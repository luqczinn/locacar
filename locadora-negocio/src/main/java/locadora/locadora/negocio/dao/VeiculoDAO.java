/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.locadora.negocio.dao;

import locadora.locadora.negocio.dto.Veiculo;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Aluno
 */



/**
 *
 * @author Aluno
 */
public class VeiculoDAO {

    public static List<Veiculo> consultarPorAno(int ano) {
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
    
    public static List<Veiculo> consultarPorMarca(String marca) {
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
    
    public static List<Veiculo> consultarPorMotor(String motor) {
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
    
    public static List<Veiculo> consultarPorModelo(String modelo) {
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
    
    public static List<Veiculo> consultarPorKm(int kmRodados) {
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
    
    public static List<Veiculo> consultarPorFaixaValores(double minimo, double maximo) {
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
    
    public static List<Veiculo> consultarPorStatus(String status) {
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
    
    public static Veiculo consultarPorPlaca(String placa) {
        if (listarVeiculosBD() != null) {
            for (Veiculo v : listarVeiculosBD()) {
                if (v.getPlaca().equals(placa)) {
                    return v;
                }
            }
        }
        return null;
    }

    public static Veiculo cadastrarVeiculoBD(int ano, String placa, String marca, String tipoMotor, String modeloCarro, int kmRodados, double valorAluguel, String status) {
        if (consultarPorPlaca(placa) == null | listarVeiculosBD() == null) {
            Veiculo v = new Veiculo(ano, placa, marca, tipoMotor, modeloCarro, kmRodados, valorAluguel, status);
            // adicionar veiculo ao banco de dados (REALIZADO FUTURAMENTE)
            return v;
        }
        return null;
    }

    public static Veiculo removerVeiculoBD(String placa) {
        if (consultarPorPlaca(placa) != null) {
            Veiculo v = consultarPorPlaca(placa);
            // apagar veiculo do banco de dados (REALIZADO FUTURAMENTE)
            return v;
        }
        return null;
    }

    public static String statusVeiculoBD(String placa) {
        if (consultarPorPlaca(placa) != null) {
            Veiculo v = consultarPorPlaca(placa);
            return v.getStatus();
        }
        return null;
    }

    public static List<Veiculo> listarVeiculosBD() {
        /* PARTE DO BANCO DE DADOS (RETORNA LISTA DOS VEICULOS) if (contatoList.isEmpty() != true) {
            return contatoList;
        }
         */
        return null;
    }

}
