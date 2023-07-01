/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2edd;

import javax.swing.JOptionPane;
import static proyecto2edd.Proyecto2EDD.hashtable;

/**
 *
 * @author rodri
 */
public class HashTable {
    public static final int INITIAL_CAPACITY = 10; // Initial table size
    public static final double LOAD_FACTOR = 0.75; // Adjust the load factor as needed
    private Node[] table;
    private int size;

    // Constructor
    public HashTable() {
        table = new Node[INITIAL_CAPACITY];
        size = 0;
    }
    
    public int hash(String key) {
        int hash = 0;
        for (char c : key.toCharArray()) {
            hash += c;
        }
        return hash % getTable().length;
    }

    //Add a guest to the hash table
        public void addGuest(String name, int roomNumber) {
        int count = 0;
        if (getSize() >= getTable().length * LOAD_FACTOR) {
            resizeTable();
        }

        int index = hash(name);
        Node newNode = new Node(name, roomNumber);

        if (getTable()[index] == null) {
            table[index] = newNode;
        } else {
            Node current = getTable()[index];
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        count+=1;
        size++;
    }
    
        // Resize the table when the load factor is reached
    private void resizeTable() {
        int newCapacity = getTable().length * 2;
        Node[] newTable = new Node[newCapacity];

        for (Node currentNode : getTable()) {
            while (currentNode != null) {
                int newIndex = hash(currentNode.name);
                Node newNode = new Node(currentNode.name, currentNode.roomNumber);

                if (newTable[newIndex] == null) {
                    newTable[newIndex] = newNode;
                } else {
                    Node current = newTable[newIndex];
                    while (current.next != null) {
                        current = current.next;
                    }
                    current.next = newNode;
                }

                currentNode = currentNode.next;
            }
        }

        table = newTable;
    }
    
    public void printHashTable() {
        for (int i = 0; i < getTable().length; i++) {
            Node current = getTable()[i];
            System.out.print("Index " + i + ": ");
            while (current != null) {
                System.out.print("(" + current.name + ", " + current.roomNumber + ") ");
                current = current.next;
            }
            System.out.println();
        }
    }
    
     public void buscarhab(){
        String nombre = JOptionPane.showInputDialog("Ingrese el primer nombre del huesped: ");
        String apellido = JOptionPane.showInputDialog("Ingrese el apellido del huesped: ");
        String nombrecompleto = nombre+" "+apellido;
        int roomNumber = hashtable.getRoomNumber(nombrecompleto);
        if (roomNumber != -1) {
            JOptionPane.showMessageDialog(null,"Guest " + nombrecompleto + " is staying in room number " + roomNumber);
        } else {
            JOptionPane.showMessageDialog(null,"Guest " + nombrecompleto + " not found.");
        }
    }
    
    
     public int getRoomNumber(String nombrecompleto) {
        int index = hash(nombrecompleto);
        Node current = getTable()[index];

        while (current != null) {
            if (current.name.equals(nombrecompleto)) {
                return current.roomNumber;
            }
            current = current.next;
        }

        return -1; // Guest not found
    }

    /**
     * @return the table
     */
    public Node[] getTable() {
        return table;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }
}


