<#macro adminAddJS url title=" " width="50%" height="70%">
<script type="application/javascript">
    function add() {
        index = layer.open({
            type: 2,
            title: "${title}",
            shadeClose: true,
            shade: 0.8,
            shift: 2,
            maxmin: true,
            area: ['${width}', '${height}'],
            content: "${url}"
        });
    }
</script>
</#macro>

<#macro adminDeleteJS url title="">
<script type="application/javascript">
    function remove(id) {
        $.ajax({
            url: "${url}?id=" + id,
            success: function (resp) {
                if ("SUCCESS" == resp.code) {
                    index = layer.alert(resp.msg, function (index) {
                        refresh();
                    })
                } else {
                    layer.alert(resp.msg);
                }
            },
            error: function (resp) {
                layer.alert("${title}失败");
            }
        })
    }
</script>
</#macro>

<#macro adminEditJS url title="" width="50%" height="70%">
<script type="application/javascript">
    function edit(id) {
        index = layer.open({
            type: 2,
            title: "${title}",
            shadeClose: true,
            shade: 0.8,
            shift: 2,
            maxmin: true,
            area: ['${width}', '${height}'],
            content: "${url}?id=" + id
        });
    }
</script>
</#macro>

<#macro adminViewJS url title="" width="50%" height="70%">
<script type="application/javascript">
    function view(id) {
        index = layer.open({
            type: 2,
            title: "${title}",
            shadeClose: true,
            shade: 0.8,
            shift: 2,
            maxmin: true,
            area: ['${width}', '${height}'],
            content: "${url}?id=" + id
        });
    }
</script>
</#macro>

<#macro pageOption currentPage="1" totalPages="10" numberOfPages = "5" callback="page">
<script type="application/javascript">
    var options = {
        bootstrapMajorVersion: 3,
        currentPage: ${currentPage},
        totalPages: ${totalPages},
        numberOfPages:${numberOfPages},
        itemContainerClass:function(type, page, current){
            switch (type) {
                case "first":
                     return (page === current) ? "disabled" : "";
                case "prev":
                     return (page === current) ? "disabled" : "";
                case "next":
                      return (page === current) ? "disabled" : "";
                case "last":
                     return (page === current) ? "disabled" : "";
                case "page":
                    return (page === current) ? "active" : "";
            }
//            return (page === current) ? "active" : "";
        },
        itemTexts: function (type, page, current) {
            switch (type) {
                case "first":
                    return "首页";
                case "prev":
                    return "上一个";
                case "next":
                    return "下一个";
                case "last":
                    return "尾页";
                case "page":
                    return page;
            }
        },
        shouldShowPage: function (type, page, current) {
            return true;
        },
        onPageChanged: function (e, oldPage, newPage) {   //分页的使用
           page(newPage);
        }
    }
</script>
</#macro>