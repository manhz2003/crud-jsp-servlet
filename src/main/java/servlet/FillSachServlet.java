package servlet;

import dao.SachDao;
import model.SachModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class FillSachServlet extends HttpServlet {
    private SachDao sachDao = new SachDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("FillSach.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            double minPrice = Double.parseDouble(request.getParameter("minPrice"));
            double maxPrice = Double.parseDouble(request.getParameter("maxPrice"));
            List<SachModel> sachList = sachDao.filterByPrice(minPrice, maxPrice);
            request.setAttribute("sachList", sachList);
            request.getRequestDispatcher("FillSach.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.sendRedirect("errorPage.jsp");
        }
    }
}