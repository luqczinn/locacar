/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package locadora.locadora.view.web.servlets;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import locadora.locadora.negocio.servico.ServicoReservas;

/**
 *
 * @author Aluno
 */
@WebServlet(name = "ComprovanteServlet", urlPatterns = {"/ComprovanteServlet"})
public class ComprovanteServlet extends HttpServlet {

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
            throws ServletException, IOException, ParseException, SQLException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String modelo = (String) request.getParameter("modelo");
            String cambio = (String) request.getParameter("cambio");
            String nome = (String) request.getParameter("nome");
            String apelido = (String) request.getParameter("apelido");
            String email = (String) request.getParameter("email");
            String endereco = (String) request.getParameter("endereco");
            String telefone = (String) request.getParameter("telefone");
            String dataNascimento = (String) request.getParameter("dataNascimento");
            String cpf = (String) request.getParameter("cpf");
            String rg = (String) request.getParameter("rg");
            String localEntrega = (String) request.getParameter("localEntrega");
            String localColeta = (String) request.getParameter("localColeta");
            String dataRetirada = (String) request.getParameter("dataRetirada");
            String dataEntrega = (String) request.getParameter("dataEntrega");
            String pagamento = (String) request.getParameter("pagamento");
            String veiculo = (String) request.getParameter("veiculo");
            String motor = (String) request.getParameter("motor");
            String tipo = (String) request.getParameter("tipo");
            String marca = (String) request.getParameter("marca");
            String ano = (String) request.getParameter("ano");
            String quilometragem = (String) request.getParameter("quilometragem");
            String valorAluguel = (String) request.getParameter("valorAluguel");
            String placaVeiculo = (String) request.getAttribute("placaVeiculo");
            String vendedor = (String) request.getAttribute("vendedor");

            //concatenação usuario
            String usuario = nome + "|" + cpf + ".";

            //concatenação veiculo
            String carro = placaVeiculo + "|" + modelo + ".";

            request.setAttribute("modelo", modelo);
            request.setAttribute("cambio", cambio);
            request.setAttribute("endereco", endereco);
            request.setAttribute("nome", nome);
            request.setAttribute("apelido", apelido);
            request.setAttribute("telefone", telefone);
            request.setAttribute("email", email);
            request.setAttribute("dataNascimento", dataNascimento);
            request.setAttribute("cpf", cpf);
            request.setAttribute("rg", rg);
            request.setAttribute("localEntrega", localEntrega);
            request.setAttribute("localColeta", localColeta);
            request.setAttribute("dataRetirada", dataRetirada);
            request.setAttribute("dataEntrega", dataEntrega);
            request.setAttribute("pagamento", pagamento);
            request.setAttribute("veiculo", veiculo);
            request.setAttribute("motor", motor);
            request.setAttribute("tipo", tipo);
            request.setAttribute("marca", marca);
            request.setAttribute("ano", ano);
            request.setAttribute("quilometragem", quilometragem);
            request.setAttribute("usuario", usuario);
            request.setAttribute("valorAluguel", valorAluguel);

            //calculo do valor de reserva
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            String data1 = df.format(dataRetirada);
            String data2 = df.format(dataEntrega);

            Date d1 = null;
            d1 = df.parse(dataRetirada);
            Date d2 = null;
            d2 = df.parse(dataEntrega);

            long dt = (d2.getTime() - d1.getTime());
            long dias = dt / 86400000L;
            int diasInt = (int) dias;
            double diaria = Double.parseDouble(valorAluguel);

            double valorTotal = diaria * diasInt;
            request.setAttribute("valorTotal", valorTotal);

            ServicoReservas.inserirReservaBD(Integer.SIZE, usuario, vendedor, carro, localColeta, data1, data2, Double.toString(diaria), Double.toString(valorTotal), "ONLINE");

            RequestDispatcher rd = request.getRequestDispatcher("/comprovante.jsp");
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
        } catch (ParseException ex) {
            Logger.getLogger(ComprovanteServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ComprovanteServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ParseException ex) {
            Logger.getLogger(ComprovanteServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ComprovanteServlet.class.getName()).log(Level.SEVERE, null, ex);
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
