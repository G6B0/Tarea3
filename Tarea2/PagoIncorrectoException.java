package Tarea2;

/**
 * Esta clase se encarga de las excepciones de pagos incorrectos, es decir
 * cuando se intenta pagar con una moneda nula.
 */
public class PagoIncorrectoException extends Exception{
    /**
     * El constructor se encarga del mensaje que se visualiza cuando se captura la excepcion.
     * @param mensaje mensaje que se muestra en pantalla cuando ocurre la excepcion
     */
    public PagoIncorrectoException(String mensaje){
        super(mensaje);
    }
}
