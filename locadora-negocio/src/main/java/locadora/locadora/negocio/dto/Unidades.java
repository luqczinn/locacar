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

    public Unidades(String endereco, Integer numReferencia, Integer codigo, Integer cep) {
        this.endereco = endereco;
        this.numReferencia = numReferencia;
        this.codigo = codigo;
        this.cep = cep;
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
    
}
