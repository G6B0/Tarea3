package Tarea3;

import Tarea2.Expendedor;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {
    private PanelComprador com;
    private PanelExpendedor exp;

    public PanelPrincipal() {
        this.setLayout(new BorderLayout());

        exp = new PanelExpendedor(3);
        com=new PanelComprador(600,600);
    }
    public void paint (Graphics g){
        super.paint(g);
        exp.paint(g);
        com.paint(g);
    }
}
