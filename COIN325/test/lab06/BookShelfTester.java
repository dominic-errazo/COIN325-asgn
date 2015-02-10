package lab06;
 
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * BookShelf and Book JUnit tester for lab06
 * @author Dominic
 */
public class BookShelfTester {
    
    private Book novel1, novel2, novel3, novel4, novel5;
    private BookShelf perpetuallyEmpty, fillable;
    
    public BookShelfTester() {
        novel1 = new Book("A Life, Vol 1", "Davey Pratchell", "Lively Writings", "6 Jun 1988");
        novel2 = new Book("A Life, Vol 2", "Davey Pratchell", "Lively Writings", "19 Apr 1989");
        novel3 = new Book("A Life, Vol 3", "Davey Pratchell", "Lively Writings", "3 Aug 1992");
        novel4 = new Book("Habit Breakers", "Elsie de Nice", "The Worn Quill", "3 Jan 2000");
        novel5 = new Book("To Arms In Nature", "Jan Quinn", "The Worn Quill", "8 Jan 1995");
        
        perpetuallyEmpty = new BookShelf();
        fillable = new BookShelf();
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    //note to self: test empty/full bookshelves, setters/getters, numBooks - 
    //numBooks tested via empty/full stuff i think?
    
    @Test
    public void checkEmptiness() {
        int size1, size2;
        size1 = perpetuallyEmpty.numBooks();
        size2 = fillable.numBooks();
        assertTrue(size1 == 0);
        assertTrue(size2 == 0);
    }
    
    @Test
    public void checkSettersGetters() {
        assertTrue(novel4.getAuthor().equals("Elsie de Nice"));
        novel4.setAuthor("Jan Quinn");
        assertTrue(novel4.getAuthor().equals(novel5.getAuthor()));
        assertTrue(novel1.getPublisher().equals(novel2.getPublisher()));
        
        fillable.setBook1(novel1);
        assertTrue(fillable.getBook1().getAuthor().equals("Davey Pratchell"));
        assertNull(fillable.getBook2());
    }
    
    @Test
    public void checkFullShelf() {
        fillable.setBook1(novel1);
        fillable.setBook2(novel2);
        fillable.setBook3(novel3);
        fillable.setBook4(novel5);
        fillable.setBook5(novel4);
        
        assertTrue(fillable.numBooks() == 5);
    }
}
