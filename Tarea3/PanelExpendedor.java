package Tarea3;

import Tarea2.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

    public class PanelExpendedor extends JPanel implements MouseListener {
        private BufferedImage imagen;
        private VistasDeposito<VistasProducto> depCocacola;
        private VistasDeposito<VistasProducto> depSprite;
        private VistasDeposito<VistasProducto> depFanta;
        private VistasDeposito<VistasProducto> depSnickers;
        private VistasDeposito<VistasProducto> depSuper8;
        private Expendedor expendedor;
        private int cantidad;

        public PanelExpendedor(int cantidad) {
            this.cantidad = cantidad;
            this.imagen = cargarImagen("images/expendedor.jpg");
            this.expendedor = new Expendedor(cantidad);
            this.addMouseListener(this);
            depCocacola = new VistasDeposito<>();
            depCocacola.setBounds(100, 100, 300, 100);
            depSprite = new VistasDeposito<>();
            depFanta = new VistasDeposito<>();
            depSnickers = new VistasDeposito<>();
            depSuper8 = new VistasDeposito<>();
            for (int i = 1; i <= cantidad; i++) {
                depCocacola.agregarProducto(new VistasProducto(new CocaCola(10 + i), 90, 70));
                depSprite.agregarProducto(new VistasProducto(new Sprite(20 + i), 90, 70));
                depFanta.agregarProducto(new VistasProducto(new Fanta(30 + i), 90, 70));
                depSnickers.agregarProducto(new VistasProducto(new Snickers(100 + i), 80, 55));
                depSuper8.agregarProducto(new VistasProducto(new Super8(110 + i), 80, 55));
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
                depCocacola.setLocation(100, 100);
                add(depCocacola);
                depSprite.setLocation(100, 200);
                add(depSprite);
                depFanta.setLocation(100, 300);
                add(depFanta);
                depSnickers.setLocation(100, 400);
                add(depSnickers);
                depSuper8.setLocation(100, 500);
                add(depSuper8);
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("Acabas de rellenar los depositos vacios a la cantidad original!");
            if (depCocacola.getDeposito().deposito.isEmpty())
                add(depCocacola);
            else if (depSprite.getDeposito().deposito.isEmpty()) {
                add(depSprite);
            } else if (depFanta.getDeposito().deposito.isEmpty()) {
                add(depFanta);
            } else if (depSnickers.getDeposito().deposito.isEmpty()) {
                add(depSnickers);
            } else if (depSuper8.getDeposito().deposito.isEmpty()) {
                add(depSuper8);
            }
            repaint();
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }


       /* public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                JFrame frame = new JFrame("Expendedor de Bebidas");
                PanelExpendedor panelExpendedor = new PanelExpendedor(7);
                frame.add(panelExpendedor);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 800);
                frame.setLayout(null);
                panelExpendedor.setBounds(10, 10, 700, 700);
                frame.setVisible(true);
            });

        }

        */
    }