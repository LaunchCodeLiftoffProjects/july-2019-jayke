package com.aplaygroundreviewer.aplaygroundreviewer.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Equipment {

    @Id
    @GeneratedValue
    private int id;

    private boolean ladder;

    public Equipment() {
      this.ladder = false;
    }


    public Equipment(boolean ladder) {
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


    public boolean isLadder() {
        return ladder;
    }

    public void setLadder(boolean ladder) {
        this.ladder = ladder;
    }
}

