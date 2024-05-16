package proyectomapaitson;

import java.util.ArrayList;
import java.util.List;

import java.util.List;

import java.util.List;

import java.util.ArrayList;

public class Nodo {
    private String nombre;
    private int x;
    private int y;
    private List<Arista> vecinos;

    public Nodo(String nombre, int x, int y) {
        this.nombre = nombre;
        this.x = x;
        this.y = y;
        this.vecinos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public List<Arista> getVecinos() {
        return vecinos;
    }

    public void agregarVecino(Nodo nodoDestino, int peso) {
        vecinos.add(new Arista(nodoDestino.getNombre(), peso));
    }
}
