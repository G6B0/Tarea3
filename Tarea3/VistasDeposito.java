package Tarea3;

import java.awt.*;
import javax.swing.border.Border;
import Tarea2.*;
import javax.swing.*;


public class VistasDeposito<T> extends JPanel {
    private Deposito<VistasProducto> deposito;

    public VistasDeposito() {
        deposito = new Deposito<>();
        setPreferredSize(new Dimension(300, 100));
    }

    public void agregarProducto(VistasProducto producto) {
        deposito.addElemento(producto);
        add(producto);
    }
    public Deposito getDeposito(){
        return deposito;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(0, 0, 300, 100);

        int cantidad = deposito.deposito.size();
        int regionAncho = 300/ 3;
        for (int i = 0; i < cantidad; i++) {
            int x = (i % 3) * regionAncho;
            deposito.deposito.get(i).setBounds(x+2, 1, 90, 90);
        }
    }
   /* public static void main(String[] args) {
        // Crear un nuevo depósito
        VistasDeposito<VistasProducto> deposito = new VistasDeposito<>();

        // Crear productos y agregarlos al depósito
        VistasProducto producto1 = new VistasProducto(new CocaCola(2),90,70);
        VistasProducto producto3 = new VistasProducto(new CocaCola(5),90,70);
        VistasProducto producto4 = new VistasProducto(new CocaCola(3),90,70);
        deposito.agregarProducto(producto4);
        deposito.agregarProducto(producto1);
        deposito.agregarProducto(producto3);
        // Crear una ventana para mostrar el depósito
        JFrame ventana = new JFrame("Prueba del Depósito");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(290, 200);

        // Agregar el depósito a la ventana
        ventana.add(deposito);

        // Mostrar la ventana
        ventana.setVisible(true);
        System.out.println(deposito.deposito.deposito.size());
    }*/
}
