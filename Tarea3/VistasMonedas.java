package Tarea3;

import Tarea2.*;

import javax.swing.*;
import java.awt.*;
public class VistasMonedas extends JPanel {
    private Moneda moneda;

    public VistasMonedas(Moneda moneda) {
        this.moneda = moneda;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (moneda instanceof Moneda100 || moneda instanceof Moneda500 || moneda instanceof Moneda1000 || moneda instanceof Moneda1500) {
            g.setColor(new Color(255, 200, 0));
            int radio = 50;
            int x = getWidth() / 2 - radio;
            int y = getHeight() / 2 - radio;
            g.fillArc(x, y, 2 * radio, 2 * radio, 0, 360);
            g.setColor(Color.BLACK);
            String valor = String.valueOf(moneda);
            int xTexto = x+5;
            int yTexto = y + radio;
            Font font = g.getFont().deriveFont(6f);
            g.setFont(font);
            g.drawString(valor, xTexto, yTexto);
        }
    }
}
