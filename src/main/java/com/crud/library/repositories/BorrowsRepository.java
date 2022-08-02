package com.crud.library.repositories;

import com.crud.library.domains.Borrows;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BorrowsRepository extends CrudRepository<Borrows, Long> {
    @Override
    List<Borrows> findAll();

    @Override
    Borrows save(Borrows borrows);

    @Override
    Optional<Borrows> findById(Long id);
}
