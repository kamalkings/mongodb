package elon.musk.twitter.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import elon.musk.twitter.model.Book;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends MongoRepository<Book, Integer>{


    @Query("{bookId :?0}")                                                  //SQL Equivalent : SELECT * FROM BOOK WHERE ID=?
    Optional<Book> getBookByBookId(Integer bookId);


    @Query("{author : ?0}")                                         // SQL Equivalent : SELECT * FROM BOOK where author = ?
    List<Book> getBooksByAuthor(String author);

    List<Book> findByTitleContaining(String bookName);



}
