/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hirnyk;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Администратор
 */
public class Bandit implements Serializable{
    private String PIB;
    private String Birth_day;
    private ArrayList <String> Murders = new ArrayList<>();;
    private String last_badjob;
    private String last_chanse;

    public void setPIB(String string){  PIB = string;  }
    public void setBirth_day(String string){  Birth_day = string;  }
    public void setMurders(String string){  Murders.add(string);  }
    public void setLast_badjob(String string){  last_badjob = string;  }
    public void setLast_chanse(String string){  last_chanse = string;  }
    public String getPIB(){  return PIB;  }
    public String getBirth_day(){  return Birth_day;  }
    public String getMurders(){  return Murders.toString();  }
    public String getLast_badjob(){  return last_badjob;  }
    public String getLast_chanse(){  return last_chanse;  }
    
}