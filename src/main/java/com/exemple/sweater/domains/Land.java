package com.exemple.sweater.domains;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Land {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer land_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id")
    @JsonIgnoreProperties("lands")
    private Owner owner;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "street_id")
//    private Street street;

    private String number;

    private String cadastr;

    private int people_count;

    @JsonIgnoreProperties(value = "land", allowSetters = true)
    @OneToMany(mappedBy = "land", fetch = FetchType.EAGER)
    private List<Counter> counters;

//    public String GetFullAddress() {
//        return this.street.getName()+", "+this.number;
//    }

    public Land() {
        this.people_count = 1;
    }

    public Land(Street street, String number, String cadastr) {
//        this.street=street;
        this.number = number;
        this.cadastr = cadastr;
        this.people_count = 1;
    }

    public Integer getLand_id() {
        return land_id;
    }

    public void setLand_id(Integer land_id) {
        this.land_id = land_id;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

//    public Street getStreet() {
//        return street;
//    }
//
//    public void setStreet(Street street) {
//        this.street = street;
//    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCadastr() {
        return cadastr;
    }

    public void setCadastr(String cadastr) {
        this.cadastr = cadastr;
    }

    public int getPeople_count() {
        return people_count;
    }

    public void setPeople_count(int people_count) {
        this.people_count = people_count;
    }

    public List<Counter> getCounters() {
        return counters;
    }

    public void setCounters(List<Counter> counters) {
        this.counters = counters;
    }
}
