<#import "../../config/common.ftl"  as common>
<#import "../../template/template.ftl" as template>
<#escape x as x?html>
<!DOCTYPE HTML>
<html>
<head lang="en">
    <@template.head title="选择角色"></@template.head>
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
                <h3 class="box-title">选择角色</h3>
            </div>
                <div class="box-body">
                        <div class="form-group">
                            <label for="username" class="control-label">权限名：</label>
                        </div>
                        <div class="form-group">
                               <#if resources??>
                                    <#list resources as res>
                                        <input type="checkbox" name="resId" value="${res.id}" <#if res.exist ==0>checked</#if>> ${res.name}&nbsp;&nbsp;
                                    </#list>
                               </#if>
                        </div>
                </div>
                <form class="form-horizontal" id="roleResInfo" method="post">
                    <input type="hidden" name="roleId" value="${roleId}">
                    <input type="hidden" name="resIds" id="resIds">
                </form>
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
           $(function(){
               $('input').iCheck({
                   checkboxClass: 'icheckbox_flat-green',
                   radioClass: 'iradio_flat-green'
               });
           });

            function doSubmit(){
                var resIds = "";
                $("input[name='resId']").each(function(index){
                   var parent = $(this).parent();
                   if($(parent).hasClass("checked")){
                       resIds += $(this).val()+",";
                   }
                });
               $("#resIds").val(resIds);
                $("#roleResInfo").ajaxSubmit({
                        url:"${base}/role/add_role_res.json",
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
    </script>
</body>
</html>
</#escape>