<%--
  Created by IntelliJ IDEA.
  User: mahua
  Date: 2018/1/29
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Amaze UI Admin index Examples</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath}/assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <script src="${pageContext.request.contextPath}/assets/js/echarts.min.js"></script>
    <link rel="stylesheet" href="http://cdn.amazeui.org/amazeui/2.7.2/css/amazeui.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/amazeui.datatables.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/app.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/dialog.css">
    <script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>

<body data-type="widgets">
<script src="${pageContext.request.contextPath}/assets/js/theme.js"></script>
<div class="am-g tpl-g">
    <!-- 头部 -->
    <header>
        <!-- logo -->
        <div class="am-fl tpl-header-logo">
            <a href="${pageContext.request.contextPath}/jsp/index.jsp"><img src="${pageContext.request.contextPath}/assets/img/logo.png" alt=""></a>
        </div>
        <!-- 右侧内容 -->
        <div class="tpl-header-fluid">
            <!-- 侧边切换 -->
            <div class="am-fl tpl-header-switch-button am-icon-list">
                    <span>

                </span>
            </div>

            <!-- 其它功能-->
            <div class="am-fr tpl-header-navbar">
                <ul>
                    <!-- 欢迎语 -->
                    <li class="am-text-sm tpl-header-navbar-welcome">
                        <a href="javascript:;">欢迎你, <span id="welcomeName1"></span> </a>
                    </li>

                    <!-- 退出 -->
                    <li class="am-text-sm">
                        <a href="href="${pageContext.request.contextPath}/jsp/login.jsp"">
                            <span class="am-icon-sign-out"></span> 退出
                        </a>
                    </li>
                </ul>
            </div>
        </div>

    </header>
    <!-- 风格切换 -->
    <div class="tpl-skiner">
        <div class="tpl-skiner-toggle am-icon-cog">
        </div>
        <div class="tpl-skiner-content">
            <div class="tpl-skiner-content-title">
                选择主题
            </div>
            <div class="tpl-skiner-content-bar">
                <span class="skiner-color skiner-white" data-color="theme-white"></span>
                <span class="skiner-color skiner-black" data-color="theme-black"></span>
            </div>
        </div>
    </div>
    <!-- 侧边导航栏 -->
    <div class="left-sidebar">
        <!-- 用户信息 -->
        <div class="tpl-sidebar-user-panel">
            <div class="tpl-user-panel-slide-toggleable">
                <div class="tpl-user-panel-profile-picture">
                    <img src="${pageContext.request.contextPath}/assets/img/user04.png" alt="">
                </div>
                <span class="user-panel-logged-in-text">
              <i class="am-icon-circle-o am-text-success tpl-user-panel-status-icon"></i>
                        <p id="welcomeName2"></p></span>
            </div>
        </div>

        <!-- 菜单 -->
        <ul class="sidebar-nav">
            <li class="sidebar-nav-link">
                <a href="user.jsp">
                    <i class="am-icon-table sidebar-nav-link-logo"></i> 用户管理
                </a>
            </li>
            <li class="sidebar-nav-link">
                <a href="economic.jsp" class="active">
                    <i class="am-icon-calendar sidebar-nav-link-logo"></i> 经济状况管理
                </a>
            </li>
            <li class="sidebar-nav-link">
                <a href="happen.jsp">
                    <i class="am-icon-wpforms sidebar-nav-link-logo"></i> 发展情况管理

                </a>
            </li>
            <li class="sidebar-nav-link">
                <a href="monthly.jsp">
                    <i class="am-icon-bar-chart sidebar-nav-link-logo"></i> 季度情况管理

                </a>
            </li>
        </ul>
    </div>

    <!-- 内容区域 -->
    <div class="tpl-content-wrapper">

        <div class="container-fluid am-cf">
            <div class="row">
                <div class="am-u-sm-12 am-u-md-12 am-u-lg-9">
                    <div class="page-header-heading"><span class="am-icon-home page-header-heading-icon"> 地区年度经济</span></div>
                    <p class="page-header-description">以下数据仅做演示，不保证数据准确性</p>
                </div>
            </div>

        </div>

        <div class="row-content am-cf">
            <div class="row">
                <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                    <div class="widget am-cf">
                        <div class="widget-head am-cf">
                            <div class="widget-title am-fl">数据表格</div>
                        </div>
                        <div class="widget-body  widget-body-lg am-fr">

                            <table  class="page-header-description am-table am-table-bordered am-table-radius am-table-striped am-table-centered am-text-nowrap am-text-middle"
                                    id="economicList">
                                <thead>
                                <tr>
                                    <th>地区</th>
                                    <th>年份</th>
                                    <th>地区生产总值(亿元)</th>
                                    <th>第一产业增加值(亿元)</th>
                                    <th>第二产业增加值(亿元)</th>
                                    <th>第三产业增加值(亿元)</th>
                                    <th>财政收入</th>
                                    <th>人均可支配收入</th>
                                    <th>GDP增长率</th>
                                    <th>第一产业增长率</th>
                                    <th>第二产业增长率</th>
                                    <th>第三产业增长率</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <!-- more data -->
                                </tbody>
                            </table>
                        </div>
                        <div class="am-u-lg-12 am-cf">
                            <div class="am-fr">
                                <ul id="barcon" class="am-pagination tpl-pagination">
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Modal -->
    <div class="am-modal am-modal-prompt" tabindex="-1" id="my-prompt">
        <div class="am-modal-dialog">
            <div class="am-modal-hd">经济状况编辑</div>
            <div class="am-modal-bd">
                <form id="economic" class="am-form tpl-form-line-form">
                    <div class="am-form-group">
                        <label for="year">年：</label>
                        <input  type="text" class="tpl-form-input" id="year"  name="year" placeholder="请输入年"
                                required="required" style="width: 690px" readonly="readonly" >
                    </div>

                    <div class="am-form-group">
                        <label for="areaCode">地区：</label>
                        <input type="text" class="tpl-form-input" id="areaCode" name="areaCode" readonly="readonly"
                               required="required" style="width: 675px">
                    </div>

                    <div class="am-form-group">
                        <label for="gdp">地区生产总值(亿元)：</label>
                        <input type="text" class="tpl-form-input" id="gdp" name="gdp" placeholder="请输入密码"
                               required="required" style="width: 565px">
                    </div>

                    <div class="am-form-group">
                        <label for="primary">第一产业增加值(亿元):</label>
                        <input type="text" class="tpl-form-input" id="primary" name="primary" placeholder="请输入值"
                               required="required" style="width: 560px;padding-left:4px">
                    </div>

                    <div class="am-form-group">
                        <label for="second">第二产业增加值(亿元):</label>
                        <input type="text" class="tpl-form-input" id="second" name="second" placeholder="请输入值"
                               required="required" style="width: 560px;padding-left:4px">
                    </div>

                    <div class="am-form-group">
                        <label for="third">第三产业增加值(亿元):</label>
                        <input type="text" class="tpl-form-input" id="third" name="third" placeholder="请输入值"
                               required="required" style="width: 560px;padding-left:4px">
                    </div>
                    <div class="am-form-group">
                        <label for="taxRevenue">财政收入(亿元):</label>
                        <input type="text" class="tpl-form-input" id="taxRevenue" name="taxRevenue" placeholder="请输入值"
                               required="required" style="width: 608px ; padding-left:4px">
                    </div>
                    <div class="am-form-group">
                        <label for="disposableIncome">人均可支配收入(元):</label>
                        <input type="text" class="tpl-form-input" id="disposableIncome" name="disposableIncome" placeholder="请输入值"
                               required="required" style="width: 578px ; padding-left:4px">
                    </div>
                    <div class="am-form-group">
                        <label for="gdpRate">GDP增长率:</label>
                        <input type="text" class="tpl-form-input" id="gdpRate" name="gdpRate" placeholder="请输入值"
                               required="required" style="width: 635px ; padding-left:4px">
                    </div>

                    <div class="am-form-group">
                        <label for="primaryRate">第一产业增长率:</label>
                        <input type="text" class="tpl-form-input" id="primaryRate" name="primaryRate" placeholder="请输入值"
                               required="required" style="width: 600px ; padding-left:4px">
                    </div>

                    <div class="am-form-group">
                        <label for="secondRate">第二产业增长率:</label>
                        <input type="text" class="tpl-form-input" id="secondRate" name="secondRate" placeholder="请输入值"
                               required="required" style="width: 600px ; padding-left:4px">
                    </div>

                    <div class="am-form-group">
                        <label for="thirdRate">第一产业增长率:</label>
                        <input type="text" class="tpl-form-input" id="thirdRate" name="thirdRate" placeholder="请输入值"
                               required="required" style="width: 600px; padding-left:4px">
                    </div>

                    <button id="submit" class="am-btn am-btn-primary btn-loading-example" type="button" form="user" value="确定">确定</button>
                    <button id="cancel" class="am-btn am-btn-primary btn-loading-example" type="button" form="user" value="取消">取消</button>
                </form>
            </div>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/assets/js/amazeui.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/amazeui.datatables.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/dataTables.responsive.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/app.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/economic.js"></script>
</body>

</html>
