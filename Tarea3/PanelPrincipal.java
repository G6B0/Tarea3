package Tarea3;


import Tarea2.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelPrincipal extends JPanel implements MouseListener {
    private PanelComprador com;
    private PanelExpendedor exp;

    public PanelPrincipal() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        exp = new PanelExpendedor(3);
        com = new PanelComprador(exp);
        this.addMouseListener(this);
        com.getComprar1().addMouseListener(this);
        com.getComprar2().addMouseListener(this);
        com.getComprar3().addMouseListener(this);
        com.getComprar4().addMouseListener(this);
        com.getComprar5().addMouseListener(this);
        com.getTomarVuelto().addMouseListener(this);
        com.getTomarVuelto().addMouseListener(this);
    }
    /**Metodo paint el cual pinta y agrega panel expendedor y comprador
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (exp != null) {
            add(exp);
            exp.setLocation(0,0);
            exp.paintComponent(g);
        }
        if (com != null) {
            add(com);
            com.setLocation(860,0);
            com.paintComponent(g);
        }
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Mi Aplicación");
            PanelPrincipal panelPrincipal = null;
            try {
                panelPrincipal = new PanelPrincipal();
            } catch (NoHayProductoException ex) {
                JOptionPane.showMessageDialog(null,"Nos quedamos sin producto de este tipo :c, compra no realizada");
            } catch (PagoIncorrectoException ex) {
                JOptionPane.showMessageDialog(null,"Pago Incorrecto, compra no realizada");
            } catch (PagoInsuficienteException ex) {
                JOptionPane.showMessageDialog(null,"Pago Insuficiente, compra no realizada");
            }
            frame.add(panelPrincipal);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1920, 1080);
            frame.setVisible(true);
        });
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getComponent()==com.getComprar1 () && com.getRespuestaCompra()== JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null,"Estamos trabajando para ti :) danos unos segundos");
            try {
                exp.cambioVista(com.getProducto());
                com.getTomarVuelto().setEnabled(true);
                com.getTomarVuelto().addMouseListener(this);
            } catch (PagoInsuficienteException ex) {
                JOptionPane.showMessageDialog(null,"Pago Insuficiente, compra no realizada");
            } catch (PagoIncorrectoException ex) {
                JOptionPane.showMessageDialog(null,"Pago Incorrecto, compra no realizada");;
            }
        }
        if(e.getComponent()==com.getComprar2 () && com.getRespuestaCompra()== JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null,"Estamos trabajando para ti :) danos unos segundos");
            try {
                exp.cambioVista(com.getProducto());
                com.getTomarVuelto().setEnabled(true);
                com.getTomarVuelto().addMouseListener(this);
            } catch (PagoInsuficienteException ex) {
                JOptionPane.showMessageDialog(null,"Pago Insuficiente, compra no realizada");
            } catch (PagoIncorrectoException ex) {
                JOptionPane.showMessageDialog(null,"Pago Incorrecto, compra no realizada");;
            }
        }
        if(e.getComponent()==com.getComprar3 () && com.getRespuestaCompra()== JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null,"Estamos trabajando para ti :) danos unos segundos");
            try {
                exp.cambioVista(com.getProducto());
                com.getTomarVuelto().setEnabled(true);
                com.getTomarVuelto().addMouseListener(this);
            } catch (PagoInsuficienteException ex) {
                JOptionPane.showMessageDialog(null,"Pago Insuficiente, compra no realizada");
            } catch (PagoIncorrectoException ex) {
                JOptionPane.showMessageDialog(null,"Pago Incorrecto, compra no realizada");;
            }
        }
        if(e.getComponent()==com.getComprar4 () && com.getRespuestaCompra()== JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null,"Estamos trabajando para ti :) danos unos segundos");
            try {
                exp.cambioVista(com.getProducto());
                com.getTomarVuelto().setEnabled(true);
                com.getTomarVuelto().addMouseListener(this);
            } catch (PagoInsuficienteException ex) {
                JOptionPane.showMessageDialog(null,"Pago Insuficiente, compra no realizada");
            } catch (PagoIncorrectoException ex) {
                JOptionPane.showMessageDialog(null,"Pago Incorrecto, compra no realizada");;
            }
        }
        if(e.getComponent()==com.getComprar5 () && com.getRespuestaCompra() == JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null,"Estamos trabajando para ti :) danos unos segundos");
            try {
                exp.cambioVista(com.getProducto());
                com.getTomarVuelto().setEnabled(true);
                com.getTomarVuelto().addMouseListener(this);
            } catch (PagoInsuficienteException ex) {
                JOptionPane.showMessageDialog(null,"Pago Insuficiente, compra no realizada");
            } catch (PagoIncorrectoException ex) {
                JOptionPane.showMessageDialog(null,"Pago Incorrecto, compra no realizada");;
            }
        }
        if(e.getComponent()==com.getTomarVuelto() && com.getRespuestaProductoSelec()==JOptionPane.YES_OPTION){
            exp.vaciarDepProductoSelec();
            com.getTomarVuelto().setEnabled(false);
            com.getTomarVuelto().removeMouseListener(this);
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
}
