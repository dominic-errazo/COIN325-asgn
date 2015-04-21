/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab18;

import java.util.LinkedList;
import java.util.HashSet;

/**
 *
 * @author Dominic
 */
public class HashLinkedChaining<K, V> implements Hash<K, V>{
    private Object[] _table;
    private int _size;
    
    public HashLinkedChaining() {
        _table = (new Object[100]);
        for(int i = 0; i < _table.length; i++)
            _table[i] = new LinkedList<HashNode<K,V>>();
        _size = 0;  
    }

    /*
        I managed to write this to avoid collisions where the key and value are
        the same for both variables. 
    */
    @Override
    public void put(K key, V value) {        
        if(key == null || value == null)
            return;
        
        LinkedList<HashNode<K,V>> list = 
                (LinkedList<HashNode<K,V>>) 
                _table[Math.abs(key.hashCode()) % _table.length];
        
        // RESOLVE ISSUE OF ADDING DUPLICATES
        HashNode<K,V> toAdd = new HashNode<>(key, value), current;
        
        //check the entire list
        
        boolean canAdd = true;
        for(int i = 0; i < list.size(); i++) {
            current = list.get(i);
            if(current.getKey().equals(key) && current.getValue().equals(value)) {
                //collision detected
                canAdd = false;
                i = list.size();
            }
        }
        
        if(canAdd) {
            list.add(toAdd);
            _size++;
        }
    }

    /*
        Gets the first instance of a match.
    */
    @Override
    public V get(K key) {
        
        V ret = null;
        
        if(key != null) {
            LinkedList<HashNode<K,V>> list =
                (LinkedList<HashNode<K,V>>)
                _table[Math.abs(key.hashCode()) % _table.length];
        
            //INCORRECT BELOW!
            ret = list.getFirst().getValue();
            //how to resolve collisions on get?
        }
        
        return ret;
    }
    
    /*
        Returns all values mapped to a given key.
        HashSet used because all values for a given key should be unique
        as guaranteed by the way put() is constructed.
    */
    public HashSet<V> getAll(K key) {
        HashSet<V> results = new HashSet<>();
        
        //if key is null, return an empty set
        if(key != null) {
            //otherwise, get all values and add them
            LinkedList<HashNode<K,V>> list =
                (LinkedList<HashNode<K,V>>)
                _table[Math.abs(key.hashCode()) % _table.length];
            
            for(int i = 0; i < list.size(); i++)
                results.add(list.get(i).getValue());
            
        }
        
        return results;
    }

    @Override
    public int size() {
        return _size;
    }
    
    
    
    
}
