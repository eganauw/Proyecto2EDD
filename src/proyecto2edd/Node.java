/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2edd;

/**
 *
 * @author rodri
 */
public class Node {
        public String name;
        public int roomNumber;
        public Node next;

        public Node(String name, int roomNumber) {
            this.name = name;
            this.roomNumber = roomNumber;
            this.next = null;
        }
    }

