package Tarea3;

import Tarea2.NoHayProductoException;
import Tarea2.PagoIncorrectoException;
import Tarea2.PagoInsuficienteException;
import javax.swing.*;

/**
 * Clase Ventana que representa el Panel Principal de la aplicación.
 * Esta ventana contiene un panel principal que se encarga de mostrar la interfaz de usuario para interactuar.
 *
 * La ventana se inicia al crear una instancia de esta clase y se configura con un tamaño predefinido, título y operación de cierre.
 *
 * @throws NoHayProductoException Si se produce un error relacionado con la falta de productos en el expendedor.
 * @throws PagoInsuficienteException Si se produce un error relacionado con el pago insuficiente para comprar un producto.
 * @throws PagoIncorrectoException Si se produce un error relacionado con el pago incorrecto para comprar un producto.
 */
public class Ventana extends JFrame {
    /**
     * Constructor de la clase Ventana que inicializa la ventana principal de la aplicación.
     */
    public Ventana() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        super();
        this.add(new PanelPrincipal());
        this.setTitle("Máquina Expendedora");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1200, 800);
        this.setVisible(true);
    }
}