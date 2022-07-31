package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "books")
public class Book {

    @Id
    @GeneratedValue
    private Long bookId;

    private String title;

    private String author;

    @Column(name = "yearofpublishing")
    private Short year;
}
