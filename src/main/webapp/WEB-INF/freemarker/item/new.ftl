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
        <@common.animateCSS></@common.animateCSS>
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
                                <img src="http://120.26.208.194:8888/yd/add_pp.png" id="oneImage" flag="ys">
                                <span class="choice-image-span">删除</span>
                            </li>
                            <li class="choice-image">
                                <img src="http://120.26.208.194:8888/yd/add_pp.png" id="twoImage" flag="ys">
                                <span class="choice-image-span"></span>
                            </li>
                            <li class="choice-image">
                                <img src="http://120.26.208.194:8888/yd/add_pp.png" id="threeImage" flag="ys">
                                <span class="choice-image-span">asd</span>
                            </li>
                            <li class="choice-image">
                                <img src="http://120.26.208.194:8888/yd/add_pp.png" id="fourImage" flag="ys">
                                <span class="choice-image-span">asd</span>
                            </li>
                            <li class="choice-image">
                                <img src="http://120.26.208.194:8888/yd/add_pp.png" id="fiveImage" flag="ys">
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
                <input type="hidden" name="fileIds">
            </form>
            <form id="fileForm" method="post" action="${base}/upload/ftp.json" enctype="multipart/form-data">
                <input type="file" style="display: none" id="uploadImage" onchange="doUpload();" name="file">
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
<script type="application/javascript">
    var setItme = null;
    $(function () {
        $("li").on('click', function () {
            var img = $(this).children("img");
            var imgId = $(img).attr("id");
            $("#choiceImg").val("#" + imgId);
            $("#uploadImage").click();
        });

        $("li").on("mouseover", function () {
            var date = new Date();
            var span = $(this).children("span");
            $(span).addClass("choice-image-span-show");
        });

        $("li").on("mouseout", function () {
            var date = new Date();
            var span = $(this).children("span");
            $(span).removeClass("choice-image-span-show");
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

    function doUpload() {
        console.info("开始上传图片.....");
        $("#fileForm").ajaxSubmit({
            url: "${base}/upload/ftp.json",
            success: function (resp) {
                if("SUCCESS" == resp.code){
                    var url = resp.data.url;
                    var imageId = $("#choiceImg").val();
                    $(imageId).attr("src",url);
                }else{
                    layer.alert("上传图片失败,请重新操作");
                }

            },
            error: function (resp) {
                layer.alert("上传图片失败,请重新操作");
            }
        });
    }

</script>
</body>
</html>
</#escape>