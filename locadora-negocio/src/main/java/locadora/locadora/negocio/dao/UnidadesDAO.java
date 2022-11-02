/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.locadora.negocio.dao;

import locadora.locadora.negocio.dto.Unidades;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import locadora.locadora.database.Conexao;

public class UnidadesDAO {

    public static Unidades consultarPorCep(String cep) throws SQLException {
        if (listarUnidadesBD() != null) {
            for (Unidades u : listarUnidadesBD()) {
                if (u.getCep().equals(cep)) {
                    return u;
                }
            }
        }
        return null;
    }

    public static Unidades consultarPorLogradouro(String logradouro) throws SQLException {
        if (listarUnidadesBD() != null) {
            for (Unidades u : listarUnidadesBD()) {
                if (u.getEndereco().equals(logradouro)) {
                    return u;
                }
            }
        }
        return null;
    }
    
    public static Unidades consultarPorEndereco(String logradouro, Integer numero, String cidade, String estado, Integer cep) throws SQLException {
        String endereco = logradouro + ", " + String.valueOf(numero) + " - " + cidade + " - " + estado + ", " + String.valueOf(cep);
        if (listarUnidadesBD() != null) {
            for (Unidades u : listarUnidadesBD()) {
                if (u.getEndereco().equals(endereco)) {
                    return u;
                }
            }
        }
        return null;
    }

    public static List<Unidades> consultarPorEstado(String estado) throws SQLException {
        List<Unidades> listaConsulta = new ArrayList<>();
        if (listarUnidadesBD() != null) {
            for (Unidades u : listarUnidadesBD()) {
                if (u.getEstado().equals(estado)) {
                    listaConsulta.add(u);
                }
            }
            return listaConsulta;
        }
        return null;
    }
    
    public static List<Unidades> consultarPorCidade(String cidade) throws SQLException {
        List<Unidades> listaConsulta = new ArrayList<>();
        if (listarUnidadesBD() != null) {
            for (Unidades u : listarUnidadesBD()) {
                if (u.getCidade().equals(cidade)) {
                    listaConsulta.add(u);
                }
            }
            return listaConsulta;
        }
        return null;
    }

    public static Unidades cadastrarUnidadeBD(String logradouro, String referencia, String cep, String estado, String cidade, Integer numero, String complemento, Integer estoque, String gerente) throws SQLException {
        if (consultarPorCep(cep) == null | listarUnidadesBD() == null) {
            String endereco = logradouro + ", " + String.valueOf(numero) + " - " + cidade + " - " + estado + ", " + cep;
            Unidades u = new Unidades(logradouro, referencia, cep, estado, cidade, numero, complemento, estoque, gerente, endereco);
            String sql = "INSERT INTO unidades VALUES('"+estado+"','"+cidade+"','"+logradouro+"','"+numero+"','"+cep+"','"+complemento+"','"+referencia+"',"+estoque+",'"+gerente+"')";
            Connection com = Conexao.getConnection();
            PreparedStatement pstmt = com.prepareStatement(sql);
            pstmt.execute();
            pstmt.close();
            com.close();
            return u;
        }
        return null;
    }

    public static Unidades removerUnidadeBD(String cep) throws SQLException {
        if (consultarPorCep(cep) != null) {
            Unidades u = consultarPorCep(cep);
            Connection com = Conexao.getConnection();
            Statement statement = com.createStatement();
            String sql = "DELETE FROM unidades WHERE cep='"+cep+"'";
            statement.executeUpdate(sql);
            return u;
        }
        return null;
    }

    public static List<Unidades> listarUnidadesBD() throws SQLException {
        String sql = "SELECT * FROM unidades";
        Connection com = Conexao.getConnection();
        PreparedStatement stmt = com.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        List<Unidades> listaUnidades = new ArrayList<>();
        while (rs.next()) {
            String estado = (rs.getString("estado"));
            String cidade = rs.getString("cidade");
            String logradouro = rs.getString("logradouro");
            int numero = rs.getInt("numero");
            String cep = (rs.getString("cep"));
            String complemento = rs.getString("complemento");
            String referencia = rs.getString("referencia");
            int estoque = Integer.valueOf(rs.getString("estoque"));
            String gerente = rs.getString("gerente");
            String endereco = logradouro + ", " + String.valueOf(numero) + " - " + cidade + " - " + estado + ", " + String.valueOf(cep);
            Unidades u = new Unidades(logradouro, referencia, cep, estado, cidade, numero, complemento, estoque, gerente, endereco);
            listaUnidades.add(u);
        }
        if (listaUnidades.isEmpty() != true) {
            return listaUnidades;
        }
        return null;
    }
}
