package com.graphqlbooks.project.service;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphqlbooks.project.model.Author;
import com.graphqlbooks.project.model.Book;
import com.graphqlbooks.project.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements GraphQLQueryResolver {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

}
