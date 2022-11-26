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
import jakarta.servlet.http.*;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import locadora.locadora.database.Conexao;
import locadora.locadora.negocio.servico.ServicoUsuarios;
import locadora.locadora.negocio.servico.ServicoClientes;
import locadora.locadora.negocio.dto.Cliente;
import locadora.locadora.negocio.dao.ClientesDAO;
import locadora.locadora.negocio.dto.Usuario;
import locadora.locadora.negocio.excessoes.negocioException;
import locadora.locadora.negocio.excessoes.persistenciaException;
import locadora.locadora.negocio.servico.ServicoLog;

/**
 *
 * @author Aluno
 */
@WebServlet(urlPatterns = {"/servletLogin"})
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
            throws ServletException, IOException, negocioException, SQLException, UnsupportedEncodingException, NoSuchAlgorithmException, persistenciaException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String user = request.getParameter("usuario");
            String senha = request.getParameter("senha");
            String ip = request.getRemoteAddr();
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            if (user.isEmpty() | senha.isEmpty()) {
                session.setAttribute("erro", "I");
                RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
                rd.forward(request, response);
            }

            if (ServicoUsuarios.logarUsuario(user, senha) == null) {
                if (ServicoClientes.logarCliente(user, senha) == null) {
                    session.setAttribute("erro", "I");
                    RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
                    rd.forward(request, response);
                } else {
                    Cliente cliente = ServicoClientes.logarCliente(user, senha);
                    String cpf = cliente.getCpf();
                    String nome = cliente.getNome();
                    String clienteBD = nome + "|" + cpf;
                    session.setAttribute("cliente", clienteBD);
                    session.setAttribute("ip", ip);
                    SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
                    String agora = formater.format(new Date());
                    String sql = "INSERT INTO logCliente VALUES('" + clienteBD + "','" + ip + "','" + agora + "')";
                    Connection com = Conexao.getConnection();
                    PreparedStatement pstmt = com.prepareStatement(sql);
                    pstmt.execute();
                    pstmt.close();
                    com.close();
                    Object vinda = (String) session.getAttribute("vinda");
                    String destino = "";
                    if (vinda == "home") {
                        destino = "index.jsp";
                        session.setAttribute("user", session.getAttribute("user"));
                        session.setAttribute("cliente", session.getAttribute("clienteBD"));
                    } else if (vinda == "listagemVeiculos") {
                        destino = "veiculos.jsp";
                        Object dataLocacao = (String) session.getAttribute("dataLocacao");
                        Object dataDevolucao = (String) session.getAttribute("dataDevolucao");
                        Object tipo = (String) session.getAttribute("tipo");
                        Object unidadeEntrega = (String) session.getAttribute("unidadeEntrega");
                        Object unidadeDevolucao = (String) session.getAttribute("unidadeDevolucao");
                        session.setAttribute("dataLocacao", dataLocacao);
                        session.setAttribute("dataDevolucao", dataDevolucao);
                        session.setAttribute("tipo", tipo);
                        session.setAttribute("unidadeEntrega", unidadeEntrega);
                        session.setAttribute("unidadeDevolucao", unidadeDevolucao);
                        session.setAttribute("user", session.getAttribute("user"));
                        session.setAttribute("cliente", session.getAttribute("clienteBD"));
                    } else if (vinda == "reservaVeiculos") {
                        destino = "reserva.jsp";
                        Object dataLocacao = (String) session.getAttribute("dataLocacao");
                        Object dataDevolucao = (String) session.getAttribute("dataDevolucao");
                        Object imagemVeiculo = (String) session.getAttribute("imagemVeiculo");
                        Object motor = (String) session.getAttribute("motor");
                        Object tipo = (String) session.getAttribute("tipo");
                        Object ano = (String) session.getAttribute("ano");
                        Object quilometragem = (String) session.getAttribute("quilometragem");
                        Object unidadeEntrega = (String) session.getAttribute("unidadeEntrega");
                        Object unidadeDevolucao = (String) session.getAttribute("unidadeDevolucao");
                        Object marca = (String) session.getAttribute("marca");
                        Object placaVeiculo = (String) session.getAttribute("placaVeiculo");
                        Object vendedor = (String) session.getAttribute("vendedor");
                        Object valorLocacao = (String) session.getAttribute("valorLocacao");
                        Object valorTotalLocacao = (String) session.getAttribute("valorTotalLocacao");
                        session.setAttribute("dataLocacao", dataLocacao);
                        session.setAttribute("dataDevolucao", dataDevolucao);
                        session.setAttribute("imagemVeiculo", imagemVeiculo);
                        session.setAttribute("motor", motor);
                        session.setAttribute("tipo", tipo);
                        session.setAttribute("ano", ano);
                        session.setAttribute("quilometragem", quilometragem);
                        session.setAttribute("unidadeEntrega", unidadeEntrega);
                        session.setAttribute("unidadeDevolucao", unidadeDevolucao);
                        session.setAttribute("marca", marca);
                        session.setAttribute("placaVeiculo", placaVeiculo);
                        session.setAttribute("vendedor", vendedor);
                        session.setAttribute("valorLocacao", valorLocacao);
                        session.setAttribute("valorTotalLocacao", valorTotalLocacao);
                        session.setAttribute("user", session.getAttribute("user"));
                        session.setAttribute("cliente", session.getAttribute("clienteBD"));
                    }
                    RequestDispatcher rd = request.getRequestDispatcher("/veiculos.jsp");
                    rd.forward(request, response);
                }
            } else {
                Usuario usuario = ServicoUsuarios.logarUsuario(user, senha);
                ServicoLog.registrarLogUsuario(usuario);
                RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
                rd.forward(request, response);
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
        } catch (Exception ex) {
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
        } catch (Exception ex) {
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
