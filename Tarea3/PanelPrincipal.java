package Tarea3;

import Tarea2.Expendedor;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {
    private PanelComprador com;
    private PanelExpendedor exp;
    public PanelPrincipal(){
        this.setLayout(null);
        exp = new PanelExpendedor(3);
        com = new PanelComprador();
    }
    public void paint (Graphics g){
        super.paint(g);
        exp.paint(g);
        com.paint(g);
    }
}
