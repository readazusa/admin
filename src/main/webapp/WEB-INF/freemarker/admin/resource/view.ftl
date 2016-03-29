<#import "../../config/common.ftl"  as common>
<#import "../../template/template.ftl" as template>
<#escape x as x?html>
<!DOCTYPE HTML>
<html>
<head lang="en">
    <@template.head title="权限修改"></@template.head>
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
                <h3 class="box-title">修改权限</h3>
            </div>
                <div class="box-body">
                    <form class="form-horizontal" id="resInfo" method="post">
                        <div class="form-group">
                            <label for="username" class="col-sm-2 control-label">权限名</label>
                            <div class="col-sm-8">
                                <input type="text"  id="name" placeholder="权限名" name="name" validate="required" value="${resource.name}" disabled>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="code" class="col-sm-2 control-label">权限编码</label>
                            <div class="col-sm-8">
                                <input type="text"  id="code" placeholder="权限编码" name="code" validate="required" value="${resource.code}" disabled>
                            </div>
                        </div>
                        <div>
                            <input type="hidden" value="${resource.id}" name="id">
                        </div>
                    </form>
                </div>

                <div class="box-footer">
                    <#--<button class="btn btn-info pull-right" onclick="doSubmit();">修改</button>-->
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

            function doSubmit(){
                var validateResultBool = $.validateForm.validate("#resInfo");
                if(!validateResultBool){
                    return;
                } else{
                    $("#resInfo").ajaxSubmit({
                        url:"${base}/resource/update.json",
                        success:function(resp){
                            if(resp.code == 'SUCCESS'){
                                layer.alert(resp.msg);
                                layer.alert(resp.msg, function(index){
                                    top.refresh();
                                });
                            }else{

                                layer.alert(resp.msg);
                            }
                        },
                        error:function(resp){
                            layer.alert(JSON.stringify(resp));
                        }
                    });
                }
            }
    </script>
</body>
</html>
</#escape>