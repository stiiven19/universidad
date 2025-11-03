package ApTienda;
import java.util.ArrayList;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Byron
 */
public class CarroCompra {
    static ArrayList<Pelicula> carro;//carro
    ItemsCompra items=new ItemsCompra(); 
    static Pelicula l;
    static ArrayList<Pelicula> catalogo;//catalogo
//    ArrayList<Pelicula> ventas;//maneja ventas ya hechas
    
    double caja=1000000;
    
    public CarroCompra(){
    carro=new ArrayList() ;//ARRAI que almacena lo del carro de compras
//    ventas=new ArrayList();//arrai que almacena las ventas hechas
    
}////constructor de arrais
    
    public double obtenerCaja(){
        return caja;
    }//retorna el valor de caja
    
    
    
    public ArrayList<Pelicula> obtenerExixtenciasEnCarro(){
         return carro;
     }//retorna el arrai carro de compras para obtener su contenido
    

    
    public void agregarCodigo(String a){
        if(items.buscarCodigo(a) !=null){
            carro.add(items.buscarCodigo(a));
        }
    }//AGREGA AL CARRO DE COMPRAS UN Pelicula por Codigo
    
    public void agregarTitulo(String c){
        if (items.buscarTitulo(c) !=null){
            carro.add(items.buscarTitulo(c));
        }
    }//AGREGA AL CARRO DE COMPRAS UN Pelicula por titulo
    
    public void agregarCatalogo(int a){
        catalogo=items.obtenerCatalogo();
        Pelicula Pelicula=catalogo.get(a-1);
        carro.add(Pelicula);
        
        
    }//AGREGA AL CARRO DE COMPRAS PeliculaS por el catalogo
    
    
    

    public void quitarExixtencias(int a){
        if (a==0) {
            carro.clear();
        } else 
            if (a>0){
               if (a-1>carro.size()||a<1) {
                   System.out.println("La Pelicula con numero en lista "+a+" no existe");
                   System.out.println("SELECCIONE UNA OPCION VALIDA");
               }else{
                   System.out.println(" Se ha removido la Pelicula con numero en lista "+a);    
                   carro.remove(a-1);
               }
        }else{
                System.out.println("la Pelicula con numero en lista "+a+" no existe");
                   System.out.println("SELECCIONE UNA OPCION VALIDA");
            }
        
    }//QUITA EXISTENCIAS 1x1 DEL CARRO DE COMPRAS
            
    
   
    /** Metodo agrega las ventas hechas en carro de compras
     * 
     */
     public void HacerVentasDelCarroDeCompras(){
        double total=0;
        for(int i=0;i<carro.size();i++){//obtenemos el precio total
            total =total+carro.get(i).obtenerPrecioVenta(carro.get(i).obtenerPrecioBase());
        }
        caja=caja+total;
        System.out.println("HAS COMPRADO "+carro.size()+" PELICULAS");
        System.out.println("PRECIO TOTAL: "+total);
        items.realizarVentas(carro);
        carro.clear();
    }
     

    /** Metodo para obtener el precio total del carrodecompras
     * 
     * @return preciototal
     */
    public double precioTotalCarro(){
         double total=0;
         for(int i=0;i<carro.size();i++){
             total=total+carro.get(i).obtenerPrecioVenta(carro.get(i).obtenerPrecioBase());
         }
         return total;
     }//RETORNA EL VALOR TOTAL DE LOS PeliculaS DE CARRO DE COMPRAS
    
    public void MostrarCarro(){
        System.out.println("");
        System.out.println("cantidad de Peliculas en el Carro De Compras : "+carro.size());
        for (int i=0;i<carro.size();i++){
            System.out.println("");
            System.out.println("________________________________________________");
            System.out.println("-Codigo: "+carro.get(i).obtenerCodigo());
            System.out.println("-La Pelicula: "+carro.get(i).obtenerTitulo());
            System.out.println("-Cantidad: "+carro.get(i).obtenerCantidadActual()+" ejemplares");
            System.out.println("-Precio Base: $"+carro.get(i).obtenerPrecioBase()+" Pesos");
            System.out.println("-Precio Venta: $"+carro.get(i).obtenerPrecioVenta(carro.get(i).obtenerPrecioBase())+" Pesos");
            System.out.println("_________________________________________________");
        }
        System.out.println("");
        System.out.println("PRECIO TOTAL: "+precioTotalCarro());
    }
    
    
    
    
}
