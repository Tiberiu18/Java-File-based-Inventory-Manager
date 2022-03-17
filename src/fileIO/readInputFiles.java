package fileIO;

import Entities.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.text.SimpleDateFormat;

import Common.Constants;
public class readInputFiles {

    public static List<Author> readAuthors()
    {
        String file = Constants.AUTHORS_INPUT_PATH;
        List<Author> authors = new ArrayList<Author>();
        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            br.readLine(); // skips then first line
            String line = null;
            while ((line = br.readLine()) != null )
            {
                String[] lineArr = line.split("###");
                authors.add(new Author(Integer.parseInt(lineArr[0].trim()), lineArr[1], lineArr[2]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return authors;
    }

    public static List<Book> readBooks()
    {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        String file = Constants.BOOKS_INPUT_PATH;
        List<Book> books = new ArrayList<Book>();
        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            br.readLine(); // skips then first line
            String line = null;
            while ((line = br.readLine()) != null )
            {
                String[] lineArr = line.split("###");
                //ID###Name###Subtitle###ISBN###PageCount###Keywords###LanguageId###CreatedOn
                int ID = Integer.parseInt(lineArr[0].trim());
                String name = lineArr[1];
                String Subtitle = lineArr[2];
                String ISBN = lineArr[3];
                int pageCount = Integer.parseInt(lineArr[4].trim());
                String keywords = lineArr[5];
                int languageID = Integer.parseInt(lineArr[6].trim());
                Date createdOn = null;
                try
                {
                    createdOn = format.parse(lineArr[7]);
                }
                catch ( java.text.ParseException e)
                {
                    e.printStackTrace();
                }
                books.add(new Book(ID, name, Subtitle, ISBN, pageCount, keywords, languageID, createdOn));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }


    public static List<Language> readLanguages()
    {
        //Id###Code###Translation
        String file = Constants.LANGUAGES_INPUT_PATH;
        List<Language> languages = new ArrayList<Language>();
        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            br.readLine(); // skips then first line
            String line = null;
            while ((line = br.readLine()) != null )
            {
                String[] lineArr = line.split("###");
                languages.add(new Language(Integer.parseInt(lineArr[0].trim()),lineArr[1], lineArr[2]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return languages;
    }

    public static List<Book> AssociateBookAuthors(List<Book> books, List<Author> authors)
    {
        //BookId###AuthorId
        String file = Constants.BOOKS_AUTHORS_INPUT_PATH;
        List<Book> booksNew = new ArrayList<Book>();
        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            br.readLine(); // skips then first line
            String line = null;
            while ((line = br.readLine()) != null )
            {
                String[] lineArr = line.split("###");
                int bookId = Integer.parseInt(lineArr[0].trim());
                int authorId = Integer.parseInt(lineArr[1].trim());
                Author auxA = null;
                Book auxB = null;
                for(Author a : authors)
                {
                    if(a.getID() == authorId)
                    {
                        auxA = a;
                        break;
                    }
                }
                for(Book b : books)
                {
                    if(b.getID() == bookId)
                    {
                        auxB = b;
                        break;
                    }
                }
                assert auxB != null;
                auxB.getAuthors().add(auxA);
                booksNew.add(auxB);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return booksNew;
    }

    public static List<EditorialGroup> readEditorialGroup()
    {
        //Id###Name
        String file = Constants.EDITORIAL_GROUPS_INPUT_PATH;
        List<EditorialGroup> editorialGroups = new ArrayList<EditorialGroup>();
        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            br.readLine(); // skips then first line
            String line = null;
            while ((line = br.readLine()) != null )
            {
                String[] lineArr = line.split("###");
                editorialGroups.add(new EditorialGroup(Integer.parseInt(lineArr[0].trim()), lineArr[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return editorialGroups;
    }

    public static List<PublishingBrand> readPublishingBrand()
    {
        //Id###Name
        String file = Constants.PUBLISHING_BRANDS_INPUT_PATH;
        List<PublishingBrand> publishingBrands = new ArrayList<PublishingBrand>();
        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            br.readLine(); // skips then first line
            String line = null;
            while ((line = br.readLine()) != null )
            {
                String[] lineArr = line.split("###");
                publishingBrands.add(new PublishingBrand(Integer.parseInt(lineArr[0].trim()), lineArr[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return publishingBrands;
    }

    public static List<EditorialGroup> AssociateEditorialGroupBooks(List<EditorialGroup> editorialGroups, List<Book> books)
    {
        //GroupId###BookId
        String file = Constants.EDITORIAL_GROUPS_BOOKS_INPUT_PATH;
        List<EditorialGroup> editorialGroupsNew = new ArrayList<EditorialGroup>();
        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            br.readLine(); // skips then first line
            String line = null;
            while ((line = br.readLine()) != null )
            {
                String[] lineArr = line.split("###");
                int GroupID = Integer.parseInt(lineArr[0].trim());
                int bookId = Integer.parseInt(lineArr[1].trim());
                EditorialGroup auxEG = null;
                Book auxB = null;
                for(EditorialGroup a : editorialGroups)
                {
                    if(a.getID() == GroupID)
                    {
                        auxEG = a;
                        break;
                    }
                }
                for(Book b : books)
                {
                    if(b.getID() == bookId)
                    {
                        auxB = b;
                        break;
                    }
                }
                assert auxEG != null;
                auxEG.getBooks().add(auxB);
                editorialGroupsNew.add(auxEG);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return editorialGroupsNew;
    }

    public static List<PublishingBrand> AssociatePublishingBrandBooks(List<PublishingBrand> publishingBrands, List<Book> books)
    {
//        PublisherId###BookId
        String file = Constants.PUBLISHING_BRANDS_BOOKS_INPUT_PATH;
        List<PublishingBrand> publishingBrandsNew = new ArrayList<PublishingBrand>();
        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            br.readLine(); // skips then first line
            String line = null;
            while ((line = br.readLine()) != null )
            {
                String[] lineArr = line.split("###");
                int PublisherID = Integer.parseInt(lineArr[0].trim());
                int bookId = Integer.parseInt(lineArr[1].trim());
                PublishingBrand auxPB = null;
                Book auxB = null;
                for(PublishingBrand a : publishingBrands)
                {
                    if(a.getID() == PublisherID)
                    {
                        auxPB= a;
                        break;
                    }
                }
                for(Book b : books)
                {
                    if(b.getID() == bookId)
                    {
                        auxB = b;
                        break;
                    }
                }
                assert auxPB != null;
                auxPB.getBooks().add(auxB);
                publishingBrandsNew.add(auxPB);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return publishingBrandsNew;
    }

    public static List<PublishingRetailer> readPublishingRetailer()
    {
        //Id###Name
        String file = Constants.PUBLISHING_RETAILERS_INPUT_PATH;
        List<PublishingRetailer> publishingRetailers = new ArrayList<PublishingRetailer>();
        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            br.readLine(); // skips then first line
            String line = null;
            while ((line = br.readLine()) != null )
            {
                String[] lineArr = line.split("###");
                publishingRetailers.add(new PublishingRetailer(Integer.parseInt(lineArr[0].trim()), lineArr[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return publishingRetailers;
    }

    public static List<Countries> readCountries()
    {
        //ID###CountryCode
        String file = Constants.COUNTRIES_INPUT_PATH;
        List<Countries> countries = new ArrayList<Countries>();
        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            br.readLine(); // skips then first line
            String line = null;
            while ((line = br.readLine()) != null )
            {
                String[] lineArr = line.split("###");
                countries.add(new Countries(Integer.parseInt(lineArr[0].trim()),lineArr[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countries;
    }

    public static List<PublishingRetailer> AssociatePublishingRetailerCountries(List<PublishingRetailer> publishingRetailer, List<Countries> countries)
    {
//       RetailerId###CountryId
        String file = Constants.PUBLISHING_RETAILERS_COUNTRIES_INPUT_PATH;
        List<PublishingRetailer> publishingRetailersNew = new ArrayList<PublishingRetailer>();
        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            br.readLine(); // skips then first line
            String line = null;
            while ((line = br.readLine()) != null )
            {
                String[] lineArr = line.split("###");
                int RetailerId = Integer.parseInt(lineArr[0].trim());
                int CountryId = Integer.parseInt(lineArr[1].trim());
                PublishingRetailer auxPR = null;
                Countries auxC = null;
                for(PublishingRetailer a : publishingRetailer)
                {
                    if(a.getID() == RetailerId)
                    {
                        auxPR= a;
                        break;
                    }
                }
                for(Countries b : countries)
                {
                    if(b.getID() == CountryId)
                    {
                        auxC = b;
                        break;
                    }
                }
                assert auxPR != null;
                auxPR.getCountries().add(auxC);
                publishingRetailersNew.add(auxPR);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return publishingRetailersNew;
    }

    public static List<PublishingRetailer> AssociatePublishingRetailerBooks(List<PublishingRetailer> publishingRetailer, List<Book> books)
    {
//       RetailerId###BookId
        String file = Constants.PUBLISHING_RETAILERS_BOOKS_INPUT_PATH;
        List<PublishingRetailer> publishingRetailersNew = new ArrayList<PublishingRetailer>();
        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            br.readLine(); // skips then first line
            String line = null;
            while ((line = br.readLine()) != null )
            {
                String[] lineArr = line.split("###");
                int RetailerId = Integer.parseInt(lineArr[0].trim());
                int bookId = Integer.parseInt(lineArr[1].trim());
                PublishingRetailer auxPR = null;
                Book auxC = null;
                for(PublishingRetailer a : publishingRetailer)
                {
                    if(a.getID() == RetailerId)
                    {
                        auxPR= a;
                        break;
                    }
                }
                for(Book b : books)
                {
                    if(b.getID() == bookId)
                    {
                        auxC = b;
                        break;
                    }
                }
                assert auxPR != null;
                auxPR.getPublishingArtifacts().add(auxC);
                if( !(publishingRetailersNew.contains(auxPR)))
                    publishingRetailersNew.add(auxPR);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return publishingRetailersNew;
    }

    public static List<PublishingRetailer> AssociatePublishingRetailerEditorialGroups(List<PublishingRetailer> publishingRetailer, List<EditorialGroup> editorialGroups)
    {
//       RetailerId###GroupId
        String file = Constants.PUBLISHING_RETAILERS_EDITORIAL_GROUPS_INPUT_PATH;
        Set<PublishingRetailer> publishingRetailersNew = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            br.readLine(); // skips then first line
            String line = null;
            while ((line = br.readLine()) != null )
            {
                String[] lineArr = line.split("###");
                int RetailerId = Integer.parseInt(lineArr[0].trim());
                int GroupId = Integer.parseInt(lineArr[1].trim());
                PublishingRetailer auxPR = null;
                EditorialGroup auxEG = null;
                for(PublishingRetailer a : publishingRetailer)
                {
                    if(a.getID() == RetailerId)
                    {
                        auxPR= a;
                        break;
                    }
                }
                for(EditorialGroup b : editorialGroups)
                {
                    if(b.getID() == GroupId)
                    {
                        auxEG = b;
                        break;
                    }
                }
                assert auxPR != null;
                auxPR.getPublishingArtifacts().add(auxEG);
                publishingRetailersNew.add(auxPR);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(publishingRetailersNew);
    }

    public static List<PublishingRetailer> AssociatePublishingRetailerPublishingBrand(List<PublishingRetailer> publishingRetailer, List<PublishingBrand> publishingBrands)
    {
//      RetailerId###PublisherId
        String file = Constants.PUBLISHING_RETAILERS_PUBLISHING_BRANDS_INPUT_PATH;
        Set<PublishingRetailer> publishingRetailersNew = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            br.readLine(); // skips then first line
            String line = null;
            while ((line = br.readLine()) != null )
            {
                String[] lineArr = line.split("###");
                int RetailerId = Integer.parseInt(lineArr[0].trim());
                int PublisherId = Integer.parseInt(lineArr[1].trim());
                PublishingRetailer auxPR = null;
                PublishingBrand auxPB = null;
                for(PublishingRetailer a : publishingRetailer)
                {
                    if(a.getID() == RetailerId)
                    {
                        auxPR= a;
                        break;
                    }
                }
                for(PublishingBrand b : publishingBrands)
                {
                    if(b.getID() == PublisherId)
                    {
                        auxPB = b;
                        break;
                    }
                }
                assert auxPR != null;
                auxPR.getPublishingArtifacts().add(auxPB);
                publishingRetailersNew.add(auxPR);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(publishingRetailersNew);
    }
}
