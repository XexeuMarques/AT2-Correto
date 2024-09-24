package controller;

import model.Cliente;
import model.ContaBancaria;

import java.util.ArrayList;
import java.util.List;

public class ContaClienteController {
    private List<ContaBancaria> contas = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();

    // Método para criar conta
    public ContaBancaria criarConta(String nome, String cpf, double limite) {
        int numeroConta = gerarNumeroConta();
        Cliente cliente = new Cliente(nome, cpf);
        ContaBancaria conta = new ContaBancaria(numeroConta, limite);

        clientes.add(cliente);
        contas.add(conta);

        return conta;
    }

    // Método para sacar
    public boolean sacar(int numeroConta, double valor) {
        ContaBancaria conta = buscarConta(numeroConta);
        if (conta != null && valor <= conta.getSaldo()) {
            conta.setSaldo(conta.getSaldo() - valor);
            return true;
        }
        return false;
    }

    // Método para depositar
    public boolean depositar(int numeroConta, double valor) {
        ContaBancaria conta = buscarConta(numeroConta);
        if (conta != null) {
            conta.setSaldo(conta.getSaldo() + valor);
            return true;
        }
        return false;
    }

    // Método para transferir entre contas
    public boolean transferir(int numeroContaOrigem, int numeroContaDestino, double valor) {
        ContaBancaria origem = buscarConta(numeroContaOrigem);
        ContaBancaria destino = buscarConta(numeroContaDestino);

        if (origem != null && destino != null && valor <= origem.getSaldo()) {
            origem.setSaldo(origem.getSaldo() - valor);
            destino.setSaldo(destino.getSaldo() + valor);
            return true;
        }
        return false;
    }

    // Buscar conta por número
    private ContaBancaria buscarConta(int numeroConta) {
        for (ContaBancaria conta : contas) {
            if (conta.getNumero() == numeroConta) {
                return conta;
            }
        }
        return null;
    }

    // Gerar número de conta aleatório (4 dígitos)
    private int gerarNumeroConta() {
        return (int) (Math.random() * 9000) + 1000;
    }

    // Listar todas as contas
    public List<ContaBancaria> listarContas() {
        return contas;
    }

    // Listar todos os clientes
    public List<Cliente> listarClientes() {
        return clientes;
    }
}
