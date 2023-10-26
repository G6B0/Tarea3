package Tarea3;

import javax.swing.*;
import java.awt.*;

public class PanelExpendedor extends JPanel {
    private VistasProductos productos;
    private VistasDepositos depositos;


    public PanelExpendedor(){

        productos = new VistasProductos();
        depositos = new VistasDepositos();
        this.setLayout(new BorderLayout());
    }
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.BLACK);
        g.drawRect(50,10,750,650);

        depositos.paint(g);
    }
}
