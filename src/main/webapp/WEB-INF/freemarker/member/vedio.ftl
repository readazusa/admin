<#import "../config/common.ftl"  as common>
<#import "../template/template.ftl" as template>
<#import  "../config/baseJS.ftl" as baseJS>
<#escape x as x?html>
<!DOCTYPE HTML>
<html>
<head lang="en">
    <@template.head title="会员管理"></@template.head>
        <@common.jquery></@common.jquery>
        <@common.bootCSS></@common.bootCSS>
        <@common.adminCSS></@common.adminCSS>
        <@common.dataTableCSS></@common.dataTableCSS>
        <@common.layerCSS></@common.layerCSS>
        <@common.bootDropdownCSS></@common.bootDropdownCSS>
        <@common.bootSelectCSS></@common.bootSelectCSS>
        <@common.allCSS></@common.allCSS>
</head>
<body class="skin-green-light sidebar-mini">
<div class="wrapper">
    <header class="main-header">
        <@template.header></@template.header>
    </header>
    <aside class="main-sidebar">
        <@template.aside flag="member"></@template.aside>
    </aside>
    <div class="content-wrapper">
        <@template.content>
            <div class="content">
                <div class="box">
                    <div class="box-header">
                    <#--<a href="javascript:add();" class="button button-action button-rounded"><li class="fa fa-plus"></li>新增角色</a>-->
                    </div>
                    <div class="box-body" id="container">
                        <embed src="http://player.youku.com/player.php/Type/Folder/Fid/6525054/Ob/1/Pt/0/sid/XMjkwNTU5NTYw/v.swf"
                               quality="high" width="480" height="400" align="middle" allowScriptAccess="always" allowFullScreen="true" mode="transparent"
                               type="application/x-shockwave-flash"></embed>
                        <#--<video controls="controls"  width="640" height="360">-->
                    <#--<source src="${base}/api/download/file" type="video/mp4" />-->
                    <#--&lt;#&ndash;<source src="http://www.html5videoplayer.net/videos/toystory.ogv" type="video/ogg" />&ndash;&gt;-->
                    <#--&lt;#&ndash;<source src="http://www.html5videoplayer.net/videos/toystory.webm" type="video/webm" />&ndash;&gt;-->
                    <#--</video>-->
                    </div>
                    <#--<div class="box-footer">-->
                        <#--<div id="navigation" align="center">-->
                            <#--<a href="${base}/member/page.htm?page=1"></a>-->
                        <#--</div>-->
                    <#--</div>-->
                </div>
            </div>
        </@template.content>
    </div>
    <@template.footer></@template.footer>
</div>
    <@common.bootJS></@common.bootJS>
    <@common.adminJS></@common.adminJS>
    <@common.infinitescroll></@common.infinitescroll>
<script type="application/javascript">
    $(function () {

    });
</script>
    <@baseJS.adminViewJS url="${base}/role/view.htm" title="查看权限"></@baseJS.adminViewJS>
</body>
</html>
</#escape>