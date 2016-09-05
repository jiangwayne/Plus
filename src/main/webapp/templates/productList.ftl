<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>right</title>
<link href="${base_addr}/static/css/main.css" rel="stylesheet" type="text/css" />
<script src="${base_addr}/static/js/jquery1.4.2.min.js" type="text/javascript"></script>

</head>

<body>
<div class="head">
	<#include "include/top.ftl">
</div>
<div class="left">
	<#include "include/menu.ftl">
</div>
<div class="right">
	<table class="table table-striped">
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
		<#if list??>
		<#list list as s>
		<tr>
			<td>${s_index+1}</td>
			<td>${s.code?if_exists}</td>
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
	</table>
	<#if (page>1) >
	<a href="#" onclick="toPage(1)">第一頁</a>｜
	<a href="#" onclick="toPage(${page-1})">上一頁</a>｜
	<#else>
	第一頁｜上一頁
	</#if>
	<#if (page<pages) >
	<a href="#" onclick="toPage(${page+1})">下一頁</a>｜
	<a href="#" onclick="toPage(${pages})">最後一頁</a>
	<#else>
	下一頁｜最後一頁
	</#if>
</div>

</body>
</html>
