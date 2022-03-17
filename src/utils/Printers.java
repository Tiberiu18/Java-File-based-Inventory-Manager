package utils;

import Entities.*;

import java.util.List;

public class Printers {
    public static void printBooks(PublishingRetailer pb)
    {
        int cnt = 0;
        for(IPublishingArtifact i : pb.getPublishingArtifacts())
        {
            if(i instanceof Book)
            {
                Book b = (Book)i;
                System.out.println(b);
                cnt += 1;
            }
            else if(i instanceof EditorialGroup)
            {
                EditorialGroup e = (EditorialGroup)i;
                for(Book b: e.getBooks())
                {
                    System.out.println(b);
                    cnt += 1;
                }

            }
            else if(i instanceof PublishingBrand)
            {
                PublishingBrand pBB = (PublishingBrand)i;
                for(Book b: pBB.getBooks())
                {
                    System.out.println(b);
                    cnt += 1;
                }
            }
            else
                break;
            System.out.println(cnt);
        }
    }
    public static void printBooks(List<Book> list)
    {
        for(Book b: list)
            System.out.print(b + " ");
        System.out.println();
    }
}
