package lab1;

import java.util.*;

public class mAin {

	public static void main(String[] args) {
	int debug = 0;
	if(args[0].equals("-d") || (args.length>1 && args[1].equals("-d")))
	{
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
				+ "Для вводу нового рядка для редактування введіть \"n\" \n"
				+ "Для виводу введеного рядка введіть \"p\" \n"
				+ "Для виконання редактування введіть \"d\" \n"
				+ "Для друку результату введіть \"r\" \n"
				+ "Для виходу введіть будь-яку іншу букву чи цифру\n\n"
				+ "Можливі режими роботи: debug та help");
		Scanner write = new Scanner(System.in);
		String k,str;
		System.out.println("Введіть рядок для редактування:");
		str = write.nextLine();
		edittext.setLstr(str);
		System.out.print("Наступна команда: ");
		k = write.nextLine();
		for(;;System.out.print("Наступна команда: "),k = write.nextLine())
			{
				switch(k.charAt(0)){
					case 'n': { 
						System.out.println("Новий рядок: "); 
						str = write.nextLine(); 
						edittext.setLstr(str); 
						break;
						}	
					case 'p': 
						System.out.println("Введений рядок:\n" + str); 
						break;
					case 'd': {
						edittext.editor(debug); 
						System.out.println("Редактування успішно виконано!"); 
						break;
							}
					case 'r': {
						System.out.println("Результат:");
						edittext.print(); 
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
