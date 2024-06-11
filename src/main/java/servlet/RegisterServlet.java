package servlet;

import dao.UserDao;
import jakarta.servlet.http.HttpSession;
import model.UserModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    private UserDao userDao = new UserDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String hoVaTen = request.getParameter("hoVaTen");
        String tenDangNhap = request.getParameter("tenDangNhap");
        String matKhau = request.getParameter("MatKhau");

        if (userDao.isUsernameExist(tenDangNhap)) {
            HttpSession session = request.getSession();
            session.setAttribute("errorMessage", "Tên tài khoản đã tồn tại, vui lòng chọn tên khác để đăng ký !");
            response.sendRedirect("Register.jsp");
        } else {
            UserModel user = new UserModel(hoVaTen, tenDangNhap, matKhau);
            userDao.register(user);
            response.sendRedirect("Login.jsp");
        }
    }
}