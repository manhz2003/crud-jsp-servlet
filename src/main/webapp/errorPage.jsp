<%--
  Created by IntelliJ IDEA.
  User: nguyenthemanh
  Date: 8/6/24
  Time: 09:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lỗi</title>
</head>
<body>
<h1>Đã xảy ra lỗi !</h1>
<p><%= request.getAttribute("error") %></p>
<a href="./Sach.jsp">Ấn vào đây để quay lại ...</a>
</body>
</html>