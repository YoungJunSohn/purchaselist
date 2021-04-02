package com.james.purchaselist.domain.category;

import com.james.purchaselist.domain.BaseLogEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Categories extends BaseLogEntity<Categories> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String type;

    private String title;

}
