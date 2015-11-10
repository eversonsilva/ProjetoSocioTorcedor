/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 41487532
 */
public class DateUtil {

    private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private static SimpleDateFormat formatterD = new SimpleDateFormat("dd/MM/yyyy");
    private static SimpleDateFormat formatterH = new SimpleDateFormat("HH:mm:ss");

    public static String date2string(Date date) {
        return formatter.format(date);
    }

    public static String time2string(Date date) {
        return formatterH.format(date);
    }

    public static Date string2date(String str) {
        Date date = null;

        try {
            date = formatter.parse(str);
        } catch (ParseException ex) {
            Logger.getLogger(DateUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        return date;
    }
    
    public static Date string2time(String str) {
        Date date = null;

        try {
            date = formatterH.parse(str);
        } catch (ParseException ex) {
            Logger.getLogger(DateUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        return date;
    }

    /*
    public static void main(String[] args) {
    Date date = new Date();
    String str = DateUtil.date2string(date);
    System.out.println("DATA PARA TEXTO:\n " +str);
     
    System.out.println("\n=========================================\n");
         
    Date date2 = DateUtil.string2date("01/05/1999 15:44:04");
    System.out.println("TEXTO PARA DATA:\n" +date2 );
    
    Calendar cal = Calendar.getInstance();
    cal.set(Calendar.DAY_OF_MONTH, 19);
    cal.set(Calendar.MONTH, 0);// Janeiro = 0, Fevereiro = 1, Março = 2, Abril = 3, ....
    cal.set(Calendar.YEAR, 1996);
    cal.set(Calendar.HOUR_OF_DAY, 15);
    cal.set(Calendar.MINUTE, 45);
    cal.set(Calendar.SECOND, 16);
    
    System.out.println("\n=========================================\n");
    
    String str2 = DateUtil.date2string(cal.getTime());
    System.out.println("CALENDÁRIO:\n" +str2);
    //Date date3 = cal.getTime();
    
    //COMO ENVIAR PARA O BANCO DE DADOS
    //java.sql.Date dateSQl = new java.sql.Date(date3.getTime());
    
    }*/
     
}
