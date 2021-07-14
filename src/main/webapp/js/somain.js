function addSomain(){
    Ajax.getHtml('/somainAdd.html', function (html) {
        Ajax.post("/customername", {},function (result){
            doResult(result,function (){
                var  list = document.getElementById("custumerName") .childNodes;
                for(var i=list.length-1;i>=0;i--)
                {list[i].remove();}
                var temp="";
                for (var i=0;i<result.data.length;i++){
                    temp+="<option>"+result.data[i].name+"</option>"
                }
                $("#custumerName").append(temp);
                Ajax.post("/account", {},function (result){
                    doResult(result,function (){
                        $("#account").val(result.data);
                    });
                })
            })
        })
        layer.open({
            type: 1,
            title: '新增采购单',
            area: ['1400px','600px'],
            content: html,
            btn: ['确认', '取消'],
            yes: function () {

                var soId = $("input[id='soId']").val();
                var createTime = $("input[id='createTime']").val();
                var custumerName = $("select[id='custumerName']").val();
                var account = $("input[id='account']").val();
                var tipFee = $("input[id='tipFee']").val();
                if(tipFee==null||tipFee==""){
                    tipFee=0;
                }
                var productTotal = $("input[id='productTotal']").val();
                var soTotal=1*tipFee+1*productTotal;
                var payType = $("select[id='payType']").val();
                var prePayFee = $("input[id='prePayFee']").val();
                if(prePayFee==null||prePayFee==""){
                    prePayFee=0;
                }
                var status=1;
                var remark = $("input[id='remark']").val();


                var data = {
                    soId:soId,
                    createTime:createTime,
                    name:custumerName,
                    account:account,
                    tipFee:tipFee,
                    productTotal:productTotal,
                    soTotal:soTotal,
                    payType:payType,
                    prePayFee:prePayFee,
                    status:status,
                    remark:remark,
                }

                var tableRows=document.getElementById("detailTable").rows;
                console.log(tableRows);
                for (var i=1;i<tableRows.length;i++){
                    data["soItems["+(i-1)+"].soId"]=soId;
                    data["soItems["+(i-1)+"].productCode"]=tableRows[i].cells[1].firstChild.value;
                    data["soItems["+(i-1)+"].unitPrice"]=tableRows[i].cells[4].firstChild.value;
                    data["soItems["+(i-1)+"].num"]=tableRows[i].cells[5].firstChild.value;
                    data["soItems["+(i-1)+"].unitName"]=tableRows[i].cells[3].firstChild.value;
                    data["soItems["+(i-1)+"].itemPrice"]=tableRows[i].cells[6].firstChild.value;
                }
                console.log(data);
                Ajax.post("/addSoMain", data,function (result){
                    doResult(result,function (){
                        alert("添加成功");
                        layer.closeAll();
                        show('somainList.html');
                    });
                })

            },
            btn2: function () {
                console.log('aaa')
            }
        })
    })
}


function updateSomain(obj){
    Ajax.getHtml('/somainUpdate.html', function (html) {
        Ajax.post("/customername", {},function (result){
            doResult(result,function (){
                var  list = document.getElementById("custumerName") .childNodes;
                for(var i=list.length-1;i>=0;i--)
                {list[i].remove();}
                var temp="";
                for (var i=0;i<result.data.length;i++){
                    temp+="<option>"+result.data[i].name+"</option>"
                }
                $("#custumerName").append(temp);
                Ajax.post("/getSomain2", {soId:obj},function (result){
                    doResult(result,function (){
                        $("#soId").val(result.data.soId);
                        $("#createTime").val(result.data.createTime);
                        $("#custumerName").val(result.data.name);
                        $("#account").val(result.data.account);
                        $("#tipFee").val(result.data.tipFee);
                        $("#productTotal").val(result.data.productTotal);
                        $("#payType").val(result.data.payType);
                        $("#prePayFee").val(result.data.prePayFee);
                        $("#remark").val(result.data.remark);
                        console.log(result.data.soItems);
                        console.log(result.data);
                        for (var i=0;i<result.data.soItems.length;i++){
                            var tr = $('<tr></tr>');
                            $('#detailTable').append(tr);
                            tr.append('<td>'+tr.index()+'</td>'
                                +'<td><input type="text" name="productCode" class="poinput" value='+result.data.soItems[i].productCode+' readonly /></td>'
                                +'<td><input type="text" name="name" class="poinput" value='+result.data.soItems[i].productName+' readonly /></td>'
                                +'<td><input type="text" name="unitName" class="poinput" value='+result.data.soItems[i].unitName+' readonly /></td>'
                                +'<td><input type="text" name="unitPrice" class="poinput" value='+result.data.soItems[i].unitPrice+' readonly/></td>'
                                +'<td><input type="text" name="num" onkeyup="sum(this)"  value='+result.data.soItems[i].num+' class="poinput"   /></td>'
                                +'<td><input type="text" name="itemPrice" value='+result.data.soItems[i].itemPrice+'  class="poinput" /></td>'
                                +'<td><input type="button" value="删除" class="point" onclick="delItem(this)" style="height: 30px"/></td>');
                            // document.getElementsByName("productCode").value=result.data.soItems[i].productCode;

                        }

                    });
                })
            })
        })
        layer.open({
            type: 1,
            title: '修改采购单',
            area: ['1400px','600px'],
            content: html,
            btn: ['确认', '取消'],
            yes: function () {

                var soId = $("input[id='soId']").val();
                var createTime = $("input[id='createTime']").val();
                var custumerName = $("select[id='custumerName']").val();
                var account = $("input[id='account']").val();
                var tipFee = $("input[id='tipFee']").val();
                if(tipFee==null||tipFee==""){
                    tipFee=0;
                }
                var productTotal = $("input[id='productTotal']").val();
                var soTotal=1*tipFee+1*productTotal;
                var payType = $("select[id='payType']").val();
                var prePayFee = $("input[id='prePayFee']").val();
                if(prePayFee==null||prePayFee==""){
                    prePayFee=0;
                }
                var status=1;
                var remark = $("input[id='remark']").val();


                var data = {
                    soId:soId,
                    createTime:createTime,
                    name:custumerName,
                    account:account,
                    tipFee:tipFee,
                    productTotal:productTotal,
                    soTotal:soTotal,
                    payType:payType,
                    prePayFee:prePayFee,
                    status:status,
                    remark:remark,
                }

                var tableRows=document.getElementById("detailTable").rows;
                console.log(tableRows);
                for (var i=1;i<tableRows.length;i++){
                    data["soItems["+(i-1)+"].soId"]=soId;
                    data["soItems["+(i-1)+"].productCode"]=tableRows[i].cells[1].firstChild.value;
                    data["soItems["+(i-1)+"].unitPrice"]=tableRows[i].cells[4].firstChild.value;
                    data["soItems["+(i-1)+"].num"]=tableRows[i].cells[5].firstChild.value;
                    data["soItems["+(i-1)+"].unitName"]=tableRows[i].cells[3].firstChild.value;
                    data["soItems["+(i-1)+"].itemPrice"]=tableRows[i].cells[6].firstChild.value;
                }
                console.log(data);
                Ajax.post("/somains3",{soId:soId},function (result){
                    doResult(result,function (){

                        layer.closeAll();
                        show('somainList.html');
                    })
                })


                Ajax.post("/addSoMain", data,function (result){
                    doResult(result,function (){
                        alert("修改成功");
                        layer.closeAll();
                        show('somainList.html');
                    });
                })

            },
            btn2: function () {
                console.log('aaa')
            }
        })
    })
}








function delSomain(obj){
    var b = window.confirm("确定删除吗？");
    if (b){
        Ajax.post("/somains3",{soId:obj},function (result){
            doResult(result,function (){
                alert("删除成功");
                layer.closeAll();
                show('somainList.html');
            })
        })
    }
}


function outSomain(obj){
    var b = window.confirm("确定出库吗？");
    if (b){
        Ajax.post("/account", {},function (result){
            doResult(result,function (){
                var stockUser=result.data;
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
                var stockTime=year+"-"+month+"-"+date1+" "+hour+":"+minutes+":"+second;
                Ajax.post("/outSomain",{soId:obj,stockUser:stockUser,stockTime:stockTime},function (result){
                    doResult(result,function (){
                        alert("出库成功");
                        layer.closeAll();
                        show('somainOut1.html');
                    })
                })
            });
        })

    }
}




function endSomain(obj){
    var b = window.confirm("确定了结吗？");
    if (b){
        Ajax.post("/account", {},function (result){
            doResult(result,function (){
                var endUser=result.data;
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
                var endTime=year+"-"+month+"-"+date1;
                Ajax.post("/endSomain",{soId:obj,endUser:endUser,endTime:endTime},function (result){
                    doResult(result,function (){
                        alert("了结成功");
                        layer.closeAll();
                        show('somainEnd1.html');
                    })
                })
            });
        })

    }
}
function inMoneySomain(obj){
    var b = window.confirm("确定收款吗？");
    if (b){
        Ajax.post("/account", {},function (result){
            doResult(result,function (){
                var payUser=result.data;
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
                var payTime=year+"-"+month+"-"+date1;
                Ajax.post("/inMoneySomain",{soId:obj,payUser:payUser,payTime:payTime},function (result){
                    doResult(result,function (){
                        alert("收款成功");
                        layer.closeAll();
                        show('inMoney1.html');
                    })
                })
            });
        })

    }
}
function inMoneySomain2(obj){
    var b = window.confirm("确定收预付款吗？");
    if (b){
        Ajax.post("/account", {},function (result){
            doResult(result,function (){
                var payUser=result.data;
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
                var payTime=year+"-"+month+"-"+date1;
                Ajax.post("/inMoneySomain2",{soId:obj,payUser:payUser,payTime:payTime},function (result){
                    doResult(result,function (){
                        alert("收款成功");
                        layer.closeAll();
                        show('inMoney1.html');
                    })
                })
            });
        })

    }
}



function GoSomain(obj){
    console.log(obj.innerText);
    if(obj.innerText=="货到付款"){
        show('somainEnd1.html');
    }
    if(obj.innerText=="款到发货"){
        show('somainEnd2.html');
    }
    if(obj.innerText=="预付款发货"){
        show('somainEnd3.html');
    }
}
function GoOut(obj){
    console.log(obj.innerText);
    if(obj.innerText=="货到付款"){
        show('somainOut1.html');
    }
    if(obj.innerText=="款到发货"){
        show('somainOut2.html');
    }
    if(obj.innerText=="预付款发货"){
        show('somainOut3.html');
    }
}
function GoInMoney(obj){
    console.log(obj.innerText);
    if(obj.innerText=="货到付款"){
        show('inMoney1.html');
    }
    if(obj.innerText=="款到发货"){
        show('inMoney2.html');
    }
    if(obj.innerText=="预付款发货"){
        show('inMoney3.html');
    }
}