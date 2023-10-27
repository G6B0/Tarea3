package Tarea3;

import javax.swing.*;
import java.awt.*;

public class PanelExpendedor extends JPanel {
    private VistasProducto productos;
    private VistasDeposito depositos;


    public PanelExpendedor() {
        this.setLayout(null);
        this.setBounds(1, 1, 750, 650);
        depositos = new VistasDeposito();
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        g.drawRect(1, 1, 750, 650);

        depositos.paint(g);

    }
}