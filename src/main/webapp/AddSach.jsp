<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm sách</title>
</head>
<body>
<h1>Thêm sách</h1>
<form action="SachAddServlet" method="post">
    <label>Tên sách: <input type="text" name="tenSach"></label><br>
    <label>Giá bán: <input type="number" step="0.01" name="giaBan"></label><br>
    <label>Năm xuất bản: <input type="number" name="namXuatBan"></label><br>
    <label>Mô tả: <textarea name="moTa"></textarea></label><br>
    <input type="submit" value="Thêm">
</form>
</body>
</html>