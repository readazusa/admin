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
        <@common.umeCSS></@common.umeCSS>
        <@common.bootSelectCSS></@common.bootSelectCSS>
</head>
<body>
<div class="container">
    <div class="box box-success">
        <div class="box-header with-border">
            <h3 class="box-title">新增商品</h3>
        </div>
        <div class="box-body">
            <form id="itemForm" method="post">
                <div class="my-from-group">
                    <div class="my-item-input-name">商品类别</div>
                    <div class="my-item-input-div">
                        <select class="selectpicker" id="selectpicker" name="cid">
                            <option value="1">水</option>
                            <option value="2">霜</option>
                            <option value="3">乳</option>
                        </select>
                    </div>
                </div>
                <div class="my-from-group">
                    <div class="my-item-input-name">商品名称</div>
                    <div class="my-item-input-div">
                        <input class="my-item-input" name="title" value="${item.title}">
                    </div>
                </div>
                <div class="my-from-group">
                    <div class="my-item-input-name">手机端宝贝图片</div>
                    <div class="my-item-input-div my-item-media">
                        <ul>
                            <li class="choice-image">
                                <span class="choice-image-index">主图片</span>
                                <img src="${item.phonePicUrl}" id="oneImage" flag="tj">
                                <span class="choice-image-span" >删除</span>
                            </li>
                            <li class="choice-image">
                                <#if (files?size>1)>
                                    <img src="${files[1].url}" id="twoImage" flag="tj">
                                <#else>
                                    <img src="http://120.26.208.194:8888/yd/add_pp.png" id="twoImage" flag="ys">
                                </#if>
                                <span class="choice-image-span">删除</span>
                            </li>
                            <li class="choice-image">
                                <#if (files?size>2)>
                                    <img src="${files[2].url}" id="threeImage" flag="tj">
                                <#else>
                                    <img src="http://120.26.208.194:8888/yd/add_pp.png" id="threeImage" flag="ys">
                                </#if>

                                <span class="choice-image-span">删除</span>
                            </li>
                            <li class="choice-image">
                                <#if (files?size>3)>
                                    <img src="${files[1].url}" id="fourImage" flag="tj">
                                <#else>
                                    <img src="http://120.26.208.194:8888/yd/add_pp.png" id="fourImage" flag="ys">
                                </#if>
                                <span class="choice-image-span">删除</span>
                            </li>
                            <li class="choice-image">
                                <#if (files?size>4)>
                                    <img src="${files[4].url}" id="fourImage" flag="tj">
                                <#else>
                                    <img src="http://120.26.208.194:8888/yd/add_pp.png" id="fiveImage" flag="ys">
                                </#if>
                                <span class="choice-image-span">删除</span>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="my-from-group">
                    <div class="my-item-input-name">价格与数量</div>
                    <div>
                        <div class="my-item-input-div">
                            <table class="gridtable">
                                <thead>
                                <tr>
                                    <th>单价</th>
                                    <th>单位</th>
                                    <th>库存</th>
                                </tr>
                                </thead>
                                <tr>
                                    <td>
                                        <input name="price" value="${item.price}">
                                    </td>
                                    <td>
                                        <input name="company" value="${item.company}">
                                    </td>
                                    <td>
                                        <input name="stock" value="${item.stock}">
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="my-from-group">
                    <div class="my-item-input-name">商品描述</div>
                    <div class="my-item-input-div">
                        <script type="text/plain" id="myEditor" style="width:100%;height:500px;">
                                 <#noescape> ${item.descr}</#noescape>
                        </script>
                    </div>
                </div>
                <div class="my-from-group">
                    <div class="my-item-input-name">邮费</div>
                    <div class="my-item-input-div">
                        <input class="my-item-input" name="postage" value="${item.postage}">
                    </div>
                </div>
                <input type="hidden" name="descr" id="descr">
                <input type="hidden" name="fileIds" id="fileIds" value="${fileIds}">
                <input type="hidden" name="phonePicUrl" id="phonePicUrl" value="${item.phonePicUrl}">
                <input type="hidden" name="uid" value="${item.uid}">
            </form>
            <form id="fileForm" method="post" action="${base}/upload/ftp.json" enctype="multipart/form-data">
                <input type="file" style="display: none" id="uploadImage" onchange="doUpload();" name="file">
            </form>
        </div>
        <div class="box-footer">
            <button class="btn btn-info pull-right" onclick="doSubmit();">更新</button>
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
    <@common.umeJS></@common.umeJS>
    <@common.bootSelectJS></@common.bootSelectJS>
    <@common.ownMapJS></@common.ownMapJS>
    <@common.xyValidate></@common.xyValidate>
<script type="application/javascript">
    var setItme = null;
    var um = UM.getEditor('myEditor');
    var default_add_pic="http://120.26.208.194:8888/yd/add_pp.png";
    var default_loading_pic="http://120.26.208.194:8888/yd/loading.gif";
    var map = new Map();
    $(function () {

        $("li img").on('click', function () {
            var imgId =$(this).attr("id");
            $("#choiceImg").val("#" + imgId);
            $("#uploadImage").click();
        });

        $("li").on("mouseover", function () {
            var span = $(this).children(".choice-image-span");
            var img = $(this).children("img");
            if("tj" == $(img).attr("flag")){
                $(span).addClass("choice-image-span-show");
            }
        });

        $("li").on("mouseout", function () {
            var span = $(this).children(".choice-image-span");
            $(span).removeClass("choice-image-span-show");
        });

        //删除图片
        $("li .choice-image-span").on("click",function(e){
            var img = $(this).prev();
            $(img).attr("flag","ys");
            $(img).attr("src",default_add_pic);
            $(this).removeClass("choice-image-span-show");
            var imageId = $(this).attr("id");
            if("oneImage" == imageId){   //如果主图片被清空，删除保存的图片url，这个url使用后续的图片
                $("#phonePicUrl").val("");
            }
            map.remove(imageId);
        });
    });

    function doUpload() {
        console.info("开始上传图片.....");
        $("#fileForm").ajaxSubmit({
            url: "${base}/upload/ftp.json",
            success: function (resp) {
                if ("SUCCESS" == resp.code) {
                    var url = resp.data.url;
                    var imageId = $("#choiceImg").val();
                    $(imageId).attr("src", url);
                    //图片的标记 flag:ys(原始):表示没有添加图片，表示添加图片 ,flag:tj  表示已经添加的图片
                    $(imageId).attr("flag","tj");
                    map.put(imageId,resp.data.id);
                    if("oneImage" == imageId){
                        $("#phonePicUrl").val(url);
                    }
                } else {
                    layer.alert("上传图片失败,请重新操作");
                }
            },
            error: function (resp) {
                layer.alert("上传图片失败,请重新操作");
            }
        });
    }
    function setUrl(){
        if(!$("#phonePicUrl").val()){
            var url = null;
            $("li img").each(function(){
                if(!url){
                    url = $(this).attr("src");
                }
            });
            !$("#phonePicUrl").val(url);
        }
    }

    function setDescr(){
        var descr = um.getContent();
        $("#descr").val(descr);
    }

    function  setFileIds(){
        var fileIds = map.getValue("&&");
        $("#fileIds").val(fileIds);
    }

    function doSubmit(){
        setDescr();
        setFileIds();
        setUrl();
        if($.xyValidateForm(document.getElementById("itemForm"))){
            $("#itemForm").ajaxSubmit({
                url: "${base}/item/update.json",
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

    function receive(data) {
        alert(data.age);
    }

</script>
</body>
</html>
</#escape>