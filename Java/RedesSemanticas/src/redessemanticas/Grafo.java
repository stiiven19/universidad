/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package redessemanticas;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Grafo {
    private List<Nodo> nodos;

    public Grafo() {
        this.nodos = new ArrayList<>();
    }

    public void agregarNodo(Nodo nodo) {
        nodos.add(nodo);
    }

    public List<String> todosLosCaminosConEtiquetas(Nodo inicio, Nodo destino) {
        List<String> caminos = new ArrayList<>();
        StringBuilder caminoActual = new StringBuilder();
        caminoActual.append(inicio.getNombre());
        dfsCaminosConEtiquetas(inicio, destino, caminoActual, caminos);
        return caminos;
    }

    private void dfsCaminosConEtiquetas(Nodo actual, Nodo destino, StringBuilder caminoActual, List<String> caminos) {
        if (actual == destino) {
            caminos.add(caminoActual.toString());
            return;
        }

        for (Relacion relacion : actual.getRelacionesSalientes()) {
            Nodo nodoVecino = relacion.getDestino();
            if (caminoActual.indexOf(nodoVecino.getNombre()) == -1) {
                StringBuilder nuevoCamino = new StringBuilder(caminoActual);
                nuevoCamino.append(" ").append(relacion.getNombreRelacion()).append(" ").append(nodoVecino.getNombre());
                dfsCaminosConEtiquetas(nodoVecino, destino, nuevoCamino, caminos);
            }
        }
    }
public void calcularNiveles() {
    Nodo nodoRaiz = encontrarNodoRaiz();
    if (nodoRaiz != null) {
        nodoRaiz.setNivel(0);
        asignarNiveles(nodoRaiz, 1);
    }
}

private Nodo encontrarNodoRaiz() {
    for (Nodo nodo : nodos) {
        boolean tienePadre = false;
        for (Nodo otroNodo : nodos) {
            for (Relacion relacion : otroNodo.getRelacionesSalientes()) {
                if (relacion.getDestino() == nodo) {
                    tienePadre = true;
                    break;
                }
            }
            if (tienePadre) {
                break;
            }
        }
        if (!tienePadre) {
            return nodo;
        }
    }
    return null;
}

private void asignarNiveles(Nodo nodoActual, int nivel) {
    for (Relacion relacion : nodoActual.getRelacionesSalientes()) {
        Nodo nodoHijo = relacion.getDestino();
        nodoHijo.setNivel(nivel);
        asignarNiveles(nodoHijo, nivel + 1);
    }
}

    public List<Nodo> getNodos() {
        return nodos;
    }
    public List<Nodo> ordenamientoTopologico(Nodo nodoInicio) {
        List<Nodo> orden = new ArrayList<>();
        Stack<Nodo> pila = new Stack<>();
        boolean[] visitado = new boolean[nodos.size()];

        pila.push(nodoInicio);

        while (!pila.isEmpty()) {
            Nodo nodoActual = pila.pop();
            if (!visitado[nodos.indexOf(nodoActual)]) {
                visitado[nodos.indexOf(nodoActual)] = true;
                orden.add(nodoActual);

                for (Relacion relacion : nodoActual.getRelacionesSalientes()) {
                    pila.push(relacion.getDestino());
                }
            }
        }

        return orden;
    }
    
    public static void createAnzuelos(Nodo nodo, List<List<Nodo>> anzuelos, List<Nodo> anzueloActual) {
        anzueloActual.add(nodo);

        for (Relacion relacion : nodo.getRelacionesSalientes()) {
            Nodo hijo = relacion.getDestino();
            if (!hijo.getNombre().equalsIgnoreCase("todo")) {
                createAnzuelos(hijo, anzuelos, anzueloActual);
            }
        }

        // Cuando llegamos al nodo "todo", agregamos el anzuelo actual a la lista de anzuelos
        if (nodo.getNombre().equalsIgnoreCase("todo")) {
            anzuelos.add(new ArrayList<>(anzueloActual));
        }

        // Removemos el nodo actual del anzuelo actual antes de volver al nodo padre
        anzueloActual.remove(anzueloActual.size() - 1);
    }   
    public static List<String> createPairs(List<Nodo> LJC) {
        List<String> pairs = new ArrayList<>();

        for (int i = 0; i < LJC.size() - 1; i++) {
            pairs.add(LJC.get(i).getNombre() + " - " + LJC.get(i + 1).getNombre());
        }

        return pairs;
    }
    public static List<String> getLJCFromPairs(List<String> pairs) {
    List<String> LJC = new ArrayList<>();
    List<String> remainingPairs = new ArrayList<>(pairs);

    while (!remainingPairs.isEmpty()) {
        String firstNode = remainingPairs.get(0).split(" - ")[0];
        LJC.add(firstNode);
        for (int i = 0; i < remainingPairs.size(); i++) {
            String[] parts = remainingPairs.get(i).split(" - ");
            if (parts[0].equals(firstNode)) {
                LJC.add(parts[1]);
                remainingPairs.remove(i);
                break;
            }
        }
    }

    return LJC;
}

    
    public static void main(String[] args) {
        Grafo grafo = new Grafo();

//        Nodo nodoA = new Nodo("A");
//        Nodo nodoB = new Nodo("B");
//        Nodo nodoC = new Nodo("C");
//        Nodo nodoD = new Nodo("D");
//        Nodo nodoE = new Nodo("E");
//        Nodo nodoF = new Nodo("F");
//        Nodo nodoG = new Nodo("G");
//        Nodo nodoH = new Nodo("H");
//
//        nodoB.agregarRelacion(nodoA, "relacionBA");
//        nodoB.agregarRelacion(nodoF, "relacionBF");
//        nodoF.agregarRelacion(nodoH, "relacionFH");
//        nodoG.agregarRelacion(nodoB, "relacionGB");
//        nodoG.agregarRelacion(nodoC, "relacionGC");
//        nodoG.agregarRelacion(nodoD, "relacionGD");
//        nodoE.agregarRelacion(nodoG, "relacionEG");
//        //nodoC.agregarRelacion(nodoF, "relacionCF");

//        grafo.agregarNodo(nodoA);
//        grafo.agregarNodo(nodoB);
//        grafo.agregarNodo(nodoC);
//        grafo.agregarNodo(nodoD);
//        grafo.agregarNodo(nodoE);
//        grafo.agregarNodo(nodoF);
//        grafo.agregarNodo(nodoG);
//        grafo.agregarNodo(nodoH);

//        List<String> caminos = grafo.todosLosCaminosConEtiquetas(nodoD, nodoA);
//
//        for (String camino : caminos) {
//            System.out.println("Camino: " + camino);
//        }
        grafo.calcularNiveles();
//        System.out.println("raiz; " + grafo.encontrarNodoRaiz().getNombre());
//        System.out.println("raiz; " + grafo.encontrarNodoRaiz().getNivel());
//        System.out.println("raiz; " + grafo.encontrarNodoRaiz().getRelacionesSalientes());
        for (Nodo nodo : grafo.getNodos()) {
            System.out.println("Nodo: " + nodo.getNombre() + ", Nivel: " + nodo.getNivel());
        }
        ////////////////////////////////////////////LJC PEPE///////////////////////////////////////////////
//        Nodo nodoA = new Nodo("pepe");
//        Nodo nodoB = new Nodo("administrador");
//        Nodo nodoC = new Nodo("goloso");
//        Nodo nodoD = new Nodo("diarista");
//        Nodo nodoE = new Nodo("competidores");
//        Nodo nodoF = new Nodo("enanos");
//        Nodo nodoG = new Nodo("todo");
//        
//        
//        nodoA.agregarRelacion(nodoB, "instancia");
//        nodoA.agregarRelacion(nodoC, "instancia");
//        nodoA.agregarRelacion(nodoD, "instancia");
//        nodoB.agregarRelacion(nodoE, "es_un");
//        nodoE.agregarRelacion(nodoF, "es_un");
//        nodoF.agregarRelacion(nodoG, "es_un");
//        nodoC.agregarRelacion(nodoF, "es_un");
//        nodoD.agregarRelacion(nodoF, "es_un");
//
//        grafo.agregarNodo(nodoA);
//        grafo.agregarNodo(nodoB);
//        grafo.agregarNodo(nodoC);
//        grafo.agregarNodo(nodoD);
//        grafo.agregarNodo(nodoE);
//        grafo.agregarNodo(nodoF);
//        grafo.agregarNodo(nodoG);
        
        Nodo nodoA = new Nodo("jaque");
        Nodo nodoB = new Nodo("Levantadores de pesas");
        Nodo nodoC = new Nodo("Lanzadores de bala");
        Nodo nodoD = new Nodo("Atletas");
        Nodo nodoE = new Nodo("Endomorfos");
        Nodo nodoF = new Nodo("enanos");
        Nodo nodoG = new Nodo("todo");
        
        
        nodoA.agregarRelacion(nodoB, "instancia");
        nodoA.agregarRelacion(nodoC, "instancia");
        nodoA.agregarRelacion(nodoD, "instancia");
        nodoB.agregarRelacion(nodoD, "es_un");
        nodoB.agregarRelacion(nodoE, "es_un");
        nodoC.agregarRelacion(nodoD, "es_un");
        nodoC.agregarRelacion(nodoE, "es_un");
        nodoD.agregarRelacion(nodoF, "es_un");
        nodoE.agregarRelacion(nodoF, "es_un");
        nodoF.agregarRelacion(nodoG, "es_un");

        grafo.agregarNodo(nodoA);
        grafo.agregarNodo(nodoB);
        grafo.agregarNodo(nodoC);
        grafo.agregarNodo(nodoD);
        grafo.agregarNodo(nodoE);
        grafo.agregarNodo(nodoF);
        grafo.agregarNodo(nodoG);
        
        // Agregar relaciones a Pepe según tus necesidades...

        List<Nodo> ljcPepe = nodoA.buscarLJC();

        // Imprimir la LJC
        System.out.println("Lista Jerárquica de Clases para Pepe:");
        for (Nodo nodo : ljcPepe) {
            System.out.println(nodo.getNombre());
        }
        System.out.println("");
       
         Queue<Queue<Nodo>> anzuelos = nodoB.LJCOrdenamientoTopologico();

        System.out.println("Anzuelos:");
        for (Queue<Nodo> anzuelo : anzuelos) {
            for (Nodo nodo : anzuelo) {
                System.out.println(nodo.getNombre());
            }
            System.out.println("-----");
        }
        System.out.println("");
        List<String> parejas = nodoB.construirParejas(anzuelos);
        System.out.println("Parejas:");
        for (String pareja : parejas) {
            System.out.println(pareja);
        }
          System.out.println("");
        List<String> LJCConParejas = nodoB.obtenerLJCConParejas(parejas, anzuelos);
        System.out.println("LJC con Parejas:");
        for (String nodo : LJCConParejas) {
            System.out.println(nodo);
        }
        
    }
}