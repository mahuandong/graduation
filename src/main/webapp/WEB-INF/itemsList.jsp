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
        <td>Pric</td>
        <td>Date</td>
        <td>Detail</td>
    </tr>
    <tr>
        <td>${items.name}</td>
        <td>${items.price}</td>
        <td><fmt:formatDate value="${items.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
        <td>${items.detail}</td>
    </tr>

</table>
</body>
</html>
