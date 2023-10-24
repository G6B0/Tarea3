package Tarea2;

/**Clase dulces que servira para crear subclases polimorficamente*/
abstract class Dulces extends Producto{
    private int nserie;
    /**Constructor inicializa la propiedad numero de serie
     * @param nserie
     */
    public Dulces(int nserie){
        this.nserie=nserie;
    }
    @Override
    public int getSerie() {
        return nserie;
    }
    /**Metodo que retorna el sabor inicial
     * @return sabor de...
     */
    @Override
    public String sabor() {
        return "Sabor a: ";
    }
}
