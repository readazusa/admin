<#import "../config/common.ftl"  as common>
<#import "../template/template.ftl" as template>
<#escape x as x?html>
<!DOCTYPE HTML>
<html>
<head lang="en">
    <@template.head title="商品新增"></@template.head>
        <@common.jquery></@common.jquery>
        <@common.bootCSS></@common.bootCSS>
        <@common.adminCSS></@common.adminCSS>
        <@common.layerCSS></@common.layerCSS>
        <@common.laydateCSS></@common.laydateCSS>
        <@common.allCSS></@common.allCSS>
        <@common.icheckCSS></@common.icheckCSS>
        <@common.umeCSS></@common.umeCSS>
        <@common.bootSelectCSS></@common.bootSelectCSS>
        <@common.bootSwitchCSS></@common.bootSwitchCSS>
</head>
<body>
<div class="container">
    <div class="box box-success">
        <div class="box-header with-border">
            <h3 class="box-title">首页元素新增</h3>
        </div>
        <div class="box-body">
            <form id="indexForm" method="post">
                <div class="my-from-group">
                    <div class="my-item-input-name">是否显示</div>
                    <div class="my-item-input-div">
                        <div class="my-item-input" style="border: none">
                            <div style="float: left;margin-top: 5px;">
                                <input type="checkbox" name="my-checkbox" data-off-color="warning"
                                       data-on-color="success" id="mySwitch" checked>
                            </div>
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
                            </ul>
                        </div>
                    </div>
                    <div class="my-from-group">
                        <div class="my-item-input-name">图片跳转的链接</div>
                        <div class="my-item-input-div">
                            <input type="url" name="contentUrl" placeholder="输图片跳转的链接" class="my-item-input">
                        </div>
                    </div>

                    <div class="my-from-group">
                        <div class="my-item-input-name">图片排序</div>
                        <div class="my-item-input-div">
                            <input type="number" name="sort" class="my-item-input">
                        </div>
                    </div>

                    <div class="my-from-group">
                        <div class="my-item-input-name">输入标题</div>
                        <div class="my-item-input-div">
                            <input type="text" name="title" class="my-item-input">
                        </div>
                    </div>

                    <input type="hidden" name="isShow" id="isShow" value="0">
                    <input type="hidden" name="picUrl" id="picUrl">
                    <input type="hidden" name="type" value="${type}">
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
    <@common.layerJS></@common.layerJS>
    <@common.laydateJS></@common.laydateJS>
    <@common.icheckJS></@common.icheckJS>
    <@common.bootSelectJS></@common.bootSelectJS>
    <@common.bootSwitchJS></@common.bootSwitchJS>
    <@common.xyValidate></@common.xyValidate>
<script type="application/javascript">
    var default_loading_pic = "http://120.26.208.194:8888/yd/loading.gif";
    var default_add_pic = "http://120.26.208.194:8888/yd/add_pp.png";
    $(function () {
        $("[name='my-checkbox']").bootstrapSwitch({
            onSwitchChange: function (event, state) {
                if (state) {
//                    $("#index").removeClass("index_shop_show");
                    $("#isShow").val(0);
                } else {
//                    $("#index").addClass("index_shop_show");
                    $("#isShow").val(1);
                }
            }
        });
        $("li img").on('click', function () {
            $("#uploadImage").click();
        });

        $("li").on("mouseover", function () {
            var span = $(this).children(".choice-image-span");
            var img = $(this).children("img");
            if ("tj" == $(img).attr("flag")) {
                $(span).addClass("choice-image-span-show");
            }
        });

        $("li").on("mouseout", function () {
            var span = $(this).children(".choice-image-span");
            $(span).removeClass("choice-image-span-show");
        });

        //删除图片
        $("li .choice-image-span").on("click", function (e) {
            var img = $(this).prev();
            $(img).attr("flag", "ys");
            $(img).attr("src", default_add_pic);
            $(this).removeClass("choice-image-span-show");
            $("#picUrl").val("");

        });
    });


    function doUpload() {
        console.info("开始上传图片.....");
        $("#oneImage").attr("src", default_loading_pic);
        $("#fileForm").ajaxSubmit({
            url: "${base}/upload/ftp.json",
            success: function (resp) {
                if ("SUCCESS" == resp.code) {
                    var url = resp.data.url;
                    $("#oneImage").attr("src", url);
                    //图片的标记 flag:ys(原始):表示没有添加图片，表示添加图片 ,flag:tj  表示已经添加的图片
                    $("#oneImage").attr("flag", "tj");
                    $("#picUrl").val(url);
                } else {
                    layer.alert("上传图片失败,请重新操作");
                }
            },
            error: function (resp) {
                layer.alert("上传图片失败,请重新操作");
            }
        });
    }

    function doSubmit() {


        $("#indexForm").ajaxSubmit({
            url: "${base}/index/save.json",
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