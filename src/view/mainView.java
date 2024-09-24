package view;

import controller.ContaClienteController;
import model.ContaBancaria;

import java.util.Scanner;

public class mainView {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContaClienteController controller = new ContaClienteController();

        System.out.println("Bem-vindo ao banco!");

        while (true) {
            System.out.println("\nSelecione uma opção:");
            System.out.println("1 - Criar conta bancária");
            System.out.println("2 - Listar contas bancárias");
            System.out.println("3 - Depositar dinheiro");
            System.out.println("4 - Retirar dinheiro");
            System.out.println("5 - Transferir dinheiro entre contas");
            System.out.println("6 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir o newline

            switch (opcao) {
                case 1:
                    System.out.print("Qual seu nome: ");
                    String nome = scanner.nextLine();
                    String cpf;
                    do {
                        System.out.print("Seu CPF (11 dígitos): ");
                        cpf = scanner.nextLine();
                        if (cpf.length() != 11) {
                            System.out.println("CPF inválido! Tente novamente.");
                        }
                    } while (cpf.length() != 11);

                    System.out.print("Qual vai ser o limite de saque e transferência por dia: ");
                    double limite = scanner.nextDouble();

                    ContaBancaria novaConta = controller.criarConta(nome, cpf, limite);
                    System.out.println("Conta criada com sucesso!");
                    System.out.println("O número da sua conta é: " + novaConta.getNumero());
                    break;

                case 2:
                    System.out.println("Listando todas as contas:");
                    for (ContaBancaria conta : controller.listarContas()) {
                        System.out.println("Conta Nº: " + conta.getNumero() + ", Saldo: " + conta.getSaldo());
                    }
                    break;

                case 3:
                    System.out.print("Número da conta para depósito: ");
                    int numeroContaDeposito = scanner.nextInt();
                    System.out.print("Valor para depositar: ");
                    double valorDeposito = scanner.nextDouble();

                    if (controller.depositar(numeroContaDeposito, valorDeposito)) {
                        System.out.println("Depósito realizado com sucesso!");
                    } else {
                        System.out.println("Falha no depósito!");
                    }
                    break;

                case 4:
                    System.out.print("Número da conta para saque: ");
                    int numeroContaSaque = scanner.nextInt();
                    System.out.print("Valor para sacar: ");
                    double valorSaque = scanner.nextDouble();

                    if (controller.sacar(numeroContaSaque, valorSaque)) {
                        System.out.println("Saque realizado com sucesso!");
                    } else {
                        System.out.println("Falha no saque! Verifique o saldo.");
                    }
                    break;

                case 5:
                    System.out.print("Número da conta de origem: ");
                    int numeroContaOrigem = scanner.nextInt();
                    System.out.print("Número da conta de destino: ");
                    int numeroContaDestino = scanner.nextInt();
                    System.out.print("Valor para transferir: ");
                    double valorTransferencia = scanner.nextDouble();

                    if (controller.transferir(numeroContaOrigem, numeroContaDestino, valorTransferencia)) {
                        System.out.println("Transferência realizada com sucesso!");
                    } else {
                        System.out.println("Falha na transferência! Verifique o saldo.");
                    }
                    break;

                case 6:
                    System.out.println("Saindo...");
                    System.exit(0);

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}
