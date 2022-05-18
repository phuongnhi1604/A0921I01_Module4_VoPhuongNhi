package com.codegym.book_management.repository;

import com.codegym.book_management.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query(value = "select b.book_id,b.author,b.book_name,b.content,b.publisher,b.`status`,b.library_id from book as b join library as li on b.library_id = li.id where b.library_id = :id and b.status=1", nativeQuery = true,
        countQuery = "select count(*) from (select b.book_id,b.author,b.book_name,b.content,b.publisher,b.`status`,b.library_id from book as b join library as li on b.library_id = li.id where b.library_id = :id and b.status=1) def")
    Page<Book> findAllById(@Param("id") int id,Pageable pageable);

    @Query(value = "select * from book where book_id= :id", nativeQuery = true)
    Book findById(@Param("id") int id);
}
