package fit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fit.domain.Book;
import fit.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
  @Autowired
  private BookRepository repo;

  public List<Book> findAll() {
    return repo.findAll();
  }
}
