/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.locadora.negocio.servico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import locadora.locadora.database.Conexao;
import locadora.locadora.negocio.dto.Log;
import locadora.locadora.negocio.dto.Usuario;

/**
 *
 * @author Aluno
 */
public class ServicoLog {

    //registrar o log de usuarios
    public static void registrarLogUsuario(Usuario usuario) throws Exception {
        //insere no bd qual foi o usuario logado de acordo c o username 
        LocalDateTime dataHora = LocalDateTime.now();
        DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String data = dataHora.format(dataFormatada);
        String sql = "INSERT INTO log VALUES ('"
                + usuario.getNome() + "', '"
                + usuario.getCargo() + "', '"
                + data + "')";
        System.out.println(usuario.getNome() + "/ " + usuario.getCargo() + "logou no sistema às: " + data + ".");
        Connection com = Conexao.getConnection();
        PreparedStatement pstmt = com.prepareStatement(sql);
        pstmt.execute();
        com.close();
        pstmt.close();
    }

    //função para pegar ultimos usuarios logados
    public static List<Log> usuariosLogados() throws Exception {
        String sql = "SELECT * FROM log ORDER BY horaLogin desc LIMIT 10";
        Connection com = Conexao.getConnection();
        PreparedStatement pstmt = com.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery(sql);
        List<Log> lista = new ArrayList<>();
        while (rs.next()) {
            String cargo = rs.getString("cargo");
            String nome = rs.getString("funcionario");
            String horario = rs.getString("horaLogin");
            lista.add(new Log(nome, cargo, horario));
        }
        com.close();
        rs.close();
        pstmt.close();
        if (lista.isEmpty() != true) {
            return lista;
        }
        return null;
    }

//registrar log de cadastro ou exclusao de veiculo
    public static void registrarLogs(String acao, String descricao, String usuario) throws Exception {
        //insere no bd qual foi o veiculo e qual a ação que sofreu
        LocalDateTime dataHora = LocalDateTime.now();
        DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String sql = "INSERT INTO logs VALUES ("
                + acao + ", "
                + descricao + ", "
                + usuario + ","
                + dataHora.format(dataFormatada) + ");";
        Connection com = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            com = Conexao.getConnection();
            pstmt = com.prepareStatement(sql);;
            rs = pstmt.executeQuery(sql);
        } catch (Exception erro) {
            throw new Exception(erro.getMessage());
        } finally {
            try {

                if (com != null) {
                    com.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (Exception erro) {
                throw new Exception(erro.getMessage());
            }
        }
    }
}
