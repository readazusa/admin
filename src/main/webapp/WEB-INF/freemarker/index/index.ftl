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
</head>
<body class="skin-green-light sidebar-mini">
<div class="wrapper">
    <header class="main-header">
        <@template.header></@template.header>
    </header>
    <aside class="main-sidebar">
        <@template.aside flag="${flag}"></@template.aside>
    </aside>
    <div class="content-wrapper">
        <@template.content>
            <div class="content">
            <div class="box">
                <div class="box-header">
                    <a href="javascript:add();" class="button button-action button-rounded"><li class="fa fa-plus"></li>新增首页元素</a>
                </div>
                <div class="box-body">
                    <table id="tradeData" class="display" cellspacing="0" width="100%">
                        <thead>
                        <tr>
                            <th>首页类型</th>
                            <th>图片URL</th>
                            <th>图片内容</th>
                            <th>是否显示</th>
                            <th>主题</th>
                            <th>创建时间</th>
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
            table = $('#tradeData').DataTable({
               "processing":true,
                "serverSide": true,
                <#--"ajax": {-->
                    <#--"url"："${base}/index/list.json",-->
                    <#--"data":{"type":${type}}-->
                <#--},-->
                "ajax":"${base}/index/list.json?type=${type}",
                columns: [
                    { data: 'type' },
                    { data: 'picUrl' },
                    { data: 'contentUrl' },
                    { data: 'isShow' },
                    {data:'title'},
                    {data:'createTime'},
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
                    { targets: 6,  render: function (data) {
                        var html =  '<span class="button-dropdown" data-buttons="dropdown"><button class="button button-rounded button-small">选择</button>'+
                                '<ul class="button-dropdown-list is-below">'+
                                ' <li><a href="javascript:edit(\''+data+'\');"><i class="fa fa-edit"></i> 修改</a></li>'+
                                ' <li><a href="javascript:view(\''+data+'\');"><i class="fa fa-street-view"></i> 查看</a></li>'+
                                ' <li><a href="javascript:remove(\''+data+'\');"><i class="fa fa-street-view"></i> 删除</a></li>'+
                                '</ul></span>';
                        return html;
                      },
                        orderable: false
                    },{
                        targets:0,render:function(type){
                            var result = "";
                            if("0" ==type){
                                result = "主页头部滚动条"
                            }else if("1" == type){
                                result="中部广告";
                            }else{
                                result = "中部大图片";
                            }
                            return result;
                        }
                    },{
                        targets:3,render:function(isshow){
                            var result = "";
                            if("0" ==isshow){
                                result = "显示"
                            } else{
                                result = "隐藏";
                            }
                            return result;
                        }
                    }
                ]
            });
            $.fn.bootstrapDropdownHover();
        } );

       function refresh(){
           table.ajax.reload();
           layer.close(index);
       }

</script>
    <@baseJS.adminAddJS url="${base}/index/new.htm?type=${type}" height="100%" width="100%"></@baseJS.adminAddJS>
    <@baseJS.adminEditJS url="${base}/index/edit.htm"  height="100%" width="100%"></@baseJS.adminEditJS>
    <@baseJS.adminViewJS url="${base}/index/view.htm"  height="100%" width="100%"></@baseJS.adminViewJS>
    <@baseJS.adminDeleteJS url="${base}/index/delete.json"></@baseJS.adminDeleteJS>
</body>
</html>
</#escape>