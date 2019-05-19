/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hirnyk;
import java.util.*;
/**
 *
 * @author Администратор
 */
public class Tester {
    public static void main(String [] args){
       MyContainer testcont = new MyContainer(), test = new MyContainer();
       Scanner write = new Scanner(System.in);
       System.out.println("Виконаємо десеріалізацію даних з файлу: ");
       // попередньо збережених у файл
       testcont.deserialization();
       System.out.println("\nПеревіримо вміст контейнера 1: "+ testcont.toString());
       System.out.println("\nСтворимо і додамо в інший контейнер наступне:\nДоброго дня \nПане\nЯ із Оріфлейм\n");
       test.add("Доброго дня");
       test.add("Пане");
       test.add("А Як у Вас справи?");
       System.out.println("Перевіримо вміст контейнера 2: "+test.toString());
       test.sort();
       System.out.println("\nВиконаємо сортування вмісту контейнера 2.");
       System.out.println("\nПеревіримо вміст контейнера 2: "+test.toString());
       System.out.println("\nПеревіримо розмір першого і другого контейнеру: " +"\nРозмір першого: " + testcont.size()+"\nРозмір другого: "+ test.size());
       System.out.println("\nПеревіримо чи контейнери однакові: "+ test.containsAll(testcont));
       System.out.println("\nПеревіримо на наявність рядка \"Пане\" в контейнері 2: "+test.contains("Пане"));
       System.out.println("\nА як щодо \"Рікардо\" в контейнері 2: "+ test.contains("Рікардо"));
       System.out.println("\nВидалимо рядок \"Доброго дня\" з другого контейнера");
       test.remove("Доброго дня");
       System.out.println("\nВміст контейнера 2: "+ test.toString());
       System.out.println("\n  While: ");
       MyIterator i = (MyIterator)test.iterator();
       while(i.hasNext()){
           System.out.println(i.next());
       }
       System.out.println("\n  Foreach: ");
       for(String a: test.toArray()){
           System.out.println(a);
       }
      System.out.println("Виконаємо серіалізацію даних: ");
      test.serialization();
       System.out.println("Success");
       
    }
}
