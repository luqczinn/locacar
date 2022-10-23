/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.locadora.negocio.dao;

import java.util.ArrayList;
import locadora.locadora.negocio.dto.Gerente;
import java.util.List;
import locadora.locadora.negocio.dto.Usuario;
import locadora.locadora.negocio.excessoes.persistenciaException;
/**
 *
 * @author Aluno
 */
public class UsuarioDAO{
    
    public static void cadastrarFuncionario(){}
    public static void removerFuncionario(){}
    public static void contagemFuncionarios(){}
    public static int numeroFuncionarios(){return 0;}
    
    public static Usuario procurarPorUsername(String username){
        ///lista provisória até inserção de BD !!!!!
        List<Usuario> listarUsuarios = new ArrayList<>();
        listarUsuarios.add(new Usuario("stella", "televisao")); 
        if (listarUsuarios != null) {
            for (Usuario u : listarUsuarios) {
                if (u.getUsername() == username) {
                    return u;
                }
            }
        }
        return null;
    } 
    
    public static Usuario logarUsuario(String username, String senha)throws persistenciaException{
        Usuario usuario = procurarPorUsername(username);
        
        if(usuario == null){
            throw new persistenciaException("Username de usuário não encontrado!");
        }
        if(usuario.getSenha() == desencriptografarSenha(senha)){
            return usuario;
        }else{
            throw new persistenciaException("Senha incorreta!");
        }
        
    }
    
    public static String encriptografarSenha(String senha){return null;}
    public static String desencriptografarSenha(String senha){return null;}
}