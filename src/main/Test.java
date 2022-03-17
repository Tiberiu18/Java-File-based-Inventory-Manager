package main;


import Entities.Language;
import Entities.PublishingRetailer;
import main.testcases.*;

import java.util.List;

public final class Test {
    private Test(){}

    public static void runTestCases()
    {
        TestGetAllBooksForRetailerIDs.runTestCases();

        TestGetBooksForPublishingRetailerID.runTestCases();

        TestGetCommonBooksForRetailerIDs.runTestCases();

        TestGetCountriesForBookID.runTestCases();

        TestGetLanguagesForPublishingRetailerID.runTestCases();

    }

}
