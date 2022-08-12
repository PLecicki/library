package com.crud.library.domains;

import com.crud.library.constants.CopyStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EditBookCopyDto {
    private Long bookCopyId;
    private Book book;
    private CopyStatus status;
}
