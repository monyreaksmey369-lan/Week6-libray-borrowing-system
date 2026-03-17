package com.library.model;

public class Book extends LibraryItem {

    public Book(String title, String author) {
        super(title, author, 2.0);
    }

    @Override
    public String getItemType() {
        return "Book";
    }

}
