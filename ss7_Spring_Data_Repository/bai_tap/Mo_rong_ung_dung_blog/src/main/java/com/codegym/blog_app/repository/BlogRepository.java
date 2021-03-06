package com.codegym.blog_app.repository;

import com.codegym.blog_app.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


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

}
