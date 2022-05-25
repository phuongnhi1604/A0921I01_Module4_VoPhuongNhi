package com.codegym.blog_management.repository;

import com.codegym.blog_management.model.Blog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface BlogRepository extends PagingAndSortingRepository<Blog, Long> {
    @Query(value = "select * from blog where category_id= :id", nativeQuery = true)
    public Iterable<Blog> findBlogByCategoryID(@Param("id") Long id);
}
