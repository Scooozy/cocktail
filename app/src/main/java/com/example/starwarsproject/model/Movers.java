package com.example.starwarsproject.model;

public class Movers {
    String title;
    int year;
    String genre;
    String plot;
    String actors;
    String poster;
    Double imdbRating;
    int totalSeasons;
    int runtime;

    public Movers(String title, int year, String genre, String plot, String actors, String poster, Double imdbRating, int totalSeasons, int runtime) {
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.plot = plot;
        this.actors = actors;
        this.poster = poster;
        this.imdbRating = imdbRating;
        this.totalSeasons = totalSeasons;
        this.runtime = runtime;
    }

    public Movers() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(Double imdbRating) {
        this.imdbRating = imdbRating;
    }

    public int getTotalSeasons() {
        return totalSeasons;
    }

    public void setTotalSeasons(int totalSeasons) {
        this.totalSeasons = totalSeasons;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    @Override
    public String toString() {
        return "Movers{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", Genre='" + Genre + '\'' +
                ", plot='" + plot + '\'' +
                ", actors='" + actors + '\'' +
                ", poster='" + poster + '\'' +
                ", imdbRating=" + imdbRating +
                ", totalSeasons=" + totalSeasons +
                ", runtime=" + runtime +
                '}';
    }
}
