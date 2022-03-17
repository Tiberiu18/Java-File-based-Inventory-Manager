package main;

import Entities.*;
import actions.Administration;
import fileIO.ProcessInput;
import fileIO.readInputFiles;

import java.time.Instant;
import java.util.Date;
import java.util.List;


public final class TestAll {

    public static void main(String[] args) {
        ProcessInput.processInput();
        Test.runTestCases();
    }

}