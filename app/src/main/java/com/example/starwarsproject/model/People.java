package com.example.starwarsproject.model;

public class People {
    String name;
    int height;
    int mass;
    String gender;
    String homeworld;
    String image;
    String species;
    String[] affiliation;
    String[] masters;
    String[] apprentices;

    public People(String name, int height, int mass, String gender, String homeworld, String image, String species, String[] affiliation, String[] masters, String[] apprentices) {
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.gender = gender;
        this.homeworld = homeworld;
        this.image = image;
        this.species = species;
        this.affiliation = affiliation;
        this.masters = masters;
        this.apprentices = apprentices;
    }

    public People() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String[] getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String[] affiliation) {
        this.affiliation = affiliation;
    }

    public String[] getMasters() {
        return masters;
    }

    public void setMasters(String[] masters) {
        this.masters = masters;
    }

    public String[] getApprentices() {
        return apprentices;
    }

    public void setApprentices(String[] apprentices) {
        this.apprentices = apprentices;
    }
}
