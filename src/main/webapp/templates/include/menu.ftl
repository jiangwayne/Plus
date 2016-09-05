<!DOCTYPE html>
<html><head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>left</title>
    <script type="text/javascript" >
        $(document).ready(function(){
            $("#menu").children().each(function(){
                $(this).removeClass("active");
                if(location.href == $(this).children().get(0).getAttribute("href")){
                    $(this).addClass("active");
                }
            })
        })
    </script>
</head>

<body>
<div class="leftmenu">
    <ul id="menu" class="nav nav-pills nav-stacked">
        <li role="presentation" class="active"><a  href="${base_addr}/ftl/order/list" target="_self">訂單列表</a></li>
        <li role="presentation"><a  href="${base_addr}/gtb/user/listBrandManager" target="_self">心願單列表</a></li>
        <li role="presentation"><a  href="${base_addr}/ftl/product/list" target="_self">產品列表</a></li>
        <li role="presentation"><a  href="${base_addr}/gtb/user/listBA" target="_self">客戶列表</a></li>
        <li role="presentation"><a  href="${base_addr}/gtb/user/listErector" target="_self">商家列表</a></li>
        <li role="presentation"><a  href="${base_addr}/gtb/user/listErector" target="_self">飛行器列表</a></li>
        <li role="presentation"><a  href="${base_addr}/gtb/user/listErector" target="_self">評價列表</a></li>
    </ul>
</div>
</body></html>
