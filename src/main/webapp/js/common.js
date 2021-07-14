var ctx = '/demo'

function logout() {
window.sessionStorage.removeItem('token')
    window.location.href='index.html'
}

function show(url) {
    $('#main').load(url)
}

var loadingIndex

function doAjax(url, type, data, datatype, success) {
    $.ajax({
        url: ctx + url,
        type: type,
        data: data,
        datatype: datatype,
        beforeSend: function () {
            loadingIndex = layer.msg('加载中', {
                icon: 16,
                shade: 0.01
            })
        },
        complete: function () {
            layer.close(loadingIndex)
        },
        success: success,
        // 自定义请求头
        headers: {'Authorization': window.sessionStorage.getItem('token')}
    })
}

var Ajax = {
    get: function (url, data, success) {
        doAjax(url, 'get', data, 'json', success)
    },
    post: function (url, data, success) {
        doAjax(url, 'post', data, 'json', success)
    },
    put: function (url, data, success) {
        doAjax(url, 'put', data, 'json', success)
    },
    delete: function (url, data, success) {
        doAjax(url, 'delete', data, 'json', success)
    },
    getHtml: function (url, success) {
        doAjax(url, 'get', null, 'html', success)
    }
}

function showPage2(options) {
    // var currentPage;
    // var pageSize = 2;
    // var url;
    // var templateId;
    // var contentId;
    Ajax.get(
        options.url,
        {
            currentPage: options.currentPage,
            pageSize: options.pageSize
        },
        function (result) {
            if (result.code == 500) {
                alert(result.msg)
            } else if (result.code == 401) {
                alert(result.msg)
                document.location.href = 'index.html'
            } else {
                // 查询到的数据通过art模板,添加到页面的指定位置
                var str = template(options.templateId, result)
                document.getElementById(options.contentId).innerHTML = str
                // 分页
                // 总页数
                var totalPages = Math.ceil(result.total / options.pageSize)
                // 分页插件提供的方法
                $('#page').bootstrapPaginator({
                    bootstrapMajorVersion: 3,
                    currentPage: options.currentPage,
                    numberOfPages: 5,
                    totalPages: totalPages,
                    shouldShowPage: true,
                    onPageClicked: function (event, originalEvent, type, nowPage) {
                        showPage({
                            currentPage: nowPage,
                            pageSize: options.pageSize,
                            url: options.url,
                            templateId: options.templateId,
                            contentId: options.contentId
                        })
                    }
                })
            }
        }
    )
}

function doResult(result, success) {
    if (result.code == 500) {
        alert(result.msg)
    } else if (result.code == 401) {
        alert(result.msg)
        document.location.href = 'index.html'
    } else {
        success();
    }
}

function showPage(options) {
    Ajax.get(
        options.url,
        {
            currentPage: options.currentPage,
            pageSize: options.pageSize
        },
        function (result) {
            doResult(result, function () {
                // 查询到的数据通过art模板,添加到页面的指定位置
                var str = template(options.templateId, result)
                document.getElementById(options.contentId).innerHTML = str
                // 分页
                // 总页数
                var totalPages = Math.ceil(result.total / options.pageSize)
                // 分页插件提供的方法
                console.log($('#page'))
                console.log($('#page').prop("id"))
                $('#page').bootstrapPaginator({
                    bootstrapMajorVersion: 3,
                    currentPage: options.currentPage,
                    numberOfPages: 5,
                    totalPages: totalPages,
                    shouldShowPage: true,
                    onPageClicked: function (event, originalEvent, type, nowPage) {
                        showPage({
                            currentPage: nowPage,
                            pageSize: options.pageSize,
                            url: options.url,
                            templateId: options.templateId,
                            contentId: options.contentId
                        })
                    }
                })
            })
        }
    )
}


