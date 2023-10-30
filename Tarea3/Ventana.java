package Tarea3;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    public Ventana() {
        super();
        this.add(new PanelPrincipal());
        this.setTitle("Máquina Expendedora");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1200, 800);
        this.setVisible(true);
    }
}
