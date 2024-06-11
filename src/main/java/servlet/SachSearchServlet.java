package servlet;

import dao.SachDao;
import model.SachModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class SachSearchServlet extends HttpServlet {
    private SachDao sachDao = new SachDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search");
        List<SachModel> sachList = sachDao.searchByName(search);
        request.setAttribute("sachList", sachList);
        request.getRequestDispatcher("SearchSach.jsp").forward(request, response);
    }
}