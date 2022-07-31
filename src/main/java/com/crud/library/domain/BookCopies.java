package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "copies")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookCopies {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bookId")
    private Book book;

    private Status status;

    private enum Status {
        AVAILABLE, BROKEN, LOST, BORROWED;
    }
}
