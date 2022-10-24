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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import locadora.locadora.database.Conexao;
import locadora.locadora.negocio.dto.Usuario;
/**
 *
 * @author Aluno
 */
public class UsuarioDAO{
    
    public static void cadastrarFuncionario(){}
    public static void removerFuncionario(){}
    public static void contagemFuncionarios(){}
    public static int numeroFuncionarios(){return 0;}
    
    public static Usuario procurarPorUsername(String username) throws SQLException{
        System.out.println("Antes conetion");
        Connection com = Conexao.getConnection();
        Statement statement = com.createStatement();
        String sql = "SELECT * FROM funcionarios";
        ResultSet rs = statement.executeQuery(sql);
        List<Usuario> listaUsuarios = new ArrayList<>();
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
            System.out.println(nome + cpf + rg + nascimento + usuario + senha);
        }
        rs.close();
        statement.close();
        Conexao.closeConnection();
        System.out.println("Depois conection");
       
        if (listaUsuarios != null) {
            for (Usuario u : listaUsuarios) {
                if (u.getUsername().equals(username)) {
                    return u;
                }
            }
        }
        return null;
    } 
    
    public static Usuario logarUsuario(String username, String senha)throws persistenciaException, SQLException{
        Usuario usuario = procurarPorUsername(username);
        
        if (usuario == null) {
            throw new persistenciaException("Username de usuário não encontrado!");
        }
        if (usuario.getSenha().equals(senha)) {
            Usuario className = usuario;
            System.out.println("Bancou aq");
            return className;
        } else {
            throw new persistenciaException("Senha incorreta!");
        }
    }
    
    public static String criptografarSenha(String senha)throws UnsupportedEncodingException, NoSuchAlgorithmException{
        MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
        byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));

        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
            hexString.append(String.format("%02X", 0xFF & b));
        }
        String senhahex = hexString.toString();
        return senhahex;
    }

}