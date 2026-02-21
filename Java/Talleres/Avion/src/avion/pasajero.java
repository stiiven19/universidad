package avion;

public class pasajero {
    
    
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    private final String cedula;
    private final String nombre;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    public pasajero( String pCedula, String pNombre )
    {
        cedula = pCedula;
        nombre = pNombre;
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    public String darCedula( )
    {
        return cedula;
    }

    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Indica si el pasajero es igual a otro.
     * @param pOtroPasajero Pasajero a comparar. pOtroPasajero != null.
     * @return Retorna true si es el mismo pasajero, false en caso contrario.
     */
    public boolean igualA( pasajero pOtroPasajero )
    {
        boolean esIgual = false;
        if( cedula.equals( pOtroPasajero.darCedula( ) ) )
        {
            esIgual = true;
        }

        return esIgual;
    }

}
