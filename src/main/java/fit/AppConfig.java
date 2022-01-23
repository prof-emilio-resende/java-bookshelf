package fit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import fit.factories.HibernateSessionFactory;

@Configuration
@ComponentScan
public class AppConfig {
  @Bean
  public HibernateSessionFactory hibernateSessionBeanFactory() {
    return new HibernateSessionFactory();
  }
}
