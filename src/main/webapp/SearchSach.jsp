<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.SachModel" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tìm kiếm sách</title>
</head>
<body>
<h1>Tìm kiếm sách</h1>
<form action="SachSearchServlet" method="get">
    <input type="text" name="search" placeholder="Nhập tên sách...">
    <input type="submit" value="Tìm kiếm">
</form>
<% List<SachModel> sachList = (List<SachModel>) request.getAttribute("sachList");
    if (sachList != null && !sachList.isEmpty()) { %>
<h2>Kết quả tìm kiếm:</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Tên sách</th>
        <th>Giá bán</th>
        <th>Năm xuất bản</th>
        <th>Mô tả</th>
    </tr>
    <% for (SachModel sach : sachList) { %>
    <tr>
        <td><%= sach.getId() %></td>
        <td><%= sach.getTenSach() %></td>
        <td><%= sach.getGiaBan() %></td>
        <td><%= sach.getNamXuatBan() %></td>
        <td><%= sach.getMoTa() %></td>
    </tr>
    <% } %>
</table>
<% } else if (request.getParameter("search") != null) { %>
<p>Không tìm thấy sách</p>
<% } %>
<br>
<br>
<br>
<a href="SachServlet">Quay lại danh sách sách</a>
</body>
</html>