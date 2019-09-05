package com.aplaygroundreviewer.dto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Equipment {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private boolean ladders;

    @NotNull
    private boolean swings;

    @NotNull
    private boolean climbingWalls;

    @NotNull
    private boolean slides;

    @NotNull
    private boolean seesaw;

    @NotNull
    private boolean structures;

    public Equipment() {
    }

    public Equipment(boolean ladders, boolean swings, boolean climbingWalls, boolean slides, boolean seesaw, boolean structures) {
        this.ladders = ladders;
        this.swings = swings;
        this.climbingWalls = climbingWalls;
        this.slides = slides;
        this.seesaw = seesaw;
        this.structures = structures;
    }

    @OneToOne(mappedBy = "equipment")
    private Playground playground;


    public Playground getPlayground() {
        return playground;
    }

    public void setPlayground(Playground playground) {
        this.playground = playground;
    }

    public int getId() {
        return id;
    }

    public boolean isLadders() {
        return ladders;
    }

    public void setLadders(boolean ladders) {
        this.ladders = ladders;
    }

    public boolean isSwings() {
        return swings;
    }

    public void setSwings(boolean swings) {
        this.swings = swings;
    }

    public boolean isClimbingWalls() {
        return climbingWalls;
    }

    public void setClimbingWalls(boolean climbingWalls) {
        this.climbingWalls = climbingWalls;
    }

    public boolean isSlides() {
        return slides;
    }

    public void setSlides(boolean slides) {
        this.slides = slides;
    }

    public boolean isSeesaw() {
        return seesaw;
    }

    public void setSeesaw(boolean seesaw) {
        this.seesaw = seesaw;
    }

    public boolean isStructures() {
        return structures;
    }

    public void setStructures(boolean structures) {
        this.structures = structures;
    }
}

