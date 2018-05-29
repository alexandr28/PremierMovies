package com.acampdev.borisalexandrcamposrios.premiermovies.POJOS;

public class Movie {

    private String name ;
    private String description;
    private String rating ;
    private String image_url;
    private String categorie;
    private String studio;

    public Movie(){}

    public Movie(String name, String description, String rating, String image_url, String categorie, String studio) {
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.image_url = image_url;
        this.categorie = categorie;
        this.studio = studio;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

}
