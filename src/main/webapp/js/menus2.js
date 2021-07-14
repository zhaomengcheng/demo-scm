var menuData = {
    items: [
        {
            name: '管理信息',
            children: {
                list: [
                    { name: '首页', url: 'first.html' },
                    { name: '用户管理', url: 'userList.html' },
                ]
            }
        },
        {
            name: '产品管理',
            children: {
                list: [
                    { name: '产品分类列表', url: 'categoryList.html' },
                    { name: '产品列表', url: 'productList.html' }
                ]
            }
        },
        {
            name: '采购管理',
            children: {
                list: [{ name: '供应商管理', url: 'venderList.html' },
                    { name: '新添采购单', url: 'pomainList.html' },
                    { name: '采购单了结', url: 'pomainEnd1.html' },
                    { name: '采购单查询', url: 'pomainQuery.html' }
                ]
            }
        },
        {
            name: '库存管理',
            children: {
                list: [{ name: '入库登记', url: 'pomainIn1.html' },
                    { name: '出库登记', url: 'somainOut1.html' },
                    { name: '库存查询', url: 'productQuery.html' },
                    { name: '库存盘点', url: 'productCheck.html' }
                ]
            }
        },
        {
            name: '销售管理',
            children: {
                list: [{ name: '客户管理', url: 'customerList.html' },
                    { name: '新添销售单', url: 'somainList.html' },
                    { name: '销售单了结', url: 'somainEnd1.html' },
                    { name: '销售单查询', url: 'somainQuery.html' }
                ]
            }
        },
        {
            name: '财务收支',
            children: {
                list: [{ name: '收款登记', url: 'inMoney1.html' },
                    { name: '付款登记', url: 'outMoney1.html' },
                    { name: '收支查询', url: 'payRecordQuery.html' }
                ]
            }
        },
        {
            name: '月度报表',
            children: {
                list: [{ name: '月度采购报表', url: 'PomainReport.html' },
                    { name: '月度销售报表', url: 'SomainReport.html' },
                    { name: '月度出库报表', url: 'InStockReport.html' },
                    { name: '月度入库报表', url: 'OutStockReport.html' },
                    { name: '月度库存报表', url: 'StockReport.html' },
                    { name: '月度收支报表', url: 'PayReport.html' }
                ]
            }
        }
    ]
}
