/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.locadora.negocio.servico;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;
import locadora.locadora.negocio.dao.UsuarioDAO;
import locadora.locadora.negocio.dto.Usuario;
import locadora.locadora.negocio.excessoes.negocioException;
import locadora.locadora.negocio.excessoes.persistenciaException;

/**
 *
 * @author PC-
 */
public class ServicoUsuarios {
    
    private ServicoUsuarios() {}
    
    public static Usuario logarUsuario(String username, String senha)throws negocioException, SQLException, UnsupportedEncodingException, NoSuchAlgorithmException{
        if(username.isEmpty()){
            throw new negocioException(319, "Insira o username!");
        }
        if(senha.isEmpty()){
            throw new negocioException(319, "Insira a senha!");
        }
        try{
            return UsuarioDAO.logarUsuarioFuncionario(username, senha);
        }catch(persistenciaException ex){
            throw new negocioException(315, ex.getMessage());
        }
    }
    
    public static void cadastrarFuncionario(String nome, String cpf, String rg, String nascimento, String cnis, Double salario, String cargo, String endereco, String telefone, String email, String usuario, String senha, String unidade)throws negocioException, SQLException, UnsupportedEncodingException, NoSuchAlgorithmException{
        if(nome.isEmpty()){
            throw new negocioException(319, "Insira o nome!");
        }
        if(cpf.isEmpty()){
            throw new negocioException(319, "Insira o cpf!");
        }
        if(rg.isEmpty()){
            throw new negocioException(319, "Insira o rg!");
        }
        if(nascimento.isEmpty()){
            throw new negocioException(319, "Insira a data de nascimento!");
        }
        if(cnis.isEmpty()){
            throw new negocioException(319, "Insira o cnis!");
        }
        if(salario == null){
            throw new negocioException(319, "Insira o salario!");
        }
        if(cargo.isEmpty()){
            throw new negocioException(319, "Insira o cargo!");
        }
        if(endereco.isEmpty()){
            throw new negocioException(319, "Insira o endereco!");
        }
        if(telefone.isEmpty()){
            throw new negocioException(319, "Insira o telefone!");
        }
        if(email.isEmpty()){
            throw new negocioException(319, "Insira o email!");
        }
        if(usuario.isEmpty()){
            throw new negocioException(319, "Insira o telefone!");
        }
        if(senha.isEmpty()){
            throw new negocioException(319, "Insira a senha!");
        }
        if(unidade.isEmpty()){
            throw new negocioException(319, "Insira a unidade!");
        }
        try{
            UsuarioDAO.cadastrarFuncionario(nome, cpf, rg, nascimento, cnis, salario, cargo, endereco, telefone, email, usuario, senha, unidade);
        }catch(negocioException | SQLException ex){
            throw new negocioException(315, ex.getMessage());
        }
    }
    
    public void removerFuncionario(String username)throws negocioException, SQLException, UnsupportedEncodingException, NoSuchAlgorithmException{
        if(username.isEmpty()){
            throw new negocioException(319, "Insira um username!");
        }
        try{
            UsuarioDAO.removerFuncionario(username);
        }catch(negocioException | SQLException ex){
            throw new negocioException(315, ex.getMessage());
        }
    }

    public static Usuario consultarPorUsername(String username) throws negocioException{

        if (username.isEmpty()) {
            throw new negocioException(319, "Insira o username do funcionário!");
        }
        try{
            return UsuarioDAO.procurarPorUsernameFuncionario(username);
        }catch(SQLException ex){
            throw new negocioException(315, ex.getMessage());
        }
    }
     public static List<Usuario> listarUsuarios() throws negocioException, SQLException {
        if (UsuarioDAO.listarFuncionariosBD() == null) {
            throw new negocioException(315, "Não existem funcionárisocadastrados!");
        }

        return UsuarioDAO.listarFuncionariosBD();
    }
}
