package com.crud.library.controller;

import com.crud.library.domains.Borrows;
import com.crud.library.domains.BorrowsDto;
import com.crud.library.mapper.BorrowsMapper;
import com.crud.library.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/borrows")
@RequiredArgsConstructor
public class BorrowsController {

    private final DbService service;
    private final BorrowsMapper borrowsMapper;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createBorrow(@RequestBody BorrowsDto borrowsDto) {
        Borrows borrow = borrowsMapper.mapToBorrows(borrowsDto);
        service.saveBorrow(borrow);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "{borrowId}")
    public ResponseEntity<Void> deleteBorrow(@PathVariable Long borrowId) throws BorrowsNotFoundException {
        service.deleteBorrow(borrowId);
        return ResponseEntity.ok().build();
    }
}
