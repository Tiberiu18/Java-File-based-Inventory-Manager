package fileIO;

import Entities.*;

import java.util.List;

public final class ProcessInput {
    private ProcessInput(){}

    private static List<Book> books;
    private static List<Language> languages;
    private static List<Author> authors;
    private static List<Countries> countries;
    private static List<EditorialGroup> editorialGroups;
    private static List<PublishingBrand> publishingBrands;
    private static List<PublishingRetailer> publishingRetailers;

    public static void processInput()
    {
        authors = readInputFiles.readAuthors();
        books = readInputFiles.readBooks();
        languages = readInputFiles.readLanguages();
        editorialGroups = readInputFiles.readEditorialGroup();
        publishingBrands = readInputFiles.readPublishingBrand();
        publishingRetailers = readInputFiles.readPublishingRetailer();
        countries = readInputFiles.readCountries();
        try{
            books = readInputFiles.AssociateBookAuthors(books, authors);
            editorialGroups = readInputFiles.AssociateEditorialGroupBooks(editorialGroups, books);
            publishingBrands = readInputFiles.AssociatePublishingBrandBooks(publishingBrands, books);
            publishingRetailers = readInputFiles.AssociatePublishingRetailerCountries(publishingRetailers, countries);
            publishingRetailers = readInputFiles.AssociatePublishingRetailerBooks(publishingRetailers, books);
            publishingRetailers = readInputFiles.AssociatePublishingRetailerEditorialGroups(publishingRetailers, editorialGroups);
            publishingRetailers = readInputFiles.AssociatePublishingRetailerPublishingBrand(publishingRetailers, publishingBrands);
        }
        catch(NullPointerException ne)
        {
            ne.printStackTrace();
        }
    }

    public static List<Book> getBooks() {
        return books;
    }

    public static void setBooks(List<Book> books) {
        ProcessInput.books = books;
    }

    public static List<Language> getLanguages() {
        return languages;
    }

    public static void setLanguages(List<Language> languages) {
        ProcessInput.languages = languages;
    }

    public static List<Author> getAuthors() {
        return authors;
    }

    public static void setAuthors(List<Author> authors) {
        ProcessInput.authors = authors;
    }

    public static List<Countries> getCountries() {
        return countries;
    }

    public static void setCountries(List<Countries> countries) {
        ProcessInput.countries = countries;
    }

    public static List<EditorialGroup> getEditorialGroups() {
        return editorialGroups;
    }

    public static void setEditorialGroups(List<EditorialGroup> editorialGroups) {
        ProcessInput.editorialGroups = editorialGroups;
    }

    public static List<PublishingBrand> getPublishingBrands() {
        return publishingBrands;
    }

    public static void setPublishingBrands(List<PublishingBrand> publishingBrands) {
        ProcessInput.publishingBrands = publishingBrands;
    }

    public static List<PublishingRetailer> getPublishingRetailers() {
        return publishingRetailers;
    }

    public static void setPublishingRetailers(List<PublishingRetailer> publishingRetailers) {
        ProcessInput.publishingRetailers = publishingRetailers;
    }
}
