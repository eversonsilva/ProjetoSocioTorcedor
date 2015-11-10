/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.model.dao;

import com.br.lp2.model.Estadio;
import com.br.lp2.model.Jogo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Everson
 */
public class JogoDAO implements GenericDAO<Jogo>{
    
        private Connection con;
    
    //==================================INSERIR NA TABELA================================================

    @Override
    public boolean insert(Jogo jogo) throws ArrayIndexOutOfBoundsException{
        
        boolean resposta = false;
        
        con = ConnectionFactory.getConnection();
        
        String sql = "INSERT INTO jogo(time1, time2, id_estadio) VALUES (?,?,?)";
        
        try{
            
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, jogo.getTime1());
        ps.setString(2, jogo.getTime2());
        ps.setInt(3, jogo.getId_Estadio());
        
        int resp = ps.executeUpdate();
        
        if(resp > 0){
            resposta = true;
        }        
        
        ps.close();
        con.close();
        
        }catch(SQLException | ArrayIndexOutOfBoundsException ex){
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resposta;
        
    }

    @Override
    public List<Jogo> read() {

    List<Jogo> jogos = new ArrayList<>();
        
        con = ConnectionFactory.getConnection();
        
        String sql = "SELECT * FROM jogo";
        
        try{
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("id_jogo");
                String time1 = rs.getString("time1");
                String time2 = rs.getString("time2");
                int id_estadio = rs.getInt("id_estadio");
                Jogo j = new Jogo(id, time1, time2, id_estadio);
                jogos.add(j);
            }
            
            ps.close();
            rs.close();
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return jogos;

    }

    @Override
    public boolean update(Jogo jogo) {
        
        boolean resposta = false;
        
        con = ConnectionFactory.getConnection();
        
        String sql = "UPDATE jogo SET time1 = ?, time2 = ?, id_estadio = ? WHERE id_jogo = ?";
        
        try{
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, jogo.getTime1());
            ps.setString(2, jogo.getTime2());
            ps.setInt(3, jogo.getId_Estadio());
            ps.setInt(4, jogo.getId_jogo());
            
           int resp = ps.executeUpdate();
           
           if(resp > 0){
               resposta = true;
           }
           
           ps.close();
           con.close();
           
        }catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resposta;

        
    }

    @Override
    public boolean delete(Jogo jogo) {

    boolean resposta = false;
        
        con = ConnectionFactory.getConnection();
        
        String sql = "DELETE FROM jogo WHERE id_jogo = ?";
        
        try{
        
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, jogo.getId_jogo());
            
            int resp = ps.executeUpdate();
            
            if(resp > 0){
                resposta = true;
            }
            
            ps.close();
            con.close();
            
        }catch(SQLException ex){
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resposta;

    }
    
}
