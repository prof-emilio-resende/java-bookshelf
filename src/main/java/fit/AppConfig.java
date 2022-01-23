package fit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import fit.factories.HibernateSessionFactory;

@Configuration
@ComponentScan
public class AppConfig {
  @Bean
  @Scope("singleton")
  public HibernateSessionFactory hibernateSessionBeanFactory() {
    return new HibernateSessionFactory();
  }
}
