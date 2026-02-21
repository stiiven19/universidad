package avion;


import avion.Avion;
import avion.Silla;
import avion.Silla.Clase;
import avion.Silla.Ubicacion;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Byron
 */
public class AppAvion {
    
    public static void main(String[]args){
        Scanner leer =new Scanner(System.in);
        Avion avion = new Avion();
        String name;
        String cc;
        Silla[] sillasEjecu;
        Silla[] sillasEcono;
        int op1=1;
        do {;
            System.out.println("****************Aplicacion Avion******************");
            System.out.println("");
            System.out.println("1. Asignar Silla a un Pasajero");
            System.out.println("2. desasignar silla ");
            System.out.println("3. Buscar Pasajero");
            System.out.println("4. Buscar Disponibilidad de silla");
            System.out.println("5. Consultar todas las sillas Ocupadas");
            System.out.println("6. Consultar todas las sillas disponibles");
            System.out.println("7. Salir");
            System.out.println("");
            System.out.println("***************************************************");
            System.out.print("opcion : ");
            int op2;
            op2=leer.nextInt(); 
            switch (op2) {//sw 1
                case 1://Asignar Silla a un Pasajero
                    do {  
                        System.out.println("");
                        System.out.println("Sillas Ejecutivas Libres : "+avion.obtenerEjecutivasLibres());
                        System.out.println("Sillas Economicas Libres : "+avion.obtenerEconomicasLibres());
                        System.out.println("");
                        System.out.println("*****************************************************");
                        System.out.println("             1._Asignar_Silla_a_un_Pasajero          ");
                        System.out.println("");
                        System.out.println("1. Desea un numero de silla especifico?");
                        System.out.println("2. Desea ingresar los datos de la silla que prefiere?");
                        System.out.println("3. Volver");
                        System.out.println("4. Salir y Guardar");
                        System.out.println("");
                        System.out.println("******************************************************");
                        System.out.print("opcion : ");
                        int op22;
                        op22=leer.nextInt();
                        do{
                            switch (op22) {
                                case 1:
                                    do{
                                        System.out.println("");
                                        System.out.println("Sillas Ejecutivas Libres : "+avion.obtenerEjecutivasLibres());
                                        System.out.println("Sillas Economicas Libres : "+avion.obtenerEconomicasLibres());
                                        System.out.println("");
                                        System.out.println("**************************************************");
                                        System.out.println("           1._numero_de_silla_especifico          ");
                                        System.out.println("");
                                        System.out.println("Ingrese el numero de silla que desesa");
                                        System.out.print("numero : ");
                                        int numero;
                                        numero=leer.nextInt();
                                        do {
                                            if (numero<=0 || numero>=51) {
                                                System.out.println("");
                                                System.out.println("ERROR");
                                                System.out.println("digite un numero valido");
                                                System.out.print("numero : ");
                                                numero=leer.nextInt();
                                            }
                                        } while (numero<=0 || numero>=51);
                                        
                                        System.out.println("");
                                        int dispo=avion.obtenerDisponibilidadSillaN(numero);
                                        if (dispo==0) {
                                            System.out.println("la silla numero : "+numero+" esta desocupada");
                                            int op222=3;
                                            do {
                                                System.out.println("");
                                                System.out.println("*************************************************");
                                                System.out.println("Desea asignarse la silla numero : "+numero+"?");
                                                System.out.println("");
                                                System.out.println("1. si");
                                                System.out.println("2. no");
                                                System.out.println("");
                                                System.out.print("opcion : ");
                                                op222=leer.nextInt();
                                                System.out.println("");
                                                System.out.println("*************************************************");
                                                System.out.println("");
                                                switch (op222) {
                                                    case 1:
                                                        System.out.println("");
                                                        System.out.println("************************************************");
                                                        System.out.println("          1._Asignar_Silla_a_un_Pasajero        ");
                                                        System.out.println("");
                                                        System.out.println("Por favor, ingrese sus datos ");
                                                        System.out.println("");
                                                        System.out.println("NOMBRE COMPLETO");
                                                        System.out.println("");
                                                        System.out.print("Nombre: ");name=leer.next();
                                                        System.out.println("");
                                                        System.out.println("Cedula de Ciudadania");
                                                        System.out.println("");
                                                        System.out.println("tenga en cuenta que su CC debe tener 10 digitos");
                                                        System.out.println("");
                                                        System.out.print("Ceduca de C. : ");cc=leer.next();
                                                        System.out.println("");
                                                        do {
                                                            if (cc.length()!=10) {
                                                                System.out.println("");
                                                                System.out.println("Error. ingresar una cedula valida");
                                                                System.out.print("Ceduca de C. : ");cc=leer.next();
                                                                System.out.println("");
                                                            }
                                                        } while (cc.length()!=10);
                                                        pasajero pasajero=new pasajero(cc,name);
                                                        if (cc.length()==10) {
                                                            if (numero<=8) {
                                                                System.out.println("numero  : "+numero);
                                                                avion.asignarSilla(numero,Silla.Clase.EJECUTIVA,avion.obtenerUbicaciondeN(numero), pasajero);
                                                            }else{
                                                                avion.asignarSilla(numero,Silla.Clase.ECONOMICA, avion.obtenerUbicaciondeN(numero), pasajero);
                                                            }
                                                            op222=2;
                                                            op22=4;
                                                        }
                                                        break;
                                                    case 2:
                                                        op222=2;
                                                        op22=4;
                                                        System.out.println("");
                                                        System.out.println("vuelves al menu anterior");
                                                        break;
                                                    default:
                                                        op222=3;
                                                        System.out.println("");
                                                        System.out.println("ERROR");
                                                        System.out.println("digite una opcion valida");
                                                        System.out.println("");
                                                        break;
                                                }
                                            } while (op222==3);
                                        }else{
                                            if (dispo==1) {
                                                System.out.println("la silla numero : "+numero+" esta ocupada");
                                                int op223=3;
                                                do {
                                                    System.out.println("");
                                                    System.out.println("***********************************");
                                                    System.out.println("");
                                                    System.out.println("1. Digitar otro numero");
                                                    System.out.println("2. Volver");
                                                    System.out.println("");
                                                    System.out.println("************************************");
                                                    System.out.println("");
                                                    System.out.print("opcion : ");
                                                    op223=leer.nextInt();
                                                    switch (op223) {
                                                        case 1:
                                                            op223=2;
                                                            op22=1;
                                                            break;
                                                        case 2:
                                                            op22=4;
                                                            break;
                                                        default:
                                                            System.out.println("");
                                                            System.out.println("ERROR");
                                                            System.out.println("digite una opcion valida");
                                                            System.out.println("");
                                                            op223=3;
                                                            break;
                                                    }
                                                } while (op223==3);            
                                            }
                                        }
                                    }while (op22!=4);
                                    break;
                                case 2://sw 2
                                    Ubicacion ubica=null;
                                    System.out.println("");
                                    System.out.println("*********************************************");
                                    System.out.println("         2. Asignar datos de la silla        ");
                                    System.out.println("");
                                    System.out.println("1. Digite la Clase de silla");
                                    System.out.println("");
                                    System.out.println("  -Contamos con sillas Ejecutivas y Economicas");
                                    System.out.println("  1. Ejecutivas  :  Libres : "+avion.obtenerEjecutivasLibres());
                                    System.out.println("  2. Economicas  :  Libres : "+avion.obtenerEconomicasLibres());
                                    System.out.println("");
                                    System.out.print("Clase : ");
                                    int clase=leer.nextInt();
                                    System.out.println("");
                                    System.out.println("************************************************");
                                    System.out.println("");
                                    
                                    Clase cla = null;
                                    do {
                                        if (clase!=1 & clase !=2) {
                                            System.out.println("");
                                            System.out.println("ERROR");
                                            System.out.println("digite una Clase valida");
                                            System.out.println("");
                                            System.out.print("Clase : ");
                                            clase=leer.nextInt();
                                            System.out.println("");
                                        } 
                                    } while (clase!= 1 & clase!=2);
                                    boolean dis=false;
                                    if (clase==1) {
                                        cla=Clase.EJECUTIVA;
                                        System.out.println("");
                                        System.out.println("*********************************************");
                                        System.out.println("               Silla Ejecutiva               ");
                                        System.out.println("");
                                        System.out.println("2. Digite La Ubicacion que desea");
                                        System.out.println("");
                                        System.out.println("  -Contamos con la ubicacion Ventana y Pasillo");
                                        System.out.println("  1. Ventana  :  Libres : "+avion.obtenerUbicacionEjeVentanaLibres());
                                        System.out.println("  2. Pasillo  :  Libres : "+avion.obtenerUbicacionEjePasilloLibres());
                                        System.out.println("");
                                        System.out.print("Ubicacion : ");
                                        int ubicacion1=leer.nextInt();
                                        System.out.println("");
                                        do {
                                            if (ubicacion1!=1 & ubicacion1 !=2) {
                                                System.out.println("");
                                                System.out.println("ERROR");
                                                System.out.println("digite una Ubicacion valida");
                                                System.out.println("");
                                                System.out.print("ubicacion : ");
                                                ubicacion1=leer.nextInt();
                                                System.out.println("");
                                            } 
                                        } while (ubicacion1!= 1 & ubicacion1!=2);
                                        dis=false;
                                        if (ubicacion1==1 & avion.obtenerUbicacionEjeVentanaLibres()!=0) {
                                            ubica=Ubicacion.VENTANA;
                                            dis=true;
                                        } else {if(ubicacion1==2 & avion.obtenerUbicacionEjePasilloLibres()!=0){
                                            ubica=Ubicacion.PASILLO;
                                            dis=true;
                                            }
                                        }
                                    } else {if(clase==2)
                                        cla=Clase.ECONOMICA;
                                        System.out.println("");
                                        System.out.println("********************************************");
                                        System.out.println("                Silla Economica             ");
                                        System.out.println("");
                                        System.out.println("2. Digite La Ubicacion que desea");
                                        System.out.println("");
                                        System.out.println("  -Contamos con la ubicacion Ventana, Central y Pasillo");
                                        System.out.println("  1. Ventana  :  Libres : "+avion.obtenerUbicacionEcoVentanaLibres());
                                        System.out.println("  2. Central  :  Libres : "+avion.obtenerUbicacionEcoCentralLibres());
                                        System.out.println("  3. Pasillo  :  Libres : "+avion.obtenerUbicacionEcoPasilloLibres());
                                        System.out.println("");
                                        System.out.print("Ubicacion : ");int ubicacion1=leer.nextInt();
                                        System.out.println("");
                                        System.out.println("**********************************************");
                                        System.out.println("");
                                        do {
                                            if (ubicacion1!=1 & ubicacion1 !=2 & ubicacion1!=3) {
                                                System.out.println("");
                                                System.out.println("ERROR");
                                                System.out.println("digite una Ubicacion valida");
                                                System.out.println("");
                                                System.out.print("ubicacion : ");
                                                ubicacion1=leer.nextInt();
                                                System.out.println("");
                                            } 
                                        } while (ubicacion1!= 1 & ubicacion1!=2 & ubicacion1!=3);
                                        dis=false;
                                        if (ubicacion1==1 & avion.obtenerUbicacionEcoVentanaLibres()!=0) {
                                            ubica=Ubicacion.VENTANA;
                                            dis=true;
                                        } else {
                                            if(ubicacion1==2 & avion.obtenerUbicacionEcoCentralLibres()!=0){
                                            ubica=Ubicacion.CENTRAL;
                                            dis=true;
                                            }else{
                                                if (ubicacion1==3 & avion.obtenerUbicacionEcoPasilloLibres()!=0) {
                                                    ubica=Ubicacion.PASILLO;
                                                    dis=true;
                                                }
                                            }
                                        }
                                    }
                                    if(dis==true){
                                    System.out.println("");
                                    System.out.println("********************************************");
                                    System.out.println("Por favor, ingrese sus datos ");
                                    System.out.println("");
                                    System.out.println("NOMBRE COMPLETO");
                                    System.out.println("");
                                    System.out.print("Nombre: ");name=leer.next();
                                    System.out.println("");
                                    System.out.println("Cedula de Ciudadania");
                                    System.out.println("");
                                    System.out.println("tenga en cuenta que su CC debe tener 10 digitos");
                                    System.out.println("");
                                    System.out.print("Ceduca de C. : ");cc=leer.next();
                                    System.out.println("");
                                    System.out.println("*********************************************");
                                    System.out.println("");
                                    do {
                                        if (cc.length()!=10) {
                                            System.out.println("");
                                            System.out.println("Error. ingresar una cedula valida");
                                            System.out.print("Ceduca de C. : ");cc=leer.next();
                                            System.out.println("");
                                        }
                                    } while (cc.length()!=10);
                                    pasajero pasa=new pasajero(cc,name);
                                    avion.asignarSilla(0, cla, ubica, pasa);
                                    }else{
                                        System.out.println("");
                                        System.out.println("________________________________________");
                                        System.out.println("ERROR");
                                        System.out.println("No hay Sillas de esta ubicacion libres");
                                        System.out.println("_________________________________________");
                                    }
                                    op22=4;
                                    break;
                                case 3:
                                    op2=4;
                                    op22=4;
                                    break;
                                case 4:
                                    op22=4;
                                    op2=4;
                                    op1=7;
                                    break;
                                default:
                                    System.out.println("");
                                    System.out.println("ERROR");
                                    System.out.println("digite una opcion valida");
                                    System.out.println("");
                                    op22=4;
                                    break;
                            }
                        }while (op22!=4);
                    } while (op2 !=4); 
                    break;
                case 2://Asignar disponibilidad de silla
                    int op3=0;
                    do {
                        
                        System.out.println("");
                        System.out.println("******************************************");
                        System.out.println("          2._Desasignar_Silla              ");
                        System.out.println("");
                        System.out.println("1. Buscar silla por los datos del Pasajero");
                        System.out.println("2. Buscar silla por el numero");
                        System.out.println("3. Volver");
                        System.out.println("4. Salir y Guardar");
                        System.out.println("");
                        System.out.print("opcion : ");
                        int op32=leer.nextInt();
                        System.out.println("");
                        System.out.println("*******************************************");
                        do {
                            Silla sla;
                            switch (op32) {
                                case 1://buscar silla por los datos del pasajero
                                    System.out.println("");
                                    System.out.println("********************************************");
                                    System.out.println("              1._Buscar_silla                ");
                                    System.out.println("");
                                    System.out.println("Por favor, ingrese sus datos ");
                                    System.out.println("");
                                    System.out.println("NOMBRE COMPLETO");
                                    System.out.println("");
                                    System.out.print("Nombre: ");name=leer.next();
                                    System.out.println("");
                                    System.out.println("Cedula de Ciudadania");
                                    System.out.println("");
                                    System.out.println("tenga en cuenta que su CC debe tener 10 digitos");
                                    System.out.println("");
                                    System.out.print("Ceduca de C. : ");cc=leer.next();
                                    System.out.println("");
                                    System.out.println("*********************************************");
                                    System.out.println("");
                                    do {
                                        if (cc.length()!=10) {
                                            System.out.println("");
                                            System.out.println("Error. ingresar una cedula valida");
                                            System.out.print("Ceduca de C. : ");cc=leer.next();
                                            System.out.println("");
                                        }
                                    } while (cc.length()!=10);
                                    pasajero pasaj=new pasajero(cc,name);
                                    
                                    sla=avion.buscarPasajero(0, pasaj);
                                    if (sla.sillaAsignada()==true) {
                                        avion.desasignarSilla(pasaj);
                                    } else {
                                        System.out.println("");
                                        System.out.println("ERROR");
                                        System.out.println("La Silla Numero : "+sla.darNumero()+" de la Clase : "+sla.darClase()+" y en la Ubicacion : "+sla.darUbicacion());
                                        System.out.println("esta Libre");
                                        System.out.println("");
                                    }
                                    op32=4;
                                    break;
                                case 2://buscar silla por el numero
                                    System.out.println("");
                                    System.out.println("**************************************************");
                                    System.out.println("           1._Desasignar_numero_de_silla_          ");
                                    System.out.println("");
                                    System.out.println("Ingrese el numero de silla para desasignar");
                                    System.out.print("numero : ");
                                    int numero1;
                                    numero1=leer.nextInt();
                                    System.out.println("****************************************************");
                                    System.out.println("");
                                    do {
                                        if (numero1<=0 || numero1>=51) {
                                            System.out.println("");
                                            System.out.println("ERROR");
                                            System.out.println("digite un numero valido");
                                            System.out.print("numero : ");
                                            numero1=leer.nextInt();
                                        }
                                    } while (numero1<=0 || numero1>=51);
                                    System.out.println("");
                                    int dispo1=avion.obtenerDisponibilidadSillaN(numero1);
                                    if (dispo1==1) {
                                        System.out.println("la Silla Numero : "+numero1+" esta Ocupada");
                                        int op322=3;
                                        do {
                                            System.out.println("");
                                            System.out.println("*************************************************");
                                            System.out.println("Desea Desasignar la silla numero : "+numero1+"?");
                                            System.out.println("");
                                            System.out.println("1. si");
                                            System.out.println("2. no");
                                            System.out.println("");
                                            System.out.print("opcion : ");
                                            op322=leer.nextInt();
                                            System.out.println("");
                                            System.out.println("*************************************************");
                                            System.out.println("");
                                            switch (op322) {
                                                case 1:
                                                    pasajero pajero=null;
                                                    sla=avion.buscarPasajero(numero1, pajero);
                                                    pajero=sla.darPasajero();
                                                    avion.desasignarSilla(pajero);
                                                    break;
                                                case 2:
                                                    op322=2;
                                                    op32=4;
                                                    break;
                                                default:
                                                    System.out.println("");
                                                    System.out.println("ERROR");
                                                    System.out.println("digite una opcion valida");
                                                    System.out.println("");
                                                    break;          
                                            }
                                        }while(op322==3);
                                    }else{
                                        if(dispo1==0){
                                            System.out.println("ERROR");
                                            System.out.println("la silla numero : "+numero1+" Libre");
                                            int op323=3;
                                            do {
                                                System.out.println("");
                                                System.out.println("***********************************");
                                                System.out.println("");
                                                System.out.println("1. Digitar otro numero");
                                                System.out.println("2. Volver");
                                                System.out.println("");
                                                System.out.println("************************************");
                                                System.out.println("");
                                                System.out.print("opcion : ");
                                                op323=leer.nextInt();
                                                switch (op323) {
                                                    case 1:
                                                        op323=2;
                                                        op32=2;
                                                        break;
                                                    case 2:
                                                        op32=4;
                                                        break;
                                                    default:
                                                        System.out.println("");
                                                        System.out.println("ERROR");
                                                        System.out.println("digite una opcion valida");
                                                        System.out.println("");
                                                        op323=3;
                                                        break;
                                                }
                                            } while (op323==3);            
                                        }
                                    }
                                    op32=4;
                                    break;
                                case 3:
                                    op32=4;
                                    op3=1;
                                    break;
                                case 4:
                                    op32=4;
                                    op3=1;
                                    op1=7;
                                    break;
                                default:
                                    System.out.println("");
                                    System.out.println("ERROR");
                                    System.out.println("digite una opcion valida");
                                    System.out.println("");
                                    op32=4;
                                    break;
                            }
                        } while (op32!=4);
                    } while (op3==0);
                    break;
                case 3://Buscar Pasajero
                    System.out.println("");
                    System.out.println("*****************************************");
                    System.out.println("            3._Buscar_Pasajero           ");
                    System.out.println("");
                    System.out.println("Por Favor, Ingresar datos del Pasajero");
                    System.out.println("");
                    System.out.println("NOMBRE COMPLETO");
                    System.out.println("");
                    System.out.print("Nombre: ");name=leer.next();
                    System.out.println("");
                    System.out.println("Cedula de Ciudadania");
                    System.out.println("");
                    System.out.println("tenga en cuenta que su CC debe tener 10 digitos");
                    System.out.println("");
                    System.out.print("Ceduca de C. : ");cc=leer.next();
                    System.out.println("");
                    System.out.println("*********************************************");
                    System.out.println("");
                    do {
                        if (cc.length()!=10) {
                            System.out.println("");
                            System.out.println("Error. ingresar una cedula valida");
                            System.out.print("Ceduca de C. : ");cc=leer.next();
                            System.out.println("");
                        }
                    } while (cc.length()!=10);
                    pasajero pasaj2=new pasajero(cc,name);
                    Silla sla1;
                    sla1=avion.buscarPasajero(0, pasaj2);
                    if (sla1!=null) {
                        System.out.println("");
                        System.out.println("_______________________________________________");
                        System.out.println("El Pasajero : "+sla1.darPasajero().darNombre()+" Con Cedula de C : "+sla1.darPasajero().darCedula());
                        System.out.println("Esta Ubicado en la Silla Numero : "+sla1.darNumero());
                        System.out.println("En la Clase : "+sla1.darClase()+" y Ubicacion : "+sla1.darUbicacion());
                        System.out.println("_______________________________________________");
                        System.out.println("");
                    } else {
                        System.out.println("El Pasajero NO esta Asignado a Este Avion");
                        System.out.println("");
                    }
                    break;
                case 4://Buscar Disponibilidad de silla
                    int op4=0;
                    do {
                        System.out.println("");
                        System.out.println("************************************************************");
                        System.out.println("             4._Buscar_Disponibilidad_De_Sillas             ");
                        System.out.println("");
                        System.out.println("_____________________________________________________________");
                        System.out.println(" - Ejecutivas  :  Libres : "+avion.obtenerEjecutivasLibres());
                        System.out.println("    - Ventana  :  Libres : "+avion.obtenerUbicacionEjeVentanaLibres());
                        System.out.println("    - Pasillo  :  Libres : "+avion.obtenerUbicacionEjePasilloLibres());
                        System.out.println(" - Economicas  :  Libres : "+avion.obtenerEconomicasLibres());
                        System.out.println("    - Ventana  :  Libres : "+avion.obtenerUbicacionEcoVentanaLibres());
                        System.out.println("    - Central  :  Libres : "+avion.obtenerUbicacionEcoCentralLibres());
                        System.out.println("    - Pasillo  :  Libres : "+avion.obtenerUbicacionEcoPasilloLibres());
                        System.out.println("______________________________________________________________");
                        System.out.println("");
                        System.out.println("Desea Ingresar un numero de Silla a buscar");
                        System.out.println("");
                        System.out.println("1. si");
                        System.out.println("2. no");
                        System.out.println("3. Volver");
                        System.out.println("");
                        System.out.print("opcion : ");
                        op4=leer.nextInt();
                        System.out.println("*************************************************************");
                        System.out.println("");
                        switch (op4) {
                            case 1:
                                System.out.println("**********************************");
                                System.out.println("Por favor, Ingresar Numero");
                                System.out.print("Numero : ");
                                int numero3=leer.nextInt();
                                System.out.println("");
                                System.out.println("**********************************");
                                int dispon1=avion.obtenerDisponibilidadSillaN(numero3);
                                if (dispon1==0) {
                                    System.out.println("");
                                    System.out.println("La Silla Numero : "+numero3+" Esta Libre");
                                    System.out.println("");
                                } else {
                                    if (dispon1==1) {
                                     System.out.println("");
                                        System.out.println("La Silla Numero : "+numero3+" Esta Ocupada");
                                    }
                                }
                                op4=1;
                                break;
                            case 2:
                                System.out.println("");
                                System.out.println("Vuelves Al Menu Anterior");
                                System.out.println("");
                                break;
                            case 3:
                                op4=3;
                                break;
                            default:
                                System.out.println("");
                                System.out.println("ERROR");
                                System.out.println("digite una opcion valida");
                                System.out.println("");
                                op4=0;
                                break;
                        }
                    } while (op4==0);
                    break;//Consultar todas las sillas Ocupadas
                case 5:
                    System.out.println("");
                    System.out.println("********************************************");
                    System.out.println("          Mostrar Sillas Ocupadas            ");
                    System.out.println("");
                    System.out.println("Sillas Ejecutivas Ocupadas : "+avion.contarSillasEjecutivasOcupadas());
                    System.out.println("Sillas Economicas Ocupadas : "+avion.contarSillasEconomicasOcupadas());
                    System.out.println("Porcentaje de Ocupacion : "+avion.calcularPorcentajeOcupacion());
                    System.out.println("");
                    sillasEjecu=avion.obtenerSillasEjecutivas();
                    sillasEcono=avion.obtenerSillasEconomicas();
                    System.out.println        ("                  SILLAS_EJECUTIVAS                   ");
                    for (int i = 0; i < sillasEjecu.length; i++) {
                        Silla silla = sillasEjecu[i];
                        if (silla.sillaAsignada()==true) {
                            System.out.println("_______________________________________________________");
                            System.out.println("");
                            System.out.println("Silla Numero : "+silla.darNumero()+" Clase : "+silla.darClase()+" Ubicacion : "+silla.darUbicacion());
                            System.out.println("Esta Asignada al Pasajero : "+silla.darPasajero().darNombre()+" Con Cedula de C. : "+silla.darPasajero().darCedula());
                            System.out.println("");
                            System.out.println("________________________________________________________");
                        }
                    }
                    System.out.println        ("                  SILLAS ECONOMICAS                     ");
                    for (int i = 0; i < sillasEcono.length; i++) {
                        Silla silla = sillasEcono[i];
                        if (silla.sillaAsignada()==true) {
                            System.out.println("________________________________________________________");
                            System.out.println("");
                            System.out.println("Silla Numero : "+silla.darNumero()+" Clase : "+silla.darClase()+" Ubicacion : "+silla.darUbicacion());
                            System.out.println("Esta Asignada al Pasajero : "+silla.darPasajero().darNombre()+" Con Cedula de C. : "+silla.darPasajero().darCedula());
                            System.out.println("");
                            System.out.println("________________________________________________________");
                        }
                    }
                    break;
                case 6://Consultar todas las sillas disponibles
                    System.out.println("");double libre=100.00-avion.calcularPorcentajeOcupacion();
                    System.out.println("********************************************");
                    System.out.println("          Mostrar Sillas Ocupadas            ");
                    System.out.println("");
                    System.out.println("Sillas Ejecutivas Libres : "+avion.obtenerEjecutivasLibres());
                    System.out.println("Sillas Economicas Libres : "+avion.obtenerEconomicasLibres());
                    System.out.println("Porcentaje de Libres : "+libre);
                    System.out.println("");
                    sillasEjecu=avion.obtenerSillasEjecutivas();
                    sillasEcono=avion.obtenerSillasEconomicas();
                    System.out.println        ("                  SILLAS_EJECUTIVAS                   ");
                    for (int i = 0; i < sillasEjecu.length; i++) {
                        Silla silla = sillasEjecu[i];
                        if (silla.sillaAsignada()==false) {
                            System.out.println("_______________________________________________________");
                            System.out.println("");
                            System.out.println("Silla Numero : "+silla.darNumero()+" Clase : "+silla.darClase()+" Ubicacion : "+silla.darUbicacion());
                            System.out.println("Esta Libre");
                            System.out.println("");
                            System.out.println("________________________________________________________");
                        }
                    }
                    System.out.println        ("                  SILLAS ECONOMICAS                     ");
                    for (int i = 0; i < sillasEcono.length; i++) {
                        Silla silla = sillasEcono[i];
                        if (silla.sillaAsignada()==false) {
                            System.out.println("________________________________________________________");
                            System.out.println("");
                            System.out.println("Silla Numero : "+silla.darNumero()+" Clase : "+silla.darClase()+" Ubicacion : "+silla.darUbicacion());
                            System.out.println("Esta Libre");
                            System.out.println("");
                            System.out.println("________________________________________________________");
                        }
                    }
                    break;
                case 7://7. Reiniciar Datos
                    System.out.println("");
                    op1=7;
                    break;
                default://menu1
                    System.out.println("");
                    System.out.println("ERROR");
                    System.out.println("digite una opcion valida");
                    System.out.println("");
                    op1=1;
                    break;
            }
        } while (op1==1);
    }
}
