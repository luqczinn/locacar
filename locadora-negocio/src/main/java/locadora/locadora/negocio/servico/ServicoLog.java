/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.locadora.negocio.servico;

/**
 *
 * @author Aluno
 */
public class ServicoLog {
    //registrar o log de usuarios
    public static void registrarLogUsuario() {
        //insere no bd qual foi o usuario logado de acordo c o username 
    }
    
    //função para pegar ultimos usuarios logados
    public static void usuariosLogados() {
        //pega no bd qual foi o usuario logado
        //SELECT
        //pega o usernamee a hora
    }
    
    //registrar log de cadastro ou exclusao de veiculo
    public static void registraLogVeiculo() {
        //insere no bd qual foi o veiculo e qual a ação que sofreu
        //INSERT INTO
        //registra o veiculo e a data que sofreu as alteracoes
    }
    
    //pegar as logs de veiculo
    public static void veiculosLog() {
        //pega no bd o veiculo e a ação
        //SELECT
    }
    
    //registrar log de cadastro ou exclusao de unidades
    public static void registarLogUnidades() {
        //insere no bd qual foi a unidade e qual a ação que sofreu
        //INSERT INTO
        //insere a unidade e a data
    }
    
    //pegar as logs de unidade
    public static void unidadesLog() {
        //pega no bd a unidade e a ação
        //SELECT
    }
    
    //registrar log de cadastro ou exclusao de funcionarios
    public static void registrarLogFuncionarios(){
        //insere no bd qual foi o funcionario e qual a ação que sofreu
        //INSERT INTO
        //registra o funcionario e a data que sofreu as alteracoes
    }
    
    //pegar as logs de funcionario
    public static void funcionariosLog(){
        //pega no bd o funcionario e a ação
        //SELECT
    }
    
    //registrar log de cadastro ou exclusao de reservas
    public static void registrarLogReservas(){
        //insere no bd qual foi a reserva e qual a ação que sofreu
        //INSERT INTO
        //registra a reserva e a data que sofreu as alteracoes
    }
    
    //pegar as logs de reservas
    public static void reservasLog(){
        //pega no bd a reserva e a ação
        //SELECT
    }
}
