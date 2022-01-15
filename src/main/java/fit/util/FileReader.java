package fit.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import fit.App;

public class FileReader {
  private static String readFromInputStream(InputStream inputStream)
      throws IOException {
    var resultStringBuilder = new StringBuilder();
    try (var br = new BufferedReader(new InputStreamReader(inputStream))) {
      String line;
      while ((line = br.readLine()) != null) {
        resultStringBuilder.append(line).append("\n");
      }
    }

    return resultStringBuilder.toString();
  }

  public static String read(String filename) throws IOException {
    var clazz = App.class;
    var is = clazz.getResourceAsStream(String.format("/%s", filename));
    String content = readFromInputStream(is);

    return content;
  }
}
