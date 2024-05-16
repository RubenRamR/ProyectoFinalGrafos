package proyectomapaitson;

import java.util.*;

public class Grafo {
    private Map<String, Nodo> nodos;

    public Grafo() {
        this.nodos = new HashMap<>();
    }

    public void agregarNodo(String nombre, int x, int y) {
        nodos.put(nombre, new Nodo(nombre, x, y));
    }

    public void conectarNodos(String origen, String destino, int peso) {
        Nodo nodoOrigen = nodos.get(origen);
        Nodo nodoDestino = nodos.get(destino);
        if (nodoOrigen != null && nodoDestino != null) {
            nodoOrigen.agregarVecino(nodoDestino, peso);
        } else {
            System.out.println("Alguno de los nodos no existe.");
        }
    }

    public Map<String, Integer> calcularRutaMasCorta(String origen) {
        Map<String, Integer> distancias = new HashMap<>();
        PriorityQueue<Nodo> colaPrioridad = new PriorityQueue<>(Comparator.comparingInt(Nodo::getPeso));

        for (String nombre : nodos.keySet()) {
            distancias.put(nombre, Integer.MAX_VALUE);
        }
        distancias.put(origen, 0);
        colaPrioridad.add(new Nodo(origen, 0, 0)); // Peso 0 para iniciar desde el origen

        while (!colaPrioridad.isEmpty()) {
            Nodo nodoActual = colaPrioridad.remove();
            String nombreActual = nodoActual.getNombre();
            int distanciaActual = distancias.get(nombreActual);

            for (Arista arista : nodos.get(nombreActual).getVecinos()) {
                String destino = arista.getDestino();
                int nuevaDistancia = distanciaActual + arista.getPeso();

                if (nuevaDistancia < distancias.get(destino)) {
                    distancias.put(destino, nuevaDistancia);
                    colaPrioridad.add(new Nodo(destino, nuevaDistancia, 0));
                }
            }
        }

        return distancias;
    }

    public List<String> obtenerNodosVecinos(String nombreNodo) {
        List<String> nodosVecinos = new ArrayList<>();
        for (Arista arista : nodos.get(nombreNodo).getVecinos()) {
            nodosVecinos.add(arista.getDestino());
        }
        return nodosVecinos;
    }

    // Getter y setter para nodos
    public Map<String, Nodo> getNodos() {
        return nodos;
    }

    public void setNodos(Map<String, Nodo> nodos) {
        this.nodos = nodos;
    }
}
