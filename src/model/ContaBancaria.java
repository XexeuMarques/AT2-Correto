package model;

public class ContaBancaria {
    private int numero;
    private double saldo;
    private double limite;

    // Construtor
    public ContaBancaria(int numero, double limite) {
        this.numero = numero;
        this.saldo = 0.0;
        this.limite = limite;
    }

    // Getters e Setters
    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
}
