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
        <@template.aside flag="item"></@template.aside>
    </aside>
    <div class="content-wrapper">
        <@template.content>
            <div class="content">
                <div class="box">
                    <div class="box-header">
                        <a href="javascript:add();" class="button button-action button-rounded">
                            <li class="fa fa-plus"></li>
                            新增商品</a>
                    </div>
                    <div class="box-body my-item-ul">
                        <ul>
                            <#list pages.data as item>
                                <li>
                                    <div class="box">
                                        <div class="box-body">
                                            <img src="${item.phonePicUrl}">
                                        </div>
                                        <div class="box-footer"> ${item.title}

                                        </div>
                                        <div class="box-footer exec">
                                            <button class="btn btn-box-tool" data-widget="collapse">删除</button>
                                            <button class="btn btn-box-tool" data-widget="collapse">修改</button>
                                            <button class="btn btn-box-tool" data-widget="collapse">查看</button>
                                        </div>
                                    </div>
                                </li>
                            </#list>
                        </ul>
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
    <@common.bootPageJS></@common.bootPageJS>
    <@common.myJS></@common.myJS>
    <@baseJS.pageOption totalPages="${pages.totalPage}"></@baseJS.pageOption>

<script type="application/javascript">
    var table = null;
    var index = 0;
    $(document).ready(function () {
    <#--$.fn.bootstrapDropdownHover();-->
        $('#page').bootstrapPaginator(options);
    });
    function refresh() {
        table.ajax.reload();
        layer.close(index);
    }

    function page(newPage) {

    }

</script>
    <@baseJS.adminAddJS url="${base}/item/new.htm" title="新增商品" width="100%" height="100%"></@baseJS.adminAddJS>
</body>
</html>
</#escape>