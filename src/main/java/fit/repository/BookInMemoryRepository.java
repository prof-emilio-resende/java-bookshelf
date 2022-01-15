package fit.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import fit.domain.Book;

@Repository
public class BookInMemoryRepository implements BookRepository {
  public List<Book> findAll() {
    
    return List.of(new Book("Book One from Memory"), new Book("Book two from memory"));
  }  
}
