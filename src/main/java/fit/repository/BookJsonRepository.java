package fit.repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import fit.domain.Book;
import fit.util.FileReader;

public class BookJsonRepository {
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
}
