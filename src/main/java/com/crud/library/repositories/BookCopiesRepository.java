package com.crud.library.repositories;

import com.crud.library.domains.BookCopies;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookCopiesRepository extends CrudRepository<BookCopies, Long> {
    @Override
    List<BookCopies> findAll();

    @Override
    BookCopies save(BookCopies bookCopies);

    @Override
    Optional<BookCopies> findById(Long id);

    List<BookCopies> findByBook_BookIdAndStatus(Long bookId, String status);
}
