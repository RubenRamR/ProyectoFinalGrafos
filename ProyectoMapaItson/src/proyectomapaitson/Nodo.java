package proyectomapaitson;

public class Nodo {

    String nombre;
    double peso;

    public Nodo(String nombre, double peso) {
        this.nombre = nombre;
        this.peso = peso;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Nodo{" + "nombre=" + nombre + ", peso=" + peso + '}';
    }

}
