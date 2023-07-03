/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2edd;

/**
 *
 * @author rodri
 */
public class BST2 {
    private Habitacion root;

    public BST2() {
        this.root = null;
    }
    
    public BST2(Habitacion habitacion) {
        this.root = habitacion;
    }

    public Habitacion getRoot() {
        return this.root;
    }

    public void setRoot(Habitacion root) {
        this.root = root;
    }
    
    public void insert(Habitacion root, Habitacion habitacion) {
        if (this.root == null) {
            this.root = habitacion;
        } else {
            if (habitacion.getNumero() < root.getNumero()) {
                if (root.getLeft() == null) {
                    root.setLeft(habitacion);
                } else {
                    insert(root.getLeft(), habitacion);
                }
            } else if (habitacion.getNumero() > root.getNumero()){
                if (root.getRight() == null) {
                    root.setRight(habitacion);
                } else {
                    insert(root.getRight(), habitacion);
                }
            } else {
                System.out.println("El elemento ya se encuentra en el Árbol");
            }
        }
    }
    
    
    public Habitacion search(Habitacion aux, int numero) {
        if (aux == null) return null;
        
        if (aux.getNumero() == numero) {
            return aux;
        } else if(numero < aux.getNumero()) {
            return search(aux.left, numero);
        } else {
            return search(aux.right, numero);
        }
    }
    
    public int getNodeLevel(Habitacion aux, int numero, int level) {
        if (aux == null) return -1;
        
        if (aux.getNumero() == numero) {
            return level;
        } else if (numero < aux.getNumero()) {
            return getNodeLevel(aux.getLeft(), numero, level + 1);
        } else {
            return getNodeLevel(aux.getRight(), numero, level + 1);
        }
    }
    
    
    public boolean isInTheTree(Habitacion aux, int numero) {
        if (aux == null) return false;
        
        if (aux.getNumero() == numero) 
            return true;
        else
            return (isInTheTree(aux.getLeft(), numero) || isInTheTree(aux.getRight(), numero));
    }
    
    
    public void inOrder(Habitacion root) {
        if (root != null) {
            inOrder(root.getLeft());
            System.out.print(root.getNumero() + ",");
            inOrder(root.getRight());
        }
    }
    
    public void preOrder(Habitacion root) {
        if (root != null) {
            System.out.print(root.getNumero() + ",");
            inOrder(root.getLeft());
            inOrder(root.getRight());
        }
    }
    
    public void postOrder(Habitacion root) {
        if (root != null) {
            inOrder(root.getLeft());
            inOrder(root.getRight());
            System.out.print(root.getNumero() + ",");
        }
    }

}
