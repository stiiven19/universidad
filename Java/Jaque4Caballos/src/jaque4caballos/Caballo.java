/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaque4caballos;

import java.util.ArrayList;

/**
 *
 * @author andre
 */
public class Caballo {
    
    private final String nombre;
    private int posicionInicial_X;
    private int posicionInicial_Y;
    private boolean move=true;
    private final ArrayList<Caballo> movimientosAnteriores =new ArrayList();
    private final ArrayList<Caballo> movimientosPosibles =new ArrayList();

    public void setPosicionInicial_X(int posicionInicial_X) {
        this.posicionInicial_X = posicionInicial_X;
    }

    public void setPosicionInicial_Y(int posicionInicial_Y) {
        this.posicionInicial_Y = posicionInicial_Y;
    }
    

    public Caballo(int posicionInicial_x, int posicionInicial_y, String nombre) {
        this.nombre = nombre;
        this.posicionInicial_X = posicionInicial_x;
        this.posicionInicial_Y = posicionInicial_y;
    }

    public int getPosicionInicial_X() {
        return posicionInicial_X;
    }
    public int getPosicionInicial_Y() {
        return posicionInicial_Y;
    }

    public ArrayList<Caballo> getMovimientosAnteriores() {
        return movimientosAnteriores;
    }

    public ArrayList<Caballo> getMovimientosPosibles() {
        return movimientosPosibles;
    }

    public String getNombre() {
        return nombre;
    }
    public boolean getMove(){
        return move;
    }
    public void setMove(boolean move2){
        move=move2;
    }
    
}
