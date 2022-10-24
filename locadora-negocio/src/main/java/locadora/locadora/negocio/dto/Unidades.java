/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.locadora.negocio.dto;

public class Unidades {
    private String logradouro;
    private String numReferencia;
    private Integer cep;
    private String estado;
    private String cidade;
    private Integer numero;
    private String complemento;
    private Integer estoque;
    private String gerente;
    private String endereco;

    public Unidades(String logradouro, String numReferencia, Integer cep, String estado,
    String cidade, Integer numero, String complemento, Integer estoque, String gerente, String endereco) {
        this.logradouro = logradouro;
        this.numReferencia = numReferencia;
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
        this.numero = numero;
        this.complemento = complemento;
        this.estoque = estoque;
        this.gerente = gerente; 
        this.endereco = endereco;
    }
    
    public String getLogradouro() {
        return logradouro;
    }
    
    public String getEndereco(){
        return endereco;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumReferencia() {
        return numReferencia;
    }

    public void setNumReferencia(String numReferencia) {
        this.numReferencia = numReferencia;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public String getGerente() {
        return gerente;
    }

    public void setGerente(String gerente) {
        this.gerente = gerente;
    }
    
}
