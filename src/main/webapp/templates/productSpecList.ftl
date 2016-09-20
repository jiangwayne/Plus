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
	<form id="specForm">
	<table class="table table-striped">
		<input type="hidden" name="id" id="id">
		<tr>
			<td>名称</td><td><input type="text" name="name" id="name"></td>
			<td>日期</td><td><input type="text" name="startDateStr" id="startDateStr"></td>
		<tr>
		</tr>
			<td>原价</td><td><input type="text" name="priceOriginal" id="priceOriginal"></td>
			<td>现价</td><td><input type="text" name="priceCurrent" id="priceCurrent"></td>
		<tr>
		</tr>
			<td>最大数量</td><td><input type="text" name="countMax" id="countMax"></td>
			<td>已卖数量</td><td><input type="text" name="countSale" id="countSale"></td>
		</tr>
		</tr>
			<td cols=999>
				<input type="button" onclick="doEdit()">
			</td>
		</tr>
	</table>
	</form>
	<table class="table table-striped">
		<tr>
			<td>序号</td>
			<td>名称</td>
			<td>日期</td>
			<td>原价</td>
			<td>现价</td>
			<td>最大数量</td>
			<td>已卖数量</td>
			<td>操作</td>
		</tr>
		<#if list??>
		<#list list as s>
		<tr>
			<td>${s_index+1}</td>
			<td>${s.name?if_exists}</td>
			<td>${s.priceOriginal?if_exists}</td>
			<td>${s.priceCurrent?if_exists}</td>
			<td>${(s.startDate?string("yyyy-MM-dd"))!''}</td>
			<td>${s.countMax?if_exists}</td>
			<td>${s.countSale?if_exists}</td>
			<td>
				<input type="button" onclick="deleteOne(${s.id?if_exists})" value="删除">
				<input type="button" onclick="toEdit(${s.id?if_exists})" value="编辑">
			</td>
		</tr>
		</#list>
		</#if>
	</table>
</div>

</body>
<script>
function deleteOne(specId){
	if(!confirm('确认删除？')){
		return;
	}
	$.ajax({
		url: '${base_addr}/ftl/product/deleteProductSpec' ,
        data: {specId: specId},
        async: false,
        dataType: 'json',
        success: function (data) {
        	if(data.success){
        		location.href='${base_addr}/ftl/product/toSpec?productId=${productId?if_exists}';
        	}
        },
        error: function (data) {
            alert("上传出错---"+data);
        }
    });
}
function toEdit(specId){
	if(specId <= 0){
		return;
	}
	$.ajax({
		url: '${base_addr}/ftl/product/querySpecById' ,
        data: {specId: specId},
        async: false,
        dataType: 'json',
        success: function (data) {
        	if(data.success){
        		if(data.data != null){
        			var d = data.data
        			$('#id').val(d.id);
        			$('#name').val(d.name);
        			$('#startDateStr').val(d.startDateStr);
        			$('#priceOriginal').val(d.priceOriginal);
        			$('#priceCurrent').val(d.priceCurrent);
        			$('#countMax').val(d.countMax);
        			$('#countSale').val(d.countSale);
        		}
        	}
        },
        error: function (data) {
            alert("失败--"+data);
        }
    });
}
function doEdit(){
	var specFormSerialize = $('#specForm').serialize();
	$.ajax({
		url: '${base_addr}/ftl/product/updateProductSpec' ,
        data: specFormSerialize,
        async: false,
        dataType: 'json',
        success: function (data) {
        	if(data.success){
        		location.href='${base_addr}/ftl/product/toSpec?productId=${productId?if_exists}';
        	}
        },
        error: function (data) {
            alert("失败--"+data);
        }
    });
}
</script>
</html>
