package com.crud.library;

import com.crud.library.domains.Book;
import com.crud.library.repositories.BookRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class BookRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void saveBookTest() {
        Book book = Book.builder()
                .title("Title1")
                .author("Author1")
                .year((short)1999)
                .build();

        entityManager.persist(book);

        Assertions.assertThat(bookRepository.findByTitle("Title1").get().getAuthor()).isEqualTo("Author1");
    }
}
