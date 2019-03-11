<%@ page import="java.util.ArrayList" %>
<%@ page import="edu.nju.yummy.entity.Restaurant" %>
<%@ page import="edu.nju.yummy.model.ResCheck" %><%--
  Created by IntelliJ IDEA.
  User: julia98
  Date: 2019/3/2
  Time: 下午2:20
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
            <div class="portlet-title">
                <div class="caption font-green bold">
                    <span class="am-icon-code"></span> 列表
                </div>
            </div>
            <div class="tpl-block">
                <div class="am-g">
                    <div class="am-u-sm-12">
                        <form class="am-form">
                            <table class="am-table am-table-striped am-table-hover table-main">
                                <thead>
                                <tr>
                                    <th class="table-id">编码</th>
                                    <th class="table-title">名称</th>
                                    <th class="table-type">类别</th>
                                    <th class="table-author am-hide-sm-only">省份</th>
                                    <th class="table-date am-hide-sm-only">市</th>
                                    <th class="table-date am-hide-sm-only">区</th>
                                    <th class="table-date am-hide-sm-only">具体</th>
                                    <th class="table-set">审核</th>
                                </tr>
                                </thead>
                            </table>
                        </form>
                        <%
                            ArrayList<ResCheck> resChecks = (ArrayList<ResCheck>) session.getAttribute("resChecks");
                            if(resChecks.size() != 0) {
                                for(ResCheck resCheck:resChecks) {
                        %>
                        <form class="am-form">
                            <table class="am-table am-table-striped am-table-hover table-main">
                            <tbody>
                                <tr>
                                    <td><%=resCheck.getIdCode()%></td>
                                    <td><a href="#"><%=resCheck.getName()%></a></td>
                                    <td><%=resCheck.getType()%></td>
                                    <td class="am-hide-sm-only"><%=resCheck.getAddress().getChangeProvince()%></td>
                                    <td class="am-hide-sm-only"><%=resCheck.getAddress().getChangeCity()%></td>
                                    <td class="am-hide-sm-only"><%=resCheck.getAddress().getChangeDistrict()%></td>
                                    <td class="am-hide-sm-only"><%=resCheck.getAddress().getChangeDetail()%></td>
                                    <td>
                                        <div class="am-btn-toolbar">
                                            <div class="am-btn-group am-btn-group-xs">
                                                <button onclick="checkOK('<%=resCheck.getIdCode()%>')" class="am-btn am-btn-default am-btn-xs am-text-secondary"><span class="am-icon-pencil-square-o"></span> 通过</button>
                                                <button onclick="checkFail('<%=resCheck.getIdCode()%>')" class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"><span class="am-icon-trash-o"></span> 拒绝</button>
                                            </div>
                                        </div>
                                    </td>
                                    <script>
                                        function checkOK(idCode) {
                                            $.ajax({
                                                url:"/checkOK?idCode="+idCode,
                                                method:"post"
                                            })
                                        }
                                        function checkFail(idCode) {
                                            $.ajax({
                                                url:"/checkFail?idCode="+idCode,
                                                method:"post"
                                            })
                                        }
                                    </script>
                                </tr>
                            </tbody>
                            </table>
                        </form>
                        <%
                                }
                            }
                        %>
                            <hr>
                    </div>

                </div>
            </div>
            <div class="tpl-alert"></div>
        </div>










    </div>

</div>


<script src="js/jquery.min.js"></script>
<script src="js/amazeui.min.js"></script>
<script src="js/app.js"></script>
</body>
</html>