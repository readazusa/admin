<#import "config/common.ftl"  as common>
<#escape x as x?html>
<!DOCTYPE HTML>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>全名享受</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

    <@common.bootMinCSS></@common.bootMinCSS>
    <#--<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />-->
    <@common.adminCSS></@common.adminCSS>
    <@common.jquery></@common.jquery>
    <@common.icheckCSS></@common.icheckCSS>
</head>
<body class="login-page" style="background: #DDDED2;">
<div class="login-box">
    <div class="login-logo">

    </div>
    <div class="login-box-body">
        <p class="login-box-msg">全名享受管理系统</p>
        <form method="post">
            <div class="form-group has-feedback input-group">
                <div class="input-group-addon">邮箱</div>
                <input type="email" class="form-control" placeholder="邮箱" />
                <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback input-group">
                <div class="input-group-addon">密码</div>
                <input type="password" class="form-control" placeholder="密码" />
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="row">
                <div class="col-xs-8">
                    <input type="checkbox"> Remember Me
                </div>
                <div class="col-xs-4">
                    <a href="javascript:void(0);"   data-url="regist/forget" style="color: #3f1fe9">忘记密码</a>
                </div>
            </div>
            <br>
            <div class="row">
                    <div class="col-xs-5 col-xs-offset-1">
                        <a class="button button-action button-rounded button-small">登录</a>
                    </div>
                    <div class="col-xs-5 col col-xs-offset-1">
                        <a class="button button-action button-rounded button-small">注册</a>
                    </div>
            </div>
        </form>
    </div>
</div>
    <@common.bootJS></@common.bootJS>
    <@common.adminJS></@common.adminJS>
    <@common.icheckJS></@common.icheckJS>
<script>
    $(function () {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%'
        });
    });
</script>
</body>
</html>
</#escape>