package Tarea2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**Esta clase es un test a expendedor, garantiza que el expendedor deba funcionar como
 * corresponde en todos los casos posibles con diferentes tipos de monedas y selecciones de productos */
class ExpendedorTest {
    /** Expendedor para hacer las pruebas */
    private Expendedor expendedorSimple;

    /**  Inicializa el Expendedor antes de cada prueba /*
    @BeforeEach
    void setUp() {
        expendedorSimple = new Expendedor(3);
    }

    /** Prueba al compra de un producto sin proporcionar una moneda(moneda nula) */

    @Test
    @DisplayName("Test para comprar un producto sin moneda (moneda null)")
    void comprarProductoPagoIncorrecto() {
        int selector = 2;
        assertThrows(PagoIncorrectoException.class, () -> {
            expendedorSimple.comprarProducto(null, selector);
        });
        assertNull(expendedorSimple.getVuelto());
    }

    /**
     * Prueba la compra de un producto con una moneda insuficiente.
     */
    @Test
    @DisplayName("Test para comprar un producto con moneda insuficiente")
    void comprarProductoPagoInsuficiente() {
        int selector = 3;
        assertThrows(PagoInsuficienteException.class, () -> {
            expendedorSimple.comprarProducto(new Moneda500(), selector);
        });
    }


    /**
     * Prueba la compra de un producto que no está en la seleccion.
     * @throws PagoInsuficienteException  Si el pago es insuficiente.
     * @throws PagoIncorrectoException Si el pago es incorrecto.
     */
    @Test
    @DisplayName("Test para comprar un producto que no está en la selección")
    void comprarProductoInexistente() throws PagoInsuficienteException, PagoIncorrectoException {
        int selector = 6;
        assertNull(expendedorSimple.comprarProducto(new Moneda1000(), selector));
    }

}