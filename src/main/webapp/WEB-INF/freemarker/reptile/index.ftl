<#import "../config/common.ftl"  as common>
<#escape x as x?html>
<!DOCTYPE HTML>
<html>
    <head lang="en">
        <title></title>
        <@common.jquery></@common.jquery>
        <@common.uedit></@common.uedit>
    </head>
    <body>

    <script id="container" name="content" type="text/plain">
        ����д��ĳ�ʼ������
    </script>

    <script type="text/javascript">
        $(function(){
            var ue = UE.getEditor('container');
        });





    </script>

    </body>
</html>
</#escape>