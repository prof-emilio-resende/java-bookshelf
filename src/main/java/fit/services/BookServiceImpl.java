package fit.services;

import java.util.List;

import fit.domain.Book;
import fit.repository.BookJsonRepository;

public class BookServiceImpl {
  public List<Book> findAll() {
    return new BookJsonRepository().findAll();
  }
}
