package com.crud.library.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalHttpErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<Object> handleBookNotFoundException(BookNotFoundException exception) {
        return new ResponseEntity<>("Book with given id doesn't exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BookCopiesNotFoundException.class)
    public ResponseEntity<Object> handleBookCopiesNotFoundException(BookCopiesNotFoundException exception) {
        return new ResponseEntity<>("Book copy with given id doesn't exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BorrowsNotFoundException.class)
    public ResponseEntity<Object> handleBorrowsNotFoundException(BorrowsNotFoundException exception) {
        return new ResponseEntity<>("Borrow with given id doesn't exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ReaderNotFoundException.class)
    public ResponseEntity<Object> handleReaderNotFoundException(ReaderNotFoundException exception) {
        return new ResponseEntity<>("Reader with given id doesn't exist", HttpStatus.BAD_REQUEST);
    }
}
