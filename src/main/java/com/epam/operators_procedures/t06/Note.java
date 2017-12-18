package com.epam.operators_procedures.t06;

import lombok.*;

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
@EqualsAndHashCode
public class Note {
    private String noteText;
}
