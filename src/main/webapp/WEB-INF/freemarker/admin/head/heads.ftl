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
        <@common.allCSS></@common.allCSS>
        <@common.jcropCSS></@common.jcropCSS>
</head>
<body>
    <div class="container">
        <div class="box box-success">
            <div class="box-header with-border">
                <div class="box-title">
                    <ul class="nav nav-tabs" id="myTab">
                        <li>
                            <a href="#custom">自定义图片</a>
                        </li>
                        <li>
                            <a href="#classic">经典图片</a>
                        </li>
                        <li>
                            <a href="#dynamic">
                                动态图片
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
                <div class="box-body">
                    <div class="tab-content">
                        <div class="tab-pane active" id="custom">
                            <div class="box">
                                <div class="box-header">
                                    <div class="box-title">
                                        <form id="headFile"  method="post" enctype="multipart/form-data">
                                            <input type="button"  onclick="headFile.click();" value="本地文件"  class="button button-primary button-pill button-small"/>
                                            <input type="file" id="headFile"  name="headFile" onchange="doUpload();" style="display:none"  accept="image/gif,image/bmp,image/png,image/jpg,image/jpeg" >
                                        </form>
                                    </div>
                                </div>
                                <div class="box-body">
                                    <div style="height: 300px; width: 600px;" align="center">
                                        <img src="${base}/resources/image/head.png" id="target">
                                    </div>
                                </div>
                                <div class="box-footer">
                                     <a class="button button-primary button-pill button-small  pull-right" href="javascript:choice();"> 确定</a>
                                </div>
                                <form id="newHeadForm" method="post">
                                    <input type="hidden" id="x1" name="x1" >
                                    <input type="hidden" id="y1" name="y1">
                                    <input type="hidden" id="x2" name="x2">
                                    <input type="hidden" id="y2" name="y2">
                                    <input type="hidden" id="height" name="height">
                                    <input type="hidden"  id="width" name="width">
                                    <input type="hidden" id="path" name="path">
                                </form>
                            </div>
                        </div>
                        <div class="tab-pane" id="classic">经典</div>
                        <div class="tab-pane" id="dynamic">动态</div>
                    </div>
                </div>
        </div>
    </div>
    <@common.jquery></@common.jquery>
    <@common.formJS></@common.formJS>
    <@common.bootJS></@common.bootJS>
    <@common.adminJS></@common.adminJS>
    <@common.jcropJS></@common.jcropJS>
    <script type="application/javascript">
             var api;
            $(function(){
                $('#myTab a').click(function (e) {
                    e.preventDefault();
                    $(this).tab('show');
                });
            });

            function setJcrop(){
                $('#target').Jcrop({
                    bgOpacity: 0.5,
                    bgColor: 'white',
                    addClass: 'jcrop-light',
                    maxSize:[100,100],
                    allowSelect:false
                },function(){
                    api = this;
                    api.setSelect([0,0,100,100]);
                    api.setOptions({ bgFade: true });
                    api.ui.selection.addClass('jcrop-selection');
                } );
            }

            function doUpload(){
                $("#headFile").ajaxSubmit({
                    url:"${base}/head/upload.json",
                    success:function(resp){
                       if(resp.code=='SUCCESS'){
                           var path = resp.path;
                           $("#target").attr("src","${base}/head/show.htm?path="+path);
                           $("#path").val(path);
                           setJcrop();
                       }
                    },
                    error: function (resp) {
                        alert(JSON.stringify(resp));
                    }
                })
            }

            //选择图片
            function choice(){
                select = api.tellSelect();
                var x1= select.x;
                var y1 = select.y;
                var x2 = select.x2;
                var y2 = select.y2;
                var height = select.h;
                var width = select.w;
                $("#x1").val(x1);
                $("#y1").val(y1);
                $("#x2").val(x2);
                $("#y2").val(y2);
                $("#height").val(height);
                $("#width").val(width);
                $("#newHeadForm").ajaxSubmit({
                   url:"${base}/head/save.json",

                   success:function(resp){
                       alert(JSON.stringify(resp));
                   },
                    error:function(resp){
                        alert(JSON.stringify(resp));
                    }
                });
            }
    </script>
</body>
</html>
</#escape>