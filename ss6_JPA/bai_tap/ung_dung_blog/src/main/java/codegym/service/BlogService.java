package codegym.service;

import codegym.entity.Blog;

import java.util.List;

public interface BlogService {
    public void create(Blog blog);
    List<Blog> findAll();
    public void update(Blog blog);
    Blog findById(int id);
    public void delete(int id);
}
