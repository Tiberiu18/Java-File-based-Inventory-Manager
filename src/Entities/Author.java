package Entities;

public class Author implements Comparable<Author>{
    int ID;
    String firstName;
    String lastName;

    public Author(int ID, String firstName, String lastName) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Entities.Author{" +
                "ID=" + ID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (o == this)
            return true;
        if( !(o instanceof Author))
            return false;
        Author a = (Author)o;
        return this.ID == a.ID;
    }

    @Override
    public int compareTo(Author b)
    {
        if(this.ID < b.ID)
            return -1;
        else if (this.ID == b.ID)
            return 0;
        else
            return 1;
    }
}
