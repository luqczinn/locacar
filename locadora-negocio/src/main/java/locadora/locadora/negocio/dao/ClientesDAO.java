/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.locadora.negocio.dao;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locadora.locadora.negocio.dto.Cliente;
import locadora.locadora.database.Conexao;
import locadora.locadora.negocio.excessoes.negocioException;
import locadora.locadora.negocio.excessoes.persistenciaException;

/**
 *
 * @author gugup
 */
public class ClientesDAO {

    public static List<Cliente> listarClientesBD() throws SQLException {
        List<Cliente> listaUsuarios = new ArrayList<>();
        String sql = "SELECT * FROM clientes";
        Connection com = Conexao.getConnection();
        PreparedStatement stmt = com.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            String nome = rs.getString("nome");
            String cpf = rs.getString("cpf");
            String rg = rs.getString("rg");
            String nascimento = rs.getString("nascimento");
            String endereco = rs.getString("endereco");
            String telefone = rs.getString("telefone");
            String email = rs.getString("email");
            String username = rs.getString("username");
            String senha = rs.getString("senha");
            Cliente u = new Cliente(nome, nascimento, cpf, rg, endereco, telefone, email, username, senha);
            listaUsuarios.add(u);
        }
        if (listaUsuarios.isEmpty() != true) {
            return listaUsuarios;
        }
        return null;
    }

    public static String criptografarSenha(String senha) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
        byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));

        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
            hexString.append(String.format("%02X", 0xFF & b));
        }
        String senhahex = hexString.toString();
        return senhahex;
    }

    public static Cliente procurarCliente(String username) throws SQLException {
        List<Cliente> listaClientes = listarClientesBD();

        if (listaClientes != null) {
            for (Cliente c : listaClientes) {
                if (c.getUsername().equals(username)) {
                    return c;
                }
            }
        }
        return null;
    }

    public static void cadastrarCliente(String nome, String nascimento, String cpf, String rg, String endereco, String telefone, String email, String usuario, String senha) throws negocioException, SQLException, UnsupportedEncodingException, NoSuchAlgorithmException {
        if (procurarCliente(usuario) == null | listarClientesBD() == null) {
            String sql = "INSERT INTO clientes VALUES('" + nome + "','" + nascimento + "','" + cpf + "','" + rg + "','" + endereco + "','" + telefone + "','" + email + "','" + usuario + "','" + criptografarSenha(senha) + "')";
            Connection com = Conexao.getConnection();
            PreparedStatement pstmt = com.prepareStatement(sql);
            pstmt.execute();
            pstmt.close();
            com.close();
        }
    }

    public static void removerCliente(String username) throws SQLException, negocioException {
        if (procurarCliente(username) != null) {
            Cliente c = procurarCliente(username);
            String sql = "DELETE FROM clientes WHERE usuario='" + username + "'";
            Connection com = Conexao.getConnection();
            PreparedStatement pstmt = com.prepareStatement(sql);
            pstmt.execute();
            pstmt.close();
            com.close();
        }
    }

    public static Cliente logarCliente(String username, String senha) throws persistenciaException, SQLException, UnsupportedEncodingException, NoSuchAlgorithmException {
        Cliente cliente = procurarCliente(username);

        if (cliente == null) {
            throw new persistenciaException("Username de usuário não encontrado!");
        }
        if (cliente.getSenha().equals(criptografarSenha(senha))) {
            return cliente;
        } else {
            throw new persistenciaException("Senha incorreta!");
        }
    }
}
