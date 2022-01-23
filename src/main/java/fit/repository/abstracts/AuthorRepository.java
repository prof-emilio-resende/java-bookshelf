package fit.repository.abstracts;

import java.util.List;

import fit.domain.Author;

public interface AuthorRepository {
  public void create(Author author);
  public List<Author> findAll();
}
