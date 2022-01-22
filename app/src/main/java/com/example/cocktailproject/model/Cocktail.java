package com.example.cocktailproject.model;

public class Cocktail {

    private String name;
    private int id;
    private String instructions;
    private String imgURL;

    public Cocktail(String name, int id, String instructions, String imgURL) {
        this.name = name;
        this.id = id;
        this.instructions = instructions;
        this.imgURL = imgURL;
    }

    public Cocktail() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getimgURL() {
        return imgURL;
    }

    public void setimgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    @Override
    public String toString() {
        return "Cocktail{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", instructions='" + instructions + '\'' +
                ", imgURL='" + imgURL + '\'' +
                '}';
    }
}
