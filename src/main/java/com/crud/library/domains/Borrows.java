//package com.crud.library.domains;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.time.LocalDate;
//
//@Entity(name = "borrowsbooks")
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
//public class Borrows {
//
//    @Id
//    @GeneratedValue
//    private Long borrowId;
//
//    @OneToOne
//    @JoinColumn(name = "bookCopyId")
//    private BookCopies bookCopies;
//
//    @OneToOne
//    @JoinColumn(name = "readerId")
//    private Reader reader;
//
//    @Column(name = "date of borrowing")
//    private LocalDate borrowing;
//
//    @Column(name = "date of returning")
//    private LocalDate returning;
//}
