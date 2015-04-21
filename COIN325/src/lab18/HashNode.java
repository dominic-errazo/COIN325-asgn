/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab18;

/**
 *
 * @author Dominic
 */
public class HashNode<K, V> {
    private K _key;
    private V _value;
    
    public HashNode(K key, V value) {
        setKey(key);
        setValue(value);
    }
    
    public void setKey(K key) {
        _key = key;
    }
    
    public void setValue(V value) {
        _value = value;
    }
    
    public K getKey() {
        return _key;
    }
    
    public V getValue() {
        return _value;
    }
}
