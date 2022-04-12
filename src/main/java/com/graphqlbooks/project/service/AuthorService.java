package com.graphqlbooks.project.service;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphqlbooks.project.model.Author;
import com.graphqlbooks.project.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService implements GraphQLQueryResolver {

    @Autowired
    private AuthorRepository authorRepository;

    public Author getAuthor(String authorName) {
        return authorRepository.getAuthorByName(authorName);
    }
}
