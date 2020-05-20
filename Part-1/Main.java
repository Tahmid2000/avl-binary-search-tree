package com.company;
import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        File file = new File("/Users/tahmidimran/Desktop/3345 Projects/src/com/company/books.txt");
        String line;
        String[] arr;
        try{
            BufferedReader in = new BufferedReader(new FileReader(file));
            if(!in.ready())
                throw new IOException();
            line = in.readLine();
            while (line != null) {
                arr = line.split(" ");
                Book b = new Book(arr[1], arr[2]);
                tree.insert(b, arr[0]);
                if(tree.getResult() != null && tree.getResult() != "Balanced")
                    System.out.println(tree.getResult());
                line = in.readLine();
            }
            in.close();
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
    }
}