/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaque4caballos;

import java.util.ArrayList;


public class Estado {
    private Caballo C1;
    private Caballo C2;
    private Caballo C3;
    private Caballo C4;
    private Rey     R;
    private int Valor_Estado;
    private int profundidad;
    private  ArrayList<Caballo> Caballos;
    private  Estado EstadoAntecesor;
    

    public Estado( ArrayList<Caballo> caballos, Rey R, int Valor_Estado, int profundidad, Estado EstadoAntecesor) {
        this.Caballos=caballos;
        this.C1 = caballos.get(0);
        this.C2 = caballos.get(1);
        this.C3 = caballos.get(2);
        this.C4 = caballos.get(3);
        this.R = R;
        this.Valor_Estado = Valor_Estado;
        this.profundidad = profundidad;
        this.EstadoAntecesor = EstadoAntecesor;
    }

    public Estado getEstadoAntecesor() {
        return EstadoAntecesor;
    }
    
    public void setValor_Estado(int Valor_Estado) {
        this.Valor_Estado = Valor_Estado;
    }

    public void setProfundidad(int profundidad) {
        this.profundidad = profundidad;
    }

    public Rey getR() {
        return R;
    }

    public ArrayList<Caballo> getCaballos() {
        return Caballos;
    }
    public Estado() {
    }

    public int getValor_Estado() {
        return Valor_Estado;
    }

    public int getProfundidad() {
        return profundidad;
    }
}
