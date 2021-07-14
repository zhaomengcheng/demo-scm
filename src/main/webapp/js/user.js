function addUser() {
    Ajax.getHtml('/userAdd.html', function (html) {
        layer.open({
            type: 1,
            title: '新增用户',
            area: ['450px'],
            content: html,
            btn: ['确认', '取消'],
            yes: function () {
                saveUser()
            },
            btn2: function () {
                console.log('bbbb')
            }
        })
    })
}
function saveUser() {
    var account = $("#account").val();
    var name = $("#name").val();
    var password = $("#password").val();
    var status = document.getElementsByName("status");
    var statu;
    var flag=false;
    for (var i=0;i<status.length;i++){
        if (status[i].checked){

            statu=status[i].value;
        }
    }
    var data={account:account,password:password,name:name,status:statu};
    var options = document.getElementsByName("option");
    var t=0;
    for (var i=0;i<options.length;i++){
        if (options[i].checked){
            flag = true;
            data["modelName["+t+"]"]=options[i].value;
            if(i==0){break;}
            t++;
        }
    }

    if ($("#usertip").html()=="√"&&flag&&name!=""&&password!="") {
        Ajax.post("/user",data,function (result){
            doResult(result,function (){
                alert("添加成功");
                layer.closeAll();
                show('userList.html');
            })
        })
    }
}
function updateUser(obj){

    Ajax.getHtml('/userUpdate.html', function (html) {
        Ajax.post("/getUser",{account:obj},function (result){
            doResult(result,function () {
                $("#accountupd").val(result.data.account);
                $("#passwordupd").val(result.data.password);
                $("#nameupd").val(result.data.name);
                $("#createDateupd").val(result.data.createDate);
                console.log(result.data)
                var status=document.getElementsByName("statusupd");
                if (result.data.status==1){
                    $("#isStatusupd").attr("checked",true)
                }else if (result.data.status==0){
                    $("#notStatusupd").attr("checked",true)
                }
                console.log(result.data.modelName);
                for (var i=0;i<result.data.modelName.length;i++){
                    if (result.data.modelName[i]=="admin"){
                        $("#adminupd").attr("checked",true);
                        $("#purchaseupd").attr("checked",true);
                        $("#sellupd").attr("checked",true);
                        $("#stockupd").attr("checked",true);
                        $("#financeupd").attr("checked",true);
                    }else if (result.data.modelName[i]=="purchase"){
                        $("#purchaseupd").attr("checked",true);
                    }else if (result.data.modelName[i]=="sell"){
                        $("#sellupd").attr("checked",true);
                    }else if (result.data.modelName[i]=="stock"){
                        $("#stockupd").attr("checked",true);
                    }else if (result.data.modelName[i]=="finance"){
                        $("#financeupd").attr("checked",true);
                    }
                }
            })
        })
        layer.open({
            type: 1,
            title: '修改用户',
            area: ['500px'],
            content: html,
            btn: ['确认', '取消'],
            yes: function () {

                var account = $("#accountupd").val();
                var name = $("#nameupd").val();
                var password = $("#passwordupd").val();
                var status = document.getElementsByName("statusupd");
                var statu;
                var flag=false;
                for (var i=0;i<status.length;i++){
                    if (status[i].checked){

                        statu=status[i].value;
                    }
                }
                var data={account:account,password:password,name:name,status:statu};
                var options = document.getElementsByName("optionupd");
                var t=0;
                for (var i=0;i<options.length;i++){
                    if (options[i].checked){
                        flag = true;
                        data["modelName["+t+"]"]=options[i].value;
                        t++;
                    }
                }
                console.log(data);
                // alert($("#usertip").html()=="√");
                // alert(flag);
                if (flag&&name!=""&&password!="") {
                    Ajax.post("/user2",data,function (result){
                        doResult(result,function (){
                            alert("修改成功");
                            layer.closeAll();
                            show('userList.html');
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

function delUser(obj){
    console.log(obj);
    var b = window.confirm("确定删除吗？");
    if (b){
        Ajax.post("/user3",{account:obj},function (result){
            doResult(result,function (){
                alert("删除成功");
                layer.closeAll();
                show('userList.html');
            })
        })
    }
}

