<!DOCTYPE html>
<html><head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>left</title>
    <link href="${base_addr}/static/css/main.css" rel="stylesheet" type="text/css">
    <link href="${base_addr}/static/css/left.css" rel="stylesheet" type="text/css">
	<script src="${base_addr}/static/js/jquery-1.3.2.min.js"></script>
    <script src="${base_addr}/static/js/leftmenu.js" type="text/javascript"></script>
</head>

<body>
<div class="leftmenu">
    <ul>
    	<#if Session.userRole.roleId?? && (Session.userRole.roleId == 1 || Session.userRole.roleId == 2 || Session.userRole.roleId == 3)>
        <li><a style="background: transparent url(&quot;images/xsj.png&quot;) no-repeat scroll 150px center;" href="#" class="one">用户管理</a>
            <ul style="display: block;" class="sub-menu show">
                <li><a  href="${base_addr}/gtb/user/listContactStaff" target="mainFrame">客服经理</a></li>
                <li><a  href="${base_addr}/gtb/user/listBrandManager" target="mainFrame">品牌经理</a></li>
                <li><a  href="${base_addr}/gtb/user/listSupplier" target="mainFrame">供应商管理员</a></li>
                <li><a  href="${base_addr}/gtb/user/listBA" target="mainFrame">BA</a></li>
                <li><a  href="${base_addr}/gtb/user/listErector" target="mainFrame">安装工</a></li>
            </ul>
        </li>
        </#if>
        <#if Session.userRole.roleId?? && (Session.userRole.roleId == 1 || Session.userRole.roleId == 2 || Session.userRole.roleId == 3 || Session.userRole.roleId == 4)>
        <li><a style="background: transparent url(&quot;images/xsj.png&quot;) no-repeat scroll 150px center;" href="#" class="one">资源管理</a>
            <ul style="display: block;" class="sub-menu">
                <li><a  href="${base_addr}/gtb/org/listBrand" target="mainFrame">品牌</a></li>
                <li><a  href="${base_addr}/gtb/org/listCounterType" target="mainFrame">柜台样式</a></li>
                <li><a  href="${base_addr}/gtb/org/listCounter" target="mainFrame">柜台</a></li>
                <li><a  href="${base_addr}/gtb/org/listFurniture" target="mainFrame">家具</a></li>
                <li><a  href="${base_addr}/gtb/org/listInstallationCompany" target="mainFrame">安装公司</a></li>
                <li><a  href="${base_addr}/gtb/org/listSupplier" target="mainFrame">供应商</a></li>
                <li><a  href="${base_addr}/gtb/parent/toEdit" target="mainFrame">添加父件</a></li>
                <li><a  href="${base_addr}/gtb/parent/list" target="mainFrame">查询父件</a></li>
                <li><a  href="${base_addr}/gtb/child/toEdit" target="mainFrame">添加子件</a></li>
                <li><a  href="${base_addr}/gtb/child/list" target="mainFrame">查询子件</a></li>
                <li><a  href="${base_addr}/gtb/everydayInfo/toEdit" target="mainFrame">添加日常信息</a></li>
                <li><a  href="${base_addr}/gtb/everydayInfo/list" target="mainFrame">查询日常信息</a></li>
                <li><a  href="${base_addr}/gtb/displayHandbook/toEdit" target="mainFrame">添加陈列手册</a></li>
                <li><a  href="${base_addr}/gtb/displayHandbook/list" target="mainFrame">查询陈列手册</a></li>
            </ul>
        </li>
        </#if>
        <#if Session.userRole.roleId?? && (Session.userRole.roleId == 1 || Session.userRole.roleId == 2 || Session.userRole.roleId == 3 || Session.userRole.roleId == 4)>
        <li><a style="background: transparent url(&quot;images/xsj.png&quot;) no-repeat scroll 150px center;" href="#" class="one">任务管理</a>
            <ul style="display: block;" class="sub-menu">
                <#if Session.userRole.roleId?? && (Session.userRole.roleId == 1 || Session.userRole.roleId == 2 || Session.userRole.roleId == 3)>
	        		<li><a  href="${base_addr}/gtb/order/list" target="mainFrame">查询任务</a></li>
	                <li><a  href="${base_addr}/gtb/assignTask/toAssign" target="mainFrame">分配物料</a></li>
	                <li><a  href="${base_addr}/gtb/orderCounter/list" target="mainFrame">柜台任务查询</a></li>
	                <li><a  href="${base_addr}/gtb/assignTask/allocateErectorTask" target="mainFrame">安装工任务分配</a></li>
	                <li><a  href="${base_addr}/gtb/orderSetup/listErectorTask" target="mainFrame">安装任务单查询</a></li>
	                <li><a  href="${base_addr}/gtb/dailyOrder/list" target="mainFrame">日常补货列表</a></li>
	                <li><a  href="${base_addr}/gtb/dailyOrder/toEdit" target="mainFrame">日常补货提交</a></li>
	            </#if>
	            <#if Session.userRole.roleId?? && (Session.userRole.roleId == 1 || Session.userRole.roleId == 2 || Session.userRole.roleId == 3 || Session.userRole.roleId == 4)>
	        		<li><a  href="${base_addr}/gtb/orderSupplier/list" target="mainFrame">生产加工单管理</a></li>
	                <li><a  href="${base_addr}/gtb/orderPrice/list" target="mainFrame">报价单管理</a></li>
	                <li><a  href="${base_addr}/gtb/stock/list" target="mainFrame">库存管理</a></li>
	            </#if>
            </ul>
        </li>
        </#if>
    </ul>
</div>


</body></html>
