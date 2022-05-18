package com.codegym.book_management.service.Impl;

import com.codegym.book_management.model.Library;
import com.codegym.book_management.repository.LibraryRepository;
import com.codegym.book_management.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LibraryServiceImpl implements LibraryService {
    @Autowired
    private LibraryRepository libraryRepository;


    @Override
    public Page<Library> findAllByNativeQuery(Pageable pageable) {
        return libraryRepository.findAllByNativeQuery(pageable);
    }

    @Override
    public List<Library> findAll() {
        return libraryRepository.findAll();
    }

}
