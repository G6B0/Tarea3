package Tarea3;

import Tarea2.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
/**Clase que representa tipo de producto con una imagen y una dimension*/
public class VistasProducto extends JPanel {
    /**Propiedad imagen del respectivo producto*/
    private BufferedImage imagen;
    private int ancho;
    private int alto;
    /**Constructor inicializa el tipo de producto y su respectivo ancho y alto
     *ademas agrega una informacion de uso y carga la imagen asociada al producto
     * */

    public VistasProducto(Producto producto,int ancho, int alto) {
        super();
        this.ancho=ancho;
        this.alto=alto;
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
    /**Metodo para cargar una imagen y en este caso para producto
     * @param ruta
     * @return null si se lanza la exception
     * @return leido de la imagen
     * */
    private BufferedImage cargarImagen(String ruta) {
        try {
            return ImageIO.read(new File(ruta));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    /**Metodo paint, principalmente para dibujar la imagen del directorio
     * @param g */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagen != null) {
            g.drawImage(imagen, 0, 0,ancho,alto, this);
        }
    }
}
