/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hirnyk;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Администратор
 */
public class Matcher1 {
    public static boolean Data(String x){
    Pattern p = Pattern.compile("^(0[1-9]|[1-2][0-9]|3[0-1])\\.(0[1-9]|1[0-2])\\.(1[0-9][0-9][0-9]|20[0-3][0-9])$");
    Matcher m = p.matcher(x);
    return m.matches();
    }
    public static boolean Name(String x){
    Pattern p = Pattern.compile("^[A-Z][a-z]+\\s[A-Z][a-z]+\\s[A-Z][a-z]+$");
    Matcher m = p.matcher(x);
    return m.matches();
    }
}
