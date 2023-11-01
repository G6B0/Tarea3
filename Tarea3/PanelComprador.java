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
    private VistasDeposito<VistasProducto> coca;
    private VistasDeposito<VistasProducto> sprt;
    private VistasDeposito<VistasProducto> fnt;
    private VistasDeposito<VistasProducto> snick;
    private VistasDeposito<VistasProducto> su8;
    private VistasMonedas moneda100;
    private VistasMonedas moneda500;
    private VistasMonedas moneda1000;
    private VistasMonedas moneda1500;
    private Moneda escogida;

    private int x;
    private int y;
    private int respuesta =JOptionPane.NO_OPTION;
    private Comprador comprador;
    private Producto productoSelec;
    private Expendedor expendedor;



    public PanelComprador() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        x = 100;
        y = 30;
        this.setLayout(null);
        this.expendedor = new Expendedor(3);
        setPreferredSize(new Dimension(600,600));
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

        coca = new VistasDeposito<>();
        sprt = new VistasDeposito<>();
        fnt = new VistasDeposito<>();
        snick = new VistasDeposito<>();
        su8 = new VistasDeposito<>();

        coca.agregarProducto(new VistasProducto(new CocaCola(0), 90, 70));
        sprt.agregarProducto(new VistasProducto(new Sprite(0), 90, 70));
        fnt.agregarProducto(new VistasProducto(new Fanta(0), 90, 70));
        snick.agregarProducto(new VistasProducto(new Snickers(0), 80, 50));
        su8.agregarProducto(new VistasProducto(new Super8(0), 80, 50));

        coca.setPreferredSize(new Dimension(90, 70));
        sprt.setPreferredSize(new Dimension(90, 70));
        fnt.setPreferredSize(new Dimension(90, 70));
        snick.setPreferredSize(new Dimension(80, 50));
        su8.setPreferredSize(new Dimension(80, 50));

        moneda100 = new VistasMonedas(new Moneda100(),Color.BLUE);
        moneda500 = new VistasMonedas(new Moneda500(),Color.MAGENTA);
        moneda1000 = new VistasMonedas(new Moneda1000(),Color.RED);
        moneda1500 = new VistasMonedas(new Moneda1500(),Color.YELLOW);

        moneda100.addMouseListener(this);
        moneda500.addMouseListener(this);
        moneda1000.addMouseListener(this);
        moneda1500.addMouseListener(this);


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
        coca.setBounds(x - 100, y, 90, 70);
        add(coca);
        sprt.setBounds(x - 100, y + 100, 90, 70);
        add(sprt);
        fnt.setBounds(x - 100, y + 200, 90, 70);
        add(fnt);
        snick.setBounds(x - 100, y + 300, 80, 50);
        add(snick);
        su8.setBounds(x - 100, y + 400, 80, 50);
        add(su8);

        moneda100.setBounds(x+120,y,100,100);
        add(moneda100);
        moneda500.setBounds(x+120,y+150,100,100);
        add(moneda500);
        moneda1000.setBounds(x+120,y+300,100,100);
        add(moneda1000);
        moneda1500.setBounds(x+120,y+450,100,100);
        add(moneda1500);
    }
  public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                JFrame frame = new JFrame("Expendedor de Bebidas");
                PanelComprador panelComprador = null;
                try {
                    panelComprador = new PanelComprador();
                } catch (NoHayProductoException e) {
                    throw new RuntimeException(e);
                } catch (PagoInsuficienteException e) {
                    throw new RuntimeException(e);
                } catch (PagoIncorrectoException e) {
                    throw new RuntimeException(e);
                }
                frame.add(panelComprador);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(900, 900);
                frame.setLayout(null);
                panelComprador.setBounds(0, 0, 600, 600);
                frame.setVisible(true);
            });
    }
    public Moneda getMonedaEscogida(){
        return escogida;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getComponent()==moneda100){
            escogida = moneda100.getMoneda();
            JOptionPane.showConfirmDialog(null,"Acabas de escoger una moneda de 100!","Moneda escogida",JOptionPane.CLOSED_OPTION);
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
            respuesta = JOptionPane.showConfirmDialog(null,"¿Estás seguro de continuar","Compra Coca",JOptionPane.YES_NO_OPTION);
            if(respuesta == JOptionPane.YES_OPTION){
                try {
                    comprador = new Comprador(escogida,1,expendedor);
                } catch (NoHayProductoException ex) {
                    respuesta =JOptionPane.NO_OPTION;
                    JOptionPane.showMessageDialog(null,"Nos quedamos sin producto de este tipo :c, compra no realizada");
                } catch (PagoIncorrectoException ex) {
                    respuesta =JOptionPane.NO_OPTION;
                    JOptionPane.showMessageDialog(null,"Pago Incorrecto, compra no realizada");
                } catch (PagoInsuficienteException ex) {
                    respuesta =JOptionPane.NO_OPTION;
                    JOptionPane.showMessageDialog(null,"Pago Insuficiente, compra no realizada");
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"Cancelaste la compra");
            }
        }

        else if(e.getComponent()==Comprar2 && ((moneda100.getMoneda() == escogida)||(moneda500.getMoneda() == escogida)||(moneda1000.getMoneda() == escogida)||(moneda1500.getMoneda() == escogida))){
            respuesta = JOptionPane.showConfirmDialog(null,"¿Estás seguro de continuar","Compra Sprite",JOptionPane.YES_NO_OPTION);
            if(respuesta == JOptionPane.YES_OPTION){
                try {
                    comprador = new Comprador(escogida,2,expendedor);
                } catch (NoHayProductoException ex) {
                    JOptionPane.showMessageDialog(null,"Nos quedamos sin producto de este tipo :c, compra no realizada");
                } catch (PagoIncorrectoException ex) {
                    JOptionPane.showMessageDialog(null,"Pago Incorrecto, compra no realizada");
                } catch (PagoInsuficienteException ex) {
                    JOptionPane.showMessageDialog(null,"Pago Insuficiente, compra no realizada");
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"Cancelaste la compra");
            }
        }

        else if(e.getComponent()==Comprar3 && ((moneda100.getMoneda() == escogida)||(moneda500.getMoneda() == escogida)||(moneda1000.getMoneda() == escogida)||(moneda1500.getMoneda() == escogida))){
            respuesta = JOptionPane.showConfirmDialog(null,"¿Estás seguro de continuar","Compra Fanta",JOptionPane.YES_NO_OPTION);
            if(respuesta == JOptionPane.YES_OPTION){
                try {
                    comprador = new Comprador(escogida,3,expendedor);
                } catch (NoHayProductoException ex) {
                    JOptionPane.showMessageDialog(null,"Nos quedamos sin producto de este tipo :c, compra no realizada");
                } catch (PagoIncorrectoException ex) {
                    JOptionPane.showMessageDialog(null,"Pago Incorrecto, compra no realizada");
                } catch (PagoInsuficienteException ex) {
                    JOptionPane.showMessageDialog(null,"Pago Insuficiente, compra no realizada");
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"Cancelaste la compra");
            }
        }

        else if(e.getComponent()==Comprar4 && ((moneda100.getMoneda() == escogida)||(moneda500.getMoneda() == escogida)||(moneda1000.getMoneda() == escogida)||(moneda1500.getMoneda() == escogida))){
            respuesta = JOptionPane.showConfirmDialog(null,"¿Estás seguro de continuar","Compra Snicker",JOptionPane.YES_NO_OPTION);
            if(respuesta == JOptionPane.YES_OPTION){
                try {
                    comprador = new Comprador(escogida,4,expendedor);
                } catch (NoHayProductoException ex) {
                    JOptionPane.showMessageDialog(null,"Nos quedamos sin producto de este tipo :c, compra no realizada");
                } catch (PagoIncorrectoException ex) {
                    JOptionPane.showMessageDialog(null,"Pago Incorrecto, compra no realizada");
                } catch (PagoInsuficienteException ex) {
                    JOptionPane.showMessageDialog(null,"Pago Insuficiente, compra no realizada");
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"Cancelaste la compra");
            }
        }

        else if(e.getComponent()==Comprar5 && ((moneda100.getMoneda() == escogida)||(moneda500.getMoneda() == escogida)||(moneda1000.getMoneda() == escogida)||(moneda1500.getMoneda() == escogida))){
            respuesta = JOptionPane.showConfirmDialog(null,"¿Estás seguro de continuar","Compra Super8",JOptionPane.YES_NO_OPTION);
            if(respuesta == JOptionPane.YES_OPTION){
                try {
                    comprador = new Comprador(escogida,5,expendedor);
                } catch (NoHayProductoException ex) {
                    JOptionPane.showMessageDialog(null,"Nos quedamos sin producto de este tipo :c, compra no realizada");
                } catch (PagoIncorrectoException ex) {
                    JOptionPane.showMessageDialog(null,"Pago Incorrecto, compra no realizada");
                } catch (PagoInsuficienteException ex) {
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
    public int getRespuesta(){
        return respuesta;
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