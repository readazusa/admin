<#import "../config/common.ftl"  as common>
<#import "../template/template.ftl" as template>
<#escape x as x?html>
<!DOCTYPE HTML>
<html>
<head lang="en">
    <@template.head title="店铺新增"></@template.head>
        <@common.jquery></@common.jquery>
        <@common.bootCSS></@common.bootCSS>
        <@common.adminCSS></@common.adminCSS>
        <@common.layerCSS></@common.layerCSS>
        <@common.laydateCSS></@common.laydateCSS>
        <@common.allCSS></@common.allCSS>
        <@common.icheckCSS></@common.icheckCSS>
  <@common.bootSelectCSS></@common.bootSelectCSS>
    <@common.bootSwitchCSS></@common.bootSwitchCSS>
</head>
<body>
<div class="container">
    <div class="box box-success">
        <div class="box-header with-border">
            <h3 class="box-title">新增店铺</h3>
        </div>
        <div class="box-body">
            <form id="shopForm" method="post">
                <div class="my-from-group">
                    <div class="my-item-input-name">是否为主店</div>
                    <div class="my-item-input-div">
                        <div class="my-item-input" style="border: none">
                            <div style="float: left;margin-top: 5px;">
                                <#--<input type="radio" name="index" id="male" value="0" checked>是 &nbsp;&nbsp;&nbsp;-->
                                <#--<input type="radio" name="index" id="female" value="1">否-->
                                    <input type="checkbox" name="my-checkbox" checked>
                            </div>
                            <div id="index" style="float: right;margin-right:50%;margin-top:5px;">
                                <span>选择主店:</span>
                                <select class="selectpicker" id="selectpicker" name="cid">
                                    <option value="1">水</option>
                                    <option value="2">霜</option>
                                    <option value="3">乳</option>
                                </select>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="my-from-group">
                    <div class="my-item-input-name">省市区</div>
                    <div class="my-item-input-div">
                        <div class="my-item-input" style="border: none">
                            <select id="province"  onchange="queryArea(this,'#city','#provinceName')">
                                <option>全部省</option>
                            </select>
                            <select id="city"  onchange="queryArea(this,'#area','#cityName')">
                                <option>城市</option>
                            </select>
                            <select id="area" onchange="insertArea(this,'#areaName');">
                                <option>县</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="my-from-group">
                    <div class="my-item-input-name">地址</div>
                    <div class="my-item-input-div">
                            <input type="text" name="address" placeholder="输入地址" class="my-item-input">
                    </div>
                </div>
                <div class="my-from-group">
                    <div class="my-item-input-name">商品名称</div>
                    <div class="my-item-input-div">
                        <input type="text" name="name" placeholder="商品名称" class="my-item-input">
                    </div>
                </div>
            </form>
        </div>
        <div class="box-footer">
            <button class="btn btn-info pull-right" onclick="doSubmit();">保存</button>
            <input type="hidden" id="choiceImg">
            <input type="hidden" id="validateSpan">
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
    <@common.bootSelectJS></@common.bootSelectJS>
<@common.bootSwitchJS></@common.bootSwitchJS>
<script type="application/javascript">
    $(function () {
//        $('input').iCheck({
//            checkboxClass: 'icheckbox_flat-green',
//            radioClass: 'iradio_flat-green'
//        });
        $("[name='my-checkbox']").bootstrapSwitch();
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

    function doSubmit() {
        var validateResultBool = $.validateForm.validate("#userInfo");
        if (!validateResultBool) {
            return;
        } else {
            $("#userInfo").ajaxSubmit({
                url: "${base}/item/save.json",
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
    }

    function doUpload() {
        console.info("开始上传图片.....");
        $("#fileForm").ajaxSubmit({
            url: "${base}/upload/ftp.json",
            success: function (resp) {
                if ("SUCCESS" == resp.code) {
                    var url = resp.data.url;
                    var imageId = $("#choiceImg").val();
                    $(imageId).attr("src", url);
                } else {
                    layer.alert("上传图片失败,请重新操作");
                }
            },
            error: function (resp) {
                layer.alert("上传图片失败,请重新操作");
            }
        });
    }

    function loadMap() {


    }

</script>
</body>
</html>
</#escape>