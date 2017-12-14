package com.epam.oop.t02_t03_t04;

import com.epam.oop.t02_t03_t04.impl.UsePaper;
import lombok.Builder;

import java.time.LocalDate;

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
