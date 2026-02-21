/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CalcularTriangulo;

import java.awt.geom.Area;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author lenovo
 */
public class Triangulo {
        double lado_A, lado_B, lado_C;
        String tipo;

    public Triangulo(double lado_A, double lado_B, double lado_C) {
        this.lado_A = lado_A;
        this.lado_B = lado_B;
        this.lado_C = lado_C;
    }
          
    public String TipoTriangulo(){
        tipo =  "invalido";
        if (lado_A==lado_B && lado_B==lado_C ){
            tipo = "Equilatero";
        }else{
            if((lado_A==lado_C && lado_C != lado_B) || (lado_A==lado_B && lado_B != lado_C)|| (lado_B==lado_C && lado_B != lado_A)){
                tipo = "Isoceles";
            }else{
                if(lado_A != lado_B && lado_A  != lado_C && lado_B != lado_C){
                    tipo = "Escaleno";
                }
            }
        }
        return tipo;
    }
    
    public double Area(){
        double area = 0;
        double h;
        if ("Escaleno".equals(tipo)){
            double s = (lado_A+lado_B+lado_C)/2;
            area = Math.sqrt(s*(s-lado_C)*(s-lado_B)*(s-lado_A));
        }else{
            h=Math.sqrt(Math.pow(lado_A, 2) - Math.pow(lado_B/2, 2));
            area = (lado_B*h)/2;
        }
        area = Math.round(area * 100);
        area = area/100;
        return area;
    }
    
    public double Perimetro(){
        double perimetro = lado_A+lado_B+lado_C;
        perimetro = Math.round(perimetro * 100);
        perimetro = perimetro/100;
        return perimetro;
    }
}
