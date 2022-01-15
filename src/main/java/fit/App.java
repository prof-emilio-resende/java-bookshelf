package fit;

import fit.services.BookServiceImpl;

/**
 * This is the entry point of my spring boot app
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        var svc = new BookServiceImpl();
        var books = svc.findAll();
        books.forEach(b -> System.out.println(b.getTitle()));
    }
}
