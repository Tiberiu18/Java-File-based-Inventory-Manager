package main.testcases;

import Entities.Language;
import Entities.PublishingRetailer;
import actions.Administration;

import java.util.List;

public final class TestGetLanguagesForPublishingRetailerID {
    private TestGetLanguagesForPublishingRetailerID(){}
    private static void printLanguages(List<Language> languages) {
        for(Language language: languages) {
            System.out.println(language);
        }
    }

    /** Get languages of the books from a specific publishing-retailer */
    public static void runTestCases() {
        System.out.println("*** Get languages of the books from a specific publishing-retailer ***");

        // Testcase 1
        System.out.println("----- Testcase 1 -----");
        List<Language> languagesForRetailer = Administration.getLanguagesForPublishingRetailerID(1);
        printLanguages(languagesForRetailer);

        // Testcase 2
        System.out.println("----- Testcase 2 -----");
        languagesForRetailer = Administration.getLanguagesForPublishingRetailerID(5);
        printLanguages(languagesForRetailer);

        // Testcase 3
        System.out.println("----- Testcase 3 -----");
        languagesForRetailer = Administration.getLanguagesForPublishingRetailerID(17);
        printLanguages(languagesForRetailer);

        // Testcase 4
        System.out.println("----- Testcase 4 -----");
        languagesForRetailer = Administration.getLanguagesForPublishingRetailerID(27);
        printLanguages(languagesForRetailer);

        // Testcase 5
        System.out.println("----- Testcase 5 -----");
        languagesForRetailer = Administration.getLanguagesForPublishingRetailerID(35); // idx out of bounds
        printLanguages(languagesForRetailer);
        System.out.println();
    }
}
