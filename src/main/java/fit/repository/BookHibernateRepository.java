package fit.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fit.domain.Book;
import fit.factories.HibernateSessionFactory;

@Repository
public class BookHibernateRepository implements BookRepository {
  @Autowired
  private HibernateSessionFactory factory;

  protected Session prepareToQuery() throws Exception {
    var sessionBean = factory.getObject();
    var sessionFactory = sessionBean.getSessionFactory();
    return sessionFactory.openSession();
  }

  @Override
  public List<Book> findAll() {
    List<Book> result = new ArrayList<Book>();
    try {
      var session = prepareToQuery();
      TypedQuery<Book> query = session.createQuery("from Book", Book.class);
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
  public void create(Book book) {
    try {
      var session = prepareToQuery();
      var transaction = session.beginTransaction();
      session.save(book);
      transaction.commit();
      session.close();
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Can't communicate with hibernate...");
    }
  }

}
