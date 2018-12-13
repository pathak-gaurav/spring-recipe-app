package com.gauravpathak.springrecipeapp.model;

import javax.persistence.*;

@Entity
public class UnitOfMeasure {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "uom_id_generator")
    @SequenceGenerator(name = "uom_id_generator", initialValue = 41001, allocationSize = 1, schema = "uom_id_sequence")
    @Column(name = "UOM_ID")
    private Long uomId;

    @Column(name = "uom")
    private String uom;

    public Long getUomId() {
        return uomId;
    }

    public void setUomId(Long uomId) {
        this.uomId = uomId;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

}
