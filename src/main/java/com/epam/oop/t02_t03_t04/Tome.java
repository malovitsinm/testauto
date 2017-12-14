package com.epam.oop.t02_t03_t04;

import lombok.Getter;

import java.time.LocalDate;

public abstract class Tome extends OfficeSupply {
    @Getter
    protected String content;

    protected Tome(int cost, String name, LocalDate expirationDate, String content){
        super(cost, name, expirationDate);
        this.content = content;
    }

}
