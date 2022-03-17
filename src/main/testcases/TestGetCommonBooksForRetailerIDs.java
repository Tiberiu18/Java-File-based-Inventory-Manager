package main.testcases;

import Entities.Book;
import Entities.PublishingRetailer;
import actions.Administration;

import java.util.List;

import static utils.Printers.printBooks;

public final class TestGetCommonBooksForRetailerIDs {
    private TestGetCommonBooksForRetailerIDs(){}

    public static void runTestCases() {
        System.out.println("*** Get common books for 2 retailers ***");

        // Testcase 1
        System.out.println("----- Testcase 1 -----");
        List<Book> commonBooks = Administration.getCommonBooksForRetailerIDs(1, 6);
        printBooks(commonBooks);

        // Testcase 2
        System.out.println("----- Testcase 2 -----");
        commonBooks = Administration.getCommonBooksForRetailerIDs(7, 13);
        printBooks(commonBooks);

        // Testcase 3
        System.out.println("----- Testcase 3 -----");
        commonBooks = Administration.getCommonBooksForRetailerIDs(19, 7);
        printBooks(commonBooks);

        // Testcase 4
        System.out.println("----- Testcase 4 -----");
        commonBooks = Administration.getCommonBooksForRetailerIDs(36, 16);
        printBooks(commonBooks);

        // Testcase 5
        System.out.println("----- Testcase 5 -----");
        commonBooks = Administration.getCommonBooksForRetailerIDs(25, 39);
        printBooks(commonBooks);

        // Testcase 6
        System.out.println("----- Testcase 6 -----");
        commonBooks = Administration.getCommonBooksForRetailerIDs(37, 55);
        printBooks(commonBooks);
        System.out.println();
    }
}
