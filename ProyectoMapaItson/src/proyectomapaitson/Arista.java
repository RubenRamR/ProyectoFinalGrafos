/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectomapaitson;

public class Arista {

    Nodo inicio;
    Nodo fin;
    double distancia;

    public Arista(Nodo inicio, Nodo fin, double distancia) {
        this.inicio = inicio;
        this.fin = fin;
        this.distancia = distancia;
    }

    public Nodo getInicio() {
        return inicio;
    }

    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    public Nodo getFin() {
        return fin;
    }

    public void setFin(Nodo fin) {
        this.fin = fin;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    @Override
    public String toString() {
        return "Arista{" + "inicio=" + inicio + ", fin=" + fin + ", distancia=" + distancia + '}';
    }

}
