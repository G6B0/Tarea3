package Tarea3;

import Tarea2.Expendedor;
import Tarea2.NoHayProductoException;
import Tarea2.PagoIncorrectoException;
import Tarea2.PagoInsuficienteException;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    public Ventana() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        super();
        this.add(new PanelPrincipal());
        this.setTitle("Máquina Expendedora");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1200, 800);
        this.setVisible(true);
    }
}
