package com.aplaygroundreviewer.aplaygroundreviewer.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Equipment {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private boolean ladder;

    @NotNull
    private boolean swing;

    public Equipment() {
    }

    public Equipment(boolean ladder, boolean swing) {
        this.ladder = ladder;
        this.swing = swing;
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

    public boolean isSwing() {
        return swing;
    }

    public void setSwing(boolean swing) {
        this.swing = swing;
    }
}

