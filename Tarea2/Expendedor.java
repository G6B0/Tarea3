package Tarea2;

public class Expendedor {
    /**Deposito de cocacola*/
    private Deposito<Bebida> coca;
    /**Deposito de sprite*/
    private Deposito<Bebida> sprite;
    /**Deposito de fanta*/
    private Deposito<Bebida> fanta;
    /**Deposito de monedas*/
    private Deposito<Moneda> monVu;
    /**Deposito de snickers*/
    private Deposito<Dulces> snickers;
    /**Deposito de super8*/
    private Deposito<Producto> productoSeleccionado;
    public Deposito<Dulces> super8;
    /**Constructor llena los depositos de los productos
     * @param numProductos
     */
    public Expendedor(int numProductos) {
        productoSeleccionado = new Deposito<>();
        this.coca = new Deposito<>();
        this.sprite = new Deposito<>();
        this.monVu = new Deposito<>();
        this.snickers= new Deposito<>();
        this.super8 = new Deposito<>();
        this.fanta= new Deposito<>();
        for (int i = 0; i < numProductos; i++) {
            coca.addElemento(new CocaCola(i));
            sprite.addElemento(new Sprite(10+i));
            fanta.addElemento(new Fanta(20+i));
            snickers.addElemento(new Snickers(30+i));
            super8.addElemento(new Super8(40+i));
        }
    }
    /**
     * Este método se utiliza para realizar la compra de un producto en la máquina expendedora,
     * gestionar el pago y calcular el cambio, si corresponde. También verifica si la moneda y
     * el producto seleccionado son válidos.
     * @param moneda La moneda utilizada para realizar la compra.
     * @param selector El selector que representa el producto deseado.
     * @return El producto comprado, o null si no está disponible.
     * @throws PagoIncorrectoException Si la moneda es nula o no válida.
     * @throws PagoInsuficienteException Si el pago es insuficiente para el producto.
     */
    public void comprarProducto(Moneda moneda,int selector) throws PagoInsuficienteException,PagoIncorrectoException{
        Producto b=null;
        if(moneda==null) {
            throw new PagoIncorrectoException("Error: Pago Incorrecto");
        }
        else {
            switch (selector){
                case 1:
                    b=coca.getElemento();
                    break;
                case 2:
                    b=sprite.getElemento();
                    break;
                case 3:
                    b=fanta.getElemento();
                    break;
                case 4:
                    b=snickers.getElemento();
                    break;
                case 5:
                    b=super8.getElemento();
                    break;
                default:
                    b= null;
                    break;
            }
            if (b == null) {
                monVu.addElemento(moneda);
            }
            else {
                if ((b instanceof CocaCola) && (moneda.getValor() < TipoProductos.COCACOLA.getPrecio())) {
                    coca.addElemento((CocaCola)b);
                    throw new PagoInsuficienteException("Error:Pago Insuficiente");
                }

                if ((moneda.getValor() < TipoProductos.SPRITE.getPrecio()) && (b instanceof Sprite)) {
                    sprite.addElemento((Sprite)b);
                    throw new PagoInsuficienteException("Error:Pago Insuficiente");
                }

                else if ((moneda.getValor() < TipoProductos.FANTA.getPrecio()) && (b instanceof Fanta)){
                    fanta.addElemento((Fanta)b);
                    throw new PagoInsuficienteException("Error:Pago Insuficiente");
                }

                else if ((moneda.getValor() < TipoProductos.SNICKER.getPrecio()) && (b instanceof Snickers)){
                    snickers.addElemento((Snickers)b);
                    throw new PagoInsuficienteException("Error:Pago Insuficiente");
                }

                else if ((moneda.getValor() < TipoProductos.SUPER8.getPrecio()) && (b instanceof Super8)){
                    super8.addElemento((Super8)b);
                    throw new PagoInsuficienteException("Error:Pago Insuficiente");
                }

                else {
                    if(selector==1) {
                        int vuelto= moneda.getValor() - TipoProductos.COCACOLA.getPrecio();
                        while (vuelto > 0) {
                            if (vuelto >= 1500) {
                                monVu.addElemento(new Moneda1500());
                                vuelto -= 1500;
                            } else if (vuelto >= 1000) {
                                monVu.addElemento(new Moneda1000());
                                vuelto -= 1000;
                            } else if (vuelto >= 500) {
                                monVu.addElemento(new Moneda500());
                                vuelto -= 500;
                            } else if (vuelto >= 100) {
                                monVu.addElemento(new Moneda100());
                                vuelto -= 100;
                            }
                        }
                        productoSeleccionado.addElemento(b);
                    }
                    else if(selector==2) {
                        int vuelto= moneda.getValor() - TipoProductos.SPRITE.getPrecio();
                        while (vuelto > 0) {
                            if (vuelto >= 1500) {
                                monVu.addElemento(new Moneda1500());
                                vuelto -= 1500;
                            } else if (vuelto >= 1000) {
                                monVu.addElemento(new Moneda1000());
                                vuelto -= 1000;
                            } else if (vuelto >= 500) {
                                monVu.addElemento(new Moneda500());
                                vuelto -= 500;
                            } else if (vuelto >= 100) {
                                monVu.addElemento(new Moneda100());
                                vuelto -= 100;
                            }
                        }
                        productoSeleccionado.addElemento(b);
                    }
                    else if(selector==3) {
                        int vuelto= moneda.getValor() - TipoProductos.FANTA.getPrecio();
                        while (vuelto > 0) {
                            if (vuelto >= 1500) {
                                monVu.addElemento(new Moneda1500());
                                vuelto -= 1500;
                            } else if (vuelto >= 1000) {
                                monVu.addElemento(new Moneda1000());
                                vuelto -= 1000;
                            } else if (vuelto >= 500) {
                                monVu.addElemento(new Moneda500());
                                vuelto -= 500;
                            } else if (vuelto >= 100) {
                                monVu.addElemento(new Moneda100());
                                vuelto -= 100;
                            }
                        }
                        productoSeleccionado.addElemento(b);
                    }
                    else if(selector==4) {
                        int vuelto= moneda.getValor() - TipoProductos.SNICKER.getPrecio();
                        while (vuelto > 0) {
                            if (vuelto >= 1500) {
                                monVu.addElemento(new Moneda1500());
                                vuelto -= 1500;
                            } else if (vuelto >= 1000) {
                                monVu.addElemento(new Moneda1000());
                                vuelto -= 1000;
                            } else if (vuelto >= 500) {
                                monVu.addElemento(new Moneda500());
                                vuelto -= 500;
                            } else if (vuelto >= 100) {
                                monVu.addElemento(new Moneda100());
                                vuelto -= 100;
                            }
                        }
                        productoSeleccionado.addElemento(b);
                    }
                    else{
                        int vuelto= moneda.getValor() - TipoProductos.SUPER8.getPrecio();
                        while (vuelto > 0) {
                            if (vuelto >= 1500) {
                                monVu.addElemento(new Moneda1500());
                                vuelto -= 1500;
                            } else if (vuelto >= 1000) {
                                monVu.addElemento(new Moneda1000());
                                vuelto -= 1000;
                            } else if (vuelto >= 500) {
                                monVu.addElemento(new Moneda500());
                                vuelto -= 500;
                            } else if (vuelto >= 100) {
                                monVu.addElemento(new Moneda100());
                                vuelto -= 100;
                            }
                        }
                        productoSeleccionado.addElemento(b);
                    }
                }
            }
        }
    }
    /**Devuelve la moneda para el vuelto a calcular
     * @return moneda
     */
    public Moneda getVuelto(){
        return monVu.getElemento();
    }
    public Producto getProducto(){
        return productoSeleccionado.getElemento();
    }
}