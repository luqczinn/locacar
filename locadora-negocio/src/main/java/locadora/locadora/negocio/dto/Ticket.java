/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.locadora.negocio.dto;

/**
 *
 * @author Aluno
 */
public class Ticket {
    private int id;
    private String usuarioPedido;
    private String assunto;
    private String descricao;
    private String dataCriada;
    private String funcionarioResposta;
    private String resposta;
    private String dataRespondida;
    
    public Ticket(int id, String usuarioPedido, String assunto, String descricao, String dataCriada){
        this.id = id;
        this.usuarioPedido = usuarioPedido;
        this.assunto = assunto;
        this.descricao = descricao;
        this.dataCriada = dataCriada;
        this.funcionarioResposta = null;
        this.resposta = null;
        this.dataRespondida = null;
    }
    
    public Ticket(int id, String usuarioPedido, String assunto, String descricao, String dataCriada, String funcionarioResposta, String resposta, String dataRespondida){
        this.id = id;
        this.usuarioPedido = usuarioPedido;
        this.assunto = assunto;
        this.descricao = descricao;
        this.dataCriada = dataCriada;
        this.funcionarioResposta = funcionarioResposta;
        this.resposta = resposta;
        this.dataRespondida = dataRespondida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getUsuarioPedido() {
        return usuarioPedido;
    }

    public void setUsuarioPedido(String usuarioPedido) {
        this.usuarioPedido = usuarioPedido;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataCriada() {
        return dataCriada;
    }

    public void setDataCriada(String dataCriada) {
        this.dataCriada = dataCriada;
    }

    public String getFuncionarioResposta() {
        return funcionarioResposta;
    }

    public void setFuncionarioResposta(String funcionarioResposta) {
        this.funcionarioResposta = funcionarioResposta;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public String getDataRespondida() {
        return dataRespondida;
    }

    public void setDataRespondida(String dataRespondida) {
        this.dataRespondida = dataRespondida;
    }
}
