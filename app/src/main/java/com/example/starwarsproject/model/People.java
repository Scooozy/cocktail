package com.example.starwarsproject.model;

import java.util.Arrays;
import java.util.Objects;

public class People {
    String name;
    String height;
    String mass;
    String gender;
    String image;
    String species;

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



    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", mass=" + mass +
                ", gender='" + gender + '\'' +
                ", image='" + image + '\'' +
                ", species='" + species + '\'' +
                '}';
    }
}
