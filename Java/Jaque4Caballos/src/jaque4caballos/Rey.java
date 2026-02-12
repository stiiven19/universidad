/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaque4caballos;

/**
 *
 * @author andre
 */
public class Rey {
    private static final String nombre="R ";
    private int posicionInicial_X;
    private int posicionInicial_Y;

    public Rey(int posicionInicial_x, int posicionInicial_y) {
        this.posicionInicial_X = posicionInicial_x;
        this.posicionInicial_Y = posicionInicial_y;
    }

    public int getPosicionInicial_X() {
        return posicionInicial_X;
    }
    public int getPosicionInicial_Y() {
        return posicionInicial_Y;
    }
    public static String getNombre() {
        return nombre;
    }
}

//private static String rellenarCadena(String cadena, int longitudDeseada) {
//        if (cadena.length() > longitudDeseada) {
//            return cadena.substring(0, longitudDeseada);
//        } else {
//            return String.format("%-" + longitudDeseada + "s", cadena);
//        }
//    }
