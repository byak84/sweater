package com.exemple.sweater.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//enum Type {PERIODIC, TARGET};

@Entity
public class PaymentType {
    enum Type {PERIODIC, TARGET};
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer payment_type_id;

    private String naming;
    private Type type;

    public PaymentType() {
    }

    public PaymentType(String naming, Type type) {
        this.naming = naming;
        this.type = type;
    }

    public Integer getPayment_type_id() {
        return payment_type_id;
    }

    public void setPayment_type_id(Integer payment_type_id) {
        this.payment_type_id = payment_type_id;
    }

    public String getNaming() {
        return naming;
    }

    public void setNaming(String naming) {
        this.naming = naming;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
