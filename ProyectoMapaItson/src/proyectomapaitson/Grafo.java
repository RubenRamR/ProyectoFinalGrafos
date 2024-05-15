/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectomapaitson;

import java.util.*;

public class Grafo {

    private Map<Nodo, List<Arista>> mapa;

    public Grafo() {
        this.mapa = new HashMap<>();
    }

    public void agregarNodo(Nodo nodo) {
        mapa.put(nodo, new ArrayList<>());
    }

    public void agregarArista(Nodo inicio, Nodo fin, double distancia) {
        mapa.get(inicio).add(new Arista(inicio, fin, distancia));
        // Si el grafo es no dirigido, descomenta la línea siguiente
        // mapa.get(fin).add(new Arista(fin, inicio, distancia));
    }

    public List<Arista> obtenerAristasDeNodo(Nodo nodo) {
        return mapa.get(nodo);
    }

    public Set<Nodo> obtenerNodos() {
        return mapa.keySet();
    }

    public List<Arista> obtenerAristas() {
        List<Arista> aristas = new ArrayList<>();
        for (List<Arista> listaAristas : mapa.values())
        {
            aristas.addAll(listaAristas);
        }
        return aristas;
    }

    public Map<Nodo, List<Arista>> getMapa() {
        return mapa;
    }

    public void setMapa(Map<Nodo, List<Arista>> mapa) {
        this.mapa = mapa;
    }

    @Override
    public String toString() {
        return "Grafo{" + "mapa=" + mapa + '}';
    }
}
