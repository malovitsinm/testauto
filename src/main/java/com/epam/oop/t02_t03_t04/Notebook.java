package com.epam.oop.t02_t03_t04;

import com.epam.oop.t02_t03_t04.impl.UseNotebook;
import lombok.Builder;

import java.time.LocalDate;

public class Notebook extends Tome {
    String department;

    @Builder
    public Notebook(int cost, String name, LocalDate expirationDate, String content, String department) {
        super(cost, name, expirationDate, content);
        this.supplyBehavior = new UseNotebook(content, department);
        this.department  = department;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", expirationDate=" + expirationDate +
                ", content='" + content + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
