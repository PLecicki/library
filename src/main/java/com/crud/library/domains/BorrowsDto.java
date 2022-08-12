package com.crud.library.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class BorrowsDto {
    private BookCopies bookCopies;
    private Reader reader;
    private LocalDate borrowing;
    private LocalDate returning;
}
