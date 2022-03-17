package Entities;

import Entities.Book;
import Entities.IPublishingArtifact;

import java.util.ArrayList;
import java.util.List;

public class PublishingBrand implements IPublishingArtifact {
    int ID;
    String name;
    List<Book> books;


    public PublishingBrand(int ID, String name, List<Book> books) {
        this.ID = ID;
        this.name = name;
        this.books = books;
    }
    public PublishingBrand(int ID, String name) {
        this.ID = ID;
        this.name = name;
        this.books = new ArrayList<>();
    }

    @Override
    public  String Publish()
    {
        StringBuilder x = new StringBuilder();
        if (books != null)
        {
            for( Book elem : books)
            {
                x.append("\n    <book>");
                x.append(elem.Publish());
                x.append("\n    </book>");
            }
        }

        return "<xml>\n  "+"<publishingBrand>\n   "+"<ID>"+ID+"</ID>"
                +"\n   "+"<Name>"+name+"</Name>"
                +"\n  "+"</publishingBrand>"
                +"\n  "+"<books>" + x +"\n   </books>" + "\n</xml>";
    }

    @Override
    public String toString() {
        return "Entities.PublishingBrand{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", books=" + books +
                '}';
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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
