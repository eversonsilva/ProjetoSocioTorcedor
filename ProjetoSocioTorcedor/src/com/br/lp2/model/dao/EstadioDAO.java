/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.model.dao;

import com.br.lp2.model.Estadio;
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
public class EstadioDAO implements GenericDAO<Estadio>{
    
        private Connection con;
    
    //==================================INSERIR NA TABELA================================================

    @Override
    public boolean insert(Estadio estadio) {
        
        boolean resposta = false;
        
        con = ConnectionFactory.getConnection();
        
        String sql = "INSERT INTO estadio(localizacao, nomeEstadio, capacidadeEstadio) VALUES (?,?,?)";
        
        try{
            
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, estadio.getLocalizacao());
        ps.setString(2, estadio.getNomeEstadio());
        ps.setInt(3, estadio.getCapacidadeEstadio());
        
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

    @Override
    public List<Estadio> read() {

    List<Estadio> estadios = new ArrayList<>();
        
        con = ConnectionFactory.getConnection();
        
        String sql = "SELECT * FROM estadio";
        
        try{
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("id_estadio");
                String localizacao = rs.getString("localizacao");
                String nomeEstadio = rs.getString("nomeEstadio");
                int capacidadeEstadio = rs.getInt("capacidadeEstadio");
                Estadio e = new Estadio(id, localizacao, nomeEstadio, capacidadeEstadio);
                estadios.add(e);
            }
            
            ps.close();
            rs.close();
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return estadios;

    }

    @Override
    public boolean update(Estadio estadio) {
        
        boolean resposta = false;
        
        con = ConnectionFactory.getConnection();
        
        String sql = "UPDATE estadio SET localizacao = ?, nomeEstadio = ?, capacidadeEstadio = ? WHERE id_estadio = ?";
        
        try{
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, estadio.getLocalizacao());
            ps.setString(2, estadio.getNomeEstadio());
            ps.setInt(3, estadio.getCapacidadeEstadio());
            ps.setInt(4, estadio.getId_estadio());
            
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
    public boolean delete(Estadio estadio) {

    boolean resposta = false;
        
        con = ConnectionFactory.getConnection();
        
        String sql = "DELETE FROM estadio WHERE id_estadio = ?";
        
        try{
        
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, estadio.getId_estadio());
            
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
