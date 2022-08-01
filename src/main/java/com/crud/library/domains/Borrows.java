package com.crud.library.domains;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "borrowed_books")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Borrows {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "borrow_id", unique = true)
    private Long borrowId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "book_copy_id")
    private BookCopies bookCopies;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "reader_id")
    private Reader reader;

    @Column(name = "date_of_borrowing")
    private LocalDate borrowing;

    @Column(name = "date_of_returning")
    private LocalDate returning;
}
