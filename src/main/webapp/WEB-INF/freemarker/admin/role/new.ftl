<#import "../../config/common.ftl"  as common>
<#import "../../template/template.ftl" as template>
<#escape x as x?html>
<!DOCTYPE HTML>
<html>
<head lang="en">
    <@template.head title="角色新增"></@template.head>
        <@common.jquery></@common.jquery>
        <@common.bootCSS></@common.bootCSS>
        <@common.adminCSS></@common.adminCSS>
        <@common.layerCSS></@common.layerCSS>
        <@common.laydateCSS></@common.laydateCSS>
        <@common.allCSS></@common.allCSS>
        <@common.icheckCSS></@common.icheckCSS>
</head>
<body>
<div class="container">
    <div class="box box-success">
        <div class="box-header with-border">
            <h3 class="box-title"></h3>
        </div>
        <div class="box-body">
            <form class="form-horizontal" id="roleInfo" method="post">
                <div class="form-group">
                    <label for="username" class="col-sm-2 control-label">角色名称</label>
                    <div class="col-sm-8">
                        <input type="text" id="name" placeholder="角色名" name="name" validate="required"><span
                            class="red">*</span>
                    </div>
                    <div class="col-sm-8">
                        <input type="text" id="code" placeholder="角色编码" name="code" validate="required"><span
                            class="red">*</span>
                    </div>
                </div>
            </form>
        </div>
        <div class="box-footer">
            <button class="btn btn-info pull-right" onclick="doSubmit();">保存</button>
        </div>
    </div>
</div>
    <@common.jquery></@common.jquery>
    <@common.bootJS></@common.bootJS>
    <@common.adminJS></@common.adminJS>
    <@common.formJS></@common.formJS>
    <@common.validateJS></@common.validateJS>
    <@common.layerJS></@common.layerJS>
    <@common.laydateJS></@common.laydateJS>
    <@common.icheckJS></@common.icheckJS>
<script type="application/javascript">

    function doSubmit() {
        var validateResultBool = $.validateForm.validate("#roleInfo");
        if(!validateResultBool){
            return;
        }
        $("#roleInfo").ajaxSubmit({
            url: "${base}/role/save.json",
            success: function (resp) {
                if (resp.code == 'SUCCESS') {
                    layer.alert(resp.msg);
                    layer.alert(resp.msg, function (index) {
                        top.refresh();
                    });
                } else {
                    layer.alert(resp.msg);
                }
            },
            error: function (resp) {
                layer.alert(JSON.stringify(resp));
            }
        });
    }
</script>
</body>
</html>
</#escape>