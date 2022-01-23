package fit.repository;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import fit.factories.HibernateSessionFactory;

public abstract class BaseRepository {
  @Autowired
  protected HibernateSessionFactory factory;

  protected Session prepareToQuery() throws Exception {
    var sessionBean = factory.getObject();
    var sessionFactory = sessionBean.getSessionFactory();
    return sessionFactory.openSession();
  }
}
