<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: mahua
  Date: 2018/1/15
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
商品列表：
<table width="100%" broder="1">
    <tr>
        <td>Name</td>
        <td>Sex</td>
        <td>Date</td>
        <td>Address</td>
    </tr>
    <tr>
        <td>${user.username}</td>
        <td>${user.sex}</td>
        <td></td>
        <td>${user.address}</td>
    </tr>
</table>
</body>
</html>
