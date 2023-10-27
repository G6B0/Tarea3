package Tarea2;

import java.util.ArrayList;

/**La clase Deposito es un contenedor genérico que permite almacenar elementos
 * de cualquier tipo especificado por el parámetro tipo T.
 */
public class Deposito<T> {
    public ArrayList<T> deposito;

    /**Constructor por defecto que inicializa un nuevo depósito vacío.
     */
    public Deposito() {
        deposito = new ArrayList<>();
    }

    /**Agrega un elemento al depósito.
     * @param elemento El elemento que se agregará al depósito.
     */
    public void addElemento(T elemento) {
        deposito.add(elemento);
    }

    /**Obtiene y elimina el primer elemento del depósito.
     *@return El primer elemento del depósito, o null si el depósito está vacío.
     */
    public T getElemento() {
        if (deposito.isEmpty()) {
            return null;
        } else {
            return deposito.remove(0);
        }
    }
}
