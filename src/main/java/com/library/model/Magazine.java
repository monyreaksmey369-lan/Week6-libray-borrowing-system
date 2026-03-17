package com.library.model;

public class Magazine extends LibraryItem{

    public Magazine(String title, String author) {
        super(title, author, 1.5);
    }

    @Override
    public String getItemType() {
        return "Magazize";
    }

}
