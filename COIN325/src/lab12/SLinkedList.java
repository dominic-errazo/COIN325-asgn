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
public class SLinkedList implements List{

    private Node head, tail;
    
    @Override
    public Object get(int index) {
        int current = 0;
        Node cNode = head;
        if(index < 0) {
            return null;
        }
        else {
            while(cNode != null)
            {
                if(current == index) {
                    //index node found
                    return cNode._val;
                }
                else {
                    current++;
                    cNode = cNode._next;
                }
            }
            return null; //exceeded list size
        }
    }

    @Override
    public void add(Object obj) {
        Node node = new Node();
        node._val = obj;
        node._next = null;
        if(head == null && tail == null) {
            head = tail = node;
        }
        else { 
            //assuming head, tail not null
            if(head != null && tail != null) {
                tail._next = node;
                tail = node;
            }
            else {
                System.err.println("Invalid state: head xor tail null");
                //how did you even get here
            }
        }
    }

    @Override
    public int size() {
        int size = 0;
        Node cNode = head;
        while(cNode != null)
        {
            size++;
            cNode = cNode._next;
        }
        return size;
    }
    class Node {
        Object _val;
        Node _next;
        
        
    }
}
