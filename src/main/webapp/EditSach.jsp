<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.SachModel" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chỉnh sửa sách</title>
</head>
<body>
<h1>Chỉnh sửa sách</h1>
<% SachModel sach = (SachModel) request.getAttribute("sach");
    if (sach != null) { %>
<form action="SachEditServlet" method="post">
    <input type="hidden" name="id" value="<%= sach.getId() %>">
    <label>Tên sách: <input type="text" name="tenSach" value="<%= sach.getTenSach() %>"></label><br>
    <label>Giá bán: <input type="number" step="0.01" name="giaBan" value="<%= sach.getGiaBan() %>"></label><br>
    <label>Năm xuất bản: <input type="number" name="namXuatBan" value="<%= sach.getNamXuatBan() %>"></label><br>
    <label>Mô tả: <textarea name="moTa"><%= sach.getMoTa() %></textarea></label><br>
    <input type="submit" value="Cập nhật">
</form>
<% } else { %>
<p>Không tìm thấy sách</p>
<% } %>
</body>
</html>