<#import "../../config/common.ftl"  as common>
<#import "../../template/template.ftl" as template>
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
                <h3 class="box-title">查看用户</h3>
            </div>
                <div class="box-body">
                    <form class="form-horizontal" id="userInfo" method="post">
                        <div class="form-group">
                            <label for="username" class="col-sm-2 control-label">用户名</label>
                            <div class="col-sm-8">
                                <input type="text"  id="username" placeholder="用户名" name="username" validate="required"><span class="red">*</span>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="password" class="col-sm-2 control-label">密码</label>
                            <div class="col-sm-8">
                                <input type="password" id="password" placeholder="密码" name="password" validate="required">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="repassword" class="col-sm-2 control-label">确认密码</label>
                            <div class="col-sm-8">
                                <input type="password"  id="repassword" placeholder="确认密码"  validate="equalTo" equalTo="#password">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="name" class="col-sm-2 control-label">姓名</label>
                            <div class="col-sm-8">
                                <input type="text" id="name" placeholder="姓名" name="name" validate="required">
                            </div>
                            <span class="red"></span>
                        </div>

                        <div class="form-group">
                            <label for="birthday" class="col-sm-2 control-label">性别</label>
                            <div class="col-sm-8">
                                <input type="radio" name="sex" id="male" value="male" checked>男 &nbsp;&nbsp;&nbsp;
                                <input type="radio" name="sex" id="female" value="female">女
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="birthday" class="col-sm-2 control-label">手机号</label>
                            <div class="col-sm-8">
                                <input type="text" id="mobile" placeholder="手机号" validate="mobilenum" name="mobile">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="birthday" class="col-sm-2 control-label">生日</label>
                            <div class="col-sm-8">
                                <input type="text" class="laydate-icon" id="birthday" placeholder="生日" style="box-sizing: inherit;" name="birthday">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="birthday" class="col-sm-2 control-label">邮箱</label>
                            <div class="col-sm-8">
                                <input type="text" id="email" placeholder="邮箱" validate="email" name="email">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="birthday" class="col-sm-2 control-label">区域</label>
                            <div class="col-sm-8">
                                <select id="province"  onchange="queryArea(this,'#city','#provinceName')" >
                                    <option>全部省</option>
                                </select>
                                <select id="city"  onchange="queryArea(this,'#area','#cityName')" >
                                    <option>城市</option>
                                </select>
                                <select id="area" onchange="insertArea(this,'#areaName');">
                                    <option>县</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="birthday" class="col-sm-2 control-label">地址</label>
                            <div class="col-sm-8">
                                <input type="text" id="address" placeholder="地址" style="box-sizing: inherit;" name="address">
                            </div>
                        </div>
                        <div>
                            <input type="hidden" id="provinceName" name="province">
                        </div>
                        <div>
                            <input type="hidden" id="cityName" name="city">
                        </div>
                        <div>
                            <input type="hidden" id="areaName" name="area">
                        </div>
                    </form>
                </div>

                <div class="box-footer">
                    <#--<button class="btn btn-info pull-right" onclick="doSubmit();">保存</button>-->
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
                laydate({
                    elem:'#birthday',
                    format:"YYYY-MM-DD hh:mm:ss"
                });
                laydate.skin("danlan");
                $("#userInfo input").bind('keyup',function(){
                       var next = $(this).next();
                       $(next).remove();
                });
                $.ajax({
                    url:"${base}/area/get/1.json",
                    success:function(resp){
                        if(resp.code = "ok"){
                            var result = resp.data;
                            var option = "";
                            $.each(result,function(index,obj){
                                option +="<option value='"+obj.id+"'>"+obj.name+"</option>";
                            });

                            $("#province").append(option);
                        }
                    },
                    error:function(resp){

                    }
                });

                $('input').iCheck({
                    checkboxClass: 'icheckbox_flat-green',
                    radioClass: 'iradio_flat-green'
                });
            });
            function queryArea(obj,area,name){
                var value = $(obj).val();
                var areaName = $(obj).find("option:selected").text();
                $(name).val(areaName);
                $.ajax({
                    url:"${base}/area/get/"+value+".json",
                    success:function(resp){
                        if(resp.code = 'ok'){
                            var result = resp.data;
                            var option = "";
                            $.each(result,function(index,obj){
                                option +="<option value='"+obj.id+"'>"+obj.name+"</option>";
                            });
                            $(area).empty();
                            $(area).append(option);
                        }
                    },
                    error:function(resp){

                    }
                });
            }

            function insertArea(obj,name){
                var areaName = $(obj).find("option:selected").text();
                $(name).val(areaName);
            }
            function doSubmit(){
                var validateResultBool = $.validateForm.validate("#userInfo");
                if(!validateResultBool){
                    return;
                } else{
                    $("#userInfo").ajaxSubmit({
                        url:"${base}/user/save.json",
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