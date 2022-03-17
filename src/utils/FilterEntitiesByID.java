package utils;

import Entities.*;

import java.util.List;
import java.util.logging.Filter;
import java.util.stream.Collectors;

public final class FilterEntitiesByID {
    private FilterEntitiesByID(){}

    public static EditorialGroup filterEditorialGroupsByID(List<EditorialGroup> editorialGroups, int ID)
    {
        List<EditorialGroup> filteredEditorialGroup = editorialGroups.stream().filter(p->p.getID() == ID).collect(Collectors.toList());
        if(filteredEditorialGroup.isEmpty())
            return null;
        else
        {
            return filteredEditorialGroup.get(0);
        }
    }

    public static Author filterAuthorsByID(List<Author> authors, int ID)
    {
        List<Author> filteredAuthor = authors.stream().filter(p->p.getID() == ID).collect(Collectors.toList());
        if(filteredAuthor.isEmpty())
            return null;
        else
        {
            return filteredAuthor.get(0);
        }
    }

    public static Book filterBooksByID(List<Book> books, int ID)
    {
        List<Book> filteredBook = books.stream().filter(p->p.getID() == ID).collect(Collectors.toList());
        if(filteredBook.isEmpty())
            return null;
        else
        {
            return filteredBook.get(0);
        }
    }

    public static Countries filterCountriesByID(List<Countries> countries, int ID)
    {
        List<Countries> filteredCountry = countries.stream().filter(p->p.getID() == ID).collect(Collectors.toList());
        if(filteredCountry.isEmpty())
            return null;
        else
        {
            return filteredCountry.get(0);
        }
    }

    public static Language filterLanguagesByID(List<Language> languages, int ID)
    {
        List<Language> filteredLanguage = languages.stream().filter(p->p.getID() == ID).collect(Collectors.toList());
        if(filteredLanguage.isEmpty())
            return null;
        else
        {
            return filteredLanguage.get(0);
        }
    }

    public static PublishingBrand filterPublishingBrandsByID(List<PublishingBrand> publishingBrands, int ID)
    {
        List<PublishingBrand> filteredPublishingBrand = publishingBrands.stream().filter(p->p.getID() == ID).collect(Collectors.toList());
        if(filteredPublishingBrand.isEmpty())
            return null;
        else
        {
            return filteredPublishingBrand.get(0);
        }
    }

    public static PublishingRetailer filterPublishingRetailersByID(List<PublishingRetailer> publishingRetailers, int ID)
    {
        List<PublishingRetailer> filteredPublishingRetailer = publishingRetailers.stream().filter(p->p.getID() == ID).collect(Collectors.toList());
        if(filteredPublishingRetailer.isEmpty())
            return null;
        else
        {
            return filteredPublishingRetailer.get(0);
        }
    }


}
