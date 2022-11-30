/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.locadora.negocio.dao;

import locadora.locadora.negocio.dto.Veiculo;
import locadora.locadora.database.Conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import locadora.locadora.negocio.servico.ServicoLog;

public class VeiculoDAO {

    public static List<Veiculo> consultarPorAno(int ano) throws SQLException {
        List<Veiculo> listaConsulta = new ArrayList<>();
        if (listarVeiculosBD() != null) {
            for (Veiculo v : listarVeiculosBD()) {
                if (v.getAno() == ano) {
                    listaConsulta.add(v);
                }
            }
            return listaConsulta;
        }
        return null;
    }

    public static List<Veiculo> consultarPorMarca(String marca) throws SQLException {
        List<Veiculo> listaConsulta = new ArrayList<>();
        if (listarVeiculosBD() != null) {
            for (Veiculo v : listarVeiculosBD()) {
                if (v.getMarca().equals(marca)) {
                    listaConsulta.add(v);
                }
            }
            return listaConsulta;
        }
        return null;
    }

    public static List<Veiculo> consultarPorMotor(String motor) throws SQLException {
        List<Veiculo> listaConsulta = new ArrayList<>();
        if (listarVeiculosBD() != null) {
            for (Veiculo v : listarVeiculosBD()) {
                if (v.getTipoMotor().equals(motor)) {
                    listaConsulta.add(v);
                }
            }
            return listaConsulta;
        }
        return null;
    }
    public static void alugarVeiculo(String placa, String usuario) throws SQLException, Exception {
        if (consultarPorPlaca(placa) == null | listarVeiculosBD() == null) {
            String sql = "UPDATE veiculos SET situacao = 'Alugado' WHERE placa = '" +placa+ "';";
            Connection com = Conexao.getConnection();
            PreparedStatement pstmt = com.prepareStatement(sql);
            pstmt.execute();
            pstmt.close();
            com.close();
            String acao = "ALTEROU";
            String descricao = "VEICULO@" + placa + "@Alugado";
            ServicoLog.registrarLogs(acao, descricao, usuario);
        }
    }
    public static List<Veiculo> consultarPorModelo(String modelo) throws SQLException {
        List<Veiculo> listaConsulta = new ArrayList<>();
        if (listarVeiculosBD() != null) {
            for (Veiculo v : listarVeiculosBD()) {
                if (v.getModeloCarro().equals(modelo)) {
                    listaConsulta.add(v);
                }
            }
            return listaConsulta;
        }
        return null;
    }

    public static List<Veiculo> consultarPorKm(int kmRodados) throws SQLException {
        List<Veiculo> listaConsulta = new ArrayList<>();
        if (listarVeiculosBD() != null) {
            for (Veiculo v : listarVeiculosBD()) {
                if (v.getKmRodados() == kmRodados) {
                    listaConsulta.add(v);
                }
            }
            return listaConsulta;
        }
        return null;
    }

    public static List<Veiculo> consultarPorFaixaValores(double minimo, double maximo) throws SQLException {
        List<Veiculo> listaConsulta = new ArrayList<>();
        if (listarVeiculosBD() != null) {
            for (Veiculo v : listarVeiculosBD()) {
                if (v.getValorAluguel() >= minimo && v.getValorAluguel() <= maximo) {
                    listaConsulta.add(v);
                }
            }
            return listaConsulta;
        }
        return null;
    }

    public static List<Veiculo> consultarPorStatus(String status) throws SQLException {
        List<Veiculo> listaConsulta = new ArrayList<>();
        if (listarVeiculosBD() != null) {
            for (Veiculo v : listarVeiculosBD()) {
                if (v.getStatus().equals(status)) {
                    listaConsulta.add(v);
                }
            }
            return listaConsulta;
        }
        return null;
    }

    public static Veiculo consultarPorPlaca(String placa) throws SQLException {
        if (listarVeiculosBD() != null) {
            for (Veiculo v : listarVeiculosBD()) {
                if (v.getPlaca().equals(placa)) {
                    return v;
                }
            }
        }
        return null;
    }

    public static List<Veiculo> consultarPorTipo(String tipo) throws SQLException {
        List<Veiculo> listaConsulta = new ArrayList<>();
        if (listarVeiculosBD() != null) {
            for (Veiculo v : listarVeiculosBD()) {
                if (v.getTipo().equals(tipo)) {
                    listaConsulta.add(v);
                }
            }
            return listaConsulta;
        }
        return null;
    }

    public static List<Veiculo> consultarPorCambio(String cambio) throws SQLException {
        List<Veiculo> listaConsulta = new ArrayList<>();
        if (listarVeiculosBD() != null) {
            for (Veiculo v : listarVeiculosBD()) {
                if (v.getCambio().equals(cambio)) {
                    listaConsulta.add(v);
                }
            }
            return listaConsulta;
        }
        return null;
    }

    public static Veiculo cadastrarVeiculoBD(int ano, String placa, String marca, String tipoMotor, String modeloCarro, double kmRodados, double valorAluguel, String status, String tipo, String cambio, String imagem, String usuario) throws SQLException, Exception {
        if (consultarPorPlaca(placa) == null | listarVeiculosBD() == null) {
            Veiculo v = new Veiculo(ano, placa, marca, tipoMotor, modeloCarro, kmRodados, valorAluguel, status, tipo, cambio, imagem);
            String sql = "INSERT INTO veiculos VALUES("+ano+",'"+placa+"','"+marca+"','"+tipoMotor+"','"+modeloCarro+"',"+kmRodados+",'"+tipo+"','"+cambio+"',"+valorAluguel+",'"+status+"','"+imagem+"')";
            Connection com = Conexao.getConnection();
            PreparedStatement pstmt = com.prepareStatement(sql);
            pstmt.execute();
            pstmt.close();
            com.close();
            String acao = "ADICAO";
            String descricao = "VEICULO@" + placa;
            ServicoLog.registrarLogs(acao, descricao, usuario);
            return v;
        }
        return null;
    }

    public static Veiculo removerVeiculoBD(String placa, String usuario) throws SQLException, Exception {
        if (consultarPorPlaca(placa) != null) {
            Veiculo v = consultarPorPlaca(placa);
            Connection com = Conexao.getConnection();
            Statement statement = com.createStatement();
            String sql = "DELETE FROM veiculos WHERE placaCarro='"+placa+"'";
            statement.executeUpdate(sql);
            String acao = "REMOCAO";
            String descricao = "VEICULO@" + placa;
            ServicoLog.registrarLogs(acao, descricao, usuario);
            return v;
        }
        return null;
    }

    public static String statusVeiculoBD(String placa) throws SQLException {
        if (consultarPorPlaca(placa) != null) {
            Veiculo v = consultarPorPlaca(placa);
            return v.getStatus();
        }
        return null;
    }

    public static List<Veiculo> listarVeiculosBD() throws SQLException {
        List<Veiculo> listaVeiculos = new ArrayList<>();
        String sql = "SELECT * FROM veiculos";
        Connection com = Conexao.getConnection();
        PreparedStatement stmt = com.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
            int ano = (rs.getInt("ano"));
            String placa = rs.getString("placaCarro");
            String marca = rs.getString("marca");
            String tipoMotor = rs.getString("tipoMotor");
            String modeloCarro = rs.getString("modelo");
            double kmRodados = rs.getDouble("km");
            String tipo = rs.getString("tipoDeCarro");
            String cambio = rs.getString("cambio");
            double valorAluguel = rs.getDouble("valorDiaria");
            String status = rs.getString("situacao");
            String imagem = rs.getString("imagem");
            Veiculo v = new Veiculo(ano, placa, marca, tipoMotor, modeloCarro, kmRodados, valorAluguel, status, tipo, cambio, imagem);
            listaVeiculos.add(v);
        }
        if (listaVeiculos.isEmpty() != true) {
            return listaVeiculos;
        }
        return null;
    }

}
