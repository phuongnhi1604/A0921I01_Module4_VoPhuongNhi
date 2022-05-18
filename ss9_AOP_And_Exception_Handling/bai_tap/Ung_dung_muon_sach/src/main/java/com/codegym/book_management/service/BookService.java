package com.codegym.book_management.service;

import com.codegym.book_management.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface BookService {
    public Page<Book> findAllById(int id,Pageable pageable);
    public void add(Book book);
    public void borrow(int id);
    public void repay(int id);
    public Book findById(int id);
}
