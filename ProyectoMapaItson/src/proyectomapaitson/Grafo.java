/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectomapaitson;

import java.util.*;

public class Grafo {

    private Map<Integer, List<Arista>> nodos;

    public Grafo() {
        this.nodos = new HashMap<>();
    }

    public void agregarNodo(int id) {
        nodos.putIfAbsent(id, new ArrayList<>());
    }

    public void conectarNodos(int origen, int destino, int peso) {
        nodos.get(origen).add(new Arista(destino, peso));
    }

    /*
    *   Metodo Dijktra
     */
    public Map<Integer, Integer> calcularRutaMasCorta(int origen) {
        Map<Integer, Integer> distancias = new HashMap<>();
        PriorityQueue<Nodo> colaPrioridad = new PriorityQueue<>(Comparator.comparingInt(Nodo::getPeso));

        for (int nodo : nodos.keySet())
        {
            distancias.put(nodo, Integer.MAX_VALUE);
        }
        distancias.put(origen, 0);
        colaPrioridad.add(new Nodo(origen, 0));

        while (!colaPrioridad.isEmpty())
        {
            int nodoActual = colaPrioridad.remove().getNombre();
            List<Arista> aristas = nodos.get(nodoActual);

            for (Arista arista : aristas)
            {
                int nuevaDistancia = distancias.get(nodoActual) + arista.getPeso();

                if (nuevaDistancia < distancias.get(arista.getDestino()))
                {
                    distancias.put(arista.getDestino(), nuevaDistancia);
                    colaPrioridad.add(new Nodo(arista.getDestino(), nuevaDistancia));
                }
            }
        }

        return distancias;
    }

    public List<Integer> obtenerNodosVecinos(int idNodo) {
        List<Integer> nodosVecinos = new ArrayList<>();
        for (Arista arista : nodos.get(idNodo))
        {
            nodosVecinos.add(arista.getDestino());
        }
        return nodosVecinos;
    }

    // Getter y setter para nodos
    public Map<Integer, List<Arista>> getNodos() {
        return nodos;
    }

    public void setNodos(Map<Integer, List<Arista>> nodos) {
        this.nodos = nodos;
    }
}
