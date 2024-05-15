/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectomapaitson;

import java.util.*;

public class Dijkstra {

    public Map<Nodo, Double> calcularRutaMasCorta(Grafo grafo, Nodo inicio) {
        
        Map<Nodo, Double> distanciaMinima = new HashMap<>();
        Set<Nodo> nodosNoVisitados = new HashSet<>();

        for (Nodo nodo : grafo.obtenerNodos())
        {
            distanciaMinima.put(nodo, Double.MAX_VALUE);
            nodosNoVisitados.add(nodo);
        }

        distanciaMinima.put(inicio, 0.0);

        while (!nodosNoVisitados.isEmpty())
        {
            Nodo nodoActual = null;
            for (Nodo nodo : nodosNoVisitados)
            {
                if (nodoActual == null || distanciaMinima.get(nodo) < distanciaMinima.get(nodoActual))
                {
                    nodoActual = nodo;
                }
            }

            nodosNoVisitados.remove(nodoActual);

            for (Arista arista : grafo.obtenerAristasDeNodo(nodoActual))
            {
                double distanciaTotal = distanciaMinima.get(nodoActual) + arista.distancia;
                if (distanciaTotal < distanciaMinima.get(arista.fin))
                {
                    distanciaMinima.put(arista.fin, distanciaTotal);
                }
            }
        }

        return distanciaMinima;
    }
}
