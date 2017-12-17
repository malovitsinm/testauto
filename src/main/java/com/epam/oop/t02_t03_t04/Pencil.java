package com.epam.oop.t02_t03_t04;

import com.epam.oop.t02_t03_t04.impl.UsePencil;
import lombok.Builder;

import java.time.LocalDate;
/**
 * In order to solve the problem of boiler-plate code this class uses Project Lombok annotation processor.
 * For more details about this tool please refer to project Lombok
 * <a href='https://projectlombok.org/features/all">feature page</a>.
 *
 * */
public class Pencil extends Feather{
    String thickness;

    @Builder
    Pencil(Integer cost, String name, LocalDate expirationDate, String color, String thickness){
        super(cost, name, expirationDate, color);
        this.supplyBehavior = new UsePencil(color, thickness);
        this.thickness = thickness;
    }

    @Override
    public String toString() {
        return "Pencil{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", expirationDate=" + expirationDate +
                ", color='" + color + '\'' +
                ", thickness='" + thickness + '\'' +
                '}';
    }
}
