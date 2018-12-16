package com.gauravpathak.springrecipeapp.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class UnitOfMeasure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UOM_ID")
    private Long uomId;

    @Column(name = "description")
    private String description;

    public UnitOfMeasure(String description) {
        this.description = description;
    }

    public UnitOfMeasure() {
    }

}
