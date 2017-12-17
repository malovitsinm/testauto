package com.epam.oop.t02_t03_t04;

import com.epam.oop.t02_t03_t04.impl.UseNotebook;
import lombok.Builder;

import java.time.LocalDate;
/**
 * In order to solve the problem of boiler-plate code this class uses Project Lombok annotation processor.
 * For more details about this tool please refer to project Lombok
 * <a href='https://projectlombok.org/features/all">feature page</a>.
 *
 * */
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
