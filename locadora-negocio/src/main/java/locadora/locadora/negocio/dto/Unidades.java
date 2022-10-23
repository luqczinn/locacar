/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.locadora.negocio.dto;

public class Unidades {
    private String endereco;
    private Integer numReferencia;
    private Integer codigo;
    private Integer cep;
    private String estado;
    private String cidade;
    private Integer numero;
    private String complemento;
    private Integer estoque;
    private String gerente; 

    public Unidades(String endereco, Integer numReferencia, Integer codigo, Integer cep, String estado,
    String cidade, Integer numero, String complemento, Integer estoque, String gerente) {
        this.endereco = endereco;
        this.numReferencia = numReferencia;
        this.codigo = codigo;
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
        this.numero = numero;
        this.complemento = complemento;
        this.estoque = estoque;
        this.gerente = gerente; 
    }
    
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getNumReferencia() {
        return numReferencia;
    }

    public void setNumReferencia(Integer numReferencia) {
        this.numReferencia = numReferencia;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
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
