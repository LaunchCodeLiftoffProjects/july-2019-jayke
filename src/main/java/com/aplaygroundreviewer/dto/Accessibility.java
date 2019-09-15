package com.aplaygroundreviewer.dto;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Accessibility {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private boolean parkingLot;

    @NotNull
    private boolean trail;

    @OneToOne(mappedBy = "accessibility")
    private Playground playground;

    public Accessibility() {
    }

    public Accessibility(boolean parkingLot, boolean trail) {
        this.parkingLot = parkingLot;
        this.trail = trail;
    }

    public int getId() {
        return id;
    }

    public boolean isParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(boolean parkingLot) {
        this.parkingLot = parkingLot;
    }

    public boolean isTrail() {
        return trail;
    }

    public void setTrail(boolean trail) {
        this.trail = trail;
    }

    public Playground getPlayground() {
        return playground;
    }

    public void setPlayground(Playground playground) {
        this.playground = playground;
    }
}
