package com.epam.oop.t02_t03_t04.impl;

import com.epam.oop.t02_t03_t04.SupplyBehavior;
import lombok.AllArgsConstructor;
/**
 * In order to solve the problem of boiler-plate code this class uses Project Lombok annotation processor.
 * For more details about this tool please refer to project Lombok
 * <a href='https://projectlombok.org/features/all">feature page</a>.
 *
 * */
@AllArgsConstructor
public class UsePencil implements SupplyBehavior{
    private String color;
    private String thickness;

    @Override
    public String useTool(String parameter) {
        return "The message written with " +
                color +
                " " +
                thickness +
                " pencil reads: " +
                parameter;
    }
}
