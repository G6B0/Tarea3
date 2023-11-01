package Tarea2;

/**Subclase moneda1000*/
public class Moneda1000 extends Moneda implements Comparable<Moneda> {
    /**Constructor por defecto inicializa el constructor de la superclase*/
    public Moneda1000(){
        super();
    }
    /**Devuelve el valor 1000 entero*/
    @Override
    public int getValor() {
        return 1000;
    }
    /**Metodo comparable compara el valor de esta moneda con otra
     * mediante "Integer.compare"
     * @param otraMoneda
     * @return un numero entero
     */
    @Override
    public int compareTo(Moneda otraMoneda) {
        return Integer.compare(this.getValor(), otraMoneda.getValor());
    }
    @Override
    public String toString() {
        return "Moneda de 1000";
    }
}