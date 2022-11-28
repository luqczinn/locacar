package locadora.locadora.negocio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import locadora.locadora.negocio.dto.Reservas;
import java.util.List;
import locadora.locadora.database.Conexao;
import locadora.locadora.negocio.servico.ServicoLog;

public class ReservasDAO {

    
    public static Reservas consultarPorCliente(String cliente) throws SQLException {
        if (listarReservasBD() != null) {
            for (Reservas r : listarReservasBD()) {
                if (r.getCliente().equals(cliente)) {
                    return r;
                }
            }
        }
        return null;
    }
    public static Reservas consultarPorCodigo(Integer codigo) throws SQLException {
        if (listarReservasBD() != null) {
            for (Reservas r : listarReservasBD()) {
                if (r.getCodigo() == codigo) {
                    return r;
                }
            }
        }
        return null;
    }

    public static Reservas cadastrarReservasBD(Integer codigo, String cliente, String vendedor, String veiculo, String unidade, String inicio, String fim, String valorDiaria, String valorReserva, String usuario) throws SQLException, Exception {
        if (consultarPorCodigo(codigo) == null) {
            Reservas reserva = new Reservas(codigo, cliente, vendedor, veiculo, unidade, inicio, fim, valorDiaria, valorReserva);
            String sql = "INSERT INTO reservas VALUES(" + codigo + ",'" + cliente + "','" + vendedor + "','" + veiculo + "','" + unidade + "','" + inicio + "','" + fim + "','" + valorDiaria + "','" + valorReserva + "')";
            Connection com = Conexao.getConnection();
            PreparedStatement pstmt = com.prepareStatement(sql);
            pstmt.execute();
            pstmt.close();
            com.close();
            String acao = "ADICAO";
            String descricao = "RESERVA@" + codigo;
            ServicoLog.registrarLogs(acao, descricao, usuario);
            System.out.println("Chegou no DAO");
            return reserva;
        }
        return null;
    }

    public static List<Reservas> listarReservasBD() throws SQLException {
        String sql = "SELECT * FROM reservas";
        Connection com = Conexao.getConnection();
        PreparedStatement stmt = com.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        List<Reservas> listaReservas = new ArrayList<>();
        while (rs.next()) {
            Integer codigo = Integer.valueOf(rs.getString("codigo"));
            String cliente = rs.getString("cliente");
            String vendedor = rs.getString("vendedor");
            String veiculo = rs.getString("veiculo");
            String unidade = rs.getString("unidade");
            String inicio = rs.getString("inicio");
            String fim = rs.getString("fim");
            String valorDiaria = rs.getString("valorDiaria");
            String valorReserva = rs.getString("valorReserva");
            Reservas r = new Reservas(codigo, cliente, vendedor, veiculo, unidade, inicio, fim, valorDiaria, valorReserva);
            listaReservas.add(r);
        }
        if (listaReservas.isEmpty() != true) {
            return listaReservas;
        }
        return null;
    }
    
    public static Reservas removerReservaBD(Integer codigo) throws SQLException {
        if (consultarPorCodigo(codigo) != null) {
            Reservas r = consultarPorCodigo(codigo);
            Connection com = Conexao.getConnection();
            Statement statement = com.createStatement();
            String sql = "DELETE FROM reservas WHERE codigo='"+codigo+"'";
            statement.executeUpdate(sql);
            return r;
        }
        return null;
    }
}
