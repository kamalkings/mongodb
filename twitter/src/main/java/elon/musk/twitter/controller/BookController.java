package elon.musk.twitter.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import elon.musk.twitter.model.Book;
import elon.musk.twitter.repository.BookRepository;

@RestController
public class BookController {
	
	private static final Logger log = LoggerFactory.getLogger(BookController.class.getSimpleName());

	@Autowired
	private BookRepository repository;

	@PostMapping("/addBook")
	public String saveBook(@RequestBody Book book) {
		repository.save(book);
		return "Added book with id : " + book.getClass();
	}

	@GetMapping("/findAllBooks")
	public List<Book> getBooks() {
		log.info("######################################");
		log.info( "Here we Go "+repository.findAll());
		return repository.findAll();
	}

	@GetMapping("/findAllBooks/{bookId}")
	public Optional<Book> getBook(@PathVariable int bookId) {
		log.info("######################################");
		log.info("id :" +bookId);
		log.info(""+repository.findById(bookId));
		return repository.findById(bookId);
	}

	@DeleteMapping("/delete/{bookId}")
	public String deleteBook(@PathVariable int bookId) {
		log.info("#%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
	repository.deleteById(bookId);
		return "book deleted with id : " + bookId;
	}

}
