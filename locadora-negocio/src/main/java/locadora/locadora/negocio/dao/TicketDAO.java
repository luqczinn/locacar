/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.locadora.negocio.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locadora.locadora.negocio.dto.Ticket;
import locadora.locadora.database.Conexao;
import java.sql.Connection;
import java.sql.Statement;
import locadora.locadora.negocio.servico.ServicoLog;

/**
 *
 * @author Aluno
 */
public class TicketDAO {
    
    public static Ticket consultarPorId(int id) throws SQLException {
        if (listarTicketsBD() != null) {
            for (Ticket t : listarTicketsBD()) {
                if (t.getId() == id) {
                    return t;
                }
            }
        }
        return null;
    }
    public static Ticket cadastrarTicketBD(String usuarioPedido, String assunto, String descricao, String dataCriada) throws SQLException, Exception {
            List<Ticket> listaTickets = listarTicketsBD();
            int id;
            if(listaTickets == null){
                id = 1;
            }else{
                Ticket mostrarId = listaTickets.get(listaTickets.size()-1);
                id = mostrarId.getId() + 1;
            }
            Ticket t = new Ticket(id, usuarioPedido, assunto, descricao, dataCriada);
            String sql = "INSERT INTO tickets VALUES('"+id+"','"+usuarioPedido+"','"+assunto+"','"+descricao+"','"+dataCriada+"',NULL, NULL, NULL)";
            Connection com = Conexao.getConnection();
            PreparedStatement pstmt = com.prepareStatement(sql);
            pstmt.execute();
            pstmt.close();
            com.close();
            String acao = "ADICAO";
            String descricaoLog = "TICKET@" + String.valueOf(id);
            ServicoLog.registrarLogs(acao, descricaoLog, usuarioPedido);
            return t;
    }
    
    public static Ticket responderTicketBD(int id, String funcionarioResposta, String resposta, String dataRespondida)throws SQLException, Exception{
        Ticket ticket = consultarPorId(id);
        if(ticket != null){
            String sql = "UPDATE tickets SET funcionarioResposta = '"+funcionarioResposta+"', resposta= '"+resposta+"', dataRespondida = '"+dataRespondida+"' WHERE id = "+String.valueOf(id);
            Connection com = Conexao.getConnection();
            PreparedStatement pstmt = com.prepareStatement(sql);
            pstmt.execute();
            pstmt.close();
            com.close();
            String acao = "RESPOSTA";
            String descricaoLog = "TICKET@" + String.valueOf(id);
            ServicoLog.registrarLogs(acao, descricaoLog, funcionarioResposta);
            return ticket;
        }
        return null;
    }
    
    public static Ticket removerTicketBD(int id, String funcionario)throws SQLException, Exception{
        if (consultarPorId(id) != null) {
            Ticket t = consultarPorId(id);
            Connection com = Conexao.getConnection();
            Statement statement = com.createStatement();
            String sql = "DELETE FROM tickets WHERE id='"+String.valueOf(id)+"'";
            statement.executeUpdate(sql);
            String acao = "REMOCAO";
            String descricao = "TICKET@" + String.valueOf(id);
            ServicoLog.registrarLogs(acao, descricao, funcionario);
            return t;
        }
        return null;
    }
    
    public static List<Ticket> listarTicketsBD() throws SQLException {
        String sql = "SELECT * FROM tickets";
        Connection com = Conexao.getConnection();
        PreparedStatement stmt = com.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        List<Ticket> listaTickets = new ArrayList<>();
        while (rs.next()) {
            int id = (rs.getInt("id"));
            String usuarioPedido = rs.getString("usuarioPedido");
            String assunto = rs.getString("assunto");
            String descricao = rs.getString("descricao");
            String dataCriada = rs.getString("dataCriada");
            String funcionarioResposta = rs.getString("funcionarioResposta");
            String resposta = rs.getString("resposta");
            String dataRespondida = rs.getString("dataRespondida");
            Ticket t = new Ticket(id, usuarioPedido, assunto, descricao, dataCriada, funcionarioResposta, resposta, dataRespondida);
            listaTickets.add(t);
        }
        if (listaTickets.isEmpty() != true) {
            return listaTickets;
        }
        return null;
    }

}
