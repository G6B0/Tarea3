package Tarea2;

/**Subclase Moneda100*/
public class Moneda100 extends Moneda implements Comparable<Moneda>{
    /**Constructor por defecto inicializa el constructor de la superclase*/
    public Moneda100(){
        super();
    }
    /**Devuelve el valor 100 entero*/
    @Override
    public int getValor() {
        return 100;
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
/**toSring que retorna la referencia de esta referencia y su valor*/
    @Override
    public String toString() {
        return super.toString();
    }


}