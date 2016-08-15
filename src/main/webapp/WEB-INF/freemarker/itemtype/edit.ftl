<#import "../config/common.ftl"  as common>
<#import "../template/template.ftl" as template>
<#escape x as x?html>
<!DOCTYPE HTML>
<html>
<head lang="en">
    <@template.head title="用户新增"></@template.head>
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
                <h3 class="box-title">修改用户</h3>
            </div>
                <div class="box-body">
                    <form class="form-horizontal" id="itemTypeInfo" method="post">
                        <div class="form-group">
                            <label for="username" class="col-sm-2 control-label">商品名称</label>
                            <div class="col-sm-8">
                                <input type="text"  id="" placeholder="请输入商品名称" name="name" validate="required" value="${itemtype.name}"><span class="red">*</span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password" class="col-sm-2 control-label">排序</label>
                            <div class="col-sm-8">
                                <input type="number" id="password" placeholder="请输入展示排序" name="sort" validate="required" value="${itemtype.sort}">
                            </div>
                        </div>
                        <input type="hidden" name="uid" value="${itemtype.uid}">
                    </form>
                </div>

                <div class="box-footer">
                    <button class="btn btn-info pull-right" onclick="doSubmit();">更新</button>
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
                var validateResultBool = $.validateForm.validate("#itemTypeInfo");
                if(!validateResultBool){
                    return;
                } else{
                    $("#itemTypeInfo").ajaxSubmit({
                        url:"${base}/itemtype/update.json",
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