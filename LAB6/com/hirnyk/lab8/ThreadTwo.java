package com.hirnyk.lab8;


import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Администратор
 */
public class ThreadTwo extends Thread{
    private long array[];
    private long bigger;
    private long sleep;
    private double  timeout;
    private TimeLimit time = new TimeLimit();
    
    ThreadTwo(long array[], long sleep, double timeout){
        this.array = array;
        this.sleep = sleep;
        this.timeout = timeout * 1_000_000_000;
    }
   
    
    public void run(){
        boolean isTime = false;
        double en, st = System.nanoTime();
        System.out.println("Початок роботи потоку 2");
        bigger = array[0];
        for(int i = 1; i < array.length ;i++ ){
        if (bigger < array[i])  bigger = array[i];
        try {
                Thread.sleep(sleep);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadThree.class.getName()).log(Level.SEVERE, null, ex);
            }
        en = System.nanoTime();
        if(en - st > timeout) {
            isTime = true;
            break;
        }
        }
        if (isTime)
            System.out.println("\nПотік 2 - таймаут!\nЗУПИНКА!");
        else {
            en  = (double) (System.nanoTime() - st) / 1_000_000_000;
         System.out.println("Час виконання потоку 2 - " + en  + " сек" 
                 + "\nМаксимальний елемент: " + bigger);   
        }
    }    
    public TimeLimit run(double time){
        boolean isTime = false;
        timeout = time;
        double en, st = System.nanoTime();
        System.out.println("Початок роботи потоку 2");
        bigger = array[0];
        for(int i = 1; i < array.length ;i++ ){
        if (bigger < array[i])  bigger = array[i];
        try {
                Thread.sleep(sleep);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadThree.class.getName()).log(Level.SEVERE, null, ex);
            }
        en = System.nanoTime();
        if(en - st > timeout) {
            isTime = true;
            this.time.timeout = true;
            break;
        }
        }
        if (isTime)
            System.out.println("\nПотік 2 - таймаут!\nЗУПИНКА!");
        else {
            en  = (double) (System.nanoTime() - st) / 1_000_000_000;
            this.time.rest = time - en * 1_000_000_000;
            System.out.println("Час виконання потоку 2 - " + en  + " сек" 
                 + "\nМаксимальний елемент: " + bigger);   
        }
        return this.time;
    }
}
