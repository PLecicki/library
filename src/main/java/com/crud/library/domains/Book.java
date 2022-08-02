package com.crud.library.domains;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "books")
public class Book {

    public Book(Long bookId, String title, String author, Short year) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "book_id", unique = true)
    private Long bookId;

    private String title;

    private String author;

    @Column(name = "publishing_year")
    private Short year;

    @OneToMany(
            targetEntity = BookCopies.class,
            mappedBy = "book",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<BookCopies> bookCopies = new ArrayList<>();
}
