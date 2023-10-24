package Tarea2;

/**La enumeración TipoProductos representa los diferentes tipos de productos disponibles
 * en una máquina expendedora, junto con sus respectivos precios.
 */
public enum TipoProductos {
    /**Representa el producto "CocaCola" y su precio es 600*/
    COCACOLA(600),

    /**Representa el producto "Sprite" y su preciop es 500*/
    SPRITE(500),

    /**Representa el producto "Fanta" y su precio es 700*/
    FANTA(700),

    /**Representa el producto "Snickers" y su precio es 200*/
    SNICKER(200),

    /**Representa el producto "Super8" y su precio es 300*/
    SUPER8(300);

    private int precio;

    /**Constructor de TipoProductos.
     * @param precio El precio del producto.
     */
    TipoProductos(int precio) {
        this.precio = precio;
    }

    /**Obtiene el precio del producto.
     * @return El precio del producto en unidades de moneda.
     */
    public int getPrecio() {
        return precio;
    }
}

