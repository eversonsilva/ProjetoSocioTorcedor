/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.model;

import java.io.Serializable;

/**
 *
 * @author Everson
 */
public class Jogo implements Serializable {
    
    private int id_jogo;
    private String time1;
    private String time2;
    private int id_estadio;
    
    //-----------------------------------CONSTRUTORES---------------------------------------------
    
    public Jogo() {
        this.id_jogo = -1;
        this.time1 = "anonimo";
        this.time2 = "anonimo";
        this.id_estadio = -1;
    }

    public Jogo(String time1, String time2, int id_estadio) {
        this.id_jogo = -1;
        this.time1 = time1;
        this.time2 = time2;
        this.id_estadio = id_estadio;
    }

    public Jogo(int id_jogo, String time1, String time2, int id_estadio) {
        this.id_jogo = id_jogo;
        this.time1 = time1;
        this.time2 = time2;
        this.id_estadio = id_estadio;
    }
    
    //----------------------------------GETTER E SETTER----------------------------------------------
    
    public int getId_jogo() {
        return id_jogo;
    }

    public void setId_jogo(int id_jogo) {
        this.id_jogo = id_jogo;
    }

    public String getTime1() {
        return time1;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }

    public String getTime2() {
        return time2;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }

    public int getId_Estadio() {
        return id_estadio;
    }

    public void setId_Estadio(int id_estadio) {
        this.id_estadio = id_estadio;
    }
    
    //----------------------------------TOSTRING----------------------------------------------

    @Override
    public String toString() {
        return "Jogo{" + "id_jogo=" + id_jogo + ", time1=" + time1 + ", time2=" + time2 + ", id_estadio=" + id_estadio + '}';
    }

}
