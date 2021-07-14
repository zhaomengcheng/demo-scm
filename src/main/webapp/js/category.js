function addCategory() {
    Ajax.getHtml('/categoryAdd.html', function (html) {
        layer.open({
            type: 1,
            title: '新增产品分类',
            area: ['450px'],
            content: html,
            btn: ['确认', '取消'],
            yes: function () {
                saveCategory()
            },
            btn2: function () {
                console.log('bbbb')
            }
        })
    })
}
function saveCategory(){
    var name = $("#name").val();
    var remark=$("#remark").val();
    var data={name:name,remark:remark}
    Ajax.post("/category",data,function (result){
        doResult(result,function (){
            alert("添加成功");
            layer.closeAll();
            show('categoryList.html');
        })
    })
}
function updateCategory(obj){

    Ajax.getHtml('/categoryUpdate.html', function (html) {
        Ajax.post("/getCategory",{categoryId:obj},function (result){
            doResult(result,function () {
                $("#categoryIdupd").val(result.data.categoryId);
                $("#nameupd").val(result.data.name);
                $("#remarkupd").val(result.data.remark);
            })
        })
        layer.open({
            type: 1,
            title: '修改产品分类',
            area: ['450px'],
            content: html,
            btn: ['确认', '取消'],
            yes: function () {
            var categoryId=$("#categoryIdupd").val();
            var name=$("#nameupd").val();
            var remark=$("#remarkupd").val();
            var data={categoryId:categoryId,name:name,remark:remark}
                Ajax.post("/category2",data,function (result){
                    doResult(result,function (){
                        alert("修改成功");
                        layer.closeAll();
                        show('categoryList.html');
                    })
                })
            },
            btn2: function () {
                console.log('bbbb')
            }
        })
    })
}
function delCategory(obj){
    var b = window.confirm("确定删除吗？");
    if (b){
        Ajax.post("/category3",{categoryId:obj},function (result){
            doResult(result,function (){
                alert("删除成功");
                layer.closeAll();
                show('categoryList.html');
            })
        })
    }
}