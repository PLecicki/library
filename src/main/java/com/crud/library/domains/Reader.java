package com.crud.library.domains;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "readers")
public class Reader {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "reader_id", unique = true)
    private Long readerId;

    private String name;

    private String surname;

    @Column(name = "date_of_birth")
    private LocalDate birth;
}
