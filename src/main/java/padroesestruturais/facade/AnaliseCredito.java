package padroesestruturais.facade;

public class AnaliseCredito {

    public double calcularLimite(double rendaMensal) {
        if (rendaMensal < 1000) {
            return 0;
        }
        return rendaMensal * 0.3;
    }
}
