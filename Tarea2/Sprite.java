package Tarea2;

/**Subclase sprite*/
public class Sprite extends Bebida {
    private int nserie;
    /**Constructor inicializa la clase Super y el numero de serie*/
    public Sprite(int nserie){
        super(nserie);
    }
    /**Retorna el sabor del tipo de bebida
     * @return String del sabor de la bebida
     */
    @Override
    public String sabor() {
        return "Sprite";
    }
}
