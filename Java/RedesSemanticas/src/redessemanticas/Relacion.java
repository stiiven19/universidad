/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package redessemanticas;

import java.io.Serializable;


public class Relacion implements Serializable{
    private Nodo destino;
    private String nombreRelacion;

    public Relacion(Nodo destino, String nombreRelacion) {
        this.destino = destino;
        this.nombreRelacion = nombreRelacion;
        if(nombreRelacion.equals("")){
            this.nombreRelacion="a";
        }
        
    }

    public Nodo getDestino() {
        return destino;
    }

    public String getNombreRelacion() {
        return nombreRelacion;
    }
}
