package lab1;

import java.util.*;

public class mAin {

	public static void main(String[] args) {
	int debug = 0;
	if(args[0].equals("-d") || (args.length>1 && args[1].equals("-d")))
	{
	debug = 1;
	System.out.println("����� debug ��������!");
	}
		if (args[0].equals("-h") || (args.length>1 && args[1].equals("-h"))) 
		System.out.println("����� help ��������!\n"
				+ "ó���� ���, ��-108 \n\n"
				+ "�����:\n"
				+ "������ �����. � ������ �������� �� �������, \n"
				+ "��� ��������, �� �� � �������. ��������, �� ������������,\n"
				+ "������� �� �������. ̳� �������������� ����,\n"
				+ "�� ����������� ������� �����, �������� ���� � ���� ������� (�a,b,c� -> �a, b, c�).\n"
				+ "������� ���������� ����� �� ���������.\n\n"
				+ "������ ����:\n"
				+ "��� ����� ������ ����� ��� ������������ ������ \"n\" \n"
				+ "��� ������ ��������� ����� ������ \"p\" \n"
				+ "��� ��������� ������������ ������ \"d\" \n"
				+ "��� ����� ���������� ������ \"r\" \n"
				+ "��� ������ ������ ����-��� ���� ����� �� �����\n\n"
				+ "������ ������ ������: debug �� help");
		Scanner write = new Scanner(System.in);
		String k,str;
		System.out.println("������ ����� ��� ������������:");
		str = write.nextLine();
		edittext.setLstr(str);
		System.out.print("�������� �������: ");
		k = write.nextLine();
		for(;;System.out.print("�������� �������: "),k = write.nextLine())
			{
				switch(k.charAt(0)){
					case 'n': { 
						System.out.println("����� �����: "); 
						str = write.nextLine(); 
						edittext.setLstr(str); 
						break;
						}	
					case 'p': 
						System.out.println("�������� �����:\n" + str); 
						break;
					case 'd': {
						edittext.editor(debug); 
						System.out.println("������������ ������ ��������!"); 
						break;
							}
					case 'r': {
						System.out.println("���������:");
						edittext.print(); 
						break;
						}
					default: {
						System.out.println("�����!"); 
						return;
						}
				}
			}
	}	
}
