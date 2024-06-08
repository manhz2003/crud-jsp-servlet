package servlet;

import dao.SachDao;
import model.SachModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SachServlet extends HttpServlet {
    private SachDao sachDao = new SachDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<SachModel> sachList = sachDao.getAll();
        request.setAttribute("sachList", sachList);
        request.getRequestDispatcher("Sach.jsp").forward(request, response);
    }
}
