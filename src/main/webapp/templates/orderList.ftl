<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>訂單列表</title>
</head>

<body>
<div class="head">
<#include "include/top.ftl">
</div>
<div class="left">
<#include "include/menu.ftl">
</div>
<div class="right">
    <ul class="nav nav-pills" role="tablist">
        <li role="presentation" ><a href="#">全部</a></li>
        <li role="presentation" ><a href="#">機BB</a></li>
        <li role="presentation" ><a href="#">機SP</a></li>
        <li role="presentation" ><a href="#">票LY</a></li>
        <li role="presentation" ><a href="#">票SE</a></li>
    </ul>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>編號</th>
            <th>產品ID</th>
            <th>產品名字</th>
            <th>執行價</th>
            <th>成交數量</th>
            <th>出發經緯</th>
            <th>狀態</th>
            <th>編輯產品</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>編號</td>
            <td>產品ID</td>
            <td>產品名字</td>
            <td>執行價</td>
            <td>成交數量</td>
            <td>出發經緯</td>
            <td>狀態</td>
            <td>編輯產品</td>
        </tr>
        </tbody>
    </table>
</div>

</body>
</html>
