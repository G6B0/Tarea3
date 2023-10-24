package Tarea2;

/**Subclase Snicker*/
public class Snickers extends Dulces{
    private int nserie;
    /**Constructor inicializa la clase Super y el numero de serie*/
    public Snickers(int nserie){
        super(nserie);
    }
    /**Retorna el sabor del tipo de dulce
     * @return String del sabor del dulce
     */
    @Override
    public String sabor() {
        return super.sabor()+"snicker";
    }
}
