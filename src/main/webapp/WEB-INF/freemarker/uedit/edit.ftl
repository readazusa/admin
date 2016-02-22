<#import  "../config/common.ftl" as common>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <@common.js></@common.js>
    <title></title>
</head>
<body>
    <div style="margin-left: auto;margin-right: auto;">
    <script id="container" type="text/plain" style="width:1024px;height:500px;">


    </script>
    </div>

    <script type="application/javascript">
        var ue = UE.getEditor("container")
        ue.ready(function(){
          //  ue.setDisabled('bold');   //除了加粗可以使用 其他都不可以使用
        });
    </script>
</body>
</html>