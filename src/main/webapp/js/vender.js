function addVender(){
    Ajax.post("/findCategoryName", {},function (result){
        doResult(result,function (){
            var myDate = new Date();
            var time = myDate.toLocaleDateString().split('/').join('-');
            $("#createDate").val(time);
        })
    })
    Ajax.getHtml('/venderAdd.html', function (html) {
        layer.open({
            type: 1,
            title: '新增产品',
            area: ['600px'],
            content: html,
            btn: ['确认', '取消'],
            yes: function () {

                saveVender()
            },
            btn2: function () {
                console.log('bbbb')
            }
        })
    })
}
function saveVender(){
    var venderCode = $("#venderCode").val();
    var name = $("#name").val();
    var password = $("#password").val();
    var contactor = $("#contactor").val();
    var address = $("#address").val();
    var postCode = $("#postCode").val();
    var tel = $("#tel").val();
    var fax = $("#fax").val();
    var createDate = $("#createDate").val();
    var data={venderCode:venderCode,name:name,password:password,contactor:contactor,address:address,postCode:postCode,tel:tel,fax:fax,createDate:createDate}
    if($("#check1").html()=="√"){
    Ajax.post("/vender",data,function (result){
        doResult(result,function (){
            alert("添加成功");
            layer.closeAll();
            show('venderList.html');
        })
    })
    }
}



function updateVender(obj){

    Ajax.post("/getVender",{venderCode:obj},function (result){
        doResult(result,function () {

            $("#venderCode").val(result.data.venderCode);
            $("#name").val(result.data.name);
            $("#password").val(result.data.password);
            $("#contactor").val(result.data.contactor);
            $("#address").val(result.data.address);
            $("#postCode").val(result.data.postCode);
            $("#tel").val(result.data.tel);
            $("#fax").val(result.data.fax);
            $("#createDate").val(result.data.createDate);
        })
    })

    Ajax.getHtml('/venderUpdate.html', function (html) {
        layer.open({
            type: 1,
            title: '修改用户',
            area: ['500px'],
            content: html,
            btn: ['确认', '取消'],
            yes: function () {

                var venderCode = $("#venderCode").val();
                var name = $("#name").val();
                var password = $("#password").val();
                var contactor = $("#contactor").val();
                var address = $("#address").val();
                var postCode = $("#postCode").val();
                var tel = $("#tel").val();
                var fax = $("#fax").val();
                var createDate = $("#createDate").val();
                var data={venderCode:venderCode,name:name,password:password,contactor:contactor,address:address,postCode:postCode,tel:tel,fax:fax,createDate:createDate}

                    Ajax.post("/vender2", data, function (result) {
                        doResult(result, function () {
                            alert("修改成功");
                            layer.closeAll();
                            show('venderList.html');
                        })
                    })

            },
            btn2: function () {
                console.log('bbbb')
            }
        })
    })
}



function checkvenderCode(){
    var venderCode=$("#venderCode").val();
    Ajax.get("/check1",{venderCode:venderCode},function (result){
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














function delVender(obj){
    var b = window.confirm("确定删除吗？");
    if (b){
        Ajax.post("/vender3",{venderCode:obj},function (result){
            doResult(result,function (){
                alert("删除成功");
                layer.closeAll();
                show('venderList.html');
            })
        })
    }
}