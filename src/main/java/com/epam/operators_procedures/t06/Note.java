package com.epam.operators_procedures.t06;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * In order to solve the problem of boiler-plate code this class uses Project Lombok annotation processor.
 * For more details about this tool please refer to project Lombok
 * <a href='https://projectlombok.org/features/all">feature page</a>.
 *
 * */
@Setter
@Getter
@AllArgsConstructor
@ToString
public class Note {
    private String noteText;
}
