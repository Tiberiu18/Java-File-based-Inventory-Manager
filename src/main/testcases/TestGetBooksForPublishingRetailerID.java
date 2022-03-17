package main.testcases;

import Entities.*;
import actions.Administration;

import java.util.List;

import static utils.Printers.printBooks;

public final class TestGetBooksForPublishingRetailerID {
    private TestGetBooksForPublishingRetailerID(){}

    public static void runTestCases()
    {
        System.out.println("*** Get books from a specific publishing-retailer ***");

        // Testcase 1
        System.out.println("----- Testcase 1 -----");
        List<Book> booksForPublishingRetailer = Administration.getBooksForPublishingRetailerID(1);
        printBooks(booksForPublishingRetailer);

        // Testcase 2
        System.out.println("----- Testcase 2 -----");
        booksForPublishingRetailer = Administration.getBooksForPublishingRetailerID(5);
        printBooks(booksForPublishingRetailer);

        // Testcase 3
        System.out.println("----- Testcase 3 -----");
        booksForPublishingRetailer = Administration.getBooksForPublishingRetailerID(17);
        printBooks(booksForPublishingRetailer);

        // Testcase 4
        System.out.println("----- Testcase 4 -----");
        booksForPublishingRetailer = Administration.getBooksForPublishingRetailerID(27);
        printBooks(booksForPublishingRetailer);

        // Testcase 5
        System.out.println("----- Testcase 5 -----");
        booksForPublishingRetailer = Administration.getBooksForPublishingRetailerID(35);
        printBooks(booksForPublishingRetailer);
        System.out.println();
    }
}
