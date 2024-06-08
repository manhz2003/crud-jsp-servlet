package servlet;

import dao.SachDao;
import model.SachModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class SachEditServlet extends HttpServlet {
    private SachDao sachDao = new SachDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            SachModel sach = sachDao.get(id);
            request.setAttribute("sach", sach);
            request.getRequestDispatcher("EditSach.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.sendRedirect("errorPage.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String tenSach = request.getParameter("tenSach");
            double giaBan = Double.parseDouble(request.getParameter("giaBan"));
            int namXuatBan = Integer.parseInt(request.getParameter("namXuatBan"));
            String moTa = request.getParameter("moTa");

            SachModel sach = new SachModel();
            sach.setId(id);
            sach.setTenSach(tenSach);
            sach.setGiaBan(giaBan);
            sach.setNamXuatBan(namXuatBan);
            sach.setMoTa(moTa);

            sachDao.update(sach);
            response.sendRedirect("SachServlet");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.sendRedirect("errorPage.jsp");
        }
    }
}