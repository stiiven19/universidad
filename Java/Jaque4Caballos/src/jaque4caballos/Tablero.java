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
public class Tablero {
    private  Caballo C1;
    private  Caballo C2;
    private  Caballo C3;
    private  Caballo C4;
    private  Rey     R; 
    private  String[][] variablesFichas;
    private ArrayList<Caballo> Caballos;
//    private ArrayList ventas;
    
    

    public Tablero(ArrayList<Caballo> caballos,Rey R) {
        this.C1 = caballos.get(0);
        this.C2 = caballos.get(1);
        this.C3 = caballos.get(2);
        this.C4 = caballos.get(3);
        this.R = R;
        Caballos = new ArrayList();
        Caballos.add(C1);
        Caballos.add(C2);
        Caballos.add(C3);
        Caballos.add(C4);
//        ventas = new ArrayList();
//        ventas.add(1);
//        ventas.add(2);
//        ventas.add(3);
//        ventas.add(4);
//        ventas.add(5);
//        ventas.add(6);
//        for (int i = 0; i < ventas.size(); i++) {
//            System.out.println("ventas en el indice : " + i + " y tiene: " + ventas.get(i));
//            
//        }
//        ventas.add(0, 10);
//        ventas.add(2, 10);
//        for (int i = 0; i < ventas.size(); i++) {
//            System.out.println("ventas en el indice : " + i + " y tiene: " + ventas.get(i));
//            
//        }
        
        imprimirTablero();
        
    }
    
   
    public  void imprimirTablero() {
        variablesFichas = new String [][]{
                {"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "},
                {"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "},
                {"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "},
                {"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "},
                {"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "},
                {"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "},
                {"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "},
                {"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "}
        };
        //char[] letras = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

        // Imprimir números de columna
        System.out.print("  ");
        for (int columna = 0; columna < 8; columna++) {
            System.out.print("  " + (columna + 1) + "  ");//imprime numeros columna
            if (columna < 7) {
                System.out.print("|");
            }
        }
        System.out.println();

        // Imprimir separador inicial de filas para ---+---+---
        System.out.print("  ");
        
        // imprime ---++---
        for (int columna = 0; columna < 8; columna++) {
            System.out.print("-----");
            if (columna < 7) {
                System.out.print("+");
            }
        }
        System.out.println();
        //pone posiciones
        for (int i = 0; i < 4; i++) {
            Caballo C=Caballos.get(i);
            variablesFichas[C.getPosicionInicial_X()-1][C.getPosicionInicial_Y()-1]=""+C.getNombre();   
        }
        variablesFichas[R.getPosicionInicial_X()-1][R.getPosicionInicial_Y()-1]=""+R.getNombre();
        
        // Imprimir filas y variables de fichas
        int cont=8;
        for (int fila = 0; fila < 8; fila+=1) {
            System.out.print(" " + (fila+1) + "");
            for (int columna = 0; columna < 8; columna++) {
                //System.out.println("fila: "+fila);
                
                
                String variableFicha = variablesFichas[fila][columna];
                
                System.out.print("  " + variableFicha + " "); // Variable de ficha
                
                if (columna < 7) {
                    System.out.print("|");
                }
            }
            System.out.println(" ");

            // Imprimir separador de filas
            System.out.print("  ");
            for (int columna = 0; columna < 8; columna++) {
                System.out.print("-----");
                if (columna < 7) {
                    System.out.print("+");
                }
            }
            System.out.println();
            cont--;
        }

    }

    public void setCaballos(ArrayList<Caballo> Caballos) {
        this.Caballos = Caballos;
        this.imprimirTablero();
    }

    

    

    public static String GetFuncionHeuristica() {
        
            

        return "";
    }
}