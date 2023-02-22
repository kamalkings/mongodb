package elon.musk.twitter.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import elon.musk.twitter.model.Book;

public interface BookRepository extends MongoRepository<Book, Integer>{

}
