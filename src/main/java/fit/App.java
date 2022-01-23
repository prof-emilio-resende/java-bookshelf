package fit;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import fit.domain.Author;
import fit.domain.Book;
import fit.services.BookService;

/**
 * This is the entry point of my spring boot app
 *
 */
public class App 
{
    private static void run(GenericApplicationContext appContext) {
        var svc = appContext.getBean(BookService.class);
        var author = new Author("Author's");
        var book = new Book("The newwwww book!");

        author.setBooks(List.of(book));
        book.setAuthor(author);

        svc.create(book);
        var books = svc.findAll();
        books.forEach(b -> {
            System.out.println(b);
            System.out.println(b.getTitle());
            System.out.println(b.getId());
        });
    }

    public static void main( String[] args )
    {
        var appContext = new AnnotationConfigApplicationContext(AppConfig.class);
        run(appContext);
    }
}
