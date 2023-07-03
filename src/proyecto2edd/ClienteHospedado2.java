/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2edd;

/**
 *
 * @author rodri
 */
public class ClienteHospedado2 {
     private String nombre;
    private String correo;
    private String genero;
    private String celular;
    private String llegada;
    private ClienteHospedado2 pnext;
    
    public ClienteHospedado2(String nombre, String correo, String genero, String celular, String llegada){
        this.nombre = nombre;
        this.correo = correo;
        this.genero = genero;
        this.celular = celular;
        this.llegada = llegada;
        this.pnext = pnext;
    }
    public void print(){
        String texto = "";
        //texto += "Habitacion: "+" "+habitacion+ " ";
        texto += "Nombre: "+" "+ getNombre()+" ";
        //texto += "Apellido: " + " "+ apellido + " ";
        System.out.println(texto);
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @return the celular
     */
    public String getCelular() {
        return celular;
    }

    /**
     * @return the llegada
     */
    public String getLlegada() {
        return llegada;
    }

    /**
     * @return the pnext
     */
    public ClienteHospedado2 getPnext() {
        return pnext;
    }

    /**
     * @param pnext the pnext to set
     */
    public void setPnext(ClienteHospedado2 pnext) {
        this.pnext = pnext;
    }

}
