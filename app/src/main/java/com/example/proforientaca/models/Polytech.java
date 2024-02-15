package com.example.proforientaca.models;

public class Polytech {

    private Class activity;
    private String name;
    private String description;
    private int img;
    private int logo;
    private String location;
    private String url;
    private Specialization[] specializations;
    private String telephone;

    public Polytech(Class activity, String name, String description, int logo, String location, String url, String telephone) {
        this.activity = activity;
        this.name = name;
        this.description = description;
        this.logo = logo;
        this.location = location;
        this.url = url;
        this.telephone = telephone;
    }

    public Class getActivity() {
        return activity;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImg() {
        return img;
    }

    public int getLogo() {
        return logo;
    }

    public String getLocation() {
        return location;
    }

    public String getUrl() {
        return url;
    }

    public Specialization[] getSpecializations() {
        return specializations;
    }

    public String getTelephone() {
        return telephone;
    }
}
