<#import "../config/common.ftl"  as common>
<#import "../template/template.ftl" as template>
<#escape x as x?html>
<!DOCTYPE HTML>
<html>
<head lang="en">
    <@template.head title="店铺更新"></@template.head>
        <@common.jquery></@common.jquery>
        <@common.bootCSS></@common.bootCSS>
        <@common.adminCSS></@common.adminCSS>
        <@common.layerCSS></@common.layerCSS>
        <@common.laydateCSS></@common.laydateCSS>
        <@common.allCSS></@common.allCSS>
        <@common.icheckCSS></@common.icheckCSS>
          <@common.bootSelectCSS></@common.bootSelectCSS>
         <@common.bootSwitchCSS></@common.bootSwitchCSS>
        <@common.gdMapCSS></@common.gdMapCSS>
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
                                <input type="checkbox" name="my-checkbox" data-off-color="warning"
                                       data-on-color="success" id="mySwitch" value="0" <#if shop.indexType=='0'>checked</#if>>
                            </div>
                            <div id="index" class="index_shop <#if shop.indexType =='1'>index_shop_show</#if>">
                                <span>选择主店:</span>
                                <select id="selectpicker" name="parentId">
                                </select>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="my-from-group">
                    <div class="my-item-input-name">店铺名称</div>
                    <div class="my-item-input-div">
                        <input type="text" name="name" placeholder="店铺名称" class="my-item-input" value="${shop.name}">
                    </div>
                </div>
                <div class="my-from-group">
                    <div class="my-item-input-name">店铺手机号</div>
                    <div class="my-item-input-div">
                        <input type="text" name="telNum" placeholder="店铺手机号" class="my-item-input" value="${shop.telNum}">
                    </div>
                </div>
                <div class="my-from-group">
                    <div class="my-item-input-name">店铺电话号码</div>
                    <div class="my-item-input-div">
                        <input type="text" name="phoneNum" placeholder="店铺电话号码" class="my-item-input" value="${shop.phoneNum}">
                    </div>
                </div>
                <div class="my-from-group">
                    <div class="my-item-input-name">手机端宝贝图片</div>
                    <div class="my-item-input-div my-item-media">
                        <ul>
                            <li class="choice-image" onclick="doClickPic();">
                                <img src="${shop.picUrl}" id="shopIndexPic">
                            <#--<span class="choice-image-span">删除</span>-->
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="my-from-group">
                    <div class="my-item-input-name">店铺介绍</div>
                    <div class="my-item-input-div">
                        <textarea name="descr" id="textarea" rows="5" cols="60">${shop.descr}</textarea>
                    </div>
                </div>
                <div class="my-from-group">
                    <div class="my-item-input-name">省市区</div>
                    <div class="my-item-input-div">
                        <div class="my-item-input" style="border: none">
                            <select id="province" onchange="queryArea(this,'#city','#provinceName')"
                                    name="province">
                                <option>全部省</option>
                            </select>
                            <select id="city" onchange="queryArea(this,'#area','#cityName')" name="city">
                                <option value="">城市</option>
                            </select>
                            <select id="area" onchange="setMap();" name="area">
                                <option value="">区县</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="my-from-group">
                    <div class="my-item-input-name">地址</div>
                    <div class="my-item-input-div">
                        <input type="text" name="address" placeholder="输入地址" class="my-item-input"
                               onblur="doSetAddress(this);" value="${shop.address}">
                    </div>
                </div>
                <div class="my-from-group">
                    <div class="my-item-input-name">店铺地图</div>
                    <div class="my-item-input-div">
                        <div id="container" style="height: 300px;width: 100%;">
                        </div>
                    </div>
                </div>
                <input type="hidden" name="lng" id="lng" value="${shop.lng}">
                <input type="hidden" name="lat" id="lat" value="${shop.lat}">
                <input type="hidden" name="picUrl" id="picUrl" value="${shop.picUrl}">
                <input type="hidden" name="indexType" value="${shop.indexType}" id="indexType">
                <input type="hidden" name="id" value="${shop.id}">
            </form>
        </div>
        <div class="box-footer">
            <button class="btn btn-info pull-right" onclick="doSubmit();">更新</button>
            <input type="hidden" id="adddressMap">
            <form method="post" enctype="multipart/form-data" id="picFileForm" action="${base}/upload/ftp.json">
                <input type="file" name="file" id="picFileId" onchange="doUpload();" style="display: none">
            </form>
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
    <@common.gdMapJS></@common.gdMapJS>
    <@common.myJS></@common.myJS>
<script type="application/javascript">
    var map = new AMap.Map('container');
    var marker = new AMap.Marker();
    var placeSearch = null;
    var placeSearchRender = null;
    var default_loading_pic = "http://120.26.208.194:8888/yd/loading.gif";
    var default_add_pic = "http://120.26.208.194:8888/yd/add_pp.png";
    $(function () {
        $("[name='my-checkbox']").bootstrapSwitch({
            onSwitchChange: function (event, state) {
                if (state) {
                    $("#index").removeClass("index_shop_show");
                    $("#indexType").val(0);
                } else {
                    $("#index").addClass("index_shop_show");
                    $("#indexType").val(1);
                }
            }
        });

        var city = "${shop.city}";

        var area = "${shop.area}";

        var province ="${shop.province}";

        MyObj.submit("${base}/area/get/1.json", loadProvice);

        MyObj.submit("${base}/area/get/" + province + ".json", loadCity);

        MyObj.submit("${base}/area/get/" + city + ".json", loadArea);

        MyObj.submit("${base}/shop/type/index.json", loadIndexShop, {"index": 0});

        loadMap();

    });

    function loadProvice(resp){
        var province ="${shop.province}";
        if (resp.code = "ok") {
            var result = resp.data;
            var option = "";
            $.each(result, function (index, obj) {
                if(province == obj.id){
                    option += "<option value='" + obj.id + "' selected>" + obj.name + "</option>";
                }else{
                    option += "<option value='" + obj.id + "'>" + obj.name + "</option>";
                }
            });
            $("#province").append(option);
        }
    }

    function loadCity(resp){
        var city = "${shop.city}";
        if (resp.code = "ok") {
            var result = resp.data;
            var option = "";
            $.each(result, function (index, obj) {
                if(city == obj.id){
                    option += "<option value='" + obj.id + "' selected>" + obj.name + "</option>";
                }else{
                    option += "<option value='" + obj.id + "'>" + obj.name + "</option>";
                }
            });
            $("#city").append(option);
        }
    }

    function loadArea(resp){
        var area = "${shop.area}";
        if (resp.code = "ok") {
            var result = resp.data;
            var option = "";
            $.each(result, function (index, obj) {
                if(area == obj.id){
                    option += "<option value='" + obj.id + "' selected>" + obj.name + "</option>";
                }else{
                    option += "<option value='" + obj.id + "'>" + obj.name + "</option>";
                }
            });
            $("#area").append(option);
        }
    }

    function loadIndexShop(resp) {
        var parentId = "${shop.parentId}";
        if (resp.code = 'SUCCESS') {
            var result = resp.data;
            var option = "";
            $.each(result, function (index, obj) {
                if(parentId == obj.id){
                    option += "<option value='" + obj.id + "' selected>" + obj.name + "</option>";
                }else{
                    option += "<option value='" + obj.id + "'>" + obj.name + "</option>";
                }
            });
            $("#selectpicker").append(option);
        }
    }




    function queryArea(obj, area, name) {
        var value = $(obj).val();
        var areaName = $(obj).find("option:selected").text();
        $(name).val(areaName);
        $.ajax({
            url: "${base}/area/get/" + value + ".json",
            success: function (resp) {
                if (resp.code = 'ok') {
                    var result = resp.data;
                    var option = "";
                    if ("#city" == area) {
                        option = "<option value=''>选择城市</option>";
                    } else {
                        option = "<option value=''>选择区县</option>";
                    }
                    $.each(result, function (index, obj) {
                        option += "<option value='" + obj.id + "'>" + obj.name + "</option>";
                    });
                    $(area).empty();
                    $(area).append(option);

                    if ("#city" == area) {
                        $("#area").empty().append("<option value=''>选择区县</option>");
                    }
                    setMap();
                }
            },
            error: function (resp) {

            }
        });
    }

    function setMap() {
        var province = $("#province").find("option:selected").text();
        var city = "";
        if ($("#city").val()) {
            city = $("#city").find("option:selected").text();
        }
        var area = "";
        if ($("#area").val()) {
            area = $("#area").find("option:selected").text();
        }
        var addressMap = province + city + area;
        $("#adddressMap").val(addressMap);
        placeSearch = new AMap.PlaceSearch(MyObj.Map.placeSearchOptions);
        placeSearch.search(addressMap, callback);
        placeSearchRender = new Lib.AMap.PlaceSearchRender();
    }


    function doSubmit() {
        $("#shopForm").ajaxSubmit({
            url: "${base}/shop/update.json",
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
    //location":{"I":31.268829,"C":120.62694199999999,"lng":120.626942,"lat":31.268829}
    /**
     * lng: 经度
     * lat：维度
     * @param status
     * @param result
     */
    function callback(status, result) {
        if (status === 'complete' && result.info === 'OK') {
            console.info(JSON.stringify(result));
            var lng = result.poiList.pois[0].location.lng;
            var lat = result.poiList.pois[0].location.lat;
            $("#lng").val(lng);
            $("#lat").val(lat);
            placeSearchRender.autoRender({
                placeSearchInstance: placeSearch,
                methodName: "search",
                methodArgumments: ["", callback],
                data: result,
                map: map
            });
        }
    }

    function doClickPic() {
        $("#picFileId").click();
    }

    function doUpload() {
        $("#shopIndexPic").attr("src", default_loading_pic);
        console.info("开始上传图片.....");
        $("#picFileForm").ajaxSubmit({
            url: "${base}/upload/ftp.json",
            success: function (resp) {
                if ("SUCCESS" == resp.code) {
                    var url = resp.data.url;
                    $("#shopIndexPic").attr("src", url);
                    $("#picUrl").val(url);
                } else {
                    $("#shopIndexPic").attr("src", default_add_pic);
                    layer.alert("上传图片失败,请重新操作");
                }
            },
            error: function (resp) {
                $("#shopIndexPic").attr("src", default_add_pic);
                layer.alert("上传图片失败,请重新操作" + JSON.stringify(resp));
            }
        });
    }
    //zoom,地图显示的缩放级别范围，在PC上，默认为[3,18]，取值范围[3-18]；在移动设备上，默认为[3-19],取值范围[3-19]
    function loadMap() {
        map.setZoom(18);
        map.setCenter([${shop.lng},${shop.lat}]);
        marker.setMap(map);
    }


    function doSetAddress(obj) {
        var address = $(obj).val();
        var addMap = $("#adddressMap").val();
        var newAddress = addMap + address;
        placeSearch = new AMap.PlaceSearch(MyObj.Map.placeSearchOptions);
//        //关键字查询，您如果想修改结果展现效果，请参考页面：http://lbs.amap.com/fn/css-style/
        placeSearch.search(newAddress, callback);
        placeSearchRender = new Lib.AMap.PlaceSearchRender();
    }
</script>
</body>
</html>
</#escape>