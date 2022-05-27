package com.codegym.ajax_blog__app.repository;

import com.codegym.ajax_blog__app.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = "SELECT * FROM Blog where author like concat('%',:author,'%')  and category_id like concat('%',:category,'%')",
            nativeQuery = true,
            countQuery = "select count(*) from ( SELECT * FROM blog where author like concat('%',:author,'%')  and category_id like concat('%',:category,'%') ) abc ")
    Page<Blog> findByAuthorAndCategory(@Param("author") String author, @Param("category") String category, Pageable pageable);

    @Query(value = "select * from Blog", nativeQuery = true)
    Page<Blog> findAllByNativeQuery(Pageable pageable);

    @Query(value="select * from Blog order by post_date ",nativeQuery = true,
            countQuery = "select count(*) from (select * from Blog order by post_date) def")
    Page<Blog> sortByPostDate(Pageable pageable);

    List<Blog> findAllByCategory_Id(Integer id);

    @Query(value = "select * from Blog where author like concat('%',:author,'%')", nativeQuery = true)
    List<Blog> findAllByAuthor(@Param("author") String author);

}
