package com.aplaygroundreviewer.aplaygroundreviewer.models;

import javax.persistence.*;
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

    @NotNull
    @Size(min=3, max=1000)
    private String address;


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "equipment_id", unique = true)
    private Equipment equipment;

    public Playground () {
        this.equipment = new Equipment(false, false, false, false, false);
    }

    public Playground(String name, String description, String address) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.equipment = new Equipment(false, false, false, false, false);
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
