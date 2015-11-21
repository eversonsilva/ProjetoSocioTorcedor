/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.model.dao;

import com.br.lp2.model.DateUtil;
import com.br.lp2.model.Ingresso;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Everson
 */
public class IngressoDAO implements GenericDAO<Ingresso>{
        
        private Connection con;
    
    //==================================INSERIR NA TABELA================================================

    @Override
    public boolean insert(Ingresso ingresso) {
        
        boolean resposta = false;
        
        con = ConnectionFactory.getConnection();
        
        String sql = "INSERT INTO ingresso(numeroIngresso, valorIngresso, dia, nomeCampeonato) VALUES (?,?,?,?)";
        
        try{
               
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, ingresso.getNumeroIngresso());
        ps.setDouble(2, ingresso.getValorIngresso());
        ps.setTimestamp(3, new java.sql.Timestamp(ingresso.getData().getTime()));
        ps.setString(4, ingresso.getNomeCampeonato());       
        
        int resp = ps.executeUpdate();
        
        if(resp > 0){
            resposta = true;
        }        
        
        ps.close();
        con.close();
        
        }catch(SQLException ex){
            Logger.getLogger(IngressoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resposta;
        
    }

    @Override
    public List<Ingresso> read() {

    List<Ingresso> ingressos = new ArrayList<>();
        
        con = ConnectionFactory.getConnection();
        
        String sql = "SELECT * FROM ingresso";
        
        try{
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("id_ingresso");
                int numeroIngresso = rs.getInt("numeroIngresso");
                double valorIngresso = rs.getDouble("valorIngresso");
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(rs.getTimestamp("dia").getTime());
                java.util.Date data = calendar.getTime();
                String nomeCampeonato = rs.getString("nomeCampeonato");
                Ingresso i = new Ingresso(id, numeroIngresso, valorIngresso, data, nomeCampeonato);
                ingressos.add(i);
            }
            
            ps.close();
            rs.close();
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(IngressoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return ingressos;

    }

    @Override
    public boolean update(Ingresso ingresso) {
        
        boolean resposta = false;
        
        con = ConnectionFactory.getConnection();
        
        String sql = "UPDATE ingresso SET numeroIngresso = ?, valorIngresso = ?, dia = ?, nomeCampeonato = ? WHERE id_ingresso = ?";
        
        try{
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ingresso.getNumeroIngresso());
            ps.setDouble(2, ingresso.getValorIngresso());
            ps.setDate(3, new java.sql.Date(ingresso.getData().getTime()));
            ps.setString(4, ingresso.getNomeCampeonato());
            ps.setInt(5, ingresso.getId_ingresso());
            
           int resp = ps.executeUpdate();
           
           if(resp > 0){
               resposta = true;
           }
           
           ps.close();
           con.close();
           
        }catch (SQLException ex) {
            Logger.getLogger(IngressoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resposta;

        
    }

    @Override
    public boolean delete(Ingresso ingresso) {
    
    boolean resposta = false;
        
        con = ConnectionFactory.getConnection();
        
        String sql = "DELETE FROM ingresso WHERE id_ingresso = ?";
        
        try{
        
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ingresso.getId_ingresso());
            
            int resp = ps.executeUpdate();
            
            if(resp > 0){
                resposta = true;
            }
            
            ps.close();
            con.close();
            
        }catch(SQLException ex){
            Logger.getLogger(IngressoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resposta;


    }
    
}
