/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dominic
 */
public class BookShelf {
    
    private Book _book1, _book2, _book3, _book4, _book5; 
    private int total;
    
    public BookShelf() {
        total = 0;
    }

    public Book getBook1() {
        return _book1;
    }

    public void setBook1(Book book1) {
        _book1 = book1;
    }

    public Book getBook2() {
        return _book2;
    }

    public void setBook2(Book book2) {
        _book2 = book2;
    }

    public Book getBook3() {
        return _book3;
    }

    public void setBook3(Book book3) {
        _book3 = book3;
    }

    public Book getBook4() {
        return _book4;
    }

    public void setBook4(Book book4) {
        _book4 = book4;
    }

    public Book getBook5() {
        return _book5;
    }

    public void setBook5(Book book5) {
        _book5 = book5;
    }
    
    public int numBooks()
    {
        total = 0;
        if(_book1 != null) total++;
        if(_book2 != null) total++;
        if(_book3 != null) total++;
        if(_book4 != null) total++;
        if(_book5 != null) total++;
        return total;
        
    }
    
}
