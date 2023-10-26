package Tarea3;

import java.awt.*;

public class VistasDepositos{
    private VistasProductos productos;
    private VistasMonedas monedas;

    public VistasDepositos(){
        productos = new VistasProductos();
        monedas = new VistasMonedas();
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawLine(600,10,600,660);
        g.drawRect(150,40,175,175);
        g.drawRect(400,40,175,175);
        g.drawRect(150,250,175,175);
        g.drawRect(400,250,175,175);
        g.drawRect(150,470,175,175);
    }
}
