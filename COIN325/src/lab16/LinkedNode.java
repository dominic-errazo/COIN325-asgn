/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab16;

/**
 *
 * @author Dominic
 */
public class LinkedNode<T> {
    
    private T _element;
    private LinkedNode<T> _next;
    
    public T getElement() {
        return _element;
    }
    
    public void setElement(T element) {
        _element = element;
    }
    
    public LinkedNode<T> getNext() {
        return _next;
    }
    
    public void setNext(LinkedNode<T> next) {
        _next = next;
    }
    
    
}
