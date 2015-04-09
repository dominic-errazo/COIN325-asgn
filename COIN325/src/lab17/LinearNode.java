/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab17;

/**
 *
 * @author Dominic
 */
public class LinearNode<T> {
    
    private T _element;
    private LinearNode<T> _next;
    
    public T getElement() {
        return _element;
    }
    
    public void setElement(T element) {
        _element = element;
    }
    
    public LinearNode<T> getNext() {
        return _next;
    }
    
    public void setNext(LinearNode<T> next) {
        _next = next;
    }
    
}
