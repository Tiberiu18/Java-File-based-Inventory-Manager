package actions;

import Entities.*;
import fileIO.ProcessInput;
import utils.FilterEntitiesByID;

import java.util.*;

public class Administration {

    public static List<Book> getBooksForPublishingRetailerID(int publishingRetailerID)
    {
        List<PublishingRetailer> publishingRetailers = ProcessInput.getPublishingRetailers();
        Set<Book> books_Set = new HashSet<>();
        PublishingRetailer aux = null;
        for(PublishingRetailer PR : publishingRetailers)
        {
            if(publishingRetailerID == PR.getID())
                aux = PR;
        }

        if(aux == null){
            System.out.println("The retailer with the ID " + publishingRetailerID +" is not in the database!");
            return Collections.emptyList();
        }

        List<IPublishingArtifact> ipa = aux.getPublishingArtifacts();
        for(IPublishingArtifact i : ipa)
        {
            if(i instanceof Book)
            {
                Book b = (Book)i;
                books_Set.add(b);
            }
            else if(i instanceof EditorialGroup)
            {
                EditorialGroup e = (EditorialGroup)i;
                books_Set.addAll(e.getBooks());
            }
            else if(i instanceof PublishingBrand)
            {
                PublishingBrand pb = (PublishingBrand)i;
                books_Set.addAll(pb.getBooks());
            }
            else
                break;
        }

        return new ArrayList<>(books_Set);
    }

    //getLanguagesForPublishingRetailerID(int publishingReatilerID) – Limbile în care sunt publicate
    //cărțile unui retailer – metodă care întoarce o listă de limbi și primeste ca parametru un
    // publishing retailer ID

    public static List<Language> getLanguagesForPublishingRetailerID(int publishingRetailerID)
    {
        List<PublishingRetailer> publishingRetailers = ProcessInput.getPublishingRetailers();
        List<Language> totalLanguages = ProcessInput.getLanguages();
        List<Book> books = getBooksForPublishingRetailerID(publishingRetailerID);
        Set<Language> languages = new HashSet<>();
        for(Book b: books)
        {
            for(Language lg : totalLanguages)
            {
                if(b.getLanguageID() == lg.getID())
                    languages.add(lg);
            }
        }
        return new ArrayList<>(languages);
    }
    //getCountriesForBookID(int bookID) – Țările în care o carte a ajuns – metodă care întoarce o listă
    //de țări și primește ca parametru un book ID
    public static List<Countries> getCountriesForBookID(int bookID)
    {
        //Get book
        Book book = utils.FilterEntitiesByID.filterBooksByID(ProcessInput.getBooks(), bookID);

        //Check if book exists in db
        if (book == null)
        {
            System.out.println("The book with ID " + bookID +" is not present in database!");
            return Collections.emptyList();
        }

        List<Countries> countries = new ArrayList<>();

        List<PublishingRetailer> publishingRetailers = ProcessInput.getPublishingRetailers();
        for(PublishingRetailer p : publishingRetailers)
        {
            List<Book> booksForRetailer = getBooksForPublishingRetailerID(p.getID());
            if(booksForRetailer.contains(book))
            {
                countries.addAll(p.getCountries());
            }
        }

        return countries;
    }

    //getCommonBooksForRetailerIDs(int retailerID1, int retailerID2) – Cărți comune între retaileri –
    //metodă care întoarce o listă de cărți comune între retaileri și primește ca parametru două ID-uri
    //de retaileri
    public static List<Book> getCommonBooksForRetailerIDs(int retailerID1, int retailerID2)
    {

        Set<Book> retailer1Books = new HashSet<>();
        Set<Book> retailer2Books = new HashSet<>();
        List<PublishingRetailer> publishingRetailers = ProcessInput.getPublishingRetailers();
        List<IPublishingArtifact> retailer1Artifacts = new ArrayList<>();
        List<IPublishingArtifact> retailer2Artifacts = new ArrayList<>();

        PublishingRetailer retailer1 = FilterEntitiesByID.filterPublishingRetailersByID(publishingRetailers, retailerID1);
        PublishingRetailer retailer2 = FilterEntitiesByID.filterPublishingRetailersByID(publishingRetailers, retailerID2);

        if(retailer1 != null && retailer2 != null)
        {
            retailer1Artifacts = retailer1.getPublishingArtifacts();
            retailer2Artifacts = retailer2.getPublishingArtifacts();
        }

        if(retailer1 == null)
            System.out.println("The Publisher Retail with the ID "+retailerID1 +" is not present in the database");
        if(retailer2 == null)
            System.out.println("The Publisher Retail with the ID "+retailerID2 +" is not present in the database");
        if(retailer1Artifacts != null && retailer2Artifacts != null)
        {
            for(IPublishingArtifact i : retailer1Artifacts)
            {
                if(i instanceof Book)
                {
                    Book b = (Book)i;
                    retailer1Books.add(b);
                }
                else if(i instanceof EditorialGroup)
                {
                    EditorialGroup e = (EditorialGroup)i;
                    retailer1Books.addAll(e.getBooks());
                }
                else if(i instanceof PublishingBrand)
                {
                    PublishingBrand pb = (PublishingBrand)i;
                    retailer1Books.addAll(pb.getBooks());
                }
                else
                    break;
            }
            for(IPublishingArtifact i : retailer2Artifacts)
            {
                if(i instanceof Book)
                {
                    Book b = (Book)i;
                    retailer2Books.add(b);
                }
                else if(i instanceof EditorialGroup)
                {
                    EditorialGroup e = (EditorialGroup)i;
                    retailer2Books.addAll(e.getBooks());
                }
                else if(i instanceof PublishingBrand)
                {
                    PublishingBrand pb = (PublishingBrand)i;
                    retailer2Books.addAll(pb.getBooks());
                }
                else
                    break;
            }
        }

        retailer1Books.retainAll(retailer2Books);
        return new ArrayList<>(retailer1Books);
    }

    //getAllBooksForRetailerIDs (int retailerID1, int retailerID2) - Cărți ale retailerilor (union) –
    // metodă care întoarce o listă de cărți între retaileri (uniunea celor două liste) și primește ca parametru două ID-uri de retaileri
    public static List<Book> getAllBooksForRetailerIDs(int retailerID1, int retailerID2)
    {
        List<PublishingRetailer> publishingRetailers = ProcessInput.getPublishingRetailers();
        Set<Book> allBooks = new HashSet<>();
        List<IPublishingArtifact> retailer1Artifacts = new ArrayList<>();
        List<IPublishingArtifact> retailer2Artifacts = new ArrayList<>();
        boolean found1 = false;
        boolean found2 = false;
        for(PublishingRetailer p:publishingRetailers)
        {
            if(p.getID() == retailerID1)
            {
                retailer1Artifacts = p.getPublishingArtifacts();
                found1 = true;
            }
            else if(p.getID() == retailerID2)
            {
                retailer2Artifacts = p.getPublishingArtifacts();
                found2 = true;
            }
        }
        if(!found1)
            System.out.println("The retailer with the ID "+retailerID1 + " is not present in database!");
        if (!found2)
            System.out.println("The retailer with the ID "+retailerID2 + " is not present in database!");
        Set<Book> retailer1Books = new HashSet<>();
        Set<Book> retailer2Books = new HashSet<>();
        for(IPublishingArtifact i : retailer1Artifacts)
        {
            if(i instanceof Book)
            {
                Book b = (Book)i;
                retailer1Books.add(b);
            }
            else if(i instanceof EditorialGroup)
            {
                EditorialGroup e = (EditorialGroup)i;
                retailer1Books.addAll(e.getBooks());
            }
            else if(i instanceof PublishingBrand)
            {
                PublishingBrand pb = (PublishingBrand)i;
                retailer1Books.addAll(pb.getBooks());
            }
            else
                break;
        }
        for(IPublishingArtifact i : retailer2Artifacts)
        {
            if(i instanceof Book)
            {
                Book b = (Book)i;
                retailer2Books.add(b);
            }
            else if(i instanceof EditorialGroup)
            {
                EditorialGroup e = (EditorialGroup)i;
                retailer2Books.addAll(e.getBooks());
            }
            else if(i instanceof PublishingBrand)
            {
                PublishingBrand pb = (PublishingBrand)i;
                retailer2Books.addAll(pb.getBooks());
            }
            else
                break;
        }

        allBooks.addAll(retailer1Books);
        allBooks.addAll(retailer2Books);
        return new ArrayList<>(allBooks);
    }
}
