package view;

import controller.ContaClienteController;
import model.ContaBancaria;
import model.Cliente;

import java.util.Scanner;

public class mainView2 {

    // Códigos ANSI para cores (se suportado pelo terminal)
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContaClienteController controller = new ContaClienteController();

        System.out.println(ANSI_CYAN + "--------------------------------------");
        System.out.println("| Bem-vindo ao Banco Digital         |");
        System.out.println("--------------------------------------" + ANSI_RESET);

        while (true) {
            System.out.println("\n" + ANSI_YELLOW + "Selecione uma opção:" + ANSI_RESET);
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
                            System.out.println(ANSI_RED + "CPF inválido! Tente novamente." + ANSI_RESET);
                        }
                    } while (cpf.length() != 11);

                    System.out.print("Qual vai ser o limite de saque e transferência por dia: ");
                    double limite = scanner.nextDouble();

                    ContaBancaria novaConta = controller.criarConta(nome, cpf, limite);
                    System.out.println(ANSI_GREEN + "Conta criada com sucesso!" + ANSI_RESET);
                    System.out.println("O número da sua conta é: " + ANSI_YELLOW + novaConta.getNumero() + ANSI_RESET);
                    break;

                case 2:
                    System.out.println(ANSI_CYAN + "Listando todas as contas:" + ANSI_RESET);
                    System.out.println("------------------------------------------------------------");
                    System.out.printf("| %-10s | %-10s | %-12s | %-10s |\n", "Número", "Nome", "CPF", "Saldo");
                    System.out.println("------------------------------------------------------------");

                    // Listar contas e seus clientes associados
                    for (int i = 0; i < controller.listarContas().size(); i++) {
                        ContaBancaria conta = controller.listarContas().get(i);
                        Cliente cliente = controller.listarClientes().get(i);  // Associar cliente à conta
                        System.out.printf("| %-10d | %-10s | %-12s | %-10.2f |\n", 
                                          conta.getNumero(), cliente.getNome(), cliente.getCpf(), conta.getSaldo());
                    }
                    System.out.println("------------------------------------------------------------");
                    break;

                case 3:
                    System.out.print("Número da conta para depósito: ");
                    int numeroContaDeposito = scanner.nextInt();
                    System.out.print("Valor para depositar: ");
                    double valorDeposito = scanner.nextDouble();

                    if (controller.depositar(numeroContaDeposito, valorDeposito)) {
                        System.out.println(ANSI_GREEN + "Depósito realizado com sucesso!" + ANSI_RESET);
                    } else {
                        System.out.println(ANSI_RED + "Falha no depósito!" + ANSI_RESET);
                    }
                    break;

                case 4:
                    System.out.print("Número da conta para saque: ");
                    int numeroContaSaque = scanner.nextInt();
                    System.out.print("Valor para sacar: ");
                    double valorSaque = scanner.nextDouble();

                    if (controller.sacar(numeroContaSaque, valorSaque)) {
                        System.out.println(ANSI_GREEN + "Saque realizado com sucesso!" + ANSI_RESET);
                    } else {
                        System.out.println(ANSI_RED + "Falha no saque! Verifique o saldo." + ANSI_RESET);
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
                        System.out.println(ANSI_GREEN + "Transferência realizada com sucesso!" + ANSI_RESET);
                    } else {
                        System.out.println(ANSI_RED + "Falha na transferência! Verifique o saldo." + ANSI_RESET);
                    }
                    break;

                case 6:
                    System.out.println(ANSI_CYAN + "Saindo..." + ANSI_RESET);
                    System.exit(0);

                default:
                    System.out.println(ANSI_RED + "Opção inválida! Tente novamente." + ANSI_RESET);
            }
        }
    }
}
