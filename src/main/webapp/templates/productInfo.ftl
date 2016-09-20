<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>right</title>
<link href="${base_addr}/static/css/main.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div class="head">
	<#include "include/top.ftl">
</div>
<div class="left">
	<#include "include/menu.ftl">
</div>
<script src="${base_addr}/static/js/ajaxfileupload.js"></script>
<div class="right">
<h3>產品信息</h3>
	<form action="#" method="post" id="productForm">
	<table border="1" width="100%">
	<input type="hidden" name="id" id="id" value="${s.id?if_exists}">
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
			<td>原價</td><td><input type="text" name="priceOriginal" id="priceOriginal" value="${s.priceOriginal?if_exists}"></td>
			<td>執行價</td><td><input type="text" name="priceCurrent" id="priceCurrent" value="${s.priceCurrent?if_exists}"></td>
		</tr>
		<tr>
			<td>出發地点</td>
			<td colspan=3>
				<select name="countryStart" id="countryStart" onchange="loadCity(this.value,'cityStart')" value="${s.countryStart?if_exists}"></select>
				<select name="cityStart" id="cityStart" onchange="loadAirport(this.value,'airportStart')" value="${s.cityStart?if_exists}"></select>
				<select name="airportStart" id="airportStart" value="${s.airportStart?if_exists}"></select>
			</td>
		</tr>
		<tr>
			<td>目的地点</td>
			<td colspan=3>
				<select name="countryEnd" id="countryEnd" onchange="loadCity(this.value,'cityEnd')" value="${s.countryEnd?if_exists}"></select>
				<select name="cityEnd" id="cityEnd" onchange="loadAirport(this.value,'airportEnd')" value="${s.cityEnd?if_exists}"></select>
				<select name="airportEnd" id="airportEnd" value="${s.airportEnd?if_exists}"></select>
			</td>
		</tr>
		<tr>
			<td>飞行器ID</td><td><input type="text" name="planeId" id="planeId" value="${s.planeId?if_exists}"></td>
			<td>飞行时间(分钟)</td><td><input type="text" name="flyTime" id="flyTime" value="${s.flyTime?if_exists}"></td>
		</tr>
		<tr>
			<td>详细描述</td>
			<td colspan=3>
				<textarea rows=5 cols=80 name="descriptionDetail" id="descriptionDetail">${s.descriptionDetail?if_exists}</textarea>
			</td>
		</tr>
		<tr>
		    <td >频道图片（684*304）</td>
		    <td colspan=3>
		    	<input type="hidden" id="pindaoPic" name="pindaoPic" value="${s.pindaoPic?if_exists}">
		    	<img width="68" height="30" id="picUrlShow1" src="${base_addr}/plus/file/downloadFile?fileName=${s.pindaoPic?if_exists}">
		    		<input type="file" id="fileToUpload1" name="fileToUpload1" >
		    		<input type="button" value="上传" onclick="ajaxUploadFile('fileToUpload1','pindaoPic','picUrlShow1')" /> 
		    </td>
		</tr>
		<tr>
		    <td >封面图片（750*1334）</td>
		    <td colspan=3>
		    	<input type="hidden" id="fengmianPic" name="fengmianPic" value="${s.fengmianPic?if_exists}">
		    	<img width="75" height="133" id="picUrlShow2" src="${base_addr}/plus/file/downloadFile?fileName=${s.fengmianPic?if_exists}">
		    		<input type="file" id="fileToUpload2" name="fileToUpload2" >
		    		<input type="button" value="上传" onclick="ajaxUploadFile('fileToUpload2','fengmianPic','picUrlShow2')" /> 
		    </td>
		</tr>
		<tr>
		    <td >轮播图片（750*550）</td>
		    <td colspan=3>
		    	<input type="hidden" id="lunboPic" name="lunboPic" value="${s.lunboPic?if_exists}">
		    		<table border="1" ><tr id="lunboBR"></tr></table>
		    		<input type="file" id="fileToUpload3" name="fileToUpload3" >
		    		<input type="button" value="上传" onclick="ajaxUploadFile('fileToUpload3','lunboPic','picUrlShow3')" /> 
		    </td>
		</tr>
		<tr>
		    <td >图标选择</td>
		    <td colspan=3>
		    	<input type="hidden" name="icon" id="icon" value="${s.icon?if_exists}">
			    <table >
					<tr>
					<#if picLibList??>
					<#list picLibList as pic>
					<#if pic_index &gt; 0 && pic_index%11==0></tr><tr></#if>
						<td>
							<img width="40" height="40" src="${base_addr}/static/img/${pic.picUrl?if_exists}">
							<br /><input <#if s.icon?contains(","+pic.id+",")>checked</#if> type="checkbox" onclick="clickCheckbox(this,${pic.id?if_exists})" name="picLibCheckbox" id="picLibCheckbox_${pic.id?if_exists}">
						</td>
					</#list>
					</#if>
					</tr>
				</table>
		    
		    </td>
		</tr>
		<tr>
		    <td ><input id="submitProductBTN" type="button" onclick="saveProduct()" value="保存"></td>
		</tr>
	</table>
	</form>
	<a href="toSpec?productId=${s.id?if_exists}">编辑规格</a>
</div>

</body>
<script>
	$(function (){
		loadCountry('countryStart');
		loadCountry('countryEnd');
		<#if productId??>
			$('#countryStart').val(${s.countryStart?if_exists});
			$('#countryEnd').val(${s.countryEnd?if_exists});
			
			loadCity($('#countryStart').val(),'cityStart');
			loadCity($('#countryEnd').val(),'cityEnd');
			$('#cityStart').val(${s.cityStart?if_exists});
			$('#cityEnd').val(${s.cityEnd?if_exists});
			
			loadAirport($('#cityStart').val(),'airportStart');
			loadAirport($('#cityEnd').val(),'airportEnd');
			$('#airportStart').val(${s.airportStart?if_exists});
			$('#airportEnd').val(${s.airportEnd?if_exists});
		</#if>
	});
	function loadCountry(domId){
		var dom = $('#'+domId);
		$.ajax({
			url: '${base_addr}/ftl/product/loadCountry' ,
	        data: {id: ''},
	        async: false,
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
	        async: false,
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
	        async: false,
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
		var fileDomValue= $('#'+fileDomId).val();
		if(fileDomValue == null || fileDomValue==''){
			return;
		}
		$.ajaxFileUpload({
			url: '${base_addr}/plus/file/uploadFile' ,
	        secureuri: false,
	        data: {fileName: fileDomId},
	        fileElementId: fileDomId,
	        dataType: 'text',
	        success: function (data) {
	        	data = formatUpFileRetData(data);
	        	if(data.success){
	        		if('fileToUpload3'==fileDomId){
	        			lunboPicAdd(data.msg);
	        			var domHtml = '<td id="'+data.msg+'" align="center"><img width="75" height="55" style="margin:10 10 0 10" src="${base_addr}/plus/file/downloadFile?fileName='+data.msg+'">';
	        			domHtml+='<br /><a href="javascript:lunboPicDelete(\''+data.msg+'\',\''+data.msg+'\',this)" style="color:#ff0000"><b>X</b></a></td>';
	        			$('#lunboBR').append(domHtml);
	        		}else{
		        		$('#'+valueId).val(data.msg);
		        		$('#'+showId).attr("src","${base_addr}/plus/file/downloadFile?fileName="+data.msg);
		        	}
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
	function saveProduct(){
		$('#submitProductBTN').attr("disabled",true);
		var productFormSerialize = $('#productForm').serialize();
		$.ajax({
			url: '${base_addr}/ftl/product/updateProduct' ,
	        data: productFormSerialize,
	        async: false,
	        dataType: 'json',
	        success: function (data) {
	        	if(data.success){
	        		//location.reload(true);
	        		location.href='${base_addr}/ftl/product/queryById?productId='+data.msg;
	        	}
	        },
	        error: function (data) {
	            alert("失败--"+data);
	        }
	    });
		$('#submitProductBTN').attr("disabled",false);
	}
	function clickCheckbox(dom,piclibId){
		var icon = $('#icon').val();
		piclibId = ","+piclibId+",";
		if(dom.checked){
			if(icon.indexOf(piclibId)<0){
				icon+=piclibId;
			}
		}else{
			icon = icon.replace(piclibId,"");
		}
		$('#icon').val(icon);
	}
	function lunboPicAdd(picUrl){
		var lunboPic = $('#lunboPic').val();
		picUrl = ","+picUrl+",";
		if(lunboPic.indexOf(picUrl)<0){
			lunboPic+=picUrl;
			$('#lunboPic').val(lunboPic);
		}
		
	}
	function lunboPicDelete(picUrl,tdId,dom){
		var lunboPic = $('#lunboPic').val();
		picUrl = ","+picUrl+",";
		if(lunboPic.indexOf(picUrl)>=0){
			lunboPic = lunboPic.replace(picUrl,"");
			$('#lunboPic').val(lunboPic);
		}
		$('#'+tdId).remove();
	}
</script>
</html>
