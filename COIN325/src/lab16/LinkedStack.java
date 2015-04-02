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
public class LinkedStack<T> implements Stack<T>{
    
    private int _count;
    private LinkedNode<T> _top;

    public LinkedStack()
    {
        _count = 0;
        _top = null;
    }
    
    @Override
    public void push(T element) {
        LinkedNode<T> created = new LinkedNode<T>();
        created.setElement(element);
        created.setNext(_top);
        _top = created;
        
        _count++;
    }

    @Override
    public T pop() throws EmptyCollectionException {
        if(_top == null) {
            throw new EmptyCollectionException("Empty stack");
        }
        else {
            T result = _top.getElement();
            _top = _top.getNext();
            _count--;
            
            return result;
        }
    }

    @Override
    public T peek() throws EmptyCollectionException {
        if(_top == null)
            throw new EmptyCollectionException("Empty stack");
        else {
            T result = _top.getElement();
            return result;
        }
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return _count;
    }
    
}
