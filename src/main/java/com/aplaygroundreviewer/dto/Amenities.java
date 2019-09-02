package com.aplaygroundreviewer.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Amenities {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private boolean waterFountain;

    @NotNull
    private boolean restroomChangingStation;

    @OneToOne (mappedBy = "amenities")
    private Playground playground;

    public Amenities() {
    }

    public Amenities(boolean waterFountain, boolean restroomChangingStation) {
        this.waterFountain = waterFountain;
        this.restroomChangingStation = restroomChangingStation;
    }

    public int getId() {
        return id;
    }

    public boolean isWaterFountain() {
        return waterFountain;
    }

    public void setWaterFountain(boolean waterFountain) {
        this.waterFountain = waterFountain;
    }

    public boolean isRestroomChangingStation() {
        return restroomChangingStation;
    }

    public void setRestroomChangingStation(boolean restroomChangingStation) {
        this.restroomChangingStation = restroomChangingStation;
    }

    public Playground getPlayground() {
        return playground;
    }

    public void setPlayground(Playground playground) {
        this.playground = playground;
    }
}
