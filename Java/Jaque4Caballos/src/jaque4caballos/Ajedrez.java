/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jaque4caballos;

import Interface.IngresarDatos;
import Interface.TableroGrafico;
import java.awt.Point;
import java.util.ArrayList;


/**
 *
 * @author andre
 */
public final class Ajedrez {

    
/**
     * @param args the command line arguments
     */
    int g=0;//profundidad
    int fh;//funcion heuristica
    int h=0;
    private ArrayList<Estado> Estados;
    private ArrayList<Estado> abiertos;
    private ArrayList<Estado> cerrados;
    private ArrayList<Caballo> Caballos;
    private Tablero tabler;
    private Estado EstadoActual;
    private Estado estadoinicial;
    private ArrayList<Point> objetivos;
    private ArrayList<Point> PuntajePos;
    private ArrayList PuntajeCaballo;
    
    public Ajedrez(Caballo C1, Caballo C2, Caballo C3, Caballo C4, Rey R) {
        
        
        Caballos = new ArrayList();
        Caballos.add(C1);
        Caballos.add(C2);
        Caballos.add(C3);
        Caballos.add(C4);
         
        
        
        Estados = new ArrayList();
        abiertos = new ArrayList();
        cerrados = new ArrayList();
        objetivos = new ArrayList();
        PuntajePos=new ArrayList();
        estadoinicial = new Estado(Caballos,R,GetFuncionHeuristica(Caballos,R, 0), g,null);
        EstadoActual = estadoinicial;
        
        Estados.add(estadoinicial);
        
        
        tabler = new Tablero (Caballos,R);
        PuntajePos = new ArrayList();
        PuntajeCaballo = new ArrayList();
        abiertos.add(EstadoActual);
        
        
        realizarEjercicio(R);


//        CrearEstadosSucesores(EstadoActual);
//        CrearEstadosSucesores(EstadoActual);
//        CrearEstadosSucesores(EstadoActual);
//        CrearEstadosSucesores(EstadoActual);
//        CrearEstadosSucesores(EstadoActual);
//        CrearEstadosSucesores(EstadoActual);
//        CrearEstadosSucesores(EstadoActual);
//////////        
//        CrearEstadosSucesores(EstadoActual);
////////        
//        CrearEstadosSucesores(EstadoActual);
//        CrearEstadosSucesores(EstadoActual);//
//        CrearEstadosSucesores(EstadoActual);
//        CrearEstadosSucesores(EstadoActual);
//        CrearEstadosSucesores(EstadoActual);
////        
//        CrearEstadosSucesores(EstadoActual);
        
//        CrearEstadosSucesores(EstadoActual);
//        CrearEstadosSucesores(EstadoActual);
//        CrearEstadosSucesores(EstadoActual);
//        CrearEstadosSucesores(EstadoActual);
//        CrearEstadosSucesores(EstadoActual);
//        CrearEstadosSucesores(EstadoActual);
//        CrearEstadosSucesores(EstadoActual);
//        CrearEstadosSucesores(EstadoActual);
//        CrearEstadosSucesores(EstadoActual);
//        CrearEstadosSucesores(EstadoActual);
//        CrearEstadosSucesores(EstadoActual);
//        CrearEstadosSucesores(EstadoActual);
//        CrearEstadosSucesores(EstadoActual);
//        CrearEstadosSucesores(EstadoActual);
//        CrearEstadosSucesores(EstadoActual);
//        CrearEstadosSucesores(EstadoActual);

 
//        tabler.setCaballos(EstadoActual.getCaballos());
//        System.out.println(".valor heuristico: "+EstadoActual.getValor_Estado());
//        //System.out.println("profundidad EA: " + EstadoActual.getProfundidad());
//        System.out.println("Caballo 1: " + Math.abs(EstadoActual.getR().getPosicionInicial_X()-(EstadoActual.getCaballos().get(0).getPosicionInicial_X())) + " , " + Math.abs(EstadoActual.getR().getPosicionInicial_Y()-(EstadoActual.getCaballos().get(0).getPosicionInicial_Y())));
//        System.out.println("Caballo 1: " + Math.abs(EstadoActual.getR().getPosicionInicial_X()-(EstadoActual.getCaballos().get(1).getPosicionInicial_X())) + " , " + Math.abs(EstadoActual.getR().getPosicionInicial_Y()-(EstadoActual.getCaballos().get(1).getPosicionInicial_Y())));
//        System.out.println("Caballo 1: " + Math.abs(EstadoActual.getR().getPosicionInicial_X()-(EstadoActual.getCaballos().get(2).getPosicionInicial_X())) + " , " + Math.abs(EstadoActual.getR().getPosicionInicial_Y()-(EstadoActual.getCaballos().get(2).getPosicionInicial_Y())));
//        System.out.println("Caballo 1: " + Math.abs(EstadoActual.getR().getPosicionInicial_X()-(EstadoActual.getCaballos().get(3).getPosicionInicial_X())) + " , " + Math.abs(EstadoActual.getR().getPosicionInicial_Y()-(EstadoActual.getCaballos().get(3).getPosicionInicial_Y())));
//        int totalx= Math.abs(EstadoActual.getR().getPosicionInicial_X()-(EstadoActual.getCaballos().get(0).getPosicionInicial_X()))+
//                    Math.abs(EstadoActual.getR().getPosicionInicial_X()-(EstadoActual.getCaballos().get(1).getPosicionInicial_X()))+
//                    Math.abs(EstadoActual.getR().getPosicionInicial_X()-(EstadoActual.getCaballos().get(2).getPosicionInicial_X()))+
//                    Math.abs(EstadoActual.getR().getPosicionInicial_X()-(EstadoActual.getCaballos().get(3).getPosicionInicial_X()));
//        int totaly= Math.abs(EstadoActual.getR().getPosicionInicial_Y()-(EstadoActual.getCaballos().get(0).getPosicionInicial_Y()))+
//                    Math.abs(EstadoActual.getR().getPosicionInicial_Y()-(EstadoActual.getCaballos().get(1).getPosicionInicial_Y()))+
//                    Math.abs(EstadoActual.getR().getPosicionInicial_Y()-(EstadoActual.getCaballos().get(2).getPosicionInicial_Y()))+
//                    Math.abs(EstadoActual.getR().getPosicionInicial_Y()-(EstadoActual.getCaballos().get(3).getPosicionInicial_Y()));
        //System.out.println("total=: -" + (totalx) + " , " +(totaly));    
        //System.out.println("objetivos: " + objetivos.size()*20);
        //System.out.println("profundidad: " + EstadoActual.getProfundidad());
        //System.out.println("total: " + (objetivos.size()*20-totalx-totaly+EstadoActual.getProfundidad()));
        //System.out.println("");
//        for (int i = 0; i < PuntajePos.size(); i++) {
//            //System.out.println("puntuaciones : "+PuntajePos.get(i).x);
//            //System.out.println("puntuaciones : "+PuntajePos.get(i).y);
//        }
//        for (int i = 0; i < 4; i++) {
//            //System.out.println("caballos: "+ Caballos.get(i).getMove());
//        }
//        for (int j = 0; j < PuntajeCaballo.size(); j++) {
////                    System.out.println("recorriendo abiertos ;es "+abiertos.get(j).getValor_Estado());
////                    abiertos.get(j).setValor_Estado(abiertos.get(j).getValor_Estado()+10);
////                    System.out.println("recorriendo abiertos ;es "+abiertos.get(j).getValor_Estado());
////                    System.out.println("recorriendo abiertos ;x "+PuntajePos.get(j).x);
////                    System.out.println("recorriendo abiertos ;y "+PuntajePos.get(j).y);
//                    System.out.println("recorriendo abiertos ;i "+PuntajeCaballo.get(j));
//                }
////        
        
        //        int contador=0;

//        while (EstadoActual.getValor_Estado() < 190) {            
//            CrearEstadosSucesores(EstadoActual);
//            System.out.println("profundidad EA: " + EstadoActual.getProfundidad());
//            tabler.setCaballos(EstadoActual.getCaballos());
//            System.out.println("");
//            System.out.println("contador: " + contador);
//            contador++;
//        }
//        CrearEstadosSucesores(EstadoActual);
////        System.out.println("profundidad EA: " + EstadoActual.getProfundidad());
////        tabler.setCaballos(EstadoActual.getCaballos());
//        CrearEstadosSucesores(EstadoActual);
////        System.out.println("profundidad EA: " + EstadoActual.getProfundidad());
////        tabler.setCaballos(EstadoActual.getCaballos());
//        CrearEstadosSucesores(EstadoActual);
////        System.out.println("profundidad EA: " + EstadoActual.getProfundidad());
////        tabler.setCaballos(EstadoActual.getCaballos());
//        CrearEstadosSucesores(EstadoActual);
////        System.out.println("profundidad EA: " + EstadoActual.getProfundidad());
////        //tabler.setCaballos(EstadoActual.getCaballos());
//        CrearEstadosSucesores(EstadoActual);
////        System.out.println("profundidad EA: " + EstadoActual.getProfundidad());
////        //tabler.setCaballos(EstadoActual.getCaballos());
//        CrearEstadosSucesores(EstadoActual);
////        System.out.println("profundidad EA: " + EstadoActual.getProfundidad());
////        //tabler.setCaballos(EstadoActual.getCaballos());
//        CrearEstadosSucesores(EstadoActual);
//        System.out.println("profundidad EA: " + EstadoActual.getProfundidad());
//        //tabler.setCaballos(EstadoActual.getCaballos());
//        CrearEstadosSucesores(EstadoActual);
//        System.out.println("profundidad EA: " + EstadoActual.getProfundidad());
        

//        //tabler.setCaballos(EstadoActual.getCaballos());
        
        
//        
        
        //System.out.println("");
//        CrearEstadosSucesores(EstadoActual);
//        for (int i = 0; i < 2; i++) {
//            tabler.setCaballos(abiertos.get(abiertos.size()-1).getCaballos());
//            
//            System.out.println("valor"+abiertos.get(abiertos.size()-1).getValor_Estado());
//            CrearEstadosSucesores(EstadoActual);
//            
//        }
//        
        //int m=17;
//        tabler.setCaballos(abiertos.get(abiertos.size()-1).getCaballos());
        
//        System.out.println("valor"+abiertos.get(m).Valor_Estado);
//        CrearEstadosSucesores(abiertos.get(abiertos.size()-1));
//        tabler.setCaballos(abiertos.get(abiertos.size()-1).getCaballos());
//        tabler.imprimirTablero();
        
        //tabler.setCaballos(abiertos.get(abiertos.size()-1).getCaballos());
        
        
        //System.out.println("abiertos size: " + abiertos.size());
//        
        
    }
    
    private int GetFuncionHeuristica(ArrayList<Caballo> Caballos1, Rey R1, int profundidad) {
        fh=0;
        h=0;
//        int RestaFila=0;
//        int RestaColumna=0;
        objetivos.clear();
        int Rey_X = R1.getPosicionInicial_X();
        int Rey_Y = R1.getPosicionInicial_Y();
        ArrayList<Point> libres = new ArrayList();
        libres.add(new Point(Rey_X-1,Rey_Y-1));
        
        libres.add(new Point(Rey_X-1,Rey_Y+1));
        libres.add(new Point(Rey_X,Rey_Y-1));
        
        libres.add(new Point(Rey_X,Rey_Y+1));
        libres.add(new Point(Rey_X+1,Rey_Y-1));
        libres.add(new Point(Rey_X+1,Rey_Y));
        libres.add(new Point(Rey_X+1,Rey_Y+1));
        libres.add(new Point(Rey_X,Rey_Y));
        libres.add(new Point(Rey_X-1,Rey_Y));
        
        
        for (int i = (libres.size()-1); i > 0; i--) {
            
            if (libres.get(i).x <1 || libres.get(i).x >8 || libres.get(i).y <1 || libres.get(i).y > 8) {
//                System.out.println("removido: " + libres.get(i).x + " y " + libres.get(i).y);
                libres.remove(i);
                

            }
        }
//        for (int g = 0; g < libres.size(); g++) {
//                                System.out.println("libres arreglo: "+ libres.get(g).x +" , "+libres.get(g).y);
//                            }
        
        if (( (Rey_X == 8 && Rey_Y == 1)  || (Rey_X == 1 && Rey_Y == 1) || (Rey_X == 8 && Rey_Y == 8) || (Rey_X == 1 && Rey_Y == 8) )) {
            int i=0;
            while(libres.size()>4){
                
//                System.out.println("esquina");
                if (libres.get(i).x <1 || libres.get(i).x >8 || libres.get(i).y <1 || libres.get(i).y > 8) {
//                    System.out.println("removido: " + libres.get(i).x + " y " + libres.get(i).y);
                    libres.remove(i);


                }
            i++;
        }
        }

        for (int i = 0; i < 4; i++) {
            //System.out.println(Caballos1.get(i).getNombre());
            int posI_CX = Caballos1.get(i).getPosicionInicial_X();
            int posI_CY = Caballos1.get(i).getPosicionInicial_Y();
            int RestaFila = Math.abs(Rey_X-posI_CX);
            int RestaColumna = Math.abs(Rey_Y-posI_CY);
            h-=RestaFila;
            h-=RestaColumna;
            //Validacion Hacke
//            if( (RestaFila == 2 && RestaColumna == 1 ) || 
//                (RestaFila == 1 && RestaColumna == 2 ) )
//            {
//                h+=100;
//                System.out.println("Hacke------------------------------------------------------------");
//            }

            //validacion Alrededor Rey
            
            if( Rey_X-1 == posI_CX && Rey_Y == posI_CY  )
            {
                h-=20;
                //System.out.println("Caballo Puede Morir------------------------------------------------------------");
            } 
            
            if( Rey_X+1 == posI_CX && Rey_Y == posI_CY )
            {
                h-=20;
                //System.out.println("Caballo Puede Morir------------------------------------------------------------");
            }
            if( Rey_X == posI_CX && Rey_Y-1 == posI_CY )
            {
                h-=20;
                //System.out.println("Caballo Puede Morir------------------------------------------------------------");
            }
            if( Rey_X == posI_CX && Rey_Y+1 == posI_CY )
            {
                h-=20;
                //System.out.println("Caballo Puede Morir------------------------------------------------------------");
            }
            if( Rey_X-1 == posI_CX && Rey_Y-1 == posI_CY )
            {
                h-=20;
                //System.out.println("Caballo Puede Morir------------------------------------------------------------");
            }
            if( Rey_X-1 == posI_CX && Rey_Y+1 == posI_CY )
            {
                h-=20;
                //System.out.println("Caballo Puede Morir------------------------------------------------------------");
            }
            if( Rey_X+1 == posI_CX && Rey_Y-1 == posI_CY )
            {
                h-=20;
//                System.out.println("Caballo Puede Morir------------------------------------------------------------");
            }
            if( Rey_X+1 == posI_CX && Rey_Y+1 == posI_CY )
            {
                h-=20;
//                System.out.println("Caballo Puede Morir------------------------------------------------------------");
            }
            if( Rey_X == posI_CX && Rey_Y == posI_CY )
            {
                h-=20;
//                System.out.println("Caballo Puede Morir------------------------------------------------------------");
            }
//            System.out.println("Caballo " + (i+1) + " : " + RestaFila + ", " + RestaColumna + " = " + (RestaColumna+RestaFila));
            

            // validaciones para las posiciones objetivo
            if(Rey_Y==1 && (Rey_X>=1 && Rey_X<=8)){// validacion para el rey en la parte izquierda
                //h+=VerificarPosisinesObjetivo(RestaFila,RestaColumna);
//                if( ((Math.abs(Rey_X-posI_CX) == 2 && Math.abs(Rey_Y-posI_CY) == 1 ) || 
//                (Math.abs(Rey_X-posI_CX) == 1 && Math.abs(Rey_Y-posI_CY) == 2 )) &&
//                ((Math.abs(Rey_X-1-posI_CX) == 2 && Math.abs(Rey_Y+1-posI_CY) == 1 ) || 
//                (Math.abs(Rey_X-1-posI_CX) == 1 && Math.abs(Rey_Y+1-posI_CY) == 2 )) )
//                {// este if quiere decir que las posiciones objetivo especificadas alguien les esta dando hacke a las 2
//                    //System.out.println("............................................................................................................................");
//                    //System.out.println("Hacke------------------------------------------------------------");
//                    //System.out.println("objetivos: " + objetivos.size());
//                    boolean ocupadas=true;
//                    for (int j = 0; j < objetivos.size(); j++) {
//                        if ( (Rey_X-1 == objetivos.get(j).x && Rey_Y+1 == objetivos.get(j).y) ||
//                             (Rey_X == objetivos.get(j).x && Rey_Y == objetivos.get(j).y)  ) {// si es igual quiere decir que la posicion esta ocupada del rey o la otra esta siendo marcada
//                            //System.out.println("ya ocupada");
//                            ocupadas=false;
//                        }
//                    }
//                    
//                    if (ocupadas) {
//                        //System.out.println("entro en ocupadas");
//                        objetivos.add(new Point(Rey_X-1, Rey_Y+1));
//                        objetivos.add(new Point(Rey_X, Rey_Y));
//                        h+=40;
//                    }
//                    //objetivos.add();// /
//
//                }
                
            if( ((Math.abs(Rey_X-posI_CX) == 2 && Math.abs(Rey_Y+1-posI_CY) == 1 ) || 
                (Math.abs(Rey_X-posI_CX) == 1 && Math.abs(Rey_Y+1-posI_CY) == 2 )) &&
                ((Math.abs(Rey_X+1-posI_CX) == 2 && Math.abs(Rey_Y-posI_CY) == 1 ) || 
                (Math.abs(Rey_X+1-posI_CX) == 1 && Math.abs(Rey_Y-posI_CY) == 2 )) )
                {// este if quiere decir que las posiciones objetivo especificadas alguien les esta dando hacke a las 2
                    //System.out.println("............................................................................................................................");
                    //System.out.println("Hacke------------------------------------------------------------");
                    //System.out.println("objetivos: " + objetivos.size());
                    boolean ocupadas=true;
                    for (int j = 0; j < objetivos.size(); j++) {
//                        System.out.println("verificacion ocupadas");
//                        System.out.println((Rey_X+1) + " = " + objetivos.get(j).x + " && " + Rey_Y + " = " + objetivos.get(j).y + " ||");
//                        System.out.println(Rey_X + " = " + objetivos.get(j).x + " && " + (Rey_Y+1) + " = " + objetivos.get(j).y);
                        if ( (Rey_X == objetivos.get(j).x && Rey_Y+1 == objetivos.get(j).y) ||
                             (Rey_X+1 == objetivos.get(j).x && Rey_Y == objetivos.get(j).y)  ) {// si es igual quiere decir que la posicion esta ocupada del rey o la otra esta siendo marcada
                            //System.out.println("ya ocupada");
                            ocupadas=false;
                        }
                    }
                    
                    if (ocupadas) {
                        boolean punt=true;
                        for (int z = 0; z < PuntajePos.size(); z++) {
                            if (posI_CX == PuntajePos.get(z).x && posI_CY == PuntajePos.get(z).y && punt) {
                                punt=false;
                            }
                            
                            
                        }
                        if(punt){
                            PuntajePos.add(new Point(posI_CX, posI_CY));
                            PuntajeCaballo.add(i);
                        }
                        int contab=0;
                        for (int k = 0; k < 4; k++) {
                                    //System.out.println("move: "+Caballos.get(k).getMove());
                                    if(!Caballos.get(k).getMove()){
                                        
                                        contab+=1;
                                        //System.out.println("contab; "+contab);
                                    }
                                }
                                //System.out.println("contab; "+contab);
                                if(libres.size() != 1 && contab!=3 ){
                                    Caballos.get(i).setMove(false);
                                }
//                        if(punt && Caballos.get(i).getMove())PuntajePos.add(new Point(posI_CX, posI_CY));
//                        Caballos.get(i).setMove(false);
                        //System.out.println("entro en ocupadas");
                        objetivos.add(new Point(Rey_X, Rey_Y+1));
                        objetivos.add(new Point(Rey_X+1, Rey_Y));
                        Caballos1.get(i).setMove(false);
                        
                    }
                    //objetivos.add(2);// //

                }
            
            if( ((Math.abs(Rey_X-1-posI_CX) == 2 && Math.abs(Rey_Y-posI_CY) == 1 ) || 
                (Math.abs(Rey_X-1-posI_CX) == 1 && Math.abs(Rey_Y-posI_CY) == 2 )) &&
                ((Math.abs(Rey_X-posI_CX) == 2 && Math.abs(Rey_Y+1-posI_CY) == 1 ) || 
                (Math.abs(Rey_X-posI_CX) == 1 && Math.abs(Rey_Y+1-posI_CY) == 2 )) )
                {// este if quiere decir que las posiciones objetivo especificadas alguien les esta dando hacke a las 2
                    //System.out.println("............................................................................................................................");
                    //System.out.println("Hacke------------------------------------------------------------");
//                    System.out.println("objetivos: " + objetivos.size());
                    boolean ocupadas=true;
                    for (int j = 0; j < objetivos.size(); j++) {
                        if ( (Rey_X-1 == objetivos.get(j).x && Rey_Y == objetivos.get(j).y) ||
                             (Rey_X == objetivos.get(j).x && Rey_Y+1 == objetivos.get(j).y)  ) {// si es igual quiere decir que la posicion esta ocupada del rey o la otra esta siendo marcada
//                            System.out.println("ya ocupada");
                            ocupadas=false;
                        }
                    }
                    
                    if (ocupadas) {
                        boolean punt=true;
                        for (int z = 0; z < PuntajePos.size(); z++) {
                            if (posI_CX == PuntajePos.get(z).x && posI_CY == PuntajePos.get(z).y && punt ) {
                                punt=false;
                            }
                            
                        }
                        if(punt){
                            PuntajePos.add(new Point(posI_CX, posI_CY));
                            PuntajeCaballo.add(i);
                        }
                        int contab=0;
                        for (int k = 0; k < 4; k++) {
                                    //System.out.println("move: "+Caballos.get(k).getMove());
                                    if(!Caballos.get(k).getMove()){
                                        
                                        contab+=1;
                                        //System.out.println("contab; "+contab);
                                    }
                                }
                                //System.out.println("contab; "+contab);
                                if(libres.size() != 1 && contab!=3 ){
                                    Caballos.get(i).setMove(false);
                                }
//                        if(punt)PuntajePos.add(new Point(posI_CX, posI_CY));
//                        if(punt)PuntajePos.add(new Point(posI_CX, posI_CY));
//                        if(punt && Caballos.get(i).getMove())PuntajePos.add(new Point(posI_CX, posI_CY));
                        //System.out.println("entro en ocupadas");
                        //PuntajePos.add(new Point(posI_CX, posI_CY));
//                        Caballos.get(i).setMove(false);
                        objetivos.add(new Point(Rey_X-1, Rey_Y));
                        objetivos.add(new Point(Rey_X, Rey_Y+1));
                        Caballos1.get(i).setMove(false);
                        
                    }
                    //objetivos.add(3);// \
                    

                }
//            if( ((Math.abs(Rey_X-posI_CX) == 2 && Math.abs(Rey_Y-posI_CY) == 1 ) || 
//                (Math.abs(Rey_X-posI_CX) == 1 && Math.abs(Rey_Y-posI_CY) == 2 )) &&
//                ((Math.abs(Rey_X+1-posI_CX) == 2 && Math.abs(Rey_Y+1-posI_CY) == 1 ) || 
//                (Math.abs(Rey_X+1-posI_CX) == 1 && Math.abs(Rey_Y+1-posI_CY) == 2 )) )
//                {// este if quiere decir que las posiciones objetivo especificadas alguien les esta dando hacke a las 2
//                    ////System.out.println("............................................................................................................................");
//                    //System.out.println("Hacke------------------------------------------------------------");
////                    System.out.println("objetivos: " + objetivos.size());
//                    boolean ocupadas=true;
//                    for (int j = 0; j < objetivos.size(); j++) {
//                        if ( (Rey_X == objetivos.get(j).x && Rey_Y == objetivos.get(j).y) ||
//                             (Rey_X+1 == objetivos.get(j).x && Rey_Y+1 == objetivos.get(j).y)  ) {// si es igual quiere decir que la posicion esta ocupada del rey o la otra esta siendo marcada
////                            System.out.println("ya ocupada");
//                            ocupadas=false;
//                        }
//                    }
//                    
//                    if (ocupadas) {
////                        System.out.println("entro en ocupadas");
//                        objetivos.add(new Point(Rey_X, Rey_Y));
//                        objetivos.add(new Point(Rey_X+1, Rey_Y+1));
//                        h+=40;
//                    }
//                    //objetivos.add(4);// \\
//                   
//
//                }
            if( ((Math.abs(Rey_X-1-posI_CX) == 2 && Math.abs(Rey_Y-posI_CY) == 1 ) || 
                (Math.abs(Rey_X-1-posI_CX) == 1 && Math.abs(Rey_Y-posI_CY) == 2 )) &&
                ((Math.abs(Rey_X+1-posI_CX) == 2 && Math.abs(Rey_Y-posI_CY) == 1 ) || 
                (Math.abs(Rey_X+1-posI_CX) == 1 && Math.abs(Rey_Y-posI_CY) == 2 )) )
                {// este if quiere decir que las posiciones objetivo especificadas alguien les esta dando hacke a las 2
                    //System.out.println("............................................................................................................................");
                    //System.out.println("Hacke------------------------------------------------------------");
//                    System.out.println("objetivos: " + objetivos.size());
                    boolean ocupadas=true;
                    for (int j = 0; j < objetivos.size(); j++) {
                        if ( (Rey_X-1 == objetivos.get(j).x && Rey_Y == objetivos.get(j).y) ||
                             (Rey_X+1 == objetivos.get(j).x && Rey_Y == objetivos.get(j).y)  ) {// si es igual quiere decir que la posicion esta ocupada del rey o la otra esta siendo marcada
//                            System.out.println("ya ocupada");
                            ocupadas=false;
                        }
                    }
                    
                    if (ocupadas) {
                        boolean punt=true;
                        for (int z = 0; z < PuntajePos.size(); z++) {
                            if (posI_CX == PuntajePos.get(z).x && posI_CY == PuntajePos.get(z).y && punt ) {
                                punt=false;
                            }
                            
                        }
                        if(punt){
                            PuntajePos.add(new Point(posI_CX, posI_CY));
                            PuntajeCaballo.add(i);
                        }
                        int contab=0;
                        for (int k = 0; k < 4; k++) {
                                    //System.out.println("move: "+Caballos.get(k).getMove());
                                    if(!Caballos.get(k).getMove()){
                                        
                                        contab+=1;
                                        //System.out.println("contab; "+contab);
                                    }
                                }
                                //System.out.println("contab; "+contab);
                                if(libres.size() != 1 && contab!=3 ){
                                    Caballos.get(i).setMove(false);
                                }
//                        if(punt)PuntajePos.add(new Point(posI_CX, posI_CY));
//                        if(punt)PuntajePos.add(new Point(posI_CX, posI_CY));
//                        if(punt && Caballos.get(i).getMove())PuntajePos.add(new Point(posI_CX, posI_CY));
                        //System.out.println("entro en ocupadas");
                        //PuntajePos.add(new Point(posI_CX, posI_CY));
//                        Caballos.get(i).setMove(false);
                        objetivos.add(new Point(Rey_X-1, Rey_Y));
                        objetivos.add(new Point(Rey_X+1, Rey_Y));
                        Caballos1.get(i).setMove(false);
                    }
                    //objetivos.add(5);// --- verticalcolumna1
                    

                }
            if( ((Math.abs(Rey_X-1-posI_CX) == 2 && Math.abs(Rey_Y+1-posI_CY) == 1 ) || 
                (Math.abs(Rey_X-1-posI_CX) == 1 && Math.abs(Rey_Y+1-posI_CY) == 2 )) &&
                ((Math.abs(Rey_X+1-posI_CX) == 2 && Math.abs(Rey_Y+1-posI_CY) == 1 ) || 
                (Math.abs(Rey_X+1-posI_CX) == 1 && Math.abs(Rey_Y+1-posI_CY) == 2 )) )
                {// este if quiere decir que las posiciones objetivo especificadas alguien les esta dando hacke a las 2
                    ////System.out.println("............................................................................................................................");
                    //System.out.println("Hacke------------------------------------------------------------");
//                    System.out.println("objetivos: " + objetivos.size());
                    boolean ocupadas=true;
                    for (int j = 0; j < objetivos.size(); j++) {
                        if ( (Rey_X-1 == objetivos.get(j).x && Rey_Y+1 == objetivos.get(j).y) ||
                             (Rey_X+1 == objetivos.get(j).x && Rey_Y+1 == objetivos.get(j).y)  ) {// si es igual quiere decir que la posicion esta ocupada del rey o la otra esta siendo marcada
//                            System.out.println("ya ocupada");
                            ocupadas=false;
                        }
                    }
                    
                    if (ocupadas) {
                        boolean punt=true;
                        for (int z = 0; z < PuntajePos.size(); z++) {
                            if (posI_CX == PuntajePos.get(z).x && posI_CY == PuntajePos.get(z).y && punt ) {
                                punt=false;
                            }
                            
                        }
                        if(punt){
                            PuntajePos.add(new Point(posI_CX, posI_CY));
                            PuntajeCaballo.add(i);
                        }
                        int contab = 0;
                        for (int k = 0; k < 4; k++) {
                            //System.out.println("move: " + Caballos.get(k).getMove());
                            if (!Caballos.get(k).getMove()) {

                                contab += 1;
                                //System.out.println("contab; " + contab);
                            }
                        }
                        //System.out.println("contab; " + contab);
                        if (libres.size() != 1 && contab != 3) {
                            Caballos.get(i).setMove(false);
                        }
//                        if(punt)PuntajePos.add(new Point(posI_CX, posI_CY));
//                        if(punt && Caballos.get(i).getMove())PuntajePos.add(new Point(posI_CX, posI_CY));
                        //System.out.println("entro en ocupadas");
//                        Caballos.get(i).setMove(false);
                        //PuntajePos.add(new Point(posI_CX, posI_CY));
                        objetivos.add(new Point(Rey_X-1, Rey_Y+1));
                        objetivos.add(new Point(Rey_X+1, Rey_Y+1));
                        Caballos1.get(i).setMove(false);
                    }
                    //objetivos.add(6);// ___ verticalcolumna2
                    

                }
                //System.out.println("............................................................................................................................");
            }
            if(Rey_Y==8 && (Rey_X>=1 && Rey_X<=8)){
                //h+=VerificarPosisinesObjetivo(RestaFila,RestaColumna);
                if( ((Math.abs(Rey_X-1-posI_CX) == 2 && Math.abs(Rey_Y-posI_CY) == 1 ) || 
                (Math.abs(Rey_X-1-posI_CX) == 1 && Math.abs(Rey_Y-posI_CY) == 2 )) &&
                ((Math.abs(Rey_X-posI_CX) == 2 && Math.abs(Rey_Y-1-posI_CY) == 1 ) || 
                (Math.abs(Rey_X-posI_CX) == 1 && Math.abs(Rey_Y-1-posI_CY) == 2 )) )
                {// este if quiere decir que las posiciones objetivo especificadas alguien les esta dando hacke a las 2
                    //System.out.println("............................................................................................................................");
                    //System.out.println("Hacke------------------------------------------------------------");
//                    System.out.println("objetivos: " + objetivos.size());
                    boolean ocupadas=true;
                    for (int j = 0; j < objetivos.size(); j++) {
                        if ( (Rey_X-1 == objetivos.get(j).x && Rey_Y == objetivos.get(j).y) ||
                             (Rey_X == objetivos.get(j).x && Rey_Y-1 == objetivos.get(j).y)  ) {// si es igual quiere decir que la posicion esta ocupada del rey o la otra esta siendo marcada
//                            System.out.println("ya ocupada");
                            ocupadas=false;
                        }
                    }
                    
                    if (ocupadas) {
                        boolean punt=true;
                        for (int z = 0; z < PuntajePos.size(); z++) {
                            if (posI_CX == PuntajePos.get(z).x && posI_CY == PuntajePos.get(z).y && punt ) {
                                punt=false;
                            }
                            
                        }
                        if(punt){
                            PuntajePos.add(new Point(posI_CX, posI_CY));
                            PuntajeCaballo.add(i);
                        }
                        int contab=0;
                        for (int k = 0; k < 4; k++) {
                                    //System.out.println("move: "+Caballos.get(k).getMove());
                                    if(!Caballos.get(k).getMove()){
                                        
                                        contab+=1;
                                        //System.out.println("contab; "+contab);
                                    }
                                }
                                //System.out.println("contab; "+contab);
                                if(libres.size() != 1 && contab!=3 ){
                                    Caballos.get(i).setMove(false);
                                }
//                        if(punt)PuntajePos.add(new Point(posI_CX, posI_CY));
//                        if(punt && Caballos.get(i).getMove())PuntajePos.add(new Point(posI_CX, posI_CY));
                        //System.out.println("entro en ocupadas");
                        
                        //PuntajePos.add(new Point(posI_CX, posI_CY));
//                        Caballos.get(i).setMove(false);
                        objetivos.add(new Point(Rey_X-1, Rey_Y));
                        objetivos.add(new Point(Rey_X, Rey_Y-1));
                        Caballos1.get(i).setMove(false);
                    }
                    //objetivos.add();// /

                }
                
//            if( ((Math.abs(Rey_X-posI_CX) == 2 && Math.abs(Rey_Y-posI_CY) == 1 ) || 
//                (Math.abs(Rey_X-posI_CX) == 1 && Math.abs(Rey_Y-posI_CY) == 2 )) &&
//                ((Math.abs(Rey_X+1-posI_CX) == 2 && Math.abs(Rey_Y-1-posI_CY) == 1 ) || 
//                (Math.abs(Rey_X+1-posI_CX) == 1 && Math.abs(Rey_Y-1-posI_CY) == 2 )) )
//                {// este if quiere decir que las posiciones objetivo especificadas alguien les esta dando hacke a las 2
//                    //System.out.println("............................................................................................................................");
//                    //System.out.println("Hacke------------------------------------------------------------");
////                    System.out.println("objetivos: " + objetivos.size());
//                    boolean ocupadas=true;
//                    for (int j = 0; j < objetivos.size(); j++) {
////                        System.out.println("verificacion ocupadas");
////                        System.out.println((Rey_X+1) + " = " + objetivos.get(j).x + " && " + Rey_Y + " = " + objetivos.get(j).y + " ||");
////                        System.out.println(Rey_X + " = " + objetivos.get(j).x + " && " + (Rey_Y+1) + " = " + objetivos.get(j).y);
//                        if ( (Rey_X == objetivos.get(j).x && Rey_Y == objetivos.get(j).y) ||
//                             (Rey_X+1 == objetivos.get(j).x && Rey_Y-1 == objetivos.get(j).y)  ) {// si es igual quiere decir que la posicion esta ocupada del rey o la otra esta siendo marcada
////                            System.out.println("ya ocupada");
//                            ocupadas=false;
//                        }
//                    }
//                    
//                    if (ocupadas) {
//                        System.out.println("entro en ocupadas");
//                        objetivos.add(new Point(Rey_X, Rey_Y));
//                        objetivos.add(new Point(Rey_X+1, Rey_Y-1));
//                        h+=40;
//                    }
//                    //objetivos.add(2);// //
//
//                }
            
//            if( ((Math.abs(Rey_X-1-posI_CX) == 2 && Math.abs(Rey_Y-1-posI_CY) == 1 ) || 
//                (Math.abs(Rey_X-1-posI_CX) == 1 && Math.abs(Rey_Y-1-posI_CY) == 2 )) &&
//                ((Math.abs(Rey_X-posI_CX) == 2 && Math.abs(Rey_Y-posI_CY) == 1 ) || 
//                (Math.abs(Rey_X-posI_CX) == 1 && Math.abs(Rey_Y-posI_CY) == 2 )) )
//                {// este if quiere decir que las posiciones objetivo especificadas alguien les esta dando hacke a las 2
//                    //System.out.println("............................................................................................................................");
//                    //System.out.println("Hacke------------------------------------------------------------");
////                    System.out.println("objetivos: " + objetivos.size());
//                    boolean ocupadas=true;
//                    for (int j = 0; j < objetivos.size(); j++) {
//                        if ( (Rey_X-1 == objetivos.get(j).x && Rey_Y-1 == objetivos.get(j).y) ||
//                             (Rey_X == objetivos.get(j).x && Rey_Y == objetivos.get(j).y)  ) {// si es igual quiere decir que la posicion esta ocupada del rey o la otra esta siendo marcada
////                            System.out.println("ya ocupada");
//                            ocupadas=false;
//                        }
//                    }
//                    
//                    if (ocupadas) {
////                        System.out.println("entro en ocupadas");
//                        objetivos.add(new Point(Rey_X-1, Rey_Y-1));
//                        objetivos.add(new Point(Rey_X, Rey_Y));
//                        h+=40;
//                    }
//                    //objetivos.add(3);// \
//                    
//
//                }
            if( ((Math.abs(Rey_X-posI_CX) == 2 && Math.abs(Rey_Y-1-posI_CY) == 1 ) || 
                (Math.abs(Rey_X-posI_CX) == 1 && Math.abs(Rey_Y-1-posI_CY) == 2 )) &&
                ((Math.abs(Rey_X+1-posI_CX) == 2 && Math.abs(Rey_Y-posI_CY) == 1 ) || 
                (Math.abs(Rey_X+1-posI_CX) == 1 && Math.abs(Rey_Y-posI_CY) == 2 )) )
                {// este if quiere decir que las posiciones objetivo especificadas alguien les esta dando hacke a las 2
                    //System.out.println("............................................................................................................................");
                    //System.out.println("Hacke------------------------------------------------------------");
//                    System.out.println("objetivos: " + objetivos.size());
                    boolean ocupadas=true;
                    for (int j = 0; j < objetivos.size(); j++) {
                        if ( (Rey_X == objetivos.get(j).x && Rey_Y-1 == objetivos.get(j).y) ||
                             (Rey_X+1 == objetivos.get(j).x && Rey_Y == objetivos.get(j).y)  ) {// si es igual quiere decir que la posicion esta ocupada del rey o la otra esta siendo marcada
//                            System.out.println("ya ocupada");
                            ocupadas=false;
                        }
                    }
                    
                    if (ocupadas) {
                        boolean punt=true;
                        for (int z = 0; z < PuntajePos.size(); z++) {
                            if (posI_CX == PuntajePos.get(z).x && posI_CY == PuntajePos.get(z).y && punt ) {
                                punt=false;
                            }
                            
                        }
                        if(punt){
                            PuntajePos.add(new Point(posI_CX, posI_CY));
                            PuntajeCaballo.add(i);
                        }
                        int contab=0;
                        for (int k = 0; k < 4; k++) {
                                    //System.out.println("move: "+Caballos.get(k).getMove());
                                    if(!Caballos.get(k).getMove()){
                                        
                                        contab+=1;
                                        //System.out.println("contab; "+contab);
                                    }
                                }
                                //System.out.println("contab; "+contab);
                                if(libres.size() != 1 && contab!=3 ){
                                    Caballos.get(i).setMove(false);
                                }
//                        if(punt)PuntajePos.add(new Point(posI_CX, posI_CY));
//                        if(punt && Caballos.get(i).getMove())PuntajePos.add(new Point(posI_CX, posI_CY));
                        //System.out.println("entro en ocupadas");
                        //PuntajePos.add(new Point(posI_CX, posI_CY));
//                        Caballos.get(i).setMove(false);
                        objetivos.add(new Point(Rey_X, Rey_Y-1));
                        objetivos.add(new Point(Rey_X+1, Rey_Y));
                        Caballos1.get(i).setMove(false);
                    }
                    //objetivos.add(4);// \\
                   

                }
            if( ((Math.abs(Rey_X-1-posI_CX) == 2 && Math.abs(Rey_Y-posI_CY) == 1 ) || 
                (Math.abs(Rey_X-1-posI_CX) == 1 && Math.abs(Rey_Y-posI_CY) == 2 )) &&
                ((Math.abs(Rey_X+1-posI_CX) == 2 && Math.abs(Rey_Y-posI_CY) == 1 ) || 
                (Math.abs(Rey_X+1-posI_CX) == 1 && Math.abs(Rey_Y-posI_CY) == 2 )) )
                {// este if quiere decir que las posiciones objetivo especificadas alguien les esta dando hacke a las 2
                    //System.out.println("............................................................................................................................");
                    //System.out.println("Hacke------------------------------------------------------------");
//                    System.out.println("objetivos: " + objetivos.size());
                    boolean ocupadas=true;
                    for (int j = 0; j < objetivos.size(); j++) {
                        if ( (Rey_X-1 == objetivos.get(j).x && Rey_Y == objetivos.get(j).y) ||
                             (Rey_X+1 == objetivos.get(j).x && Rey_Y == objetivos.get(j).y)  ) {// si es igual quiere decir que la posicion esta ocupada del rey o la otra esta siendo marcada
//                            System.out.println("ya ocupada");
                            ocupadas=false;
                        }
                    }
                    
                    if (ocupadas) {
                        boolean punt=true;
                        for (int z = 0; z < PuntajePos.size(); z++) {
                            if (posI_CX == PuntajePos.get(z).x && posI_CY == PuntajePos.get(z).y && punt ) {
                                punt=false;
                            }
                            
                        }
                        if(punt){
                            PuntajePos.add(new Point(posI_CX, posI_CY));
                            PuntajeCaballo.add(i);
                        }
                        int contab=0;
                        for (int k = 0; k < 4; k++) {
                                    //System.out.println("move: "+Caballos.get(k).getMove());
                                    if(!Caballos.get(k).getMove()){
                                        
                                        contab+=1;
                                        //System.out.println("contab; "+contab);
                                    }
                                }
                                //System.out.println("contab; "+contab);
                                if(libres.size() != 1 && contab!=3 ){
                                    Caballos.get(i).setMove(false);
                                }
//                        if(punt)PuntajePos.add(new Point(posI_CX, posI_CY));
//                        if(punt && Caballos.get(i).getMove())PuntajePos.add(new Point(posI_CX, posI_CY));
                        //System.out.println("entro en ocupadas");
                        //PuntajePos.add(new Point(posI_CX, posI_CY));
//                        Caballos.get(i).setMove(false);
                        objetivos.add(new Point(Rey_X-1, Rey_Y));
                        objetivos.add(new Point(Rey_X+1, Rey_Y));
                        Caballos1.get(i).setMove(false);
                    }
                    //objetivos.add(5);// --- verticalcolumna8
                    

                }
            if( ((Math.abs(Rey_X-1-posI_CX) == 2 && Math.abs(Rey_Y-1-posI_CY) == 1 ) || 
                (Math.abs(Rey_X-1-posI_CX) == 1 && Math.abs(Rey_Y-1-posI_CY) == 2 )) &&
                ((Math.abs(Rey_X+1-posI_CX) == 2 && Math.abs(Rey_Y-1-posI_CY) == 1 ) || 
                (Math.abs(Rey_X+1-posI_CX) == 1 && Math.abs(Rey_Y-1-posI_CY) == 2 )) )
                {// este if quiere decir que las posiciones objetivo especificadas alguien les esta dando hacke a las 2
                    //System.out.println("............................................................................................................................");
                    //System.out.println("Hacke------------------------------------------------------------");
//                    System.out.println("objetivos: " + objetivos.size());
                    boolean ocupadas=true;
                    for (int j = 0; j < objetivos.size(); j++) {
                        if ( (Rey_X-1 == objetivos.get(j).x && Rey_Y-1 == objetivos.get(j).y) ||
                             (Rey_X+1 == objetivos.get(j).x && Rey_Y-1 == objetivos.get(j).y)  ) {// si es igual quiere decir que la posicion esta ocupada del rey o la otra esta siendo marcada
//                            System.out.println("ya ocupada");
                            ocupadas=false;
                        }
                    }
                    
                    if (ocupadas) {
                        boolean punt=true;
                        for (int z = 0; z < PuntajePos.size(); z++) {
                            if (posI_CX == PuntajePos.get(z).x && posI_CY == PuntajePos.get(z).y && punt ) {
                                punt=false;
                            }
                            
                        }
                        if(punt){
                            PuntajePos.add(new Point(posI_CX, posI_CY));
                            PuntajeCaballo.add(i);
                        }
                        int contab=0;
                        for (int k = 0; k < 4; k++) {
                                    //System.out.println("move: "+Caballos.get(k).getMove());
                                    if(!Caballos.get(k).getMove()){
                                        
                                        contab+=1;
                                        //System.out.println("contab; "+contab);
                                    }
                                }
                                //System.out.println("contab; "+contab);
                                if(libres.size() != 1 && contab!=3 ){
                                    Caballos.get(i).setMove(false);
                                }
//                        if(punt)PuntajePos.add(new Point(posI_CX, posI_CY));
//                        if(punt && Caballos.get(i).getMove())PuntajePos.add(new Point(posI_CX, posI_CY));
                        //System.out.println("entro en ocupadas");
                        //PuntajePos.add(new Point(posI_CX, posI_CY));
//                        Caballos.get(i).setMove(false);
                        objetivos.add(new Point(Rey_X-1, Rey_Y-1));
                        objetivos.add(new Point(Rey_X+1, Rey_Y-1));
                        Caballos1.get(i).setMove(false);
                    }
                    //objetivos.add(6);// ___ verticalcolumna7
                    

                }
                //System.out.println("............................................................................................................................");
            }
            if(Rey_X==1 && (Rey_Y>=2 && Rey_Y<=7)){ //arriba
                //h+=VerificarPosisinesObjetivo(Rey_X,Rey_Y,posI_CX,posI_CY);
//                if( ((Math.abs(Rey_X-posI_CX) == 2 && Math.abs(Rey_Y-posI_CY) == 1 ) || 
//                (Math.abs(Rey_X-posI_CX) == 1 && Math.abs(Rey_Y-posI_CY) == 2 )) &&
//                ((Math.abs(Rey_X+1-posI_CX) == 2 && Math.abs(Rey_Y-1-posI_CY) == 1 ) || 
//                (Math.abs(Rey_X+1-posI_CX) == 1 && Math.abs(Rey_Y-1-posI_CY) == 2 )) )
//                {// este if quiere decir que las posiciones objetivo especificadas alguien les esta dando hacke a las 2
//                    //System.out.println("............................................................................................................................");
//                    //System.out.println("Hacke------------------------------------------------------------");
////                    System.out.println("objetivos: " + objetivos.size());
//                    boolean ocupadas=true;
//                    for (int j = 0; j < objetivos.size(); j++) {
//                        if ( (Rey_X+1 == objetivos.get(j).x && Rey_Y-1 == objetivos.get(j).y) ||
//                             (Rey_X == objetivos.get(j).x && Rey_Y == objetivos.get(j).y)  ) {// si es igual quiere decir que la posicion esta ocupada del rey o la otra esta siendo marcada
////                            System.out.println("ya ocupada");
//                            ocupadas=false;
//                        }
//                    }
//                    
//                    if (ocupadas) {
//                        System.out.println("entro en ocupadas");
//                        objetivos.add(new Point(Rey_X, Rey_Y));
//                        objetivos.add(new Point(Rey_X+1, Rey_Y-1));
//                        h+=40;
//                    }
//                    //objetivos.add();// /
//
//                }
                
            if( ((Math.abs(Rey_X-posI_CX) == 2 && Math.abs(Rey_Y+1-posI_CY) == 1 ) || 
                (Math.abs(Rey_X-posI_CX) == 1 && Math.abs(Rey_Y+1-posI_CY) == 2 )) &&
                ((Math.abs(Rey_X+1-posI_CX) == 2 && Math.abs(Rey_Y-posI_CY) == 1 ) || 
                (Math.abs(Rey_X+1-posI_CX) == 1 && Math.abs(Rey_Y-posI_CY) == 2 )) )
                {// este if quiere decir que las posiciones objetivo especificadas alguien les esta dando hacke a las 2
                    //System.out.println("............................................................................................................................");
                    //System.out.println("Hacke------------------------------------------------------------");
//                    System.out.println("objetivos: " + objetivos.size());
                    boolean ocupadas=true;
                    for (int j = 0; j < objetivos.size(); j++) {
//                        System.out.println("verificacion ocupadas");
//                        System.out.println((Rey_X+1) + " = " + objetivos.get(j).x + " && " + Rey_Y + " = " + objetivos.get(j).y + " ||");
//                        System.out.println(Rey_X + " = " + objetivos.get(j).x + " && " + (Rey_Y+1) + " = " + objetivos.get(j).y);
                        if ( (Rey_X+1 == objetivos.get(j).x && Rey_Y == objetivos.get(j).y) ||
                             (Rey_X == objetivos.get(j).x && Rey_Y+1 == objetivos.get(j).y)  ) {// si es igual quiere decir que la posicion esta ocupada del rey o la otra esta siendo marcada
//                            System.out.println("ya ocupada");
                            ocupadas=false;
                        }
                    }
                    
                    if (ocupadas) {
                        boolean punt=true;
                        for (int z = 0; z < PuntajePos.size(); z++) {
                            if (posI_CX == PuntajePos.get(z).x && posI_CY == PuntajePos.get(z).y && punt ) {
                                punt=false;
                            }
                            
                        }
                        if(punt){
                            PuntajePos.add(new Point(posI_CX, posI_CY));
                            PuntajeCaballo.add(i);
                        }
                        int contab=0;
                        for (int k = 0; k < 4; k++) {
                                    //System.out.println("move: "+Caballos.get(k).getMove());
                                    if(!Caballos.get(k).getMove()){
                                        
                                        contab+=1;
                                        //System.out.println("contab; "+contab);
                                    }
                                }
                                //System.out.println("contab; "+contab);
                                if(libres.size() != 1 && contab!=3 ){
                                    //System.out.println("entraaaaa la mrd");
                                    Caballos.get(i).setMove(false);
                                }
//                        if(punt)PuntajePos.add(new Point(posI_CX, posI_CY));
//                        if(punt && Caballos.get(i).getMove())PuntajePos.add(new Point(posI_CX, posI_CY));
                        //System.out.println("entro en ocupadas");
//                        Caballos.get(i).setMove(false);
                        //PuntajePos.add(new Point(posI_CX, posI_CY));
                        objetivos.add(new Point(Rey_X+1, Rey_Y));
                        objetivos.add(new Point(Rey_X, Rey_Y+1));
                        Caballos1.get(i).setMove(false);
                    }
                    //objetivos.add(2);// //

                }
            
            if( ((Math.abs(Rey_X-posI_CX) == 2 && Math.abs(Rey_Y-1-posI_CY) == 1 ) || 
                (Math.abs(Rey_X-posI_CX) == 1 && Math.abs(Rey_Y-1-posI_CY) == 2 )) &&
                ((Math.abs(Rey_X+1-posI_CX) == 2 && Math.abs(Rey_Y-posI_CY) == 1 ) || 
                (Math.abs(Rey_X+1-posI_CX) == 1 && Math.abs(Rey_Y-posI_CY) == 2 )) )
                {// este if quiere decir que las posiciones objetivo especificadas alguien les esta dando hacke a las 2
                    //System.out.println("............................................................................................................................");
                    //System.out.println("Hacke------------------------------------------------------------");
//                    System.out.println("objetivos: " + objetivos.size());
                    boolean ocupadas=true;
                    for (int j = 0; j < objetivos.size(); j++) {
                        if ( (Rey_X+1 == objetivos.get(j).x && Rey_Y == objetivos.get(j).y) ||
                             (Rey_X == objetivos.get(j).x && Rey_Y-1 == objetivos.get(j).y)  ) {// si es igual quiere decir que la posicion esta ocupada del rey o la otra esta siendo marcada
//                            System.out.println("ya ocupada");
                            ocupadas=false;
                        }
                    }
                    
                    if (ocupadas) {
                        boolean punt=true;
                        for (int z = 0; z < PuntajePos.size(); z++) {
                            if (posI_CX == PuntajePos.get(z).x && posI_CY == PuntajePos.get(z).y && punt ) {
                                punt=false;
                            }
                            
                        }
                        if(punt){
                            PuntajePos.add(new Point(posI_CX, posI_CY));
                            PuntajeCaballo.add(i);
                        }
                        int contab = 0;
                        for (int k = 0; k < 4; k++) {
                            //System.out.println("move: " + Caballos.get(k).getMove());
                            if (!Caballos.get(k).getMove()) {

                                contab += 1;
                                //System.out.println("contab; " + contab);
                            }
                        }
                        //System.out.println("contab; " + contab);
                        if (libres.size() != 1 && contab != 3) {
                            Caballos.get(i).setMove(false);
                        }
//                        if(punt)PuntajePos.add(new Point(posI_CX, posI_CY));
//                        if(punt && Caballos.get(i).getMove())PuntajePos.add(new Point(posI_CX, posI_CY));
                        //System.out.println("entro en ocupadas");
                        //PuntajePos.add(new Point(posI_CX, posI_CY));
//                        Caballos.get(i).setMove(false);
                        objetivos.add(new Point(Rey_X+1, Rey_Y));
                        objetivos.add(new Point(Rey_X, Rey_Y-1));
                        Caballos1.get(i).setMove(false);
                    }
                    //objetivos.add(3);// \
                    

                }
//            if( ((Math.abs(Rey_X-posI_CX) == 2 && Math.abs(Rey_Y-posI_CY) == 1 ) || 
//                (Math.abs(Rey_X-posI_CX) == 1 && Math.abs(Rey_Y-posI_CY) == 2 )) &&
//                ((Math.abs(Rey_X+1-posI_CX) == 2 && Math.abs(Rey_Y+1-posI_CY) == 1 ) || 
//                (Math.abs(Rey_X+1-posI_CX) == 1 && Math.abs(Rey_Y+1-posI_CY) == 2 )) )
//                {// este if quiere decir que las posiciones objetivo especificadas alguien les esta dando hacke a las 2
//                    ////System.out.println("............................................................................................................................");
//                    //System.out.println("Hacke------------------------------------------------------------");
////                    System.out.println("objetivos: " + objetivos.size());
//                    boolean ocupadas=true;
//                    for (int j = 0; j < objetivos.size(); j++) {
//                        if ( (Rey_X+1 == objetivos.get(j).x && Rey_Y+1 == objetivos.get(j).y) ||
//                             (Rey_X == objetivos.get(j).x && Rey_Y == objetivos.get(j).y)  ) {// si es igual quiere decir que la posicion esta ocupada del rey o la otra esta siendo marcada
////                            System.out.println("ya ocupada");
//                            ocupadas=false;
//                        }
//                    }
//                    
//                    if (ocupadas) {
////                        System.out.println("entro en ocupadas");
//                        objetivos.add(new Point(Rey_X+1, Rey_Y+1));
//                        objetivos.add(new Point(Rey_X, Rey_Y));
//                        h+=40;
//                    }
//                    //objetivos.add(4);// \\
//                   
//
//                }
            if( ((Math.abs(Rey_X-posI_CX) == 2 && Math.abs(Rey_Y-1-posI_CY) == 1 ) || 
                (Math.abs(Rey_X-posI_CX) == 1 && Math.abs(Rey_Y-1-posI_CY) == 2 )) &&
                ((Math.abs(Rey_X-posI_CX) == 2 && Math.abs(Rey_Y+1-posI_CY) == 1 ) || 
                (Math.abs(Rey_X-posI_CX) == 1 && Math.abs(Rey_Y+1-posI_CY) == 2 )) )
                {// este if quiere decir que las posiciones objetivo especificadas alguien les esta dando hacke a las 2
                    //System.out.println("............................................................................................................................");
                    //System.out.println("Hacke------------------------------------------------------------");
//                    System.out.println("objetivos: " + objetivos.size());
                    boolean ocupadas=true;
                    for (int j = 0; j < objetivos.size(); j++) {
                        if ( (Rey_X == objetivos.get(j).x && Rey_Y-1 == objetivos.get(j).y) ||
                             (Rey_X == objetivos.get(j).x && Rey_Y+1 == objetivos.get(j).y)  ) {// si es igual quiere decir que la posicion esta ocupada del rey o la otra esta siendo marcada
//                            System.out.println("ya ocupada");
                            ocupadas=false;
                        }
                    }
                    
                    if (ocupadas) {
                        boolean punt=true;
                        for (int z = 0; z < PuntajePos.size(); z++) {
                            if (posI_CX == PuntajePos.get(z).x && posI_CY == PuntajePos.get(z).y && punt ) {
                                punt=false;
                            }
                            
                        }
                        if(punt){
                            PuntajePos.add(new Point(posI_CX, posI_CY));
                            PuntajeCaballo.add(i);
                        }
                        int contab=0;
                        for (int k = 0; k < 4; k++) {
                                    //System.out.println("move: "+Caballos.get(k).getMove());
                                    if(!Caballos.get(k).getMove()){
                                        
                                        contab+=1;
                                        //System.out.println("contab; "+contab);
                                    }
                                }
                                //System.out.println("contab; "+contab);
                                if(libres.size() != 1 && contab!=3 ){
                                    Caballos.get(i).setMove(false);
                                }
//                        if(punt)PuntajePos.add(new Point(posI_CX, posI_CY));
//                        if(punt && Caballos.get(i).getMove())PuntajePos.add(new Point(posI_CX, posI_CY));
                        //System.out.println("entro en ocupadas");
                        //PuntajePos.add(new Point(posI_CX, posI_CY));
//                        Caballos.get(i).setMove(false);
                        objetivos.add(new Point(Rey_X, Rey_Y+1));
                        objetivos.add(new Point(Rey_X, Rey_Y-1));
                        Caballos1.get(i).setMove(false);
                    }
                    //objetivos.add(5);// ---
                    

                }
            if( ((Math.abs(Rey_X+1-posI_CX) == 2 && Math.abs(Rey_Y-1-posI_CY) == 1 ) || 
                (Math.abs(Rey_X+1-posI_CX) == 1 && Math.abs(Rey_Y-1-posI_CY) == 2 )) &&
                ((Math.abs(Rey_X+1-posI_CX) == 2 && Math.abs(Rey_Y+1-posI_CY) == 1 ) || 
                (Math.abs(Rey_X+1-posI_CX) == 1 && Math.abs(Rey_Y+1-posI_CY) == 2 )) )
                {// este if quiere decir que las posiciones objetivo especificadas alguien les esta dando hacke a las 2
                    ////System.out.println("............................................................................................................................");
                    //System.out.println("Hacke------------------------------------------------------------");
//                    System.out.println("objetivos: " + objetivos.size());
                    boolean ocupadas=true;
                    for (int j = 0; j < objetivos.size(); j++) {
                        if ( (Rey_X+1 == objetivos.get(j).x && Rey_Y-1 == objetivos.get(j).y) ||
                             (Rey_X+1 == objetivos.get(j).x && Rey_Y+1 == objetivos.get(j).y)  ) {// si es igual quiere decir que la posicion esta ocupada del rey o la otra esta siendo marcada
//                            System.out.println("ya ocupada");
                            ocupadas=false;
                        }
                    }
                    
                    if (ocupadas) {
                        boolean punt=true;
                        for (int z = 0; z < PuntajePos.size(); z++) {
                            if (posI_CX == PuntajePos.get(z).x && posI_CY == PuntajePos.get(z).y && punt ) {
                                punt=false;
                            }
                            
                        }
                        if(punt){
                            PuntajePos.add(new Point(posI_CX, posI_CY));
                            PuntajeCaballo.add(i);
                        }
                        int contab=0;
                        for (int k = 0; k < 4; k++) {
                                    //System.out.println("move: "+Caballos.get(k).getMove());
                                    if(!Caballos.get(k).getMove()){
                                        
                                        contab+=1;
                                        //System.out.println("contab; "+contab);
                                    }
                                }
                                //System.out.println("contab; "+contab);
                                if(libres.size() != 1 && contab!=3 ){
                                    Caballos.get(i).setMove(false);
                                }
//                        if(punt)PuntajePos.add(new Point(posI_CX, posI_CY));
//                        if(punt && Caballos.get(i).getMove())PuntajePos.add(new Point(posI_CX, posI_CY));
                        //System.out.println("entro en ocupadas");
                        //PuntajePos.add(new Point(posI_CX, posI_CY));
//                        Caballos.get(i).setMove(false);
                        objetivos.add(new Point(Rey_X+1, Rey_Y+1));
                        objetivos.add(new Point(Rey_X+1, Rey_Y-1));
                        Caballos1.get(i).setMove(false);
                    }
                    //objetivos.add(6);// ___
                    

                }
                //System.out.println("............................................................................................................................");
            }
            if(Rey_X==8 && (Rey_Y>=2 && Rey_Y<=7)){//abajo
                //h+=VerificarPosisinesObjetivo(RestaFila,RestaColumna);
                if( ((Math.abs(Rey_X-1-posI_CX) == 2 && Math.abs(Rey_Y-posI_CY) == 1 ) || 
                (Math.abs(Rey_X-1-posI_CX) == 1 && Math.abs(Rey_Y-posI_CY) == 2 )) &&
                ((Math.abs(Rey_X-posI_CX) == 2 && Math.abs(Rey_Y-1-posI_CY) == 1 ) || 
                (Math.abs(Rey_X-posI_CX) == 1 && Math.abs(Rey_Y-1-posI_CY) == 2 )) )
                {// este if quiere decir que las posiciones objetivo especificadas alguien les esta dando hacke a las 2
                    //System.out.println("............................................................................................................................");
                    //System.out.println("Hacke------------------------------------------------------------");
//                    System.out.println("objetivos: " + objetivos.size());
                    boolean ocupadas=true;
                    for (int j = 0; j < objetivos.size(); j++) {
                        if ( (Rey_X-1 == objetivos.get(j).x && Rey_Y == objetivos.get(j).y) ||
                             (Rey_X == objetivos.get(j).x && Rey_Y-1 == objetivos.get(j).y)  ) {// si es igual quiere decir que la posicion esta ocupada del rey o la otra esta siendo marcada
//                            System.out.println("ya ocupada");
                            ocupadas=false;
                        }
                    }
                    
                    if (ocupadas) {
                        boolean punt=true;
                        for (int z = 0; z < PuntajePos.size(); z++) {
                            if (posI_CX == PuntajePos.get(z).x && posI_CY == PuntajePos.get(z).y && punt ) {
                                punt=false;
                            }
                            
                        }
                        if(punt){
                            PuntajePos.add(new Point(posI_CX, posI_CY));
                            PuntajeCaballo.add(i);
                        }
                        int contab=0;
                        for (int k = 0; k < 4; k++) {
                                    //System.out.println("move: "+Caballos.get(k).getMove());
                                    if(!Caballos.get(k).getMove()){
                                        
                                        contab+=1;
                                        //System.out.println("contab; "+contab);
                                    }
                                }
                                //System.out.println("contab; "+contab);
                                if(libres.size() != 1 && contab!=3 ){
                                    Caballos.get(i).setMove(false);
                                }
//                        if(punt)PuntajePos.add(new Point(posI_CX, posI_CY));
//                        if(punt && Caballos.get(i).getMove())PuntajePos.add(new Point(posI_CX, posI_CY));
                        //System.out.println("entro en ocupadas");
                        //PuntajePos.add(new Point(posI_CX, posI_CY));
//                        Caballos.get(i).setMove(false);
                        objetivos.add(new Point(Rey_X-1, Rey_Y));
                        objetivos.add(new Point(Rey_X, Rey_Y-1));
                        Caballos1.get(i).setMove(false);
                    }
                    //objetivos.add();// /

                }
                
//            if( ((Math.abs(Rey_X-1-posI_CX) == 2 && Math.abs(Rey_Y+1-posI_CY) == 1 ) || 
//                (Math.abs(Rey_X-1-posI_CX) == 1 && Math.abs(Rey_Y+1-posI_CY) == 2 )) &&
//                ((Math.abs(Rey_X-posI_CX) == 2 && Math.abs(Rey_Y-posI_CY) == 1 ) || 
//                (Math.abs(Rey_X-posI_CX) == 1 && Math.abs(Rey_Y-posI_CY) == 2 )) )
//                {// este if quiere decir que las posiciones objetivo especificadas alguien les esta dando hacke a las 2
//                    //System.out.println("............................................................................................................................");
//                    //System.out.println("Hacke------------------------------------------------------------");
////                    System.out.println("objetivos: " + objetivos.size());
//                    boolean ocupadas=true;
//                    for (int j = 0; j < objetivos.size(); j++) {
////                        System.out.println("verificacion ocupadas");
////                        System.out.println((Rey_X+1) + " = " + objetivos.get(j).x + " && " + Rey_Y + " = " + objetivos.get(j).y + " ||");
////                        System.out.println(Rey_X + " = " + objetivos.get(j).x + " && " + (Rey_Y+1) + " = " + objetivos.get(j).y);
//                        if ( (Rey_X-1 == objetivos.get(j).x && Rey_Y+1 == objetivos.get(j).y) ||
//                             (Rey_X == objetivos.get(j).x && Rey_Y == objetivos.get(j).y)  ) {// si es igual quiere decir que la posicion esta ocupada del rey o la otra esta siendo marcada
////                            System.out.println("ya ocupada");
//                            ocupadas=false;
//                        }
//                    }
//                    
//                    if (ocupadas) {
//                        System.out.println("entro en ocupadas");
//                        objetivos.add(new Point(Rey_X-1, Rey_Y+1));
//                        objetivos.add(new Point(Rey_X, Rey_Y));
//                        h+=40;
//                    }
//                    //objetivos.add(2);// //
//
//                }
            
//            if( ((Math.abs(Rey_X-1-posI_CX) == 2 && Math.abs(Rey_Y-1-posI_CY) == 1 ) || 
//                (Math.abs(Rey_X-1-posI_CX) == 1 && Math.abs(Rey_Y-1-posI_CY) == 2 )) &&
//                ((Math.abs(Rey_X-posI_CX) == 2 && Math.abs(Rey_Y-posI_CY) == 1 ) || 
//                (Math.abs(Rey_X-posI_CX) == 1 && Math.abs(Rey_Y-posI_CY) == 2 )) )
//                {// este if quiere decir que las posiciones objetivo especificadas alguien les esta dando hacke a las 2
//                    //System.out.println("............................................................................................................................");
//                    //System.out.println("Hacke------------------------------------------------------------");
////                    System.out.println("objetivos: " + objetivos.size());
//                    boolean ocupadas=true;
//                    for (int j = 0; j < objetivos.size(); j++) {
//                        if ( (Rey_X-1 == objetivos.get(j).x && Rey_Y-1 == objetivos.get(j).y) ||
//                             (Rey_X == objetivos.get(j).x && Rey_Y == objetivos.get(j).y)  ) {// si es igual quiere decir que la posicion esta ocupada del rey o la otra esta siendo marcada
////                            System.out.println("ya ocupada");
//                            ocupadas=false;
//                        }
//                    }
//                    
//                    if (ocupadas) {
////                        System.out.println("entro en ocupadas");
//                        objetivos.add(new Point(Rey_X-1, Rey_Y-1));
//                        objetivos.add(new Point(Rey_X, Rey_Y));
//                        h+=40;
//                    }
//                    //objetivos.add(3);// \
//                    
//
//                }
            if( ((Math.abs(Rey_X-1-posI_CX) == 2 && Math.abs(Rey_Y-posI_CY) == 1 ) || 
                (Math.abs(Rey_X-1-posI_CX) == 1 && Math.abs(Rey_Y-posI_CY) == 2 )) &&
                ((Math.abs(Rey_X-posI_CX) == 2 && Math.abs(Rey_Y+1-posI_CY) == 1 ) || 
                (Math.abs(Rey_X-posI_CX) == 1 && Math.abs(Rey_Y+1-posI_CY) == 2 )) )
                {// este if quiere decir que las posiciones objetivo especificadas alguien les esta dando hacke a las 2
                    //System.out.println("............................................................................................................................");
                    //System.out.println("Hacke------------------------------------------------------------");
//                    System.out.println("objetivos: " + objetivos.size());
                    boolean ocupadas=true;
                    for (int j = 0; j < objetivos.size(); j++) {
                        if ( (Rey_X-1 == objetivos.get(j).x && Rey_Y == objetivos.get(j).y) ||
                             (Rey_X == objetivos.get(j).x && Rey_Y+1 == objetivos.get(j).y)  ) {// si es igual quiere decir que la posicion esta ocupada del rey o la otra esta siendo marcada
//                            System.out.println("ya ocupada");
                            ocupadas=false;
                        }
                    }
                    
                    if (ocupadas) {
                        boolean punt=true;
                        for (int z = 0; z < PuntajePos.size(); z++) {
                            if (posI_CX == PuntajePos.get(z).x && posI_CY == PuntajePos.get(z).y && punt ) {
                                punt=false;
                            }
                            
                        }
                        if(punt){
                            PuntajePos.add(new Point(posI_CX, posI_CY));
                            PuntajeCaballo.add(i);
                        }
                        int contab=0;
                        for (int k = 0; k < 4; k++) {
                                    //System.out.println("move: "+Caballos.get(k).getMove());
                                    if(!Caballos.get(k).getMove()){
                                        
                                        contab+=1;
                                        //System.out.println("contab; "+contab);
                                    }
                                }
                                //System.out.println("contab; "+contab);
                                if(libres.size() != 1 && contab!=3 ){
                                    Caballos.get(i).setMove(false);
                                }
//                        if(punt)PuntajePos.add(new Point(posI_CX, posI_CY));
//                        if(punt && Caballos.get(i).getMove())PuntajePos.add(new Point(posI_CX, posI_CY));
                        System.out.println("entro en ocupadas");
//                        Caballos.get(i).setMove(false);
                        //PuntajePos.add(new Point(posI_CX, posI_CY));
                        objetivos.add(new Point(Rey_X-1, Rey_Y));
                        objetivos.add(new Point(Rey_X, Rey_Y+1));
                        Caballos1.get(i).setMove(false);
                    }
                    //objetivos.add(4);// \\
                   

                }
            if( ((Math.abs(Rey_X-posI_CX) == 2 && Math.abs(Rey_Y-1-posI_CY) == 1 ) || 
                (Math.abs(Rey_X-posI_CX) == 1 && Math.abs(Rey_Y-1-posI_CY) == 2 )) &&
                ((Math.abs(Rey_X-posI_CX) == 2 && Math.abs(Rey_Y+1-posI_CY) == 1 ) || 
                (Math.abs(Rey_X-posI_CX) == 1 && Math.abs(Rey_Y+1-posI_CY) == 2 )) )
                {// este if quiere decir que las posiciones objetivo especificadas alguien les esta dando hacke a las 2
                    ////System.out.println("............................................................................................................................");
                    //System.out.println("Hacke------------------------------------------------------------");
//                    System.out.println("objetivos: " + objetivos.size());
                    boolean ocupadas=true;
                    for (int j = 0; j < objetivos.size(); j++) {
                        if ( (Rey_X == objetivos.get(j).x && Rey_Y-1 == objetivos.get(j).y) ||
                             (Rey_X == objetivos.get(j).x && Rey_Y+1 == objetivos.get(j).y)  ) {// si es igual quiere decir que la posicion esta ocupada del rey o la otra esta siendo marcada
//                            System.out.println("ya ocupada");
                            ocupadas=false;
                        }
                    }
                    
                    if (ocupadas) {
                        boolean punt=true;
                        for (int z = 0; z < PuntajePos.size(); z++) {
                            if (posI_CX == PuntajePos.get(z).x && posI_CY == PuntajePos.get(z).y && punt ) {
                                punt=false;
                            }
                            
                        }
                        if(punt){
                            PuntajePos.add(new Point(posI_CX, posI_CY));
                            PuntajeCaballo.add(i);
                        }
                        int contab=0;
                        for (int k = 0; k < 4; k++) {
                                    //System.out.println("move: "+Caballos.get(k).getMove());
                                    if(!Caballos.get(k).getMove()){
                                        
                                        contab+=1;
                                        //System.out.println("contab; "+contab);
                                    }
                                }
                                //System.out.println("contab; "+contab);
                                if(libres.size() != 1 && contab!=3 ){
                                    Caballos.get(i).setMove(false);
                                }
//                        if(punt)PuntajePos.add(new Point(posI_CX, posI_CY));
//                        if(punt && Caballos.get(i).getMove())PuntajePos.add(new Point(posI_CX, posI_CY));
                        //System.out.println("entro en ocupadas");
                        //PuntajePos.add(new Point(posI_CX, posI_CY));
//                        Caballos.get(i).setMove(false);
                        objetivos.add(new Point(Rey_X, Rey_Y+1));
                        objetivos.add(new Point(Rey_X, Rey_Y-1));
                        Caballos1.get(i).setMove(false);
                    }
                    //objetivos.add(5);// ---
                    

                }
            if( ((Math.abs(Rey_X-1-posI_CX) == 2 && Math.abs(Rey_Y-1-posI_CY) == 1 ) || 
                (Math.abs(Rey_X-1-posI_CX) == 1 && Math.abs(Rey_Y-1-posI_CY) == 2 )) &&
                ((Math.abs(Rey_X-1-posI_CX) == 2 && Math.abs(Rey_Y+1-posI_CY) == 1 ) || 
                (Math.abs(Rey_X-1-posI_CX) == 1 && Math.abs(Rey_Y+1-posI_CY) == 2 )) )
                {// este if quiere decir que las posiciones objetivo especificadas alguien les esta dando hacke a las 2
                    //System.out.println("............................................................................................................................");
                    //System.out.println("Hacke------------------------------------------------------------");
//                    System.out.println("objetivos: " + objetivos.size());
                    boolean ocupadas=true;
                    for (int j = 0; j < objetivos.size(); j++) {
                        if ( (Rey_X-1 == objetivos.get(j).x && Rey_Y-1 == objetivos.get(j).y) ||
                             (Rey_X-1 == objetivos.get(j).x && Rey_Y+1 == objetivos.get(j).y)  ) {// si es igual quiere decir que la posicion esta ocupada del rey o la otra esta siendo marcada
//                            System.out.println("ya ocupada");
                            ocupadas=false;
                        }
                        
                    }
                    
                    if (ocupadas) {
                        boolean punt=true;
                        for (int z = 0; z < PuntajePos.size(); z++) {
                            if (posI_CX == PuntajePos.get(z).x && posI_CY == PuntajePos.get(z).y && punt ) {
                                punt=false;
                            }
                            
                        }
                        if(punt){
                            PuntajePos.add(new Point(posI_CX, posI_CY));
                            PuntajeCaballo.add(i);
                        }
//                        if(punt)PuntajePos.add(new Point(posI_CX, posI_CY));
//                        if(punt && Caballos.get(i).getMove())PuntajePos.add(new Point(posI_CX, posI_CY));
                        //System.out.println("entro en ocupadas");
                        int contab=0;
                        for (int k = 0; k < 4; k++) {
                                    //System.out.println("move: "+Caballos.get(k).getMove());
                                    if(!Caballos.get(k).getMove()){
                                        
                                        contab+=1;
                                        //System.out.println("contab; "+contab);
                                    }
                                }
                                //System.out.println("contab; "+contab);
                                if(libres.size() != 1 && contab!=3 ){
                                    Caballos.get(i).setMove(false);
                                }
//                        Caballos.get(i).setMove(false);
                        //PuntajePos.add(new Point(posI_CX, posI_CY));
                        objetivos.add(new Point(Rey_X-1, Rey_Y+1));
                        objetivos.add(new Point(Rey_X-1, Rey_Y-1));
                        Caballos1.get(i).setMove(false);
                    }
                    //objetivos.add(6);// ___
                    

                }
                //System.out.println("............................................................................................................................");
                
            }
            
            
            
        }
//        for (int j = 0; j < 4; j++) {
//            System.out.println("Caballos: "+ Caballos.get(0) +" , "+libres.get(j).y);
//        }
        for (int j = 0; j < objetivos.size(); j++) {// remueve de libres 
            //recorre libres luego objetivos
            //System.out.println("");
            //System.out.println("libres size: "+libres.size());
            //System.out.println("objetivos size: "+objetivos.size());
            for (int k = 0; k < libres.size(); k++) {
                //System.out.println("libresx: "+ libres.get(k).x +" , "+libres.get(k).y);
                //System.out.println("cx: "+ objetivos.get(j).x +" , "+objetivos.get(j).y);
                if ( libres.get(k).x == objetivos.get(j).x && libres.get(k).y == objetivos.get(j).y  ) {// si es igual quiere decir que la posicion esta ocupada del rey o la otra esta siendo marcada
                    //System.out.println("removido: " + libres.get(k).x + " y " + libres.get(k).y);

                    libres.remove(k);
                    k=libres.size();

                }
            }

        }
        for (int i = 0; i < 4; i++) {
            int posI_CX = Caballos1.get(i).getPosicionInicial_X();
            int posI_CY = Caballos1.get(i).getPosicionInicial_Y();
//            System.out.println("");
//            System.out.println("libres size: "+libres.size());
            if (( (Rey_X == 8 && Rey_Y == 1)  || (Rey_X == 1 && Rey_Y == 1) || (Rey_X == 8 && Rey_Y == 8) || (Rey_X == 1 && Rey_Y == 8) )) {
                if (libres.size()<3) {
                    //System.out.println("for libres size: "+libres.size());
                    for (int j = (libres.size()); j > 0; j--) {
                        if ((Math.abs(libres.get(j-1).x-posI_CX) == 2 && Math.abs(libres.get(j-1).y-posI_CY) == 1 ) || 
                            (Math.abs(libres.get(j-1).x-posI_CX) == 1 && Math.abs(libres.get(j-1).y-posI_CY) == 2 )) {
                            if ( !(libres.get(j-1).x == Rey_X && libres.get(j-1).y == Rey_Y && libres.size()!=1) ) {
                                    //System.out.println("entraaaaa la mrd");
                                    Caballos.get(i).setMove(false);
                                    //System.out.println("c: "+Caballos1.get(i).getNombre());
                                //System.out.println("libresx: "+ libres.get(j-1).x +" , "+libres.get(j-1).y);
                                    objetivos.add(new Point(libres.get(j-1).x, libres.get(j-1).y));
                                    
                                if(libres.size() != 1)libres.remove(j-1);
                            }
                        }
                    }
                }
            }else{
                if (libres.size()<5){
                    
                    for (int j = (libres.size()); j > 0; j--) {
//                        System.out.println("for libres size: "+libres.size());
//                        System.out.println("j "+j);
//                        System.out.println("c: "+Caballos1.get(i).getNombre());
//                        System.out.println("libresx: "+ libres.get(j-1).x +" , "+libres.get(j-1).y);
//                        System.out.println("cx: "+ posI_CX +" , "+posI_CY);
//                        System.out.println("Cebra: " + Math.abs(libres.get(j-1).x-posI_CX) + " , " + Math.abs(libres.get(j-1).y-posI_CY));
                        if ((Math.abs(libres.get(j-1).x-posI_CX) == 2 && Math.abs(libres.get(j-1).y-posI_CY) == 1 ) || 
                            (Math.abs(libres.get(j-1).x-posI_CX) == 1 && Math.abs(libres.get(j-1).y-posI_CY) == 2 )) {
//                            System.out.println("///////////////////////////////////////////////////////////////////////////");
                            for (int g = 0; g < libres.size(); g++) {
                                //System.out.println("libres arreglo: "+ libres.get(g).x +" , "+libres.get(g).y);
                            }
                            //System.out.println("");
                            //System.out.println("for libres size: "+libres.size());
                            if ( !(libres.get(j-1).x == Rey_X && libres.get(j-1).y == Rey_Y && libres.size()!=1) ) {
                                //System.out.println("?????????????????????????????");
//                                System.out.println("libresx: "+ libres.get(0).x +" , "+libres.get(0).y);
//                                System.out.println("libresx: "+ libres.get(1).x +" , "+libres.get(1).y);
                                boolean punt=true;
                                for (int z = 0; z < PuntajePos.size(); z++) {
                                    if (posI_CX == PuntajePos.get(z).x && posI_CY == PuntajePos.get(z).y && punt ) {
                                        punt=false;
                                    }

                                }
                                if(punt){
                                    PuntajePos.add(new Point(posI_CX, posI_CY));
                                    PuntajeCaballo.add(i);
                                    //System.out.println("entro");
                                }
//                                if(punt)PuntajePos.add(new Point(posI_CX, posI_CY));
//                                if(punt && Caballos.get(i).getMove())PuntajePos.add(new Point(posI_CX, posI_CY));
                                int contab=0;
                                for (int k = 0; k < 4; k++) {
                                    //System.out.println("move: "+Caballos.get(k).getMove());
                                    if(!Caballos.get(k).getMove()){
                                        
                                        contab+=1;
                                        //System.out.println("contab; "+contab);
                                    }
                                }
                                //System.out.println("contab; "+contab);
                                if(libres.size() != 1 && contab!=3 ){
                                    Caballos.get(i).setMove(false);
                                    //System.out.println("c: "+Caballos1.get(i).getNombre());
                                //System.out.println("libresx: "+ libres.get(j-1).x +" , "+libres.get(j-1).y);
                                    objetivos.add(new Point(libres.get(j-1).x, libres.get(j-1).y));
                                    
                                }
                                if(libres.size() != 1)libres.remove(j-1);
                                //PuntajePos.add(new Point(posI_CX, posI_CY));
//                                if (Caballos.get(i).getMove())Ca;
                                
                                
                                //h+=20;

                            }


                        }
                    }

                }
            }
        }
        //System.out.println("for libres size: "+libres.size());
        if ( (libres.get(libres.size()-1).x == Rey_X && libres.get(libres.size()-1).y == Rey_Y) && libres.size()==1) {
            for (int i = 0; i < 4; i++) {
                int posI_CX = Caballos1.get(i).getPosicionInicial_X();
                int posI_CY = Caballos1.get(i).getPosicionInicial_Y();
                if ((Math.abs(libres.get(0).x-posI_CX) == 2 && Math.abs(libres.get(0).y-posI_CY) == 1 ) || 
                    (Math.abs(libres.get(0).x-posI_CX) == 1 && Math.abs(libres.get(0).y-posI_CY) == 2 )) {
                    h+=100;
                }
            }
        }
//        for (int j = 0; j < libres.size(); j++) {
//            System.out.println("libresx: "+ libres.get(j).x +" , "+libres.get(j).y);
//        }
//        for (int i = 0; i < 4; i++) {
//                    System.out.println("caballos: "+ Caballos.get(i).getMove());
//                }
        
        
//        for (int i = 0; i < 4; i++) {
//            if (!Caballos.get(i).getMove()) {
//                System.out.println("name:" +Caballos.get(i).getNombre());
//                h+=10;
//            }
//        }
        //System.out.println("objetivos.size en el estado: " + objetivos.size()*20);
        //System.out.println("pruf: "+profundidad);
        System.out.println("h.. "+h);
        fh = profundidad + h + (objetivos.size()*20);
        System.out.println("fh: " + fh);
        //7,8
//      if () {
//                
//      }
            
        //System.out.println("objetivos size : " + objetivos.size());
        return fh;
    }
    

    private void CrearEstadosSucesores(Estado est){
        ArrayList<Caballo> ballos=est.getCaballos();
        
        for (int i = 0; i < 4; i++) {

            int pos_X = ballos.get(i).getPosicionInicial_X();
            int pos_Y = ballos.get(i).getPosicionInicial_Y();
            ArrayList<Caballo> ballos2 = new ArrayList();
//          ArrayList<Caballo> ballos2 = ballos;
            for (int j = 0; j < 4; j++) {
                ballos2.add(new Caballo(ballos.get(j).getPosicionInicial_X(),ballos.get(j).getPosicionInicial_Y(),ballos.get(j).getNombre()));
            }
            
            if(Caballos.get(i).getMove()){
            if (pos_X <= 7 && pos_X >= 2 && pos_Y <= 6 && pos_Y >= 1){
                System.out.println("---------------------entro primer movimiento------------------------------ " + ballos.get(i).getNombre());
                ballos2.get(i).setPosicionInicial_X(pos_X-1);
                ballos2.get(i).setPosicionInicial_Y(pos_Y+2);
                validacionesNuevoEstado(ballos2, i,  est);
                 
            }
            if (pos_X <= 8 && pos_X >= 3 && pos_Y <= 7 && pos_Y >= 1){
                System.out.println("---------------------entro segundo movimiento------------------------------ " + ballos.get(i).getNombre());
                ballos2.get(i).setPosicionInicial_X(pos_X-2);
                ballos2.get(i).setPosicionInicial_Y(pos_Y+1);
                validacionesNuevoEstado(ballos2, i,  est);
            }
            if (pos_X <= 7 && pos_X >= 1 && pos_Y <= 6 && pos_Y >= 1){
                System.out.println("---------------------entro tercero movimiento------------------------------ " + ballos.get(i).getNombre());
                ballos2.get(i).setPosicionInicial_X(pos_X+1);
                ballos2.get(i).setPosicionInicial_Y(pos_Y+2);
                validacionesNuevoEstado(ballos2, i,  est);
            }
            if (pos_X <= 8 && pos_X >= 3 && pos_Y <= 8 && pos_Y >= 2){
                System.out.println("---------------------entro cuarto movimiento------------------------------ " + ballos.get(i).getNombre());
                ballos2.get(i).setPosicionInicial_X(pos_X-2);
                ballos2.get(i).setPosicionInicial_Y(pos_Y-1);
                validacionesNuevoEstado(ballos2, i,  est);
            }
            if (pos_X <= 7 && pos_X >= 1 && pos_Y <= 8 && pos_Y >= 3){
                System.out.println("---------------------entro quinto movimiento------------------------------ " + ballos.get(i).getNombre());
                ballos2.get(i).setPosicionInicial_X(pos_X+1);
                ballos2.get(i).setPosicionInicial_Y(pos_Y-2);
                validacionesNuevoEstado(ballos2, i,  est);
            }
            if (pos_X <= 6 && pos_X >= 1 && pos_Y <= 8 && pos_Y >= 2){
                System.out.println("---------------------entro sexto movimiento------------------------------ " + ballos.get(i).getNombre());
                ballos2.get(i).setPosicionInicial_X(pos_X+2);
                ballos2.get(i).setPosicionInicial_Y(pos_Y-1);
                validacionesNuevoEstado(ballos2, i,  est);
            }
            if (pos_X <= 8 && pos_X >= 2 && pos_Y <= 8 && pos_Y >= 3){
                System.out.println("---------------------entro septimo movimiento------------------------------ " + ballos.get(i).getNombre());
                ballos2.get(i).setPosicionInicial_X(pos_X-1);
                ballos2.get(i).setPosicionInicial_Y(pos_Y-2);
                validacionesNuevoEstado(ballos2, i,  est);
            }
            if (pos_X <= 6 && pos_X >= 1 && pos_Y <= 7 && pos_Y >= 1){
                System.out.println("---------------------entro octavo movimiento------------------------------ " + ballos.get(i).getNombre());
                ballos2.get(i).setPosicionInicial_X(pos_X+2);
                ballos2.get(i).setPosicionInicial_Y(pos_Y+1);
                validacionesNuevoEstado(ballos2, i,  est);
            }
            
            }
        }
//        for (int i = 0; i < PuntajeCaballo.size(); i++) {
//            for (int j = 0; j < abiertos.size(); j++) {
//                if(PuntajePos.get(i).x == abiertos.get(j).getCaballos().get((int) PuntajeCaballo.get(i)).getPosicionInicial_X() && PuntajePos.get(i).y == abiertos.get(j).getCaballos().get((int)PuntajeCaballo.get(i)).getPosicionInicial_Y()){
//                    System.out.println("recorriendo abiertos ;es "+abiertos.get(j).getValor_Estado());
//                    abiertos.get(j).setValor_Estado(abiertos.get(j).getValor_Estado()+10);
//                    System.out.println("recorriendo abiertos ;es "+abiertos.get(j).getValor_Estado());
//                    System.out.println("recorriendo abiertos ;x "+PuntajePos.get(i).x);
//                    System.out.println("recorriendo abiertos ;y "+PuntajePos.get(i).y);
//                    System.out.println("recorriendo abiertos ;i "+PuntajeCaballo.get(i));
//                }
//            }
//            
//            
//        }
        CambiarEA();
//  
        
    }

    public ArrayList<Caballo> getCaballos() {
        return Caballos;
    }
    
    private boolean validacionesNuevoEstado(ArrayList<Caballo> cballos2 , int ind, Estado esta){
        ArrayList<Caballo> cballos=esta.getCaballos();
//        int cvalorHeuristico=0;
//        System.out.println("move: "+ Caballos.get(ind).getMove());
//        if(!Caballos.get(ind).getMove()){
//            cvalorHeuristico=GetFuncionHeuristica(cballos2, esta.getR(),esta.getProfundidad()-1, 10);
//        }else{
//            cvalorHeuristico=GetFuncionHeuristica(cballos2, esta.getR(),esta.getProfundidad()-1, 0);
//        }
        

        //validar que la posicion no este ocupada
        //validar que el estado sucesor no exista con valor heuristica y luego 2 for 4 caballos = 4 caballos
        //validar abiertos
        //validar cerrados
        boolean bandera = true;
        for (int j = 0; j < 4; j++) {//validar que la posicion no este ocupada//validar que la posicion no este ocupada
            if (cballos2.get(ind).getPosicionInicial_X() == cballos.get(j).getPosicionInicial_X() && cballos2.get(ind).getPosicionInicial_Y() == cballos.get(j).getPosicionInicial_Y()) {
//                System.out.println("posicion ya ocupada");
                bandera = false;
            }
        }
        
        //validar que el estado sucesor no exista con valor heuristica y luego 2 for (4 caballos = 4 caballos)
        //System.out.println("estados size: " + Estados.size());
        boolean band[] = {false,false,false,false} ; 
        for (int s = 0; s < cerrados.size(); s++) {
            Estado este = cerrados.get(s);
            if (cballos2.get(0).getPosicionInicial_X() == este.getCaballos().get(0).getPosicionInicial_X() && cballos2.get(0).getPosicionInicial_Y() == este.getCaballos().get(0).getPosicionInicial_Y()) {
//                System.out.println("posicion ya ocupada");
                band[0] = true ;
            }
            if (cballos2.get(1).getPosicionInicial_X() == este.getCaballos().get(1).getPosicionInicial_X() && cballos2.get(1).getPosicionInicial_Y() == este.getCaballos().get(1).getPosicionInicial_Y()) {
//                System.out.println("posicion ya ocupada");
                band[1] = true ;
            }
            if (cballos2.get(2).getPosicionInicial_X() == este.getCaballos().get(2).getPosicionInicial_X() && cballos2.get(2).getPosicionInicial_Y() == este.getCaballos().get(2).getPosicionInicial_Y()) {
//                System.out.println("posicion ya ocupada");
                band[2] = true ;
            }
            if (cballos2.get(3).getPosicionInicial_X() == este.getCaballos().get(3).getPosicionInicial_X() && cballos2.get(3).getPosicionInicial_Y() == este.getCaballos().get(3).getPosicionInicial_Y()) {
//                System.out.println("posicion ya ocupada");
                band[3] = true ;
            }
//            System.out.println("Caballo 1: " + Math.abs((este.getCaballos().get(0).getPosicionInicial_X())) + " , " + (este.getCaballos().get(0).getPosicionInicial_Y()));
//            System.out.println("Caballo 1: " + Math.abs((este.getCaballos().get(1).getPosicionInicial_X())) + " , " + (este.getCaballos().get(1).getPosicionInicial_Y()));
//            System.out.println("Caballo 1: " + Math.abs((este.getCaballos().get(2).getPosicionInicial_X())) + " , " + (este.getCaballos().get(2).getPosicionInicial_Y()));
//            System.out.println("Caballo 1: " + Math.abs((este.getCaballos().get(3).getPosicionInicial_X())) + " , " + (este.getCaballos().get(3).getPosicionInicial_Y()));
            
        }
        int cvalorHeuristico=GetFuncionHeuristica(cballos2, esta.getR(),esta.getProfundidad());
        
//        if(!Caballos.get(ind).getMove()){
//            cvalorHeuristico+=10;
//        }
        //System.out.println("cvalorheuristico: " + cvalorHeuristico);

        for (int j = 0; j < Estados.size(); j++) {
            if (Estados.get(j).getValor_Estado() == cvalorHeuristico)  {
                //estado que tiene mismo valor heuristoco esta en indice Estados(j)
                //recorremos 2 for para x cada caballo ver si ocupan las mismas posiciones
                ArrayList<Caballo> verificarCaballos=Estados.get(j).getCaballos();
                //System.out.println("hay un estado igual valor");

                for (int x = 0; x < 4; x++) {//ballos2 y verificarCaballos
                    Caballo verificarCaballo=verificarCaballos.get(x);


                    for (int y = 0; y < 4; y++) {
                        if (cballos2.get(y).getPosicionInicial_X() == verificarCaballo.getPosicionInicial_X() && cballos2.get(y).getPosicionInicial_Y() == verificarCaballo.getPosicionInicial_Y()) {
                                band[x]=true;
//                                System.out.println("1 caballo igual en verificarCaballos");
//                                System.out.println(cballos2.get(y).getPosicionInicial_X() + " = " + verificarCaballo.getPosicionInicial_X() + " && " + cballos2.get(y).getPosicionInicial_Y() + " == " + verificarCaballo.getPosicionInicial_Y());
                        }
                    }
                }
                //si hay alguno falso entonces significa que todos los caballos del estado nuevo y del que tiene el mismo valor heuristico no son iguales
                //y sigue buscando estados con mismo valor heuristico pero con todas las banderas en false
                //System.out.println("band: " + band[0] + band[1] + band[2] + band[3]);
                if (band[0] == false || band[1] == false || band[2] == false || band[3] == false) {
                    band[0] = false ; 
                    band[1] = false ; 
                    band[2] = false ; 
                    band[3] = false ; 
                }else{
                    bandera=false;
                    //System.out.println("//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
                }

            }
        }//cierra ciclo de recorrer todos los estados y validar 4 caballos = 4 caballos
        //validar abiertos
        //validar cerrados

// creo que en el anterior ciclo se valida tanto abiertos como cerrados ---------------------------------------------------------------------------------------------
        Estado EstSucesor=null;
//        System.out.println("bandera : "+ bandera);
//                System.out.println("ballos2 size: "+ballos2.size());
        if (bandera) {
            ArrayList<Caballo> caballitos = new ArrayList();
            caballitos.add(new Caballo(cballos2.get(0).getPosicionInicial_X(),cballos2.get(0).getPosicionInicial_Y(),cballos2.get(0).getNombre()));
            caballitos.add(new Caballo(cballos2.get(1).getPosicionInicial_X(),cballos2.get(1).getPosicionInicial_Y(),cballos2.get(1).getNombre()));
            caballitos.add(new Caballo(cballos2.get(2).getPosicionInicial_X(),cballos2.get(2).getPosicionInicial_Y(),cballos2.get(2).getNombre()));
            caballitos.add(new Caballo(cballos2.get(3).getPosicionInicial_X(),cballos2.get(3).getPosicionInicial_Y(),cballos2.get(3).getNombre()));
            
            EstSucesor = new Estado(caballitos, esta.getR(), cvalorHeuristico, esta.getProfundidad(),EstadoActual );
            Estados.add(EstSucesor);

//            tabler.setCaballos(cballos2);
            
            
        }
        


        //organizar abiertos
        if (bandera == true) {
            
            for (int a = 0; a < abiertos.size(); a++) {
                //System.out.println("cvalorHeuristico <= abiertos.get(a).getValor_Estado()");
                //System.out.println(""+cvalorHeuristico +" <= " + abiertos.get(a).getValor_Estado() +" = " + (cvalorHeuristico <= abiertos.get(a).getValor_Estado()));
                if (  cvalorHeuristico <= abiertos.get(a).getValor_Estado()){
                    
                    //System.out.println("sale de abiertos");
                    
                    abiertos.add(a, EstSucesor);
                    //System.out.println("indice del estado : " + a);
                    //System.out.println("abiertos size: " + abiertos.size());
//                    for (int i = 0; i < 4; i++) {
//                        System.out.println("caballos: "+ Caballos.get(i).getMove());
//                    }
                    return true;
                }
            }
            
            if (abiertos.isEmpty()){
                //System.out.println("sale de abiertos");
                abiertos.add(EstSucesor);
                //System.out.println("indice del estado : " + (abiertos.size()-1));
//                for (int i = 0; i < 4; i++) {
//                    System.out.println("caballos: "+ Caballos.get(i).getMove());
//                }
                return true;
            }
            if (bandera) {
                
                abiertos.add(EstSucesor);
                //System.out.println("cballlo22222: "+abiertos.get(abiertos.size()-1).getCaballos().get(1).getPosicionInicial_X() +", "+abiertos.get(abiertos.size()-1).getCaballos().get(1).getPosicionInicial_Y());
                //System.out.println("indice del estado : " + (abiertos.size()-1));
//                for (int i = 0; i < 4; i++) {
//                    System.out.println("caballos: "+ Caballos.get(i).getMove());
//                }
            }
        }
        
        return false;
    }
    
    private void CambiarEA(){
        
        cerrados.add(EstadoActual);
        //System.out.println("calalala"+abiertos.get(abiertos.size()-1).getCaballos().get(1).getPosicionInicial_X());
        System.out.println("abiertos: "+abiertos.size());
        if (abiertos.size()>0){
            EstadoActual = abiertos.get(abiertos.size()-1);
            System.out.println("Estado Actual: ");
            tabler.setCaballos(EstadoActual.getCaballos());
            System.out.println("Funcion Heuristica EA : " + EstadoActual.getValor_Estado());
            abiertos.remove(abiertos.size()-1);
        }
        
        System.out.println("abiertos: "+abiertos.size());
//        tabler.setCaballos(EstadoActual.getCaballos());
//        for (int i = 0; i < PuntajePos.size(); i++) {
//            for (int j = 0; j < 4; j++) {
//                if (!Caballos.get(j).getMove()) {
//                    if (EstadoActual.getCaballos().get(j).getPosicionInicial_X() == PuntajePos.get(i).x && EstadoActual.getCaballos().get(j).getPosicionInicial_Y() == PuntajePos.get(j).y) {
//                                        punt=false;
//                    }
//                }
//                
//            }
//            
//        }
    }
    public void ImprimirAbiertos(){
        System.out.println("///////////////////////////////////////////////////ABIERTOS///////////////////////////////////////////////////////////////////");
        for (int s = 0; s < abiertos.size(); s++) {
            Estado get = abiertos.get(s);
            System.out.println((s+1)+". "+get.getValor_Estado());
//            System.out.println("profundidad: " + get.getProfundidad());
            tabler.setCaballos(get.getCaballos());
            System.out.println("valor heuristico EA : " + EstadoActual.getValor_Estado());
            
        }
    }
    
    public void imprimirCerrados(){
        
        
System.out.println("///////////////////////////////////////////////////CERRADOS///////////////////////////////////////////////////////////////////");        for (int s = 0; s < cerrados.size(); s++) {
            Estado get = cerrados.get(s);
            System.out.println((s+1)+". "+get.getValor_Estado());
            System.out.println("profundidad: " + get.getProfundidad());
            tabler.setCaballos(get.getCaballos());
            
        }
    }
    
    public void ImprimirAntecesores(){
        System.out.println("///////////////////////////////////////////////////ANTECESORES///////////////////////////////////////////////////////////////////");
        tabler.setCaballos(EstadoActual.getCaballos());
        int in=0;
        Estado Es = EstadoActual.getEstadoAntecesor();
        tabler.setCaballos(Es.getCaballos());
        while (in!=10) {
//                System.out.println("Es; "+Es.getValor_Estado());
            Es = Es.getEstadoAntecesor();
            
            if (Es != null) {
//                System.out.println(""+Es.getValor_Estado());
                System.out.println("");
                tabler.setCaballos(Es.getCaballos());
                System.out.println("");
            }else{
                System.out.println("isnull");
                return;
            }
            in++;

        }
    }
    
    public void realizarEjercicio(Rey R1){
        int Rey_X = R1.getPosicionInicial_X();
        int Rey_Y = R1.getPosicionInicial_Y();
        TableroGrafico tableroinicial = new TableroGrafico(EstadoActual.getCaballos(), EstadoActual.getR());
        int contra=1;
        if (( (Rey_X == 8 && Rey_Y == 1)  || (Rey_X == 1 && Rey_Y == 1) || (Rey_X == 8 && Rey_Y == 8) || (Rey_X == 1 && Rey_Y == 8) )) {
            while(EstadoActual.getValor_Estado()<130){
                CrearEstadosSucesores(EstadoActual);
                contra++;
                if (contra>40) {
                    return;
                }
 
            }
            TableroGrafico tablerofinal = new TableroGrafico(EstadoActual.getCaballos(), EstadoActual.getR());
            tabler.setCaballos(EstadoActual.getCaballos());
            System.out.println(".valor heuristico: "+EstadoActual.getValor_Estado());
            //System.out.println("profundidad EA: " + EstadoActual.getProfundidad());
//            System.out.println("Caballo 1: " + Math.abs(EstadoActual.getR().getPosicionInicial_X()-(EstadoActual.getCaballos().get(0).getPosicionInicial_X())) + " , " + Math.abs(EstadoActual.getR().getPosicionInicial_Y()-(EstadoActual.getCaballos().get(0).getPosicionInicial_Y())));
//            System.out.println("Caballo 2: " + Math.abs(EstadoActual.getR().getPosicionInicial_X()-(EstadoActual.getCaballos().get(1).getPosicionInicial_X())) + " , " + Math.abs(EstadoActual.getR().getPosicionInicial_Y()-(EstadoActual.getCaballos().get(1).getPosicionInicial_Y())));
//            System.out.println("Caballo 3: " + Math.abs(EstadoActual.getR().getPosicionInicial_X()-(EstadoActual.getCaballos().get(2).getPosicionInicial_X())) + " , " + Math.abs(EstadoActual.getR().getPosicionInicial_Y()-(EstadoActual.getCaballos().get(2).getPosicionInicial_Y())));
//            System.out.println("Caballo 4: " + Math.abs(EstadoActual.getR().getPosicionInicial_X()-(EstadoActual.getCaballos().get(3).getPosicionInicial_X())) + " , " + Math.abs(EstadoActual.getR().getPosicionInicial_Y()-(EstadoActual.getCaballos().get(3).getPosicionInicial_Y())));
            int totalx= Math.abs(EstadoActual.getR().getPosicionInicial_X()-(EstadoActual.getCaballos().get(0).getPosicionInicial_X()))+
                        Math.abs(EstadoActual.getR().getPosicionInicial_X()-(EstadoActual.getCaballos().get(1).getPosicionInicial_X()))+
                        Math.abs(EstadoActual.getR().getPosicionInicial_X()-(EstadoActual.getCaballos().get(2).getPosicionInicial_X()))+
                        Math.abs(EstadoActual.getR().getPosicionInicial_X()-(EstadoActual.getCaballos().get(3).getPosicionInicial_X()));
            int totaly= Math.abs(EstadoActual.getR().getPosicionInicial_Y()-(EstadoActual.getCaballos().get(0).getPosicionInicial_Y()))+
                        Math.abs(EstadoActual.getR().getPosicionInicial_Y()-(EstadoActual.getCaballos().get(1).getPosicionInicial_Y()))+
                        Math.abs(EstadoActual.getR().getPosicionInicial_Y()-(EstadoActual.getCaballos().get(2).getPosicionInicial_Y()))+
                        Math.abs(EstadoActual.getR().getPosicionInicial_Y()-(EstadoActual.getCaballos().get(3).getPosicionInicial_Y()));
            System.out.println("Total Movimientos: "+contra);
        }else{
            
            while(EstadoActual.getValor_Estado()<150){
                contra++;
                CrearEstadosSucesores(EstadoActual);
                System.out.println("contra: "+contra);
                
                if (contra>40) {
                    return;
                }
            }
            TableroGrafico tablerofinal = new TableroGrafico(EstadoActual.getCaballos(), EstadoActual.getR());
            tabler.setCaballos(EstadoActual.getCaballos());
            System.out.println(".valor heuristico: "+EstadoActual.getValor_Estado());
            //System.out.println("profundidad EA: " + EstadoActual.getProfundidad());
//            System.out.println("Caballo 1: " + Math.abs(EstadoActual.getR().getPosicionInicial_X()-(EstadoActual.getCaballos().get(0).getPosicionInicial_X())) + " , " + Math.abs(EstadoActual.getR().getPosicionInicial_Y()-(EstadoActual.getCaballos().get(0).getPosicionInicial_Y())));
//            System.out.println("Caballo 2: " + Math.abs(EstadoActual.getR().getPosicionInicial_X()-(EstadoActual.getCaballos().get(1).getPosicionInicial_X())) + " , " + Math.abs(EstadoActual.getR().getPosicionInicial_Y()-(EstadoActual.getCaballos().get(1).getPosicionInicial_Y())));
//            System.out.println("Caballo 3: " + Math.abs(EstadoActual.getR().getPosicionInicial_X()-(EstadoActual.getCaballos().get(2).getPosicionInicial_X())) + " , " + Math.abs(EstadoActual.getR().getPosicionInicial_Y()-(EstadoActual.getCaballos().get(2).getPosicionInicial_Y())));
//            System.out.println("Caballo 4: " + Math.abs(EstadoActual.getR().getPosicionInicial_X()-(EstadoActual.getCaballos().get(3).getPosicionInicial_X())) + " , " + Math.abs(EstadoActual.getR().getPosicionInicial_Y()-(EstadoActual.getCaballos().get(3).getPosicionInicial_Y())));
            int totalx= Math.abs(EstadoActual.getR().getPosicionInicial_X()-(EstadoActual.getCaballos().get(0).getPosicionInicial_X()))+
                        Math.abs(EstadoActual.getR().getPosicionInicial_X()-(EstadoActual.getCaballos().get(1).getPosicionInicial_X()))+
                        Math.abs(EstadoActual.getR().getPosicionInicial_X()-(EstadoActual.getCaballos().get(2).getPosicionInicial_X()))+
                        Math.abs(EstadoActual.getR().getPosicionInicial_X()-(EstadoActual.getCaballos().get(3).getPosicionInicial_X()));
            int totaly= Math.abs(EstadoActual.getR().getPosicionInicial_Y()-(EstadoActual.getCaballos().get(0).getPosicionInicial_Y()))+
                        Math.abs(EstadoActual.getR().getPosicionInicial_Y()-(EstadoActual.getCaballos().get(1).getPosicionInicial_Y()))+
                        Math.abs(EstadoActual.getR().getPosicionInicial_Y()-(EstadoActual.getCaballos().get(2).getPosicionInicial_Y()))+
                        Math.abs(EstadoActual.getR().getPosicionInicial_Y()-(EstadoActual.getCaballos().get(3).getPosicionInicial_Y()));
            System.out.println("Total Movimientos: "+contra);
            
        }
    }        
    public static void main(String[] args) {

    
    
        //Caballo C1 = new Caballo(1, 3, "C1");
        
//      Caballo C2 = new Caballo(2, 1, "C2");

        //Caballo C2 = new Caballo(2, 4, "C2");
//      Caballo C3 = new Caballo(3, 1, "C3");



        IngresarDatos ingreso = new IngresarDatos();
//        Caballo C1 = new Caballo(1, 3, "C1");
//        Caballo C2 = new Caballo(2, 1, "C2");
//        Caballo C3 = new Caballo(1, 4, "C3");
//        Caballo C4 = new Caballo(3, 1, "C4");
//        Rey     R = new Rey(8, 4);
//        Ajedrez Funcion = new Ajedrez(C1, C2, C3, C4, R);
//        Funcion.ImprimirAntecesores();
//        Funcion.imprimirCerrados();
//        Funcion.ImprimirAbiertos();
        

//        Caballo C1 = new Caballo(1, 1, "C1");
//        Caballo C2 = new Caballo(1, 2, "C2");
//        Caballo C3 = new Caballo(1, 3, "C3");
//        Caballo C4 = new Caballo(1, 4, "C4");
//        Rey     R = new Rey(1, 5);
//        Ajedrez Funcion = new Ajedrez(C1, C2, C3, C4, R);
//        Rey     R = new Rey(8, 1);



    
        
    
    
    
    }
    
}
