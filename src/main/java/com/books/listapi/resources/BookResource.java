package com.books.listapi.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.books.listapi.repository.BookRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.books.listapi.models.*;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Books")
@CrossOrigin(origins="*")
public class BookResource {
	@Autowired
	BookRepository bookRepository;

	@GetMapping("/books")
	@ApiOperation(value="Retorna todos os livros")
	public List<Book> listBooks(){
		return bookRepository.findAll();
	}

	@GetMapping("/books/id/{id}")
	@ApiOperation(value="Retorna livro por ID")
	public Book listOneBook(@PathVariable(value="id") long id) {
		return bookRepository.findById(id);
	}
	
	@GetMapping("/books/title/{title}")
	@ApiOperation(value="Retorna livro por titulo")
	public Book listOneBook(@PathVariable(value="title") String title) {
		return bookRepository.findByTitle(title);
	}
	
	@GetMapping("/books/{autor}")
	@ApiOperation(value="Retorna livros por autor")
	public List<Book> listByAutor(@PathVariable(value="autor") String autor) {
		return bookRepository.findByAutor(autor);
	}
	
	@PostMapping("/book")
	@ApiOperation(value="Adiciona um livro")
	public Book saveBook(@RequestBody Book book) {
		return bookRepository.save(book);
	}
	
	@DeleteMapping("/book")
	@ApiOperation(value="Deleta umlivro")
	public void deletBook(@RequestBody Book book) {
		bookRepository.delete(book);
	}
	
	@PutMapping("/book")
	@ApiOperation(value="Edita um livro")
	public Book editBook(@RequestBody Book book) {
		return bookRepository.save(book);
	}
}
