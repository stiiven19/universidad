/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaque4caballos;

/**
 *
 * @author andre
 */
public abstract class Ficha {
    
    private  int posicionInicial_X;
    private  int posicionInicial_Y;
    public abstract void movimiento();
    public Ficha(int posicionInicial_X, int posicionInicial_Y) {
        this.posicionInicial_X = posicionInicial_X;
        this.posicionInicial_Y = posicionInicial_Y;
    }
    public int getPosicionInicial_X() {
        return posicionInicial_X;
    }
    public int getPosicionInicial_Y() {
        return posicionInicial_Y;
    }
    
}
//ArrayList<int[]> caballos = new ArrayList<>();
//
//        Scanner scanner = new Scanner(System.in);
//
//        // Solicitar las posiciones de los cuatro caballos
//        for (int i = 0; i < 4; i++) {
//            System.out.println("Ingrese la posición del caballo " + (i + 1) + ":");
//            System.out.print("Fila: ");
//            int fila = scanner.nextInt();
//            System.out.print("Columna: ");
//            int columna = scanner.nextInt();
//
//            int[] posicion = {fila, columna};
//            caballos.add(posicion);
//        }