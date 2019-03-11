<%@ page import="edu.nju.yummy.entity.Address" %>
<%@ page import="edu.nju.yummy.entity.OrderFood" %>
<%@ page import="edu.nju.yummy.model.HistoryOrderPresent" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: julia98
  Date: 2019/3/7
  Time: 上午10:38
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
    <script src="js/echarts.min.js"></script>
</head>

<body data-type="index">


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
                    <a href="/userHistoryOrder" class="nav-link tpl-left-nav-link-list">
                        <i class="am-icon-table"></i>
                        <span>历史订单</span>
                    </a>
                </li>

                <li class="tpl-left-nav-item">
                    <a href="/userOrder" class="nav-link tpl-left-nav-link-list">
                        <i class="am-icon-table"></i>
                        <span>订单</span>
                    </a>
                </li>

                <li class="tpl-left-nav-item">
                    <a href="/userMakeOrder" class="nav-link tpl-left-nav-link-list">
                        <i class="am-icon-bell-o"></i>
                        <span>下订单</span>
                    </a>
                </li>

                <li class="tpl-left-nav-item">
                    <a href="/useredit" class="nav-link tpl-left-nav-link-list">
                        <i class="am-icon-wpforms"></i>
                        <span>修改信息</span>
                    </a>
                </li>

                <li class="tpl-left-nav-item">
                    <a href="/userLogin" class="nav-link tpl-left-nav-link-list">
                        <i class="am-icon-key"></i>
                        <span>登录</span>
                    </a>
                </li>

                <li class="tpl-left-nav-item">
                    <a href="/userSignup" class="nav-link tpl-left-nav-link-list">
                        <i class="am-icon-lock"></i>
                        <span>注册</span>
                    </a>
                </li>
            </ul>
        </div>
    </div>


    <div class="tpl-content-wrapper">
        <div class="tpl-portlet-components">
            <div class="am-u-md-6 am-u-sm-12 row-mb">

                <div class="tpl-portlet">
                    <div class="portlet-title">
                        <div class="caption font-green bold">
                            <span class="am-icon-code"></span> 历史订单
                        </div>
                    </div>
                    <div id="wrapper" class="wrapper">
                        <div id="scroller" class="scroller">
                            <select id="type" name="type" onchange="window.location='/userHistoryOrder?type='+this.value" data-am-selected="{btnSize: 'sm'}">
                                <option value="1">点餐按照时间统计</option>
                                <option value="2">点餐按照金额统计</option>
                                <option value="3">点餐按照餐厅统计</option>
                                <option value="4">退订按照时间统计</option>
                                <option value="5">退订按照金额统计</option>
                                <option value="6">退订按照餐厅统计</option>
                                <option value="7">消费按照时间统计</option>
                                <option value="8">消费按照金额统计</option>
                                <option value="9">消费按照餐厅统计</option>
                            </select>
                            <ul class="tpl-task-list">
                                <%
                                    ArrayList<HistoryOrderPresent> presents = (ArrayList<HistoryOrderPresent>) session.getAttribute("orderPresent");
                                    for(HistoryOrderPresent present:presents) {
                                %>
                                <li>
                                    <div class="task-title">
                                        <span class="task-title-sp"> 订单号：<%=present.getOrderId()%> </span>
                                    </div>
                                </li>
                                <li>
                                    <div class="task-title">
                                        <span class="task-title-sp"> 用户手机号码：<%=present.getUserPhone()%> </span>
                                    </div>
                                </li>
                                <li>
                                    <div class="task-title">
                                        <span class="task-title-sp"> 餐厅编码：<%=present.getRestaurantIdCode()%> </span>
                                    </div>
                                </li>
                                <%
                                    Address address = present.getUserAddress();
                                %>
                                <li>
                                    <div class="task-title">
                                        <span class="task-title-sp"> 用户地址：<%=address.getProvince()%>省 <%=address.getCity()%>市 <%=address.getDistrict()%>区 <%=address.getDetail()%> </span>
                                    </div>
                                </li>
                                <li>
                                    <div class="task-title">
                                        <span class="task-title-sp"> 下单时间：<%=present.getTime()%> </span>
                                    </div>
                                </li>
                                <li>
                                    <div class="task-title">
                                        <span class="task-title-sp"> 订单状态：<%=present.getDeliverState()%> </span>
                                    </div>
                                </li>
                                <%
                                    ArrayList<OrderFood> foods = present.getFoods();
                                    for(OrderFood food:foods) {
                                %>
                                <li>
                                    <div class="task-title">
                                        <span class="task-title-sp"> 食品Id：<%=food.getFoodId()%> </span>
                                    </div>
                                </li>
                                <li>
                                    <div class="task-title">
                                        <span class="task-title-sp"> 食品种类：<%=food.getType()%> </span>
                                    </div>
                                </li>
                                <li>
                                    <div class="task-title">
                                        <span class="task-title-sp"> 食品名称：<%=food.getName()%> </span>
                                    </div>
                                </li>
                                <li>
                                    <div class="task-title">
                                        <span class="task-title-sp"> 食品单价：<%=food.getPrice()%> </span>
                                    </div>
                                </li>
                                <li>
                                    <div class="task-title">
                                        <span class="task-title-sp"> 食品数量：<%=food.getOrderNum()%> </span>
                                    </div>
                                </li>
                                <%
                                    }
                                %>
                                <li>
                                    <div class="task-title">
                                        <span class="task-title-sp"> 原价：<%=present.getOrderMoney()%> </span>
                                    </div>
                                </li>
                                <li>
                                    <div class="task-title">
                                        <span class="task-title-sp"> 折后价：<%=present.getTotalMoney()%> </span>
                                    </div>
                                </li>
                                <%
                                    if(!present.isCancelled()) {
                                %>
                                <li>
                                    <div class="task-title">
                                        <button onclick="cancelOrder(<%=present.getOrderId()%>)">取消订单</button>
                                    </div>
                                </li>
                                <%
                                } else {
                                %>
                                <li>
                                    <div class="task-title">
                                        <span class="task-title-sp">已取消订单</span>
                                    </div>
                                </li>
                                <%
                                    }
                                %>

                                <%
                                    if(!present.isPayed() && !present.isCancelled()) {
                                %>
                                <li>
                                    <div class="task-title">
                                        <button onclick="pay(<%=present.getOrderId()%>)">付款</button>
                                    </div>
                                </li>
                                <%
                                } else if(present.isPayed() && !present.isCancelled()) {
                                %>
                                <li>
                                    <div class="task-title">
                                        <span class="task-title-sp">已付款</span>
                                    </div>
                                </li>
                                <%
                                    }
                                %>

                                <%
                                    if(!present.isEnsureDelivered() && !present.isCancelled()) {
                                %>
                                <li>
                                    <div class="task-title">
                                        <button onclick="ensureReceived(<%=present.getOrderId()%>)">确认收货</button>
                                    </div>
                                </li>
                                <%
                                    } else if(present.isEnsureDelivered()){
                                %>
                                <li>
                                    <div class="task-title">
                                        <span class="task-title-sp">已确认收货</span>
                                    </div>
                                </li>
                                <%
                                    }
                                %>
                                <br>
                                <br>
                                <%
                                    }
                                %>

                            </ul>
                            <script>
                                function cancelOrder(oid) {
                                    $.ajax({
                                        url:"/userOrder/cancel?oid="+oid,
                                        success: function (data) {
                                            alert(data);
                                        }
                                    })
                                }

                                function ensureReceived(oid) {
                                    $.ajax({
                                        url:"/userOrder/ensure?oid="+oid,
                                        complete: function(msg) {
                                            history.go(0);
                                        }
                                    })
                                }

                                function pay(oid) {
                                    window.location = "/userPay?oid="+oid;
                                }
                            </script>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>










    </div>


</div>


<script src="js/jquery.min.js"></script>
<script src="js/amazeui.min.js"></script>
<script src="js/iscroll.js"></script>
<script src="js/app.js"></script>
</body>

</html>
