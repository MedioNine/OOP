package com.hirnyk.lab8;


import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Администратор
 */
public class Main  extends Thread {
    
    public static void main(String[] args) throws InterruptedException{
       
        TimeLimit timelimit = new TimeLimit();
        Random random = new Random();
        Scanner write = new Scanner(System.in);
        System.out.print("Необіхдна кількість автоматично згенерованих чисел: ");
        int length = write.nextInt();
        long array[] = new long[length];
        for(int i = 0; i < length; i++){
            array[i] = random.nextInt(100);
        }
        System.out.print("Час затримки(мс): ");
        long sleep = write.nextLong();
        System.out.print("Таймаут(с): ");
        double timeout = write.nextDouble();
        timelimit.rest = timeout * 1_000_000_000;
        //threads
        ThreadOne first;
        ThreadTwo second;
        ThreadThree third;

        long st, en;
        double elapsedTimeInSecond;

        System.out.print("Для виконання обрахунків за допомогою паралельних потоків введіть 1\n"
                + "Для виконання обрахунків за допомогою послідовних потоків введіть 2\n"
                + "Для зміни кількості чисел або часу затримки введіть 3\n"
                + "Для виходу натисніть будь-що інше.\n\n");
        while(true){
            System.out.print("\nНаступна команда - ");
            String comand = write.next();
            System.out.println();
                first = new ThreadOne(array, sleep, timeout);
                second = new ThreadTwo(array, sleep, timeout);
                third = new ThreadThree(array, sleep, timeout);

            switch(comand){
                case "1":
                    first.start();
                    second.start();
                    third.start();
                    first.join();
                    second.join();
                    third.join();
                    break;
                case "2":
                    st = System.nanoTime();   
                    timelimit = first.run(timelimit.rest);
                    if (timelimit.timeout) {
                        timelimit.timeout = false;
                        break;
                    }
                    timelimit = second.run(timelimit.rest);
                    if (timelimit.timeout){
                        timelimit.timeout = false;
                        break;
                    }
                    timelimit = third.run(timelimit.rest);
                    if (timelimit.timeout){
                        timelimit.timeout = false;
                        break;
                    }
                    en = System.nanoTime();
                    elapsedTimeInSecond = (double) (en - st) / 1_000_000_000;
                    System.out.println("Час виконання послідовно: " + elapsedTimeInSecond + " сек");
                    break;
                case "3":
                    System.out.print("Необіхдна кількість автоматично згенерованих чисел: ");
                    length = write.nextInt();
                    long array1[] = new long[length];
                    for(int i = 0; i < length; i++){
                        array1[i] = random.nextInt(100);
                    }
                    System.out.print("Час затримки(мс): ");
                        sleep = write.nextLong();
                    System.out.print("Таймаут(с): ");
                        timeout = write.nextInt();
                        timelimit.rest = timeout * 1_000_000_000;
                        timelimit.timeout = false;
                    break;
                default:
                {
                    System.out.println("Завершення виконання.....");
                    return;
                }
        }
    }
    
    
}

}
