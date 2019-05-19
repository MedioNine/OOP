/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hirnyk;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Администратор
 */
public class Bandit {
    private String PIB;
    private String Birth_day;
    private ArrayList <String> Murders = new ArrayList<>();;
    private String last_badjob;
    private String last_chanse;
    
    Scanner write = new Scanner(System.in);
    
    
    public void setPIB(String string){
       if(Matcher1.Name(string))
        PIB = string; 
       else
       {
           while(Matcher1.Name(string)==false)
           {
               System.out.print("Неправильне введення даних!\n "
                       + "(Введіть ім'я, прізвище та по-батькові з великої букви, всі інші літери з малої)\n"
               +"Спробуйте: ");
                string = write.nextLine();
           }
           PIB = string;
       }
    }
    public void setBirth_day(String string){  
        if(Matcher1.Data(string))
         Birth_day = string; 
       else
       {
           while(Matcher1.Data(string)==false)
           {
               System.out.print("Неправильне введення даних!\n "
                       + "(Введіть корректну дату - ДД.ММ.РРРР)\n"
               +"Спробуйте: ");
                string = write.nextLine();
           }
           Birth_day = string;
       }  
    }
    public void setMurders(String string){  
        if(Matcher1.Data(string))
         Murders.add(string); 
       else
       {
           while(Matcher1.Data(string)==false)
           {
               System.out.print("Неправильне введення даних!\n "
                       + "(Введіть корректну дату - ДД.ММ.РРРР)\n"
               +"Спробуйте: ");
                string = write.nextLine();
           }
           Murders.add(string);
       }   
    }
    public void setLast_badjob(String string){    
       if(Matcher1.Data(string))
         last_badjob = string; 
       else
       {
           while(Matcher1.Data(string)==false)
           {
               System.out.print("Неправильне введення даних!\n "
                       + "(Введіть корректну дату - ДД.ММ.РРРР)\n"
               +"Спробуйте: ");
                string = write.nextLine();
           }
           last_badjob = string;
       }  
    }
    public void setLast_chanse(String string){   
       if(Matcher1.Data(string))
         last_chanse = string; 
       else
       {
           while(Matcher1.Data(string)==false)
           {
               System.out.print("Неправильне введення даних!\n "
                       + "(Введіть корректну дату - ДД.ММ.РРРР)\n"
               +"Спробуйте: ");
                string = write.nextLine();
           }
           last_chanse = string;
       }
    }
    public String getPIB(){  return PIB;  }
    public String getBirth_day(){  return Birth_day;  }
    public String getMurders(){  return Murders.toString();  }
    public String getLast_badjob(){  return last_badjob;  }
    public String getLast_chanse(){  return last_chanse;  }

    private void If(boolean Name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
