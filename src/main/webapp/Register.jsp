<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng ký</title>
    <style>
        .error-message {
            color: red;
        }
    </style>
</head>
<body>
<h1>Đăng ký</h1>
<form action="RegisterServlet" method="post">
    <label>Họ và tên: <input type="text" name="hoVaTen" required></label><br>
    <label>Tên đăng nhập: <input type="text" name="tenDangNhap" required></label><br>
    <label>Mật khẩu: <input type="password" name="MatKhau" required></label><br>
    <input type="submit" value="Đăng ký">
</form>

<%
    String errorMessage = (String) session.getAttribute("errorMessage");
    if (errorMessage != null) {
        out.println("<p class=\"error-message\">" + errorMessage + "</p>");
        session.removeAttribute("errorMessage");
    }
%>

<p>Nếu đã có tài khoản vui lòng click vào <a href="./Login.jsp">đây</a> để đăng nhập !</p>
</body>
</html>