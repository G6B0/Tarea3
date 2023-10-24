package Tarea2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Esta clase es un test para Comprador, se garantiza que el comprador funcione correctamente para
 * todos los casos posibles de todos los productos a comprar con monedas en un expendedor.
 */
public class CompradorTest {
    /** Comprador utilizado en las pruebas*/
    private Comprador comprador;
    /** Expendedor utilizado en comprador */
    private Expendedor expendedor;
    /** Moneda utilizada en comprador */
    private Moneda moneda;
    /** Moneda a utilizar en comprador */
    private Moneda nada=null;

    /**
     * Inicializa el expendedor y la moneda a utilizar
     */
    @BeforeEach
    void SetUp(){
        expendedor = new Expendedor(1);
        moneda = new Moneda1000();
    }

    /**
     * Prueba desde Comprador para compras exitosas
     * @throws Exception No es lanzada, debido a que la compra debe ser exitosa
     */
    @Test
    @DisplayName("test compra exitosa")
    public void testCompraExitosa()throws Exception{
        System.out.println("Compra exitosa para cada producto");
        assertNotNull(comprador = new Comprador(moneda,1,expendedor));
        assertNotNull(comprador = new Comprador(moneda,2,expendedor));
        assertNotNull(comprador = new Comprador(moneda,3,expendedor));
        assertNotNull(comprador = new Comprador(moneda,4,expendedor));
        assertNotNull(comprador = new Comprador(moneda,5,expendedor));
    }

    /**
     * Prueba desde Comprador para pagos incorrectos(moneda nula).
     */
    @Test
    @DisplayName("Test PagoIncorrectoException")
    public void testComprarProductoSinMoneda(){
        Exception exception = assertThrows(PagoIncorrectoException.class,()->{
            comprador = new Comprador(nada,1,expendedor);
            comprador = new Comprador(nada,2,expendedor);
            comprador = new Comprador(nada,3,expendedor);
            comprador = new Comprador(nada,4,expendedor);
            comprador = new Comprador(nada,5,expendedor);
        });
    }

    /**
     * Prueba desde Comprador para compra sin productos en expendedor.
     */
    @Test
    @DisplayName("Test NoHayProductoException")
    public void testComprarProductoSinProductos(){
        expendedor = new Expendedor(0);
        Exception exception = assertThrows(NoHayProductoException.class,()->{
            comprador = new Comprador(moneda,1,expendedor);
            comprador = new Comprador(moneda,2,expendedor);
            comprador = new Comprador(moneda,3,expendedor);
            comprador = new Comprador(moneda,4,expendedor);
            comprador = new Comprador(moneda,5,expendedor);
        });
    }
}