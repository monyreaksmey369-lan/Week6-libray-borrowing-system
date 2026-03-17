package com.library.service;

import com.library.model.LibraryItem;


public class BorrowService {

    private double memDiscount;

    public BorrowService() {
        this.memDiscount = 0.0;
    }

    public BorrowService(double memDiscount) {
        this.memDiscount = memDiscount;
    }

    public double borrow(LibraryItem item) {
        double totalFee = item.getBorrowFee();
        return applyDiscount(totalFee);
    }

    public double borrow(LibraryItem item, int extraDays) {
        double totalFee = item.getBorrowFee() + (extraDays * 0.5);
        return applyDiscount(totalFee);
    }

    public double borrow(LibraryItem[] items) {
        double totalFee = 0;

        for (LibraryItem item : items) {
            totalFee += item.getBorrowFee();
        }

        return applyDiscount(totalFee);
    }

    public double borrow(LibraryItem[] items, int extraDays) {
        double totalFee = 0;

        for (LibraryItem item : items) {
            totalFee += item.getBorrowFee();
        }

        totalFee += extraDays * 0.5 * items.length;

        return applyDiscount(totalFee);
    }

    private double applyDiscount(double totalFee) {
        return totalFee - (totalFee * memDiscount);
    }
}