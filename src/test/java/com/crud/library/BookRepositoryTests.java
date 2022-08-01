package com.crud.library;

import com.crud.library.domains.Book;
import com.crud.library.repositories.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = KodillaLibraryApplication.class)
public class BookRepositoryTests {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void saveBookTest() {
        //Given
        Book book = new Book();
        book.setTitle("Title1");
        book.setAuthor("Author1");
        book.setYear((short)1999);

        //When
        bookRepository.save(book);

        //Then
        Assertions.assertNotEquals(book.getBookId(), null);

        //CleanUp
        bookRepository.deleteById(book.getBookId());
    }

    @Test
    public void deleteBookByIdTest() {
        //Given
        Book book = new Book();
        book.setTitle("Title1");
        book.setAuthor("Author1");
        book.setYear((short)1999);

        bookRepository.save(book);
        Long bookId = book.getBookId();

        //When
        bookRepository.deleteById(book.getBookId());

        //Then
        Assertions.assertEquals(Optional.empty(), bookRepository.findById(bookId));
    }
}
