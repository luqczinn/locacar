/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.locadora.negocio.dao;

import java.util.ArrayList;
import java.util.List;
import locadora.locadora.negocio.dto.Usuario;
import locadora.locadora.negocio.excessoes.persistenciaException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import locadora.locadora.database.Conexao;
import locadora.locadora.negocio.dto.Usuario;
import locadora.locadora.negocio.excessoes.negocioException;

/**
 *
 * @author Aluno
 */
public class UsuarioDAO {

    public static void cadastrarFuncionario(String nome, String cpf, String rg, String nascimento, String cnis, double salario, String cargo, String endereco, String telefone, String email, String usuario, String senha, String unidade) throws negocioException, SQLException, UnsupportedEncodingException, NoSuchAlgorithmException {
        if (procurarPorUsernameFuncionario(usuario) == null | listarFuncionariosBD() == null) {
            String sql = "INSERT INTO funcionarios VALUES('"+nome+"','"+cpf+"','"+rg+"','"+nascimento+"','"+cnis+"',"+salario+",'"+cargo+"','"+endereco+"','"+telefone+",'"+email+"','"+usuario+"'+'"+criptografarSenha(senha)+"','"+unidade+"')";
            Connection com = Conexao.getConnection();
            PreparedStatement pstmt = com.prepareStatement(sql);
            pstmt.execute();
            pstmt.close();
            com.close();
        }
    }
    

    public static void removerFuncionario(String username) throws SQLException, negocioException {
        if (procurarPorUsernameFuncionario(username) != null) {
            Usuario u = procurarPorUsernameFuncionario(username);
            Connection com = Conexao.getConnection();
            Statement statement = com.createStatement();
            String sql = "DELETE FROM funcionarios WHERE usuario='"+username+"'";
            statement.executeUpdate(sql);
        }
    }
    
    public static void cadastrarCliente(String nome, String nascimento, String cpf, String rg, String endereco, String telefone, String email, String usuario, String senha) throws negocioException, SQLException, UnsupportedEncodingException, NoSuchAlgorithmException {
        if (procurarPorUsernameFuncionario(usuario) == null | listarFuncionariosBD() == null) {
            String sql = "INSERT INTO clientes VALUES('"+nome+"','"+nascimento+"','"+cpf+"','"+rg+"','"+endereco+"',"+telefone+",'"+email+"','"+usuario+"','"+criptografarSenha(senha)+"')";
            Connection com = Conexao.getConnection();
            PreparedStatement pstmt = com.prepareStatement(sql);
            pstmt.execute();
            pstmt.close();
            com.close();
        }
    }
    
    public static void removerCliente(String username) throws SQLException, negocioException {
        if (procurarPorUsernameFuncionario(username) != null) {
            Usuario u = procurarPorUsernameFuncionario(username);
            Connection com = Conexao.getConnection();
            Statement statement = com.createStatement();
            String sql = "DELETE FROM clientes WHERE usuario='"+username+"'";
            statement.executeUpdate(sql);
        }
    }

    public static Usuario procurarPorUsernameFuncionario(String username) throws SQLException {
        List<Usuario> listaFuncionarios = listarFuncionariosBD();
        
        if (listaFuncionarios != null) {
            for (Usuario u : listaFuncionarios) {
                if (u.getUsername().equals(username)) {
                    return u;
                }
            }
        }
        return null;
    }
    
    public static Usuario procurarPorUsernameCliente(String username) throws SQLException {
        List<Usuario> listaClientes = listarFuncionariosBD();
        
        if (listaClientes != null) {
            for (Usuario u : listaClientes) {
                if (u.getUsername().equals(username)) {
                    return u;
                }
            }
        }
        return null;
    }

    public static Usuario logarUsuarioFuncionario(String username, String senha) throws persistenciaException, SQLException, UnsupportedEncodingException, NoSuchAlgorithmException {
        Usuario usuario = procurarPorUsernameFuncionario(username);

        if (usuario == null) {
            throw new persistenciaException("Username de usuário não encontrado!");
        }
        if (usuario.getSenha().equals(criptografarSenha(senha))) {
            return usuario;
        } else {
            throw new persistenciaException("Senha incorreta!");
        }
    }
    
    public static Usuario logarUsuarioCliente(String username, String senha) throws persistenciaException, SQLException, UnsupportedEncodingException, NoSuchAlgorithmException {
        Usuario usuario = procurarPorUsernameCliente(username);

        if (usuario == null) {
            throw new persistenciaException("Username de usuário não encontrado!");
        }
        if (usuario.getSenha().equals(criptografarSenha(senha))) {
            return usuario;
        } else {
            throw new persistenciaException("Senha incorreta!");
        }
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

    public static List<Usuario> listarFuncionariosBD() throws SQLException {
        List<Usuario> listaUsuarios = new ArrayList<>();
        String sql = "SELECT * FROM funcionarios";
        Connection com = Conexao.getConnection();
        PreparedStatement stmt = com.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
            String nome = rs.getString("nome");
            String cpf = rs.getString("cpf");
            String rg = rs.getString("rg");
            String nascimento = rs.getString("nascimento");
            String cnis = rs.getString("cnis");
            String salario = rs.getString("salario");
            String cargo = rs.getString("cargo");
            String endereco = rs.getString("endereco");
            String telefone = rs.getString("telefone");
            String email = rs.getString("email");
            String usuario = rs.getString("usuario");
            String senha = rs.getString("senha");
            String unidade = rs.getString("unidade");
            Usuario u = new Usuario(nome, cpf, rg, nascimento, cnis, salario, cargo, endereco, telefone, email, usuario, senha, unidade);
            listaUsuarios.add(u);
            System.out.println("Usuário adicionado");
        }
        if (listaUsuarios.isEmpty() != true) {
            return listaUsuarios;
        }
        return null;
    }
    /*public void List<Usuario> listarClientesBD() throws SQLException {
        List<Usuario> listaUsuarios = new ArrayList<>();
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
            String usuario = rs.getString("usuario");
            String senha = rs.getString("senha");
            Usuario u = new Usuario(nome, cpf, rg, nascimento, null, null, null, endereco, telefone, email, usuario, senha, null);
            listaUsuarios.add(u);
            System.out.println("Usuário adicionado");
        }
        if (listaUsuarios.isEmpty() != true) {
            return listaUsuarios;
        }
        return null;
    }*/
}
