package com.crud.library.domains;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "books")
@Builder
public class Book {

    @Id
    @GeneratedValue
    private Long bookId;

    private String title;

    private String author;

    @Column(name = "publishing_year")
    private Short year;
}
