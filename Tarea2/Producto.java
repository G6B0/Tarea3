package Tarea2;

/**Clase plantilla que representa producto(dulces o bebidas)*/
abstract class Producto {
/**Metodos base-plantilla*/
    int getSerie() {
        return 0;
    }

    abstract String sabor();
}
