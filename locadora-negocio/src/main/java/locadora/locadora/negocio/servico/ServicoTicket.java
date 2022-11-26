/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.locadora.negocio.servico;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;
import locadora.locadora.negocio.dao.TicketDAO;
import locadora.locadora.negocio.dto.Ticket;
import locadora.locadora.negocio.excessoes.negocioException;

/**
 *
 * @author Aluno
 */
public class ServicoTicket {
    
    private ServicoTicket() {}
    
    public static void cadastrarTicket(String usuarioPedido, String assunto, String descricao, String dataCriada)throws negocioException, SQLException, UnsupportedEncodingException, NoSuchAlgorithmException, Exception{
        if(usuarioPedido.isEmpty()){
            throw new negocioException(319, "Insira o usuário!");
        }
        if(assunto.isEmpty()){
            throw new negocioException(319, "Insira o assunto!");
        }
        if(descricao.isEmpty()){
            throw new negocioException(319, "Insira a descrição!");
        }
        if(dataCriada.isEmpty()){
            throw new negocioException(319, "Data para criação do ticket não encontrada!");
        }
            TicketDAO.cadastrarTicketBD(usuarioPedido, assunto, descricao, dataCriada);

    }
    
    public static void responderTicket(int id, String funcionarioResposta, String resposta, String dataRespondida)throws negocioException, SQLException, UnsupportedEncodingException, NoSuchAlgorithmException, Exception{
        if(funcionarioResposta.isEmpty()){
            throw new negocioException(319, "Insira o funcionario!");
        }
        if(resposta.isEmpty()){
            throw new negocioException(319, "Insira a resposta!");
        }
        if(dataRespondida.isEmpty()){
            throw new negocioException(319, "Data para resposta do ticket não encontrada!");
        }
            TicketDAO.responderTicketBD(id, funcionarioResposta, resposta, dataRespondida);

    }
    
    public static Ticket removerTicket(int id, String funcionario)throws negocioException, SQLException, UnsupportedEncodingException, NoSuchAlgorithmException, Exception{
        if(id == 0){
            throw new negocioException(319, "Ticket não encotrado!");
        }
        if(funcionario.isEmpty()){
            throw new negocioException(319, "Usuário não informado!");
        }
        
            return TicketDAO.removerTicketBD(id, funcionario);
    }
    
    public static List<Ticket> listarTickets() throws negocioException, SQLException {
        if (TicketDAO.listarTicketsBD() == null) {
            throw new negocioException(315, "Não existem tickets cadastrados");
        }

        return TicketDAO.listarTicketsBD();
    }
}
