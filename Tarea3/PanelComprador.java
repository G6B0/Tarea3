package Tarea3;

import Tarea2.*;


import javax.swing.*;
import java.awt.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelComprador extends JPanel implements MouseListener {
    private int ancho;
    private int alto;
    private JButton Comprar1;
    private JButton Comprar2;
    private JButton Comprar3;
    private JButton Comprar4;
    private JButton Comprar5;
    private Comprador comprador;



    public PanelComprador(int ancho, int alto) {
        int x, y;
        x = 100;
        y = 30;
        this.setLayout(null);
        this.ancho=ancho;
        this.alto=alto;
        setPreferredSize(new Dimension(ancho,alto));
        JLabel Cocacola = new JLabel("Coca-Cola");
        JLabel Sprite = new JLabel("Sprite");
        JLabel Fanta = new JLabel("Fanta");
        JLabel Snickers = new JLabel("Snickers");
        JLabel Super8 = new JLabel("Super8");

        Cocacola.setPreferredSize(new Dimension(100, 30));
        Sprite.setPreferredSize(new Dimension(100, 30));
        Fanta.setPreferredSize(new Dimension(100, 30));
        Snickers.setPreferredSize(new Dimension(100, 30));
        Super8.setPreferredSize(new Dimension(100, 30));

        Cocacola.setBounds(x, y, 100, 30);
        Sprite.setBounds(x, y + 100, 100, 30);
        Fanta.setBounds(x, y + 200, 100, 30);
        Snickers.setBounds(x, y + 300, 100, 30);
        Super8.setBounds(x, y + 400, 100, 30);

        VistasProducto coca = new VistasProducto(new CocaCola(0), 90, 70);
        VistasProducto sprt = new VistasProducto(new Sprite(0), 90, 70);
        VistasProducto fnt = new VistasProducto(new Fanta(0), 90, 70);
        VistasProducto snick = new VistasProducto(new Snickers(0), 80, 50);
        VistasProducto su8 = new VistasProducto(new Super8(0), 80, 50);

        coca.setPreferredSize(new Dimension(90, 70));
        sprt.setPreferredSize(new Dimension(90, 70));
        fnt.setPreferredSize(new Dimension(90, 70));
        snick.setPreferredSize(new Dimension(80, 50));
        su8.setPreferredSize(new Dimension(80, 50));

        coca.setBounds(x - 100, y, 90, 70);
        sprt.setBounds(x - 100, y + 100, 90, 70);
        fnt.setBounds(x - 100, y + 200, 90, 70);
        snick.setBounds(x - 100, y + 300, 80, 50);
        su8.setBounds(x - 100, y + 400, 80, 50);

        Comprar1 = new JButton("Comprar");
        Comprar2 = new JButton("Comprar");
        Comprar3 = new JButton("Comprar");
        Comprar4 = new JButton("Comprar");
        Comprar5 = new JButton("Comprar");

        Comprar1.setPreferredSize(new Dimension(100, 30));
        Comprar2.setPreferredSize(new Dimension(100, 30));
        Comprar3.setPreferredSize(new Dimension(100, 30));
        Comprar4.setPreferredSize(new Dimension(100, 30));
        Comprar5.setPreferredSize(new Dimension(100, 30));

        Comprar1.setBounds(x, y + 50, 100, 30);
        Comprar2.setBounds(x, y + 150, 100, 30);
        Comprar3.setBounds(x, y + 250, 100, 30);
        Comprar4.setBounds(x, y + 350, 100, 30);
        Comprar5.setBounds(x, y + 450, 100, 30);

        this.add(coca);
        this.add(sprt);
        this.add(fnt);
        this.add(snick);
        this.add(su8);
        this.add(Cocacola);
        this.add(Sprite);
        this.add(Fanta);
        this.add(Snickers);
        this.add(Super8);
        this.add(Comprar1);
        this.add(Comprar2);
        this.add(Comprar3);
        this.add(Comprar4);
        this.add(Comprar5);

        Comprar1.addMouseListener(this);
        Comprar2.addMouseListener(this);
        Comprar3.addMouseListener(this);
        Comprar4.addMouseListener(this);
        Comprar5.addMouseListener(this);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
  public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                JFrame frame = new JFrame("Expendedor de Bebidas");
                PanelComprador panelComprador = new PanelComprador(600,600);
                frame.add(panelComprador);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(900, 900);
                frame.setLayout(null);
                panelComprador.setBounds(0, 0, 600, 600);
                frame.setVisible(true);
            });
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getComponent()==Comprar1){
            int respuesta = JOptionPane.showConfirmDialog(null,"¿Estás seguro de continuar","Compra Coca",JOptionPane.YES_NO_OPTION);
            if(respuesta == JOptionPane.YES_OPTION){

            }
            else{
                JOptionPane.showMessageDialog(null,"Cancelaste la compra");
            }
        }
        else if(e.getComponent()==Comprar2){
            int respuesta = JOptionPane.showConfirmDialog(null,"¿Estás seguro de continuar","Compra Sprite",JOptionPane.YES_NO_OPTION);
            if(respuesta == JOptionPane.YES_OPTION){

            }
            else{
                JOptionPane.showMessageDialog(null,"Cancelaste la compra");
            }
        }
        else if(e.getComponent()==Comprar3){
            int respuesta = JOptionPane.showConfirmDialog(null,"¿Estás seguro de continuar","Compra Fanta",JOptionPane.YES_NO_OPTION);
            if(respuesta == JOptionPane.YES_OPTION){

            }
            else{
                JOptionPane.showMessageDialog(null,"Cancelaste la compra");
            }
        }
        else if(e.getComponent()==Comprar4){
            int respuesta = JOptionPane.showConfirmDialog(null,"¿Estás seguro de continuar","Compra Snicker",JOptionPane.YES_NO_OPTION);
            if(respuesta == JOptionPane.YES_OPTION){

            }
            else{
                JOptionPane.showMessageDialog(null,"Cancelaste la compra");
            }
        }
        else if(e.getComponent()==Comprar5){
            int respuesta = JOptionPane.showConfirmDialog(null,"¿Estás seguro de continuar","Compra Super8",JOptionPane.YES_NO_OPTION);
            if(respuesta == JOptionPane.YES_OPTION){

            }
            else{
                JOptionPane.showMessageDialog(null,"Cancelaste la compra");
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
}