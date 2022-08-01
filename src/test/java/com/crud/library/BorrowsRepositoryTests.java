package com.crud.library;

import com.crud.library.domains.Book;
import com.crud.library.domains.BookCopies;
import com.crud.library.domains.Borrows;
import com.crud.library.domains.Reader;
import com.crud.library.repositories.BorrowsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = KodillaLibraryApplication.class)
public class BorrowsRepositoryTests {

    @Autowired
    private BorrowsRepository borrowsRepository;

    @Test
    void saveBorrowTest() {
        //Given
        Reader reader = new Reader();
        reader.setName("Pawel");
        reader.setSurname("Kowalski");
        reader.setBirth(LocalDate.of(1993, 4, 12));

        Book book = new Book();
        book.setTitle("Title1");
        book.setAuthor("Author1");
        book.setYear((short)1999);

        BookCopies bookCopy = new BookCopies();
        bookCopy.setBook(book);
        bookCopy.setStatus("Borrowed");

        Borrows borrows = new Borrows();
        borrows.setBookCopies(bookCopy);
        borrows.setReader(reader);
        borrows.setBorrowing(LocalDate.of(2022, 6, 12));
        borrows.setBorrowing(LocalDate.of(2023, 1, 23));

        //When
        borrowsRepository.save(borrows);

        //Then
        Assertions.assertNotEquals(borrows.getBorrowId(), null);

        //CleanUp
        borrowsRepository.delete(borrows);
    }

    @Test
    void deleteBorrowTest() {
        //Given
        Reader reader = new Reader();
        reader.setName("Pawel");
        reader.setSurname("Kowalski");
        reader.setBirth(LocalDate.of(1993, 4, 12));

        Book book = new Book();
        book.setTitle("Title1");
        book.setAuthor("Author1");
        book.setYear((short)1999);

        BookCopies bookCopy = new BookCopies();
        bookCopy.setBook(book);
        bookCopy.setStatus("Borrowed");

        Borrows borrows = new Borrows();
        borrows.setBookCopies(bookCopy);
        borrows.setReader(reader);
        borrows.setBorrowing(LocalDate.of(2022, 6, 12));
        borrows.setBorrowing(LocalDate.of(2023, 1, 23));

        borrowsRepository.save(borrows);

        //When
        borrowsRepository.delete(borrows);

        //Then
        Assertions.assertEquals(Optional.empty(), borrowsRepository.findById(borrows.getBorrowId()));
    }
}
