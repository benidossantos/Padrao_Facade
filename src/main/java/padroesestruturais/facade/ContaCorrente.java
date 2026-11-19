package padroesestruturais.facade;

public class ContaCorrente {

    private static int proximoNumero = 1;

    public String abrir() {
        return "Conta " + String.format("%04d", proximoNumero++) + " aberta";
    }

    public static void reiniciarNumeracao() {
        proximoNumero = 1;
    }
}
