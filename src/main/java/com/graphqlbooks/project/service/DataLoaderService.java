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
        Book book1 = new Book();
        book1.setTitle("Чудесная книга");
        bookRepository.save(book1);

        Book book2 = new Book();
        book2.setTitle("Эхо звёздного мира");
        bookRepository.save(book2);

        Author author1 = new Author();
        author1.setName("Демидова М. Д.");
        author1.setBooks(List.of(book2));
        authorRepository.save(author1);

        Author author2 = new Author();
        author2.setName("Кольцов Ф. Н.");
        author2.setBooks(List.of(book2));
        authorRepository.save(author2);

        book1.setAuthors(List.of(author1));
        bookRepository.save(book1);

        book2.setAuthors(List.of(author1, author2));
        bookRepository.save(book2);
    }

}
