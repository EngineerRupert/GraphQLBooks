package com.graphqlbooks.project.service;

import com.graphqlbooks.project.model.Author;
import com.graphqlbooks.project.model.Book;
import com.graphqlbooks.project.repository.AuthorRepository;
import com.graphqlbooks.project.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class DataLoaderService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    @PostConstruct
    public void loadData() {
        Author author1 = new Author("Демидова М. Д.");
        authorRepository.save(author1);
        Author author2 = new Author("Кольцов Ф. Н.");
        authorRepository.save(author2);
        Book book = new Book("Эхо звёздного мира");
        book.setAuthors(List.of(author1, author2));
        bookRepository.save(book);
    }

}
