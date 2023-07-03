/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2edd;

/**
 *
 * @author rodri
 */
public class ClientesHospedadosList {
    public ClienteHospedado2 pFirst;
    public ClienteHospedado2 pLast;
    public int size;
    
    public ClientesHospedadosList(){
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
    }
         public boolean isEmpty(){
        return this.pFirst == null;
    }
    
    public void insert(ClienteHospedado2 cliente2){
        if(isEmpty()){
            pFirst = cliente2;
            pLast = cliente2;
        }else{
            ClienteHospedado2 aux = pLast;
            aux.setPnext(cliente2);
            pLast = cliente2;
        } size += 1;
        
    }   
    //public ClienteHospedado2 buscar_cliente(){
        
    //}
  }

