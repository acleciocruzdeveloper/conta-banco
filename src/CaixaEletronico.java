import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CaixaEletronico {
    private final Map<String, ContaBancaria> contas = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);

    public CaixaEletronico() {
        contas.put("1002", new ContaBancaria("Alice Johnson", 1002));
        contas.put("1004", new ContaBancaria("Bob Smith", 1004));
    }

    public void iniciar() {
        boolean sessaoAtiva = true;
        while (sessaoAtiva) {
            System.out.println("1. Sacar");
            System.out.println("2. Transferir");
            System.out.println("3. Depositar");
            System.out.println("4. Sair");

            System.out.print("Escolha uma opção (1-4): ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    realizarSaque();
                    break;
                case 2:
                    realizarTransferencia();
                    break;
                case 3:
                    realizarDeposito();
                    break;
                case 4:
                    sessaoAtiva = false;
                    System.out.println("Sessão encerrada.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }

    private void realizarSaque() {
        System.out.print("Digite o número da conta: ");
        String numeroConta = scanner.nextLine();
        ContaBancaria conta = contas.get(numeroConta);
        if (conta != null) {
            System.out.print("Digite o valor a sacar: ");
            double valor = scanner.nextDouble();
            scanner.nextLine();
            conta.sacar(valor);
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    private void realizarTransferencia() {
        System.out.print("Digite o número da conta de origem: ");
        String origem = scanner.nextLine();
        ContaBancaria contaOrigem = contas.get(origem);
        if (contaOrigem != null) {
            System.out.print("Digite o número da conta de destino: ");
            String destino = scanner.nextLine();
            ContaBancaria contaDestino = contas.get(destino);
            if (contaDestino != null) {
                System.out.print("Digite o valor a transferir: ");
                double valor = scanner.nextDouble();
                scanner.nextLine();
                contaOrigem.transferir(contaDestino, valor);
            } else {
                System.out.println("Conta de destino não encontrada.");
            }
        } else {
            System.out.println("Conta de origem não encontrada.");
        }
    }

    private void realizarDeposito() {
        System.out.print("Digite o número da conta: ");
        String numeroConta = scanner.nextLine();
        ContaBancaria conta = contas.get(numeroConta);
        if (conta != null) {
            System.out.print("Digite o valor a depositar: ");
            double valor = scanner.nextDouble();
            scanner.nextLine();
            conta.depositar(valor);
        } else {
            System.out.println("Conta não encontrada.");
        }
    }
}
