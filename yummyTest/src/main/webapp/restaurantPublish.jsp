<%@ page import="java.util.ArrayList" %>
<%@ page import="edu.nju.yummy.entity.Restaurant" %><%--
  Created by IntelliJ IDEA.
  User: julia98
  Date: 2019/2/28
  Time: 上午12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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




    <%
        Restaurant restaurant = (Restaurant) session.getAttribute("restaurant");
        String idCode = restaurant.getIdCode();
    %>
    <div class="tpl-content-wrapper">

        <div class="tpl-portlet-components">
        <div class="portlet-title">
            <div class="caption font-green bold">
                <span class="am-icon-code"></span> 发布单品信息
            </div>
        </div>
        <div class="tpl-block ">

            <div class="am-g tpl-amazeui-form">


                <div class="am-u-sm-12 am-u-md-9">
                    <form action="/publishSingle" method="post" class="am-form am-form-horizontal">
                        <input type="text" id="idCode" name="idCode" value="<%=idCode %>" style="display: none">
                        <div class="am-form-group">
                            <label for="type" class="am-u-sm-3 am-form-label">分类 / Type</label>
                            <div class="am-u-sm-9">
                                <select id="type" name="type" data-am-selected="{btnSize: 'sm'}">
                                    <option value="家常菜">家常菜</option>
                                    <option value="川菜">川菜</option>
                                    <option value="快餐">快餐</option>
                                    <option value="西餐">西餐</option>
                                    <option value="粤菜">粤菜</option>
                                    <option value="甜点">甜点</option>
                                </select>
                                <%--<input type="text" id="type" name="type" placeholder="分类 / Type">--%>
                            </div>
                        </div>

                        <div class="am-form-group">
                            <label for="type" class="am-u-sm-3 am-form-label">名字 / Name</label>
                            <div class="am-u-sm-9">
                                <input type="text" id="name" name="name" placeholder="名字 / Name">
                            </div>
                        </div>

                        <div class="am-form-group">
                            <label for="price" class="am-u-sm-3 am-form-label">价格 / Price</label>
                            <div class="am-u-sm-9">
                                <input type="text" id="price" name="price" placeholder="输入食品价格 / Price">
                            </div>
                        </div>

                        <div class="am-form-group">
                            <label for="totalNum" class="am-u-sm-3 am-form-label">数量 / Number</label>
                            <div class="am-u-sm-9">
                                <input type="text" id="totalNum" name="totalNum" placeholder="数量 / Number">
                            </div>
                        </div>

                        <div class="am-form-group">
                            <label for="price" class="am-u-sm-3 am-form-label">起始时间 / StartTime</label>
                            <div class="am-u-sm-9">
                                <input type="date" name="startTime" placeholder="输入起始时间 / StartTime">
                            </div>
                        </div>

                        <div class="am-form-group">
                            <label for="price" class="am-u-sm-3 am-form-label">终止时间 / EndTime</label>
                            <div class="am-u-sm-9">
                                <input type="date" name="endTime" placeholder="输入终止时间 / EndTime">
                            </div>
                        </div>

                        <div class="am-form-group">
                            <div class="am-u-sm-9 am-u-sm-push-3">
                                <button type="submit" class="am-btn am-btn-primary">提交</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>

    </div>








    </div>



    <div class="tpl-content-wrapper">

        <div class="tpl-portlet-components">
            <div class="portlet-title">
                <div class="caption font-green bold">
                    <span class="am-icon-code"></span> 发布套餐信息
                </div>
            </div>
            <div class="tpl-block ">

                <div class="am-g tpl-amazeui-form">


                    <div class="am-u-sm-12 am-u-md-9">
                        <form action="/publishCombo" method="post" class="am-form am-form-horizontal">
                            <input type="text" name="idCode" value="<%=idCode%>" style="display: none">
                            <div class="am-form-group">
                                <label for="name" class="am-u-sm-3 am-form-label">商品数量 / Num</label>
                                <div class="am-u-sm-9">
                                    <input type="text" name="num" onchange="addNum(this.value)" placeholder="商品数量 / Num">
                                </div>
                            </div>
                            <div id="names">

                                <script>
                                    function addNum(num) {
                                        var div = document.getElementById("names");
                                        div.innerHTML = "";
                                        for (let i = 0; i < num; i++) {
                                            div.innerHTML += '                                <div class="am-form-group">\n' +
                                                '                                    <label for="name" class="am-u-sm-3 am-form-label">名字 / Name</label>\n' +
                                                '                                    <div class="am-u-sm-9">\n' +
                                                '                                        <input type="text" name="name'+i+'" placeholder="姓名 / Name">\n' +
                                                '                                    </div>\n' +
                                                '                                </div>';
                                        }
                                    }
                                </script>

                            </div>

                            <div class="am-form-group">
                                <label for="price" class="am-u-sm-3 am-form-label">价格 / Price</label>
                                <div class="am-u-sm-9">
                                    <input type="text" name="price" placeholder="输入食品价格 / Price">
                                </div>
                            </div>

                            <div class="am-form-group">
                                <label for="price" class="am-u-sm-3 am-form-label">套餐数量 / Num</label>
                                <div class="am-u-sm-9">
                                    <input type="text" name="totalNum" placeholder="套餐数量 / Num">
                                </div>
                            </div>

                            <div class="am-form-group">
                                <label for="price" class="am-u-sm-3 am-form-label">起始时间 / StartTime</label>
                                <div class="am-u-sm-9">
                                    <input type="date" name="startTime" placeholder="输入起始时间 / StartTime">
                                </div>
                            </div>

                            <div class="am-form-group">
                                <label for="price" class="am-u-sm-3 am-form-label">终止时间 / EndTime</label>
                                <div class="am-u-sm-9">
                                    <input type="date" name="endTime" placeholder="输入终止时间 / EndTime">
                                </div>
                            </div>

                            <div class="am-form-group">
                                <div class="am-u-sm-9 am-u-sm-push-3">
                                    <button type="submit" class="am-btn am-btn-primary">提交</button>
                                </div>
                            </div>
                        </form>
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
