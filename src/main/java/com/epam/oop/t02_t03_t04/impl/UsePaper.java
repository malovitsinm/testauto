package com.epam.oop.t02_t03_t04.impl;

import com.epam.oop.t02_t03_t04.SupplyBehavior;

import java.util.ArrayList;
import java.util.List;


public class UsePaper implements SupplyBehavior {
    private String content;
    private String copyMsg = "This papaper is";

    public UsePaper(String content, boolean isCopy){
        this.content = content;
        copyMsg += isCopy ? " a copy." : " not a copy";
    }

    @Override
    public String useTool(String parameter) {
        return "The paper reads: "
                + content + " "
                + copyMsg;
    }
}
