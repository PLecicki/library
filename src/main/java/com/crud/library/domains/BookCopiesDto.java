package com.crud.library.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookCopiesDto {
    private Long bookCopyId;
    private Book book;
    private String status;
}
