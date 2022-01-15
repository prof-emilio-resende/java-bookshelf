package fit.repository;

import java.util.List;

import fit.domain.Book;

public class BookInMemoryRepository {
  public List<Book> findAll() {
    return List.of(new Book("Book One"), new Book("Book Two"));
  }  
}
