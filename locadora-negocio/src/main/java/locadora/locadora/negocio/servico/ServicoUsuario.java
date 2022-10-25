/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.locadora.negocio.servico;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import locadora.locadora.negocio.dao.UsuarioDAO;
import locadora.locadora.negocio.dto.Usuario;
import locadora.locadora.negocio.excessoes.negocioException;
import locadora.locadora.negocio.excessoes.persistenciaException;

/**
 *
 * @author PC-
 */
public class ServicoUsuario {
    
    private ServicoUsuario() {}
    
    public static Usuario logarUsuario(String username, String senha)throws negocioException, SQLException, UnsupportedEncodingException, NoSuchAlgorithmException{
        if(username.isEmpty()){
            throw new negocioException(319, "Insira o username!");
        }
        if(senha.isEmpty()){
            throw new negocioException(319, "Insira a senha!");
        }
        try{
            return UsuarioDAO.logarUsuario(username, senha);
        }catch(persistenciaException ex){
            throw new negocioException(315, ex.getMessage());
        }
    }
}
