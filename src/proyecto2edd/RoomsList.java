/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2edd;

/**
 *
 * @author rodri
 */
public class RoomsList {
    public Room pFirst;
    public Room pLast;
    public int size;
    
        public RoomsList(){
            this.pFirst = null;
            this.pLast = null;
            this.size = 0;
        }
        
        public boolean isEmpty(){
        return this.pFirst == null;
    }
    
    public void insert(Room room){
        if(isEmpty()){
            pFirst = room;
            pLast = room;
        }else{
            Room aux = pLast;
            aux.setPnext(room);
            pLast = room;
        } size += 1;
        
    }   
    
    public Room findFreeRoom(String tipo){
        tipo = tipo.toLowerCase();
        Room pAux = pFirst;
        Room encontrada = null;
        while(pAux!=null){
            if(!pAux.ocupada&&pAux.tipo.equals(tipo)){
                encontrada = pAux;
                break;
            }else{
                pAux = pAux.getPnext();
            }
        }return encontrada;
    }
}
