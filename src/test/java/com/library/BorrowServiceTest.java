package com.library;

import com.library.model.Book;
import com.library.model.Magazine;
import com.library.model.LibraryItem;
import com.library.service.BorrowService;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

public class BorrowServiceTest {

    private static final double EPS = 0.0001;

    // -----------------------------
    // Constructor Overloading Tests
    // -----------------------------

    @Test
    public void testDefaultConstructorExists() throws Exception {
        Constructor<BorrowService> constructor =
                BorrowService.class.getConstructor();

        assertNotNull(constructor);
    }

    @Test
    public void testDiscountConstructorExists() throws Exception {
        Constructor<BorrowService> constructor =
                BorrowService.class.getConstructor(double.class);

        assertNotNull(constructor);
    }

    // -----------------------------
    // Method Overloading Tests
    // -----------------------------

    @Test
    public void testBorrowMethodSingleExists() throws Exception {
        Method method =
                BorrowService.class.getMethod("borrow", LibraryItem.class);

        assertNotNull(method);
    }

    @Test
    public void testBorrowMethodExtraDaysExists() throws Exception {
        Method method =
                BorrowService.class.getMethod("borrow", LibraryItem.class, int.class);

        assertNotNull(method);
    }

    @Test
    public void testBorrowMethodMultipleItemsExists() throws Exception {
        Method method =
                BorrowService.class.getMethod("borrow", LibraryItem[].class);

        assertNotNull(method);
    }

    @Test
    public void testBorrowMethodMultipleItemsExtraDaysExists() throws Exception {
        Method method =
                BorrowService.class.getMethod("borrow", LibraryItem[].class, int.class);

        assertNotNull(method);
    }

    // -----------------------------
    // Borrow Logic Tests
    // -----------------------------

    @Test
    public void testBorrowSingleBook() {

        BorrowService service = new BorrowService();

        Book book = new Book("Clean Code", "Robert Martin");

        double result = service.borrow(book);

        assertEquals(2.0, result, EPS);
    }

    @Test
    public void testBorrowBookWithExtraDays() {

        BorrowService service = new BorrowService();

        Book book = new Book("Clean Code", "Robert Martin");

        double result = service.borrow(book, 4);

        double expected = 2.0 + (4 * 0.5);

        assertEquals(expected, result, EPS);
    }

    @Test
    public void testBorrowMultipleItems() {

        BorrowService service = new BorrowService();

        Book book = new Book("Clean Code", "Robert Martin");
        Magazine magazine = new Magazine("Tech Monthly", "Editorial");

        LibraryItem[] items = {book, magazine};

        double result = service.borrow(items);

        double expected = 2.0 + 1.5;

        assertEquals(expected, result, EPS);
    }

    @Test
    public void testBorrowMultipleItemsExtraDays() {

        BorrowService service = new BorrowService();

        Book book = new Book("Clean Code", "Robert Martin");
        Magazine magazine = new Magazine("Tech Monthly", "Editorial");

        LibraryItem[] items = {book, magazine};

        double result = service.borrow(items, 3);

        double expected =
                (2.0 + 1.5) + (3 * 0.5 * 2);

        assertEquals(expected, result, EPS);
    }

    // -----------------------------
    // Discount Logic Tests
    // -----------------------------

    @Test
    public void testDiscountConstructor() {

        BorrowService service = new BorrowService(0.1);

        Book book = new Book("Clean Code", "Robert Martin");

        double result = service.borrow(book);

        double expected = 2.0 - (2.0 * 0.1);

        assertEquals(expected, result, EPS);
    }

    // -----------------------------
    // Inheritance Check
    // -----------------------------

    @Test
    public void testBookInheritance() {

        Book book = new Book("Clean Code", "Robert Martin");

        assertTrue(book instanceof LibraryItem);
    }

    @Test
    public void testMagazineInheritance() {

        Magazine magazine = new Magazine("Tech Monthly", "Editorial");

        assertTrue(magazine instanceof LibraryItem);
    }

}