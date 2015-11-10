/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.model;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author 41487532
 */
public class ValorUtil {
  
    /*private static DecimalFormat df = new DecimalFormat("#.##");
    
    public static String double2String(double valor){
         
        String dx = df.format(valor); 
        
        return dx;
    }*/
    
    private static Locale lBrasil = new Locale ("pt", "BR");
    
    public static String formatarNumero(double valor, int casas) {
        NumberFormat formato = NumberFormat.getNumberInstance(lBrasil);
        formato.setMinimumFractionDigits(casas);
    return formato.format(valor);
}
    
}
