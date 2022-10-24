/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.locadora.negocio.servico;

import locadora.locadora.negocio.excessoes.negocioException;
import locadora.locadora.negocio.excessoes.persistenciaException;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.List;
import locadora.locadora.negocio.dao.UnidadesDAO;
import locadora.locadora.negocio.dto.Unidades;

/**
 *
 * @author Aluno
 */
public class ServicoUnidades {

    private ServicoUnidades() {
    }

    public static Unidades consultarPorEndereco(String logradouro, Integer numero, String cidade, String estado, Integer cep) throws negocioException, SQLException {

        if (logradouro.isEmpty()) {
            throw new negocioException(319, "Insira o logradouro da unidade!");
        }
        if (numero == 0) {
            throw new negocioException(319, "Insira o número da unidade!");
        }
        if (cidade.isEmpty()) {
            throw new negocioException(319, "Insira a cidade da unidade!");
        }
        if (estado.isEmpty()) {
            throw new negocioException(319, "Insira o estado da unidade!");
        }
        if (cep == 0) {
            throw new negocioException(319, "Insira o cep da unidade!");
        }

        return UnidadesDAO.consultarPorEndereco(logradouro, numero, cidade, estado, cep);
    }

    public static Unidades consultarPorCep(Integer cep) throws negocioException, SQLException {

        if (cep < 0) //futura verificaçao 
        {
            throw new negocioException(319, "Insira o CEP da unidade!");
        }

        return UnidadesDAO.consultarPorCep(cep);
    }
    
    public static List<Unidades> consultarPorEstado(String estado) throws negocioException, SQLException {

        if (estado.isEmpty()) //futura verificaçao 
        {
            throw new negocioException(319, "Insira o estado da unidade!");
        }

        return UnidadesDAO.consultarPorEstado(estado);
    }
    
    public static List<Unidades> consultarPorCidade(String cidade) throws negocioException, SQLException {

        if (cidade.isEmpty()) //futura verificaçao 
        {
            throw new negocioException(319, "Insira a cidade da unidade!");
        }

        return UnidadesDAO.consultarPorCidade(cidade);
    }


    public static Unidades inserirUnidadeBD(String logradouro, String referencia, Integer cep, String estado, String cidade, Integer numero, String complemento, Integer estoque, String gerente) throws negocioException, SQLException {
        if (logradouro.isEmpty()) {
            throw new negocioException(319, "O logradouro é obrigatório.");
        }
        if (referencia.isEmpty()) {
            throw new negocioException(319, "A referência da unidade é obrigatório.");
        }
        if (cep < 0) {
            throw new negocioException(319, "O CEP é obrigatório.");
        }
        if (estado.isEmpty()) {
            throw new negocioException(319, "O estado da unidade é obrigatório.");
        }
        if (cidade.isEmpty()) {
            throw new negocioException(319, "A cidade da unidade é obrigatória.");
        }
        if (numero < 0) {
            throw new negocioException(319, "O número é obrigatório.");
        }
        if (complemento.isEmpty()) {
            throw new negocioException(319, "O complemento é obrigatório.");
        }
        if (estoque < 0) {
            throw new negocioException(319, "O estoque é obrigatório.");
        }
        if (gerente.isEmpty()) {
            throw new negocioException(319, "O gerente é obrigatório.");
        }

        return UnidadesDAO.cadastrarUnidadeBD(logradouro, referencia, cep, estado, cidade, numero, complemento, estoque, gerente);
    }

    public static Unidades removerUnidadePorCEP(Integer cep) throws negocioException, SQLException {
        if (cep < 0) {
            throw new negocioException(319, "Informe o CEP da unidade");
        }

        return UnidadesDAO.removerUnidadeBD(cep);
    }

    public static List<Unidades> listarVeiculos() throws negocioException, SQLException {
        if (UnidadesDAO.listarUnidadesBD() == null) {
            throw new negocioException(315, "Não existem unidades cadastrados!");
        }

        return UnidadesDAO.listarUnidadesBD();
    }

}
