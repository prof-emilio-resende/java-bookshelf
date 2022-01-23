package fit.factories;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.beans.factory.FactoryBean;

import fit.domain.data.HibernateSessionBean;

public class HibernateSessionFactory implements FactoryBean<HibernateSessionBean> {
  @Override
  public HibernateSessionBean getObject() throws Exception {
    return getInstance();
  }

  @Override
  public Class<?> getObjectType() {
    return HibernateSessionBean.class;
  }

  private HibernateSessionBean getInstance() throws Exception {
    // A SessionFactory is set up once for an application!
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
        .configure() // configures settings from hibernate.cfg.xml
        .build();
    try {
      var sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
      var bean = new HibernateSessionBean();
      bean.setSessionFactory(sessionFactory);

      return bean;
    } catch (Exception e) {
      // The registry would be destroyed by the SessionFactory, but we had trouble
      // building the SessionFactory
      // so destroy it manually.
      StandardServiceRegistryBuilder.destroy(registry);

      return null;
    }
  }
}
