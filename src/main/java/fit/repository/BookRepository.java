package fit.repository;

import java.util.List;

import fit.domain.Book;

public interface BookRepository {
  public void create(Book book);
  public List<Book> findAll();
}
