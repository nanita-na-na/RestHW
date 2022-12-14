package com.cursor.cursorRestHW.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    Long id;
    String name;
    String city;
    String street;
    int countOfEmployees;
    boolean haveSite;

    public Shop() {
    }

    public Shop(String name, String city, String street, int countOfEmployees, boolean haveSite) {
        this.name = name;
        this.city = city;
        this.street = street;
        this.countOfEmployees = countOfEmployees;
        this.haveSite = haveSite;
    }

    public Shop(Long id, String name, String city, String street, int countOfEmployees, boolean haveSite) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.street = street;
        this.countOfEmployees = countOfEmployees;
        this.haveSite = haveSite;
    }
}
