/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab12;

/**
 *
 * @author Dominic
 */
public class ArrayList implements List{
    
    private Object[] data;
    private int size;
    private int MAX = 16;
    
    public ArrayList() {
        data = new Object[MAX];
        size = 0;
    }

    @Override
    public Object get(int index) {
        if(index < size && index >= 0)
        {
            return data[index];
        }
        else
            return null;
    }

    @Override
    public void add(Object obj) {
        if(size == (MAX * 3 / 4)) //if we are at 3/4 of capacity, double max capacity
        {
            MAX *= 2;
            Object[] temp = new Object[MAX];
            for(int i = 0; i <= size; i++)
                temp[i] = data[i];
            data = temp;
        }
        data[size++] = obj;
    }

    @Override
    public int size() {
        return size;
    }
    
    
}
