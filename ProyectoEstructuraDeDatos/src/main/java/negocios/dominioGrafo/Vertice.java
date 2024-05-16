/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package negocios.dominioGrafo;

/**
 *
 * @author Admin
 */
public class Vertice {
    private String edificio;

    public Vertice() {
    }
    
    public Vertice(String edificio) {
        this.edificio = edificio;
    }

    public String getEdificio() {
        return edificio;
    }

    public void setEdificio(String edificio) {
        this.edificio = edificio;
    }

    @Override
    public String toString() {
        return edificio;
    }
    
    
    
}
