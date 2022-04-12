package com.graphqlbooks.project.service;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.graphqlbooks.project.model.Author;
import com.graphqlbooks.project.model.Book;
import com.graphqlbooks.project.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookResolver implements GraphQLResolver<Author> {

    @Autowired
    private BookRepository bookRepository;

    @Transactional
    public List<Book> getBooksByAuthor(Author author) {
        return bookRepository.findBooksByAuthorId(author.getAuthorId());
    }

}
