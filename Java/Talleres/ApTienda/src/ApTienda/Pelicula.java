
package ApTienda;

public class Pelicula {
    
    private final String codigo;
    private final String titulo;
    private final Double precioBase;
    public int cantidadActual;
    private static final double IVA_VENTAS=1.19;
    
    public Pelicula(String pcodigo, String ptitulo, double pprecioBase){
        codigo=pcodigo;
        titulo=ptitulo;
        precioBase=pprecioBase*IVA_VENTAS;
        cantidadActual=1;
    }

    public Pelicula(String pcodigo, String ptitulo, double pprecioBase, int pcantidadActual){
        codigo=pcodigo;
        titulo=ptitulo;
        precioBase=pprecioBase;
        cantidadActual=pcantidadActual;
        
    }
    
    public String obtenerCodigo(){
        return codigo;
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
            System.out.println("SE DEBE HACER UN PEDIDO DE LA PELICULA: "+titulo);
        }
        cantidadActual=cantidadActual-1;
    }

    public void setCantidadActual(int cantidadActual) {
        this.cantidadActual = cantidadActual;
    }

    
    public void hacerPedido(){
        
    }
}
