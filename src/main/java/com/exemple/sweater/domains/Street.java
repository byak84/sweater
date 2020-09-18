package com.exemple.sweater.domains;

import javax.persistence.*;
import java.util.List;

@Entity
public class Street {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer street_id;
    private String name;

    @OneToMany (mappedBy = "street")
    List<Land> lands;

    public Street() {}

    public Street(String name) {
        this.name = name;
    }

    public Integer getStreet_id() {
        return street_id;
    }

    public void setStreet_id(Integer street_id) {
        this.street_id = street_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Land> getLands() {
        return lands;
    }

    public void setLands(List<Land> lands) {
        this.lands = lands;
    }
}
