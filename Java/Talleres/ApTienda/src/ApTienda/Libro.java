/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aptienda;


/**
 *
 * @author Byron
 */

public class Libro {
    
    private final String isbn;
    private final String titulo;
    private final Double precioBase;
    public int cantidadActual;
    private static final double IVA_VENTAS=1.19;
    
    public Libro(String pisbn, String ptitulo, double pprecioBase){
        isbn=pisbn;
        titulo=ptitulo;
        precioBase=pprecioBase*IVA_VENTAS;
        cantidadActual=1;
    }

    public Libro(String pisbn, String ptitulo, double pprecioBase, int pcantidadActual){
        isbn=pisbn;
        titulo=ptitulo;
        precioBase=pprecioBase;
        cantidadActual=pcantidadActual;
        
    }
    
    public String obtenerIsbn(){
        return isbn;
    }
    
    public String obtenerTitulo(){
        return titulo;
    }
    
    public double obtenerPrecioBase(){
        return precioBase;
    }
    
    public int obtenerCantidadActual(){
        return cantidadActual;
    }
    
    public double obtenerPrecioVenta(double a){
        a=a*IVA_VENTAS;
        return a;
    }
    
    public void quitarCantidades(){
        if (cantidadActual<5) {
            System.out.println("SE DEBE HACER UN PEDIDO DE EL LIBRO: "+titulo);
        }
        cantidadActual=cantidadActual-1;
    }

    public void setCantidadActual(int cantidadActual) {
        this.cantidadActual = cantidadActual;
    }

    
    public void hacerPedido(){
        
    }
}
