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
public class Silla {
    
    public enum Clase {
     
        EJECUTIVA,

        
        ECONOMICA
    }

    
    public enum Ubicacion {
        
        VENTANA,

        
        CENTRAL,

       
        PASILLO
    }

    private final int numero;
    private final Clase clase;
    private final Ubicacion ubicacion;
    private pasajero pasajero;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------


     
    public Silla( int pNumero, Clase pClase, Ubicacion pUbicacion )
    {
        numero = pNumero;
        clase = pClase;
        ubicacion = pUbicacion;
        // Inicialmente no hay ningún pasajero en la silla
        pasajero = null;
    }
    
    /**
     * Asigna la silla al pasajero recibido como parámetro. <br>
     * <b>post: </b> La silla queda asignada al pasajero recibido como parámetro.
     * @param pPasajero Pasajero a asignar en la silla. pPasajero !=null.
     */
    public void asignarAPasajero( pasajero pPasajero )
    {
        
        pasajero = pPasajero;
    }

    /**
     * Desasigna la silla al pasajero. La silla queda nuevamente libre. <br>
     * <b>post: </b> La silla queda sin pasajero asignado.
     */
    public void desasignarSilla( )
    {
        pasajero = null;
    }

    /**
     * Indica si la silla está asignada.
     * @return Retorna true si la silla esta asignada, false en caso contrario.
     */
    public boolean sillaAsignada( )
    {
        boolean asignada = true;
        if( null == pasajero )
        {
            asignada = false;
        }
        return asignada;
    }

    /**
     * Indica si la silla está asignada al pasajero recibido como parámetro.
     * @param pPasajero Pasajero a comparar con el de la silla.
     * @return Retorna true si el pasajero ocupa la silla, false si la silla está vacía o no coincide con el pasajero recibido como parámetro.
     */
    
    public boolean sillaAsignadaPasajero( pasajero pPasajero )
    {
        boolean asignadaPasajero = true;
        if( null == pasajero )
        {
            asignadaPasajero = false;
        }
        else if( pasajero.igualA( pPasajero ) )
        {
            asignadaPasajero = true;
        }

        return asignadaPasajero;
    }
  
    
    public int darNumero( )
    {
        return numero;
    }
    public Clase darClase( )
    {
        return clase;
    }
    public Ubicacion darUbicacion( )
    {
        return ubicacion;
    }
    public pasajero darPasajero( )
    {
        return pasajero;
    }

    
}
