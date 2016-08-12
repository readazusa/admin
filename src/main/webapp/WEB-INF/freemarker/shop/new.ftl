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

</head>
<body>
<div class="container">
    <div class="box box-success">
        <div class="box-header with-border">
            <h3 class="box-title">新增店铺</h3>
        </div>
        <div class="box-body">
            <form>
                <div class="my-from-group">
                    <div class="my-item-input-name">店铺地址</div>
                    <div class="my-item-input-div">
                        <div id="bdMap" style="width: 100%;height: 400px;">


                        </div>
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
    <@common.bdMapJS></@common.bdMapJS>
<script type="application/javascript">
    var setItme = null;
    $(function () {
        loadMap();
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

        var map = new BMap.Map("bdMap");

        var point = new BMap.Point(116.404, 39.915);

        map.centerAndZoom(point, 30);

        map.enableScrollWheelZoom();
//        window.setTimeout(function(){
//            map.panTo(new BMap.Point(116.409, 39.918));
//        }, 4000);

//        var polyline = new BMap.Polyline([
//            new BMap.Point(116.399, 39.910), new BMap.Point(116.405, 39.920)], {strokeColor:"blue", strokeWeight:6, strokeOpacity:0.5});
//
//        map.addOverlay(polyline);
        var point1 = new BMap.Point(116.405, 39.920);
//        var walking = new BMap.WalkingRoute(map);
//
//        walking.search(point,point1); //创建步行搜索
//
//        map.addEventListener("click", function(){
//            alert("您点击了地图。");
//        });
//        var myPushpin = new BMap.PushpinTool(map);          // 创建标注工具实例
//        myPushpin.addEventListener("markend", function(e){  // 监听事件，提示标注点坐标信
//            息
//            alert("您标注的位置：" +
//                    e.marker.getPoint().lng + ", " +
//                    e.marker.getPoint().lat);
//        });
//        myPushpin.open();
//        var transit = new BMap.WalkingRoute(map, {
//            renderOptions: {map: map, panel: "results"}
//        });
////        transit.search("王府井", "西单");
//        transit.search(point1, point);

//        var map = new BMap.Map("bdMap");
//        var point = new BMap.Point(116.331398,39.897445);
//        map.centerAndZoom(point,12);

        var geolocation = new BMap.Geolocation();
        geolocation.getCurrentPosition(function(r){
            if(this.getStatus() == BMAP_STATUS_SUCCESS){
                var mk = new BMap.Marker(r.point);
                map.addOverlay(mk);
                map.panTo(r.point);
                alert('您的位置：'+r.point.lng+','+r.point.lat);
            }
            else {
                alert('failed'+this.getStatus());
            }
        },{enableHighAccuracy: true})
    }

</script>
</body>
</html>
</#escape>