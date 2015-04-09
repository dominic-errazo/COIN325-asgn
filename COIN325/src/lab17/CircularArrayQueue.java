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
public class CircularArrayQueue<T> implements Queue<T>{
    
    private T[] _queue;
    private final static int DEFAULT_CAPACITY = 100;
    private int _front, _rear, _count;
    
    public CircularArrayQueue(int initialCapacity) {
        _front = _rear = _count = 0;
        _queue = (T[]) new Object[initialCapacity];
    }
    
    public CircularArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public void enqueue(T element) {
        if(size() == _queue.length)
            //queue full, throw an exception
            throw new UnsupportedOperationException("Array out of space");
        else {
            _queue[_rear] = element;
            _rear = (_rear + 1) % _queue.length;
            _count++;
        }
    }

    @Override
    public T dequeue() throws EmptyCollectionException{
        if(_count == 0)
            throw new EmptyCollectionException("Nothing in the queue");
        else {
            T elt = _queue[_front];
            _front = (_front + 1) % _queue.length;
            _count--;
            return elt;
        }
    }

    @Override
    public T first() throws EmptyCollectionException{
        if(_count == 0)
            throw new EmptyCollectionException("Nothing in the queue");
        else {
            T elt = _queue[_front];
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
    
}
