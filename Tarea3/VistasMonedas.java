package Tarea3;

import Tarea2.*;

import javax.swing.*;
import java.awt.*;
/**Clase representa Vista moneda con un circulo de radio 50 y puede tener diferentes colores */
public class VistasMonedas extends JPanel {
    private Moneda moneda;
    private Color color;
/**Constructor inicializa las propiedades de la clase
 * @param moneda
 * @param color
 */
    public VistasMonedas(Moneda moneda,Color color) {
        this.moneda = moneda;
        this.color=color;
    }
    /**Metodo paint crea in circulo de radio 50 para que se ajuste bien en los demas paneles y vistas
     * ademas se usa un Font para el tamaño del toString y ubicacion determinada
     * @param g */
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
    /**Este metodo devuelve el tipo de instancia, sera de utilidad para panel comprador
     * @return moneda
     */
    public Moneda getMoneda(){
        return moneda;
    }
}
