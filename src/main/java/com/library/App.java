package com.library;
import com.library.model.Book;
import com.library.model.LibraryItem;
import com.library.model.Magazine;
import com.library.service.BorrowService;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        Book book = new Book("Clean Code", "Robert Martin");
        Magazine magazine = new Magazine("Tech Monthly", "Editorial Team");

        BorrowService service = new BorrowService();

        System.out.println(service.borrow(book));
        System.out.println(service.borrow(book, 3));

        LibraryItem[] items = {book, magazine};

        System.out.println(service.borrow(items));
        System.out.println(service.borrow(items, 2));

        BorrowService discountService = new BorrowService(0.1);
        System.out.println(discountService.borrow(book));
    }
}
