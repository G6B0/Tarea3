package Tarea2;

/**Clase que representa el producto super8*/
public class Super8 extends Dulces{
    private int nserie;
    /**Constructor inicializa la clase Super y el numero de serie*/
    public Super8(int nserie){
        super(nserie);
    }
    /**Retorna el sabor del tipo de dulce
     * @return String del sabor del dulce
     */
    @Override
    public String sabor() {
        return "Super8";
    }
}