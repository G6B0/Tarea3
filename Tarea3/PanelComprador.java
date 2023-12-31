package Tarea3;

import Tarea2.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Clase PanelComprador representa un panel gráfico que permite a los usuarios interactuar con un comprador de productos.
 * Los usuarios pueden seleccionar productos, seleccionar monedas, realizar compras y recibir vuelto.
 * Esta clase contiene botones para comprar productos, monedas para realizar pagos, y una interfaz para visualizar las operaciones realizadas.
 *
 * Los botones de compra están asociados a productos específicos, como Coca-Cola, Sprite, Fanta, Snicker y Super8.
 * Los usuarios pueden seleccionar monedas para realizar pagos y, si es necesario, recibir el cambio.
 *
 * Esta clase utiliza instancias de las clases Comprador, Expendedor, Moneda, y Producto de la Tarea 2 para realizar las operaciones de compra y cambio.
 */
public class PanelComprador extends JPanel implements MouseListener {
    /**
     * Boton para comprar Coca-Cola.
     */
    private JButton Comprar1;
    /**
     * Boton para comprar Sprite.
     */
    private JButton Comprar2;
    /**
     * Boton para comprar Fanta.
     */
    private JButton Comprar3;
    /**
     * Boton para comprar Snicker.
     */
    private JButton Comprar4;
    /**
     * Boton para comprar Super8.
     */
    private JButton Comprar5;
    /**
     * Boton para sacar el Vuelto.
     */
    private JButton tomarVuelto;
    /**
     * Moneda de 100 a seleccionar para realizar compras.
     */
    private VistasMonedas moneda100;
    /**
     * Moneda de 500 a seleccionar para realizar compras.
     */
    private VistasMonedas moneda500;
    /**
     * Moneda de 1000 a seleccionar para realizar compras.
     */
    private VistasMonedas moneda1000;
    /**
     * Moneda de 1500 a seleccionar para realizar compras.
     */
    private VistasMonedas moneda1500;
    /**
     * Imagen de producto tipo Coca-Cola.
     */
    private VistasProducto cocaCola;
    /**
     * Imagen de producto tipo Sprite.
     */
    private VistasProducto sprite;
    /**
     * Imagen de producto tipo Fanta.
     */
    private VistasProducto fanta;
    /**
     * Imagen de producto tipo Snicker.
     */
    private VistasProducto snicker;
    /**
     * Imagen de producto tipo super8.
     */
    private VistasProducto super8;
    /**
     * Verificador de compra exitosa;
     */
    private int respuestaCompra = JOptionPane.NO_OPTION;
    /**
     * Verificador de retiro del producto comprado.
     */
    private int respuestaProductoSelec = JOptionPane.NO_OPTION;
    /**
     * Comprador de tarea2
     */
    private Comprador comprador;
    /**
     * Expendedor de tarea2
     */
    private Expendedor expendedor;
    /**
     * Moneda de tarea2, se encarga de darle el valor a la moneda que
     * se escoge.
     */
    private Moneda escogida;
    /**
     * Vuelto de la compra realizada.
     */
    private int vuelto;
    /**
     * Producto de tarea2, se encarga de guardar en memoria el producto que se compra.
     */
    private Producto producto;
    /**
     * Deposito de monedas de vuelto. que se visualiza cuando se compra.
     */
    private VistasDeposito<VistasMonedas> depMonvu;
    /**
     * Constructor de PanelComprador usa un PanelExpendedor para iniciarlo
     * y usar su expendedor para usarlo en el comprador.
     * Se encarga de inicializar y agregar al panel las Vistasmonedas, VistasProducto
     * y los botones para comprar y retirar vuelto.
     * Tambien agrega mouseListener a cada componente, es decir a las Vistasmonedas y a los Jbutton.
     */
    public PanelComprador(PanelExpendedor panelExpendedor){
        this.setLayout(null);
        this.expendedor = panelExpendedor.getExpendedor();
        setPreferredSize(new Dimension(600,900));
        depMonvu = new VistasDeposito<>();
        this.vuelto=0;
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
        tomarVuelto= new JButton("Tomar Vuelto y Producto");

        tomarVuelto.setBounds(1,570,200,30);
        Comprar1.setBounds(100, 60, 100, 30);
        Comprar2.setBounds(100, 160, 100, 30);
        Comprar3.setBounds(100, 260, 100, 30);
        Comprar4.setBounds(100, 360, 100, 30);
        Comprar5.setBounds(100, 460, 100, 30);

        this.add(Comprar1);
        this.add(Comprar2);
        this.add(Comprar3);
        this.add(Comprar4);
        this.add(Comprar5);
        this.add(tomarVuelto);

        tomarVuelto.setEnabled(false);
        Comprar1.addMouseListener(this);
        Comprar2.addMouseListener(this);
        Comprar3.addMouseListener(this);
        Comprar4.addMouseListener(this);
        Comprar5.addMouseListener(this);
    }

    /**
     * Metodo Override que se encarga de pintar y agregar las imagenes de los productos
     * y las monedas al PanelComprador.
     * si el deposito de monedas de vuelto es distinto del nulo entonces
     * agrega al mismo las monedas de vuelto.
     * @param g graficos del paintcomponent
     */
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

    /**
     * Metodo que se encarga de llenar el deposito de monedas de vuelto;
     * @param vistasDeposito es un deposito de monedas, desde el cual se sacan
     *                       las monedas para el conteo del vuelto.
     */
    public void llenarDepMonvu(VistasDeposito<VistasMonedas> vistasDeposito) {
        Moneda moneda = comprador.getVuelto();
        while (moneda != null) {
            vistasDeposito.agregarProducto(new VistasMonedas(moneda, Color.YELLOW));
            moneda = comprador.getVuelto();
        }
        repaint();
    }

    /**
     *
     * @param vistasDeposito es un deposito que se encarga de sacar las monedas de vuelto
     *                       que fueron agregadas por el metodo llenarDepMonvu.
     */
    public void vaciarDepMonvu(VistasDeposito<VistasMonedas> vistasDeposito){
        VistasMonedas vMoneda = vistasDeposito.quitarVista();
        while(vMoneda != null){
            vMoneda = vistasDeposito.quitarVista();
        }
        repaint();
        JOptionPane.showMessageDialog(null, "Aqui esta su vuelto, Gracias por su compra");
    }

    /**
     * Metodo que se encarga de seleccionar una moneda mediante el click.
     * Tambien se encargade seleccionar el producto a comprar y de realizar la compra
     * lanzando tambien mensajes dependiendo de si la compra es exitosa o no
     * agregando vuelto a los depositos de monedas.
     * @param e evento a suceder.
     */
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
            tomarVuelto.removeMouseListener(this);
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
                    tomarVuelto.addMouseListener(this);
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
                    tomarVuelto.addMouseListener(this);
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
                    tomarVuelto.addMouseListener(this);
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
                    tomarVuelto.addMouseListener(this);
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
                    tomarVuelto.addMouseListener(this);
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


    /**
     * Getter de Comprar1(Para comprar Coca-Cola).
     * @return El boton Comprar1.
     */
    public JButton getComprar1() {
        return Comprar1;
    }
    /**
     * Getter de Comprar2(Para comprar Sprite).
     * @return El boton Comprar2.
     */
    public JButton getComprar2() {
        return Comprar2;
    }
    /**
     * Getter de Comprar3(Para comprar Fanta).
     * @return El boton Comprar3.
     */
    public JButton getComprar3() {
        return Comprar3;
    }
    /**
     * Getter de Comprar4(Para comprar Snicker).
     * @return El boton Comprar4.
     */
    public JButton getComprar4() {
        return Comprar4;
    }
    /**
     * Getter de Comprar5(Para comprar Super8).
     * @return El boton Comprar5.
     */
    public JButton getComprar5() {
        return Comprar5;
    }
    /**
     * Getter de respuestaCompra.
     * @return si la respuesta es afirmativa o no.
     */
    public int getRespuestaCompra(){
        return respuestaCompra;
    }
    /**
     * Getter de respuestaProductoSelec.
     * @return si la respuesta es afirmativa o no.
     */
    public int getRespuestaProductoSelec(){
        return respuestaProductoSelec;
    }
    /**
     * Getter de producto.
     * @return el producto comprado.
     */
    public Producto getProducto(){
        return producto;
    }
    /**
     * Getter de tomarVuelto
     * @return el vuelto de la compra.
     */
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