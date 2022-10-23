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
import java.util.List;
import locadora.locadora.negocio.dao.UnidadesDAO;
import locadora.locadora.negocio.dto.Unidades;

/**
 *
 * @author Aluno
 */
public class ServicoUnidades {
    
    private ServicoUnidades(){ }
    
    public static Unidades consultarPorEndereco(String endereco) throws negocioException{
        
        if(endereco.isEmpty())
            throw new negocioException(319, "Insira o endereço da unidade!");
        
        return UnidadesDAO.consultarPorEndereco(endereco);
    }
    
    public static Unidades consultarPorCep(Integer cep) throws negocioException{
        
        if(cep < 0) //futura verificaçao 
            throw new negocioException(319, "Insira o CEP da unidade!");
        
        return UnidadesDAO.consultarPorCep(cep);
    }
    
    public static Unidades consultarPorCodigo(Integer codigo) throws negocioException{
        
        if(codigo < 0) //futura verificaçao 
            throw new negocioException(319, "Insira o código da unidade!");
        
        return UnidadesDAO.consultarPorCodigo(codigo);
    }
    
    public static Unidades consultarPorNumReferencia(Integer numReferencia) throws negocioException{
        
        if(numReferencia < 0) //futura verificaçao 
            throw new negocioException(319, "Insira o número de referência da unidade!");
        
        return UnidadesDAO.consultarPorNumReferencia(numReferencia);
    }
    
    public static Unidades inserirUnidadeBD(String endereco, Integer numReferencia, Integer codigo, Integer cep) throws negocioException{
        if (endereco.isEmpty())
            throw new negocioException(319, "O endereço é obrigatório.");
        if (numReferencia < 0)
            throw new negocioException(319, "O número de referência da unidade é obrigatório.");
        if (codigo < 0)
            throw new negocioException(319, "O código é obrigatório.");
        if (cep < 0)
            throw new negocioException(319, "O CEP é obrigatório.");
        
        return UnidadesDAO.cadastrarUnidadeBD(endereco, numReferencia, codigo, cep);
    }
    
    public static Unidades removerUnidadePorCEP(Integer cep) throws negocioException{
        if(cep < 0)
            throw new negocioException (319, "Informe o CEP o veículo");
        
        return UnidadesDAO.removerUnidadeBD(cep);
    }
    
    public static List<Unidades> listarVeiculos() throws negocioException{
        if(UnidadesDAO.listarUnidadesBD() == null)
            throw new negocioException (315, "Não existem unidades cadastrados!");
        
        return UnidadesDAO.listarUnidadesBD();
    }
    
}
