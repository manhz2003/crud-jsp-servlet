<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng nhập</title>
    <style>
        .error-message {
            color: red;
        }
    </style>
</head>
<body>
<h1>Đăng nhập</h1>
<form action="LoginServlet" method="post">
    <label>Tên đăng nhập: <input type="text" name="tenDangNhap" required></label><br>
    <label>Mật khẩu: <input type="password" name="matKhau" required></label><br>
    <input type="submit" value="Đăng nhập">
</form>

<%
    String errorMessage = (String) session.getAttribute("errorMessage");
    if (errorMessage != null) {
        out.println("<p class=\"error-message\">" + errorMessage + "</p>");
        session.removeAttribute("errorMessage");
    }
%>

<p>Nếu chưa có tài khoản vui lòng click vào <a href="./Register.jsp">đây</a> để đăng ký !</p>
</body>
</html>