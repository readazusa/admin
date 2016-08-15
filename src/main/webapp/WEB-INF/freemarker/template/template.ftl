<#macro head title="管理主页">
<meta charset="UTF-8">
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<title>${title}</title>
</#macro>
<#macro header>
<a href="#" class="logo">
    <span class="logo-mini">SMC</span>
    <span class="logo-lg">SUNMC</span>
</a>
<nav class="navbar navbar-static-top" role="navigation">
    <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
    </a>

    <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
            <li>
                <a href="${base}/logout.htm"></a>
            </li>
            <li class="dropdown messages-menu">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <i class="fa fa-envelope-o"></i>
                    <span class="label label-success">4</span>
                </a>
                <ul class="dropdown-menu">
                    <li class="header">You have 4 messages</li>
                    <li>
                        <ul class="menu">
                            <li>
                                <a href="#">
                                    <div class="pull-left">
                                        <img src="${base}/resources/scripts/admin/img/user2-160x160.jpg"
                                             class="img-circle" alt="User Image"/>
                                    </div>
                                    <h4>
                                        Support Team
                                        <small><i class="fa fa-clock-o"></i> 5 mins</small>
                                    </h4>
                                    <p>Why not buy a new awesome theme?</p>
                                </a>
                            </li>

                            <li>
                                <a href="#">
                                    <div class="pull-left">
                                        <img src="${base}/resources/scripts/admin/img/user3-128x128.jpg"
                                             class="img-circle" alt="User Image"/>
                                    </div>
                                    <h4>
                                        AdminLTE Design Team
                                        <small><i class="fa fa-clock-o"></i> 2 hours</small>
                                    </h4>
                                    <p>Why not buy a new awesome theme?</p>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <div class="pull-left">
                                        <img src="${base}/resources/scripts/admin/img/user4-128x128.jpg"
                                             class="img-circle" alt="User Image"/>
                                    </div>
                                    <h4>
                                        Developers
                                        <small><i class="fa fa-clock-o"></i> Today</small>
                                    </h4>
                                    <p>Why not buy a new awesome theme?</p>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <div class="pull-left">
                                        <img src="${base}/resources/scripts/admin/img/user3-128x128.jpg"
                                             class="img-circle" alt="User Image"/>
                                    </div>
                                    <h4>
                                        Sales Department
                                        <small><i class="fa fa-clock-o"></i> Yesterday</small>
                                    </h4>
                                    <p>Why not buy a new awesome theme?</p>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <div class="pull-left">
                                        <img src="${base}/resources/scripts/admin/img/user4-128x128.jpg"
                                             class="img-circle" alt="User Image"/>
                                    </div>
                                    <h4>
                                        Reviewers
                                        <small><i class="fa fa-clock-o"></i> 2 days</small>
                                    </h4>
                                    <p>Why not buy a new awesome theme?</p>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="footer"><a href="#">See All Messages</a></li>
                </ul>
            </li>
            <li class="dropdown notifications-menu">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <i class="fa fa-bell-o"></i>
                    <span class="label label-warning">10</span>
                </a>
                <ul class="dropdown-menu">
                    <li class="header">You have 10 notifications</li>
                    <li>
                        <ul class="menu">
                            <li>
                                <a href="#">
                                    <i class="fa fa-users text-aqua"></i> 5 new members joined today
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <i class="fa fa-warning text-yellow"></i> Very long description here that may not
                                    fit into the
                                    page and may cause design problems
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <i class="fa fa-users text-red"></i> 5 new members joined
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <i class="fa fa-shopping-cart text-green"></i> 25 sales made
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <i class="fa fa-user text-red"></i> You changed your username
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="footer"><a href="#">View all</a></li>
                </ul>
            </li>
            <li class="dropdown tasks-menu">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <i class="fa fa-flag-o"></i>
                    <span class="label label-danger">9</span>
                </a>
                <ul class="dropdown-menu">
                    <li class="header">You have 9 tasks</li>
                    <li>
                        <ul class="menu">
                            <li>
                                <a href="#">
                                    <h3>
                                        Design some buttons
                                        <small class="pull-right">20%</small>
                                    </h3>
                                    <div class="progress xs">
                                        <div class="progress-bar progress-bar-aqua" style="width: 20%"
                                             role="progressbar"
                                             aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                                            <span class="sr-only">20% Complete</span>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <h3>
                                        Create a nice theme
                                        <small class="pull-right">40%</small>
                                    </h3>
                                    <div class="progress xs">
                                        <div class="progress-bar progress-bar-green" style="width: 40%"
                                             role="progressbar"
                                             aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                                            <span class="sr-only">40% Complete</span>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <h3>
                                        Some task I need to do
                                        <small class="pull-right">60%</small>
                                    </h3>
                                    <div class="progress xs">
                                        <div class="progress-bar progress-bar-red" style="width: 60%" role="progressbar"
                                             aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                                            <span class="sr-only">60% Complete</span>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <h3>
                                        Make beautiful transitions
                                        <small class="pull-right">80%</small>
                                    </h3>
                                    <div class="progress xs">
                                        <div class="progress-bar progress-bar-yellow" style="width: 80%"
                                             role="progressbar"
                                             aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                                            <span class="sr-only">80% Complete</span>
                                        </div>
                                    </div>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="footer">
                        <a href="#">View all tasks</a>
                    </li>
                </ul>
            </li>
            <li class="dropdown user user-menu">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <img src="${base}/resources/scripts/admin/img/user2-160x160.jpg" class="user-image"
                         alt="User Image"/>
                    <span class="hidden-xs">Alexander Pierce</span>
                </a>
                <ul class="dropdown-menu">
                    <li class="user-header">
                        <img src="${base}/resources/scripts/admin/img/user2-160x160.jpg" class="img-circle"
                             alt="User Image"/>
                        <p>
                            Alexander Pierce - Web Developer
                            <small>Member since Nov. 2012</small>
                        </p>
                    </li>
                    <li class="user-body">
                        <div class="col-xs-4 text-center">
                        <#--<a href="#">Followers</a>-->
                        </div>
                        <div class="col-xs-4 text-center">
                        <#--<a href="#">Sales</a>-->
                        </div>
                        <div class="col-xs-4 text-center">
                        <#--<a href="#">Friends</a>-->
                        </div>
                    </li>
                    <li class="user-footer">
                        <div class="pull-left">
                            <a href="#" class="btn btn-default btn-flat">Profile</a>
                        </div>
                        <div class="pull-right">
                            <a href="${base}/logout.htm" class="btn btn-default btn-flat">Sign out</a>
                        </div>
                    </li>
                </ul>
            </li>
            <li>
                <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
            </li>
        </ul>
    </div>
</nav>
</#macro>
<#macro aside flag="index">
<section class="sidebar">
    <ul class="sidebar-menu">
        <li class='treeview   <#if flag=="role" || flag=="resource" || flag=="vislog" || flag=="user" || flag=="operlog">active</#if>'>
            <a href="#">
                <i class="fa fa-user-plus"></i> <span>系统管理</span> <i class="fa fa-angle-left pull-right"></i>
            </a>
            <ul class="treeview-menu">
                <li class='<#if flag=="user">active</#if>'><a href="${base}/user/index.htm"><i class="fa fa-user"></i>用户管理</a>
                </li>
                <li class='<#if flag=="role">active</#if>'><a href="${base}/role/index.htm"><i
                        class="fa fa-hand-rock-o"></i> 角色管理</a></li>
                <li class='<#if flag=="resource">active</#if>'><a href="${base}/resource/index.htm"><i
                        class="fa fa-hand-spock-o"></i> 资源管理</a></li>
                <li class='<#if flag=="vislog">active</#if>'><a href="${base}/vislog/index.htm"><i
                        class="fa fa-bookmark-o"></i> 访问日志管理</a></li>
            <#--<li class='<#if flag=="operlog">active</#if>'><a href="${base}/operlog/index.htm"><i-->
            <#--class="fa fa-bookmark-o"></i> 操作日志管理</a></li>-->
            </ul>
        </li>
        <li class='treeview  <#if flag=="item" || flag=="itemtype">active</#if>'>
            <a href="#">
                <i class="fa fa-user-plus"></i> <span>商品管理</span> <i class="fa fa-angle-left pull-right"></i>
            </a>
            <ul class="treeview-menu">
                <li class='<#if flag="item">active</#if>'><a href="${base}/item/index.htm"><i class="fa fa-user"></i>商品管理</a>
                </li>
                <li class='<#if flag="itemtype">active</#if>'><a href="${base}/itemtype/index.htm"><i
                        class="fa fa-user"></i>商品类型管理</a>
                </li>
            <#--<li class='<#if flag="trade">active</#if>'><a href="${base}/trade/index.htm"><i class="fa fa-user"></i>订单管理</a>-->
            <#--</li>-->
            <#--<li class='<#if flag="shopcart">active</#if>'><a href="${base}/shopcart/index.htm"><i class="fa fa-user"></i>购物车管理</a>-->
            <#--</li>-->
            </ul>
        </li>

        <li class='treeview  <#if flag=="shop" || flag == "shopcart" || flag=="trade">active</#if>'>
            <a href="#">
                <i class="fa fa-user-plus"></i> <span>店铺管理</span> <i class="fa fa-angle-left pull-right"></i>
            </a>
            <ul class="treeview-menu">
                <li class='<#if flag="shop">active</#if>'><a href="${base}/shop/index.htm"><i class="fa fa-user"></i>店铺管理</a>
                </li>
                <li class='<#if flag="trade">active</#if>'><a href="${base}/trade/index.htm"><i class="fa fa-user"></i>订单管理</a>
                </li>
                <li class='<#if flag="shopcart">active</#if>'><a href="${base}/shopcart/index.htm"><i
                        class="fa fa-user"></i>购物车管理</a>
                </li>
            </ul>
        </li>
        <li class='treeview  <#if flag=="tradefx" || flag=="shopfx">active</#if>'>
            <a href="#">
                <i class="fa fa-user-plus"></i> <span>统计分析</span> <i class="fa fa-angle-left pull-right"></i>
            </a>
            <ul class="treeview-menu">
                <li class='<#if flag="tradefx">active</#if>'><a href="${base}/item/index.htm"><i class="fa fa-user"></i>订单分析</a>
                </li>
                <li class='<#if flag="shopfx">active</#if>'><a href="${base}/item/index.htm"><i class="fa fa-user"></i>商品分析</a>
                </li>
            </ul>
        </li>
    </ul>
</section>
</#macro>
<#macro content>
    <#nested>
</#macro>
<#macro footer>
<footer class="main-footer">
    <div class="pull-right hidden-xs">
        <b>Version</b> 2.2.0
    </div>
    <strong>Copyright &copy; 2014-2015 <a href="http://almsaeedstudio.com">Almsaeed Studio</a>.</strong> All rights
    reserved.
</footer>
</#macro>








