package locadora.locadora.view.web.servlets;

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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import locadora.locadora.negocio.excessoes.negocioException;
import locadora.locadora.negocio.servico.ServicoReservas;

/**
 *
 * @author Aluno
 */
@WebServlet(urlPatterns = {"/ReservaServlet"})
public class ReservaServlet extends HttpServlet {

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
            throws ServletException, IOException, negocioException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            //concatenação de cliente
            String nome = request.getParameter("nomeCliente"); 
            String cpf = request.getParameter("cpfCliente"); 
            String cliente = nome + "  |  " + cpf + ".";
            
            //concatenação do veiculo
            String placa = request.getParameter("placaVeiculo");
            String modelo = request.getParameter("modelo"); 
            String carro = placa + " | " + modelo + ".";
            
            String vendedor = request.getParameter("vendedor");
            String unidade = request.getParameter("unidadeEntrega");
            String dataInicio = request.getParameter("dataLocacao");
            String dataFim = request.getParameter("dataDevolucao");
            String valorReserva = request.getParameter("valorLocacao"); 
            String valorTotalReserva = request.getParameter("valorTotalLocacao"); 
            
            //inserir no bd
            ServicoReservas.inserirReservaBD(Integer.SIZE, cliente, vendedor, carro, unidade, dataInicio, dataFim, valorReserva, valorTotalReserva, "ONLINE");
        } catch (Exception ex) {
            Logger.getLogger(ReservaServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ReservaServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ReservaServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (negocioException ex) {
            Logger.getLogger(ReservaServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ReservaServlet.class.getName()).log(Level.SEVERE, null, ex);
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
