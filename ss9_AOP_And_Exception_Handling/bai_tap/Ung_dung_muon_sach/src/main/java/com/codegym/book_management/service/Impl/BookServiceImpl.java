package com.codegym.book_management.service.Impl;

import com.codegym.book_management.model.Book;
import com.codegym.book_management.repository.BookRepository;
import com.codegym.book_management.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Page<Book> findAllById(int id, Pageable pageable) {
        return bookRepository.findAllById(id,pageable);
    }

    @Override
    public void add(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void borrow(int id) {
        Book book = bookRepository.findById(id);
        book.setStatus(false);
        bookRepository.save(book);
    }

    @Override
    public void repay(int id) {
        Book book = bookRepository.findById(id);
        book.setStatus(true);
        bookRepository.save(book);
    }

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id);
    }
}
