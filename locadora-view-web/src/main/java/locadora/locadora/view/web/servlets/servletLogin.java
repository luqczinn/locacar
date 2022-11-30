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
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
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
            

            switch (tipoLogin) {

                case "usuario":
                    request.setAttribute("user", u);
                    session.setAttribute("user", user);
                    ServicoLog.registrarLogUsuario(u);
                    RequestDispatcher rd3 = request.getRequestDispatcher("/logs.jsp");
                    rd3.forward(request, response);

                    break;

                case "cliente":
                    
                    String email = c.getEmail();
                    String tel = c.getTelefone();
                    String endereco = c.getEndereco();
                    String cpf = c.getCpf();
                    String nome = c.getNome();
                    String clienteBD = nome + "|" + cpf;
                    request.setAttribute("user", user);
                    request.setAttribute("nome", nome);
                    request.setAttribute("email", email);
                    request.setAttribute("tel", tel);
                    request.setAttribute("endereco", endereco);
                    request.setAttribute("cliente", clienteBD);
                    request.setAttribute("ip", ip);
                    session.setAttribute("user", user);
                    session.setAttribute("nome", nome);
                    session.setAttribute("email", email);
                    session.setAttribute("tel", tel);
                    session.setAttribute("endereco", endereco);
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

                    String vinda = (String) request.getParameter("vinda");

                    String destino = "";
                    if (vinda.equals("home")) {
                        destino = "/index.jsp";
                        
                    } else if (vinda.equals("listagemVeiculos")) {
                        destino = "/abrirBooking";
                        request.setAttribute("user", user);
                        request.setAttribute("cliente", clienteBD);
                        String nomeVeiculo = (String) request.getParameter("marca") + " " + (String) request.getParameter("modelo");
                        Locale l = new Locale("pt", "BR");
                        String valorAluguel = request.getParameter("valorDiaria");
                        String modelo = (String) request.getParameter("modelo");
                        String cambio = (String) request.getParameter("cambio");
                        String imagemVeiculo = (String) request.getParameter("imagem");
                        String motor = (String) request.getParameter("tipoMotor");
                        String tipo = (String) request.getParameter("tipoDeCarro");
                        String ano = (String) request.getParameter("ano");
                        NumberFormat nk = NumberFormat.getInstance(l);
                        Double km = Double.valueOf(request.getParameter("km"));
                        String quilometragem = nk.format(km);
                        String marca = (String) request.getParameter("marca");
                        String placaVeiculo = (String) request.getParameter("placaVeiculo");
                        String vendedor = "ONLINE";

                        request.setAttribute("nomeVeiculo", nomeVeiculo);
                        request.setAttribute("valorAluguel", valorAluguel);
                        request.setAttribute("modelo", modelo);
                        request.setAttribute("cambio", cambio);
                        request.setAttribute("imagemVeiculo", imagemVeiculo);
                        request.setAttribute("motor", motor);
                        request.setAttribute("tipo", tipo);
                        request.setAttribute("ano", ano);
                        request.setAttribute("quilometragem", quilometragem);
                        request.setAttribute("marca", marca);
                        request.setAttribute("placaVeiculo", placaVeiculo);
                        request.setAttribute("vendedor", vendedor);
                    } else if (vinda.equals("enviarTicket")) {
                        destino = "/contato.jsp";
                        String assuntoSelect = (String) request.getParameter("assuntoSelect");
                        String assuntoOutro = (String) request.getParameter("assuntoOutro");
                        String descricao = (String) request.getParameter("descricao");
                        request.setAttribute("assuntoSelect", assuntoSelect);
                        request.setAttribute("assuntoOutro", assuntoOutro);
                        request.setAttribute("descricao", descricao);
                        request.setAttribute("user", user);
                    }else{
                        destino = "/index.jsp";
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
