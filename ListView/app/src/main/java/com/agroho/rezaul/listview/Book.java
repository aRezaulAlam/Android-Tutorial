package com.agroho.rezaul.listview;

/**
 * Created by AKM Rezaul Alam on 7/7/2015.
 */
public class Book {

    private int drawableID;
    private String BookName;
    private double BookPrice;


    public Book(int drawableID, String bookName, double bookPrice) {
        super();
        this.drawableID = drawableID;
        BookName = bookName;
        BookPrice = bookPrice;
    }

    public int getDrawableID() {
        return drawableID;
    }

    public void setDrawableID(int drawableID) {
        this.drawableID = drawableID;
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
