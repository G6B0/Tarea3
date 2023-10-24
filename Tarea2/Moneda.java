package Tarea2;

/**Clase representa Moneda y sera super clase de las demas monedas*/
abstract class Moneda{
    /**Constructor se inicializa por defecto*/
    public Moneda(){
    }
    /**Getter retorna la referencia de este objeto
     * @return this
     */
    public Moneda getSerie(){
        return this;
    }
    /**Plantilla de metodo para devolver el valor*/
    public abstract int getValor();
}