/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab15;

/**
 *
 * @author Dominic
 */
public class ArrayStack<T> implements Stack<T>{
    
    private final int DEFAULT_CAPACITY = 10;
    private T[] mArray;
    private int mPosition;
    
    

    
    public ArrayStack() {
        mPosition = 0;
        mArray = (T[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void push(T element) {
        
        if(mPosition == mArray.length)
            expandCapacity();
        
        mArray[mPosition++] = element;
        
    }
    
    @Override
    public String toString() {
        String result = "<top of stack>";
        
        for(int index = mPosition-1; index >= 0; index--)
            result += mArray[index] + "\n";
        
        return result + "<bottom of stack>";
    }
    
    private void expandCapacity() {
        T[] larger = (T[]) (new Object[mArray.length*2]);
        
        for(int index = 0; index < mArray.length; index++)
            larger[index] = mArray[index];
        
        mArray = larger;
    }

    @Override
    public T pop() throws EmptyCollectionException{
        if(mPosition > 0) {
            T elt = mArray[mPosition-1];
            mArray[mPosition-1] = null;
            mPosition--;
            return elt;
        }
        else
            throw new EmptyCollectionException("Cannot pop from an empty stack!");
    }
    
    @Override
    public T peek()  throws EmptyCollectionException{
        if(mPosition > 0)
            return mArray[mPosition-1];
        else
            throw new EmptyCollectionException("Nothing on the stack to peek!");
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return mPosition;
    }
    
}
