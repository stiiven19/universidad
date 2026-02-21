/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CalcularTriangulo;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author lenovo
 */
public final class Menu {
    double a,b,c;
    Triangulo triangule;
            
    public Menu() {
        System.out.println("ingrese los lados de un triangulo asi: ");
        System.out.println("a /\\ c");
        System.out.println("  --");
        System.out.println("   b");
        
        a=pedir_numero("a");
        System.out.println("");
        b=pedir_numero("b");
        System.out.println("");
        c=pedir_numero("c");
        triangule = new Triangulo(a, b, c);
        System.out.println("");
        System.out.println("Tipo: "+triangule.TipoTriangulo());
        System.out.println("");
        System.out.println("Area: "+triangule.Area());
        System.out.println("");
        System.out.println("Perimetro: "+triangule.Perimetro());
    }
    
    public double pedir_numero(String str){
        Scanner leer =new Scanner(System.in);
        double numero;
        while (true) {            
            try {
                System.out.print("Ingrese lado "+str+": ");numero=leer.nextDouble();
                if (numero == 0) {
                    throw new InputMismatchException("ingrese un numero diferente de 0");
                }
                if (numero < 0) {
                    throw new InputMismatchException("ingrese un numero mayor que 0");
                }
                break;
            } catch (InputMismatchException e) {
                if (e.getMessage() == null){
                    System.err.println("Error \n"
                        + "Digite un numero");   
                leer.nextLine();
                }else{
                System.err.println("Error \n"
                        + e.getMessage());   
                leer.nextLine();
                }
            }   
        }
        return numero;
    }
    
    public static void main(String[] args) {
        new Menu();
        
        
    }
}
