package Tarea3;

import javax.swing.*;
import java.awt.*;

public class PanelExpendedor extends JPanel {
    private PanelProductos productos;
    private PanelDepositos depositos;

    public PanelExpendedor() {

        productos = new PanelProductos();
        depositos = new PanelDepositos();
        this.setLayout(new BorderLayout());
    }
}
