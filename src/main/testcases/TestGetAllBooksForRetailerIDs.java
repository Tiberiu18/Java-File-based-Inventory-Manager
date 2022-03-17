package main.testcases;

import Entities.Book;
import Entities.PublishingRetailer;
import actions.Administration;

import java.util.List;
import static utils.Printers.printBooks;

public final class TestGetAllBooksForRetailerIDs {
    private TestGetAllBooksForRetailerIDs(){}

    public static void runTestCases()
    {
        System.out.println("--- Union of books for 2 retailers ---");

        System.out.println("---- Testcase 1 ----");
        List<Book> unionOfBooks = Administration.getAllBooksForRetailerIDs(1, 6);
        printBooks(unionOfBooks);

        System.out.println("---- Testcase 2 ----");
        unionOfBooks = Administration.getAllBooksForRetailerIDs(7, 13);
        printBooks(unionOfBooks);

        // Testcase 3
        System.out.println("----- Testcase 3 -----");
        unionOfBooks = Administration.getAllBooksForRetailerIDs(36, 16); // idx1 out of bounds
        printBooks(unionOfBooks);

        // Testcase 4
        System.out.println("----- Testcase 4 -----");
        unionOfBooks = Administration.getAllBooksForRetailerIDs(25, 39); // idx2 out of bounds
        printBooks(unionOfBooks);

        // Testcase 5
        System.out.println("----- Testcase 5 -----");
        unionOfBooks = Administration.getAllBooksForRetailerIDs(37, 55); // both idxs out of bounds
        printBooks(unionOfBooks);
        System.out.println();
    }

}
