package Tarea3;

import Tarea2.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PanelExpendedor extends JPanel {
    private BufferedImage imagen;
    private VistasDeposito<VistasProducto>depCocacola;
    private VistasDeposito<VistasProducto>depSprite;
    private VistasDeposito<VistasProducto>depFanta;
    private VistasDeposito<VistasProducto>depSnickers;
    private VistasDeposito<VistasProducto>depSuper8;
    private Expendedor expendedor;


    public PanelExpendedor(int cantidad) {
        this.imagen=cargarImagen("images/expendedor.jpg");
        this.expendedor = new Expendedor(cantidad);
        depCocacola = new VistasDeposito<>(100, 120);
        depSprite = new VistasDeposito<>(100, 220);
        depFanta = new VistasDeposito<>(100, 320);
        depSnickers = new VistasDeposito<>(100, 420);
        depSuper8 = new VistasDeposito<>(100, 520);
        this.setLayout(null);
        this.setBounds(1, 1, 700, 700);
        int j=0;
        int k=0;
        for(int i=1;i<=cantidad;i++) {
            j=j+100;
            k=k+120;
            depCocacola.agregarProducto(new VistasProducto(new CocaCola(2), 110+j, 110));
            depSprite.agregarProducto(new VistasProducto(new Sprite(1), 110+j, 210));
            depFanta.agregarProducto(new VistasProducto(new Fanta(5), 110+j, 310));
            depSnickers.agregarProducto(new VistasProducto(new Snickers(3), 110+j, 410));
            depSuper8.agregarProducto(new VistasProducto(new Super8(7), 110+k, 510));
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
        g.setColor(Color.BLACK);
        if (imagen != null) {
            g.drawImage(imagen, 10, 10,700,700, this);
        }
        depCocacola.paintComponent(g);
        depSprite.paintComponent(g);
        depFanta.paintComponent(g);
        depSnickers.paintComponent(g);
        depSuper8.paintComponent(g);
    }
}
