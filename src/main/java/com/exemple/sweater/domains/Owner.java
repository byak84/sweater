package com.exemple.sweater.domains;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer owner_id;


    @JsonIgnoreProperties(value = "owner", allowSetters = true)
    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
    private List<Land> lands;

    private String firstname;          // Имя
    private String lastname;           // фамилия
    private String patronymic;         // Отчество
    private String phone;
    private String comment;

    public Owner() {
    }

    public Owner(String firstname, String lastname, String patronymic, String phone, String comment) {

        this.firstname = firstname;
        this.lastname = lastname;
        this.patronymic = patronymic;
        this.phone = phone;
        this.comment = comment;
    }

    public Integer getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Integer owner_id) {
        this.owner_id = owner_id;
    }

    public List<Land> getLands() {
        return lands;
    }

    public void setLands(List<Land> lands) {
        this.lands = lands;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPhone() { return phone; }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

//    public String getFullName() {
//        return lastname + " " + firstname + " " + patronymic;
//    }
}
