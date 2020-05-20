package com.company;

import java.util.*;

public class BinaryTree {
    BinaryNode root;

    public BinaryTree(){
        root = null;
    }

    private int getHeight(BinaryNode node){
        if(node == null)
            return -1;
        return node.height = 1 + Math.max(getHeight(node.leftPtr), getHeight(node.rightPtr));
    }

    private int getBalance(BinaryNode node){
        return getHeight(node.leftPtr) - getHeight(node.rightPtr);
    }

    public void insert(int key){
        Random rand = new Random();
        int leftright = rand.nextInt(2); //bias
        insert(root, key, leftright);
    }

    private void insert(BinaryNode node, int key, int lr) {
        if(root == null){
            root = new BinaryNode(key);
            return;
        }
        else if (lr == 0) {
            if (node.leftPtr != null) {
                insert(node.leftPtr, key, lr);
            }
            else {
                node.leftPtr = new BinaryNode(key);
                return;
            }
        }
        else if (lr == 1) {
            if (node.rightPtr != null) {
                insert(node.rightPtr, key, lr);
            }
            else {
                node.rightPtr = new BinaryNode(key);
                return;
            }
        }
    }

    public void printInorder(){
        printInorder(root);
    }

    private void printInorder(BinaryNode node)
    {
        if (node == null)
            return;
        System.out.print(node.key + " ");
        printInorder(node.leftPtr);
        printInorder(node.rightPtr);
    }

    public boolean isBst(){
        return isBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBst(BinaryNode node, int min, int max){
        if (node == null) return true;
        if (node.key <= min) return false;
        if (node.key >= max) return false;
        return isBst(node.leftPtr, min, node.key) && isBst(node.rightPtr, node.key, max);
    }

    public boolean isAvl(){
        if(isBst() == false)
            return false;
        return isAvl(root);
    }

    private boolean isAvl(BinaryNode node){
        if(node == null)
            return true;
        if(getBalance(node) > 1 || getBalance(node) < -1)
            return false;
        return isAvl(node.leftPtr) && isAvl(node.rightPtr);

    }
}

class BinaryNode{
    int key;
    BinaryNode leftPtr, rightPtr;
    int height;

    public BinaryNode(int key){
        this.key = key;
        leftPtr = null;
        rightPtr = null;
        height = 0;
    }
}