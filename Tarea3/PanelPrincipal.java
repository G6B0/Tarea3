package Tarea3;


import Tarea2.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelPrincipal extends JPanel implements MouseListener {
    private PanelComprador com;
    private PanelExpendedor exp;
    private VistasDeposito<VistasMonedas> depMonvu;

    public PanelPrincipal() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        exp = new PanelExpendedor(3);
        com = new PanelComprador(exp);
        this.addMouseListener(this);
        com.getComprar1().addMouseListener(this);
        com.getComprar2().addMouseListener(this);
        com.getComprar3().addMouseListener(this);
        com.getComprar4().addMouseListener(this);
        com.getComprar5().addMouseListener(this);
        depMonvu=new VistasDeposito<>();
    }
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
            com.setLocation(900,0);
            com.paintComponent(g);
        }
        if(depMonvu != null){
            add(depMonvu);
            depMonvu.setBounds(900,600,100,100);
            depMonvu.paintComponent(g);
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
        if(e.getComponent()==com.getComprar1 () && com.getRespuesta()== JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null,"Estamos trabajando para ti :) danos unos segundos");
            try {
                exp.cambioVista(com.getProducto());
                exp.vistasMonvu(depMonvu);
            } catch (PagoInsuficienteException ex) {
                JOptionPane.showMessageDialog(null,"Pago Insuficiente, compra no realizada");
            } catch (PagoIncorrectoException ex) {
                JOptionPane.showMessageDialog(null,"Pago Incorrecto, compra no realizada");;
            }
        }
        if(e.getComponent()==com.getComprar2 () && com.getRespuesta()== JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null,"Estamos trabajando para ti :) danos unos segundos");
            try {
                exp.cambioVista(com.getProducto());
                exp.vistasMonvu(depMonvu);
            } catch (PagoInsuficienteException ex) {
                JOptionPane.showMessageDialog(null,"Pago Insuficiente, compra no realizada");
            } catch (PagoIncorrectoException ex) {
                JOptionPane.showMessageDialog(null,"Pago Incorrecto, compra no realizada");;
            }
        }
        if(e.getComponent()==com.getComprar3 () && com.getRespuesta()== JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null,"Estamos trabajando para ti :) danos unos segundos");
            try {
                exp.cambioVista(com.getProducto());
                exp.vistasMonvu(depMonvu);
            } catch (PagoInsuficienteException ex) {
                JOptionPane.showMessageDialog(null,"Pago Insuficiente, compra no realizada");
            } catch (PagoIncorrectoException ex) {
                JOptionPane.showMessageDialog(null,"Pago Incorrecto, compra no realizada");;
            }
        }
        if(e.getComponent()==com.getComprar4 () && com.getRespuesta()== JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null,"Estamos trabajando para ti :) danos unos segundos");
            try {
                exp.cambioVista(com.getProducto());
                exp.vistasMonvu(depMonvu);
            } catch (PagoInsuficienteException ex) {
                JOptionPane.showMessageDialog(null,"Pago Insuficiente, compra no realizada");
            } catch (PagoIncorrectoException ex) {
                JOptionPane.showMessageDialog(null,"Pago Incorrecto, compra no realizada");;
            }
        }
        if(e.getComponent()==com.getComprar5 () && com.getRespuesta()== JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null,"Estamos trabajando para ti :) danos unos segundos");
            try {
                exp.cambioVista(com.getProducto());
                exp.vistasMonvu(depMonvu);
            } catch (PagoInsuficienteException ex) {
                JOptionPane.showMessageDialog(null,"Pago Insuficiente, compra no realizada");
            } catch (PagoIncorrectoException ex) {
                JOptionPane.showMessageDialog(null,"Pago Incorrecto, compra no realizada");;
            }
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
