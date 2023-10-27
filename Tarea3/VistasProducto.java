package Tarea3;

import Tarea2.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class VistasProducto extends JPanel {
    private BufferedImage imagen;
    private Producto producto;
    private int ejeX;
    private int ejeY;

    public VistasProducto(Producto producto, int ejeX, int ejeY) {
        super();
        this.ejeX=ejeX;
        this.ejeY=ejeY;
        this.producto=producto;
        super.setToolTipText(producto.sabor());
        if(producto instanceof CocaCola) {
            imagen = cargarImagen("images/cocacola.png");
        }
        else if(producto instanceof Sprite){
            imagen = cargarImagen("images/sprite.png");
        }
        else if(producto instanceof Fanta){
            imagen = cargarImagen("images/fanta.png");
        }
        else if(producto instanceof Snickers){
            imagen = cargarImagen("images/snicker.png");
        }else{
            imagen = cargarImagen("images/super8.png");
        }
    }

    private BufferedImage cargarImagen(String ruta) {
        try {
            return ImageIO.read(new File(ruta));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagen != null) {
            g.setColor(Color.gray);
            g.drawString(super.getToolTipText(), ejeX, ejeY);
            g.drawString("nªSerie:  "+producto.getSerie(),ejeX,ejeY+100);
            g.drawImage(imagen, ejeX, ejeY,40, 60, this);
  }
}

}