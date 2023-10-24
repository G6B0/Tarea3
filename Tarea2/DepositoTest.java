package Tarea2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Esta clase es un test para Deposito, se encarga de garantizar que el deposito
 * a utilizar cumpla con todos los requerimentos para el programa
 */
class DepositoTest {
    /** Deposito utilizado para las pruebas */
    Deposito<Producto> depositoGenerico;

    /**
     * Se inicializa el Deposito antes de cada prueba.
     */
    @BeforeEach
    void setUp(){
        depositoGenerico = new Deposito<>();
        for(int i=1;i<=2;i++){
            depositoGenerico.addElemento(new CocaCola(i));
        }
    }

    /**
     * Prueba que se pueda obtener un producto del deposito.
     */
    @Test
    @DisplayName("Test para sacar una bebida")
    void getBebida(){
        assertNotNull(depositoGenerico.getElemento());
    }

    /**
     * Prueba que si el deposito esta vacio obtenemos el nulo
     */
    @Test
    @DisplayName("Test para verificar si está vacío el depósito")
    void getBebidaVacio() {
        depositoGenerico.getElemento();
        depositoGenerico.getElemento();

        assertNull(depositoGenerico.getElemento());
    }
}
