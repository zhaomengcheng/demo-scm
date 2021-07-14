function addProduct() {


    Ajax.getHtml('/productAdd.html', function (html) {
        Ajax.post("/findCategoryName", {},function (result){
            doResult(result,function (){
                // alert(result.data);
                var myDate = new Date();
                var time = myDate.toLocaleDateString().split('/').join('-');
                $("#createDate").val(time);
                var  list = document.getElementById("categoryName") .childNodes;
                for(var i=list.length-1;i>=0;i--)
                {list[i].remove();}
                var temp="";
                for (var i=0;i<result.data.length;i++){
                    temp+="<option>"+result.data[i]+"</option>"
                }
                $("#categoryName").append(temp);
            })
        })
        layer.open({
            type: 1,
            title: '新增产品',
            area: ['450px'],
            content: html,
            btn: ['确认', '取消'],
            yes: function () {

                saveProduct()
            },
            btn2: function () {
                console.log('bbbb')
            }
        })
    })
}
function saveProduct(){
    var productCode= $("#productCode").val();
    var name = $("#name").val();
    var unitName= $("#unitName").val();
    var categoryName= $("#categoryName").val();
    var createDate= $("#createDate").val();
    var price= $("#price").val();
    var remark=$("#remark").val();
    var data={productCode:productCode,name:name,unitName:unitName,categoryName:categoryName,createDate:createDate,price:price,remark:remark}
    if($("#check1").html()=="√"&&check2()&&check3()&&check4()&&check5()){
    Ajax.post("/product",data,function (result){
        doResult(result,function (){
            alert("添加成功");
            layer.closeAll();
            show('productList.html');
        })
    })
    }
}



function updateProduct(obj){


    Ajax.getHtml('/productUpdate.html', function (html) {
        Ajax.post("/findCategoryName", {},function (result){
            doResult(result,function (){
                // alert(result.data);

                var  list = document.getElementById("categoryName") .childNodes;
                for(var i=list.length-1;i>=0;i--)
                {list[i].remove();}
                var temp="";
                for (var i=0;i<result.data.length;i++){
                    temp+="<option>"+result.data[i]+"</option>"
                }
                $("#categoryName").append(temp);


                Ajax.post("/getProduct",{productCode:obj},function (result){
                    doResult(result,function () {

                        $("#productCode").val(result.data.productCode);
                        $("#name").val(result.data.name);
                        $("#unitName").val(result.data.unitName);
                        $("#categoryName").val(result.data.categoryName);
                        $("#createDate").val(result.data.createDate);
                        $("#price").val(result.data.price);
                        $("#remark").val(result.data.remark);
                    })
                })
            })
        })
        layer.open({
            type: 1,
            title: '修改用户',
            area: ['500px'],
            content: html,
            btn: ['确认', '取消'],
            yes: function () {

                var productCode= $("#productCode").val();
                var name = $("#name").val();
                var unitName= $("#unitName").val();
                var categoryName= $("#categoryName").val();
                var createDate= $("#createDate").val();
                var price= $("#price").val();
                var remark=$("#remark").val();
                var data={productCode:productCode,name:name,unitName:unitName,categoryName:categoryName,createDate:createDate,price:price,remark:remark}
                if(check2()&&check3()&&check4()&&check5()) {
                    Ajax.post("/product2", data, function (result) {
                        doResult(result, function () {
                            alert("修改成功");
                            layer.closeAll();
                            show('productList.html');
                        })
                    })
                }
            },
            btn2: function () {
                console.log('bbbb')
            }
        })
    })
}










function delProduct(obj){
    var b = window.confirm("确定删除吗？");
    if (b){
        Ajax.post("/product3",{productCode:obj},function (result){
            doResult(result,function (){
                alert("删除成功");
                layer.closeAll();
                show('productList.html');
            })
        })
    }
}

function check1(){
    var productCode=$("#productCode").val();
    Ajax.get("/check",{productCode:productCode},function (result){
        doResult(result,function () {
            var productCode=$("#productCode").val();
            var flag1 = /[\u4e00-\u9fa5a-zA-Z0-9\-]{4,20}/.test(productCode);
            if(result.data==0&&flag1==true){
                $("#check1").html("√") ;
                $("#check1").css("color","green")
            }else {
                $("#check1").html("×") ;
                $("#check1").css("color","red")
            }
        })
    })
}
function check2(){
    var name=$("#name").val();
    var flag1 = /[\u4e00-\u9fa5a-zA-Z0-9\-]{1,100}/.test(name);
    if(flag1){
        $("#check3").html("√") ;
        $("#check3").css("color","green")
    }else{
        $("#check3").html("×") ;
        $("#check3").css("color","red")
    }
    return flag1;
}
function check3(){
    var unitName=$("#unitName").val();
    var flag1 = /[\u4e00-\u9fa5a-zA-Z0-9\-]{1,20}/.test(unitName);
    if(flag1){
        $("#check4").html("√") ;
        $("#check4").css("color","green")
    }else{
        $("#check4").html("×") ;
        $("#check4").css("color","red")
    }
    return flag1;
}
// /^\d+(\.\d+)?$/
function check4(){
    var price=$("#price").val();
    var flag1 = /^\d+(\.\d+)?$/.test(price);
    if(flag1){
        $("#check5").html("√") ;
        $("#check5").css("color","green")
    }else{
        $("#check5").html("×") ;
        $("#check5").css("color","red")
    }
    return flag1;
}
function check5(){
    var remark=$("#remark").val();
    var flag1 = /[\u4e00-\u9fa5a-zA-Z0-9\-]{0,20}/.test(remark);
    if(flag1){
        $("#check6").html("√") ;
        $("#check6").css("color","green")
    }else{
        $("#check6").html("×") ;
        $("#check6").css("color","red")
    }
    return flag1;
}

function updateProductNum(obj){



    Ajax.getHtml('/productNumUpdate.html', function (html) {
        Ajax.post("/getProduct",{productCode:obj},function (result){
            doResult(result,function () {

                $("#productCode").val(result.data.productCode);
                $("#name").val(result.data.name);
                $("#num").val(result.data.num);

            })
        })

        layer.open({
            type: 1,
            title: '修改用户',
            area: ['500px'],
            content: html,
            btn: ['确认', '取消'],
            yes: function () {
                Ajax.post("/account", {},function (result){
                    doResult(result,function (){
                        var createUser=result.data;
                        var date = new Date();
                        var year = date.getFullYear();
                        var month = date.getMonth()+1;
                        if(month<10){
                            month="0"+month;
                        }
                        var date1 = date.getDate();
                        if(date1<10){
                            date1="0"+date1;
                        }
                        var hour = date.getHours();
                        if(hour<10){
                            hour="0"+hour;
                        }
                        var minutes = date.getMinutes();
                        if(minutes<10){
                            minutes="0"+minutes;
                        }
                        var second = date.getSeconds();
                        if(second<10){
                            second="0"+second;
                        }
                        var stockTime=year+""+month+""+date1+""+hour+""+minutes+""+second;
                        var productCode= $("#productCode").val();
                        var name = $("#name").val();
                        var originNum= $("#num").val();
                        var type=$("#type").val();
                        var cgNum=$("#cgNum").val();
                        var realNum=0;
                        if(type==3){
                            realNum=parseInt(originNum)+parseInt(cgNum);
                        }
                        if(type==4){
                            realNum=parseInt(originNum)-parseInt(cgNum);
                        }

                        data={
                            productCode:productCode,
                            originNum:originNum,
                            realNum:realNum,
                            createUser:createUser,
                            stockTime:stockTime,
                            type:type

                        }
                        Ajax.post("/updatePNum",data,function (result){
                            doResult(result,function () {
                                alert("盘点成功");
                                layer.closeAll();
                                show('productCheck.html');
                            })
                        })

                    });
                })


            },
            btn2: function () {
                console.log('bbbb')
            }
        })
    })
}


function findStockRecord(obj){
    console.log(obj);
    Ajax.getHtml('/stockRecord.html', function (html) {
        Ajax.post("/findStockRecord",{productCode:obj},function (result){
            doResult(result,function () {

                   var table=$("#StockRecordList1");
                   var t="";
                   for (let i = 0; i <result.data.length ; i++) {
                       t+="<tr>";
                       t+="<td>"+result.data[i].productCode+"</td>";
                       t+="<td>"+result.data[i].orderCode+"</td>";
                       t+="<td>"+result.data[i].stockNum+"</td>";
                       if(result.data[i].stockType=="1"){
                           t+="<td>"+"入库"+"</td>";
                       }else  if(result.data[i].stockType=="2"){
                           t+="<td>"+"出库"+"</td>";
                       }else  if(result.data[i].stockType=="3"){
                           t+="<td>"+"盘点入库"+"</td>";
                       }else  if(result.data[i].stockType=="4"){
                           t+="<td>"+"盘点出库"+"</td>";
                       }

                       t+="<td>"+result.data[i].stockTime+"</td>";
                       t+="<td>"+result.data[i].createUser+"</td>";
                       t+="</tr>";

                   }
                   table.append(t);

            })
        })

        layer.open({
            type: 1,
            title: '修改用户',
            area: ['1400px','600px'],
            content: html,
            btn: ['确认'],
            yes: function () {
                show('/productQuery.html');
            }
        })
    })
}