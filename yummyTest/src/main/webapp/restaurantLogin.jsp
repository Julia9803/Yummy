<%--
  Created by IntelliJ IDEA.
  User: julia98
  Date: 2019/3/1
  Time: 下午9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

<body data-type="login">

<div class="am-g myapp-login">
    <div class="myapp-login-logo-block  tpl-login-max">
        <div class="myapp-login-logo-text">
            <div class="myapp-login-logo-text">
                RESTAURANT<span> Login</span> <i class="am-icon-skyatlas"></i>

            </div>
        </div>
        <small><%=session.getAttribute("res")%></small>

        <div class="am-u-sm-10 login-am-center">
            <form class="am-form" action="/restaurant" method="get">
                <fieldset>
                    <div class="am-form-group">
                        <input type="text" class="" name="code" id="doc-ipt-email-1" placeholder="输入七位识别码">
                    </div>
                    <div class="am-form-group">
                        <input type="password" class="" name="password" id="doc-ipt-pwd-1" placeholder="输入密码">
                    </div>
                    <p><button type="submit" class="am-btn am-btn-default">登录</button></p>
                </fieldset>
            </form>
        </div>
    </div>
</div>

<script src="js/jquery.min.js"></script>
<script src="js/amazeui.min.js"></script>
<script src="js/app.js"></script>
</body>

</html>