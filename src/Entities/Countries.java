package Entities;

public class Countries {
    int ID;
    String countryCode;

    public Countries(int ID, String countryCode) {
        this.ID = ID;
        this.countryCode = countryCode;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public String toString() {
        return "Entities.Countries{" +
                "ID=" + ID +
                ", countryCode='" + countryCode + '\'' +
                '}';
    }
}
