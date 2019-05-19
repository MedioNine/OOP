/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hirnyk;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author Администратор
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner write = null;
        boolean auto = false;
        for(String i : args){
            if(i.equals("-auto")){
                write = new Scanner(new FileReader("D:\\auto.txt"));
                auto = true;
                break;
            }
       }
       if(auto == false)
       write = new Scanner(System.in);
       ListFiles choose = new ListFiles(); 
       MyList<Bandit> bandits = new MyList<>();
       println("Вас вітає Поліцейська картотека!");
       String command;
       while(true){
           print("\nФункції меню якими Ви можете користуватись\n"+
                   "1 - додати нового злочинця в картотеку\n"+
                   "2 - показати вже наявних злочинців\n"+
                   "3 - меню управління даними певним злочинцем\n"+
                   "4 - запис даних до XML файлу\n"+
                   "5 - зчитування даних з XML файлу\n"+
                   "6 - стандартна серіалізація даних\n"+
                   "7 - стандартна десеріалізація даних\n"+
                   "8 - видалення злочинця\n"+
                   "9 - очищення картотеки\n"+
                   "10 - перетворення в стрічку\n"+
                   "11 - перетворення в масив\n"+ 
                   "exit - вихід з картотеки.\n\nВведіть наступну команду: ");
           command = write.nextLine();
           String temp;
           switch(command){
               
               case "1":
                   println("Для додання нового злочинця потрібно ввести ім'я особи, дату народження, дати всіх судимостей,"+
                           "\nдату останнього позбавлення волі та дату останнього звільнення");
                   Bandit bandit = new Bandit();
                   print("\nВведіть ім'я злочинця: ");
                   temp = write.nextLine();
                   bandit.setPIB(temp);
                   print("\nВведіть дату народження: " );
                   temp = write.nextLine();
                   bandit.setBirth_day(temp);
                   println("\nВведіть дати всіх судимостей(використайте команду 'stop' після введення всіх дат): ");
                   String data;
                   while(true){
                    data = write.nextLine();
                    if (data.equals("stop")) break;
                    bandit.setMurders(data);
                   }
                   print("\nВведіть дату останнього позбавлення волі: ");
                   temp = write.nextLine();
                           
                   bandit.setLast_badjob(temp);
                   print("\nВведіть дату останнього звільнення: ");
                   temp = write.nextLine();
                   bandit.setLast_chanse(temp);
                   bandits.add(bandit);
                   println("\nПорядковий номер введеного злочинця - "+bandits.size());
                   break;
               
               
               case "2":
                   println("\nВміст картотеки: ");
                   if (bandits.isEmpty()){
                    println("Картотека пуста!");
                    break;
                   }
                   for(int i = 0; i < bandits.size(); i++){
                       println("\n"+(i+1)+". " + bandits.get(i).getPIB()+", д.н. "+bandits.get(i).getBirth_day()+
                               ", \nСудимості - "+bandits.get(i).getMurders()+", \nОстанняє позбавлення волі - "+
                               bandits.get(i).getLast_badjob()+ ", \nОстаннє звільнення - "+bandits.get(i).getLast_chanse());
                   }
                   println("Кінець переліку.");
                   break;
             
               
               case "3":
                   print("\nДля управління даними певного злочинця введіть його порядковий номер(1-"+bandits.size()
                           +"): ");
                   int numb;
                   while(true){
                   numb = write.nextInt();
                   if(numb<=0 || numb> bandits.size()){
                       print("\nТакого порядкового номера не існує! Спробуйте ще раз: ");
                       continue;
                   }
                   Bandit current = bandits.get(numb-1);
                   break;
                   }
                   String com;
                   repeat:
                   while(true){
                       println("\nФункції меню даних даного злочинця: \n"+
                               "1 - показ імені злочинця,\n"+
                               "2 - зміна імені злочинця,\n"+
                               "3 - показ дати народження,\n"+
                               "4 - зміна дати народження,\n"+
                               "5 - показ всіх судимостей,\n"+
                               "6 - додання нової судимості,\n"+
                               "7 - показ дати останнього позбавлення волі,\n"+
                               "8 - зміна дати останнього позбавлення волі,\n"+
                               "9 - показ дати останнього звільнення,\n"+
                               "10 - зміна дати останнього звільнення,\n"+
                               "exit - вихід з меню обробки даних злочинця.");
                       print("\nВведіть наступну команду: ");
                       com = write.nextLine();
                       String input;
                   switch(com){
                       
                       case"1":
                           println("\nІм'я злочинця: " + bandits.get(numb-1).getPIB());
                           continue;
                       
                       case"2":
                           print("\nОновлене ім'я злочинця: ");
                           input = write.nextLine();
                           bandits.get(numb-1).setPIB(input);
                           continue;
                       
                       case"3":
                           println("\nДата народження злочинця: " + bandits.get(numb-1).getBirth_day());
                           continue;
                       
                       case"4":
                           print("\nОновлена дата народження злочинця: ");
                           input = write.nextLine();
                           bandits.get(numb-1).setBirth_day(input);
                           continue;
                       
                       case"5":
                           println("\nВсі судимості: " + bandits.get(numb-1).getMurders());
                           continue;
                       
                       case"6":
                           println("Нова судимість злочинця: ");
                           input = write.nextLine();
                           bandits.get(numb-1).setMurders(input);
                           continue;
                       
                       case"7":
                           println("\nДата останнього ув'язення злочинця: " + bandits.get(numb-1).getLast_badjob());
                           continue;
                       
                       case"8":
                           print("Оновлене останнє ув'язнення злочинця: ");
                           input = write.nextLine();
                           bandits.get(numb-1).setLast_badjob(input);
                           continue;
                       
                       case"9":
                           println("\nДата останнього звільнення злочинця: " + bandits.get(numb-1).getLast_chanse());
                           continue;
                       
                       case"10":
                           print("Оновлене останнє звільнення злочинця: ");
                           input = write.nextLine();
                           bandits.get(numb-1).setLast_chanse(input);
                           continue;
                       
                       case"exit":
                           break;
                    
                       default:
                           println("Ви ввели неіснуючу команду, спробуйте ще раз!");
                           continue;
                    }
                   break;
                   }
                   break;
               
               
               case "4":
                   println("\nВиконуємо запис даних картотеки в XML файл. Виберіть файл: ");
                   ListFiles SearchDirectory = new ListFiles();
                   XMLEncoder encoder = new XMLEncoder(
                                                new BufferedOutputStream(
                                                        new FileOutputStream(SearchDirectory.search(".xml"))));
                  
                   encoder.writeObject(bandits.size());
                   for(Bandit i: bandits){
                       encoder.writeObject(i);
                   }
                   encoder.close();
                   println("\nПроцес пройшов успішно!");
                   break;
            
               
               case "5":
                   println("\nВиконуємо зчитування даних картотеки з XML файл. Виберіть файл: ");
                   ListFiles SearchDirectory1 = new ListFiles();
                   l:
                   try{
                   XMLDecoder decoder = new XMLDecoder(
                                            new BufferedInputStream(
                                                new FileInputStream(SearchDirectory1.search(".xml"))));
                   int size  = (int) decoder.readObject();
                   for(int i = 0; i< size; i++){
                       bandits.add((Bandit) decoder.readObject());
                   }
                   decoder.close();
                   println("\nПроцес пройшов успішно!");
                   break;
                   }
                   catch(FileNotFoundException ex){
                       System.out.println("Схоже, що такого файлу не існує. Спробуйте ще раз!");
                       continue;
                   }
               
               
               case "6":
                  
                   try {
                      FileOutputStream  outputStream = new FileOutputStream(choose.search(".txt"));
                      ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream); 
                      objectOutputStream.writeInt(bandits.size());
                          for(Bandit i : bandits){
                              objectOutputStream.writeObject(i);
                          }    
                      outputStream.close();
                      System.out.println("Success serialization");
                        break;

                   } catch (FileNotFoundException ex) {
                            System.out.println("Something wrong....");
                            break;
                        } 
                  catch (IOException ex) {
                             System.out.println("Sorry, but....");
                                break;
                        }
            
               
               case "7":
                  
                   FileInputStream fileInputStream;
                    try {
                        fileInputStream = new FileInputStream(choose.search(".txt"));
                    } catch (FileNotFoundException ex) {
                            System.out.println("Something wrong....");
                            break;
                        }
                    try{
                        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                        int size = (int)objectInputStream.readInt();
                        for(int i = 0; i < size; i++)
                        bandits.add((Bandit)objectInputStream.readObject());
                        System.out.println("Success deserialization");
                        break;
                    } catch (IOException ex) {
                    System.out.println("Sorry, but....");
                    break;
                    } catch (ClassNotFoundException ex) {
                    System.out.println("Wrong input data....");
                    break;
                    }   
                        
               case "8"://видалення
                   print("Введіть індекс злочинця для його видалення 1-"+bandits.size()+":  ");
                   int index = write.nextInt();
                   bandits.remove(index-1);
                   println("Успішне видалення!");
                   break;
               
               case "9"://очищення
                   bandits.clear();
                   println("Очищення картотеки. \n\nКартотека порожня!");
                   continue;
               
               
               case "10"://перетвореня в рядок
                   println("Перетворення в рядок: "+ bandits.toString()+"\n\n");
                   break;
               
               
               case "11"://перетворення в масив
                   println("Перетворення в масив: ");
                   Object[] arr = bandits.toArray();
                   int j = 1;
                   for(Object i: arr){
                       print("Array["+(j++)+"]");
                       println(i);
                   }
                   break;
               
               
               case "exit":
                   println("Завершення роботи!");
                   return;
               
               
               default:
                   println("Такої команди не існує. Спробуйте ще раз: ");
           }
       }
    }
    
    public static void print(Object x){
        System.out.print(x);
    }
    public static void println(Object x){
        System.out.println(x);
    }
}
