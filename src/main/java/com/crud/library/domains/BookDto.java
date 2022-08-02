package com.crud.library.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class BookDto {
    private Long bookId;
    private String title;
    private String author;
    private List<BookCopies> bookCopies = new ArrayList<>(); //TODO Maybe it is to delete
}
