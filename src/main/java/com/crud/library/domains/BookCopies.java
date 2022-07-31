//package com.crud.library.domains;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//
//@Entity(name = "copies")
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//public class BookCopies {
//
//    @Id
//    @GeneratedValue
//    private Long bookCopyId;
//
//    @ManyToOne
//    @JoinColumn(name = "bookId")
//    private Book book;
//
//    private String status;
//}
