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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, UnsupportedEncodingException, UnsupportedEncodingException {
        try {
            Usuario u = null;
            Cliente c = null;
            String checkBox[] = request.getParameterValues("checkbox");
            String valorCheckbox = checkBox[0];
            String user = request.getParameter("user");
            String senha = request.getParameter("senha");
            String tipoLogin = "";

            if (valorCheckbox.equals("usuario")) {
                u = ServicoUsuarios.logarUsuario(user, senha);
                if (u.getUsername().equals(user) && u.getSenha().equals(ClientesDAO.criptografarSenha(senha))) {
                    tipoLogin = "usuario";
                } else {
                    request.setAttribute("erro", "Credenciais incorretas!");
                    RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
                    rd.forward(request, response);
                }
            } else if (valorCheckbox.equals("cliente")) {
                c = ServicoClientes.logarCliente(user, senha);
                if (c.getUsername().equals(user) && c.getSenha().equals(ClientesDAO.criptografarSenha(senha))) {
                    tipoLogin = "cliente";
                } else {
                    request.setAttribute("erro", "Credenciais incorretas!");
                    RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
                    rd.forward(request, response);
                }
            }
            HttpSession session = request.getSession();
            String ip = request.getRemoteAddr();
            session.setAttribute("user", user);

            switch (tipoLogin) {

                case "usuario":
                    request.setAttribute("user", u);
                    ServicoLog.registrarLogUsuario(u);
                    RequestDispatcher rd3 = request.getRequestDispatcher("/index.jsp");
                    rd3.forward(request, response);

                    break;

                case "cliente":

                    String cpf = c.getCpf();
                    String nome = c.getNome();
                    String clienteBD = nome + "|" + cpf;
                    request.setAttribute("cliente", clienteBD);
                    request.setAttribute("ip", ip);
                    SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
                    String agora = formater.format(new Date());
                    String sql = "INSERT INTO logCliente VALUES('" + clienteBD + "','" + ip + "','" + agora + "')";
                    Connection com = Conexao.getConnection();
                    PreparedStatement pstmt = com.prepareStatement(sql);
                    pstmt.execute();
                    pstmt.close();
                    com.close();
                    
                    
                    String vinda = (String) request.getParameter("vinda");
                    String destino = "";
                    if (vinda.equals("home")) {
                        destino = "/index.jsp";
                        request.setAttribute("user", user);
                        request.setAttribute("cliente", clienteBD);
                    } else if (vinda.equals("listagemVeiculos")) {
                        destino = "/abrirBooking";
                        request.setAttribute("user", user);
                        request.setAttribute("cliente", clienteBD);
                    } else if (vinda.equals("reservaVeiculos")) {
                        destino = "/reserva.jsp";
                        String dataLocacao = (String) request.getAttribute("dataLocacao");
                        String dataDevolucao = (String) request.getAttribute("dataDevolucao");
                        String imagemVeiculo = (String) request.getAttribute("imagemVeiculo");
                        String motor = (String) request.getAttribute("motor");
                        String tipo = (String) request.getAttribute("tipo");
                        String ano = (String) request.getAttribute("ano");
                        String quilometragem = (String) request.getAttribute("quilometragem");
                        String unidadeEntrega = (String) request.getAttribute("unidadeEntrega");
                        String unidadeDevolucao = (String) request.getAttribute("unidadeDevolucao");
                        String marca = (String) request.getAttribute("marca");
                        String placaVeiculo = (String) request.getAttribute("placaVeiculo");
                        String vendedor = (String) request.getAttribute("vendedor");
                        String valorLocacao = (String) request.getAttribute("valorLocacao");
                        String valorTotalLocacao = (String) request.getAttribute("valorTotalLocacao");
                        request.setAttribute("dataLocacao", dataLocacao);
                        request.setAttribute("dataDevolucao", dataDevolucao);
                        request.setAttribute("imagemVeiculo", imagemVeiculo);
                        request.setAttribute("motor", motor);
                        request.setAttribute("tipo", tipo);
                        request.setAttribute("ano", ano);
                        request.setAttribute("quilometragem", quilometragem);
                        request.setAttribute("unidadeEntrega", unidadeEntrega);
                        request.setAttribute("unidadeDevolucao", unidadeDevolucao);
                        request.setAttribute("marca", marca);
                        request.setAttribute("placaVeiculo", placaVeiculo);
                        request.setAttribute("vendedor", vendedor);
                        request.setAttribute("valorLocacao", valorLocacao);
                        request.setAttribute("valorTotalLocacao", valorTotalLocacao);
                        request.setAttribute("user", user);
                        request.setAttribute("cliente", clienteBD);
                    }
                    RequestDispatcher rd4 = request.getRequestDispatcher(destino);
                    rd4.forward(request, response);
                    break;
            }

        } catch (negocioException ex) {
            String user = request.getParameter("user");
            String senha = request.getParameter("senha");
            if (user.isEmpty() | senha.isEmpty()) {
                request.setAttribute("erro", "Insira suas credenciais!");
                RequestDispatcher rd1 = request.getRequestDispatcher("/Login.jsp");
                rd1.forward(request, response);
            }
            request.setAttribute("erro", "Credenciais incorretas!");
            RequestDispatcher rd2 = request.getRequestDispatcher("/Login.jsp");
            rd2.forward(request, response);
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
