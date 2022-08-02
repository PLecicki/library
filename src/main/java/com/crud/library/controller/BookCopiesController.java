package com.crud.library.controller;

import com.crud.library.domains.BookCopies;
import com.crud.library.domains.BookCopiesDto;
import com.crud.library.mapper.BookCopiesMapper;
import com.crud.library.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/book_copies")
@RequiredArgsConstructor
public class BookCopiesController {

    private final DbService service;
    private final BookCopiesMapper bookCopiesMapper;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createBookCopy(@RequestBody BookCopiesDto bookCopiesDto) {
        BookCopies bookCopies = bookCopiesMapper.mapToBookCopies(bookCopiesDto);
        service.saveBookCopy(bookCopies);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<BookCopiesDto> updateBookCopy(@RequestBody BookCopiesDto bookCopiesDto) {
        BookCopies bookCopies = bookCopiesMapper.mapToBookCopies(bookCopiesDto);
        BookCopies savedBookCopies = service.saveBookCopy(bookCopies);
        return ResponseEntity.ok(bookCopiesMapper.mapToBookCopiesDto(savedBookCopies));
    }

    @GetMapping(value = "{bookId}")
    public ResponseEntity<Integer> getQuantityOfAvailableCopies(@PathVariable Long bookId) throws BookNotFoundException {
        try {
            return ResponseEntity.ok(bookCopiesMapper.mapToBookCopiesDtoList(
                    service.getBookCopiesByBookIdAndStatus(bookId, "Available")).size()
            );
        } catch (BookCopiesNotFoundException e) {
            return ResponseEntity.ok(0);
        }
    }
}
