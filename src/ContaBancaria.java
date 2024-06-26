public class ContaBancaria {
    private String nomeTitular;
    private int numeroConta;
    private String agencia;
    private double saldo;
    private boolean ativa;

    public ContaBancaria(String nomeTitular, int numeroConta) {
        this.nomeTitular = nomeTitular;
        this.numeroConta = numeroConta;
        this.agencia = EDadosBanco.AGENCIA.getValue();
        this.saldo = 0.0;
        this.ativa = true;
    }

    public void sacar(double valor) {
        if (ativa && saldo >= valor) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Falha ao sacar. Saldo insuficiente ou conta inativa.");
        }
    }

    public void depositar(double valor) {
        if (ativa) {
            saldo += valor;
            System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Falha no depósito. Conta inativa.");
        }
    }

    public void transferir(ContaBancaria destino, double valor) {
        if (ativa && saldo >= valor) {
            saldo -= valor;
            destino.saldo += valor;
            System.out.println("Transferência de R$" + valor + " para a conta " + destino.numeroConta + " realizada com sucesso.");
        } else {
            System.out.println("Falha na transferência. Saldo insuficiente ou conta inativa.");
        }
    }
}
