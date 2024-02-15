package com.example.proforientaca.models;

public class Specialization {

    private String id;
    private String name;
    private String description;
    private String time;

    public Specialization(String id, String name, String description, String time) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getTime() {
        return time;
    }
}
