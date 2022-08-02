package com.crud.library.mapper;

import com.crud.library.domains.Borrows;
import com.crud.library.domains.BorrowsDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowsMapper {

    public Borrows mapToBorrows(final BorrowsDto borrowsDto) {
        return new Borrows(
                borrowsDto.getBorrowId(),
                borrowsDto.getBookCopies(),
                borrowsDto.getReader(),
                borrowsDto.getBorrowing(),
                borrowsDto.getReturning()
        );
    }

    public BorrowsDto mapToBorrowsDto(final Borrows borrows) {
        return new BorrowsDto(
                borrows.getBorrowId(),
                borrows.getBookCopies(),
                borrows.getReader(),
                borrows.getBorrowing(),
                borrows.getReturning()
        );
    }

    public List<BorrowsDto> mapToBorrowsDtoList(final List<Borrows> borrows) {
        return borrows.stream()
                .map(this::mapToBorrowsDto)
                .collect(Collectors.toList());
    }
}
