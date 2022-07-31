package com.crud.library.repositories;

import com.crud.library.domains.Borrows;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowsRepository extends CrudRepository<Borrows, Long> {
}
