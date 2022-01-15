package fit.repository;

import java.util.List;

import fit.domain.Book;

public interface BookRepository {
  public List<Book> findAll();
}
