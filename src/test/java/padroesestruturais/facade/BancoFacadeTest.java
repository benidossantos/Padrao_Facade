package padroesestruturais.facade;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BancoFacadeTest {

    @BeforeEach
    void setUp() {
        ContaCorrente.reiniciarNumeracao();
    }

    @Test
    void deveAbrirContaComCartao() {
        assertEquals("Cliente Maria cadastrado\nConta 0001 aberta\nCartão de crédito emitido com limite de R$ 1500.00",
                BancoFacade.getInstancia().abrirConta("Maria", "123.456.789-00", 5000));
    }

    @Test
    void deveAbrirContaSemCartaoParaRendaBaixa() {
        assertEquals("Cliente João cadastrado\nConta 0001 aberta\nCartão de crédito não emitido",
                BancoFacade.getInstancia().abrirConta("João", "12345678900", 800));
    }

    @Test
    void deveRecusarAberturaComCpfInvalido() {
        assertEquals("Abertura de conta recusada: CPF inválido",
                BancoFacade.getInstancia().abrirConta("Ana", "123", 5000));
    }

    @Test
    void deveNumerarContasSequencialmente() {
        BancoFacade.getInstancia().abrirConta("Maria", "12345678900", 5000);
        assertTrue(BancoFacade.getInstancia().abrirConta("Pedro", "98765432100", 5000).contains("Conta 0002 aberta"));
    }

    @Test
    void deveRetornarMesmaInstancia() {
        assertSame(BancoFacade.getInstancia(), BancoFacade.getInstancia());
    }
}
