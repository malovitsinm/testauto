package com.epam.oop.t02_t03_t04.impl;

import com.epam.oop.t02_t03_t04.SupplyBehavior;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UseNotebook implements SupplyBehavior {
    private String content;
    private String department;

    @Override
    public String useTool(String parameter) {
        return "The notebook from " +
                department
                + " department reads:"
                + content;
    }
}
