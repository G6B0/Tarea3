package Tarea2;

/**
 * Esta clase se encarga de las excepciones en las que no hay productos
 * en el expendedor
 */
public class NoHayProductoException extends Exception{
    /**
     * El constructor se encarga del mensaje que se visualiza cuando se captura la excepcion.
     * @param mensaje mensaje que se muestra en pantalla cuando ocurre la excepcion
     */
    public NoHayProductoException(String mensaje){
        super(mensaje);
    }
}
