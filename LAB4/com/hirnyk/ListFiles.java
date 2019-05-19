/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hirnyk;

 
/**
 *
 * @author Администратор
 */

 
import java.io.File;
import java.util.*;

public class ListFiles {
    
    public String search(String format) {
       Scanner write = new Scanner(System.in);
       String  j = "D:";
       System.out.println("\nДля переходу на іншу папку просто введіть назву папки,\n"+
               "Для повернення назад введіть 'back' та після цього ведіть назву папки для спуску,\n"+
               "Для вибору потрібного вам файла, введіть його назву з розширенням "+ format);
       System.out.println("Поточне розташування: "+j);
       File start = new File (j);
       list(start); 
       String command;
        while(true){
            System.out.println("Наступна команда: ");
            System.out.println("(поточне розташування: "+j+")");
            command = write.nextLine();
            if (command.equals("back")){
                    if(j.equals("D:")){
                            System.out.println("Далі нікуди спускатись!");
                            continue;
                    }
                    System.out.println("(поточне розташування: "+j+")");
                    System.out.println("Виберіть одну попередніх папок: ");
                    command = write.nextLine();
                    if(command.equals("D:") || command.equals("d:")|| command.equals("d") || command.equals("D")){
                        j = "D:";
                        File actual = new File (j);
                        list(actual);   
                        continue;
                    }

                    if (j.lastIndexOf(command)==-1 || Character.isAlphabetic(j.charAt(j.indexOf(command)-1)) || Character.isAlphabetic(j.charAt(j.indexOf(command)+command.length()))){
                        System.out.println("Такої папки не існує! Спробуйте ще раз!");
                        continue;
                    }
                    int last = j.lastIndexOf(command)+ command.length();
                    j = j.substring(0, last);
                    File actual = new File (j);
                   System.out.println("(поточне розташування: "+j+")");
                    list(actual); 
                }
            else{
                    try {
                        j +="\\" + command;     
                        File temp = new File (j);
                        System.out.println(j);
                        if (j.contains(format))
                            return j;
                        list(temp);
                    }
                catch(NullPointerException ex){
                        System.out.println("Такої папки/файлу не існує! Спробуйте ще раз!"); 
                        j = j.substring(0, j.length()-command.length()-1);
                        continue;
                    }   
            }
        }
    }
 
    void list(File file) {
        for (File f : file.listFiles()) {
                System.out.println(f.getAbsolutePath());     
        }
    }
}