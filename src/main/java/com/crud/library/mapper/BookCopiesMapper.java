package com.crud.library.mapper;

import com.crud.library.domains.BookCopies;
import com.crud.library.domains.BookCopiesDto;
import com.crud.library.domains.EditBookCopyDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookCopiesMapper {

    public BookCopies mapToBookCopies(final BookCopiesDto bookCopiesDto) {
        return new BookCopies(
              0L,
              bookCopiesDto.getBook(),
              bookCopiesDto.getStatus()
        );
    }

    public BookCopies mapToBookCopies(final EditBookCopyDto editBookCopyDto) {
        return new BookCopies(
                editBookCopyDto.getBookCopyId(),
                editBookCopyDto.getBook(),
                editBookCopyDto.getStatus()
        );
    }

    public BookCopiesDto mapToBookCopiesDto(final BookCopies bookCopies) {
        return new BookCopiesDto(
                bookCopies.getBook(),
                bookCopies.getStatus()
        );
    }

    public List<BookCopiesDto> mapToBookCopiesDtoList(final List<BookCopies> bookCopiesList) {
        return bookCopiesList.stream()
                .map(this::mapToBookCopiesDto)
                .collect(Collectors.toList());
    }
}
