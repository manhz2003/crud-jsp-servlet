package servlet;

import dao.SachDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.SachModel;

import java.io.IOException;

public class SachDeleteServlet extends HttpServlet {
    private SachDao sachDao = new SachDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            SachModel sach = new SachModel();
            sach.setId(id);
            sachDao.delete(sach);
            response.sendRedirect("SachServlet");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.sendRedirect("errorPage.jsp");
        }
    }
}