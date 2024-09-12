import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.example.Banco;

public class BancoTest {

    @Test
    public void testSaldoInicial() {
        Banco conta = new Banco("João", 1000.00);
        assertEquals(1000.00, conta.getBalance(), "O saldo inicial deve ser 1000.00");
    }

    @Test
    public void testDepositoValido() {
        Banco conta = new Banco("Maria", 1000.00);
        conta.deposit(500.00);
        assertEquals(1500.00, conta.getBalance(), "O saldo deve ser atualizado para 1500.00 após o depósito de 500.00");
    }

    @Test
    public void testDepositoInvalido() {
        Banco conta = new Banco("Ana", 1000.00);
        conta.deposit(-100.00);
        assertEquals(1000.00, conta.getBalance(), "O saldo não deve mudar após um depósito negativo");
    }
    
    @Test
    public void testSaqueBemSucedido() {
        Banco conta = new Banco("Carlos", 1000.00);
        boolean sucesso = conta.withdraw(400.00);
        assertTrue(sucesso, "O saque deve ser bem-sucedido quando há saldo suficiente");
        assertEquals(600.00, conta.getBalance(), "O saldo deve ser atualizado para 600.00 após o saque de 400.00");
    }

    @Test
    public void testSaqueInsuficiente() {
        Banco conta = new Banco("Beatriz", 1000.00);
        boolean sucesso = conta.withdraw(1500.00);
        assertFalse(sucesso, "O saque deve falhar quando o saldo é insuficiente");
        assertEquals(1000.00, conta.getBalance(), "O saldo deve permanecer inalterado após uma tentativa de saque insuficiente");
    }

    @Test
    public void testSaqueInvalido() {
        Banco conta = new Banco("Lucas", 1000.00);
        boolean sucesso = conta.withdraw(-200.00);
        assertFalse(sucesso, "O saque deve falhar quando o valor é negativo");
        assertEquals(1000.00, conta.getBalance(), "O saldo deve permanecer inalterado após uma tentativa de saque negativo");
    }
}
