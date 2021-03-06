<%--
  Created by IntelliJ IDEA.
  User: hori
  Date: 2019/6/21
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>医疗设备检修预警系统</title>
    <link rel="stylesheet" href="layui/css/layui.css">
    <script type="text/javascript" src="jquery/jquery3.4.1.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#mainFrame").load("welcome.html");
        });
        function loadUserAnalysis() {
            $("#mainFrame").load("userAnalysis.html");
        }
        function loadUserManagePage() {
            $("#mainFrame").load("userManage.html");
        }
        function loadPersonCenterPage() {
            $("#mainFrame").load("personCenter.html");
        }
        function loadepuipmentCenterPage() {
            $("#mainFrame").load("equipmentManage2.html");
        }
        function loadepuipmentCenterPage2() {
            $("#mainFrame").load("equipmentManage3.html");
        }
        function loadjournalCenterPage() {
            $("#mainFrame").load("journal.html");
        }
    </script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo" style="color: white">医疗设备检修预警系统</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <!-- <ul class="layui-nav layui-layout-left">
             <li class="layui-nav-item"><a href="">控制台</a></li>
             <li class="layui-nav-item"><a href="">商品管理</a></li>
             <li class="layui-nav-item"><a href="">用户</a></li>
             <li class="layui-nav-item">
                 <a href="javascript:;">其它系统</a>
                 <dl class="layui-nav-child">
                     <dd><a href="">邮件管理</a></dd>
                     <dd><a href="">消息管理</a></dd>
                     <dd><a href="">授权管理</a></dd>
                 </dl>
             </li>
         </ul>-->
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    张三
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:loadPersonCenterPage()"><span class="layui-icon layui-icon-user"></span> 基本资料</a></dd>
                    <dd><a href=""><span class="layui-icon layui-icon-password"></span> 修改密码</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="">退出系统</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;"><span class="layui-icon layui-icon-user"></span> 所有用户</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:loadUserManagePage();"><span class="layui-icon layui-icon-app"></span> 用户管理</a></dd>
                        <dd><a href="javascript:loadUserAnalysis();"><span class="layui-icon layui-icon-chart-screen"></span> 统计分析</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a href="javascript:;"><span class="layui-icon layui-icon-cellphone"></span> 所有设备</a>
                    <dl class="layui-nav-child">
                        <c:if test="${user.role eq '管理员' || user.role eq '职员'}">
                            <dd><a href="javascript:loadepuipmentCenterPage();"><span class="layui-icon layui-icon-camera"></span> 设备管理</a></dd>
                        </c:if>
                        <c:if test="${user.role eq '检修员'}">
                            <dd><a href="javascript:loadepuipmentCenterPage2();"><span class="layui-icon layui-icon-camera"></span> 设备管理</a></dd>
                        </c:if>
                        <dd><a href="javascript:;"><span class="layui-icon layui-icon-chart-screen"></span> 统计分析</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a href="javascript:;"><span class="layui-icon layui-icon-water"></span> 检修日志</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:loadjournalCenterPage();"><span class="layui-icon layui-icon-date"></span> 日志管理</a></dd>
                        <dd><a href="javascript:;"><span class="layui-icon layui-icon-chart-screen"></span> 统计分析</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a href="javascript:;"><span class="layui-icon layui-icon-group"></span> 所有供应商</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;"><span class="layui-icon layui-icon-set-fill"></span> 供应商管理</a></dd>
                        <dd><a href="javascript:;"><span class="layui-icon layui-icon-chart"></span> 统计分析</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;"><span class="layui-icon layui-icon-engine"></span> 系统管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;"><span class="layui-icon layui-icon-survey"></span> 权限分配</a></dd>
                        <dd><a href="javascript:;"><span class="layui-icon layui-icon-prev"></span> 注销系统</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;" id="mainFrame">内容主体区域</div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        &copy;2019-2020 融创软通科技股份
    </div>
</div>
<script src="layui/layui.all.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
</script>
</body>
</html>
