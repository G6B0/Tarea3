package Tarea3;

import java.awt.*;
import javax.swing.border.Border;
import Tarea2.*;
import javax.swing.*;


public class VistasDeposito<T extends Component> extends JPanel {
    private Deposito<T> deposito;

    public VistasDeposito() {
        deposito = new Deposito<>();
        setPreferredSize(new Dimension(350, 90));
    }
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
