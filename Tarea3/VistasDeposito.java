package Tarea3;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import Tarea2.*;

import javax.imageio.ImageIO;
import javax.swing.*;


public class VistasDeposito<T> extends JPanel {
    private BufferedImage imagen;
    private Deposito<T> deposito;
    private int ejeX;
    private int ejeY;
    public VistasDeposito(int ejeX, int ejeY){
        this.ejeX=ejeX;
        this.ejeY=ejeY;
        deposito = new Deposito<>();
        imagen=cargarImagen("images/deposito.png");
    }

    private BufferedImage cargarImagen(String ruta) {
        try {
            return ImageIO.read(new File(ruta));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public void agregarVistas(T vistas){
        deposito.addElemento(vistas);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagen != null) {
            g.drawImage(imagen, ejeX, ejeY, 150, 50, this);
        }
    }
}
