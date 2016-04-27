<#import "../config/common.ftl"  as common>
<#import "../template/template.ftl" as template>
<#import  "../config/baseJS.ftl" as baseJS>
<#escape x as x?html>
<!DOCTYPE HTML>
<html>
<head lang="en">
    <@template.head title="商品管理"></@template.head>
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
        <@template.aside flag="item"></@template.aside>
    </aside>
    <div class="content-wrapper">
        <@template.content>
            <div class="content">
                <div class="box">
                    <div class="box-header">
                        <a href="javascript:add();" class="button button-action button-rounded"><li class="fa fa-plus"></li>新增商品</a>
                    </div>
                    <div class="box-body">
                        <table id="userData" class="display" cellspacing="0" width="100%">
                            <thead>
                            <tr>
                                <th>商品编号</th>
                                <th>商品标题</th>
                                <th>价格</th>
                                <th>库存</th>
                                <th>产地</th>
                                <th>打折后价格</th>
                                <th>上架时间</th>
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
        $(document).ready(function() {
            table = $('#userData').DataTable({
               "processing":true,
                "serverSide": true,
                "ajax": "${base}/item/list.json",
                columns: [
                    { data: 'uid' },
                    { data: 'title' },
                    { data: 'price' },
                    { data: 'stock' },
                    {data:'discountPrice'},
                    {data:'idCard'},
                    {data:'createTime'},
                    {data:"uid"}
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
                    { targets: 7,  render: function (data) {
                        var html =  '<span class="button-dropdown" data-buttons="dropdown"><button class="button button-rounded button-small">选择</button>'+
                                '<ul class="button-dropdown-list is-below">'+
                                ' <li><a href="javascript:edit(\''+data+'\');"><i class="fa fa-edit"></i> 修改</a></li>'+
                                '</ul></span>';
                        return html;
                      },
                        orderable: false
                    },
                ]
            });
            $.fn.bootstrapDropdownHover();
        } );

        function setRole(id){
            index = layer.open({
                type: 2,
                title:"赋角色",
                shadeClose: true,
                shade: 0.8,
                shift: 2,
                maxmin: true,
                area: ['50%', '50%'],
                content:"${base}/user/user_role.htm?id="+id
            });
        }

       function refresh(){
           table.ajax.reload();
           layer.close(index);
       }

</script>
    <@baseJS.adminAddJS url="${base}/item/new.htm" title="新增商品"></@baseJS.adminAddJS>
</body>
</html>
</#escape>