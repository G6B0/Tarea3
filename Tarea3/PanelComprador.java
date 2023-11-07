package Tarea3;

import Tarea2.*;


import javax.swing.*;
import java.awt.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelComprador extends JPanel implements MouseListener {
    private JButton Comprar1;
    private JButton Comprar2;
    private JButton Comprar3;
    private JButton Comprar4;
    private JButton Comprar5;
    private JButton tomarVuelto;
    private VistasMonedas moneda100;
    private VistasMonedas moneda500;
    private VistasMonedas moneda1000;
    private VistasMonedas moneda1500;
    private VistasProducto cocaCola;
    private VistasProducto sprite;
    private VistasProducto fanta;
    private VistasProducto snicker;
    private VistasProducto super8;
    private int respuestaCompra = JOptionPane.NO_OPTION;
    private int respuestaProductoSelec = JOptionPane.NO_OPTION;
    private Comprador comprador;
    private Expendedor expendedor;
    private Moneda escogida;
    private int vuelto;
    private Producto producto;
    private VistasDeposito<VistasMonedas> depMonvu;
    public PanelComprador(PanelExpendedor panelExpendedor) throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        this.setLayout(null);
        this.expendedor = panelExpendedor.getExpendedor();
        setPreferredSize(new Dimension(600,900));
        depMonvu = new VistasDeposito<>();

        moneda100 = new VistasMonedas(new Moneda100(),Color.CYAN);
        moneda500 = new VistasMonedas(new Moneda500(),Color.MAGENTA);
        moneda1000 = new VistasMonedas(new Moneda1000(),Color.GREEN);
        moneda1500 = new VistasMonedas(new Moneda1500(),Color.YELLOW);

        cocaCola = new VistasProducto(new CocaCola(1),100,70);
        fanta = new VistasProducto(new Fanta(1),100,70);
        sprite = new VistasProducto(new Sprite(1),100,70);
        snicker = new VistasProducto(new Snickers(1),100,70);
        super8 = new VistasProducto(new Super8(1),100,70);

        moneda100.addMouseListener(this);
        moneda500.addMouseListener(this);
        moneda1000.addMouseListener(this);
        moneda1500.addMouseListener(this);

        Comprar1 = new JButton("Comprar");
        Comprar2 = new JButton("Comprar");
        Comprar3 = new JButton("Comprar");
        Comprar4 = new JButton("Comprar");
        Comprar5 = new JButton("Comprar");
        tomarVuelto= new JButton("Tomar Vuelto");

        tomarVuelto.setBounds(1,570,150,30);
        Comprar1.setBounds(100, 60, 100, 30);
        Comprar2.setBounds(100, 160, 100, 30);
        Comprar3.setBounds(100, 260, 100, 30);
        Comprar4.setBounds(100, 360, 100, 30);
        Comprar5.setBounds(100, 460, 100, 30);

        this.add(cocaCola);
        this.add(fanta);
        this.add(sprite);
        this.add(snicker);
        this.add(super8);
        this.add(Comprar1);
        this.add(Comprar2);
        this.add(Comprar3);
        this.add(Comprar4);
        this.add(Comprar5);
        this.add(tomarVuelto);

        tomarVuelto.addMouseListener(this);
        Comprar1.addMouseListener(this);
        Comprar2.addMouseListener(this);
        Comprar3.addMouseListener(this);
        Comprar4.addMouseListener(this);
        Comprar5.addMouseListener(this);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        cocaCola.setBounds(0, 30, 90, 70);
        add(cocaCola);
        sprite.setBounds(0, 130, 90, 70);
        add(sprite);
        fanta.setBounds(0, 230, 90, 70);
        add(fanta);
        snicker.setBounds(0, 340, 80, 50);
        add(snicker);
        super8.setBounds(0, 440, 80, 50);
        add(super8);

        moneda100.setBounds(240,30,100,100);
        add(moneda100);
        moneda500.setBounds(240,150,100,100);
        add(moneda500);
        moneda1000.setBounds(240,270,100,100);
        add(moneda1000);
        moneda1500.setBounds(240,390,100,100);
        add(moneda1500);
        if(depMonvu!=null){
            depMonvu.setBounds(1,600,350,90);
            add(depMonvu);
        }
    }
    public void llenarDepMonvu(VistasDeposito<VistasMonedas> vistasDeposito) {
        Moneda moneda = comprador.getVuelto();
        while (moneda != null) {
            vistasDeposito.agregarProducto(new VistasMonedas(moneda, Color.YELLOW));
            moneda = comprador.getVuelto();
        }
        repaint();
    }
    public void vaciarDepMonvu(VistasDeposito<VistasMonedas> vistasDeposito){
        VistasMonedas vMoneda = vistasDeposito.quitarVista();
        while(vMoneda != null){
            vMoneda = vistasDeposito.quitarVista();
        }
        repaint();
        JOptionPane.showMessageDialog(null, "Aqui esta su vuelto, Gracias por su compra");
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getComponent()==moneda100){
            escogida = moneda100.getMoneda();
            JOptionPane.showConfirmDialog(null,"Acabas de escoger una moneda de 100!","Moneda escogida",JOptionPane.CLOSED_OPTION);
        }
        else if(e.getComponent()==tomarVuelto){
            vaciarDepMonvu(depMonvu);
            this.vuelto=comprador.cuantoVuelto();
            respuestaProductoSelec = JOptionPane.YES_OPTION;
            JOptionPane.showMessageDialog(null, "Tu vuelto es:"+vuelto);
        }
        else  if(e.getComponent()==moneda500){
            escogida = moneda500.getMoneda();
            JOptionPane.showConfirmDialog(null,"Acabas de escoger una moneda de 500!","Moneda escogida",JOptionPane.CLOSED_OPTION);
        }

        else if(e.getComponent()==moneda1000){
            escogida = moneda1000.getMoneda();
            JOptionPane.showConfirmDialog(null,"Acabas de escoger una moneda de 1000!","Moneda escogida",JOptionPane.CLOSED_OPTION);
        }

        else if(e.getComponent()==moneda1500){
            escogida = moneda1500.getMoneda();
            JOptionPane.showConfirmDialog(null,"Acabas de escoger una moneda de 1500!","Moneda escogida",JOptionPane.CLOSED_OPTION);
        }

        else if(e.getComponent()==Comprar1 && ((moneda100.getMoneda() == escogida)||(moneda500.getMoneda() == escogida)||(moneda1000.getMoneda() == escogida)||(moneda1500.getMoneda() == escogida))){
            respuestaCompra = JOptionPane.showConfirmDialog(null,"¿Estás seguro de continuar","Compra Coca",JOptionPane.YES_NO_OPTION);
            if(respuestaCompra == JOptionPane.YES_OPTION){
                try {
                    comprador = new Comprador(escogida,1,expendedor);
                    producto =comprador.getProducto();
                   this.vuelto=comprador.cuantoVuelto();
                    llenarDepMonvu(depMonvu);
                } catch (NoHayProductoException ex) {
                    respuestaCompra =JOptionPane.NO_OPTION;
                    JOptionPane.showMessageDialog(null,"Nos quedamos sin producto de este tipo :c, compra no realizada");
                } catch (PagoIncorrectoException ex) {
                    respuestaCompra =JOptionPane.NO_OPTION;
                    JOptionPane.showMessageDialog(null,"Pago Incorrecto, compra no realizada");
                } catch (PagoInsuficienteException ex) {
                    respuestaCompra =JOptionPane.NO_OPTION;
                    JOptionPane.showMessageDialog(null,"Pago Insuficiente, compra no realizada");
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"Cancelaste la compra");
            }
        }
        else if(e.getComponent()==Comprar2 && ((moneda100.getMoneda() == escogida)||(moneda500.getMoneda() == escogida)||(moneda1000.getMoneda() == escogida)||(moneda1500.getMoneda() == escogida))){
            respuestaCompra = JOptionPane.showConfirmDialog(null,"¿Estás seguro de continuar","Compra Sprite",JOptionPane.YES_NO_OPTION);
            if(respuestaCompra == JOptionPane.YES_OPTION){
                try {
                    comprador = new Comprador(escogida,2,expendedor);
                    producto =comprador.getProducto();
                    this.vuelto=comprador.cuantoVuelto();
                    llenarDepMonvu(depMonvu);
                } catch (NoHayProductoException ex) {
                    respuestaCompra =JOptionPane.NO_OPTION;
                    JOptionPane.showMessageDialog(null,"Nos quedamos sin producto de este tipo :c, compra no realizada");
                } catch (PagoIncorrectoException ex) {
                    respuestaCompra =JOptionPane.NO_OPTION;
                    JOptionPane.showMessageDialog(null,"Pago Incorrecto, compra no realizada");
                } catch (PagoInsuficienteException ex) {
                    respuestaCompra =JOptionPane.NO_OPTION;
                    JOptionPane.showMessageDialog(null,"Pago Insuficiente, compra no realizada");
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"Cancelaste la compra");
            }
        }

        else if(e.getComponent()==Comprar3 && ((moneda100.getMoneda() == escogida)||(moneda500.getMoneda() == escogida)||(moneda1000.getMoneda() == escogida)||(moneda1500.getMoneda() == escogida))){
            respuestaCompra = JOptionPane.showConfirmDialog(null,"¿Estás seguro de continuar","Compra Fanta",JOptionPane.YES_NO_OPTION);
            if(respuestaCompra == JOptionPane.YES_OPTION){
                try {
                    comprador = new Comprador(escogida,3,expendedor);
                    producto =comprador.getProducto();
                    this.vuelto=comprador.cuantoVuelto();
                    llenarDepMonvu(depMonvu);
                } catch (NoHayProductoException ex) {
                    respuestaCompra =JOptionPane.NO_OPTION;
                    JOptionPane.showMessageDialog(null,"Nos quedamos sin producto de este tipo :c, compra no realizada");
                } catch (PagoIncorrectoException ex) {
                    respuestaCompra =JOptionPane.NO_OPTION;
                    JOptionPane.showMessageDialog(null,"Pago Incorrecto, compra no realizada");
                } catch (PagoInsuficienteException ex) {
                    respuestaCompra =JOptionPane.NO_OPTION;
                    JOptionPane.showMessageDialog(null,"Pago Insuficiente, compra no realizada");
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"Cancelaste la compra");
            }
        }

        else if(e.getComponent()==Comprar4 && ((moneda100.getMoneda() == escogida)||(moneda500.getMoneda() == escogida)||(moneda1000.getMoneda() == escogida)||(moneda1500.getMoneda() == escogida))){
            respuestaCompra = JOptionPane.showConfirmDialog(null,"¿Estás seguro de continuar","Compra Snicker",JOptionPane.YES_NO_OPTION);
            if(respuestaCompra == JOptionPane.YES_OPTION){
                try {
                    comprador = new Comprador(escogida,4,expendedor);
                    producto =comprador.getProducto();
                    this.vuelto=comprador.cuantoVuelto();
                    llenarDepMonvu(depMonvu);
                } catch (NoHayProductoException ex) {
                    respuestaCompra =JOptionPane.NO_OPTION;
                    JOptionPane.showMessageDialog(null,"Nos quedamos sin producto de este tipo :c, compra no realizada");
                } catch (PagoIncorrectoException ex) {
                    respuestaCompra =JOptionPane.NO_OPTION;
                    JOptionPane.showMessageDialog(null,"Pago Incorrecto, compra no realizada");
                } catch (PagoInsuficienteException ex) {
                    respuestaCompra =JOptionPane.NO_OPTION;
                    JOptionPane.showMessageDialog(null,"Pago Insuficiente, compra no realizada");
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"Cancelaste la compra");
            }
        }

        else if(e.getComponent()==Comprar5 && ((moneda100.getMoneda() == escogida)||(moneda500.getMoneda() == escogida)||(moneda1000.getMoneda() == escogida)||(moneda1500.getMoneda() == escogida))){
            respuestaCompra = JOptionPane.showConfirmDialog(null,"¿Estás seguro de continuar","Compra Super8",JOptionPane.YES_NO_OPTION);
            if(respuestaCompra == JOptionPane.YES_OPTION){
                try {
                    comprador = new Comprador(escogida,5,expendedor);
                    producto =comprador.getProducto();
                    this.vuelto=comprador.cuantoVuelto();
                    llenarDepMonvu(depMonvu);
                } catch (NoHayProductoException ex) {
                    respuestaCompra =JOptionPane.NO_OPTION;
                    JOptionPane.showMessageDialog(null,"Nos quedamos sin producto de este tipo :c, compra no realizada");
                } catch (PagoIncorrectoException ex) {
                    respuestaCompra =JOptionPane.NO_OPTION;
                    JOptionPane.showMessageDialog(null,"Pago Incorrecto, compra no realizada");
                } catch (PagoInsuficienteException ex) {
                    respuestaCompra =JOptionPane.NO_OPTION;
                    JOptionPane.showMessageDialog(null,"Pago Insuficiente, compra no realizada");
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"Cancelaste la compra");
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"Aun no has escogido una moneda!");
        }
    }
    public JButton getComprar1() {
        return Comprar1;
    }

    public JButton getComprar2() {
        return Comprar2;
    }

    public JButton getComprar3() {
        return Comprar3;
    }

    public JButton getComprar4() {
        return Comprar4;
    }

    public JButton getComprar5() {
        return Comprar5;
    }
    public int getRespuestaCompra(){
        return respuestaCompra;
    }
    public int getRespuestaProductoSelec(){
        return respuestaProductoSelec;
    }
    public Producto getProducto(){
        return producto;
    }
public JButton getTomarVuelto(){
        return  tomarVuelto;
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