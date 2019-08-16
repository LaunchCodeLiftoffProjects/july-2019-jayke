package com.aplaygroundreviewer.aplaygroundreviewer.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Equipment {

    @Id
    @GeneratedValue
    private int id;

    private Boolean ladder = false;

    public Equipment() {
        this.ladder = false;
    }

    public Equipment(Boolean ladder) {
        this.ladder = ladder;
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

    public Boolean getLadder() {
        return ladder;
    }

    public void setLadder(Boolean ladder) {
        this.ladder = ladder;
    }
}

