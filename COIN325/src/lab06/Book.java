package lab06;

/**
 *
 * @author Dominic
 */
public class Book {
    private String _title, _author, _publisher, _copyrightDate;
    
    public Book(String title, String author, String publisher, String copyrightDate) {
        
        _title = title;
        _author = author;
        _publisher = publisher;
        _copyrightDate = copyrightDate;
    }
    
    public String getTitle() {
        return _title;
    }
    
    public void setTitle(String title) {
        _title = title;
    }
    
    public String getAuthor() {
        return _author;
    }

    public void setAuthor(String author) {
        _author = author;
    }

    public String getPublisher() {
        return _publisher;
    }

    public void setPublisher(String publisher) {
        _publisher = publisher;
    }

    public String getCopyrightDate() {
        return _copyrightDate;
    }

    public void setCopyrightDate(String copyrightDate) {
        _copyrightDate = copyrightDate;
    }
    
    
}
