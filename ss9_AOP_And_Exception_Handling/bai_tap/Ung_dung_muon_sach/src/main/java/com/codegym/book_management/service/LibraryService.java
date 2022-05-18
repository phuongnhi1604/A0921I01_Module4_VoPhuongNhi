package com.codegym.book_management.service;

import com.codegym.book_management.model.Library;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface LibraryService {
    public Page<Library> findAllByNativeQuery(Pageable pageable);
    public List<Library> findAll();
}
