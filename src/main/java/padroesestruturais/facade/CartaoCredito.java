package padroesestruturais.facade;

public class CartaoCredito {

    public String emitir(double limite) {
        if (limite <= 0) {
            return "Cartão de crédito não emitido";
        }
        return "Cartão de crédito emitido com limite de R$ " + String.format(java.util.Locale.US, "%.2f", limite);
    }
}
