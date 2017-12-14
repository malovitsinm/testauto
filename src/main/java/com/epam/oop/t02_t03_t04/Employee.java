package com.epam.oop.t02_t03_t04;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Employee {
    String name;
    @Setter
    @Getter
    List<OfficeSupply> personalBelongings;

    public Employee(String name) {
        this.name = name;
    }
}
