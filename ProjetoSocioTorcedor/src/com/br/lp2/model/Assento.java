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
public class Assento implements Serializable{
    
    private int id_assento, numeroAssento;
    private String setorAssento;
    
    //---------------------CONSTRUTORES---------------------------------------
    
    public Assento() {
        this.id_assento = -1; 
        this.numeroAssento = 0;
        this.setorAssento = null;
        
    }
    
    public Assento(int numeroAssento, String setorAssento) {
        this.id_assento = -1;
        this.numeroAssento = numeroAssento;
        this.setorAssento = setorAssento;
    }

    public Assento(int id_assento, int numeroAssento, String setorAssento) {
        this.id_assento = id_assento;
        this.numeroAssento = numeroAssento;
        this.setorAssento = setorAssento;
    }
    
    //---------------------GETTERS E SETTERS----------------------------------
    
    public int getId_assento() {
        return id_assento;
    }

    public void setId_assento(int id_assento) {
        this.id_assento = id_assento;
    }

    public int getNumeroAssento() {
        return numeroAssento;
    }

    public void setNumeroAssento(int numeroAssento) {
        this.numeroAssento = numeroAssento;
    }

    public String getSetorAssento() {
        return setorAssento;
    }

    public void setSetorAssento(String setorAssento) {
        this.setorAssento = setorAssento;
    }

    //---------------------TO STRING------------------------------------------

    @Override
    public String toString() {
        return "Assento{" + "id_assento=" + id_assento + ", numeroAssento=" + numeroAssento + ", setorAssento=" + setorAssento + '}';
    }
    
    

    

    

    
    
}
