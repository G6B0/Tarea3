package Tarea2;

/**Subclase Moneda500*/
class Moneda500 extends Moneda implements Comparable<Moneda>{
    /**Constructor por defecto inicializa el constructor de la superclase*/
    public Moneda500(){
        super();
    }
    /**Devuelve el valor 500 entero*/
    @Override
    public int getValor() {
        return 500;
    }
    /**Metodo comparable compara el valor de esta moneda con otra
     * mediante "Integer.compare"
     * @param otraMoneda
     * @return un numero entero
     */
    @Override
    public int compareTo(Moneda otraMoneda) {
        return Integer.compare(this.getValor(),otraMoneda.getValor());
    }
    @Override
    public String toString() {
        return "Numero de serie: " + super.toString() + ", Su valor es: " + getValor();
    }
}