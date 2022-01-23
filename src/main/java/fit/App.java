package fit;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

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
        svc.create(new Book("The newwwww book!"));
        var books = svc.findAll();
        books.forEach(b -> System.out.println(b.getTitle()));
    }

    public static void main( String[] args )
    {
        var appContext = new AnnotationConfigApplicationContext(AppConfig.class);
        run(appContext);
    }
}
