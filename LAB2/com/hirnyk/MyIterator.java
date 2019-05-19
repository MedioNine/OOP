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
 * @param <String>
 */
public class MyIterator implements Iterator<String>{
    
    private int current = 0;
    private String[] dat;
    private int length;
   // private int length;
    
    MyIterator(String[] data, int length){
        dat = data; 
        this.length = length;
     //   this.length = length;
    }
    @Override
    public boolean hasNext() {
        //if (next()==null) return false;
        return current < length;
    }

    @Override
    public String next() {
        return dat[current++];
    }
    
    @Override
    public void remove(){
        dat[current] = null;
        current--;
    }
    
}
