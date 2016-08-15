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
        <@common.allCSS></@common.allCSS>
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
                    <div class="box-body my-item-ul">

                            <#if page.data?? && (page.data?size>0)>
                            <ul>
                                <#list page.data as shop>
                                    <li>
                                        <div class="box">
                                            <div class="box-body">
                                                <img src="${shop.picUrl}">
                                            </div>
                                            <div class="box-footer"> ${shop.name}
                                            </div>
                                            <div class="box-footer exec">
                                                <button class="btn btn-box-tool" data-widget="collapse">删除</button>
                                                <button class="btn btn-box-tool" data-widget="collapse"
                                                        onclick="edit('${shop.id}');">修改
                                                </button>
                                                <button class="btn btn-box-tool" data-widget="collapse"
                                                        onclick="view('${shop.id}')">查看
                                                </button>
                                            </div>
                                        </div>
                                    </li>
                                </#list>
                            </ul>
                             <#else>
                                    <span style="    text-align: center;width: 100%;line-height: 40px;display: inline-block;">
                                    没有数据
                                     </span>
                            </#if>

                    </div>
                    <div class="box-footer">
                        <ul id="page" class="pagination"></ul>
                    </div>
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
    <@common.bootPageJS></@common.bootPageJS>
    <@baseJS.pageOption totalPages="${page.totalPage}"></@baseJS.pageOption>
<script type="application/javascript">
    var index = 0;
    $(document).ready(function () {
        $('#page').bootstrapPaginator(options);
    });


    function refresh() {
//        table.ajax.reload();
        layer.close(index);
    }
</script>
    <@baseJS.adminAddJS url="${base}/shop/new.htm" title="新增店铺" width="100%" height="100%"></@baseJS.adminAddJS>
</body>
</html>
</#escape>