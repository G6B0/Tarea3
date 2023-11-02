package Tarea2;

/**Clase principalmente usada para calcular el vuelto
  *y el tipo de productor que se consume*/
   public class Comprador{
        /**Propiedades de sonido que cosumio y vuelto*/
        private String sonido;
        private int vuelto;
        private Producto b;
    /**Constructor principalmente calcula el vuelto, y su respectivo sonido al producto seleccionado
     * ademas de condicionar las exceptions para que se lanzen segun su condicion
     * @param m
     * @param exp
     * @param cualProducto
     */
        public Comprador(Moneda m,int cualProducto,Expendedor exp)throws NoHayProductoException, PagoIncorrectoException, PagoInsuficienteException {
            exp.comprarProducto(m, cualProducto);
            b = exp.getProducto();
            if(b==null){
                throw new NoHayProductoException("No hay producto deseado en la maquina");
            }
            if(m==null){
                throw new PagoIncorrectoException("No ingresaste una moneda valida");
            }
            else{
                sonido=b.sabor();
                vuelto=0;
                Moneda vueltoMoneda = exp.getVuelto();
                while (vueltoMoneda != null) {
                    vuelto += vueltoMoneda.getValor();
                    vueltoMoneda = exp.getVuelto();
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
        public Producto getProducto(){
            return b;
        }
    }
