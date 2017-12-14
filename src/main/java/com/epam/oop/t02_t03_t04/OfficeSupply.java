package com.epam.oop.t02_t03_t04;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.Period;
@ToString
public abstract class OfficeSupply {
    @Getter
    protected Integer cost;
    @Getter
    protected String name;
    protected LocalDate expirationDate;
    protected SupplyBehavior supplyBehavior;


    protected OfficeSupply(Integer cost, String name, LocalDate expirationDate) {
        this.cost = cost;
        this.expirationDate = expirationDate;
        this.name = name;
    }


    public Period getEperationPeriod() {
        return Period.between(LocalDate.now(), expirationDate);
    }

    public String useSupply(String parameter){
        return supplyBehavior.useTool(parameter);
    }
}
