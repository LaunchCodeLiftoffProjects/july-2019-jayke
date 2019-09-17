package com.aplaygroundreviewer.dto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Playground {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
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

    private boolean waterFeature;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "equipment_id", unique = true)
    private Equipment equipment;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "amenities_id", unique = true)
    private Amenities amenities;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "accessibility_id")
    private Accessibility accessibility;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "shelters_id")
    private Shelters shelters;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "specialNeeds_id")
    private SpecialNeeds specialNeeds;

    public Playground () {
        this.equipment = new Equipment(false, false, false, false, false, false);
        //add amenities fields
        this.amenities = new Amenities(false, false);
        //add accessibility fields
        this.accessibility = new Accessibility(false, false);
        //add shelters fields
        this.shelters = new Shelters(false, false);
        //add special needs fields
        this.specialNeeds = new SpecialNeeds(false, false);
    }

    public Playground(String name, String description, String address, boolean waterFeature, boolean ladders, boolean swings, boolean climbingWalls, boolean slides, boolean seesaw, boolean structures, boolean waterFountain, boolean restroomChangingStation, boolean parkingLot, boolean trail, boolean pavillion, boolean benches, boolean sensory, boolean wheelchairAccessible) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.waterFeature = waterFeature;
        this.equipment = new Equipment(ladders, swings, climbingWalls, slides, seesaw, structures);
        //add amenities fields
        this.amenities = new Amenities(waterFountain, restroomChangingStation);
        //add accessibility fields
        this.accessibility = new Accessibility(parkingLot, trail);
        //add shelters fields
        this.shelters = new Shelters(pavillion, benches);
        //add special needs fields
        this.specialNeeds = new SpecialNeeds(sensory,wheelchairAccessible);
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

    public Amenities getAmenities() {
        return amenities;
    }

    public void setAmenities(Amenities amenities) {
        this.amenities = amenities;
    }

    public Accessibility getAccessibility() {
        return accessibility;
    }

    public void setAccessibility(Accessibility accessibility) {
        this.accessibility = accessibility;
    }

    public boolean getWaterFeature() {
        return waterFeature;
    }

    public void setWaterFeature(boolean waterFeature) {
        this.waterFeature = waterFeature;
    }

    public Shelters getShelters() {
        return shelters;
    }

    public void setShelters(Shelters shelters) {
        this.shelters = shelters;
    }

    public SpecialNeeds getSpecialNeeds() {
        return specialNeeds;
    }

    public void setSpecialNeeds(SpecialNeeds specialNeeds) {
        this.specialNeeds = specialNeeds;
    }
}