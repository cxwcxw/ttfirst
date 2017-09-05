<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>


<table id="table"></table>


<script>
    var toolbar = [{
        iconCls: 'icon-add',
        text: '新增',
        handler: function () {
            console.log('add');
        }
    }, {
        iconCls: 'icon-remove',
        text: '删除',
        handler: function () {
            var rows = $('#table').datagrid('getSelections');
            console.log(rows);
            //未选中任何记录时
            if (rows.length == 0) {
                $.messager.alert('消息', '未选中任何记录', 'info');
                return;
            }
            //选中记录的时候
            $.messager.confirm('确认', '您确认想要删除记录吗？', function (r) {
                if (r) {
                    var ids = [];
                    for (var i = 0; i < rows.length; i++) {
                        ids.push(rows[i].id);
                    }
                    $.ajax({
                        url: "items/batch",
                        type: "post",
                        data: {"ids[]": ids},
                        success: function (data) {
                                $('#table').datagrid('reload')
                        },
                        dataType: "json"
                    });
                }
            })
        }
    }, {
        iconCls: 'icon-edit',
        text: '编辑',
        handler: function () {
            console.log('edit');
        }
    }, {
        iconCls: 'icon-up',
        text: '上架',
        handler: function () {
            var rows = $('#table').datagrid('getSelections');
            console.log(rows);
            //未选中任何记录时
            if (rows.length == 0) {
                $.messager.alert('消息', '未选中任何记录', 'info');
                return;
            }
            //选中记录的时候
            $.messager.confirm('确认', '您确认想要上架商品吗？', function (r) {
                if (r) {
                    var ids = [];
                    for (var i = 0; i < rows.length; i++) {
                        ids.push(rows[i].id);
                    }
                    $.ajax({
                        url: "items/up",
                        type: "post",
                        data: {"ids[]": ids},
                        success: function (data) {
                            if (data > 0) {
                                $('#table').datagrid('reload');
                            }
                        },
                        dataType: "json"
                    });
                }
            })
        }
    }, {
        iconCls: 'icon-down',
        text: '下架',
        handler: function () {
            var rows = $('#table').datagrid('getSelections');
            console.log(rows);
            //未选中任何记录时
            if (rows.length == 0) {
                $.messager.alert('消息', '未选中任何记录', 'info');
                return;
            }
            //选中记录的时候
            $.messager.confirm('确认', '您确认想要下架商品吗？', function (r) {
                if (r) {
                    var ids = [];
                    for (var i = 0; i < rows.length; i++) {
                        ids.push(rows[i].id);
                    }
                    $.ajax({
                        url: "items/down",
                        type: "post",
                        data: {"ids[]": ids},
                        success: function (data) {
                            if (data > 0) {
                                $('#table').datagrid('reload');
                            }
                        },
                        dataType: "json"
                    });
                }
            })
        }
    }];

    $('#table').datagrid({
        //这里使用的是RESTful的URL，动态获取使用的是items
        url: 'items',
        //默认是post类型的请求
        method: "get",
        toolbar: toolbar,
        pagination: true,
        fit: true,
        columns: [[
            {field: 'ck', checkbox: true},
            {field: 'id', title: '商品ID'},
            {field: 'catName', title: '商品类型'},
            {field: 'title', title: '商品名称'},
            {field: 'sellPoint', title: '卖点'},
            {field: 'statusName', title: '商品状态'}

        ]]
    });
</script>
