/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2edd;

import javax.swing.JOptionPane;

/**
 *
 * @author juanm
 */
public class BST {
      private TreeNode root;

    public BST() {
        this.root = null;
    }
    
    public BST(TreeNode node) {
        this.root = node;
    }

    public TreeNode getRoot() {
        return this.root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }
    
    public void insert(TreeNode root, TreeNode newNode) {
        if (this.root == null) {
            this.root = newNode;
        } else {
            if (newNode.getCedula() < root.getCedula()) {
                if (root.getLeft() == null) {
                    root.setLeft(newNode);
                } else {
                    insert(root.getLeft(), newNode);
                }
            } else if (newNode.getCedula() > root.getCedula()) {
                if (root.getRight() == null) {
                    root.setRight(newNode);
                } else {
                    insert(root.getRight(), newNode);
                }
            } else {
                System.out.println("El elemento ya se encuentra en el Árbol");
            }
        }
    }
    
    
    public TreeNode search(TreeNode aux, int cedula) {
        if (aux == null) return null;
        
        if (aux.getCedula() == cedula) {
            String data = aux.getData();
            System.out.println("Encontrado");
            return aux;
        } else if(cedula < aux.getCedula()) {
            String data = aux.getLeft().getData();
            System.out.println("Encontrado");
            return search(aux.getLeft(), cedula);
        } else {
            String data = aux.getRight().getData();
            System.out.println("Encontrado");
            return search(aux.getRight(), cedula);
        }
    }
    
    public int getNodeLevel(TreeNode aux, int cedula, int level) {
        if (aux == null) return -1;
        
        if (aux.getCedula() == cedula) {
            return level;
        } else if (cedula < aux.getCedula()) {
            return getNodeLevel(aux.getLeft(), cedula, level + 1);
        } else {
            return getNodeLevel(aux.getRight(), cedula, level + 1);
        }
    }
    
    
    public boolean isInTheTree(TreeNode aux, int cedula) {
        if (aux == null) return false;
        
        if (aux.getCedula() == cedula) 
            return true;
        else
            return (isInTheTree(aux.getLeft(), cedula) || isInTheTree(aux.getRight(), cedula));
    }
    
    
    public void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.getLeft());
            System.out.print(root.getCedula() + ",");
            inOrder(root.getRight());
        }
    }
    
    public void preOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.getCedula() + ",");
            inOrder(root.getLeft());
            inOrder(root.getRight());
        }
    }
    
    public void postOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.getLeft());
            inOrder(root.getRight());
            System.out.print(root.getCedula() + ",");
        }
    }
    

    /**
     * ========================================================================
     * METODOS DE BORRADOS, ESTOS NO LOS VOY A EVALUAR
     * ========================================================================
     */
    
    /**
     * SuprimeIzq Metodo para borrar el hijo izquerdo del nodo p
     *
     * @param p
     * @return
     */
    public TreeNode deleteLeft(TreeNode p) {
        if (p.getLeft() != null) {
            TreeNode aux = p.getLeft();
            p.setLeft(null);
            if (aux.getLeft() != null && aux.getRight() != null) {
                TreeNode aux2 = aux.getLeft();
                p.setLeft(aux.getLeft());
                while (aux2.getRight() != null) {
                    aux2 = aux2.getRight();
                }
                aux2.setRight(aux.getRight());
            } else if (aux.getLeft() != null) {
                p.setLeft(aux.getLeft());
            } else if (aux.getRight() != null) {
                p.setLeft(aux.getRight());
            }
            return aux;
        }
        return null;

    }


    public TreeNode deleteRoot() {
        TreeNode aux = this.root;
        this.root = null;
        if (aux.getLeft() != null && aux.getRight() != null) {
            this.root = aux.getRight();
            TreeNode aux2 = aux.getRight();
            while (aux2.getLeft() != null) {
                aux2 = aux2.getLeft();
            }
            aux2.setLeft(aux.getLeft());
            return aux;
        } else if (aux.getLeft() != null) {
            this.root = aux.getLeft();
            return aux;
        } else if (aux.getRight() != null) {
            this.root = aux.getRight();
            return aux;
        }
        return null;
    }

    public TreeNode delete(TreeNode p, int cedula) {
        if (this.root != null && this.root.getCedula() == cedula) {
            return deleteRoot();
        } else if (p.getLeft() != null && p.getLeft().getCedula() == cedula) {
            return deleteLeft(p);
        } else if (p.getRight() != null && p.getRight().getCedula() == cedula) {
            return deleteRight(p);
        }
        return null;
    }

    public TreeNode deleteRight(TreeNode p) {
        if (p.getRight() != null) {
            TreeNode aux = p.getRight();
            p.setRight(null);

            if (aux.getLeft() != null && aux.getRight() != null) {
                TreeNode aux2 = aux.getRight();
                p.setRight(aux.getRight());
                while (aux2.getLeft() != null) {
                    aux2 = aux2.getLeft();
                }
                aux2.setLeft(aux.getLeft());
            } else if (aux.getLeft() != null) {
                p.setRight(aux.getLeft());
            } else if (aux.getRight() != null) {
                p.setRight(aux.getRight());
            }
            return aux;
        }
        return null;
    }
}