/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2edd;

/**
 *
 * @author juanm
 */
public class TreeNode {
       private int cedula;
       private String data;
    private TreeNode left;
    private TreeNode right;
    
    
    public TreeNode(int cedula,String data) {
        this.cedula = cedula;
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
    
    /**
     * Checks whether a node is leaf or not
     *
     * @return
     */
    public boolean isLeaf() {
        return (this.left == null && this.right == null);
    }

    /**
     * Prints the node content
     */
    public void printNode() {
        System.out.println(this.getData());
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }
}