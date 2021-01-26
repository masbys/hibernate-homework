package ru.hh.school.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

//TODO: оформите entity
@Entity
@Table(name = "area")
public class Area {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "area_id")
    private Integer id;

    @Column(name = "name")
    private String name;

    public Area() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
