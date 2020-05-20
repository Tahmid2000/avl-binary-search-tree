package com.company;

public class Book {

    private String title;
    private String author;

    public Book(){
        title = "";
        author = "";
    }

    public Book(String theTitle, String theAuthor){
        title = theTitle;
        author = theAuthor;
    }

    public String getTitle(){
        return  title;
    }

    public String getAuthor(){
        return author;
    }

    public void setTitle(String t){
        title = t;
    }

    public void setAuthor(String a){
        author = a;
    }
}
