package Tarea2;

/**Clase que sirve polimorficamente para las subclases de bebida*/
public abstract class Bebida extends Producto{
    /**Numero de serie(propiedad)*/
    private int nserie;
    /**Constructor inicializa la variable de serie*/
    public Bebida(int nserie){
        this.nserie=nserie;
    }
    /**Devuelve el numero de serie que se hereda a las demas
     * @return  nserie
     */
    @Override
    public int getSerie() {
        return nserie;
    }
    /**Indica que sabor es ya que es clase Bebida
     * @return String de sabor:*/

    @Override
    public String sabor() {
        return "Sabor a: ";
    }
}
