/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package locadora.locadora.negocio.dto;

/**
 *
 * @author Aluno
 */
public class Veiculo {

    private int ano;
    private String placa;
    private String marca;
    private String tipoMotor;
    private String modeloCarro;
    private double kmRodados;
    private double valorAluguel;
    private String status;
    private String tipo;
    private String cambio;

    public Veiculo(int ano, String placa, String marca, String tipoMotor, String modeloCarro, double kmRodados, double valorAluguel, String status, String tipo, String cambio) {
        this.ano = ano;
        this.placa = placa;
        this.marca = marca;
        this.tipoMotor = tipoMotor;
        this.modeloCarro = modeloCarro;
        this.kmRodados = kmRodados;
        this.valorAluguel = valorAluguel;
        this.status = status;
        this.tipo = tipo;
        this.cambio = cambio;
    }

    public int getAno() {
        return ano;
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getTipoMotor() {
        return tipoMotor;
    }

    public String getModeloCarro() {
        return modeloCarro;
    }

    public double getKmRodados() {
        return kmRodados;
    }

    public double getValorAluguel() {
        return valorAluguel;
    }

    public String getStatus() {
        return status;
    }

    public String getTipo() {
        return tipo;
    }

    public String getCambio() {
        return cambio;
    }

}
