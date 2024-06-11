package servlet;

import dao.UserDao;
import model.UserModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private UserDao userDao = new UserDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tenDangNhap = request.getParameter("tenDangNhap");
        String matKhau = request.getParameter("matKhau");
        UserModel user = userDao.login(tenDangNhap, matKhau);
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("hoVaTen", user.getHoVaTen());
            response.sendRedirect("index.jsp");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("errorMessage", "Tên đăng nhập hoặc mật khẩu không chính xác, vui lòng thử lại !");
            response.sendRedirect("Login.jsp");
        }
    }
}