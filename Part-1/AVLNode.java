package com.company;

public class AVLNode {
    String isbn;
    Book value;
    int height;
    AVLNode leftPtr;
    AVLNode rightPtr;
    public AVLNode(Book b, String key){
        isbn = key;
        value = b;
        height = 0;
    }

    public String getIsbn() {
        return isbn;
    }
}
