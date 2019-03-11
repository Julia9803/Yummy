<%--
  Created by IntelliJ IDEA.
  User: julia98
  Date: 2019/3/2
  Time: 上午12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="edu.nju.yummy.entity.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="edu.nju.yummy.entity.Address" %>
<%@ page import="edu.nju.yummy.entity.Restaurant" %>
<!doctype html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Amaze UI Admin index Examples</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <link rel="stylesheet" href="css/amazeui.min.css" />
    <link rel="stylesheet" href="css/admin.css">
    <link rel="stylesheet" href="css/app.css">
</head>

<body data-type="generalComponents">


<header class="am-topbar am-topbar-inverse admin-header">
    <div class="am-topbar-brand">
        <a href="javascript:;" class="tpl-logo">
            <img src="img/logo.png" alt="">
        </a>
    </div>
    <div class="am-icon-list tpl-header-nav-hover-ico am-fl am-margin-right">

    </div>

    <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span></button>

    <div class="am-collapse am-topbar-collapse" id="topbar-collapse">

        <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list tpl-header-list">

            <li class="am-hide-sm-only"><a href="javascript:;" id="admin-fullscreen" class="tpl-header-list-link"><span class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li>

            <li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
                <a class="am-dropdown-toggle tpl-header-list-link" href="javascript:;">
                    <span class="tpl-header-list-user-nick">禁言小张</span><span class="tpl-header-list-user-ico"> <img src="/img/user01.png"></span>
                </a>
                <ul class="am-dropdown-content">
                    <li><a href="#"><span class="am-icon-bell-o"></span> 资料</a></li>
                    <li><a href="#"><span class="am-icon-cog"></span> 设置</a></li>
                    <li><a href="#"><span class="am-icon-power-off"></span> 退出</a></li>
                </ul>
            </li>
            <li><a href="###" class="tpl-header-list-link"><span class="am-icon-sign-out tpl-header-list-ico-out-size"></span></a></li>
        </ul>
    </div>
</header>







<div class="tpl-page-container tpl-page-header-fixed">
    <div class="tpl-left-nav tpl-left-nav-hover">
        <div class="tpl-left-nav-title">
            操作列表
        </div>
        <div class="tpl-left-nav-list">
            <ul class="tpl-left-nav-menu">
                <li class="tpl-left-nav-item">
                    <a href="index.jsp" class="nav-link active">
                        <i class="am-icon-home"></i>
                        <span>首页</span>
                    </a>
                </li>
                <li class="tpl-left-nav-item">
                    <a href="chart.html" class="nav-link tpl-left-nav-link-list">
                        <i class="am-icon-bar-chart"></i>
                        <span>数据表</span>
                    </a>
                </li>

                <li class="tpl-left-nav-item">
                    <a href="/restaurantOrder" class="nav-link tpl-left-nav-link-list">
                        <i class="am-icon-table"></i>
                        <span>订单</span>
                    </a>
                </li>

                <li class="tpl-left-nav-item">
                    <a href="/restaurantPublish" class="nav-link tpl-left-nav-link-list">
                        <i class="am-icon-bell-o"></i>
                        <span>发布信息</span>
                    </a>
                </li>

                <li class="tpl-left-nav-item">
                    <a href="/restaurantEdit" class="nav-link tpl-left-nav-link-list">
                        <i class="am-icon-wpforms"></i>
                        <span>修改信息</span>
                    </a>
                </li>

                <li class="tpl-left-nav-item">
                    <a href="/restaurantLogin" class="nav-link tpl-left-nav-link-list">
                        <i class="am-icon-key"></i>
                        <span>登录</span>
                    </a>
                </li>

                <li class="tpl-left-nav-item">
                    <a href="/restaurantSignup" class="nav-link tpl-left-nav-link-list">
                        <i class="am-icon-lock"></i>
                        <span>注册</span>
                    </a>
                </li>
            </ul>
        </div>
    </div>





    <div class="tpl-content-wrapper">

        <div class="tpl-portlet-components">
            <div class="portlet-title">
                <div class="caption font-green bold">
                    <span class="am-icon-code"></span> 修改信息
                    <small><%=session.getAttribute("checkProcess")%></small>
                </div>
            </div>
            <div class="tpl-block ">

                <div class="am-g tpl-amazeui-form">


                    <div class="am-u-sm-12 am-u-md-9">
                        <form class="am-form am-form-horizontal" action="/restaurantE" method="post">
                            <div class="am-form-group" style="display: none">
                                <label for="idCode" class="am-u-sm-3 am-form-label">电子邮件 / Email</label>
                                <div class="am-u-sm-9">
                                    <%
                                        Restaurant restaurant = (Restaurant) session.getAttribute("restaurant");
                                    %>
                                    <input type="text" id="idCode" name="idCode" style="display: none" value="<%= restaurant.getIdCode()%>">
                                </div>
                            </div>

                            <div class="am-form-group">
                                <label for="name" class="am-u-sm-3 am-form-label">名称 / Name</label>
                                <div class="am-u-sm-9">
                                    <input type="text" id="name" name="name" value="<%= restaurant.getName()%>" placeholder="名称 / Name">
                                </div>
                            </div>

                            <div class="am-form-group">
                                <label for="type" class="am-u-sm-3 am-form-label">类型 / Type</label>
                                <div class="am-u-sm-9">
                                    <input type="text" id="type" name="type" value="<%= restaurant.getType()%>" placeholder="类型 / type">
                                </div>
                            </div>

                            <div class="am-form-group">
                                <label for="user-phone" class="am-u-sm-3 am-form-label">电话 / Telephone</label>
                                <div class="am-u-sm-9">
                                    <input type="tel" id="user-phone" name="phoneNumber" value="<%= restaurant.getPhoneNumber()%>" placeholder="输入你的电话号码 / Telephone">
                                </div>
                            </div>

                            <div class="am-form-group">
                                <label for="password" class="am-u-sm-3 am-form-label">密码 / Password</label>
                                <div class="am-u-sm-9">
                                    <input type="text" id="password" name="password" value="<%= restaurant.getPassword()%>" placeholder="输入你的密码 / password">
                                </div>
                            </div>

                        <%
                            Address address = (Address) session.getAttribute("address");
                            if(address != null) {
                        %>

                            <div class="am-form-group">
                                <label for="province" class="am-u-sm-3 am-form-label">省 / province</label>
                                <div class="am-u-sm-9">
                                    <input type="text" id="province" name="province" value="<%= address.getProvince()%>" placeholder="输入你的省份 / province">
                                </div>
                            </div>

                            <div class="am-form-group">
                                <label for="city" class="am-u-sm-3 am-form-label">市 / city</label>
                                <div class="am-u-sm-9">
                                    <input type="text" id="city" name="city" value="<%= address.getCity()%>" placeholder="输入你的城市 / city">
                                </div>
                            </div>

                            <div class="am-form-group">
                                <label for="district" class="am-u-sm-3 am-form-label">区 / district</label>
                                <div class="am-u-sm-9">
                                    <input type="text" id="district" name="district" value="<%= address.getDistrict()%>" placeholder="输入你的区 / district">
                                </div>
                            </div>

                            <div class="am-form-group">
                                <label for="detail" class="am-u-sm-3 am-form-label">街道门牌号 / detail</label>
                                <div class="am-u-sm-9">
                                    <input type="text" id="detail" name="detail" value="<%= address.getDetail()%>" placeholder="街道门牌号 / detail">
                                </div>
                            </div>

                            <div class="am-form-group">
                                <div class="am-u-sm-9 am-u-sm-push-3">
                                    <button type="submit" class="am-btn am-btn-primary">保存修改</button>
                                </div>
                            </div>
                        </form>
                        <%
                            }
                        %>
                    </div>
                </div>
            </div>

        </div>










    </div>

</div>


<script src="js/jquery.min.js"></script>
<script src="js/amazeui.min.js"></script>
<script src="js/app.js"></script>
</body>

</html>