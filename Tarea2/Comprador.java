package Tarea2;

/**Clase principalmente usada para calcular el vuelto
  *y el tipo de productor que se consume*/
class Comprador{
    /**Propiedades de sonido que cosumio y vuelto*/
    private String sonido;
    private int vuelto;
/**Constructor principalmente calcula el vuelto, y su respectivo sonido al producto seleccionado
 * ademas de condicionar las exceptions para que se lanzen segun su condicion
 * @param m
 * @param exp
 * @param cualProducto
 */
    public Comprador(Moneda m,int cualProducto,Expendedor exp)throws NoHayProductoException, PagoIncorrectoException, PagoInsuficienteException {
        Producto b = exp.comprarProducto(m, cualProducto);
        if(b==null){
            throw new NoHayProductoException("No hay producto deseado en la maquina");
        }
        if(m==null){
            throw new PagoIncorrectoException("No ingresaste una moneda valida");
        }
        else{
            sonido=b.sabor();
            vuelto=0;
            while(exp.getVuelto()!=null){
                vuelto+=100;
            }
        }
    }
    /**Devuelve el vuelto
     * @return vuelto
     */
    public int cuantoVuelto(){
        return vuelto;
    }
    /**Devuelve el sonido del producto
     * @return sonido
     */
    public String queBebiste(){
        return sonido;
    }
}
