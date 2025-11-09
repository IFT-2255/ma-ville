package ca.udem.maville;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {


    Bank bank = new Bank("BanqUdem");
/*
    @BeforeEach
    void setup() {
        bank.supprimerComptes();
        bank.createAccount(new Account("12345"));
        bank.createAccount(new Account("54321", 200));
    }

    @Test
    void testRetrait() {
        bank.retrait("54321", 100);
        assertAll(
                () -> assertThrows(RuntimeException.class, () -> bank.retrait("12345", 50)),
                () -> assertThrows(IllegalArgumentException.class, () -> bank.retrait("54321", -100)),
                () -> assertTrue(bank.retrait("54321", 100) == 100)
        );
    }

    @Test
    void testTransaction(){

    }
*/

    @Test
    void testLuhnValide() {
        assertTrue(bank.isLuhn("378282246310005"));
    }

    @Test
    void testLuhnInvalide() {
        assertFalse(bank.isLuhn("378282246310000"));
    }

}