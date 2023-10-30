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
    private int ancho;
    private int alto;

    public VistasProducto(Producto producto,int ancho, int alto) {
        super();
        this.ancho=ancho;
        this.alto=alto;
        this.producto = producto;
        super.setToolTipText(producto.sabor());
        setPreferredSize(new Dimension(ancho, alto));
        if(producto instanceof CocaCola){
            imagen=cargarImagen("images/cocacola.png");
        }else if(producto instanceof Sprite){
            imagen=cargarImagen("images/sprite.png");
        }else if(producto instanceof Fanta){
            imagen=cargarImagen("images/fanta.png");
        }else if(producto instanceof Snickers){
            imagen=cargarImagen("images/snicker.png");
        }else{
            imagen=cargarImagen("images/super8.png");
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
            g.drawImage(imagen, 0, 0,ancho,alto, this);
        }
    }
    /*public static void main(String[] args) {

        VistasProducto producto = new VistasProducto(new CocaCola(2), 90, 60);

        // Crea un JFrame y un panel para contener el producto
        JFrame frame = new JFrame("Prueba de Producto");
        JPanel panel = new JPanel();

        // Agrega el producto al panel
        panel.add(producto);

        // Agrega el panel al JFrame
        frame.add(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 100);
        frame.setVisible(true);
    }*/
}
