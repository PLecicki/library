package com.crud.library;

import com.crud.library.domains.Book;
import com.crud.library.domains.BookCopies;
import com.crud.library.repositories.BookCopiesRepository;
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
public class BookCopiesRepositoryTests {

    @Autowired
    private BookCopiesRepository bookCopiesRepository;

    @Test
    public void saveCopiesTest() {
        //Given
        Book book = new Book();
        book.setTitle("Title1");
        book.setAuthor("Author1");
        book.setYear((short)1999);

        BookCopies bookCopy1 = new BookCopies();
        bookCopy1.setBook(book);
        bookCopy1.setStatus("Borrowed");

        BookCopies bookCopy2 = new BookCopies();
        bookCopy2.setBook(book);
        bookCopy2.setStatus("Available");

        BookCopies bookCopy3 = new BookCopies();
        bookCopy3.setBook(book);
        bookCopy3.setStatus("Broken");

        book.getBookCopies().add(bookCopy1);
        book.getBookCopies().add(bookCopy2);
        book.getBookCopies().add(bookCopy3);

        //When
        bookCopiesRepository.save(bookCopy1);
        bookCopiesRepository.save(bookCopy2);
        bookCopiesRepository.save(bookCopy3);

        //Then
        Assertions.assertEquals("Borrowed",
                bookCopiesRepository.findById(bookCopy1.getBookCopyId()).get().getStatus());
        Assertions.assertEquals("Available",
                bookCopiesRepository.findById(bookCopy2.getBookCopyId()).get().getStatus());
        Assertions.assertEquals("Broken",
                bookCopiesRepository.findById(bookCopy3.getBookCopyId()).get().getStatus());

        //CleanUp
        bookCopiesRepository.delete(bookCopy1);
        bookCopiesRepository.delete(bookCopy2);
        bookCopiesRepository.delete(bookCopy3);
    }

    @Test
    void deleteCopiesTest() {
        //Given
        Book book = new Book();
        book.setTitle("Title1");
        book.setAuthor("Author1");
        book.setYear((short)1999);

        BookCopies bookCopy1 = new BookCopies();
        bookCopy1.setBook(book);
        bookCopy1.setStatus("Borrowed");

        BookCopies bookCopy2 = new BookCopies();
        bookCopy2.setBook(book);
        bookCopy2.setStatus("Available");

        BookCopies bookCopy3 = new BookCopies();
        bookCopy3.setBook(book);
        bookCopy3.setStatus("Broken");

        book.getBookCopies().add(bookCopy1);
        book.getBookCopies().add(bookCopy2);
        book.getBookCopies().add(bookCopy3);

        bookCopiesRepository.save(bookCopy1);
        bookCopiesRepository.save(bookCopy2);
        bookCopiesRepository.save(bookCopy3);

        //When
        bookCopiesRepository.delete(bookCopy1);
        bookCopiesRepository.delete(bookCopy2);
        bookCopiesRepository.delete(bookCopy3);

        //Then
        Assertions.assertEquals(Optional.empty(), bookCopiesRepository.findById(bookCopy1.getBookCopyId()));
        Assertions.assertEquals(Optional.empty(), bookCopiesRepository.findById(bookCopy2.getBookCopyId()));
        Assertions.assertEquals(Optional.empty(), bookCopiesRepository.findById(bookCopy3.getBookCopyId()));
    }
}
