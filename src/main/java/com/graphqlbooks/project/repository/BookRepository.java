package com.graphqlbooks.project.repository;

import com.graphqlbooks.project.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query("FROM Book b INNER JOIN b.authors a WITH a.authorId = :id")
    List<Book> findBooksByAuthorId(@Param("id") Integer id);

}
