package Entities;

import Entities.Countries;
import Entities.IPublishingArtifact;

import java.util.ArrayList;
import java.util.List;

public class PublishingRetailer {
    int ID;
    String name;
    List<IPublishingArtifact> publishingArtifacts;
    List<Countries> countries;

    public List<Countries> getCountries() {
        return countries;
    }

    public void setCountries(List<Countries> countries) {
        this.countries = countries;
    }

    public PublishingRetailer(int ID, String name, List<IPublishingArtifact> publishingArtifacts) {
        this.ID = ID;
        this.name = name;
        this.publishingArtifacts = publishingArtifacts;
    }
    public PublishingRetailer(int ID, String name) {
        this.ID = ID;
        this.name = name;
        this.publishingArtifacts = new ArrayList<>();
        this.countries = new ArrayList<>();
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

    @Override
    public String toString() {
        return "Entities.PublishingRetailer{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", publishingArtifacts=" + publishingArtifacts +
                ", countries=" + countries +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<IPublishingArtifact> getPublishingArtifacts() {
        return publishingArtifacts;
    }

    public void setPublishingArtifacts(List<IPublishingArtifact> publishingArtifacts) {
        this.publishingArtifacts = publishingArtifacts;
    }
}
