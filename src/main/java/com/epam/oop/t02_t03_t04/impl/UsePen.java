package com.epam.oop.t02_t03_t04.impl;

import com.epam.oop.t02_t03_t04.SupplyBehavior;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UsePen  implements SupplyBehavior{
    private String color;
    private String type;

    @Override
    public String useTool(String parameter) {
        return "The message written with " +
                color +
                " " +
                type +
                " pen reads: " +
                parameter;
    }
}
