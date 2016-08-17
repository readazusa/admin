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
                            <label for="username" class="control-label">角色名：</label>
                        </div>
                        <div class="form-group">
                               <#if roles??>
                                    <#list roles as role>
                                        <input type="checkbox" name="roleId" value="${role.id}"   <#if role.exist ==0>checked</#if>> ${role.name}&nbsp;&nbsp;
                                    </#list>
                               </#if>
                        </div>
                </div>
            <form class="form-horizontal" id="userRoleInfo" method="post">
                    <input type="hidden" name="userId" value="${userId}">
                    <input type="hidden" name="roleIds" id="roleIds">
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
                var roleIds = "";
                $("input[name='roleId']").each(function(index){
                   var parent = $(this).parent();
                   if($(parent).hasClass("checked")){
                       roleIds += $(this).val()+",";
                   }
                });
               $("#roleIds").val(roleIds);
                $("#userRoleInfo").ajaxSubmit({
                        url:"${base}/user/add_user_role.json",
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