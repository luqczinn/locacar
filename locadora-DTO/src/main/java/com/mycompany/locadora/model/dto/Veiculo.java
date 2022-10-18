/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.locadora.model.dto;

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
    private int kmRodados;
    private double valorAluguel;
    private String status;

    public Veiculo(int ano, String placa, String marca, String tipoMotor, String modeloCarro, int kmRodados, double valorAluguel, String status) {
        this.ano = ano;
        this.placa = placa;
        this.marca = marca;
        this.tipoMotor = tipoMotor;
        this.modeloCarro = modeloCarro;
        this.kmRodados = kmRodados;
        this.valorAluguel = valorAluguel;
        this.status = status;
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

    public int getKmRodados() {
        return kmRodados;
    }

    public double getValorAluguel() {
        return valorAluguel;
    }

    public String getStatus() {
        return status;
    }
    
    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setTipoMotor(String tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    public void setModeloCarro(String modeloCarro) {
        this.modeloCarro = modeloCarro;
    }

    public void setKmRodados(int kmRodados) {
        this.kmRodados = kmRodados;
    }

    public void setValorAluguel(double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
