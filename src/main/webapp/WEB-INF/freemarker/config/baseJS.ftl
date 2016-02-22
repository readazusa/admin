<#macro adminAddJS url title=" ">
     <script type="application/javascript">
            function add(){
                index = layer.open({
                    type: 2,
                    title: "${title}",
                    shadeClose: true,
                    shade: 0.8,
                    shift: 2,
                    maxmin: true,
                    area: ['50%', '70%'],
                    content: "${url}"
                });
            }
     </script>
</#macro>

<#macro adminDeleteJS url title="">
    <script type="application/javascript">
        function remove(id){
            $.ajax({
                url:"${url}?id="+id,
                success:function(resp){
                    if("SUCCESS"== resp.code){
                        index = layer.alert(resp.msg,function(index){
                            refresh();
                        })
                    }else{
                        layer.alert(resp.msg);
                    }
                },
                error:function(resp){
                    layer.alert("${title}失败");
                }
            })
        }
    </script>
</#macro>

<#macro adminEditJS url title="">
    <script type="application/javascript">
        function edit(id){
            index = layer.open({
                type: 2,
                title: "${title}",
                shadeClose: true,
                shade: 0.8,
                shift: 2,
                maxmin: true,
                area: ['50%', '70%'],
                content: "${url}?id="+id
            });
        }
    </script>
</#macro>

<#macro adminViewJS url title="">
    <script type="application/javascript">
        function view(id){
            index = layer.open({
                type: 2,
                title: "${title}",
                shadeClose: true,
                shade: 0.8,
                shift: 2,
                maxmin: true,
                area: ['50%', '70%'],
                content: "${url}?id="+id
            });
        }
    </script>
</#macro>