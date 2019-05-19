/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hirnyk;
import java.util.*;
import java.io.*;
/**
 *
 * @author Администратор
 * 
 * 
 **/
public class MyContainer implements Serializable{
    private String[] data;
    private int length = 0;
    
    MyContainer(){
        data = new String[0];
    }
    
    @Override
    public String toString(){
        if(data==null){
            return "Container is empty";
        }
        StringBuilder result = new StringBuilder();
        String [] temp = new String[length];
        System.arraycopy(data, 0, temp, 0, length);
        result.append("[");
        for(String a : temp){
            result.append(a);
            if(a != temp[length-1])
            result.append(", ");
        }
        result.append("]");
        return result.toString();
    }
    
    void add(String string){
        String[] temp = data;
        data = new String[++length];
        System.arraycopy(temp, 0, data, 0, length-1);
        data[length-1] = string;
    }
    
    void clear(){
        data = null;
        length = 0;
    }
    
    boolean remove(String string){
       // int L = data.length;
        String[] temp = data;
        for(int i = 0; i<data.length; i++){
         if (string.equals(data[i])){
            length--;
            
                 System.arraycopy(temp, i+1, data, i, length - i);
             
             
             data[length] = null;
             return true;
          }
         }
        return false;
    }
    
    void sort(){
        String temp;
        char min;
        for (int i = 0; i<length; i++){
            min = data[i].charAt(0);
            for (int j = i+1; j < length; j++)
                if (data[j].charAt(0) > min){
                    temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                }
        }
        for (int i = 0, j = length-1; ;i++, j--){
            if (i>= j ) break;
            temp  = data[i];
            data[i] = data[j];
            data[j] = temp;
        }
    }
    String[] toArray(){
        String [] temp = new String[length];
        System.arraycopy(data, 0, temp, 0, length);
        return temp;
    }
    
    int size(){
        if (data==null) return 0;
        return length;
    }
    
    boolean contains(String string){
        for (String data1 : data) {
            if (string.equals(data1)) {
                return true;
            }
        }
        return false;
    }
    
    boolean containsAll(MyContainer container){
        boolean result = false;
        for(int visit = 0; visit < container.size(); visit++){
            for(String our : data){
                if (container.toArray()[visit].equals(our)){
                    result = true;
                    break;
                } 
            }
            if(!result)
                return false;
            result = false;
        }
        return true;
    }
    
     public Iterator<String> iterator(){
         return new MyIterator(data, length);
     }
     
     public boolean serialization(){
         FileOutputStream outputStream;
        try {
            outputStream = new FileOutputStream("D:\\NetBeans 8.0.2\\data.txt");
        } catch (FileNotFoundException ex) {
            System.out.println("Something wrong....");
            return false;
        } 
        try {
             try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {
                 objectOutputStream.writeObject(data);
                 System.out.println("Success serialization");
             }
                outputStream.close();
                return true;
            } catch (IOException ex) {
                System.out.println("Sorry, but....");
                return false;
            }
        

     }
     
     public boolean deserialization(){
         FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream("D:\\NetBeans 8.0.2\\data.txt");
        } catch (FileNotFoundException ex) {
            System.out.println("Something wrong....");
            return false;
        }
        try{
       ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
       data = (String[]) objectInputStream.readObject();
       length = data.length;
        System.out.println("Success deserialization");
       return true;
        } catch (IOException ex) {
            System.out.println("Sorry, but....");
                return false;
        } catch (ClassNotFoundException ex) {
            System.out.println("Wrong input data....");
            return false;
        }   
     }
     
     public void editor(int debug){
         StringBuilder Lstr;
         int k;
         for(int j = 0;j<length;j++){
         Lstr = new StringBuilder(data[j]);
         k = Lstr.length();
         for(int i = 0; i<k; i++){
             if (debug == 1) System.out.println("Проміжковий результат: "+Lstr);
		if ((Lstr.charAt(i) == ',' &&  Lstr.charAt(i+1) == ',') 
				|| (Lstr.charAt(i) == ',' &&  Lstr.charAt(i-1) == ','))
			{
				Lstr.deleteCharAt(i--);
				k--;
			}
		
		if (!Character.isAlphabetic(Lstr.charAt(i)) && Lstr.charAt(i)!=' ' && Lstr.charAt(i)!=',')
			{
			Lstr.deleteCharAt(i);
			i--;
			k--;
			continue;
			}
		if(Character.isAlphabetic(Lstr.charAt(i))) continue; 
		else
			if ((Lstr.charAt(i)==',' ) && Character.isAlphabetic(Lstr.charAt(i+1))) 
				{
				Lstr.insert(++i, ' ');
				k++;
				}
					if (Lstr.charAt(i)==' ' && Lstr.charAt(i+1)==' ') 
						{
						Lstr.deleteCharAt(i--);
						k--;
						}
		}
         data[j] = Lstr.toString();
     }
     }
    
}
