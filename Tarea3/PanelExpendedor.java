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
        private VistasDeposito<VistasProducto> depProductoSelec;
        private Expendedor expendedor;
        private Producto productoSelec;
        private int cantidad;


        public PanelExpendedor(int cantidad) {
            setPreferredSize(new Dimension(700, 700));
            this.imagen = cargarImagen("images/expendedor.jpg");
            this.expendedor = new Expendedor(cantidad);
            this.cantidad=cantidad;
            this.addMouseListener(this);
            depCocacola = new VistasDeposito<>();
            depSprite = new VistasDeposito<>();
            depFanta = new VistasDeposito<>();
            depSnickers = new VistasDeposito<>();
            depSuper8 = new VistasDeposito<>();
            depProductoSelec= new VistasDeposito<>();
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
        public void cambioVista(Producto producto) throws PagoInsuficienteException, PagoIncorrectoException {
            this.productoSelec=producto;
            if(productoSelec instanceof CocaCola){
                depProductoSelec.agregarProducto(depCocacola.quitarVista());

            }else if(productoSelec instanceof Sprite){
                depProductoSelec.agregarProducto(depSprite.quitarVista());
            }else if(productoSelec instanceof Fanta){
                depProductoSelec.agregarProducto(depFanta.quitarVista());
            }else if(productoSelec instanceof Snickers){
                depProductoSelec.agregarProducto(depSnickers.quitarVista());
            }else if(productoSelec instanceof Super8){
                depProductoSelec.agregarProducto(depSuper8.quitarVista());
            }
            repaint();
        }

        public Expendedor getExpendedor() {
            return expendedor;
        }
        public void vistasMonvu(VistasDeposito<VistasMonedas> vistasDeposito) {
            Moneda moneda = expendedor.getVuelto();
            while (moneda != null) {
                if (vistasDeposito.getDeposito().getElemento()==null) {
                    vistasDeposito.agregarProducto(new VistasMonedas(moneda, Color.YELLOW));
                } else {
                    JOptionPane.showMessageDialog(null, "Aqui esta su vuelto, Gracias por su compra");
                }
                moneda = expendedor.getVuelto();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLACK);
            if (imagen != null) {
                g.drawImage(imagen, 0, 0, 700, 700, this);
                depCocacola.setLocation(95, 100);
                add(depCocacola);
                depSprite.setLocation(95, 190);
                add(depSprite);
                depFanta.setLocation(95, 290);
                add(depFanta);
                depSnickers.setLocation(95, 385);
                add(depSnickers);
                depSuper8.setLocation(95, 480);
                add(depSuper8);
                depProductoSelec.setSize(160,75);
                depProductoSelec.setLocation(490,500);
                add(depProductoSelec);
            }
        }
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("Acabas de rellenar los depositos vacios a la cantidad original!");
            if (depCocacola.getDeposito().deposito.isEmpty()){
                JOptionPane.showConfirmDialog(null, "Deposito de Cocacola Vacio :C", "Deposito vacio", JOptionPane.CLOSED_OPTION);
                for (int i = 1; i <= cantidad; i++) {
                    depCocacola.agregarProducto(new VistasProducto(new CocaCola(10 + i), 90, 70));
                    expendedor.getCoca().addElemento(new CocaCola(10 + i));
                }
            }
            else if (depSprite.getDeposito().deposito.isEmpty()) {
                JOptionPane.showConfirmDialog(null, "Deposito de Sprite Vacio :C", "Deposito vacio", JOptionPane.CLOSED_OPTION);
                for (int i = 1; i <= cantidad; i++) {
                    depSprite.agregarProducto(new VistasProducto(new Sprite(20 + i), 90, 70));
                    expendedor.getSprite().addElemento(new Sprite(20 + i));
                }
            } else if (depFanta.getDeposito().deposito.isEmpty()) {
                JOptionPane.showConfirmDialog(null, "Deposito de Fanta Vacio :C", "Deposito vacio", JOptionPane.CLOSED_OPTION);
                for (int i = 1; i <= cantidad; i++) {
                    depFanta.agregarProducto(new VistasProducto(new Fanta(30 + i), 90, 70));
                    expendedor.getFanta().addElemento(new Fanta(30 + i));
                }
            } else if (depSnickers.getDeposito().deposito.isEmpty()) {
                JOptionPane.showConfirmDialog(null, "Deposito de Snickers Vacio :C", "Deposito vacio", JOptionPane.CLOSED_OPTION);
                for (int i = 1; i <= cantidad; i++) {
                    depSnickers.agregarProducto(new VistasProducto(new Snickers(100 + i), 90, 70));
                    expendedor.getSnickers().addElemento(new Snickers(100 + i));
                }
            } else if (depSuper8.getDeposito().deposito.isEmpty()) {
                JOptionPane.showConfirmDialog(null, "Deposito de Super8 Vacio :C", "Deposito vacio", JOptionPane.CLOSED_OPTION);
                for (int i = 1; i <= cantidad; i++) {
                    depSuper8.agregarProducto(new VistasProducto(new Super8(110 + i), 90, 70));
                    expendedor.getSuper8().addElemento(new Super8(110 + i));
                }
            }
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
        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                JFrame frame = new JFrame();
                PanelExpendedor panelExpendedor = new PanelExpendedor(3);

                frame.add(panelExpendedor);
                frame.setSize(700, 700);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            });
        }
    }