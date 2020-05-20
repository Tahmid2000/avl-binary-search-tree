package com.company;

public class AVLTree {

    private AVLNode root;
    private String result;

    public AVLTree(){
        root = null;
    }

    private int getHeight(AVLNode node){
        if(node == null)
            return -1;
        return node.height;
    }

    private int getBalance(AVLNode node){
        return getHeight(node.leftPtr) - getHeight(node.rightPtr);
    }

    public void insert(Book b, String key){
        if(b == null)
            return;
        root = insert(root, b, key);
    }
    private AVLNode insert(AVLNode node, Book b, String key) {
        if (node == null) {
            return (new AVLNode(b, key));
        }
        else if (key.compareTo(node.isbn) < 0) {
         node.leftPtr = insert(node.leftPtr, b, key);
     }
     else if (key.compareTo(node.isbn) > 0)
         node.rightPtr = insert(node.rightPtr, b, key);
     else {
         node.value = b;
         return node;
     }
     node.height = 1 + Math.max(getHeight(node.leftPtr), getHeight(node.rightPtr));
     return balancer(node, key);
    }

    private AVLNode balancer(AVLNode node, String key) {
        result = "Balanced";
        if (getBalance(node) < -1) {
            if (getBalance(node.rightPtr) > 0) { //RightLeft
                node.rightPtr = rotateRight(node.rightPtr);
                result = "Imbalance occurred at inserting ISBN " + key + "; fixed in RightLeft Rotation.";
            }
            if(result == "Balanced")
                result = "Imbalance occurred at inserting ISBN " + key + "; fixed in Left Rotation."; //Right Right
            node = rotateLeft(node);
        }
        else if (getBalance(node) > 1) {
            if (getBalance(node.leftPtr) < 0) { //LeftRight
                node.leftPtr = rotateLeft(node.leftPtr);
                if(result == "Balanced")
                    result = "Imbalance occurred at inserting ISBN " + key + "; fixed in LeftRight Rotation.";
            }
            if(result == "Balanced")
                result = "Imbalance occurred at inserting ISBN " + key + "; fixed in Right Rotation."; //LeftLeft
            node = rotateRight(node);
        }
        return node;
    }

    private AVLNode rotateRight(AVLNode node) {
        AVLNode node2 = node.leftPtr;
        node.leftPtr = node2.rightPtr;
        node2.rightPtr = node;
        node.height = 1 + Math.max(getHeight(node.leftPtr), getHeight(node.rightPtr));
        node2.height = 1 + Math.max(getHeight(node2.leftPtr), getHeight(node2.rightPtr));
        return node2;
    }

    private AVLNode rotateLeft(AVLNode node) {
        AVLNode node2 = node.rightPtr;
        node.rightPtr = node2.leftPtr;
        node2.leftPtr = node;
        node.height = 1 + Math.max(getHeight(node.leftPtr), getHeight(node.rightPtr));
        node2.height = 1 + Math.max(getHeight(node2.leftPtr), getHeight(node2.rightPtr));
        return node2;
    }

    public AVLNode getRoot(){
        return root;
    }

    public String getResult(){
        return result;
    }
}