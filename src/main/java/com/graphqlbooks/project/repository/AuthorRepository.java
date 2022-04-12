package com.graphqlbooks.project.repository;

import com.graphqlbooks.project.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    @Query("from Author a where a.name = :name")
    Author getAuthorByName(@Param("name") String authorName);

}
