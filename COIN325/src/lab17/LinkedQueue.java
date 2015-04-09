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
public class LinkedQueue<T> implements Queue<T> {

    private int _count;
    private LinearNode<T> _head, _tail;
    
    public LinkedQueue() {
        _count = 0;
        _head = _tail = null;
    }
    
    @Override
    public void enqueue(T element) {
        LinearNode<T> node = new LinearNode<T>();
        node.setElement(element);
        if(_head == null)
            _head = node;
        else {
            _tail.setNext(node);
        }
        _tail = node;
        _count++;
    }

    @Override
    public T dequeue() throws EmptyCollectionException{
        if(_count == 0)
            throw new EmptyCollectionException("queue is empty");
        else {
            T elt = _head.getElement();
            _head = _head.getNext();
            _count--;
            return elt;
        }
    }

    @Override
    public T first() throws EmptyCollectionException{
        if(_count == 0)
            throw new EmptyCollectionException("queue is empty");
        else {
            T elt = _head.getElement();
            return elt;
        }
    }

    @Override
    public boolean isEmpty() {
        return _count == 0;
    }

    @Override
    public int size() {
        return _count;
    }
    
    @Override
    public String toString() {
        return "";
    }
    
}
