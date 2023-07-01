/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2edd;

/**
 *
 * @author rodri
 */
public class Habitacion {
    private int numero;
    private String historial;
    public Habitacion left;
    public Habitacion right;
    
    public Habitacion(int numero, String historial){
        this.numero = numero;
        this.historial = historial;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the historial
     */
    public String getHistorial() {
        return historial;
    }

    /**
     * @param historial the historial to set
     */
    public void setHistorial(String historial) {
        this.historial = historial;
    }

    /**
     * @return the left
     */
    public Habitacion getLeft() {
        return left;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(Habitacion left) {
        this.left = left;
    }

    /**
     * @return the right
     */
    public Habitacion getRight() {
        return right;
    }

    /**
     * @param right the right to set
     */
    public void setRight(Habitacion right) {
        this.right = right;
    }
}
