package com.crud.library.controller;

import com.crud.library.domains.Book;
import com.crud.library.domains.BookDto;
import com.crud.library.mapper.BookMapper;
import com.crud.library.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final DbService service;
    private final BookMapper bookMapper;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createBook(@RequestBody BookDto bookDto) {
        Book book = bookMapper.mapToBook(bookDto);
        service.saveBook(book);
        return ResponseEntity.ok().build();
    }
}
