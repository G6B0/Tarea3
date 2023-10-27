package Tarea3;

import Tarea2.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PanelProductos extends JPanel {
    private BufferedImage imagen;
    private Producto producto;
    private int ejeX;
    private int ejeY;

    public PanelProductos(Producto producto, int ejeX, int ejeY) {
        super();
        this.ejeX=ejeX;
        this.ejeY=ejeY;
        this.producto=producto;
        super.setToolTipText(producto.sabor());
        if(producto instanceof CocaCola) {
            imagen = cargarImagen("C:\\Users\\Asus\\OneDrive\\Pictures\\Cocacolawena.png");
        }
        else if(producto instanceof Sprite){
            imagen = cargarImagen("C:\\Users\\Asus\\OneDrive\\Pictures\\Spritewena.png");
        }
        else if(producto instanceof Fanta){
            imagen = cargarImagen("C:\\Users\\Asus\\OneDrive\\Pictures\\Fantawena.png");
        }
        else if(producto instanceof Snickers){
            imagen = cargarImagen("C:\\Users\\Asus\\OneDrive\\Pictures\\Snickerweno.png");
        }else{
            imagen = cargarImagen("C:\\Users\\Asus\\OneDrive\\Pictures\\Super8weno.png");
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

            // eje Y Posición Y
            int width = 150; // Ancho
            int height = 100; // Alto

            g.drawImage(imagen, ejeX, ejeY, width, height, this);
  }
}

}