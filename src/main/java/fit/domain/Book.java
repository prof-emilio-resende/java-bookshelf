package fit.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Book {
  private String title;
  
  @Id
  @GeneratedValue(generator="increment")
  @GenericGenerator(name="increment", strategy="increment")
  private Long id;
  private Long authorId;
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(referencedColumnName = "id")
  private Author author;

  public Book() {
    super();
  }

  public Book(String title) {
    super();
    this.title = title;
  }

  @Override
  public String toString() {
    return String.format("[title: %s, by: %s]", this.getTitle(), this.getAuthor() != null ? this.getAuthor() : "");
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getAuthorId() {
    return this.authorId;
  }
  
  public void setAuthorId(Long authorId) {
    this.authorId = authorId;
  }

  public Author getAuthor() {
    return author;
  }
  
  public void setAuthor(Author author) {
    this.author = author;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
}
