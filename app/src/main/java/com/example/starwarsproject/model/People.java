package com.example.starwarsproject.model;

public class People {
    String name;
    String height;
    String mass;
    String gender;
    String image;
    String species;
    String dateNaissance;
    String apparitions;
    String wikiLien;

    public People(String name, String height, String mass, String gender, String image, String species) {
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.gender = gender;
        this.image = image;
        this.species = species;
    }

    public People() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getApparitions() {
        return apparitions;
    }

    public void setApparitions(String apparitions) {
        this.apparitions = apparitions;
    }

    public String getWikiLien() {
        return wikiLien;
    }

    public void setWikiLien(String wikiLien) {
        this.wikiLien = wikiLien;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", mass=" + mass +
                ", gender='" + gender + '\'' +
                ", image='" + image + '\'' +
                ", species='" + species + '\'' +
                ", date de naissance='" + dateNaissance + '\'' +
                ", Apparitions='" + apparitions + '\'' +
                ", lien vers le Wiki='" + wikiLien + '\'' +
                '}';
    }
}