/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2edd;

/**
 *
 * @author rodri
 */
public class Room {
    public int numero;
    public String tipo;
    public int piso;
    public boolean ocupada = false;
    private Room pnext;
        
    public Room(int numero,String tipo,int piso){
            this.numero = numero;
            this.tipo = tipo;
            this.piso = piso;
        }

    /**
     * @return the pnext
     */
    public Room getPnext() {
        return pnext;
    }

    /**
     * @param pnext the pnext to set
     */
    public void setPnext(Room pnext) {
        this.pnext = pnext;
    }


}
