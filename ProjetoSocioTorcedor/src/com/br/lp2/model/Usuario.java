/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Everson
 */
public class Usuario implements Serializable {
    
    private int id_usuario, tipo;
    private String username, senha, plano, time, foto;
    private Date nascimento;
    
    //---------------------CONSTRUTORES----------------------------------

    public Usuario() {
        this.id_usuario = -1;
        this.username = "anonimo";
        this.senha = "123";
        this.plano = "bronze"; 
        this.time = "não definido";
        this.foto = "";
        this.nascimento = new Date();
        this.tipo = -1;
    }

    public Usuario(String username, String senha, String plano, String time, String foto, Date nascimento, Integer tipo) {
        this.id_usuario = -1;
        this.username = username;
        this.senha = senha;
        this.plano = plano;
        this.time = time;
        this.foto = foto;
        this.nascimento = nascimento;
        this.tipo = tipo;
    }

    public Usuario(int id_usuario, String username, String senha, String plano, String time, String foto, Date nascimento, Integer tipo) {
        this.id_usuario = id_usuario;
        this.username = username;
        this.senha = senha;
        this.plano = plano;
        this.time = time;
        this.foto = foto;
        this.nascimento = nascimento;
        this.tipo = tipo;
    }
    
    //-----------------------GETTER E SETTER---------------------

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
     public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }
    
    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    //-------------TOSTRING------------------------------

    @Override
    public String toString() {
        return "Usuario{" + "id_usuario=" + id_usuario + ", tipo=" + tipo + ", username=" + username + ", senha=" + senha + ", plano=" + plano + ", time=" + time + ", foto=" + foto + ", nascimento=" + nascimento + '}';
    }

    

}
