package com.epam.oop.t02_t03_t04;

import lombok.Getter;

import java.time.LocalDate;

public abstract class Feather extends OfficeSupply{
    @Getter
    protected String color;

    protected Feather(int cost, String name, LocalDate expirationDate, String color){
        super(cost, name, expirationDate);
        this.color = color;
    }


}
