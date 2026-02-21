/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avion;

/**
 *
 * @author Byron
 */
import avion.Silla.Clase;
import avion.Silla.Ubicacion;

public class Avion {
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    
    public final static int SILLAS_EJECUTIVAS = 8;

    
    public final static int SILLAS_ECONOMICAS = 42;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------


    private final Silla[] sillasEjecutivas;

   
    private final Silla[] sillasEconomicas;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el avión. <br>
     * <b>post: </b> Se inicializan las listas de sillas ejecutivas y económicas.
     */
    public Avion( )
    {
        Ubicacion ubicacion;

        // Crea las sillas ejecutivas
        sillasEjecutivas = new Silla[SILLAS_EJECUTIVAS];

        // Crea las sillas económicas
        sillasEconomicas = new Silla[SILLAS_ECONOMICAS];

        sillasEjecutivas[ 0 ] = new Silla( 1, Clase.EJECUTIVA, Ubicacion.VENTANA );
        sillasEjecutivas[ 1 ] = new Silla( 2, Clase.EJECUTIVA, Ubicacion.PASILLO );
        sillasEjecutivas[ 2 ] = new Silla( 3, Clase.EJECUTIVA, Ubicacion.PASILLO );
        sillasEjecutivas[ 3 ] = new Silla( 4, Clase.EJECUTIVA, Ubicacion.VENTANA );
        sillasEjecutivas[ 4 ] = new Silla( 5, Clase.EJECUTIVA, Ubicacion.VENTANA );
        sillasEjecutivas[ 5 ] = new Silla( 6, Clase.EJECUTIVA, Ubicacion.PASILLO );
        sillasEjecutivas[ 6 ] = new Silla( 7, Clase.EJECUTIVA, Ubicacion.PASILLO );
        sillasEjecutivas[ 7 ] = new Silla( 8, Clase.EJECUTIVA, Ubicacion.VENTANA );
        
        sillasEconomicas[ 0 ] = new Silla( 9, Clase.ECONOMICA, Ubicacion.VENTANA ); 
        sillasEconomicas[ 1 ] = new Silla( 10, Clase.ECONOMICA, Ubicacion.CENTRAL ); 
        sillasEconomicas[ 2 ] = new Silla( 11, Clase.ECONOMICA, Ubicacion.PASILLO );
        sillasEconomicas[ 3 ] = new Silla( 12, Clase.ECONOMICA, Ubicacion.PASILLO );
        sillasEconomicas[ 4 ] = new Silla( 13, Clase.ECONOMICA, Ubicacion.CENTRAL );
        sillasEconomicas[ 5 ] = new Silla( 14, Clase.ECONOMICA, Ubicacion.VENTANA );
        sillasEconomicas[ 6 ] = new Silla( 15, Clase.ECONOMICA, Ubicacion.VENTANA );
        sillasEconomicas[ 7 ] = new Silla( 16, Clase.ECONOMICA, Ubicacion.CENTRAL );
        sillasEconomicas[ 8 ] = new Silla( 17, Clase.ECONOMICA, Ubicacion.PASILLO );
        sillasEconomicas[ 9 ] = new Silla( 18, Clase.ECONOMICA, Ubicacion.PASILLO );
        sillasEconomicas[ 10 ] = new Silla( 19, Clase.ECONOMICA, Ubicacion.CENTRAL );
        sillasEconomicas[ 11 ] = new Silla( 20, Clase.ECONOMICA, Ubicacion.VENTANA );
        sillasEconomicas[ 12 ] = new Silla( 21, Clase.ECONOMICA, Ubicacion.VENTANA );
        sillasEconomicas[ 13 ] = new Silla( 22, Clase.ECONOMICA, Ubicacion.CENTRAL);
        sillasEconomicas[ 14 ] = new Silla( 23, Clase.ECONOMICA, Ubicacion.PASILLO );
        sillasEconomicas[ 15 ] = new Silla( 24, Clase.ECONOMICA, Ubicacion.PASILLO);
        sillasEconomicas[ 16 ] = new Silla( 25, Clase.ECONOMICA, Ubicacion.CENTRAL );
        sillasEconomicas[ 17 ] = new Silla( 26, Clase.ECONOMICA, Ubicacion.VENTANA );
        sillasEconomicas[ 18 ] = new Silla( 27, Clase.ECONOMICA, Ubicacion.VENTANA );
        sillasEconomicas[ 19 ] = new Silla( 28, Clase.ECONOMICA, Ubicacion.CENTRAL);
        sillasEconomicas[ 20 ] = new Silla( 29, Clase.ECONOMICA, Ubicacion.PASILLO );
        sillasEconomicas[ 21 ] = new Silla( 30, Clase.ECONOMICA, Ubicacion.PASILLO );
        sillasEconomicas[ 22 ] = new Silla( 31, Clase.ECONOMICA, Ubicacion.CENTRAL );
        sillasEconomicas[ 23 ] = new Silla( 32, Clase.ECONOMICA, Ubicacion.VENTANA );
        sillasEconomicas[ 24 ] = new Silla( 33, Clase.ECONOMICA, Ubicacion.VENTANA );
        sillasEconomicas[ 25 ] = new Silla( 34, Clase.ECONOMICA, Ubicacion.CENTRAL );
        sillasEconomicas[ 26 ] = new Silla( 35, Clase.ECONOMICA, Ubicacion.PASILLO );
        sillasEconomicas[ 27 ] = new Silla( 36, Clase.ECONOMICA, Ubicacion.PASILLO );
        sillasEconomicas[ 28 ] = new Silla( 37, Clase.ECONOMICA, Ubicacion.CENTRAL);
        sillasEconomicas[ 29 ] = new Silla( 38, Clase.ECONOMICA, Ubicacion.VENTANA );
        sillasEconomicas[ 30 ] = new Silla( 39, Clase.ECONOMICA, Ubicacion.VENTANA );
        sillasEconomicas[ 31 ] = new Silla( 40, Clase.ECONOMICA, Ubicacion.CENTRAL );
        sillasEconomicas[ 32 ] = new Silla( 41, Clase.ECONOMICA, Ubicacion.PASILLO );
        sillasEconomicas[ 33 ] = new Silla( 42, Clase.ECONOMICA, Ubicacion.PASILLO );
        sillasEconomicas[ 34 ] = new Silla( 43, Clase.ECONOMICA, Ubicacion.CENTRAL );
        sillasEconomicas[ 35 ] = new Silla( 44, Clase.ECONOMICA, Ubicacion.VENTANA );
        sillasEconomicas[ 36 ] = new Silla( 45, Clase.ECONOMICA, Ubicacion.VENTANA );
        sillasEconomicas[ 37 ] = new Silla( 46, Clase.ECONOMICA, Ubicacion.CENTRAL );
        sillasEconomicas[ 38 ] = new Silla( 47, Clase.ECONOMICA, Ubicacion.PASILLO );
        sillasEconomicas[ 39 ] = new Silla( 48, Clase.ECONOMICA, Ubicacion.PASILLO );
        sillasEconomicas[ 40 ] = new Silla( 49, Clase.ECONOMICA, Ubicacion.CENTRAL );
        sillasEconomicas[ 41 ] = new Silla( 50, Clase.ECONOMICA, Ubicacion.VENTANA);
        
        
        /*for( int numSilla = 1 + SILLAS_EJECUTIVAS, j = 1; j <= SILLAS_ECONOMICAS; numSilla++, j++ )
        {
            // Sillas ventana
            if( j % 6 == 1 || j % 6 == 0 )
                ubicacion = Ubicacion.VENTANA;
            // Sillas centrales
            else if( j % 6 == 2 || j % 6 == 5 )
                ubicacion = Ubicacion.CENTRAL;
            // Sillas pasillo
            else
                ubicacion = Ubicacion.PASILLO;

            sillasEconomicas[ j - 1 ] = new Silla( numSilla, Clase.ECONOMICA, ubicacion );
        }*/
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Asigna la silla al pasajero en la clase y ubicación especificados. <br>
     * <b>post: </b> Si existe una silla con la clase y la ubicación dada, el pasajero queda asignado en la primera de ellas según el orden numérico.
     * @param pClase Clase elegida por el pasajero. Clase pertenece {Clase.EJECUTIVA, Clase.ECONOMICA}.
     * @param pUbicacion Ubicación elegida por el pasajero. Si clase = Clase.ECONOMICA entonces ubicación pertenece {VENTANA, CENTRAL, PASILLO}, <br>
     *        o si clase = Clase.EJECUTIVA entonces ubicación pertenece {VENTANA, PASILLO}.
     * @param pPasajero Pasajero a asignar. pPasajero != null y no tiene silla en el avión.
     * @return Silla asignada al pasajero o null si no se pudo asignar una silla al pasajero en la ubicación y clase especificados.
     */
    public Silla asignarSilla( int b , Clase pClase, Ubicacion pUbicacion, pasajero pPasajero )
    {//si b=0 entonces busca normal    :  si no busca el numero que tenga
        Silla silla = null;
        if (b!=0) {
            if (pClase==Clase.EJECUTIVA) {
                silla=sillasEjecutivas[b-1];
            } else {if(pClase==Clase.ECONOMICA)
                    silla=sillasEconomicas[b-9];
            }
        }else{if (b==0) {
                if( pClase == Clase.EJECUTIVA )
                {
                    silla = buscarSillaEjecutivaLibre( pUbicacion );
                }
                else if( pClase == Clase.ECONOMICA )
                {
                    silla = buscarSillaEconomicaLibre( pUbicacion );
                }
                }
            }
        if( silla != null )
        {
            System.out.println("");
            System.out.println("______________________________________________________________");
            silla.asignarAPasajero( pPasajero );
            System.out.println("la Silla : "+silla.darNumero()+" de clase : "+pClase+" en la ubicacion : "+pUbicacion);
            System.out.println("Fue asignada al Pasajero con : ");
            System.out.println("Nombre : "+pPasajero.darNombre());
            System.out.println("Ceduda de C. : "+pPasajero.darCedula());
            System.out.println("___________________________________________________________________");
            System.out.println("");
        }else{
            System.out.println("");
            System.out.println("______________________________________________________________");
            System.out.println("la Silla : "+silla.darNumero()+" de clase : "+pClase+" en la ubicacion : "+pUbicacion);
            System.out.println("Esta Ocupada por el Pasajero : ");
            System.out.println("Nombre : "+pPasajero.darNombre());
            System.out.println("Ceduda de C. : "+pPasajero.darCedula());
            System.out.println("___________________________________________________________________");
            System.out.println("");
        }
        
        return silla;
    }

    /**
     * Busca la siguiente silla ejecutiva que este libre y tenga la ubicación indicada. <br>
     * <b>pre: </b> La lista de sillas ejecutivas está inicializada.
     * @param pUbicacion Ubicación en donde buscar la silla. pUbicación pertenece {VENTANA, PASILLO}.
     * @return La silla libre encontrada. Si no encuentra una silla retorna null.
     */
    public Silla buscarSillaEjecutivaLibre( Ubicacion pUbicacion )
    {
        boolean encontrado = false;
        Silla silla = null;
        for( int i = 0; i < SILLAS_EJECUTIVAS && !encontrado; i++ )
        {
            silla = sillasEjecutivas[ i ];
            if( ! ( silla.sillaAsignada( ) ) && silla.darUbicacion( ) == pUbicacion )
            {
                encontrado = true;
            }
        }
        if( !encontrado )
        {
            silla = null;
            System.out.println("");
            System.out.println("La silla esta ocupada");
        }
        return silla;
    }

    /**
     * Busca la siguiente silla económica que este libre y tenga la ubicación indicada. <br>
     * <b>pre: </b> La lista de sillas económicas está inicializada.
     * @param pUbicacion Ubicación en donde buscar la silla. pUbicación pertenece {VENTANA, CENTRAL, PASILLO}.
     * @return Silla libre encontrada. Si no encuentra una silla retorna null.
     */
    public Silla buscarSillaEconomicaLibre( Ubicacion pUbicacion )
    {
        boolean encontrado = false;
        Silla silla = null;
        for( int i = 0; i < SILLAS_ECONOMICAS && !encontrado; i++ )
        {
            silla = sillasEconomicas[ i ];
            if( ! ( silla.sillaAsignada( ) ) && silla.darUbicacion( ) == pUbicacion )
            {
                encontrado = true;
            }
        }
        if( !encontrado )
        {
            silla = null;
        }
        return silla;
    }

    /**
     * Busca un pasajero en el avión.
     * @param pPasajero Pasajero a buscar. pPasajero != null.
     * int b si b=0 -> busca con los dtos del pasajero si b!=0 -> busca por el numero
     * @return Silla en la que se encontró el pasajero. Si no lo encuentra retorna null.
     */
    public Silla buscarPasajero(int b,  pasajero pPasajero )
    {
        Silla silla=null;
        if (b!=0) {
            if (b<=SILLAS_EJECUTIVAS) {
                silla=sillasEjecutivas[b-1];
            } else {if(b>SILLAS_EJECUTIVAS)
                silla=sillasEconomicas[b-9];
            }
        }else{
            if (b==0) {
                // Busca el pasajero en ejecutiva
                silla = buscarPasajeroEjecutivo( pPasajero );
                // Si no estaba en ejecutiva
                if( null == silla )
                {
                    // Busca en económica
                    silla = buscarPasajeroEconomico( pPasajero );
                }
            }
        }
        return silla;
    }

    /**
     * Busca un pasajero en las sillas ejecutivas. <br>
     * <b>pre: </b> La lista de sillas ejecutivas está inicializada.
     * @param pPasajero Pasajero a buscar. pPasajero != null.
     * @return Silla en la que se encontró el pasajero. Si no lo encuentra retorna null.
     */
    public Silla buscarPasajeroEjecutivo( pasajero pPasajero )
    {
        boolean encontrado = false;
        Silla silla = null;
        for( int i = 0; i < SILLAS_EJECUTIVAS && !encontrado; i++ )
        {
            silla = sillasEjecutivas[ i ];
            if( silla.sillaAsignada( ) && silla.darPasajero( ).igualA( pPasajero ) )
            {
                encontrado = true;
            }
        }
        if( !encontrado )
        {
            silla = null;
        }
        return silla;
    }

    /**
     * Busca un pasajero en las sillas económicas. <br>
     * <b>pre: </b> La lista de sillas económicas está inicializada.
     * @param pPasajero Pasajero a buscar. pPasajero != null.
     * @return Silla en la que se encontró el pasajero. Si no lo encuentra retorna null.
     */
    public Silla buscarPasajeroEconomico( pasajero pPasajero )
    {
        boolean encontrado = false;
        Silla silla = null;
        for( int i = 0; i < SILLAS_ECONOMICAS && !encontrado; i++ )
        {
            silla = sillasEconomicas[ i ];
            if( silla.sillaAsignada( ) && silla.darPasajero( ).igualA( pPasajero ) )
            {
                encontrado = true;
            }
        }
        if( !encontrado )
        {
            silla = null;
        }
        return silla;
    }

    /**
     * Desasigna la silla de un pasajero. <br>
     * <b>post: </b> Si se encuentra una silla con el pasajero, la silla quedara con su pasajero igual a null.
     * @param pPasajero Pasajero a retirar. pPasajero != null.
     * @return Retorna true si encontró el pasajero y des asignó la silla, false en caso contrario.
     */
    public boolean desasignarSilla( pasajero pPasajero )
    {
        // Busca el pasajero en el avión
        Silla silla = buscarPasajero( 0, pPasajero );
        boolean resultado = false;
        // Si lo encuentra desasigna
        if( silla != null )
        {
            System.out.println("");
            System.out.println("________________________________________________");
            System.out.println("La Silla : "+silla.darNumero());
            System.out.println("Asignada al pasajero : "+silla.darPasajero().darNombre());
            System.out.println("Con Cedula de C : "+silla.darPasajero().darCedula());
            System.out.println("Ha Sido Desasignada satisfactoriamente ");
            System.out.println("_________________________________________________");
            System.out.println("");
            
            silla.desasignarSilla( );
            resultado = true;
        }
        return resultado;
    }

    /**
     * Retorna el número de sillas ejecutivas ocupadas. <br>
     * <b>pre: </b> La lista de sillas ejecutivas está inicializada.
     * @return Número de silla ejecutivas ocupadas.
     */
    public int contarSillasEjecutivasOcupadas( )
    {
        int contador = 0;
        for( Silla sillaEjecutiva : sillasEjecutivas )
        {
            if( sillaEjecutiva.sillaAsignada( ) )
            {
                contador++;
            }
        }
        return contador;
    }

    /**
     * Retorna el número de sillas económicas ocupadas. <br>
     * <b>pre: </b> La lista de sillas económicas está inicializada.
     * @return Número de sillas económicas ocupadas.
     */
    public int contarSillasEconomicasOcupadas( )
    {
        int contador = 0;
        for( Silla sillaEconomica : sillasEconomicas )
        {
            if( sillaEconomica.sillaAsignada( ) )
            {
                contador++;
            }
        }
        return contador;
    }

    /**
     * Calcula el porcentaje de ocupación del avión.
     * @return Porcentaje total de ocupación.
     */
    public double calcularPorcentajeOcupacion( )
    {
        double porcentaje;
        int totalSillas = SILLAS_ECONOMICAS + SILLAS_EJECUTIVAS;
        int sillasOcupadas = contarSillasEconomicasOcupadas( ) + contarSillasEjecutivasOcupadas( );
        porcentaje = ( double )sillasOcupadas / totalSillas * 100;
        return porcentaje;
    }

    /**
     * Retorna las sillas ejecutivas del avión.
     * @return Sillas ejecutivas del avión.
     */
    public Silla[] obtenerSillasEjecutivas( )
    {
        return sillasEjecutivas;
    }

    /**
     * Retorna las sillas económicas del avión.
     * @return Sillas económicas del avión.
     */
    public Silla[] obtenerSillasEconomicas( )
    {
        return sillasEconomicas;
    }

    /**Metodo para la disponibilidad de un numero de silla especifico
     * 
     * @param numero
     * @return disponibilidad 0false =1desocupada true ocupada 3 > 50
     */
    public int obtenerDisponibilidadSillaN(int numero){
        boolean disponibilidad=false;   
        int dispon=3;
        if (numero-1<sillasEjecutivas.length) {
            Silla silla=sillasEjecutivas[numero-1];
            disponibilidad=silla.sillaAsignada();
            
            }else{
                if (numero-9<=sillasEconomicas.length) {
                    
                    Silla silla=sillasEconomicas[numero-9];
                    disponibilidad=silla.sillaAsignada();
                    
                }else{
                    System.out.println("");
                    System.out.println("el numero : "+numero+" que ingreso no es valido");
                    System.out.println("hay 50 sillas en el avion");
                    System.out.println("");
                }
            }
        if (disponibilidad==false) {
            dispon= 0;
        }else{
            dispon= 1;
        }
        if(numero>50){
            dispon=3;
        }
        
    return dispon;
    }
    
    /**metodo para la caantidad de ejecutivas libres
     * 
     * @return 
     */
    public int obtenerEjecutivasLibres(){
        int cont=0;
        
        for (int i = 1; i<=sillasEjecutivas.length; i++) {
            int dispo=obtenerDisponibilidadSillaN(i);
            
            if (dispo==0) {
                cont++;
            }
        }
        return cont;
    }
            
    /** Metodo para la cantidad de economicas libres
     * 
     * @return int cont
     */
    public int obtenerEconomicasLibres(){
        int cont=0;
        
        for (int i = 9; i<=50; i++) {
            //ystem.out.println("secono "+sillasEconomicas.length);
            //System.out.println("sejecu "+sillasEjecutivas.length);
            int dispo=obtenerDisponibilidadSillaN(i);
            if (dispo==0) {
                cont++;
            }
        }
        return cont;
    }
    
    public Ubicacion obtenerUbicaciondeN(int num){
        Ubicacion ubicacion;
        if (num<=8) {
            ubicacion=sillasEjecutivas[num-1].darUbicacion();
            
        } else {
            ubicacion=sillasEconomicas[num-9].darUbicacion();
        }
        
        return ubicacion;
        
        
    }
    
    public int obtenerUbicacionEjeVentanaLibres(){
            int cont=0;
            for (int i = 0; i < sillasEjecutivas.length; i++) {
                if (sillasEjecutivas[i].darUbicacion()==Ubicacion.VENTANA) {
                    if (sillasEjecutivas[i].sillaAsignada()==false) {
                        cont++;
                    }
                }
        }
            return cont;
    }
    
    public int obtenerUbicacionEjePasilloLibres(){
            int cont=0;
            for (int i = 0; i < sillasEjecutivas.length; i++) {
                if (sillasEjecutivas[i].darUbicacion()==Ubicacion.PASILLO) {
                    if (sillasEjecutivas[i].sillaAsignada()==false) {
                        cont++;
                    }
                }
            }
            return cont;
    }
    
    public int obtenerUbicacionEcoVentanaLibres(){
        int cont=0;
        for (int i = 0; i < sillasEconomicas.length; i++) {
                if (sillasEconomicas[i].darUbicacion()==Ubicacion.VENTANA) {
                    if (sillasEconomicas[i].sillaAsignada()==false) {
                        cont++;
                    }
                }
            }
        return cont;
    }
    
    public int obtenerUbicacionEcoCentralLibres(){
        int cont=0;
        for (int i = 0; i < sillasEconomicas.length; i++) {
                if (sillasEconomicas[i].darUbicacion()==Ubicacion.CENTRAL) {
                    if (sillasEconomicas[i].sillaAsignada()==false) {
                        cont++;
                    }
                }
            }
        return cont;
    }
    
    public int obtenerUbicacionEcoPasilloLibres(){
        int cont=0;
        for (int i = 0; i < sillasEconomicas.length; i++) {
                if (sillasEconomicas[i].darUbicacion()==Ubicacion.PASILLO) {
                    if (sillasEconomicas[i].sillaAsignada()==false) {
                        cont++;
                    }
                }
            }
        return cont;
    }
}   


    /**
     * Método para la extensión 1.
     * @return Respuesta 1.
     */
    /*public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * Método para la extensión 2.
     * @return Respuesta 2.
     
    public String metodo2( )
    {
        return "Respuesta 2";
    }
    */