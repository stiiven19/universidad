/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package redessemanticas;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Nodo implements Serializable{
    private String nombre;
    private List<Relacion> relacionesSalientes;
    private int nivel=0;

    public Nodo(String nombre) {
        this.nombre = nombre;
        this.relacionesSalientes = new ArrayList<>();
    }
    public int getNivel() {
        return nivel;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

        
    public String getNombre() {
        return nombre;
    }

    public List<Relacion> getRelacionesSalientes() {
        return relacionesSalientes;
    }

    public void agregarRelacion(Nodo destino, String nombreRelacion) {// se agregan de derecha a izquierda para la LJC
        relacionesSalientes.add(new Relacion(destino, nombreRelacion));
    }
    
    public List<Nodo> buscarLJC() {
        List<Nodo> ljc = new ArrayList<>();
        Stack<Nodo> pila = new Stack<>();
        pila.push(this); // Agregar el nodo raíz a la pila

        while (!pila.isEmpty()) {
            Nodo nodoActual = pila.pop(); // Obtener el último nodo de la pila
            ljc.add(nodoActual); // Agregar el nodo actual a la LJC

            // Verificar si ya existe en la LJC y eliminar duplicados
            for (int i = ljc.size() - 2; i >= 0; i--) {
                if (ljc.get(i).equals(nodoActual)) {
                    ljc.remove(i);
                    break;
                }
            }

            // Verificar si el nodo actual tiene hijos
            for (Relacion relacion : nodoActual.getRelacionesSalientes()) {
                if (relacion.getNombreRelacion().equalsIgnoreCase("es_un") ||
                    relacion.getNombreRelacion().equalsIgnoreCase("instancia")) {
                    pila.push(relacion.getDestino()); // Agregar los hijos a la pila
                }
            }
        }

        return ljc;
    }
    public Queue<Nodo> getAnzuelo() {
        Queue<Nodo> anzueloActual = new LinkedList<>();
        anzueloActual.add(this);
        for (Relacion relacion : this.getRelacionesSalientes()) {
            if(relacion.getNombreRelacion().equalsIgnoreCase("es_un") || relacion.getNombreRelacion().equalsIgnoreCase("instancia")){
                Nodo hijo = relacion.getDestino();
                anzueloActual.add(hijo);
            }
//            if (hijo.getNombre().equalsIgnoreCase("todo")) {
//                return anzueloActual;
//            }
        }
        return anzueloActual;
    }
//    private Queue<Nodo> MiPrimerAnzuelo() {
//        Queue<Nodo> anzueloActual = new LinkedList<>();
//        anzueloActual.add(this);
//        for (Relacion relacion : this.getRelacionesSalientes()) {
//            Nodo hijo = relacion.getDestino();
//            anzueloActual.add(hijo);
//            if (hijo.getNombre().equalsIgnoreCase("todo")) {
//                return anzueloActual;
//            }
//        }
//        return anzueloActual;
//    }//PEPE, ADMIN,GOLOSO,DIARISTA
     public Queue<Queue<Nodo>> LJCOrdenamientoTopologico() {
        Queue<Queue<Nodo>> todosAnzuelos = new LinkedList<>();
        Queue<Queue<Nodo>> todosAnzuelos2 = new LinkedList<>();
        Queue<Nodo> anzueloActual = new LinkedList<>();
        Queue<Nodo> colaActual = new LinkedList<>();
        Queue<Nodo> anzueloinicio = getAnzuelo();
        
        todosAnzuelos2.add(anzueloinicio);
        todosAnzuelos.add(anzueloinicio);
        colaActual.add(anzueloinicio.peek());
        for (Relacion relacion : this.getRelacionesSalientes()) {
            if(relacion.getNombreRelacion().equalsIgnoreCase("es_un") || relacion.getNombreRelacion().equalsIgnoreCase("instancia")){
                Nodo hijo = relacion.getDestino();
                colaActual.add(hijo);
                anzueloActual = hijo.getAnzuelo();
                todosAnzuelos.add(anzueloActual);
                todosAnzuelos2.add(anzueloActual);
            
                if (hijo.getNombre().equalsIgnoreCase("todo")) {
                    return todosAnzuelos;
                }
            }    
        }//pepe, pepe, pepe=pepe, 
//         System.out.println("dentrodel ciclo");
//        for (Queue<Nodo> anzuelo : todosAnzuelos) {
//            for (Nodo nodo : anzuelo) {
//                System.out.println(nodo.getNombre());
//            }
//            System.out.println("-----");
//        }
         System.out.println("cola");
        for (Nodo nodo : colaActual) {
                System.out.println(nodo.getNombre());
            }
        boolean banderaanzuelo=true;
        boolean banderacola=false;
        etiquetaExterior:
        for (Queue<Nodo> anzuelo : todosAnzuelos) {
            System.out.println("");
            System.out.println("todosanzuelos; "+anzuelo.peek().getNombre());
            System.out.println("");
                
            for (Nodo nodoqueue : anzuelo) {
                if(banderacola){
                    break etiquetaExterior;
                }
                banderaanzuelo=true;
                for (Nodo nodocola : colaActual) {
                    if(nodoqueue.getNombre().equals(nodocola.getNombre())){
                        banderaanzuelo=false;
                    }
                }
                if(banderaanzuelo){
                    if (!nodoqueue.getNombre().equalsIgnoreCase("todo")) {
                        System.out.println("retorno1");
                    
                        System.out.println("");
                        System.out.println("break; "+anzuelo.peek().getNombre());
                        System.out.println("break; "+nodoqueue.getNombre());

                        colaActual.add(nodoqueue);
                        anzueloActual = nodoqueue.getAnzuelo();
                        todosAnzuelos2.add(anzueloActual);
                        banderacola=true;
                        System.out.println("size"+todosAnzuelos2.size());

                        System.out.println("");
                        break etiquetaExterior;
                    }
                }
                
            }
            
//            System.out.println(""+anzuelo.peek().getNombre());
        }
        banderaanzuelo=true;
        banderacola=false;
        todosAnzuelos.clear();
        todosAnzuelos.addAll(todosAnzuelos2);
        etiquetaExterior:
        for (Queue<Nodo> anzuelo : todosAnzuelos2) {
            
            System.out.println("");
            System.out.println("todosanzuelos; "+anzuelo.peek().getNombre());
            System.out.println("");
            for (Nodo nodoqueue : anzuelo) {
                if(banderacola){
                    break etiquetaExterior;
                }
                banderaanzuelo=true;
                for (Nodo nodocola : colaActual) {
                    if(nodoqueue.getNombre().equals(nodocola.getNombre())){
                        banderaanzuelo=false;
                    }
                }
                if(banderaanzuelo){
                    if (!nodoqueue.getNombre().equalsIgnoreCase("todo")) {
                        System.out.println("retorno2");
                    
                        System.out.println("");
                        System.out.println("break; "+anzuelo.peek().getNombre());
                        System.out.println("break; "+nodoqueue.getNombre());

                        colaActual.add(nodoqueue);
                        anzueloActual = nodoqueue.getAnzuelo();
                        todosAnzuelos.add(anzueloActual);
                        banderacola=true;
                        System.out.println("size"+todosAnzuelos.size());
                        System.out.println("");
                        break etiquetaExterior;
                    }
                }
                
            }
            
//            System.out.println(""+anzuelo.peek().getNombre());
        }
        
        banderaanzuelo=true;
        banderacola=false;
        todosAnzuelos2.clear();
        todosAnzuelos2.addAll(todosAnzuelos);
        etiquetaExterior:
        for (Queue<Nodo> anzuelo : todosAnzuelos) {
            
            System.out.println("");
            System.out.println("todosanzuelos; "+anzuelo.peek().getNombre());
            System.out.println("");
            for (Nodo nodoqueue : anzuelo) {
                if(banderacola){
                    break etiquetaExterior;
                }
                banderaanzuelo=true;
                for (Nodo nodocola : colaActual) {
                    if(nodoqueue.getNombre().equals(nodocola.getNombre())){
                        banderaanzuelo=false;
                    }
                }
                if(banderaanzuelo){
                    if (!nodoqueue.getNombre().equalsIgnoreCase("todo")) {
                        System.out.println("retorno3");
                        System.out.println("");
                        System.out.println("break; "+anzuelo.peek().getNombre());
                        System.out.println("break; "+nodoqueue.getNombre());

                        colaActual.add(nodoqueue);
                        anzueloActual = nodoqueue.getAnzuelo();
                        todosAnzuelos2.add(anzueloActual);
                        banderacola=true;
                        System.out.println("size"+todosAnzuelos.size());
                        System.out.println("");
                        break etiquetaExterior;
                    }

                }
                
            }
            
//            System.out.println(""+anzuelo.peek().getNombre());
        }
        banderaanzuelo=true;
        banderacola=false;
        todosAnzuelos.clear();
        todosAnzuelos.addAll(todosAnzuelos2);
        etiquetaExterior:
        for (Queue<Nodo> anzuelo : todosAnzuelos2) {
            if(banderacola){
                    break etiquetaExterior;
                }
            System.out.println("");
            System.out.println("todosanzuelos; "+anzuelo.peek().getNombre());
            System.out.println("");
            for (Nodo nodoqueue : anzuelo) {
                
                banderaanzuelo=true;
                for (Nodo nodocola : colaActual) {
                    if(nodoqueue.getNombre().equals(nodocola.getNombre())){
                        banderaanzuelo=false;
                    }
                }
                if(banderaanzuelo){
                    if (!nodoqueue.getNombre().equalsIgnoreCase("todo")) {
                        System.out.println("retorno4");
                    
                        System.out.println("");
                        System.out.println("break; "+anzuelo.peek().getNombre());
                        System.out.println("break; "+nodoqueue.getNombre());

                        colaActual.add(nodoqueue);
                        anzueloActual = nodoqueue.getAnzuelo();
                        todosAnzuelos.add(anzueloActual);
                        banderacola=true;
                        System.out.println("size"+todosAnzuelos.size());
                        System.out.println("");
                        break etiquetaExterior;
                    }
                }
            }
        }
        banderaanzuelo=true;
        banderacola=false;
        todosAnzuelos2.clear();
        todosAnzuelos2.addAll(todosAnzuelos);
        etiquetaExterior:
        for (Queue<Nodo> anzuelo : todosAnzuelos) {
            
            System.out.println("");
            System.out.println("todosanzuelos; "+anzuelo.peek().getNombre());
            System.out.println("");
            for (Nodo nodoqueue : anzuelo) {
                
                banderaanzuelo=true;
                for (Nodo nodocola : colaActual) {
                    if(nodoqueue.getNombre().equals(nodocola.getNombre())){
                        banderaanzuelo=false;
                    }
                }
                if(banderaanzuelo){
                    if (!nodoqueue.getNombre().equalsIgnoreCase("todo")) {
                        System.out.println("retorno5");
                    
                        System.out.println("");
                        System.out.println("break; "+anzuelo.peek().getNombre());
                        System.out.println("break; "+nodoqueue.getNombre());

                        colaActual.add(nodoqueue);
                        anzueloActual = nodoqueue.getAnzuelo();
                        todosAnzuelos2.add(anzueloActual);
                        banderacola=true;
                        System.out.println("size"+todosAnzuelos.size());
                        System.out.println("");
                        break etiquetaExterior;
                    }
                }
                
            }
            
//            System.out.println(""+anzuelo.peek().getNombre());
        }
        banderaanzuelo=true;
        banderacola=false;
        todosAnzuelos.clear();
        todosAnzuelos.addAll(todosAnzuelos2);
        etiquetaExterior:
        for (Queue<Nodo> anzuelo : todosAnzuelos2) {
            
            System.out.println("");
            System.out.println("todosanzuelos; "+anzuelo.peek().getNombre());
            System.out.println("");
            for (Nodo nodoqueue : anzuelo) {
                
                banderaanzuelo=true;
                for (Nodo nodocola : colaActual) {
                    if(nodoqueue.getNombre().equals(nodocola.getNombre())){
                        banderaanzuelo=false;
                    }
                }
                if(banderaanzuelo){
                    if (!nodoqueue.getNombre().equalsIgnoreCase("todo")) {
                        System.out.println("retorno6");
                    
                        System.out.println("");
                        System.out.println("break; "+anzuelo.peek().getNombre());
                        System.out.println("break; "+nodoqueue.getNombre());

                        colaActual.add(nodoqueue);
                        anzueloActual = nodoqueue.getAnzuelo();
                        todosAnzuelos.add(anzueloActual);
                        banderacola=true;
                        System.out.println("size"+todosAnzuelos.size());
                        System.out.println("");
                        break etiquetaExterior;
                    }
                }
            }
        }
        banderaanzuelo=true;
        banderacola=false;
        todosAnzuelos2.clear();
        todosAnzuelos2.addAll(todosAnzuelos);
        etiquetaExterior:
        for (Queue<Nodo> anzuelo : todosAnzuelos) {
            
            System.out.println("");
            System.out.println("todosanzuelos; "+anzuelo.peek().getNombre());
            System.out.println("");
            for (Nodo nodoqueue : anzuelo) {
                
                banderaanzuelo=true;
                for (Nodo nodocola : colaActual) {
                    if(nodoqueue.getNombre().equals(nodocola.getNombre())){
                        banderaanzuelo=false;
                    }
                }
                if(banderaanzuelo){
                    if (!nodoqueue.getNombre().equalsIgnoreCase("todo")) {
                        System.out.println("retorno7");
                    
                        System.out.println("");
                        System.out.println("break; "+anzuelo.peek().getNombre());
                        System.out.println("break; "+nodoqueue.getNombre());

                        colaActual.add(nodoqueue);
                        anzueloActual = nodoqueue.getAnzuelo();
                        todosAnzuelos2.add(anzueloActual);
                        banderacola=true;
                        System.out.println("size"+todosAnzuelos.size());
                        System.out.println("");
                        break etiquetaExterior;
                    }
                }
                
            }
            
//            System.out.println(""+anzuelo.peek().getNombre());
        }
        banderaanzuelo=true;
        banderacola=false;
        todosAnzuelos.clear();
        todosAnzuelos.addAll(todosAnzuelos2);
        etiquetaExterior:
        for (Queue<Nodo> anzuelo : todosAnzuelos2) {
            
            System.out.println("");
            System.out.println("todosanzuelos; "+anzuelo.peek().getNombre());
            System.out.println("");
            for (Nodo nodoqueue : anzuelo) {
                if(banderacola){
                    break etiquetaExterior;
                }
                banderaanzuelo=true;
                for (Nodo nodocola : colaActual) {
                    if(nodoqueue.getNombre().equals(nodocola.getNombre())){
                        banderaanzuelo=false;
                    }
                }
                if(banderaanzuelo){
                    if (!nodoqueue.getNombre().equalsIgnoreCase("todo")) {

    //                    System.out.println("");
    //                    System.out.println("break; "+anzuelo.peek().getNombre());
    //                    System.out.println("break; "+nodoqueue.getNombre());

                        colaActual.add(nodoqueue);
                        anzueloActual = nodoqueue.getAnzuelo();
                        todosAnzuelos.add(anzueloActual);
                        banderacola=true;
    //                    System.out.println("size"+todosAnzuelos.size());
    //                    System.out.println("");
                        break etiquetaExterior;
                    }
                }
            }
        }
        return todosAnzuelos;
        
    }
     
    public List<String> construirParejas(Queue<Queue<Nodo>> todosAnzuelos) {
        List<String> parejas = new ArrayList<>();

        for (Queue<Nodo> anzuelo : todosAnzuelos) {
            List<Nodo> nodosAnzuelo = new ArrayList<>(anzuelo);

            for (int i = 0; i < nodosAnzuelo.size() - 1; i++) {
                Nodo nodo1 = nodosAnzuelo.get(i);
                Nodo nodo2 = nodosAnzuelo.get(i + 1);
                parejas.add(nodo1.getNombre() + " - " + nodo2.getNombre());
            }
        }

        return parejas;
    }
    public List<String> obtenerLJCConParejas(List<String> parejas, Queue<Queue<Nodo>> todosAnzuelos) {
    List<String> LJCConParejas = new ArrayList<>();
    Set<String> nodosProcesados = new HashSet<>();
    
    for (Queue<Nodo> anzuelo : todosAnzuelos) {
        for (Nodo nodo : anzuelo) {
            String nombreNodo = nodo.getNombre();
            if (!nodosProcesados.contains(nombreNodo)) {
                LJCConParejas.add(nombreNodo);
                nodosProcesados.add(nombreNodo);
            }
        }
    }
    
    for (String pareja : parejas) {
        String[] partes = pareja.split(" - ");
        if (partes.length == 2) {
            String nodoIzquierdo = partes[0];
            String nodoDerecho = partes[1];
            if (!nodosProcesados.contains(nodoDerecho)) {
                LJCConParejas.add(nodoDerecho);
                nodosProcesados.add(nodoDerecho);
            }
        }
    }
    
    return LJCConParejas;
}
    

    
}