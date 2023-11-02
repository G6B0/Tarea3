package Tarea2;

import Tarea3.Ventana;

public class Main {
    public static void main(String[] args) throws NoHayProductoException, PagoIncorrectoException,PagoInsuficienteException {

        Expendedor exp = new Expendedor(3);
        Moneda m;
        Comprador c;
        //compra exitosa para cada producto//
        m = new Moneda1000();
        c = new Comprador(m, 1, exp);
        System.out.println(c.queBebiste() + ", "+c.cuantoVuelto());
        m = new Moneda1000();
        c = new Comprador(m,2,exp);
        System.out.println(c.queBebiste()+", "+c.cuantoVuelto());
        m = new Moneda1000();
        c = new Comprador(m,3,exp);
        System.out.println(c.queBebiste()+", "+c.cuantoVuelto());
        m = new Moneda1000();
        c = new Comprador(m,4,exp);
        System.out.println(c.queBebiste()+", "+c.cuantoVuelto());
        m = new Moneda1000();
        c = new Comprador(m,5,exp);
        System.out.println(c.queBebiste()+", "+c.cuantoVuelto());

        //PagoIncorrectoException//
        try {
            m = null;
            c = new Comprador(m, 1, exp);
        }
        catch (PagoIncorrectoException e){
            System.out.println("Error: Pago incorrecto");
            System.out.println(null+", "+0);
        }
        try {
            m = null;
            c = new Comprador(m, 2, exp);
        }
        catch (PagoIncorrectoException e){
            System.out.println("Error: Pago incorrecto");
            System.out.println(null+", "+0);
        }
        try {
            m = null;
            c = new Comprador(m, 3, exp);
        }
        catch (PagoIncorrectoException e){
            System.out.println("Error: Pago incorrecto");
            System.out.println(null+", "+0);
        }
        try {
            m = null;
            c = new Comprador(m, 3, exp);
        }
        catch (PagoIncorrectoException e){
            System.out.println("Error: Pago incorrecto");
            System.out.println(null+", "+0);
        }
        try {
            m = null;
            c = new Comprador(m, 4, exp);
        }
        catch (PagoIncorrectoException e){
            System.out.println("Error: Pago incorrecto");
            System.out.println(null+", "+0);
        }
        try {
            m = null;
            c = new Comprador(m, 5, exp);
        }
        catch (PagoIncorrectoException e){
            System.out.println("Error: Pago incorrecto");
            System.out.println(null+", "+0);
        }

        //PagoInsuficienteException//
        try {
            m = new Moneda100();
            c = new Comprador(m, 1, exp);
            System.out.println(c.queBebiste() + ", " + c.cuantoVuelto());
        }
        catch (PagoInsuficienteException e) {
            System.out.println("Error: Pago insuficiente");
            System.out.println(null+", "+m.getValor());
        }
        try {
            m = new Moneda100();
            c = new Comprador(m, 2, exp);
            System.out.println(c.queBebiste() + ", " + c.cuantoVuelto());
        }
        catch (PagoInsuficienteException e) {
            System.out.println("Error: Pago insuficiente");
            System.out.println(null+", "+m.getValor());
        }
        try {
            m = new Moneda100();
            c = new Comprador(m, 3, exp);
            System.out.println(c.queBebiste() + ", " + c.cuantoVuelto());
        }
        catch (PagoInsuficienteException e) {
            System.out.println("Error: Pago insuficiente");
            System.out.println(null+", "+m.getValor());
        }
        try {
            m = new Moneda100();
            c = new Comprador(m, 4, exp);
            System.out.println(c.queBebiste() + ", " + c.cuantoVuelto());
        }
        catch (PagoInsuficienteException e) {
            System.out.println("Error: Pago insuficiente");
            System.out.println(null+", "+m.getValor());
        }
        try {
            m = new Moneda100();
            c = new Comprador(m, 5, exp);
            System.out.println(c.queBebiste() + ", " + c.cuantoVuelto());
        }
        catch (PagoInsuficienteException e) {
            System.out.println("Error: Pago insuficiente");
            System.out.println(null+", "+m.getValor());
        }

        //compra exitosa para cada producto//
        m = new Moneda1000();
        c = new Comprador(m,1,exp);
        System.out.println(c.queBebiste()+", "+c.cuantoVuelto());
        m = new Moneda1000();
        c = new Comprador(m,2,exp);
        System.out.println(c.queBebiste()+", "+c.cuantoVuelto());
        m = new Moneda1000();
        c = new Comprador(m,3,exp);
        System.out.println(c.queBebiste()+", "+c.cuantoVuelto());
        m = new Moneda1000();
        c = new Comprador(m,4,exp);
        System.out.println(c.queBebiste()+", "+c.cuantoVuelto());
        m = new Moneda1000();
        c = new Comprador(m,5,exp);
        System.out.println(c.queBebiste()+", "+c.cuantoVuelto());

        //NoHayProductoException//
        try {
            m = new Moneda1500();
            c = new Comprador(m, 1, exp);
        }
        catch(NoHayProductoException e){
            System.out.println("No hay producto del tipo solicitado");
            System.out.println(null+", "+m.getValor());
        }
        try {
            m = new Moneda1500();
            c = new Comprador(m, 2, exp);
            System.out.println(c.queBebiste() + ", " + c.cuantoVuelto());
        }
        catch(NoHayProductoException e){
            System.out.println("No hay producto del tipo solicitado");
            System.out.println(null+", "+m.getValor());
        }
        try {
            m = new Moneda1500();
            c = new Comprador(m, 3, exp);
            System.out.println(c.queBebiste() + ", " + c.cuantoVuelto());
        }
        catch(NoHayProductoException e){
            System.out.println("No hay producto del tipo solicitado");
            System.out.println(null+", "+m.getValor());
        }
        try {
            m = new Moneda1500();
            c = new Comprador(m, 4, exp);
            System.out.println(c.queBebiste() + ", " + c.cuantoVuelto());
        }
        catch(NoHayProductoException e){
            System.out.println("No hay producto del tipo solicitado");
            System.out.println(null+", "+m.getValor());
        }
        try {
            m = new Moneda1500();
            c = new Comprador(m, 5, exp);
            System.out.println(c.queBebiste() + ", " + c.cuantoVuelto());
        }
        catch(NoHayProductoException e){
            System.out.println("No hay producto del tipo solicitado");
            System.out.println(null+", "+m.getValor());
        }   
    }
}