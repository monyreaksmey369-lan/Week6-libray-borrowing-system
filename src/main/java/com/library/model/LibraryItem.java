package com.library.model;

public abstract class LibraryItem {
    protected String title;
    protected String author;
    protected double borrowFee;

    public LibraryItem(String title, String author, double borrowFee) {
        this.title = title;
        this.author = author;
        this.borrowFee = borrowFee;
    }

    public String getTitle() {
        return title;
    }

    public double getBorrowFee() {
        return borrowFee;
    }

    public abstract String getItemType();

}
