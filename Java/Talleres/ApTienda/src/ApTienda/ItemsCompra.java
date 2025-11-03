/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApTienda;
import java.util.ArrayList;


/**
 *
 * @author Byron
 */

public class ItemsCompra {
    
    private static double precioVenta;
    private static double IVA_VENTAS;
    //CarroCompra carro=new CarroCompra();    
        private static ArrayList<Pelicula> catalogo;
        private static ArrayList<Pelicula> ventas = new ArrayList();//maneja ventas ya hechas
        
    public ItemsCompra(){
        catalogo=new ArrayList();
        IVA_VENTAS=1.19;
        catalogo.add(new Pelicula( "00", "ana", 10000, 10 ));
        catalogo.add(new Pelicula("01", "CIEN AÑOS DE SOLEDAD",20000, 10));
        catalogo.add(new Pelicula("02", "LA TREGUA", 15000, 10));
        catalogo.add(new Pelicula("03", "FORTUNATA Y JACINTA", 17000, 10 ));
        catalogo.add(new Pelicula("04", "CAMPOS DE CASTILLA", 25000, 10));
        catalogo.add(new Pelicula("05", "EL ALEPH", 30000, 10));
        catalogo.add(new Pelicula("06", "HISTORIAS DE CRONOPIOS Y DE FAMAS", 40000, 10));
        catalogo.add(new Pelicula("07", "DON QUIJOTE DE LA MANCHA", 37000, 10));
        catalogo.add(new Pelicula("08", "LOS RENGLONES TORCIDOS DE DIOS", 14000, 10 ));
        catalogo.add(new Pelicula("09", "LA FIESTA DEL CHIVO", 12000, 10));
        catalogo.add(new Pelicula("10", "FICCIONES", 16000, 10));
        catalogo.add(new Pelicula("11", "El futuro de nuestra mente", 35000, 10));
        catalogo.add(new Pelicula("12", "Breve historia de mi vida", 20000, 10));
        catalogo.add(new Pelicula("13", "El bonobo y los diez mandamientos", 17000, 10));
        catalogo.add(new Pelicula("14", "Somos nuestro cerebro: cómo pensamos, sufrimos y amamos", 11000, 10));
        catalogo.add(new Pelicula("15", "La cuenta atrás", 25000,10));
        catalogo.add(new Pelicula("16", "El corazón de las tinieblas: materia y energía oscuras", 20000, 10));
        catalogo.add(new Pelicula("17", "Preguntas al aire: la meteorología tiene la respuesta", 16000, 10));
        catalogo.add(new Pelicula("18", "El sello indeleble", 13000, 10));
        catalogo.add(new Pelicula("19", "Curiosidad. Por qué todo nos interesa", 15000, 10));
        catalogo.add(new Pelicula("20", "El triunfo de la compasión", 8000, 10));
        
    }//constructor que agrega los Peliculas al catalogo
    
    /** Metodo que obtiene el precio de venta de un Pelicula
     * 
     * @param precioBase
     * @return retorna el precio de venta 
     */
    public double obtenerPrecioVenta(double precioBase){
        precioVenta=precioBase*IVA_VENTAS;
        return precioVenta;
    }  //retorna el precio de venta de un Pelicula 
    
    public ArrayList<Pelicula> obtenerCatalogo(){

        return catalogo;
        
    }//retorn el catalogo
    
    
    public Pelicula buscarCodigo(String codigo){
        Pelicula pelicula=null;
        for (int i = 0; i < catalogo.size(); i++) {
            if(codigo.equals(catalogo.get(i).obtenerCodigo())){
               pelicula=catalogo.get(i);
                break;
            }
        }
        if(pelicula!=null) {
            System.out.println("");
            System.out.println("la Pelicula que Busca es: ");
            System.out.println("_________________________________________________");
            System.out.println("");
            System.out.println("-Codigo: "+pelicula.obtenerCodigo());
            System.out.println("-la pelicula: "+pelicula.obtenerTitulo());
            System.out.println("-Cantidad: "+pelicula.obtenerCantidadActual()+" ejemplares");
            System.out.println("-Precio Base: $"+pelicula.obtenerPrecioBase()+" Pesos");
            System.out.println("-Precio Venta: $"+pelicula.obtenerPrecioVenta(pelicula.obtenerPrecioBase())+" Pesos");
            System.out.println("_________________________________________________");
        }else{
            System.out.println("");
            System.out.println("La Pelicula que Busca Con Codigo: "+codigo+" No Se Encuentra En Nuestra Bodega");
        }
        return pelicula;
    }//Buscar Peliculas por Codigo
    
     public void realizarVentas(ArrayList<Pelicula> CarroDeCompras){//elimina cantidad por ventas hechas
         Pelicula pelicula;
         int cantActual;
         for (int y=0;y<CarroDeCompras.size();y++){
            for(int i=0;i<catalogo.size();i++){
                if(CarroDeCompras.get(y).obtenerCodigo().equals(catalogo.get(i).obtenerCodigo())){
                    cantActual=catalogo.get(i).obtenerCantidadActual(); //int=cantcatalogo
                    cantActual=cantActual-1;                            //int-1
                    catalogo.get(i).setCantidadActual(cantActual);      //setcanactual a catalogo
                    pelicula=catalogo.get(i);
                    setVenta(pelicula);
                    break;
                }
            } 
         }        
     }
    //BUSCAR TITULO
    public Pelicula buscarTitulo(String titulo){
        Pelicula pelicula=null;
        for (int i = 0; i < catalogo.size(); i++) {
            if(titulo.equals(catalogo.get(i).obtenerTitulo())){
                pelicula=catalogo.get(i);
                break;
            }
        }
        if(pelicula!=null) {
        System.out.println("");
        System.out.println("El Pelicula que Busca es: ");
        System.out.println("_________________________________________________");
        System.out.println("");
        System.out.println("-Codigo: "+pelicula.obtenerCodigo());
        System.out.println("-La Pelicula: "+pelicula.obtenerTitulo());
        System.out.println("-Cantidad: "+pelicula.obtenerCantidadActual()+" ejemplares");
        System.out.println("-Precio Base: $"+pelicula.obtenerPrecioBase()+" Pesos");
        System.out.println("-Precio Venta: $"+pelicula.obtenerPrecioVenta(pelicula.obtenerPrecioBase())+" Pesos");
        System.out.println("_________________________________________________");
        }else{
            System.out.println("");
            System.out.println("La Pelicula que Busca Con Titulo: "+titulo+" No Se Encuentra En Nuestra Bodega");
        }
        return pelicula;
    }//buscar peliculas por TITULO
    
    public void obtener3MasCostosos(){
        Pelicula l3=catalogo.get(0);
        Pelicula l4=catalogo.get(1);
        Pelicula l5=catalogo.get(2);//mas caro
        Pelicula var;
        for (int i = 0; i < 2 ;i++) {
            if (l3.obtenerPrecioBase()*IVA_VENTAS> l4.obtenerPrecioBase()*IVA_VENTAS) {
                var=l4;
                l4=l3;
                l3=var;
            } 
            else {
                if (l4.obtenerPrecioBase()*IVA_VENTAS>l5.obtenerPrecioBase()*IVA_VENTAS) {
                    var=l5;
                    l5=l4;
                    l4=var;
                }
            }
        }
        for( int i = 3; i <catalogo.size(); i++) {
            if (catalogo.get(i).obtenerPrecioBase()*IVA_VENTAS>l5.obtenerPrecioBase()*IVA_VENTAS) {
                l3=l4;
                l4=l5;
                l5=catalogo.get(i);
            }else{
                if(catalogo.get(i).obtenerPrecioBase()*IVA_VENTAS>l4.obtenerPrecioBase()*IVA_VENTAS){
                    l3=l4;
                    l4=catalogo.get(i);
                }else{
                    if(catalogo.get(i).obtenerPrecioBase()*IVA_VENTAS>l3.obtenerPrecioBase()*IVA_VENTAS){
                        l3=catalogo.get(i);
                    }
                }
            }
        }    
        System.out.println("_____________________________________________________________");
        System.out.println("LA PELICULA  MAS COSTOSA ES: ");
        System.out.println("-Codigo: "+l5.obtenerCodigo());
        System.out.println("-La Pelicula: "+l5.obtenerTitulo());
        System.out.println("-Cantidad: "+l5.obtenerCantidadActual()+" ejemplares");
        System.out.println("-Precio Base: $"+l5.obtenerPrecioBase()+" Pesos");
        System.out.println("-Precio Venta: $"+l5.obtenerPrecioBase()*IVA_VENTAS+" Pesos");
        System.out.println("_____________________________________________________________");
        System.out.println("");
        System.out.println("LA SEGUNDA PELICULA MAS COSTOSA ES: ");
        System.out.println("-Codigo: "+l4.obtenerCodigo());
        System.out.println("-La Pelicula: "+l4.obtenerTitulo());
        System.out.println("-Cantidad: "+l4.obtenerCantidadActual()+" ejemplares");
        System.out.println("-Precio Base: $"+l4.obtenerPrecioBase()+" Pesos");
        System.out.println("-Precio Venta: $"+l4.obtenerPrecioBase()*IVA_VENTAS+" Pesos");
        System.out.println("_____________________________________________________________");
        System.out.println("");
        System.out.println("LA TERCER PELICULA MAS COSTOSA ES: ");
        System.out.println("-Codigo: "+l3.obtenerCodigo());
        System.out.println("-La Pelicula: "+l3.obtenerTitulo());
        System.out.println("-Cantidad: "+l3.obtenerCantidadActual()+" ejemplares");
        System.out.println("-Precio Base: $"+l3.obtenerPrecioBase()+" Pesos");
        System.out.println("-Precio Venta: $"+l3.obtenerPrecioBase()*IVA_VENTAS+" Pesos");
        System.out.println("_____________________________________________________________");
        System.out.println("");
    }   
    
    public void obtenerMasEconomicos(){
        Pelicula l3=catalogo.get(0);
        Pelicula l4=catalogo.get(1);
        Pelicula l5=catalogo.get(2);//mas caro
        Pelicula var;
        for (int i = 0; i < 2 ;i++) {
            if (l3.obtenerPrecioBase()*IVA_VENTAS> l4.obtenerPrecioBase()*IVA_VENTAS) {
                var=l4;
                l4=l3;
                l3=var;
            } 
            else {
                if (l4.obtenerPrecioBase()*IVA_VENTAS>l5.obtenerPrecioBase()*IVA_VENTAS) {
                    var=l5;
                    l5=l4;
                    l4=var;
                }else{            
            }
            }
        }
        for( int i = 3; i <catalogo.size(); i++) {
            if (catalogo.get(i).obtenerPrecioBase()*IVA_VENTAS<l3.obtenerPrecioBase()*IVA_VENTAS) {
                l5=l4;
                l4=l3;
                l3=catalogo.get(i);
            }else{
                if(catalogo.get(i).obtenerPrecioBase()*IVA_VENTAS<l4.obtenerPrecioBase()*IVA_VENTAS){
                    l5=l4;
                    l4=catalogo.get(i);
                }else{
                    if(catalogo.get(i).obtenerPrecioBase()*IVA_VENTAS<l5.obtenerPrecioBase()*IVA_VENTAS){
                        l5=catalogo.get(i);
                    }
                }
            }
        }    
        System.out.println("_____________________________________________________________");
        System.out.println("LA PELICULA MAS ECONOMICA ES: ");
        System.out.println("-Codigo: "+l3.obtenerCodigo());
        System.out.println("-La Pelicula: "+l3.obtenerTitulo());
        System.out.println("-Cantidad: "+l3.obtenerCantidadActual()+" ejemplares");
        System.out.println("-Precio Base: $"+l3.obtenerPrecioBase()+" Pesos");
        System.out.println("-Precio Venta: $"+l3.obtenerPrecioBase()*IVA_VENTAS+" Pesos");
        System.out.println("_____________________________________________________________");
        System.out.println("");
        System.out.println("LA SEGUNDA PELICULA MAS ECONOMICA ES: ");
        System.out.println("-Codigo: "+l4.obtenerCodigo());
        System.out.println("-La Pelicula: "+l4.obtenerTitulo());
        System.out.println("-Cantidad: "+l4.obtenerCantidadActual()+" ejemplares");
        System.out.println("-Precio Base: $"+l4.obtenerPrecioBase()+" Pesos");
        System.out.println("-Precio Venta: $"+l4.obtenerPrecioBase()*IVA_VENTAS+" Pesos");
        System.out.println("_____________________________________________________________");
        System.out.println("");
        System.out.println("LA TERCER PELICULA MAS ECONOMICA ES: ");
        System.out.println("-Codigo: "+l5.obtenerCodigo());
        System.out.println("-La Pelicula: "+l5.obtenerTitulo());
        System.out.println("-Cantidad: "+l5.obtenerCantidadActual()+" ejemplares");
        System.out.println("-Precio Base: $"+l5.obtenerPrecioBase()+" Pesos");
        System.out.println("-Precio Venta: $"+l5.obtenerPrecioBase()*IVA_VENTAS+" Pesos");
        System.out.println("_____________________________________________________________");
        System.out.println("");
    }
    
    public void MostrarCatalogo(){
        
        for (int i=0;i<catalogo.size();i++){
            System.out.println("________________________________________________");
            System.out.println(i+1+". NUMERO EN LISTA");
            System.out.println("-Codigo: "+catalogo.get(i).obtenerCodigo());
            System.out.println("-La Pelicula: "+catalogo.get(i).obtenerTitulo());
            System.out.println("-Cantidad: "+catalogo.get(i).obtenerCantidadActual()+" ejemplares");
            System.out.println("-Precio Base: $"+catalogo.get(i).obtenerPrecioBase()+" Pesos");
            System.out.println("-Precio Venta: $"+catalogo.get(i).obtenerPrecioVenta(catalogo.get(i).obtenerPrecioBase())+" Pesos");
            System.out.println();
            System.out.println("_________________________________________________");
            System.out.println();
        }
    }
    
    public void setVenta(Pelicula pelicula){
        String codigo=pelicula.obtenerCodigo();
        String titulo=pelicula.obtenerTitulo();
        double precio=pelicula.obtenerPrecioBase();
        ventas.add(new Pelicula(codigo,titulo,precio));
        
        System.out.println("");
        System.out.println("________________________________________");
        System.out.println("Haz Comprado La Pelicula : ");
        System.out.println("- Pelicula : "+pelicula.obtenerTitulo());
        System.out.println("- Codigo : "+pelicula.obtenerCodigo());
        System.out.println("_________________________________________");
        
    }
     
    public ArrayList<Pelicula> obtenerArrayVentas(){

    return ventas;
    }//retorna las el arrai de ventas ya hechas
    
    public void getVentas(){

        if (!ventas.isEmpty()) {
            for (int i = 0; i < ventas.size(); i++) {
            System.out.println("");
            System.out.println("_______________________________________________");
            System.out.println("Pelicula : "+ventas.get(i).obtenerTitulo());
            System.out.println("Con Codigo : "+ventas.get(i).obtenerCodigo());
            System.out.println("_______________________________________________");
            System.out.println("");
            }
        } else {
            System.out.println("");
            System.out.println("NO se han realizado ventas el dia de hoy");
        }
        
        
    }
    
    public void anadirPelicula(String pcodigo, String ptitulo, double pprecioBase, int cantidad) {
    	Pelicula Pelicula = new Pelicula(pcodigo,ptitulo, pprecioBase, cantidad);
    	if (catalogo.add(Pelicula)) {
    		System.out.println("_______________________________________________");
    		System.out.println("se ha agregado la Pelicula: \ncon Codigo: "+pcodigo);
    		System.out.println("Titulo: "+ptitulo);
    		System.out.println("_____________________________________________");
    	}
    }
    
}