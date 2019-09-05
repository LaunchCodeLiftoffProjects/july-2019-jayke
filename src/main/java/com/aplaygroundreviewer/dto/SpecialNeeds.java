package com.aplaygroundreviewer.dto;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class SpecialNeeds {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private boolean sensory;

    @NotNull
    private boolean wheelchairAccessible;


    @OneToOne(mappedBy = "specialNeeds")
    private Playground playground;

    public SpecialNeeds() {
    }

    public SpecialNeeds(boolean sensory, boolean wheelchairAccessible) {
        this.sensory = sensory;
        this.wheelchairAccessible = wheelchairAccessible;
    }

    public boolean isSensory() {
        return sensory;
    }

    public void setSensory(boolean sensory) {
        this.sensory = sensory;
    }

    public boolean isWheelchairAccessible() {
        return wheelchairAccessible;
    }

    public void setWheelchairAccessible(boolean wheelchairAccessible) {
        this.wheelchairAccessible = wheelchairAccessible;
    }
}
