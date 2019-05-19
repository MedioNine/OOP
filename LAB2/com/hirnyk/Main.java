/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hirnyk;
import java.util.Scanner;
/**
 *
 * @author Администратор
 */
public class Main {
   public static void main(String[] args) {
	int debug = 0;
       	if(args[0].equals("-d") || (args.length>1 && args[1].equals("-d"))){
	debug = 1;
	System.out.println("Режим debug активний!");
	}
		if (args[0].equals("-h") || (args.length>1 && args[1].equals("-h"))) 
		System.out.println("Режим help активний!\n"
				+ "Гірник Юрій, КН-108 \n\n"
				+ "Умова:\n"
				+ "Ввести текст. З тексту видалити всі символи, \n"
				+ "крім пропусків, які не є буквами. Пропуски, що повторюються,\n"
				+ "замінити на одиночні. Між послідовностями літер,\n"
				+ "де знаходяться розділові знаки, залишити хоча б один пропуск (“a,b,c” -> “a, b, c”).\n"
				+ "Вивести початковий текст та результат.\n\n"
				+ "Пункти меню:\n"
				+ "Для додавання нового рядка для редактування введіть \"a\" \n"
				+ "Для виводу вмісту контейнера введіть \"p\" \n"
				+ "Для виконання редактування введіть \"d\" \n"
				+ "Для виходу введіть будь-яку іншу букву чи цифру\n\n"
				+ "Можливі режими роботи: debug та help");
		Scanner write = new Scanner(System.in);
		String k,str = new String();
                MyContainer text = new MyContainer(); 
		for(System.out.print("Наступна команда: "),k = write.nextLine();;System.out.print("Наступна команда: "),k = write.nextLine())
			{
				switch(k.charAt(0)){
					case 'a': { 
						System.out.print("Новий рядок: "); 
						str = write.nextLine(); 
						text.add(str); 
						break;
						}	
					case 'p': 
						System.out.println("Введені/відредаговані рядки: " + text.toString()); 
						break;
					case 'd': {
						text.editor(debug); 
						System.out.println("Редактування успішно виконано!"); 
						break;
							}
					case 'r': {
						System.out.println("Результат:");
						System.out.println(text.toString()); 
						break;
						}
					default: {
						System.out.println("Вихід!"); 
						return;
						}
				}
			}
	}	

}