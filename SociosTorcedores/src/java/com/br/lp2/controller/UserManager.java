/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.controller;

import com.br.lp2.model.Usuario;
import com.br.lp2.model.dao.UsuarioDAO;

/**
 *
 * @author Everson
 */
public class UserManager {
    
    public static boolean authorize(String username, String password){
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = dao.readByUsername(username);

        return !(usuario.getId_usuario() == -1 || !usuario.getSenha().equals(password));
    }
    
}
