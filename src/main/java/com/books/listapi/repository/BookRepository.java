package com.books.listapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.books.listapi.models.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
	Book findById(long id);
	Book findByTitle(String title);
	List<Book> findByAutor(String autor);
}
