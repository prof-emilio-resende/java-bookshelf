package fit.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import fit.domain.Author;
import fit.repository.abstracts.AuthorRepository;

@Repository
public class AuthorHibernateRepository extends BaseRepository implements AuthorRepository {

  @Override
  public List<Author> findAll() {
    List<Author> result = new ArrayList<Author>();
    try {
      var session = prepareToQuery();
      TypedQuery<Author> query = session.createQuery("from Author a left join a.books", Author.class);
      var list = query.getResultList();

      session.close();
      return list;
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Can't communicate with hibernate...");
    }

    return result;
  }

  @Override
  public void create(Author author) {
    try {
      var session = prepareToQuery();
      var transaction = session.beginTransaction();
      session.save(author);
      transaction.commit();
      session.close();
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Can't communicate with hibernate...");
    }
  }
  
}
