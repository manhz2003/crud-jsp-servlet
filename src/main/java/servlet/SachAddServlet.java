package servlet;

import dao.SachDao;
import model.SachModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class SachAddServlet extends HttpServlet {
    private SachDao sachDao = new SachDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("AddSach.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String tenSach = request.getParameter("tenSach");
            double giaBan = Double.parseDouble(request.getParameter("giaBan"));
            int namXuatBan = Integer.parseInt(request.getParameter("namXuatBan"));
            String moTa = request.getParameter("moTa");

            SachModel sach = new SachModel();
            sach.setTenSach(tenSach);
            sach.setGiaBan(giaBan);
            sach.setNamXuatBan(namXuatBan);
            sach.setMoTa(moTa);
            sachDao.add(sach);
            response.sendRedirect("SachServlet");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.sendRedirect("errorPage.jsp");
        }
    }
}