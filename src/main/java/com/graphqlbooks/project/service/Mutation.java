package com.graphqlbooks.project.service;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graphqlbooks.project.model.Author;
import com.graphqlbooks.project.model.Book;
import com.graphqlbooks.project.repository.AuthorRepository;
import com.graphqlbooks.project.repository.BookRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    @Transactional
    public Book saveBook(BookInput bookInput) {
        Book book = new Book();
        book.setTitle(bookInput.getTitle());
        if (!bookInput.getAuthor().isEmpty()) {
            Author author = new Author();
            author.setName(bookInput.getAuthor());
            author.setBooks(List.of(book));
            authorRepository.save(author);
            book.setAuthors(List.of(author));
        }
        return bookRepository.save(book);
    }

    @Transactional
    public Author saveAuthor(AuthorInput authorInput) {
        Author author = new Author();
        author.setName(authorInput.getName());
        if (!authorInput.getBook().isEmpty()) {
            Book book = new Book();
            book.setTitle(authorInput.getBook());
            book.setAuthors(List.of(author));
            bookRepository.save(book);
            author.setBooks(List.of(book));
        }
        return authorRepository.save(author);
    }

}

@Data
@NoArgsConstructor
@AllArgsConstructor
class BookInput {
    private String title;
    private String author;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class AuthorInput {
    private String name;
    private String book;
}
