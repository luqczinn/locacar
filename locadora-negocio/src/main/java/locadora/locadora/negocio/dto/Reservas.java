/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.locadora.negocio.dto;

public class Reservas {
    
    private Integer codigo;
    private String cliente;
    private String vendedor;
    private String veiculo;
    private String unidade;
    private String inicio;
    private String fim;
    private String valorDiaria;
    private String valorReserva;

    public Reservas(Integer codigo, String cliente, String vendedor, String veiculo, String unidade, String inicio, String fim, String valorDiaria, String valorReserva) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.veiculo = veiculo;
        this.unidade = unidade;
        this.inicio = inicio;
        this.fim = fim;
        this.valorDiaria = valorDiaria;
        this.valorReserva = valorReserva;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getCliente() {
        return cliente;
    }

    public String getVendedor() {
        return vendedor;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public String getUnidade() {
        return unidade;
    }

    public String getInicio() {
        return inicio;
    }

    public String getFim() {
        return fim;
    }

    public String getValorDiaria() {
        return valorDiaria;
    }

    public String getValorReserva() {
        return valorReserva;
    }
    
    
}
