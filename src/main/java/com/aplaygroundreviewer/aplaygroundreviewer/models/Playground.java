package com.aplaygroundreviewer.aplaygroundreviewer.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Playground {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=400)
    private String name;

    @NotNull
    @Size(min=3, max=400)
    private String description;

    public Playground(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Playground () { }

    public int getId() {
        return id;
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
}
