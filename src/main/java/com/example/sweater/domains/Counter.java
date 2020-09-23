package com.example.sweater.domains;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Counter {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer counter_id;

    private String naming;
    private int value;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "land_id")
    @JsonIgnoreProperties("counters")
    private Land land;

    private boolean active;
    private Date activeDate;

    public Counter() {
        this.naming = null;
        this.value = 0;
        this.land = null;
        this.active = false;
        this.activeDate = null;
    }

    public Counter(int value) {
        this.naming = null;
        this.value = value;
        this.land = null;
        this.active = false;
        this.activeDate = null;
    }

    public Integer getCounter_id() {
        return counter_id;
    }

    public void setCounter_id(Integer counter_id) {
        this.counter_id = counter_id;
    }

    public String getNaming() {
        return naming;
    }

    public void setNaming(String naming) {
        this.naming = naming;
    }

    public int getValue() { return value; }

    public void setValue(int value) {
        this.value = value;
    }

    public Land getLand() {
        return land;
    }

    public void setLand(Land land) {
        this.land = land;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getActiveDate() {
        return activeDate;
    }

    public void setActiveDate(Date activeDate) {
        this.activeDate = activeDate;
    }
}
