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

    public static Unidades consultarPorEndereco(String logradouro, String numero, String cidade, String estado, String cep) throws negocioException, SQLException {

        if (logradouro.isEmpty()) {
            throw new negocioException(319, "Insira o logradouro da unidade!");
        }
        if (numero.isEmpty()) {
            throw new negocioException(319, "Insira o número da unidade!");
        }
        if (cidade.isEmpty()) {
            throw new negocioException(319, "Insira a cidade da unidade!");
        }
        if (estado.isEmpty()) {
            throw new negocioException(319, "Insira o estado da unidade!");
        }
        if (cep.isEmpty()) {
            throw new negocioException(319, "Insira o cep da unidade!");
        }

        return UnidadesDAO.consultarPorEndereco(logradouro, Integer.valueOf(numero), cidade, estado, Integer.valueOf(cep));
    }

    public static Unidades consultarPorCep(String cep) throws negocioException, SQLException {

        if (cep.isEmpty()) //futura verificaçao 
        {
            throw new negocioException(319, "Insira o CEP da unidade!");
        }
        if(String.valueOf(cep).length() != 11)
            throw new negocioException(315, "O CEP não está correto!");
        
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


    public static Unidades inserirUnidadeBD(String logradouro, String referencia, String cep, String estado, String cidade, String numero, String complemento, String estoque, String gerente, String usuario) throws negocioException, SQLException, Exception {
        if (logradouro.isEmpty()) {
            throw new negocioException(319, "O logradouro é obrigatório.");
        }
        if (referencia.isEmpty()) {
            throw new negocioException(319, "A referência da unidade é obrigatório.");
        }
        if (cep.isEmpty()) {
            throw new negocioException(319, "O CEP é obrigatório.");
        }
        if (estado.isEmpty()) {
            throw new negocioException(319, "O estado da unidade é obrigatório.");
        }
        if (cidade.isEmpty()) {
            throw new negocioException(319, "A cidade da unidade é obrigatória.");
        }
        if (numero.isEmpty()) {
            throw new negocioException(319, "O número é obrigatório.");
        }
        if (complemento.isEmpty()) {
            throw new negocioException(319, "O complemento é obrigatório.");
        }
        if (estoque.isEmpty()) {
            throw new negocioException(319, "O estoque é obrigatório.");
        }
        if (gerente.isEmpty()) {
            throw new negocioException(319, "O gerente é obrigatório.");
        }
        
        return UnidadesDAO.cadastrarUnidadeBD(logradouro, referencia, cep, estado, cidade, Integer.valueOf(numero), complemento, Integer.valueOf(estoque), gerente, usuario);
    }

    public static Unidades removerUnidadePorCEP(String cep, String usuario) throws negocioException, SQLException, Exception {
        if (cep.isEmpty()) {
            throw new negocioException(319, "Informe o CEP da unidade");
        }

        return UnidadesDAO.removerUnidadeBD(cep, usuario);
    }

    public static List<Unidades> listarUnidades() throws negocioException, SQLException {
        if (UnidadesDAO.listarUnidadesBD() == null) {
            throw new negocioException(315, "Não existem unidades cadastrados!");
        }

        return UnidadesDAO.listarUnidadesBD();
    }

}
