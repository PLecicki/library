package com.crud.library.controller;

import com.crud.library.domains.Reader;
import com.crud.library.domains.ReaderDto;
import com.crud.library.mapper.ReaderMapper;
import com.crud.library.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/reader")
@RequiredArgsConstructor
public class ReaderController {

    private final DbService service;
    private final ReaderMapper readerMapper;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createReader(@RequestBody ReaderDto readerDto) {
        Reader reader = readerMapper.mapToReader(readerDto);
        service.saveReader(reader);
        return ResponseEntity.ok().build();
    }
}
