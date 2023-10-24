package Tarea2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Esta clase es un test para garantizar el correcto funcionamiento de las monedas.
 */
class MonedaTest {
    /** Moneda de valor 1000 */
    private Moneda1000 moneda1000;
    /** Moneda de valor 500 */
    private Moneda500 moneda500;

    /**
     * Se inicializan las monedas antes de cada prueba.
     */
    @BeforeEach
    void setUp() {
        moneda1000 = new Moneda1000();
        moneda500 = new Moneda500();
    }

    /**
     * Se prueba que la moneda de 500 sea menor que la moneda de 1000.
     */
    @Test
    @DisplayName("Test para CompareTo con moneda de valor menor con una de valor mayor")
    void compareToValorMenorAMayor() {
        assertTrue(moneda500.compareTo(moneda1000) < 0);
    }

    /**
     * Se prueba que la moneda de 1000 sea mayor a la moneda de 500.
     */
    @Test
    @DisplayName("Test para CompareTo con moneda de valor mayor con una de menor valor")
    void compareToValorMayorAMenor() {
        assertTrue(moneda1000.compareTo(moneda500) > 0);
    }

    /**
     * Se prueba que la moneda de 1000 sea una moneda de 1000
     */
    @Test
    @DisplayName("Test para CompareTo con monedas del mismo valor")
    void compareToMismoValor() {
        assertTrue(moneda1000.compareTo(moneda1000) == 0);
    }
}