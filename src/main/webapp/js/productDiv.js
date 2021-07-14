var rowIndex;
function sum(obj){
	var unitPrice = $(obj).parents("tr").find("input[name='unitPrice']").val();
	var num = $(obj).parents("tr").find("input[name='num']").val();
	var itemPrice = $(obj).parents("tr").find("input[name='itemPrice']");
	itemPrice.val(unitPrice*num);
	addPrice();
}

function addPrice() {
	var sum = 0;
	// var tipFee = $("input[name='tipFee']").val();
	var itemPrices = document.getElementsByName("itemPrice");
	for (var i=0;i<itemPrices.length;i++){
		sum+=parseFloat(itemPrices[i].value);
	}
	if (!isNaN(parseFloat(tipFee))){
		$("input[id='productTotal']").val(parseFloat(sum));
	} else {
		$("input[id='productTotal']").val(parseFloat(sum));
	}
}






function addItem(){
	var tr = $('<tr></tr>');
	$('#detailTable').append(tr);
	tr.append('<td>'+tr.index()+'</td>'
		+'<td><input type="text" name="productCode" class="poinput" readonly /> <input type="button" value="添加" style="height: 30px" class="point" onclick="choiceSpxx(this)" /></td>'
		+'<td><input type="text" name="name" class="poinput" readonly /></td>'
		+'<td><input type="text" name="unitName" class="poinput" readonly /></td>'
		+'<td><input type="text" name="unitPrice" class="poinput" readonly/></td>'
		+'<td><input type="text" name="num" onkeyup="sum(this)" class="poinput" /></td>'
		+'<td><input type="text" name="itemPrice" class="poinput"/></td>'
		+'<td><input type="button" value="删除" class="point" onclick="delItem(this)" style="height: 30px"/></td>'
	);
}

//删除行,注意这里的行号全部要重新计算 刷新的
function delItem(delImg) {
	var tr = $(delImg).parents('tr');
	var index = tr.index()-1;// 获得删除行的前一行的索引
	tr.remove();
	// 修改删除的行后面行的序号
	$('#detailTable tr:gt('+index+')').each(function(){
		$(this).find('td:first').text($(this).index());
	});
	addPrice();
}

// 选择产品
function choiceSpxx(img){
	rowIndex = $(img).parents('tr').index();// 选择行的索引
	showDiv();
	$('#spxxTable [name=choice]').prop('checked',false);
}

function hiddenDiv() {
	$('#poDiv').show();
	$('#productDiv').hide();
	
}
function showDiv(){
	$('#poDiv').hide();
	$('#productDiv').show();
}

function sure(){
	var check = $('#spxxTable [name=choice]:checked');
	if(check.length==0){
		alert('请先选择产品');
		return;
	}
	var tr = check.parents('tr');
	tr.find('td:gt(0)').each(function(i){
		$('#detailTable tr:eq('+rowIndex+')').find('td:eq('+(i+1)+') :text').val($(this).text());
	});
	hiddenDiv();
	
}

function savePomain(){
	$('#pomainForm').submit();
}