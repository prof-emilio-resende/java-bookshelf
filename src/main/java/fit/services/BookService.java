package fit.services;

import java.util.List;

import fit.domain.Book;

public interface BookService {
  public List<Book> findAll();
  public void create(Book book);
}
