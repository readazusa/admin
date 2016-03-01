<#import "config/common.ftl"  as common>
<#import "template/template.ftl" as template>
<#escape x as x?html>
<!DOCTYPE HTML>
<html>
    <head lang="en">
        <@template.head title="后台管理"></@template.head>
        <@common.bootCSS></@common.bootCSS>
        <@common.adminCSS></@common.adminCSS>
        <@common.jquery></@common.jquery>
        <@shiro.hasAnyRoles name="adduer">
            user
        </@shiro.hasAnyRoles>
    </head>
    <body class="skin-green-light sidebar-mini">
       <div class="wrapper">
           <header class="main-header">
               <@template.header></@template.header>
             </header>
           <aside class="main-sidebar">
               <@template.aside></@template.aside>
           </aside>
             <div class="content-wrapper">
                 <@template.content>

                 </@template.content>
             </div>
            <@template.footer></@template.footer>

       </div>
      <@common.bootJS></@common.bootJS>
      <@common.adminJS></@common.adminJS>
    </body>
</html>
</#escape>