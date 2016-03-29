<#import "../../../config/common.ftl"  as common>
<#import "../../../template/template.ftl" as template>
<#escape x as x?html>
<!DOCTYPE HTML>
<html>
<head lang="en">
    <@template.head title="访问日志详细信息"></@template.head>
        <@common.jquery></@common.jquery>
        <@common.bootMinCSS></@common.bootMinCSS>
        <@common.adminCSS></@common.adminCSS>
</head>
<body>
<div class="container">
    <div class="box box-info">
        <div class="box-header with-border">
            <h3 class="box-title">访问日志详细信息</h3>
        </div>
        <div class="box-body">
            <div class="row">
                <div class="col-md-2">访问客户端:</div>
                <div class="col-md-10">${visitLogPO.userAgent}</div>
            </div>
            <div class="row">
                <div class="col-md-2">userIp:</div>
                <div class="col-md-10">${visitLogPO.userIp}</div>
            </div>
            <div class="row">
                <div class="col-md-2">访问url:</div>
                <div class="col-md-10">${visitLogPO.url}</div>
            </div>
            <div class="row">
                <div class="col-md-2">访问方法:</div>
                <div class="col-md-10">${visitLogPO.method}</div>
            </div>
            <div class="row">
                <div class="col-md-2">访问时间:</div>
                <div class="col-md-10">${visitLogPO.createTime?datetime}</div>
            </div>


            <#--<form class="form-horizontal" id="userInfo" method="post">-->
                <#--<div class="form-group">-->
                    <#--<label for="username" class="col-sm-2 control-label">访问客户端:</label>-->
                    <#--<div class="col-sm-8">-->
                        <#--${visitLogPO.userAgent}-->
                    <#--</div>-->
                <#--</div>-->

                <#--<div class="form-group">-->
                    <#--<label for="password" class="col-sm-2 control-label">userIp:</label>-->
                    <#--<div class="col-sm-8">-->
                        <#--${visitLogPO.userIp}-->
                    <#--</div>-->
                <#--</div>-->
                <#--<div class="form-group">-->
                    <#--<label for="repassword" class="col-sm-2 control-label">访问url:</label>-->

                    <#--<div class="col-sm-8">-->
                    <#--${visitLogPO.url}-->
                    <#--</div>-->
                <#--</div>-->
                <#--<div class="form-group">-->
                    <#--<label for="name" class="col-sm-2 control-label">username:</label>-->

                    <#--<div class="col-sm-8">-->
                    <#--${visitLogPO.username}-->
                    <#--</div>-->
                <#--</div>-->
                <#--<div class="form-group">-->
                    <#--<label for="birthday" class="col-sm-2 control-label">访问时间:</label>-->

                    <#--<div class="col-sm-8">-->
                    <#--${visitLogPO.createTime?datetime}-->
                    <#--</div>-->
                <#--</div>-->
            <#--</form>-->
        </div>

        <div class="box-footer">
        <#--<button class="btn btn-info pull-right" onclick="doSubmit();">保存</button>-->
        </div>
    </div>
</div>
    <@common.bootJS></@common.bootJS>
    <@common.adminJS></@common.adminJS>
</body>
</html>
</#escape>