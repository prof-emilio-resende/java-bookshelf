package fit.domain.data;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.DisposableBean;

public class HibernateSessionBean implements DisposableBean {
  private SessionFactory sessionFactory;

  public SessionFactory getSessionFactory() {
    return sessionFactory;
  }

  public void setSessionFactory(SessionFactory instance) {
    this.sessionFactory = instance;
  }

  @Override
  public void destroy() throws Exception {
    if (sessionFactory != null) {
      sessionFactory.close();
    }
  }
}
