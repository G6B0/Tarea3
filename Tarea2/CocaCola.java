package Tarea2;

/**Bebida tipo cocacola que entrega su sabor*/
public class CocaCola extends Bebida {
    /**numero de serie asociado*/
    private int nserie;
    /**Constructor inicializa su clase padre y su numero de serie*/
    public CocaCola(int nserie) {
        super(nserie);
    }
    /**Metodo devuelve el tipo sabor de la bebida
     * @return String sabor
     */
    @Override
    public String sabor() {
        return "Cocacola";
    }
}