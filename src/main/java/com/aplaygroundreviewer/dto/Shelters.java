package com.aplaygroundreviewer.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Shelters {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private boolean pavillion;

    @NotNull
    private boolean benches;

    @OneToOne(mappedBy = "shelters")
    private Playground playground;

    public Shelters() {
    }

    public Shelters(boolean pavillion, boolean benches) {
        this.pavillion = pavillion;
        this.benches = benches;
    }

    public boolean isPavillion() {
        return pavillion;
    }

    public void setPavillion(boolean pavillion) {
        this.pavillion = pavillion;
    }

    public boolean isBenches() {
        return benches;
    }

    public void setBenches(boolean benches) {
        this.benches = benches;
    }

    public Playground getPlayground() {
        return playground;
    }

    public void setPlayground(Playground playground) {
        this.playground = playground;
    }
}
