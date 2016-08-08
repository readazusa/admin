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
            <h3 class="box-title">新增商品</h3>
        </div>
        <div class="box-body">
            <form>
                <div class="my-from-group">
                      <div class="my-item-input-name">商品名称</div>
                      <div class="my-item-input-div">
                          <input class="my-item-input">
                      </div>
                </div>

                <div class="my-from-group">
                    <div class="my-item-input-name">手机端宝贝图片</div>
                    <div class="my-item-input-div my-item-media">
                        <ul>
                            <li class="choice-image">
                                <img src="http://120.26.208.194:8888/yd/add.png" id="oneImage">
                                <span class="choice-image-span">删除</span>
                            </li>
                            <li class="choice-image">
                                <img src="http://120.26.208.194:8888/yd/add.png" id="oneImage">
                                <span class="choice-image-span">asd</span>
                            </li>
                            <li class="choice-image">
                                <img src="http://120.26.208.194:8888/yd/add.png" id="oneImage">
                                <span class="choice-image-span">asd</span>
                            </li>
                            <li class="choice-image">
                                <img src="http://120.26.208.194:8888/yd/add.png" id="oneImage">
                                <span class="choice-image-span">asd</span>
                            </li>
                            <li class="choice-image">
                                <img src="http://120.26.208.194:8888/yd/add.png" id="oneImage">
                                <span class="choice-image-span"></span>
                            </li>
                        </ul>
                    </div>
                </div>

                <div class="my-from-group">
                    <div class="my-item-input-name">商品描述</div>
                    <div class="my-item-input-div">

                    </div>
                </div>
            </form>
            <form>
               <input type="file" style="display: none" id="uploadImage" onchange="doUpload(this.files);">
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
    $(function () {
        $('input').iCheck({
            checkboxClass: 'icheckbox_flat-green',
            radioClass: 'iradio_flat-green'
        });
    });

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

    function doUpload(files){
        var file = files[0];
        var url = null;
        if (window.createObjectURL != undefined) {
            url = window.createObjectURL(file);
        } else if (window.URL != undefined) {
            url = window.URL.createObjectURL(file);
        } else if (window.webkitURL != undefined) {
            url = window.webkitURL.createObjectURL(file);
        }
        $("#oneImage").attr("src",url);
    }

    function doUploadImageDiv(){
        $("#uploadImage").click();
    }

</script>
</body>
</html>
</#escape>