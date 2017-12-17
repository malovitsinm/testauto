package com.epam.oop.t02_t03_t04;

import lombok.Getter;

import java.time.LocalDate;
/**
 * In order to solve the problem of boiler-plate code this class uses Project Lombok annotation processor.
 * For more details about this tool please refer to project Lombok
 * <a href='https://projectlombok.org/features/all">feature page</a>.
 *
 * */
public abstract class Tome extends OfficeSupply {
    @Getter
    protected String content;

    protected Tome(int cost, String name, LocalDate expirationDate, String content){
        super(cost, name, expirationDate);
        this.content = content;
    }

}
