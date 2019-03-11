<%@ page import="java.util.ArrayList" %>
<%@ page import="edu.nju.yummy.model.RestaurantPresent" %><%--
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
        <%
            ArrayList<RestaurantPresent> presents = (ArrayList<RestaurantPresent>) session.getAttribute("presents");
            int size = 0;
            for(RestaurantPresent present:presents) {
                String idCode = present.getIdCode();
        %>
        <div class="row">
            <div class="am-u-md-12 am-u-sm-12 row-mb">
                <div class="tpl-portlet">
                    <div class="tpl-portlet-title">
                        <div class="tpl-caption font-red ">
                            <i class="am-icon-bar-chart"></i>
                            <span><%=present.getResName()%></span>
                        </div>
                    </div>
                    <div class="tpl-scrollable">

                        <table class="am-table tpl-table">
                            <thead>
                            <tr class="tpl-table-uppercase">
                                <th>食品Id</th>
                                <th>食品名称</th>
                                <th>食品类型</th>
                                <th>食品总量</th>
                                <th>食品单价</th>
                                <th>选购数量</th>
                                <th>加入购物车</th>
                            </tr>
                            </thead>
                            <tbody>
                            <%
                                for (int i = 0; i < present.getFoodIds().size(); i++) {
                                    int foodId = present.getFoodIds().get(i);
                                    String name = present.getFoodNames().get(i);
                                    String type = present.getFoodTypes().get(i);
                                    int totalNum = present.getFoodNums().get(i);
                                    double price = present.getFoodPrices().get(i);
                                    int k = i + size + 1;
                            %>
                            <tr>
                                <td>
                                    <input type="number" id="idCode<%=k%>" name="foodId" value="<%=idCode%>" style="display:none;" readonly>
                                    <input type="number" id="foodId<%=k%>" name="foodId" value="<%=foodId%>" readonly>
                                </td>
                                <td>
                                    <input type="text" id="name<%=k%>" name="name" value="<%=name%>" readonly>
                                </td>
                                <td>
                                    <input type="text" id="type<%=k%>" name="type" value="<%=type%>" readonly>
                                </td>
                                <td>
                                    <input type="number" id="totalNum<%=k%>" name="totalNum" value="<%=totalNum%>" readonly>
                                </td>
                                <td>
                                    <input type="text" id="price<%=k%>" name="price" value="<%=price%>" readonly>
                                </td>
                                <td>
                                    <input type="number" id="orderNum<%=k%>" name="orderNum">
                                </td>
                                <td>
                                    <button type="button" class="am-btn am-btn-default" onclick="addBag(<%=k%>)">添加</button>
                                </td>
                            </tr>
                            <%
                                }
                            %>
                            <%
                                for (int i = 0; i < present.getComboFoodIds().size(); i++) {
                                    int foodId = present.getComboFoodIds().get(i);
                                    String name = present.getComboFoodNames().get(i);
                                    String type = "套餐";
                                    int totalNum = present.getComboFoodNums().get(i);
                                    double price = present.getComboFoodPrices().get(i);
                                    int j = i + size + present.getFoodIds().size();
                            %>
                            <tr>
                                <td>
                                    <input type="text" id="idCode<%=j%>" name="foodId" value="<%=idCode%>" style="display:none;" readonly>
                                    <input type="text" id="foodId<%=j%>" name="foodId" value="<%=foodId%>" readonly>
                                </td>
                                <td>
                                    <input type="text" id="name<%=j%>" name="name" value="<%=name%>" readonly>
                                </td>
                                <td>
                                    <input type="text" id="type<%=j%>" name="type" value="<%=type%>" readonly>
                                </td>
                                <td>
                                    <input type="text" id="totalNum<%=j%>" name="totalNum" value="<%=totalNum%>" readonly>
                                </td>
                                <td>
                                    <input type="text" id="price<%=j%>" name="price" value="<%=price%>" readonly>
                                </td>
                                <td>
                                    <input type="number" id="orderNum<%=j%>" name="orderNum">
                                </td>
                                <td>
                                    <button type="button" class="am-btn am-btn-default" onclick="addBag(<%=j%>)">添加</button>
                                </td>
                            </tr>
                            <%
                                }
                            %>

                            <script>
                                function addBag(i) {
                                    let idCode = document.getElementById("idCode"+i).value;
                                    let foodId = document.getElementById("foodId"+i).value;
                                    let name = document.getElementById("name"+i).value;
                                    let type = document.getElementById("type"+i).value;
                                    let totalNum = document.getElementById("totalNum"+i).value;
                                    let price = document.getElementById("price"+i).value;
                                    let orderNum = document.getElementById("orderNum"+i).value;
                                    if(parseInt(orderNum)>parseInt(totalNum)) {
                                        alert("不可超卖!");
                                        return;
                                    }
                                    $.ajax({
                                        url:"/userMakeOrder/addBag?idCode="+idCode+"&foodId="+foodId+"&name="+name+"&type="+type+"&totalNum="+totalNum+"&price="+price+"&orderNum="+orderNum,
                                        complete: function(msg) {
                                            alert("添加成功!");
                                        }
                                    })
                                }
                            </script>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>


        </div>
        <%
                size ++;
            }
        %>


    </div>

</div>


<script src="js/jquery.min.js"></script>
<script src="js/amazeui.min.js"></script>
<script src="js/iscroll.js"></script>
<script src="js/app.js"></script>
</body>
</html>
