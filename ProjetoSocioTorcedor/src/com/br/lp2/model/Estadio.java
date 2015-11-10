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
public class Estadio implements Serializable{
    
    private String localizacao, nomeEstadio;
    private int capacidadeEstadio, id_estadio;
    
    //-----------------------------------CONSTRUTORES------------------------------------------------
    
    public Estadio() {
        this.id_estadio = -1;
        this.localizacao = "anonimo";
        this.nomeEstadio = "anonimo";
        this.capacidadeEstadio = 0;
    }

    public Estadio(String localizacao, String nomeEstadio, int capacidadeEstadio) {    
        this.id_estadio = -1;
        this.localizacao = localizacao;
        this.nomeEstadio = nomeEstadio;
        this.capacidadeEstadio = capacidadeEstadio;
    }

    public Estadio(int id_estadio, String localizacao, String nomeEstadio, int capacidadeEstadio) {    
        this.id_estadio = id_estadio;
        this.localizacao = localizacao;
        this.nomeEstadio = nomeEstadio;
        this.capacidadeEstadio = capacidadeEstadio;
    }
    
    //-----------------------------------GETTER E SETTER---------------------------------------------
    
    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getNomeEstadio() {
        return nomeEstadio;
    }

    public void setNomeEstadio(String nomeEstadio) {
        this.nomeEstadio = nomeEstadio;
    }

    public int getCapacidadeEstadio() {
        return capacidadeEstadio;
    }

    public void setCapacidadeEstadio(int capacidadeEstadio) {
        this.capacidadeEstadio = capacidadeEstadio;
    }

    public int getId_estadio() {
        return id_estadio;
    }

    public void setId_estadio(int id_estadio) {
        this.id_estadio = id_estadio;
    }

    //--------------------------------------TOSTRING-------------------------------------------------

    @Override
    public String toString() {
        return "Estadio{" + "localizacao=" + localizacao + ", nomeEstadio=" + nomeEstadio + ", capacidadeEstadio=" + capacidadeEstadio + ", id_estadio=" + id_estadio + '}';
    }
  
}
