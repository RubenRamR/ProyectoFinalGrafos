/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocios.dominioGrafo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Grafo {

    private static final Logger LOG = Logger.getLogger(Grafo.class.getName());

    private List<Vertice> vertices; // Representa los edificios
    private List<Arista> aristas; // Representa los caminos

    public Grafo() {
        this.vertices = new ArrayList<>();
        this.aristas = new ArrayList<>();
    }

    public List<Vertice> getVertices() {
        return vertices;
    }

    public void setVertices(List<Vertice> vertices) {
        this.vertices = vertices;
    }

    public List<Arista> getAristas() {
        return aristas;
    }

    public void setAristas(List<Arista> aristas) {
        this.aristas = aristas;
    }

    public void agregarVertice(String edificio) { // Agrega un edificio
        vertices.add(new Vertice(edificio));
    }

    public void agregarArista(String edificio1, String edificio2, double peso) { // Agrega un camino entre edificios
        Vertice vertice1 = encontrarVertice(edificio1);
        Vertice vertice2 = encontrarVertice(edificio2);

        if (vertice1 != null && vertice2 != null) {
            aristas.add(new Arista(vertice1, vertice2, peso));
            aristas.add(new Arista(vertice2, vertice1, peso));

        } else {
            LOG.log(Level.WARNING, "Error: No se pudo agregar la arista, los vertices no se encontraron.");

        }
    }

    public Vertice encontrarVertice(String nombreEdificio) {
        for (Vertice verticeEdificio : vertices) {
            if (verticeEdificio.getEdificio().equalsIgnoreCase(nombreEdificio)) {
                return verticeEdificio;
            }
        }
        return null;
    }

    public Double[][] obtenerMatrizAdyacente() {
        int largo = vertices.size();
        Double[][] matriz = new Double[largo][largo];

        for (Arista aristaCamino : aristas) {
            int indexOrigen = vertices.indexOf(aristaCamino.getOrigen());
            int indexDestino = vertices.indexOf(aristaCamino.getDestino());

            matriz[indexOrigen][indexDestino] = aristaCamino.getPeso();
            matriz[indexDestino][indexOrigen] = aristaCamino.getPeso();
        }

        return matriz;
    }
    
    public List<Vertice> dijkstra(Vertice origen, Vertice destino) {
        Map<Vertice, Double> distancias = new HashMap<>();
        Map<Vertice, Vertice> padres = new HashMap<>();
        PriorityQueue<Vertice> cola = new PriorityQueue<>(Comparator.comparingDouble(distancias::get));
        for (Vertice vertice : vertices) {
            
            distancias.put(vertice, Double.POSITIVE_INFINITY);
            padres.put(vertice, null);
            
        }
        
        distancias.put(origen, 0.0);
        cola.add(origen);
        while (!cola.isEmpty()) {
            
            Vertice actual = cola.poll();
            for (Arista arista : obtenerAristasSalientes(actual)) {
                
                Vertice vecino = arista.getDestino();
                double pesoTotal = distancias.get(actual) + arista.getPeso();

                if (pesoTotal < distancias.get(vecino)) {
                    
                    distancias.put(vecino, pesoTotal);
                    padres.put(vecino, actual);
                    cola.add(vecino);
                    
                }
                
            }
            
        }

        List<Vertice> camino = new ArrayList<>();
        Vertice actual = destino;
        while (actual != null) {
            
            camino.add(actual);
            actual = padres.get(actual);
            
        }
        
        Collections.reverse(camino);
        return camino;
        
    }
    
    public List<Arista> obtenerAristasSalientes(Vertice vertice) {
        
        List<Arista> aristasSalientes = new ArrayList<>();
        for (Arista arista : aristas) {
            
            if (arista.getOrigen().equals(vertice)) {
                
                aristasSalientes.add(arista);
                
            }
            
        }
        
        return aristasSalientes;
    
    }
    
    public Arista buscarArista(Vertice origen, Vertice destino){
        
        for (Arista arista : aristas) {
            
            if (arista.getOrigen().equals(origen) && arista.getDestino().equals(destino)) {
               
                return arista;
                
            }
            
        }
        
        return null;
        
    }
    
    public List<Arista> caminoAristas(List<Vertice> caminoVertice){
        
        List<Arista> aristasEnCamino = new ArrayList<>();
        for (int i = 0; i < caminoVertice.size() - 1; i++) {
            
            Vertice actual = caminoVertice.get(i);
            Vertice siguiente = caminoVertice.get(i + 1);
            Arista arista = buscarArista(actual, siguiente);
            if (arista != null) {
                
                aristasEnCamino.add(arista);
                
            } else {
                
                return null;
                
            }
            
        }

        return aristasEnCamino;
        
    }
    
    public double distancia(List<Arista> camino){
        
        double distancia = 0;
        for(Arista arista: camino){
            
            distancia = distancia + arista.getPeso();
            
        }
        
        return distancia;
        
    }
    
}
