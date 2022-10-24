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
                if (v.getTipo() == tipo) {
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

    public static Veiculo cadastrarVeiculoBD(int ano, String placa, String marca, String tipoMotor, String modeloCarro, double kmRodados, double valorAluguel, String status, String tipo, String cambio) throws SQLException {
        if (consultarPorPlaca(placa) == null | listarVeiculosBD() == null) {
            Veiculo v = new Veiculo(ano, placa, marca, tipoMotor, modeloCarro, kmRodados, valorAluguel, status, tipo, cambio);
            Connection com = Conexao.getConnection();
            Statement statement = com.createStatement();
            String sql = "INSERT INTO veiculos VALUES("+ano+",'"+placa+"','"+marca+"','"+tipoMotor+"','"+modeloCarro+"',"+kmRodados+",'"+tipo+"',"+cambio+"',"+valorAluguel+",'"+status+"')";
            statement.executeUpdate(sql);
            Conexao.closeConnection();
            return v;
        }
        return null;
    }

    public static Veiculo removerVeiculoBD(String placa) throws SQLException {
        if (consultarPorPlaca(placa) != null) {
            Veiculo v = consultarPorPlaca(placa);
            Connection com = Conexao.getConnection();
            Statement statement = com.createStatement();
            String sql = "DELETE FROM veiculos WHERE placaCarro='"+placa+"'";
            statement.executeUpdate(sql);
            Conexao.closeConnection();
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
        Connection com = Conexao.getConnection();
        Statement statement = com.createStatement();
        String sql = "SELECT * FROM veiculos";
        ResultSet rs = statement.executeQuery(sql);
        List<Veiculo> listaVeiculos = new ArrayList<>();
        while (rs.next()) {
            int ano = Integer.valueOf(rs.getString("ano"));
            String placa = rs.getString("placaCarro");
            String marca = rs.getString("marca");
            String tipoMotor = rs.getString("tipoMotor");
            String modeloCarro = rs.getString("modelo");
            double kmRodados = rs.getDouble("km");
            String tipo = rs.getString("fim");
            String cambio = rs.getString("cambio");
            double valorAluguel = rs.getDouble("valorDiaria");
            String status = rs.getString("status");
            Veiculo v = new Veiculo(ano, placa, marca, tipoMotor, modeloCarro, kmRodados, valorAluguel, status, tipo, cambio);
            listaVeiculos.add(v);
        }
        Conexao.closeConnection();
        if (listaVeiculos.isEmpty() != true) {
            return listaVeiculos;
        }
        return null;
    }

}
