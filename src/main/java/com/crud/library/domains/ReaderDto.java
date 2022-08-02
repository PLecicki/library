package com.crud.library.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class ReaderDto {
    private Long readerId;
    private String name;
    private String surname;
    private LocalDate birth;
}
