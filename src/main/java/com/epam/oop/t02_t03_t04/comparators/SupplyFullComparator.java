package com.epam.oop.t02_t03_t04.comparators;

import com.epam.oop.t02_t03_t04.OfficeSupply;

import java.util.Comparator;

public class SupplyFullComparator implements Comparator<OfficeSupply> {
    @Override
    public int compare(OfficeSupply o1, OfficeSupply o2) {
        int comparedCost = o1.getCost().compareTo(o2.getCost());
        return comparedCost != 0 ? comparedCost : o1.getName().compareTo(o2.getName());
    }
}
