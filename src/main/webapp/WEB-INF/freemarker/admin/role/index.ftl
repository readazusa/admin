<#import "../../config/common.ftl"  as common>
<#import "../../template/template.ftl" as template>
<#import  "../../config/baseJS.ftl" as baseJS>
<#escape x as x?html>
<!DOCTYPE HTML>
<html>
<head lang="en">
    <@template.head title="角色管理"></@template.head>
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
        <@template.aside flag="role"></@template.aside>
    </aside>
    <div class="content-wrapper">
        <@template.content>
            <div class="content">
            <div class="box">
                <div class="box-header">
                <a href="javascript:add();" class="button button-action button-rounded"><li class="fa fa-plus"></li>新增角色</a>
            </div>
                <div class="box-body">
                    <table id="roleData" class="display" cellspacing="0" width="100%">
                        <thead>
                            <tr>
                                <th>编号</th>
                                <th>权限名称</th>
                                <th>权限编码</th>
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
            table = $('#roleData').DataTable({
               "processing":true,
                "serverSide": true,
                "ajax": "${base}/role/list.json",
                columns: [
                    { data: 'id' },
                    { data: 'name' },
                    { data: 'code' },
                    {data:"id"}
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
                    { targets: 3,  render: function (data) {
                        var html =  '<span class="button-dropdown" data-buttons="dropdown"><button class="button button-rounded button-small">选择</button>'+
                                '<ul class="button-dropdown-list is-below">'+
                                ' <li><a href="javascript:edit(\''+data+'\');"><i class="fa fa-edit"></i> 修改</a></li>'+
                                ' <li><a href="javascript:remove(\''+data+'\');"><i class="fa fa-trash-o"></i> 删除</a></li>'+
                                ' <li><a href="javascript:view(\''+data+'\');"><i class="fa fa-street-view"></i> 查看</a></li>'+
                                ' <li><a href="javascript:setResource(\''+data+'\');"><i class="fa fa-gears"></i> 赋权限</a></li>'+
                                '</ul></span>';
                        return html;
                      },
                        orderable: false
                    },
                ]
            });
            $.fn.bootstrapDropdownHover();
        } );

       function setResource(id){
           index = layer.open({
               type: 2,
               title:"赋权限",
               shadeClose: true,
               shade: 0.8,
               shift: 2,
               maxmin: true,
               area: ['50%', '50%'],
               content:"${base}/role/role_res.htm?id="+id
           });
       }
       function refresh(){
           table.ajax.reload();
           layer.close(index);
       }

</script>
    <@baseJS.adminAddJS url="${base}/role/new.htm" title="新增权限"></@baseJS.adminAddJS>
    <@baseJS.adminDeleteJS url="${base}/role/delete.json" title="删除权限"></@baseJS.adminDeleteJS>
    <@baseJS.adminEditJS url="${base}/role/edit.htm" title="修改权限"></@baseJS.adminEditJS>
    <@baseJS.adminViewJS url="${base}/role/view.htm" title="查看权限"></@baseJS.adminViewJS>
</body>
</html>
</#escape>