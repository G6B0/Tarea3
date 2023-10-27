package Tarea3;

import Tarea2.CocaCola;
import Tarea2.Expendedor;
import Tarea2.Fanta;
import Tarea2.Sprite;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo de Panel de Productos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);

        PanelProductos panel = new PanelProductos(new Sprite(123));
        PanelProductos panel2 = new PanelProductos(new Fanta(123));
        frame.add(panel);
        frame.add(panel2);

        frame.setVisible(true);
    }
}
