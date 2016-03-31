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
                        <div class="info-box bg-red">
                            <span class="info-box-icon"><i class="fa fa-comments-o"></i></span>

                            <div class="info-box-content">
                                <span class="info-box-text">Likes</span>
                                <span class="info-box-number">41,410</span>

                                <div class="progress">
                                    <div class="progress-bar" style="width: 70%"></div>
                                </div>
                                    <span class="progress-description">
                                      70% Increase in 30 Days
                                    </span>
                            </div>
                        </div>
                        <div class="info-box bg-red">
                            <span class="info-box-icon"><i class="fa fa-comments-o"></i></span>

                            <div class="info-box-content">
                                <span class="info-box-text">Likes</span>
                                <span class="info-box-number">41,410</span>

                                <div class="progress">
                                    <div class="progress-bar" style="width: 70%"></div>
                                </div>
                                    <span class="progress-description">
                                      70% Increase in 30 Days
                                    </span>
                            </div>
                        </div>
                        <div class="info-box bg-red">
                            <span class="info-box-icon"><i class="fa fa-comments-o"></i></span>

                            <div class="info-box-content">
                                <span class="info-box-text">Likes</span>
                                <span class="info-box-number">41,410</span>

                                <div class="progress">
                                    <div class="progress-bar" style="width: 70%"></div>
                                </div>
                                    <span class="progress-description">
                                      70% Increase in 30 Days
                                    </span>
                            </div>
                        </div>
                        <div class="info-box bg-red">
                            <span class="info-box-icon"><i class="fa fa-comments-o"></i></span>

                            <div class="info-box-content">
                                <span class="info-box-text">Likes</span>
                                <span class="info-box-number">41,410</span>

                                <div class="progress">
                                    <div class="progress-bar" style="width: 70%"></div>
                                </div>
                                    <span class="progress-description">
                                      70% Increase in 30 Days
                                    </span>
                            </div>
                        </div>
                        <div class="info-box bg-red">
                            <span class="info-box-icon"><i class="fa fa-comments-o"></i></span>

                            <div class="info-box-content">
                                <span class="info-box-text">Likes</span>
                                <span class="info-box-number">41,410</span>

                                <div class="progress">
                                    <div class="progress-bar" style="width: 70%"></div>
                                </div>
                                    <span class="progress-description">
                                      70% Increase in 30 Days
                                    </span>
                            </div>
                        </div>
                        <div class="info-box bg-red">
                            <span class="info-box-icon"><i class="fa fa-comments-o"></i></span>

                            <div class="info-box-content">
                                <span class="info-box-text">Likes</span>
                                <span class="info-box-number">41,410</span>

                                <div class="progress">
                                    <div class="progress-bar" style="width: 70%"></div>
                                </div>
                                    <span class="progress-description">
                                      70% Increase in 30 Days
                                    </span>
                            </div>
                        </div>
                        <div class="info-box bg-red">
                            <span class="info-box-icon"><i class="fa fa-comments-o"></i></span>

                            <div class="info-box-content">
                                <span class="info-box-text">Likes</span>
                                <span class="info-box-number">41,410</span>

                                <div class="progress">
                                    <div class="progress-bar" style="width: 70%"></div>
                                </div>
                                    <span class="progress-description">
                                      70% Increase in 30 Days
                                    </span>
                            </div>
                        </div>

                        <div id="navigation" align="center">
                            <a href="${base}/member/page.htm?page=1"></a>
                        </div>
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
        $("#container").infinitescroll({
                    navSelector: "#navigation",
                    nextSelector: "#navigation a",
                    itemSelector: "#container  >div",
                    dataType: "html",
                    animate: true,
                    extraScrollPx: 100,   //滚动条距离底部多少像素的时候开始加载，默认150
//                    maxPage: 13,
                    loading: {
                        finishedMsg: '没有更多内容了', //当加载失败，或者加载不出内容之后的提示语
                        msgText: '正在加载中...',    //加载时的提示语
                    },
                    errorCallback: function (resp) {
                        //    alert(JSON.stringify(resp));
                    }
                },
                function (json, opts) {
                    // alert(JSON.stringify(json))
                    var page = opts.state.currPage;
                    var isDone = opts.state.isDone;
                    console.info("page: " + page + " ,isDone: " + isDone);
                }
        );
    });
</script>
    <@baseJS.adminViewJS url="${base}/role/view.htm" title="查看权限"></@baseJS.adminViewJS>
</body>
</html>
</#escape>