<%@ page import="java.util.ArrayList" %>
<%@ page import="edu.nju.yummy.model.BagContent" %>
<%@ page import="edu.nju.yummy.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: julia98
  Date: 2019/2/27
  Time: 下午10:13
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
            <div class="portlet-title">
                <div class="caption font-green bold">
                    <span class="am-icon-code"></span> 购物车
                </div>

            </div>
            <div class="tpl-block">
                <div class="am-g">
                    <div class="am-u-sm-12">
                        <form class="am-form">
                            <table class="am-table am-table-striped am-table-hover table-main">
                                <thead>
                                <tr>
                                    <th>餐厅idCode</th>
                                    <th>食品Id</th>
                                    <th>食品名称</th>
                                    <th>食品类型</th>
                                    <th>食品单价</th>
                                    <th>选购数量</th>
                                </tr>
                                </thead>
                                <tbody>
                                <%

                                    ArrayList<BagContent> contents = (ArrayList<BagContent>) session.getAttribute("bag");
                                    if(contents.size() != 0) {
                                        for(BagContent content:contents) {
                                            String resIdCode = content.getIdCode();
                                            int foodId = content.getFoodId();
                                            String name = content.getName();
                                            String type = content.getType();
                                            double price = content.getPrice();
                                            int num = content.getOrderNum();

                                %>

                                <tr>
                                    <td><%=resIdCode%></td>
                                    <td><%=foodId%></td>
                                    <td><%=name%></td>
                                    <td><%=type%></td>
                                    <td><%=price%></td>
                                    <td><%=num%></td>
                                </tr>
                                <%
                                        }
                                    }
                                %>
                                </tbody>
                            </table>
                            <%
                                double orderMoney = (double) session.getAttribute("orderMoney");
                                double discount = (double) session.getAttribute("discount");
                                double totalMoney = orderMoney - discount;

                            %>
                            <div class="am-cf">

                                <div class="am-fr">
                                    原价：<label id="orderMoney"><%=orderMoney%></label>
                                    折扣：<label id="discount"><%=discount%></label>
                                    总价：<label id="totalMoney"><%=totalMoney%></label>
                                </div>
                            </div>
                            <script>

                            </script>
                            <hr>


                        </form>
                    </div>

                </div>
            </div>
            <div class="tpl-alert">
                <button type="button" onclick="submitOrder()" >提交订单</button>
                <script>
                    function submitOrder() {
                        var orderMoney = document.getElementById("orderMoney").innerText;
                        var discount = document.getElementById("discount").innerText;
                        var totalMoney = document.getElementById("totalMoney").innerText;

                        $.ajax({
                            url:"/order?orderMoney="+orderMoney+"&discount="+discount+"&totalMoney="+totalMoney,
                            complete: function() {
                                alert("订单已提交!");
                            }
                        })
                    }
                </script>
            </div>
        </div>










    </div>

</div>


<script src="js/jquery.min.js"></script>
<script src="js/amazeui.min.js"></script>
<script src="js/app.js"></script>
</body>

</html>
