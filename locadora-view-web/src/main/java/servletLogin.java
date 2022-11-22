/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.*;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import locadora.locadora.negocio.servico.ServicoUsuarios;
import locadora.locadora.negocio.servico.ServicoClientes;
import locadora.locadora.negocio.dto.Cliente;
import locadora.locadora.negocio.excessoes.negocioException;
import locadora.locadora.negocio.excessoes.persistenciaException;

/**
 *
 * @author Aluno
 */
@WebServlet(urlPatterns = {"/Login.jsp"})
public class servletLogin extends HttpServlet {

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
            throws ServletException, IOException, negocioException, SQLException, UnsupportedEncodingException, NoSuchAlgorithmException, persistenciaException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String user = request.getParameter("usuario");
            String senha = request.getParameter("senha");
            HttpSession session = request.getSession();

            if (user.isEmpty() && senha.isEmpty()) {
                response.sendRedirect("Login.jsp");
            }

            session.setAttribute("usuario", user);
            session.setAttribute("senha", senha);
            if (ServicoUsuarios.logarUsuario(user, senha) == null) {
                if (ServicoClientes.logarCliente(user, senha) == null) {
                    session.setAttribute("loginError", "loginError");
                } else {
                    Cliente cliente = ServicoClientes.logarCliente(user, senha);
                }
            

            }
            
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
        } catch (negocioException ex) {
            Logger.getLogger(servletLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(servletLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(servletLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(servletLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (persistenciaException ex) {
            Logger.getLogger(servletLogin.class.getName()).log(Level.SEVERE, null, ex);
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
            throws ServletException, IOException, UnsupportedEncodingException {
        try {
            processRequest(request, response);
        } catch (negocioException ex) {
            Logger.getLogger(servletLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(servletLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(servletLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (persistenciaException ex) {
            Logger.getLogger(servletLogin.class.getName()).log(Level.SEVERE, null, ex);
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
