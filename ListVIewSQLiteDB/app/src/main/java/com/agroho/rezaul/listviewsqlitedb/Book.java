package com.agroho.rezaul.listviewsqlitedb;

/**
 * Created by AKM Rezaul Alam.
 * This book model class
 */
public class Book {
    private int book_id;
    private String book_name;
    private double book_price;

    //empty constructor
    public Book(){

    }

    //constructor with all parameters
    public Book(int book_id, String book_name, double book_price) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.book_price = book_price;
    }

    //constructr witout id as dataase id will be auto incremented we don't need to add id separately
    public Book(String book_name, double book_price) {
        this.book_name = book_name;
        this.book_price = book_price;
    }


    public int getBook_id() {
        return book_id;
    }

    //Getters and Setters
    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public double getBook_price() {
        return book_price;
    }

    public void setBook_price(double book_price) {
        this.book_price = book_price;
    }
}
