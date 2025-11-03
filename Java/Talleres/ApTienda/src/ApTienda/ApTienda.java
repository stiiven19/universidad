
package ApTienda;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
 
public class ApTienda {

    private static Scanner leer;

	public static void main(String[] args) {
        //Libro l1;
        
        leer = new Scanner(System.in);
        ItemsCompra items=new ItemsCompra();
        
        CarroCompra carro=new CarroCompra();
        ArrayList<Pelicula> cata;//obtiene el catalogo
        ArrayList<Pelicula> ventas;//muestra las venta
        //ItemsCompra items2;
        int opcion = 0, opcion1 =0, opcion2=0;
        int mv2=0;
        int mv3=0;
        int mv4=0;
        
    	while (true) {
    		boolean bandera1 = false;
            System.out.println("______________________________________________________________________");
            System.out.println("*******************BIENVENIDO A LA TIENDA DE PELICULAS*******************")  ;
            System.out.println("");
            System.out.println("-ESCOJA LA OPCION QUE DESEA");
            System.out.println("");
            System.out.println("1. Consultas");
            System.out.println("2. Mostrar Catalogo De Peliculas ");
            System.out.println("3. Hacer una Venta");
            System.out.println("4. Hacer un Pedido");
            System.out.println("5. Mostrar Dinero En Caja");
            System.out.println("6. Salir");
            System.out.println("");
            boolean b5=true;
            while (b5) {
                try {
                    System.out.print("opcion: ");opcion=leer.nextInt();
                    b5=false;
                } catch (InputMismatchException e) {
                    System.err.println("Error \n"
                            + "Digite un Entero");   
                    leer.nextLine();
                }
            }
            System.out.println("________________________________________________________________________");
            System.out.println("");
            mv3=0;
            switch(opcion){
                case 1:
                    while(true){
                    	boolean bandera2 = false;
                        System.out.println("________________________________________");
                        System.out.println("***************CONSULTAS***************");
                        System.out.println("");
                        System.out.println("-ESCOJA LA OPCION QUE DESEA");
                        System.out.println("");
                        System.out.println("1. Consultar Pelicula");
                        System.out.println("2. Consultar las 3 Peliculas Mas Costosos");
                        System.out.println("3. Consultar las 3 Peliculas Mas Economicos");
                        System.out.println("4. Consultar las Ventas");
                        System.out.println("5. Consultar las 3 Peliculas Menos Vendidos");
                        System.out.println("6. Volver al Menu Anterior");
                        System.out.println("7. Salir");
                        System.out.println("");
                        b5 = true;
                        while (b5) {
                            try {
                                System.out.print("opcion: ");opcion1=leer.nextInt();
                                b5=false;
                            } catch (InputMismatchException e) {
                                System.err.println("Error \n"
                                        + "Digite un Entero");   
                                leer.nextLine();
                            }
                        }
                        System.out.println("__________________________________________");
                        System.out.println("");
                        switch (opcion1) {
                            case 1:
                                while(true) { //MENU CONSULTAR LIBRO//opcion1
                                	boolean bandera11=false;
                                    System.out.println("________________________________________");
                                    System.out.println("************CONSULTAR PELICULA************"); 
                                    System.out.println("");
                                    System.out.println("1. Consultar Pelicula por codigo");
                                    System.out.println("2. Consultar Pelicula por Titulo");
                                    System.out.println("3. Volver al Menu Anterior");
                                    System.out.println("4. Salir");
                                    System.out.println("");
                                    b5 = true;
                                    while (b5) {
                                        try {
                                            System.out.print("opcion: ");opcion2=leer.nextInt();
                                            b5=false;
                                        } catch (InputMismatchException e) {
                                            System.err.println("Error \n"
                                                    + "Digite un Entero");   
                                            leer.nextLine();
                                        }
                                    }
                                    System.out.println("_________________________________________");
                                    System.out.println("");
                                    while(true){//opcion2
                                    	boolean bandera111=false;
                                        switch(opcion2){
                                            case 1:
                                                System.out.println("_________________________________________");
                                                System.out.println("*******CONSULTAR PELICULA POR codigo*********");
                                                System.out.println("");
                                                System.out.println("1. Digite el codigo");
                                                System.out.println("2. Cancelar");
                                                String codigo="h";
                                                System.out.print("opcion: ");codigo=leer.next();
                                                System.out.println("__________________________________________");
                                                System.out.println("");
                                                if ("2".equals(codigo)) {
                                                    //opcion2=4;
                                                	bandera111=true;
                                                    System.out.println("");
                                                    System.out.println("vuelves al menu anterior");
                                                    break;
                                                } else {
                                                    items.buscarCodigo(codigo);
                                                }
                                                break;
                                            case 2:
                                                System.out.println("___________________________________________");
                                                System.out.println("*******CONSULTAR PELICULA POR TITULO*********");
                                                System.out.println("");
                                                System.out.println("1. Digite el TITULO");
                                                System.out.println("2. Cancelar");
                                                String titulo;
                                                System.out.print("Titulo : ");titulo=leer.next();
                                                System.out.println("____________________________________________");
                                                System.out.println("");
                                                if("2".equals(titulo)){
                                                	bandera111=true;
                                                    System.out.println("");
                                                    System.out.println("vuelves al menu anterior");
                                                    break;
                                                }else{
                                                    items.buscarTitulo(titulo);  
                                                }
                                                break;
                                            case 3:
                                            	bandera11=true;
                                            	bandera111=true;
                                                opcion=1;
                                                break;
                                            case 4:
                                                //opcion0=1;
                                            	bandera1=true;
                                            	bandera11=true;
                                            	bandera111=true;
                                            	bandera2=true;
                                                opcion=7;
                                                opcion1=7;
                                                break;
                                            default :                            
                                                System.out.println("");
                                                System.out.println("ERROR");
                                                System.out.println("Seleccione Una Opcion Valida");
                                                System.out.println("");
                                                opcion2=4;
                                        }
                                        if (bandera111)break;
                                    }
                                    if (bandera11)break;
                                }
                                break;
                            case 2:
                                System.out.println("__________________________________________________");
                                System.out.println("*******CONSULTAR LAS 3 PELICULAS MAS COSTOSOS*******");
                                items.obtener3MasCostosos();
                                break;
                            case 3:
                                System.out.println("__________________________________________________");
                                System.out.println("*******CONSULTAR LAS 3 PELICULAS MAS ECONOMICOS*******");
                                items.obtenerMasEconomicos();
                                break;
                            case 4:
                                System.out.println("");
                                System.out.println("_________________________________");
                                System.out.println("*******CONSULTAR VENTAS********");
                                items.getVentas();
                                break;
                            case 5:
                                System.out.println("*******CONSULTAR LAS 3 PELICULAS MENOS VENDIDOS*******");
                                break;
                            case 6:
                                bandera2=true;
                                break;
                            case 7:
                            	bandera1=true;
                                bandera2=true;
                                //opcion=6;
                                break;
                            default:
                                System.out.println("");
                                System.out.println("ERROR");
                                System.out.println("Seleccione Una Opcion Valida");
                                System.out.println("");
                                //opcion1=1;
                                break;
                        }
                        if (bandera2)break;
                    }
                    break;
                case 2:
                    System.out.println("_________________________________________");
                    System.out.println("*******MOSTRAR CATALOGO DE PELICULAS********");
                    System.out.println("");
                    System.out.println(items.obtenerCatalogo().size());
                    items.MostrarCatalogo();
                    System.out.println(items.obtenerCatalogo().size());
                    System.out.println("");
                    break;
                case 3://opcion0
                    while(true) {
                    	boolean bandera13=false;
                        int lv;
                        //items2=new ItemsCompra();
                        System.out.println("__________________________________________________");
                        System.out.println("**************CARRITO DE COMPRAS***************");
                        System.out.println("");
                        System.out.println("-Desea Agregar Peliculas al Carro de Compras?");
                        System.out.println("");
                        System.out.println("1. SI");
                        System.out.println("2. NO");
                        System.out.println("");
                        System.out.print("opcion: ");lv=leer.nextInt();
                        System.out.println("__________________________________________________");
                        System.out.println("");
                        do {
                            if (lv!=1 & lv!=2) {
                                System.out.println("");
                                System.out.println("ERROR");
                                System.out.println("Seleccione Una Opcion Valida");
                                System.out.println("");
                                System.out.print("opcion: ");lv=leer.nextInt();
                            }
                        } while (lv!=1 & lv!=2);
                        
                        do {//lv
                            int b=0;
                            int sal=0;
                            if(lv==1){
                                int lv2=1;
                                while(sal==0){
                                    while (b==0) {    
                                        if (lv2==1) {
                                            int opcion223=0;
                                            do{//opcion223=0
                                                int op;
                                                System.out.println("___________________________________________________");
                                                System.out.println("*********AGREGAR PELICULAS A CARRO DE COMPRAS********");
                                                System.out.println("");
                                                System.out.println("1. Agregar con el Titulo de la Pelicula");
                                                System.out.println("2. Agregar con el codigo de la Pelicula");
                                                System.out.println("3. Agregar con el Catalogo de Peliculas");
                                                System.out.println("4. Ya No Deseo Agregar Peliculas");
                                                System.out.println("");
                                                System.out.print("opcion: ");op=leer.nextInt();
                                                System.out.println("____________________________________________________");
                                                System.out.println("");
                                                int h=0;//bandera case 3
                                                do {//op
                                                    switch (op) {//hay que hacer un do
                                                        case 1://1. Agregar con el Titulo del Libro
                                                            System.out.println("");
                                                            System.out.println("__________________");
                                                            System.out.println("Por favor, Digite el Titulo");
                                                            System.out.println("");
                                                            System.out.print("Titulo : ");String c=leer.next();//c=string de agregar por titulo
                                                            System.out.println("___________________");
                                                            System.out.println("");
                                                            int a1;//a1=bandera para averiguar si se ha agregado el libro
                                                            a1=carro.obtenerExixtenciasEnCarro().size();
                                                            carro.agregarTitulo(c);
                                                            if(a1==carro.obtenerExixtenciasEnCarro().size()){
                                                                op=4;
                                                                break;
                                                            }else{
                                                                System.out.println("");
                                                                System.out.println("Se ha agregado la Pelicula con Titulo: "+c+" Al carro de compras");
                                                            }
                                                            op=4;
                                                            break;
                                                        case 2:
                                                            System.out.println("");
                                                            System.out.println("__________________");
                                                            System.out.println("Por favor, Digite el codigo");
                                                            System.out.println("");
                                                            System.out.print("codigo : ");String a=leer.next();
                                                            System.out.println("___________________");
                                                            System.out.println("");
                                                            int a2;
                                                            a2=carro.obtenerExixtenciasEnCarro().size();
                                                            carro.agregarCodigo(a);
                                                            if (a2==carro.obtenerExixtenciasEnCarro().size()) {
                                                                op=4;;
                                                                break;
                                                            } else {
                                                                System.out.println("");
                                                                System.out.println("Se ha agregado la Pelicula con codigo: "+a+" Al carro de compras");
                                                            }
                                                            op=4;
                                                            break;
                                                        case 3:
                                                            if(h==0){
                                                                System.out.println("__________________________________________________");
                                                                System.out.println("*******************CATALOGO*******************");
                                                                System.out.println("");
                                                                items.MostrarCatalogo();
                                                                h=1;
                                                            }
                                                            int mv33=0;
                                                            do{
                                                                System.out.println("__________________________________________________");
                                                                System.out.println("**************Agregar con Catalogo**************");
                                                                System.out.println("");
                                                                System.out.println("1. Digitar El Numero En Lista Para Agregar");
                                                                System.out.println("2. Ya no Deseo Agregar");
                                                                System.out.println("");
                                                                System.out.print("opcion: ");mv4=leer.nextInt();
                                                                System.out.println("___________________________________________________");
                                                                System.out.println("");
                                                                do {
                                                                    switch (mv4) {
                                                                        case 1:
                                                                            System.out.println("");
                                                                            System.out.println("____________________________");
                                                                            System.out.println("Por favor, Digite El Numero En Lista");
                                                                            System.out.println("");
                                                                            int a3;
                                                                            System.out.print("Numero : ");a3=leer.nextInt();
                                                                            System.out.println("____________________________");
                                                                            System.out.println("");
                                                                            int a4;
                                                                            a4=carro.obtenerExixtenciasEnCarro().size();
                                                                            //cata=items.obtenerCatalogo();
                                                                            do {
                                                                                if (a3<=0 || a3>items.obtenerCatalogo().size()) {
                                                                                    System.out.println("");
                                                                                    System.out.println("ERROR");
                                                                                    System.out.println("La Pelicula de Numero En Lista: "+a3+" No Se Encuentra en nuestras exixtencias");
                                                                                    System.out.println("DIGITE UN NUMERO EN LISTA VALIDO");
                                                                                    System.out.print("Numero : ");a3=leer.nextInt();
                                                                                }
                                                                            } while (a3<=0 || a3>items.obtenerCatalogo().size());
                                                                            if (a3>=1 & a3<=items.obtenerCatalogo().size()){
                                                                                carro.agregarCatalogo(a3);
                                                                                if (a4==carro.obtenerExixtenciasEnCarro().size()) {
                                                                                op=4;
                                                                                mv2=0;
                                                                                    System.out.println("no se ha agregado");
                                                                                break;
                                                                                }else{
                                                                                    System.out.println("Se ha agreado la Pelicula : "+items.obtenerCatalogo().get(a3-1).obtenerTitulo() +" con Numero En Lista: "+a3+" Al carro de compras");
                                                                                    mv4=2;
                                                                                }
                                                                            }
                                                                            break;
                                                                        case 2:
                                                                            mv4=2;
                                                                            mv33=1;
                                                                            op=4;
                                                                            break;
                                                                        default:
                                                                            System.out.println("");
                                                                            System.out.println("ERROR");
                                                                            System.out.println("Seleccione Una Opcion Valida");
                                                                            System.out.println(""); 
                                                                            mv4=2;
                                                                            break;
                                                                    }
                                                                } while (mv4!=2);   
                                                            }while(mv33==0);
                                                            break;
                                                        case 4:
                                                            opcion223=1;
                                                            op=4;
                                                            lv2=2;
                                                            b=1;
                                                            break;
                                                        default:
                                                            System.out.println("");
                                                            System.out.println("ERROR");
                                                            System.out.println("Seleccione Una Opcion Valida");
                                                            System.out.println("");
                                                            op=1;

                                                            break;
                                                    }
                                                } while (op !=4);
                                            }while(opcion223==0);
                                        }
                                    }
                                    if (lv2==2){
                                        if (carro.obtenerExixtenciasEnCarro().size()>0){
                                            int opcion4;
                                            int opcion5=0;
                                            do{
                                                System.out.println("");
                                                System.out.println("___________________________________________________________________");
                                                System.out.println("****************************CARRO DE COMPRAS************************");
                                                System.out.println("");
                                                System.out.println("1. Agregar Mas Peliculas");
                                                System.out.println("2. Consultar Las Existencias y el Valor Total en Carro de Compras");
                                                System.out.println("3. Quitar Alguna Existencia de Carro de Compras");
                                                System.out.println("4. Comprar Todas Las Existencias En Carro de Compras");
                                                System.out.println("5. Cancelar Venta");
                                                System.out.println("6. Salir");
                                                System.out.println("");
                                                System.out.print("opcion: ");opcion4=leer.nextInt();
                                                System.out.println("____________________________________________________________________");
                                                System.out.println("");
                                                do {
                                                    switch (opcion4) {
                                                        case 1://1. Agregar Mas Peliculas(regresa al menu de agregar Peliculas
                                                            b=0;
                                                            opcion4=6;
                                                            lv=1;
                                                            sal=0;
                                                            lv2=1;
                                                            opcion5=1;
                                                            break;
                                                        case 2://Consultar Las Existencias y el Valor Total en Carro de Compras
                                                            carro.MostrarCarro();
                                                            System.out.println("");
                                                            System.out.println("Vuelves al Menu Anterior");
                                                            opcion4=6;
                                                            break;
                                                        case 3://Quitar Alguna Existencia de Carro de Compras
                                                            carro.MostrarCarro();int mv5;
                                                            System.out.println("_________________________________");
                                                            System.out.println("1. remover ");
                                                            System.out.println("2. Volver al menu anterior");
                                                            System.out.println("");
                                                            System.out.print("opcion: ");mv5=leer.nextInt();
                                                            System.out.println("_________________________________");
                                                            System.out.println("");
                                                            do {
                                                                if (mv5<=0 || mv5>carro.obtenerExixtenciasEnCarro().size()) {
                                                                    System.out.println("");
                                                                    System.out.println("ERROR");
                                                                    System.out.println("La Pelicula de Numero En Lista: "+mv5+" No Se Encuentra en nuestras exixtencias");
                                                                    System.out.println("DIGITE UN NUMERO EN LISTA VALIDO");
                                                                    System.out.print("Numero : ");mv5=leer.nextInt();
                                                                }
                                                            } while (mv5<=0 || mv5>carro.obtenerExixtenciasEnCarro().size());
                                                            switch (mv5) {
                                                                case 1://3. Quitar Alguna Existencia de Carro de Compras
                                                                    int n;
                                                                    System.out.println("_______________________________________");
                                                                    System.out.println("Digite el numero en lista para remover");
                                                                    System.out.println("");
                                                                    System.out.print("Numero : ");n=leer.nextInt();
                                                                    System.out.println("_______________________________________");
                                                                    System.out.println("");
                                                                    carro.quitarExixtencias(n);
                                                                    break;
                                                                case 2://volver al menu anterior
                                                                    opcion4=6;
                                                                    break;
                                                                default:
                                                                    System.out.println("");
                                                                    System.out.println("ERROR");
                                                                    System.out.println("Seleccione Una Opcion Valida");
                                                                    System.out.println("");      
                                                                    opcion4=6;
                                                                    opcion5=0;
                                                                    break;
                                                            }
                                                            break;
                                                        case 4://Comprar Todas Las Existencias En Carro de Compras
                                                            carro.HacerVentasDelCarroDeCompras();
                                                            sal=1;
                                                            lv=2;
                                                            opcion4=6;
                                                            lv2=3;
                                                            opcion5=1;
                                                            System.out.println("");
                                                            System.out.println("Vuelves al menu anterior");
                                                            System.out.println("");
                                                            break;
                                                        case 5:
                                                            sal=1;
                                                            b=1;
                                                            opcion4=6;
                                                            lv=2;
                                                            opcion=6;
                                                            opcion5=1;
                                                            carro.quitarExixtencias(0);
                                                            break;
                                                        case 6:
                                                            lv=2;
                                                            sal=1;
                                                            opcion=6;
                                                            opcion5=1;
                                                            bandera1=true;
                                                            break;
                                                        default:
                                                            System.out.println("");
                                                            System.out.println("ERROR");
                                                            System.out.println("Seleccione Una Opcion Valida");
                                                            System.out.println("");
                                                            opcion4=6;
                                                            opcion5=0;
                                                            break;
                                                    }
                                                } while (opcion4 !=6);
                                            }while(opcion5==0);
                                        }else{
                                            System.out.println("NO HAS AGREGADO NINGUNA EXISTENCIA AL CARRO DE COMPRAS");
                                            System.out.println("VUELVES AL MENU ANTERIOR");
                                            //mv3=1;
                                            //opcion=6;
                                            sal=1;
                                            break;
                                        }
                                    }
                                }
                                break;
                            }else{
                                if (lv==2) {
                                    //opcion3=1;
                                    //sal=1;
                                    //opcion=6;
                                   // mv3=1;
                                	bandera13=true;
                                    System.out.println(" ");
                                    System.out.println("Vuelves al Menu anterior");
                                    //lv=2;
                                    break;
                                }
                            }
                        } while (lv !=2);   
                        //break;
                        if (bandera13)break;
                    }
                    break;
                case 4:
                	System.out.println();
                	System.out.println("________________________________________________________");
                	System.out.println("*********************Agregar Peliculas*********************");
                	String codigo123;
                	System.out.println();
                	System.out.print("Digite codigo: ");codigo123=leer.next();
                	System.out.println();
                	String titulo123;
                	System.out.println();
                	System.out.print("Digite el Titulo: ");titulo123=leer.next();
                	System.out.println();
                	double precio123;
                	System.out.println();
                	System.out.print("DIgite el precio: ");precio123=leer.nextDouble();
                	System.out.println();
                	int can;
                	System.out.println();
                	System.out.print("Digite la Cantidad de Peliculas: ");can=leer.nextInt();
                	System.out.println();
                	items.anadirPelicula(codigo123, titulo123, precio123, can);
                	
                    break;
                case 5:
                    break;
                case 6: //salir menu 1op0
                    bandera1 = true;
                    break;
                default :
                    System.out.println("");
                    System.out.println("ERROR");
                    System.out.println("Seleccione Una Opcion Valida");
                    System.out.println("");
                    //opcion0=0;
                }
            if (bandera1)break;
        }
        System.out.println("______________________________");
        System.out.println("****EJECUCION TERMINADA*****");
    }
    
    
   
}
