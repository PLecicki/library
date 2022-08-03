package com.crud.library.domains;

import com.crud.library.constants.CopyStatus;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.Cascade;

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

    @NotNull
    @ManyToOne()
    @Cascade(org.hibernate.annotations.CascadeType.REPLICATE)
    @JoinColumn(name = "book_id")
    private Book book;

    private CopyStatus status;
}
