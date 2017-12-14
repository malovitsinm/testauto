package com.epam.oop.t02_t03_t04.impl;

import com.epam.oop.t02_t03_t04.SupplyBehavior;
import lombok.AllArgsConstructor;

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
