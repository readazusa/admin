<#import "../config/common.ftl"  as common>
<#import "../template/template.ftl" as template>
<#import  "../config/baseJS.ftl" as baseJS>
<#escape x as x?html>
<!DOCTYPE HTML>
<html>
<head lang="en">
    <@template.head title="店铺管理"></@template.head>
        <@common.bootCSS></@common.bootCSS>
        <@common.adminCSS></@common.adminCSS>
        <@common.jquery></@common.jquery>
        <@common.dataTableCSS></@common.dataTableCSS>
        <@common.layerCSS></@common.layerCSS>
        <#--<@common.bootDropdownCSS></@common.bootDropdownCSS>-->
        <#--<@common.bootSelectCSS></@common.bootSelectCSS>-->
</head>
<body class="skin-green-light sidebar-mini">
<div class="wrapper">
    <header class="main-header">
        <@template.header></@template.header>
    </header>
    <aside class="main-sidebar">
        <@template.aside flag="shop"></@template.aside>
    </aside>
    <div class="content-wrapper">
        <@template.content>
            <div class="content">
                <div class="box">
                    <div class="box-header">
                        <a href="javascript:add();" class="button button-action button-rounded">
                            <li class="fa fa-plus"></li>
                            新增店铺</a>
                    </div>
                    <div class="box-body">
                        <table id="shopData" class="display" cellspacing="0" width="100%">
                            <thead>
                            <tr>
                                <th>商品编号</th>
                                <th>商品标题</th>
                                <th>创建时间</th>
                                <th>照片</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                        </table>
                    </div>
                    <div class="box-footer"></div>
                </div>
            </div>
        </@template.content>
    </div>
    <@template.footer></@template.footer>
</div>
    <@common.bootJS></@common.bootJS>
    <@common.adminJS></@common.adminJS>
    <@common.dataTableJS></@common.dataTableJS>
    <@common.layerJS></@common.layerJS>
    <@common.validateJS></@common.validateJS>
    <@common.bootDropdownJS></@common.bootDropdownJS>
    <@common.bootSelectJS></@common.bootSelectJS>
<script type="application/javascript">
    var table = null;
    var index = 0;
    $(document).ready(function () {
        table = $('#shopData').DataTable({
            "processing": true,
            "serverSide": true,
            "ajax": "${base}/shop/list.json",
            columns: [
                {data: 'id'},
                {data: 'name'},
                {data: 'phoneNum'},
                {data: 'createTime'},
                {data: "id"}
            ],
            "language": {
                "lengthMenu": "每页 _MENU_ 条记录",
                "zeroRecords": "没有找到记录",
                "info": "第 _PAGE_ 页 ( 总共 _PAGES_ 页 , _TOTAL_ 条 )",
                "infoEmpty": "无记录",
                search: "搜索:",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "上页",
                    "sNext": "下页",
                    "sLast": "末页"
                }
            },
            columnDefs: [
                {
                    targets: 4, render: function (data) {
                    var html = '<span class="button-dropdown" data-buttons="dropdown"><button class="button button-rounded button-small">选择</button>' +
                            '<ul class="button-dropdown-list is-below">' +
                            ' <li><a href="javascript:edit(\'' + data + '\');"><i class="fa fa-edit"></i> 修改</a></li>' +
                            '</ul></span>';
                    return html;
                },
                    orderable: false
                },
            ]
        });
        $.fn.bootstrapDropdownHover();
    });

    function refresh() {
        table.ajax.reload();
        layer.close(index);
    }
</script>
    <@baseJS.adminAddJS url="${base}/shop/new.htm" title="新增店铺" width="100%" height="100%"></@baseJS.adminAddJS>
</body>
</html>
</#escape>