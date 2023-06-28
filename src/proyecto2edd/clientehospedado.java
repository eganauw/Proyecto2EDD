/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2edd;

/**
 *
 * @author rodri
 */
public class clientehospedado {
    private String habitacion;
    private String nombre;
    private String apellido;
    public clientehospedado pnext;
    
    public clientehospedado(String habitacion,String nombre, String apellido){
        this.habitacion = habitacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.pnext = pnext;
    }
    public void print(){
        String texto = "";
        texto += "Habitacion: "+" "+habitacion+ " ";
        texto += "Nombre: "+" "+ nombre+" ";
        texto += "Apellido: " + " "+ apellido + " ";
        System.out.println(texto);
    }

    /**
     * @return the habitacion
     */
    public String getHabitacion() {
        return habitacion;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }
}