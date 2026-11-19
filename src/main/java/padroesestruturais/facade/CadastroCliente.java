package padroesestruturais.facade;

public class CadastroCliente {

    public boolean validarCpf(String cpf) {
        return cpf != null && cpf.replaceAll("\\D", "").length() == 11;
    }

    public String cadastrar(String nome, String cpf) {
        if (!validarCpf(cpf)) {
            throw new IllegalArgumentException("CPF inválido");
        }
        return "Cliente " + nome + " cadastrado";
    }
}
