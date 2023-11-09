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
/**
 * Clase PanelExpendedor representa un panel gráfico que simula un expendedor.
 * Permite a los usuarios visualizar el expendedor que contiene depositos de productos.
 *
 * Los productos disponibles y sus depósitos se gestionan mediante instancias de VistasDeposito
 * y se utilizan para mostrar los productos disponibles en el panel.
 *
 * La clase PanelExpendedor también controla la interacción del usuario a través de eventos de clic del mouse.
 * Puede rellenar los depósitos de productos vacíos y realizar un seguimiento de las selecciones de productos.
 */
public class PanelExpendedor extends JPanel implements MouseListener {
    /**
     * Imagen que muestra visualmente el expendedor.
     */
    private BufferedImage imagen;
    /**
     * Depósito de productos de tipo Coca-Cola.
     */
    private VistasDeposito<VistasProducto> depCocacola;
    /**
     * Depósito de productos de tipo Sprite.
     */
    private VistasDeposito<VistasProducto> depSprite;
    /**
     * Depósito de productos de tipo Fanta.
     */
    private VistasDeposito<VistasProducto> depFanta;
    /**
     * Depósito de productos de tipo Snickers.
     */
    private VistasDeposito<VistasProducto> depSnickers;
    /**
     * Depósito de productos de tipo Super8.
     */
    private VistasDeposito<VistasProducto> depSuper8;
    /**
     * Depósito del producto comprado.
     */
    private VistasDeposito<VistasProducto> depProductoSelec;
    /**
     * Expendedor de tarea2
     */
    private Expendedor expendedor;
    /**
     * Producto que se encuentra en el depProductoSelec;
     */
    private Producto productoSelec;
    /**
     * cantidad que se encarga de inicializar el expendedor.
     */
    private int cantidad;

    /**
     *Constructor crea una instancia de PanelExpendedor con la cantidad especificada de productos disponibles,
     * donde tambien se inicializa el expendedor clase tarea2
     * @param cantidad La cantidad de productos disponibles inicialmente en el expendedor.
     */
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
    /**
     * Metodo que se encarga de cargar la imagen del expendedor
     * @param ruta es el enlace a la imagen del expendedor.
     */
    private BufferedImage cargarImagen(String ruta) {
        try {
            return ImageIO.read(new File(ruta));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * Realiza una actualización de la vista para mostrar el producto seleccionado por el usuario.
     *
     * @param producto El producto seleccionado por el usuario.
     * @throws PagoInsuficienteException Si el pago realizado es insuficiente para comprar el producto.
     * @throws PagoIncorrectoException Si el pago realizado es incorrecto para comprar el producto.
     */
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
    /**
     * Vacía el depósito de productos seleccionados en la vista.
     */
    public void vaciarDepProductoSelec() {
        while (true) {
            VistasProducto vistaProducto = depProductoSelec.quitarVista();
            if (vistaProducto == null) {
                break;
            }
            remove(vistaProducto);
            repaint();
        }
    }
    /**
     * Obtiene el objeto Expendedor asociado al panel.
     * @return El objeto Expendedor asociado al panel.
     */
    public Expendedor getExpendedor() {
        return expendedor;
    }
    /**
     *  Metodo Override paint que se encarga de dibujar el PanelExpendedor junto con todas
     *  sus componentes, es decir, con los depositos correspondientes.
     */
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
    /**
     * Override de mouseClicked, se encarga de que cuando se haga click dentro de PanelExpendedor
     * si y solo si algun deposito se encuentra vacío este metodo se encargará de
     * llenarlo, junto con un mensaje que te avisa del llenado.
     *
     */
    @Override
    public void mouseClicked(MouseEvent e) {
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

}