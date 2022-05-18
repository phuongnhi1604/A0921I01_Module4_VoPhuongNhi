package com.codegym.book_management.model;
import javax.persistence.*;
import javax.validation.constraints.Null;
import java.util.List;

@Entity
public class Library {
    @Id
    private int id;
    private String title;
    @Null
    private int quantity;


    @OneToMany(mappedBy = "library")
    @Column(name = "library_id")
    private List<Book> books;

    public Library() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
