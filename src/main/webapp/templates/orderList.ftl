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
    <div class="input-group">
        <div class="input-group">
            <input type="text" class="form-control">
            <span class="input-group-btn">
                <button class="btn btn-default" type="button">查詢</button>
            </span>
        </div><!-- /input-group -->
    </div><!-- /.col-lg-6 -->
    <div class="input-group">
        <ul class="nav nav-pills" role="tablist">
            <li role="presentation" ><a href="#">全部</a></li>
            <li role="presentation" ><a href="#">機BB</a></li>
            <li role="presentation" ><a href="#">機SP</a></li>
            <li role="presentation" ><a href="#">票LY</a></li>
            <li role="presentation" ><a href="#">票SE</a></li>
        </ul>
    </div>
    <table id="orderList" class="table table-striped">
        <thead>
        <tr>
            <th>編號</th>
            <th>訂單ID</th>
            <th>產品ID</th>
            <th>生成時間</th>
            <th>數量</th>
            <th>總額</th>
            <th>訂單狀態</th>
            <th>客戶ID</th>
            <th>用戶名</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <#if list??>
            <#list list as s>
            <tr>
                <td>${s_index+1}</td>
                <td>${s.id?if_exists}</td>
                <td>${s.name?if_exists}</td>
                <td>${s.priceCurrent?if_exists}</td>
                <td>${s.saleCount?if_exists}</td>
                <td>${s.longLat?if_exists}</td>
                <td>上線
                    <#if s.type1111??>
                        <#if s.type=1>图片</#if>
                        <#if s.type=2>道具</#if>
                        <#if s.type=3>灯片</#if>
                    </#if>
                </td>
                <td><a href="queryById?productId=${s.id?if_exists}">編輯產品</a></td>
            </tr>
            </#list>
        </#if>
        <tr>
            <td>編號</td>
            <td>訂單ID</td>
            <td>產品ID</td>
            <td>生成時間</td>
            <td>數量</td>
            <td>總額</td>
            <td>訂單狀態</td>
            <td>客戶ID</td>
            <td>用戶名</td>
        </tr>
        </tbody>
    </table>
</div>

</body>
</html>
