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
        private VistasDeposito<VistasProducto> depCocacola;
        private VistasDeposito<VistasProducto> depSprite;
        private VistasDeposito<VistasProducto> depFanta;
        private VistasDeposito<VistasProducto> depSnickers;
        private VistasDeposito<VistasProducto> depSuper8;
        private Expendedor expendedor;

        public PanelExpendedor(int cantidad) {
            this.imagen = cargarImagen("images/expendedor.jpg");
            this.expendedor = new Expendedor(cantidad);
            depCocacola = new VistasDeposito<>();
            depCocacola.setBounds(100,100,300,100);
            depSprite = new VistasDeposito<>();
            depFanta = new VistasDeposito<>();
            depSnickers = new VistasDeposito<>();
            depSuper8 = new VistasDeposito<>();
            for (int i = 1; i <= cantidad; i++) {
                depCocacola.agregarProducto(new VistasProducto(new CocaCola(2), 90, 70));
                depSprite.agregarProducto(new VistasProducto(new Sprite(1), 90, 70));
                depFanta.agregarProducto(new VistasProducto(new Fanta(5), 90, 70));
                depSnickers.agregarProducto(new VistasProducto(new Snickers(3), 80, 55));
                depSuper8.agregarProducto(new VistasProducto(new Super8(7), 80, 55));
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
                g.drawImage(imagen, 10, 10, 700, 700, this);
                add(depCocacola);
                depCocacola.setLocation(100,100);
                add(depSprite);
                depSprite.setLocation(100,200);
                add(depFanta);
                depFanta.setLocation(100,300);
                add(depSnickers);
                depSnickers.setLocation(100,400);
                add(depSuper8);
                depSuper8.setLocation(100,500);
            }
        }

        /*public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                JFrame frame = new JFrame("Expendedor de Bebidas");
                PanelExpendedor panelExpendedor = new PanelExpendedor(7);
                frame.add(panelExpendedor);

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 800);
                frame.setVisible(true);
            });
        }*/
    }