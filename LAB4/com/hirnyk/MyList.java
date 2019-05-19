/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hirnyk;

import java.util.Iterator;
/**
 *
 * @author Администратор
 * @param <T>
 */
public class MyList<T> implements Iterable<T> {

     private class Node {
         private T data;
         private Node next;
         
         public T getData(){
             return data;
         }
         
         public void setData(T data){
             this.data = data;
         }
         
         public Node getNext(){
             return next;
         }
         
         public void setNext(Node next){
             this.next = next;
         }
     }
    
     private Node first;
     
     private int size = 0;
     
     public int size(){
         return size;
     }
     
   public void add(T data){
            Node init = new Node();
            init.setData(data);
            if (first != null){
                Node temp = first;
                while ((temp.getNext())!= null){
                    temp = temp.getNext();
                }
                temp.setNext(init);
            }
            else {
                first = init;
            }
            size++;
        }
     
     public T  get(int index){
         if (index > size || index < 0)
             return null;
         Node temp = first;
         int count = 0;
         while(temp!=null){
             if(count++==index){
                 return temp.getData();
             }
             temp = temp.getNext();
         }
         return null;
     }
     
    public boolean remove(int index){
        if(index >= size || index < 0)
            return false;
        Node prev = null;
        Node real = first;
        int count = 0;
        while(true){
            if(count++ == index){
                if(real==first)
                    first = first.getNext();
                else if(real.getNext()==null)
                    prev.setNext(null);
                else prev.setNext(real.getNext());
                size--;
                return true;
            }
            prev = real;
            real = real.getNext();
        }
    }
    
    public void clear(){
        first = null;
        size = 0;
    }
    
     @Override
    public String toString(){
        StringBuilder string = new StringBuilder();
        Node count = first;
        while(count !=null){
            string.append(count.getData());
            count = count.getNext();
        }
        return string.toString();
    }
    
    public T[] toArray(){    
        T[] arr = (T[])new Object[size()];
        for(int i = 0; i < size; i++){
            arr[i] = get(i); 
        }
        return (T[])arr;
    }
    
    public boolean contains(T object){
        for(T i : this){
            if (i.equals(object))
                return true;
        }
        return false;
    }   
    
    @Override
    public Iterator<T> iterator() {
        Iterator<T> l;
         l = new Iterator<T>(){
             int counter = 0;
             
             @Override
             public boolean hasNext(){
                 return counter < size();
             }
             
             @Override
             public T next(){
                 return get(counter++);
             }
         };
        return l;
    }

    public boolean isEmpty(){
        return size==0;
    }
    
}
