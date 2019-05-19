/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

public class Edittext {
	static StringBuilder Lstr;
	static int k;

	static void setLstr(String str){
		Lstr = new StringBuilder(str);
		k = Lstr.length();
	}
	
	static void print(){
		System.out.println(Lstr);
	}
	
	static	void  editor(int debug){
	for(int i = 0; i<k; i++){
		if (debug == 1) System.out.println("Проміжковий результат: "+Lstr);
		if ((Lstr.charAt(i) == ',' &&  Lstr.charAt(i+1) == ',') 
				|| (Lstr.charAt(i) == ',' &&  Lstr.charAt(i-1) == ','))
			{
				Lstr.deleteCharAt(i--);
				k--;
			};
		
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
				};
					if (Lstr.charAt(i)==' ' && Lstr.charAt(i+1)==' ') 
						{
						Lstr.deleteCharAt(i--);
						k--;
						};
		}	
	}
}
