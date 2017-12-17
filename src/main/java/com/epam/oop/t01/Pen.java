package com.epam.oop.t01;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
/**
 * In order to solve the problem of boiler-plate code this class uses Project Lombok annotation processor.
 * For more details about this tool please refer to project Lombok
 * <a href='https://projectlombok.org/features/all">feature page</a>.
 *
* */
@AllArgsConstructor
@Setter
@Getter
public class Pen {
    private String inkColor;
    private String inkType;

    @Override
    public String toString() {
        return "Pen{" +
                "inkColor='" + inkColor + '\'' +
                ", inkType='" + inkType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pen pen = (Pen) o;

        if (inkColor != null ? !inkColor.equals(pen.inkColor) : pen.inkColor != null) return false;
        return inkType != null ? inkType.equals(pen.inkType) : pen.inkType == null;
    }

    @Override
    public int hashCode() {
        int result = inkColor != null ? inkColor.hashCode() : 0;
        result = 31 * result + (inkType != null ? inkType.hashCode() : 0);
        return result;
    }

    public String writeSomething(String text){
        return text + " This text is written in " + inkColor + " color.";
    }
}
