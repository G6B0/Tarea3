package Tarea3;

import Tarea2.Fanta;

import java.awt.*;
import Tarea2.*;


public class PanelDepositos {
    private PanelProductos producto_coca;
    private PanelProductos producto_sprite;
    private PanelProductos producto_fanta;
    private PanelProductos producto_snicker;
    private PanelProductos producto_super8;
    private VistasMonedas monedas;


    public PanelDepositos(){
        producto_coca = new PanelProductos(new CocaCola(1),55,60);
        producto_sprite = new PanelProductos(new Sprite(2),255,60);
        producto_fanta = new PanelProductos(new Fanta(3),55,270);
        producto_snicker = new PanelProductos(new Snickers(4),255,270);
        producto_super8 = new PanelProductos(new Super8(5),55,490);
        monedas = new VistasMonedas();
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawLine(500,1,500,650);
        g.drawRect(50,40,175,175);
        g.drawRect(250,40,175,175);
        g.drawRect(50,250,175,175);
        g.drawRect(250,250,175,175);
        g.drawRect(50,470,175,175);
        producto_coca.paintComponent(g);
        producto_fanta.paintComponent(g);
        producto_snicker.paintComponent(g);
        producto_sprite.paintComponent(g);
        producto_super8.paintComponent(g);

    }
}
