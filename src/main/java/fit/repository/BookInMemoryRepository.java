package fit.repository;

import java.util.List;

import fit.domain.Book;
import fit.repository.abstracts.BookRepository;

//@Repository
public class BookInMemoryRepository implements BookRepository {
  private List<Book> books = List.of(new Book("Book One from Memory"), new Book("Book two from memory"));

  public List<Book> findAll() {
    return List.copyOf(books);
  }

  @Override
  public void create(Book book) {
    books.add(book);
  }  
}
