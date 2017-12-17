package com.epam.oop.t02_t03_t04;

import com.epam.oop.t02_t03_t04.impl.UsePaper;
import lombok.Builder;

import java.time.LocalDate;
/**
 * In order to solve the problem of boiler-plate code this class uses Project Lombok annotation processor.
 * For more details about this tool please refer to project Lombok
 * <a href='https://projectlombok.org/features/all">feature page</a>.
 *
 * */
public class Paper extends Tome {
    boolean isCopy;

    @Builder
    public Paper(Integer cost, String name, LocalDate expirationDate, String content, boolean isCopy){
        super(cost, name, expirationDate, content);
        this.supplyBehavior = new UsePaper(content, isCopy);
        this.isCopy = isCopy;
    }

    @Override
    public String toString() {
        return "Paper{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", expirationDate=" + expirationDate +
                ", content='" + content + '\'' +
                ", isCopy=" + isCopy +
                '}';
    }
}
