package proyectomapaitson;

public class Nodo {

    String nombre;
    double pesoX, pesoY;

    public Nodo(String nombre, double pesoX, double pesoY) {
        this.nombre = nombre;
        this.pesoX = pesoX;
        this.pesoY = pesoY;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPesoX() {
        return pesoX;
    }

    public void setPesoX(double pesoX) {
        this.pesoX = pesoX;
    }

    public double getPesoY() {
        return pesoY;
    }

    public void setPesoY(double pesoY) {
        this.pesoY = pesoY;
    }

    @Override
    public String toString() {
        return "Nodo{" + "nombre=" + nombre + ", pesoX=" + pesoX + ", pesoY=" + pesoY + '}';
    }

}
