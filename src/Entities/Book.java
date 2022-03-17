package Entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Book implements IPublishingArtifact, Comparable<Book> {
    public int ID;
    public String name;
    public String subtitle;
    public String ISBN;
    public int pageCount;
    public String keywords;
    public int languageID;
    Date createdOn;
    List<Author> authors;

    @Override
    public String toString() {
        return "Book{" +
                "ID=" + ID +
                '}';
    }

    public Book(int ID, String name, String subtitle, String ISBN, int pageCount, String keywords, int languageID, Date createdOn, List<Author> authors) {
        this.ID = ID;
        this.name = name;
        this.subtitle = subtitle;
        this.ISBN = ISBN;
        this.pageCount = pageCount;
        this.keywords = keywords;
        this.languageID = languageID;
        this.createdOn = createdOn;
        this.authors = authors;
    }
    public Book(int ID, String name, String subtitle, String ISBN, int pageCount, String keywords, int languageID, Date createdOn) {
        this.ID = ID;
        this.name = name;
        this.subtitle = subtitle;
        this.ISBN = ISBN;
        this.pageCount = pageCount;
        this.keywords = keywords;
        this.languageID = languageID;
        this.createdOn = createdOn;
        this.authors = new ArrayList<Author>();
    }

    @Override
    public String Publish() {
        return "<xml>\n " + "<title>"+name+"</title>"
                +"\n "+"<subtitle>"+subtitle+"</subtitle>"
                +"\n "+"<isbn>"+ISBN+"</isbn>"
                +"\n " +"<pageCount>"+pageCount+"</pageCount>"
                +"\n "+"<keywords>"+keywords+"</keywords>"
                +"\n "+"<languageID>"+languageID+"</languageID"
                +"\n "+"<createdOn>"+createdOn+"</createdOn>"
                +"\n "+"<authors>"+authors+"<authors>"
                +"\n</xml>";
    }

    @Override
    public boolean equals(Object o)
    {
        if ( o == this)
            return true;
        if( o == null)
            return false;
        if (!(o instanceof Book))
            return false;
        final Book b = (Book)o;
        return this.ID == b.ID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    @Override
    public int compareTo(Book b)
    {
        if(this.ID < b.ID)
            return -1;
        else if (this.ID == b.ID)
            return 0;
        else
            return 1;
    }

    public int getID() {
        return ID;
    }


    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public int getLanguageID() {
        return languageID;
    }

    public void setLanguageID(int languageID) {
        this.languageID = languageID;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }


}
