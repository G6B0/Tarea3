package Tarea3;

import java.awt.*;
import Tarea2.*;
import javax.swing.*;


public class VistasDeposito<T extends Component> extends JPanel {
    private Deposito<T> deposito;
/**Constructor inicializa el deposito clase tarea2 y el tamaño de su vista fijo*/
    public VistasDeposito() {
        deposito = new Deposito<>();
        setPreferredSize(new Dimension(350, 90));
    }
    /**Metodo para agregar un producto y su vista */
    public void agregarProducto(T elemento) {
        deposito.addElemento(elemento);
        add((Component) elemento);
    }

    public Deposito<T> getDeposito() {
        return deposito;
    }

    public T quitarVista() {
        if (deposito.deposito.size() == 0) {
            return null;
        } else {
            T vista = deposito.getElemento();
            remove((Component) vista);
            revalidate();
            repaint();
            return vista;
        }
    }
/**Metodo pain dibuja los productos/monedas dentro del area(rectangulo)
 * de manera que los ordene de 3 en 3(simulando que estan ordenados en fila como en una maquina expendedora)
 * @param g
 */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(0, 0, 350, 90);

        int cantidad = deposito.deposito.size();
        int regionAncho = 330/ 3;
        for (int i = 0; i < cantidad; i++) {
            int x = (i % 3) * regionAncho;
            deposito.deposito.get(i).setBounds(x, 1, 90, 90);
        }
    }
}
