package Tarea3;

import Tarea2.Expendedor;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {
    private PanelComprador com;
    private PanelExpendedor exp;

    public PanelPrincipal() {
        exp = new PanelExpendedor(3);
        com = new PanelComprador(300, 550);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (exp != null) {
            add(exp);
            exp.setLocation(0,0);
            exp.paintComponent(g);
        }
        if (com != null) {
            add(com);
            com.setLocation(700,0);
            com.paintComponent(g);
        }
    }
    
   /* public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Mi Aplicación");
            PanelPrincipal panelPrincipal = new PanelPrincipal();
            frame.add(panelPrincipal);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1900, 1080);
            frame.setVisible(true);
        });
    }*/
}
