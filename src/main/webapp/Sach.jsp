<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.SachModel" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Bảng sách</title>
</head>
<body>

<h1>Dữ liệu bảng sách</h1>
<%
  String hoVaTen = (String) session.getAttribute("hoVaTen");
%>
<div style="display: flex"><p>Xin chào : <%= hoVaTen %> !</p> <p style="margin-left: 100px"><a href="LogoutServlet">Đăng xuất</a></p></div>
<br>
<% List<SachModel> sachList = (List<SachModel>) request.getAttribute("sachList");
  if (sachList != null && !sachList.isEmpty()) { %>
<a href="SachAddServlet">Thêm sách</a>
<br>
<a href="./SearchSach.jsp">Tìm sách theo tên</a>
<br>
<a href="./FillSach.jsp">Lọc sách theo giá</a>
<br>
<br>
<table border="1">
  <tr>
    <th>ID</th>
    <th>Tên sách</th>
    <th>Giá bán</th>
    <th>Năm xuất bản</th>
    <th>Mô tả</th>
    <th>Action</th>
  </tr>
  <% for (SachModel sach : sachList) { %>
  <tr>
    <td><%= sach.getId() %></td>
    <td><%= sach.getTenSach() %></td>
    <td><%= sach.getGiaBan() %></td>
    <td><%= sach.getNamXuatBan() %></td>
    <td><%= sach.getMoTa() %></td>
    <td>
      <a href="SachEditServlet?id=<%= sach.getId() %>">Sửa</a> |
      <a href="SachDeleteServlet?id=<%= sach.getId() %>">Xóa</a>
    </td>
  </tr>
  <% } %>
</table>
<% } else { %>
<p>Không có dữ liệu trong bảng sách</p>
<% } %>

<br>
<br>
<a href="./index.jsp">Quay về trang chủ !</a>
</body>
</html>
