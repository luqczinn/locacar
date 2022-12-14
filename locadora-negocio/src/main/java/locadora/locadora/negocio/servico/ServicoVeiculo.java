/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.locadora.negocio.servico;

import locadora.locadora.negocio.dao.VeiculoDAO;
import locadora.locadora.negocio.dto.Veiculo;
import locadora.locadora.negocio.excessoes.negocioException;
import locadora.locadora.negocio.excessoes.persistenciaException;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class ServicoVeiculo {    
    private ServicoVeiculo(){ }
    
    public static List<Veiculo> consultarPorAno(String ano) throws negocioException, SQLException{
        
        if(ano.isEmpty())
            throw new negocioException(319, "Insira o ano dos veículos!");
        
        return VeiculoDAO.consultarPorAno(parseInt(ano));
    }
    
    public static Veiculo consultarPorPlaca(String placa) throws negocioException, SQLException{
        
        if(placa.isEmpty())
            throw new negocioException(319, "Insira a placa do veículo!");
        
        return VeiculoDAO.consultarPorPlaca(placa);
    }
    
    public static List<Veiculo> consultarPorMarca(String marca) throws negocioException, SQLException{
        
        if(marca.isEmpty())
            throw new negocioException(319, "Insira a marca dos veículos!");
        
        return VeiculoDAO.consultarPorMarca(marca);
    }
    
    public static List<Veiculo> consultarPorMotor(String motor) throws negocioException, SQLException{
        
        if(motor.isEmpty())
            throw new negocioException(319, "Insira o motor dos veículos!");
        
        return VeiculoDAO.consultarPorMotor(motor);
    }
    
    public static List<Veiculo> consultarPorModelo(String modelo) throws negocioException, SQLException{
        
        if(modelo.isEmpty())
            throw new negocioException(319, "Insira o modelo dos veículos!");
        
        return VeiculoDAO.consultarPorModelo(modelo);
    }
    
    public static List<Veiculo> consultarPorKm(String kmRodados) throws negocioException, SQLException{
        
        if(kmRodados.isEmpty())
            throw new negocioException(319, "Insira o número de km dos veículos!");
        
        return VeiculoDAO.consultarPorKm(parseInt(kmRodados));
    }
    
    public static List<Veiculo> consultarPorFaixaValores(double minimo, double maximo) throws negocioException, SQLException{
        
        if(minimo < 0)
            throw new negocioException(319, "Valor impossível!");
        
        return VeiculoDAO.consultarPorFaixaValores(minimo, maximo);
    }
    
    public static List<Veiculo> consultarPorStatus(String status) throws negocioException, SQLException{
        
        if(status.isEmpty())
            throw new negocioException(319, "Insira o status dos veículos!");
        
        return VeiculoDAO.consultarPorStatus(status);
    }
    
    public static List<Veiculo> consultarPorTipo(String tipo) throws negocioException, SQLException{
        
        if(tipo.isEmpty())
            throw new negocioException(319, "Insira o tipo do veículos!");
        
        return VeiculoDAO.consultarPorTipo(tipo);
    }
    
    public static List<Veiculo> consultarPorCambio(String cambio) throws negocioException, SQLException{
        
        if(cambio.isEmpty())
            throw new negocioException(319, "Insira o câmbio dos veículos!");
        
        return VeiculoDAO.consultarPorCambio(cambio);
    }
    
    public static Veiculo inserirVeiculoBD(String anoS, String placa, String marca, String tipoMotor, String modeloCarro, String kmRodados, String valorAluguel, String status, String tipo, String cambio, String imagem, String usuario) throws negocioException, SQLException, Exception{
        int ano = Integer.parseInt(anoS);
        if (ano < 1999 && ano > 2022)
            throw new negocioException(319, "O ano do veículo é inválido.");
        if (placa.isEmpty())
            throw new negocioException(319, "A placa é obrigatória.");
        if (marca.isEmpty())
            throw new negocioException(319, "A marca é obrigatório.");
        if (tipoMotor.isEmpty())
            throw new negocioException(319, "O tipo do motor é obrigatório.");
        if (modeloCarro.isEmpty())
            throw new negocioException(319, "O modelo é obrigatório.");
        if (kmRodados.isEmpty())
            throw new negocioException(319, "O número de km rodados é obrigatório.");
        if (valorAluguel.isEmpty())
            throw new negocioException(319, "O valor de aluguel é obrigatório.");
        if (status.isEmpty())
            throw new negocioException(319, "O status do veículo é obrigatório.");
        if (imagem.isEmpty())
            throw new negocioException(319, "A imagem do veículo é obrigatório.");
        
        return VeiculoDAO.cadastrarVeiculoBD(ano, placa, marca, tipoMotor, modeloCarro, parseDouble(kmRodados), parseDouble(valorAluguel), status, tipo, cambio, imagem, usuario);
    }
    
    public static Veiculo removerVeiculoPorPlaca(String placa, String usuario) throws negocioException, SQLException, Exception{
        if(placa.isEmpty())
            throw new negocioException (319, "Informe a placa para remover o veículo");
        
        return VeiculoDAO.removerVeiculoBD(placa, usuario);
    }
    
    public static List<Veiculo> listarVeiculos() throws negocioException, SQLException{
        if(VeiculoDAO.listarVeiculosBD() == null)
            throw new negocioException (315, "Não existem veículos cadastrados!");
        
        return VeiculoDAO.listarVeiculosBD();
    }
    
}
