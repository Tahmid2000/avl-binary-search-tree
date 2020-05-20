package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("How many trees do you want to generate?");
        int num = scan.nextInt();
        System.out.println("How many elements in each tree would you like?");
        int trees = scan.nextInt();
        int count = 0;
        int counterBST = 0;
        int counterAVL = 0;
        while (count != num) {
            BinaryTree tree2 = new BinaryTree();
            for (int i = 0; i < trees; i++) {
                Random rand = new Random();
                tree2.insert(rand.nextInt(50));
            }
            if(tree2.isAvl())
                counterAVL++;
            if(tree2.isBst())
                counterBST++;

            count++;
        }
        if(num == 1){
            if(counterBST == 1)
                System.out.println("The tree is a BST");
            else
                System.out.println("The tree is not a BST");

            if(counterAVL == 1)
                System.out.println("The tree is a AVL");
            else
                System.out.println("The tree is not a AVL");
        }
        else {
            System.out.println("BST Trees: " + counterBST + " out of " + num + " Binary Trees satisfy the BST conditions.");
            System.out.println("AVL Trees: " + counterAVL + " out of " + num + " Binary Trees satisfy the AVL conditions.");
        }
    }
}
