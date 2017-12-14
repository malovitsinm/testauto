package com.epam.oop.t02_t03_t04.comparators;

import com.epam.oop.t02_t03_t04.OfficeSupply;

import java.util.Comparator;

public class SupplyCostComparator implements Comparator<OfficeSupply> {
    @Override
    public int compare(OfficeSupply o1, OfficeSupply o2) {
        return o1.getCost().compareTo(o2.getCost());
    }
}
