package com.crud.library.service;

import com.crud.library.controller.BookCopiesNotFoundException;
import com.crud.library.controller.BookNotFoundException;
import com.crud.library.controller.BorrowsNotFoundException;
import com.crud.library.controller.ReaderNotFoundException;
import com.crud.library.domains.Book;
import com.crud.library.domains.BookCopies;
import com.crud.library.domains.Borrows;
import com.crud.library.domains.Reader;
import com.crud.library.repositories.BookCopiesRepository;
import com.crud.library.repositories.BookRepository;
import com.crud.library.repositories.BorrowsRepository;
import com.crud.library.repositories.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbService {

    private final BookRepository bookRepository;
    private final BookCopiesRepository bookCopiesRepository;
    private final BorrowsRepository borrowsRepository;
    private final ReaderRepository readerRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBook(final Long bookId) throws BookNotFoundException {
        return bookRepository.findById(bookId).orElseThrow(BookNotFoundException::new);
    }

    public Book saveBook(final Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(final Long bookId) {
        bookRepository.deleteById(bookId);
    }

    public List<BookCopies> getAllBookCopies() {
        return bookCopiesRepository.findAll();
    }

    public BookCopies getBookCopy(final Long bookCopiesId) throws BookCopiesNotFoundException {
        return bookCopiesRepository.findById(bookCopiesId).orElseThrow(BookCopiesNotFoundException::new);
    }

    public BookCopies saveBookCopy(final BookCopies bookCopies) {
        return bookCopiesRepository.save(bookCopies);
    }

    public void deleteBookCopy(final Long bookCopyId) {
        bookCopiesRepository.deleteById(bookCopyId);
    }

    public List<Reader> getAllReaders() {
        return readerRepository.findAll();
    }

    public Reader getReader(final Long readerId) throws ReaderNotFoundException {
        return readerRepository.findById(readerId).orElseThrow(ReaderNotFoundException::new);
    }

    public Reader saveReader(final Reader reader) {
        return readerRepository.save(reader);
    }

    public void deleteReader(final Long readerId) {
        readerRepository.deleteById(readerId);
    }

    public List<Borrows> getAllBorrows() {
        return borrowsRepository.findAll();
    }

    public Borrows getBorrow(final Long borrowId) throws BorrowsNotFoundException {
        return borrowsRepository.findById(borrowId).orElseThrow(BorrowsNotFoundException::new);
    }

    public Borrows saveBorrow(final Borrows borrow) {
        return borrowsRepository.save(borrow);
    }

    public void deleteBorrow(final Long borrowId) {
        borrowsRepository.deleteById(borrowId);
    }
}
