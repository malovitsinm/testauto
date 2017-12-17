package com.epam.oop.t02_t03_t04;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
/**
 * In order to solve the problem of boiler-plate code this class uses Project Lombok annotation processor.
 * For more details about this tool please refer to project Lombok
 * <a href='https://projectlombok.org/features/all">feature page</a>.
 *
 * */
public class Employee {
    String name;
    @Setter
    @Getter
    List<OfficeSupply> personalBelongings;

    public Employee(String name) {
        this.name = name;
    }
}
