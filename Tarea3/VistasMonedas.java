package Tarea3;

import Tarea2.*;

import javax.swing.*;
import java.awt.*;
public class VistasMonedas extends JPanel {
    private Moneda moneda;
    private Color color;

    public VistasMonedas(Moneda moneda,Color color) {
        this.moneda = moneda;
        this.color=color;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (moneda instanceof Moneda100 || moneda instanceof Moneda500 || moneda instanceof Moneda1000 || moneda instanceof Moneda1500) {
            g.setColor(color);
            int radio = 50;
            int x = getWidth() / 2 - radio;
            int y = getHeight() / 2 - radio;
            g.fillArc(x, y, 2 * radio, 2 * radio, 0, 360);
            g.setColor(Color.black);
            String valor = String.valueOf(moneda);
            int xTexto = x+10;
            int yTexto = y + radio;
            Font font = g.getFont().deriveFont(10f);
            g.setFont(font);
            g.drawString(valor, xTexto, yTexto);
        }
    }
    public Moneda getMoneda(){
        return moneda;
    }
public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Mi Aplicación");
            VistasMonedas moneda = new VistasMonedas(new Moneda100(),Color.CYAN);
            frame.add(moneda);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1900, 1080);
            frame.setVisible(true);
        });
    }
}
