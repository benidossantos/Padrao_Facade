package padroesestruturais.facade;

public class BancoFacade {

    private static BancoFacade instancia = new BancoFacade();

    private final CadastroCliente cadastroCliente = new CadastroCliente();
    private final AnaliseCredito analiseCredito = new AnaliseCredito();
    private final ContaCorrente contaCorrente = new ContaCorrente();
    private final CartaoCredito cartaoCredito = new CartaoCredito();

    private BancoFacade() {}

    public static BancoFacade getInstancia() {
        return instancia;
    }

    public String abrirConta(String nome, String cpf, double rendaMensal) {
        if (!cadastroCliente.validarCpf(cpf)) {
            return "Abertura de conta recusada: CPF inválido";
        }
        double limite = analiseCredito.calcularLimite(rendaMensal);
        return cadastroCliente.cadastrar(nome, cpf) + "\n" +
                contaCorrente.abrir() + "\n" +
                cartaoCredito.emitir(limite);
    }
}
