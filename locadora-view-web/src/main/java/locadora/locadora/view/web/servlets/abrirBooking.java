package locadora.locadora.view.web.servlets;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import locadora.locadora.negocio.servico.ServicoClientes;
import locadora.locadora.negocio.dao.ClientesDAO;
import locadora.locadora.negocio.dto.Cliente;

/**
 *
 * @author gugup
 */
@WebServlet(urlPatterns = {"/abrirBooking"})
public class abrirBooking extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String user = (String) request.getAttribute("user");
            Cliente c = ClientesDAO.procurarCliente(user);
            String nomeCliente = c.getNome();
            String emailCliente = c.getEmail();
            String telefoneCliente = c.getTelefone();
            String apelidoCliente = c.getUsername();
            String nascimentoCliente = c.getNascimento();
            String enderecoCliente = c.getEndereco();
            String cpfCliente = c.getCpf();
            String rgCliente = c.getRg();

            request.setAttribute("nomeCliente", nomeCliente);
            request.setAttribute("emailCliente", emailCliente);
            request.setAttribute("telefoneCliente", telefoneCliente);
            request.setAttribute("apelidoCliente", apelidoCliente);
            request.setAttribute("nascimentoCliente", nascimentoCliente);
            request.setAttribute("enderecoCliente", enderecoCliente);
            request.setAttribute("cpfCliente", cpfCliente);
            request.setAttribute("rgCliente", rgCliente);
            

            RequestDispatcher rd = request.getRequestDispatcher("/reserva.jsp");
            rd.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(abrirBooking.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(abrirBooking.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
