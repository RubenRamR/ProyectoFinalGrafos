package proyectomapaitson;

public class Nodo {

    private int nombre;
    private int peso;

    public Nodo(int nombre, int peso) {
        this.nombre = nombre;
        this.peso = peso;
    }

    // Getters y setters para nombre y peso
    public int getNombre() {
        return nombre;
    }

    public void setId(int nombre) {
        this.nombre = nombre;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
}
