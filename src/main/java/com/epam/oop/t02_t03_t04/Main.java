package com.epam.oop.t02_t03_t04;

import com.epam.oop.t02_t03_t04.comparators.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(getBeginnerKit().toString());
        Employee manager = new Employee("Ivan Ivanov");
        List<OfficeSupply> starterKit = getBeginnerKit();
        manager.setPersonalBelongings(getBeginnerKit());
        Collections.sort(starterKit, new SupplyCostComparator());
        System.out.println(starterKit);
        Collections.sort(starterKit, new SupplyNameComparator());
        System.out.println(starterKit);
        Collections.sort(starterKit, new SupplyFullComparator());
        System.out.println(starterKit);
    }

    public static List<OfficeSupply> getBeginnerKit(){
        List<OfficeSupply> kit = new ArrayList<>();
        LocalDate today = LocalDate.now();
        kit.add(new Pen.PenBuilder()
                .name("Bic")
                .color("Blue")
                .cost(20)
                .expirationDate(today.plusMonths(12))
                .type("Ball")
                .build());
        kit.add(new Pen.PenBuilder()
                .name("Bic")
                .color("Red")
                .cost(40)
                .expirationDate(today.plusMonths(6))
                .type("Gel")
                .build());
        kit.add(new Pencil.PencilBuilder()
                .name("Erich Krause")
                .color("grey")
                .cost(10)
                .expirationDate(today.plusMonths(18))
                .thickness("HB")
                .build());
        kit.add(new Paper.PaperBuilder()
                .name("Paper badge")
                .cost(20)
                .expirationDate(today.plusMonths(24))
                .content("This employ is authorized!")
                .isCopy(true)
                .build());
        kit.add(new Paper.PaperBuilder()
                .name("SvetoCopy")
                .cost(5)
                .expirationDate(today.plusMonths(3))
                .content("Notes will follow here")
                .isCopy(false)
                .build());
        kit.add(new Notebook.NotebookBuilder()
                .name("Erich Krause")
                .cost(150)
                .expirationDate(today.plusMonths(36))
                .content("Valuable marketing notes.")
                .department("Marketing")
                .build());
        return kit;
    }
}
