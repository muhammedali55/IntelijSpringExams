package com.SpringDeneme.SpringDemo.service;

import com.SpringDeneme.SpringDemo.model.Book;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;



public interface IBookService {
    @PreAuthorize("hasRole('ROLE_WRITE')")
    public void addBook(Book book);

    @PostAuthorize("returnObject.owner == authentication.name")
    public Book getBook();

    @PreAuthorize ("#book.owner == authentication.name")
    public void deleteBook(Book book);
}