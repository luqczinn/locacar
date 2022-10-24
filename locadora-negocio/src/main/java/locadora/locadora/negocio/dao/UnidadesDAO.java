/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.locadora.negocio.dao;

import locadora.locadora.negocio.dto.Unidades;
import java.util.List;

public class UnidadesDAO {

    public static Unidades consultarPorCep(Integer cep) {
        if (listarUnidadesBD() != null) {
            for (Unidades u : listarUnidadesBD()) {
                if (u.getCep().equals(cep)) {
                    return u;
                }
            }
        }
        return null;
    }

    public static Unidades consultarPorEndereco(String endereco) {
        if (listarUnidadesBD() != null) {
            for (Unidades u : listarUnidadesBD()) {
                if (u.getEndereco().equals(endereco)) {
                    return u;
                }
            }
        }
        return null;
    }

    public static Unidades consultarPorCodigo(Integer codigo) {
        if (listarUnidadesBD() != null) {
            for (Unidades u : listarUnidadesBD()) {
                if (u.getCodigo().equals(codigo)) {
                    return u;
                }
            }
        }
        return null;
    }

    public static Unidades consultarPorNumReferencia(Integer numReferencia) {
        if (listarUnidadesBD() != null) {
            for (Unidades u : listarUnidadesBD()) {
                if (u.getNumReferencia().equals(numReferencia)) {
                    return u;
                }
            }
        }
        return null;
    }

    public static Unidades cadastrarUnidadeBD(String endereco, Integer numReferencia, Integer codigo, Integer cep, String estado, String cidade, Integer numero, String complemento, Integer estoque, String gerente) {
        if (consultarPorCep(cep) == null | listarUnidadesBD() == null) {
            Unidades unidade = new Unidades(endereco, numReferencia, codigo, cep, estado, cidade, numero, complemento, estoque, gerente);
            // adicionar unidade ao banco de dados (REALIZADO FUTURAMENTE)
            return unidade;
        }
        return null;
    }

    public static Unidades removerUnidadeBD(Integer cep) {
        if (consultarPorCep(cep) != null) {
            Unidades unidade = consultarPorCep(cep);
            // apagar veiculo do banco de dados (REALIZADO FUTURAMENTE)
            return unidade;
        }
        return null;
    }

    public static List<Unidades> listarUnidadesBD() {
        /* PARTE DO BANCO DE DADOS (RETORNA LISTA DOS VEICULOS) if (contatoList.isEmpty() != true) {
            return contatoList;
        }
         */
        return null;
    }
}
