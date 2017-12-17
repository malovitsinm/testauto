package com.epam.oop.t02_t03_t04;

import com.epam.oop.t02_t03_t04.impl.UsePen;
import lombok.Builder;

import java.time.LocalDate;
/**
 * In order to solve the problem of boiler-plate code this class uses Project Lombok annotation processor.
 * For more details about this tool please refer to project Lombok
 * <a href='https://projectlombok.org/features/all">feature page</a>.
 *
 * */
public class Pen extends Feather {
    String type;

    @Builder
    Pen(Integer cost, String name, LocalDate expirationDate,  String color, String type) {
        super(cost, name, expirationDate, color);
        this.supplyBehavior = new UsePen(color, type);
        this.type = type;
    }

    @Override
    public String toString() {
        return "Pen{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", expirationDate=" + expirationDate +
                ", color='" + color + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
