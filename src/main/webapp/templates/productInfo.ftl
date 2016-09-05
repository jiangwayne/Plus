<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>right</title>
<link href="${base_addr}/static/css/main.css" rel="stylesheet" type="text/css" />
<script src="${base_addr}/static/js/jquery1.4.2.min.js" type="text/javascript"></script>
<script src="${base_addr}/static/js/ajaxfileupload.js"></script>

</head>

<body>
<div class="head">
	<#include "include/top.ftl">
</div>
<div class="left">
	<#include "include/menu.ftl">
</div>
<div class="right">
<h3>產品信息</h3>
	<table border="1" width="100%">
	<input type="hidden" name="id" id="id" value="${s.code?if_exists}">
		<tr>
			<td>产品类型</td>
			<td><select name="type" id="type">
	               <option value="10" <#if 10 = s.type>selected</#if>>机票BB</option>
	               <option value="11" <#if 11 = s.type>selected</#if>>机票LY</option>
	               <option value="20" <#if 20 = s.type>selected</#if>>门票SE</option>
	               <option value="21" <#if 21 = s.type>selected</#if>>门票SP</option>
	        </select></td>
		</tr>
		<tr>
			<td>產品ID</td><td><input type="text" name="code" id="code" value="${s.code?if_exists}"></td>
			<td>產品名字</td><td><input type="text" name="name" id="name" value="${s.name?if_exists}"></td>
		</tr>
		<tr>
			<td>一句话描述</td>
			<td colspan=3><input type="text" size=100 name="descriptionSimple" id="descriptionSimple" value="${s.descriptionSimple?if_exists}"></td>
		</tr>
		<tr>
			<td>原價</td><td><input type="text" name="name" id="name" value="${s.name?if_exists}"></td>
			<td>執行價</td><td><input type="text" name="name" id="name" value="${s.name?if_exists}"></td>
		</tr>
		<tr>
			<td>出發地点</td>
			<td colspan=3>
				<select name="countryStart" id="countryStart" onchange="loadCity(this.value,'cityStart')"></select>
				<select name="cityStart" id="cityStart" onchange="loadAirport(this.value,'airportStart')"></select>
				<select name="airportStart" id="airportStart"></select>
			</td>
		</tr>
		<tr>
			<td>目的地点</td>
			<td colspan=3>
				<select name="countryEnd" id="countryEnd" onchange="loadCity(this.value,'cityEnd')"></select>
				<select name="cityEnd" id="cityEnd" onchange="loadAirport(this.value,'airportEnd')"></select>
				<select name="airportEnd" id="airportEnd"></select>
			</td>
		</tr>
		<tr>
			<td>飞行器ID</td><td></td>
			<td>飞行时间(分钟)</td><td><input type="text" name="flyTime" id="flyTime" value="${s.flyTime?if_exists}"></td>
		</tr>
		<tr>
			<td>详细描述</td>
			<td colspan=3>
				<textarea name="descriptionDetail" id="descriptionDetail">${s.descriptionDetail?if_exists}</textarea>
			</td>
		</tr>
		<tr>
			<td>退改须知</td>
			<td colspan=3>
				<select name="orderAlterAgreementId" id="orderAlterAgreementId">
				<#if orderAlterAgreementList??>
					<#list orderAlterAgreementList as o>
	                    <option value="${s.id?if_exists}" <#if s.orderAlterAgreementId = o.id>selected</#if>>${s.content?if_exists}</option>
					</#list>
				</#if>
	            </select>
            </td>
		</tr>
		<tr>
		    <td >频道图片（684*304）</td>
		    <td colspan=3>
		    	<input type="hidden" id="pindaoPic" name="pindaoPic" value="${s.pindaoPic?if_exists}">
		    	<img width="68" height="30" id="picUrlShow1" src="${base_addr}/gtb/file/downloadFile?fileName=${oc.picUrl?if_exists}">
		    		<input type="file" id="fileToUpload1" name="fileToUpload1" >
		    		<input type="button" value="上传" onclick="ajaxUploadFile('fileToUpload1','pindaoPic','picUrlShow1')" /> 
		    </td>
		</tr>
		<tr>
		    <td >封面图片（750*1334）</td>
		    <td colspan=3>
		    	<input type="hidden" id="fengmianPic" name="fengmianPic" value="${s.fengmianPic?if_exists}">
		    	<img width="75" height="133" id="picUrlShow2" src="${base_addr}/gtb/file/downloadFile?fileName=${oc.picUrl?if_exists}">
		    		<input type="file" id="fileToUpload2" name="fileToUpload2" >
		    		<input type="button" value="上传" onclick="ajaxUploadFile('fileToUpload2','fengmianPic','picUrlShow2')" /> 
		    </td>
		</tr>
		<tr>
		    <td >轮播图片（750*550）</td>
		    <td colspan=3>
		    	<input type="hidden" id="lunboPic" name="lunboPic" value="${s.lunboPic?if_exists}">
		    	<img width="75" height="55" id="picUrlShow3" src="${base_addr}/gtb/file/downloadFile?fileName=${oc.picUrl?if_exists}">
		    		<input type="file" id="fileToUpload3" name="fileToUpload3" >
		    		<input type="button" value="上传" onclick="ajaxUploadFile('fileToUpload3','lunboPic','picUrlShow3')" /> 
		    </td>
		</tr>
	</table>
</div>

</body>
<script>
	$(function (){
		loadCountry('countryStart');
		loadCountry('countryEnd');
	});
	function loadCountry(domId){
		var dom = $('#'+domId);
		$.ajax({
			url: '${base_addr}/ftl/product/loadCountry' ,
	        data: {id: ''},
	        dataType: 'json',
	        success: function (data) {
	        	if(data.success){
	        		if(data.data != null){
	        			var d = data.data;
	        			dom.empty();
	        			dom.append("<option value=''></option>");
		        		for(var i = 0; i < d.length; i++){
		        			dom.append("<option value='"+d[i].id+"'>"+d[i].name+"</option>");
		        		}
	        		}
	        	}
	        },
	        error: function (data) {
	            alert("失败--"+data);
	        }
	    });
	}
	function loadCity(countryId,domId){
		if(countryId == null || countryId == ''){
			return;
		}
		var dom = $('#'+domId);
		$.ajax({
			url: '${base_addr}/ftl/product/loadCity' ,
	        data: {countryId: countryId},
	        dataType: 'json',
	        success: function (data) {
	        	if(data.success){
	        		if(data.data != null){
	        			var d = data.data;
	        			dom.empty();
	        			dom.append("<option value=''></option>");
		        		for(var i = 0; i < d.length; i++){
		        			dom.append("<option value='"+d[i].id+"'>"+d[i].name+"</option>");
		        		}
	        		}
	        	}
	        },
	        error: function (data) {
	            alert("失败--"+data);
	        }
	    });
	}
	function loadAirport(cityId,domId){
		if(cityId == null || cityId == ''){
			return;
		}
		var dom = $('#'+domId);
		$.ajax({
			url: '${base_addr}/ftl/product/loadAirport' ,
	        data: {cityId: cityId},
	        dataType: 'json',
	        success: function (data) {
	        	if(data.success){
	        		if(data.data != null){
	        			var d = data.data;
	        			dom.empty();
	        			dom.append("<option value=''></option>");
		        		for(var i = 0; i < d.length; i++){
		        			dom.append("<option value='"+d[i].id+"'>"+d[i].name+"</option>");
		        		}
	        		}
	        	}
	        },
	        error: function (data) {
	            alert("失败--"+data);
	        }
	    });
	}
	function ajaxUploadFile(fileDomId,valueId,showId){
		$.ajaxFileUpload({
			url: '${base_addr}/plus/file/uploadFile' ,
	        secureuri: false,
	        data: {fileName: fileDomId},
	        fileElementId: fileDomId,
	        dataType: 'text',
	        success: function (data) {
	        	data = formatUpFileRetData(data);
	        	if(data.success){
	        		$('#'+valueId).val(data.msg);
	        		$('#'+showId).attr("src","${base_addr}/plus/file/downloadFile?fileName="+data.msg);
	        	}
	        },
	        error: function (data) {
	            alert("上传出错---"+data);
	        }
	    });
	}
	
	function formatUpFileRetData(data){
		var start = data.indexOf(">");  
        if(start != -1) {  
            var end = data.indexOf("<", start + 1);  
            if(end != -1) {  
                data = data.substring(start + 1, end);  
            }  
        }  
       eval( "data = " + data );  
       return data;
	}
</script>
</html>
