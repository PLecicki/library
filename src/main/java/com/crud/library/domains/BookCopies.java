package com.crud.library.domains;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Entity(name = "copies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookCopies {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "book_copy_id", unique = true)
    private Long bookCopyId;

    @ManyToOne()
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private Book book;

    private String status;
}
