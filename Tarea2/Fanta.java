package Tarea2;

public class Fanta extends Bebida{
    private int nserie;
    /**Constructor inicializa la clase Super y el numero de serie*/
    public Fanta(int nserie){
        super(nserie);
    }
    /**Retorna el sabor del tipo de bebida
     * @return String del sabor de la bebida
     */
    @Override
    public String sabor() {
        return super.sabor()+"fanta";
    }
}
