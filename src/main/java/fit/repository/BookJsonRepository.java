package fit.repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import fit.domain.Book;
import fit.util.FileReader;

//@Repository
public class BookJsonRepository implements BookRepository {
  public List<Book> findAll() {
    var books = new ArrayList<Book>();
    
    try {
      var rawData = FileReader.read("books.json");
      return new Gson().fromJson(rawData, new TypeToken<List<Book>>(){}.getType());
    } catch (IOException ex) {
      System.out.println("Can't read file!");
    }

    return books;
  }

  @Override
  public void create(Book book) {
    System.out.println("Hey, I didn't mean to disappoint you... but this is read-only from Json");
  }  
}
