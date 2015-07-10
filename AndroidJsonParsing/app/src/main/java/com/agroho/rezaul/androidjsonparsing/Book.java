package com.agroho.rezaul.androidjsonparsing;

/**
 * Created by ASUS on 7/10/2015.
 */
public class Book {
    private String BookName;
    private double BookPrice;

    public Book(){

    }

    public Book( String bookName, double bookPrice) {
        super();
        BookName = bookName;
        BookPrice = bookPrice;
    }



    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public double getBookPrice() {
        return BookPrice;
    }

    public void setBookPrice(double bookPrice) {
        BookPrice = bookPrice;
    }
}
