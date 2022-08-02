package com.crud.library.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookDto {
    private Long bookId;
    private String title;
    private String author;
    private Short year;
}
