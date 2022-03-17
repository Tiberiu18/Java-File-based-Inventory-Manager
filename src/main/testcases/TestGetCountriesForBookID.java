package main.testcases;

import Entities.Countries;
import Entities.PublishingRetailer;
import actions.Administration;

import java.util.List;

public final class TestGetCountriesForBookID {
    private TestGetCountriesForBookID(){}

    private static void printCountries(List<Countries> countries) {
        for (Countries country : countries) {
            System.out.println(country);
        }
    }
    public static void runTestCases()
    {
        System.out.println("*** Get countries for a specific book ***");

        // Testcase 1
        System.out.println("----- Testcase 1 -----");
        List<Countries> countriesForBook = Administration.getCountriesForBookID(262);
        printCountries(countriesForBook);

        // Testcase 2
        System.out.println("----- Testcase 2 -----");
        countriesForBook = Administration.getCountriesForBookID(1353);
        printCountries(countriesForBook);


        // Testcase 3
        System.out.println("----- Testcase 3 -----");
        countriesForBook = Administration.getCountriesForBookID(11738);
        printCountries(countriesForBook);

        // Testcase 4
        System.out.println("----- Testcase 4 -----");
        countriesForBook = Administration.getCountriesForBookID(14407);
        printCountries(countriesForBook);

        // Testcase 5
        System.out.println("----- Testcase 5 -----");
        countriesForBook = Administration.getCountriesForBookID(717); // there's no book with this idx
        printCountries(countriesForBook);
        System.out.println();
    }
}
