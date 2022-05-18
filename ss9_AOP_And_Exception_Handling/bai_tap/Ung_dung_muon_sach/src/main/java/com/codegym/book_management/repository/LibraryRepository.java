package com.codegym.book_management.repository;

import com.codegym.book_management.model.Library;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Integer> {
    @Query(value = "select li.id, li.title, count(*) as quantity from library as li join book as b on li.id = b.library_id where b.status=1 group by li.id", nativeQuery = true,
    countQuery = "select count(*) from (select li.id,li.title,count(*) as quantity from library as li join book as b on li.id=b.library_id  where b.status=1 group by li.id) abc")
    Page<Library> findAllByNativeQuery(Pageable pageable);
}
