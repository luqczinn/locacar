/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.locadora.negocio.dto;

public class Unidades {
    private String logradouro;
    private String numReferencia;
    private String cep;
    private String estado;
    private String cidade;
    private Integer numero;
    private String complemento;
    private Integer estoque;
    private String gerente;
    private String endereco;

    public Unidades(String logradouro, String numReferencia, String cep, String estado,
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

    public String getNumReferencia() {
        return numReferencia;
    }

    public String getCep() {
        return cep;
    }

    public String getEstado() {
        return estado;
    }

    public String getCidade() {
        return cidade;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public String getGerente() {
        return gerente;
    }

    public String getEndereco() {
        return endereco;
    }

    
}
