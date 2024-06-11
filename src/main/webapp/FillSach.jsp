<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.SachModel" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lọc sách theo giá</title>
</head>
<body>
<h1>Lọc sách theo giá</h1>
<form action="FillSachServlet" method="post">
    <label>Giá thấp nhất: <input type="number" step="0.01" name="minPrice"></label><br>
    <label>Giá cao nhất: <input type="number" step="0.01" name="maxPrice"></label><br>
    <input type="submit" value="Lọc">
</form>
<% List<SachModel> sachList = (List<SachModel>) request.getAttribute("sachList");
    if (sachList != null && !sachList.isEmpty()) { %>
<h2>Kết quả lọc:</h2>
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
<% } else if (request.getParameter("minPrice") != null && request.getParameter("maxPrice") != null) { %>
<p>Không tìm thấy sách trong khoảng giá này</p>
<% } %>
<br>
<br>
<a href="SachServlet">Quay lại danh sách sách</a>
</body>
</html>