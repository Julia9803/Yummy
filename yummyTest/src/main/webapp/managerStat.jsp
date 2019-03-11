<%@ page import="edu.nju.yummy.model.RestaurantStatistics" %>
<%@ page import="edu.nju.yummy.model.UserStatistics" %>
<%@ page import="edu.nju.yummy.model.CompanyFinance" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: julia98
  Date: 2019/3/10
  Time: 下午3:53
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
                    <a href="/managerStat" class="nav-link tpl-left-nav-link-list">
                        <i class="am-icon-table"></i>
                        <span>统计信息</span>
                    </a>
                </li>

                <li class="tpl-left-nav-item">
                    <a href="/managerCheckRes" class="nav-link tpl-left-nav-link-list">
                        <i class="am-icon-bell-o"></i>
                        <span>审核餐厅信息修改</span>
                    </a>
                </li>
            </ul>
        </div>
    </div>



    <div class="tpl-content-wrapper">
        <div class="tpl-portlet-components">
            <div class="am-u-md-6 am-u-sm-12">

                <div class="tpl-portlet">
                    <div class="portlet-title">
                        <div class="caption font-green bold">
                            <span class="am-icon-code"></span> 餐厅统计信息
                        </div>
                    </div>
                    <ul class="tpl-task-list">
                                <%
                                    RestaurantStatistics restaurantStatistics = (RestaurantStatistics) session.getAttribute("resStat");
                                %>
                                <li>
                                    <div class="task-title">
                                        <span class="task-title-sp"> 餐厅总数：<%=restaurantStatistics.getResNum()%> </span>
                                    </div>
                                    <div class="task-title">
                                        <span class="task-title-sp"> 每个餐厅平均订单数：<%=restaurantStatistics.getAverageOrderNum()%> </span>
                                    </div>
                                    <div class="task-title">
                                        <span class="task-title-sp"> 每个餐厅平均取消订单数：<%=restaurantStatistics.getAverageCancelRate()%> </span>
                                    </div>
                                    <%
                                        HashMap<String,Double> cancelRate = restaurantStatistics.getCancelRate();
                                        for(String key:cancelRate.keySet()) {
                                    %>
                                    <div class="task-title">
                                        <span class="task-title-sp"> 餐厅Id：<%=key%> 取消订单率：<%=cancelRate.get(key)%> </span>
                                    </div>
                                    <%
                                        }
                                        HashMap<String,Integer> orderNumber = restaurantStatistics.getOrderNumber();
                                        for(String key:orderNumber.keySet()) {
                                    %>
                                    <div class="task-title">
                                        <span class="task-title-sp"> 餐厅Id：<%=key%> 订单数：<%=orderNumber.get(key)%> </span>
                                    </div>
                                    <%
                                        }
                                    %>

                                </li>
                                <li>
                                        <button onclick="getResChart()">显示统计图</button>
                                        <div id="resChart1" style="width: 600px;height:400px;"></div>
                                        <div id="resChart2" style="width: 600px;height:400px;"></div>
                                        <script>
                                            function getResChart() {
                                                $.ajax({
                                                    url:"/managerStat/res",
                                                    type:"GET",
                                                    dataType:"json",
                                                    async:false,
                                                    success: function(data) {
                                                        let idCode = data.resIdCode;
                                                        let orderNumber = data.orderNumber;
                                                        let cancelRate = data.cancelRate;

                                                        let resChart1 = echarts.init(document.getElementById('resChart1'));
                                                        let option1 = {
                                                            title: {
                                                                text: '餐厅订单数量分布条形图'
                                                            },
                                                            tooltip: {},
                                                            legend: {
                                                                data: ['数量']
                                                            },
                                                            xAxis: {
                                                                data: idCode
                                                            },
                                                            yAxis: {},
                                                            series: [
                                                                {
                                                                name: '数量',
                                                                type: 'bar',
                                                                data: orderNumber
                                                                }
                                                            ]
                                                        };
                                                        resChart1.setOption(option1);

                                                        let resChart2 = echarts.init(document.getElementById('resChart2'));
                                                        let option2 = {
                                                            title: {
                                                                text: '餐厅订单取消率分布条形图'
                                                            },
                                                            tooltip: {},
                                                            legend: {
                                                                data: ['订单取消率']
                                                            },
                                                            xAxis: {
                                                                data: idCode
                                                            },
                                                            yAxis: {},
                                                            series: [
                                                                {
                                                                    name: '订单取消率',
                                                                    type: 'line',
                                                                    data: cancelRate
                                                                }
                                                            ]
                                                        };
                                                        resChart2.setOption(option2);

                                                    }
                                                })
                                            }
                                        </script>
                                </li>
                            </ul>
                </div>
            </div>
        </div>

        <div class="tpl-portlet-components">
            <div class="am-u-md-6 am-u-sm-12">

                <div class="tpl-portlet">
                    <div class="portlet-title">
                        <div class="caption font-green bold">
                            <span class="am-icon-code"></span> 会员统计信息
                        </div>
                    </div>
                    <ul class="tpl-task-list">
                                <%
                                    UserStatistics userStatistics = (UserStatistics) session.getAttribute("userStat");
                                %>
                                <li>
                                    <div class="task-title">
                                        <span class="task-title-sp"> 总用户数：<%=userStatistics.getUserNum()%> </span>
                                    </div>
                                    <div class="task-title">
                                        <span class="task-title-sp"> 平均下订单数：<%=userStatistics.getAverageOrderNum()%> </span>
                                    </div>
                                    <div class="task-title">
                                        <span class="task-title-sp"> 平均支付订单数：<%=userStatistics.getAveragePayedNum()%> </span>
                                    </div>
                                    <%
                                        HashMap<String,Double> paidRate = userStatistics.getPaidRate();
                                        for(String key:paidRate.keySet()) {
                                    %>
                                    <div class="task-title">
                                        <span class="task-title-sp"> 会员email：<%=key%> 支付订单率：<%=paidRate.get(key)%> </span>
                                    </div>
                                    <%
                                        }
                                        HashMap<Integer,Integer> gradeNumber = userStatistics.getGradeNumber();
                                        for(int key:gradeNumber.keySet()) {
                                    %>
                                    <div class="task-title">
                                        <span class="task-title-sp"> 级别：<%=key%> 对应人数：<%=gradeNumber.get(key)%> </span>
                                    </div>
                                    <%
                                        }
                                        HashMap<String,Integer> orderNumberU = userStatistics.getOrderNumber();
                                        for(String key:orderNumberU.keySet()) {
                                    %>
                                    <div class="task-title">
                                        <span class="task-title-sp"> 会员email：<%=key%> 下订单数：<%=orderNumberU.get(key)%> </span>
                                    </div>
                                    <%
                                        }
                                    %>
                                </li>
                                <li>
                                        <button onclick="getUserChart()">显示统计图</button>
                                        <div id="userChart1" style="width: 600px;height:400px;"></div>
                                        <div id="userChart2" style="width: 600px;height:400px;"></div>
                                        <div id="userChart3" style="width: 600px;height:400px;"></div>
                                        <script>
                                            function getUserChart() {
                                                $.ajax({
                                                    url: "/managerStat/user",
                                                    method: "GET",
                                                    async: false,
                                                    success: function(data) {
                                                        let uid = data.uid;
                                                        let paidRate = data.paidRate;
                                                        let grade = data.grade;
                                                        let userNumber = data.userNumber;
                                                        let orderNumber = data.orderNumber;

                                                        let userChart1 = echarts.init(document.getElementById('userChart1'));
                                                        let userOption1 = {
                                                            title: {
                                                                text: '用户取消订单率分布条形图'
                                                            },
                                                            tooltip: {},
                                                            legend: {
                                                                data: ['取消订单率']
                                                            },
                                                            xAxis: {
                                                                data: uid
                                                            },
                                                            yAxis: {},
                                                            series: [
                                                                {
                                                                    name: '取消订单率',
                                                                    type: 'line',
                                                                    data: paidRate
                                                                }
                                                            ]
                                                        };
                                                        userChart1.setOption(userOption1);

                                                        let userChart2 = echarts.init(document.getElementById('userChart2'));
                                                        let userOption2 = {
                                                            title: {
                                                                text: '用户订单数分布条形图'
                                                            },
                                                            tooltip: {},
                                                            legend: {
                                                                data: ['订单数']
                                                            },
                                                            xAxis: {
                                                                data: uid
                                                            },
                                                            yAxis: {},
                                                            series: [
                                                                {
                                                                    name: '订单数',
                                                                    type: 'bar',
                                                                    data: orderNumber
                                                                }
                                                            ]
                                                        };
                                                        userChart2.setOption(userOption2);

                                                        let userChart3 = echarts.init(document.getElementById('userChart3'));
                                                        let userOption3 = {
                                                            title: {
                                                                text: '用户级别分布条形图'
                                                            },
                                                            tooltip: {},
                                                            legend: {
                                                                data: ['用户数']
                                                            },
                                                            xAxis: {
                                                                data: grade
                                                            },
                                                            yAxis: {},
                                                            series: [
                                                                {
                                                                    name: '用户数',
                                                                    type: 'bar',
                                                                    data: userNumber
                                                                }
                                                            ]
                                                        };
                                                        userChart3.setOption(userOption3);
                                                    }
                                                })
                                            }
                                        </script>
                                </li>
                            </ul>
                </div>
            </div>
        </div>

        <div class="tpl-portlet-components">
            <div class="am-u-md-6 am-u-sm-12">

                <div class="tpl-portlet">
                    <div class="portlet-title">
                        <div class="caption font-green bold">
                            <span class="am-icon-code"></span> 公司财务统计信息
                        </div>
                    </div>
                    <ul class="tpl-task-list">
                                <%
                                    CompanyFinance companyFinance = (CompanyFinance) session.getAttribute("companyStat");
                                %>
                                <li>
                                    <div class="task-title">
                                        <span class="task-title-sp"> 总收入：<%=companyFinance.getTotalIncome()%> </span>
                                    </div>
                                    <%
                                        HashMap<String,Double> ridIncome = companyFinance.getRidIncome();
                                        for(String key:ridIncome.keySet()) {
                                    %>
                                    <div class="task-title">
                                        <span class="task-title-sp"> 餐厅Id：<%=key%> 收入额：<%=ridIncome.get(key)%> </span>
                                    </div>
                                    <%
                                        }
                                        HashMap<String,Double> uidPayment = companyFinance.getUidPayment();
                                        for(String key:uidPayment.keySet()) {
                                    %>
                                    <div class="task-title">
                                        <span class="task-title-sp"> 会员email：<%=key%> 支出额：<%=uidPayment.get(key)%> </span>
                                    </div>
                                    <%
                                        }
                                    %>
                                </li>
                                <li>
                                <button onclick="getCompanyChart()">显示统计图</button>
                                <div id="companyChart1" style="width: 600px;height:400px;"></div>
                                <div id="companyChart2" style="width: 600px;height:400px;"></div>
                                <script>
                                    function getCompanyChart() {
                                        $.ajax({
                                            url: "/managerStat/company",
                                            method: "GET",
                                            async: false,
                                            success: function(data) {
                                                let rid = data.rid;
                                                let income = data.income;
                                                let uid = data.uid;
                                                let payment = data.payment;

                                                let companyChart1 = echarts.init(document.getElementById('companyChart1'));
                                                let companyOption1 = {
                                                    title: {
                                                        text: '餐厅收入分布条形图'
                                                    },
                                                    tooltip: {},
                                                    legend: {
                                                        data: ['收入额']
                                                    },
                                                    xAxis: {
                                                        data: rid
                                                    },
                                                    yAxis: {},
                                                    series: [
                                                        {
                                                            name: '收入额',
                                                            type: 'bar',
                                                            data: income
                                                        }
                                                    ]
                                                };
                                                companyChart1.setOption(companyOption1);

                                                let companyChart2 = echarts.init(document.getElementById('companyChart2'));
                                                let companyOption2 = {
                                                    title: {
                                                        text: '用户支出分布条形图'
                                                    },
                                                    tooltip: {},
                                                    legend: {
                                                        data: ['支出额']
                                                    },
                                                    xAxis: {
                                                        data: uid
                                                    },
                                                    yAxis: {},
                                                    series: [
                                                        {
                                                            name: '支出额',
                                                            type: 'bar',
                                                            data: payment
                                                        }
                                                    ]
                                                };
                                                companyChart2.setOption(companyOption2);
                                            }
                                        })
                                    }
                                </script>
                                </li>
                            </ul>
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
