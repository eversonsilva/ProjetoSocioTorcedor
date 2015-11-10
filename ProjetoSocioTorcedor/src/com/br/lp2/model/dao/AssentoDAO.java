/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.model.dao;

import com.br.lp2.model.Assento;
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
public class AssentoDAO implements GenericDAO<Assento> {

    private Connection con;

    //==================================INSERIR NA TABELA================================================
    @Override
    public boolean insert(Assento assento) {

        boolean resposta = false;

        con = ConnectionFactory.getConnection();

        String sql = "INSERT INTO assento(numeroAssento, setorAssento) VALUES (?,?)";

        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, assento.getNumeroAssento());
            ps.setString(2, assento.getSetorAssento());

            int resp = ps.executeUpdate();

            if (resp > 0) {
                resposta = true;
            }

            ps.close();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resposta;

    }

    @Override
    public List<Assento> read() {

        List<Assento> assentos = new ArrayList<>();

        con = ConnectionFactory.getConnection();

        String sql = "SELECT * FROM assento";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_assento");
                int numeroAssento = rs.getInt("numeroAssento");
                String setorAssento = rs.getString("setorAssento");
                Assento a = new Assento(id, numeroAssento, setorAssento);
                assentos.add(a);
            }

            ps.close();
            rs.close();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return assentos;

    }

    @Override
    public boolean update(Assento assento) {

        boolean resposta = false;

        con = ConnectionFactory.getConnection();

        String sql = "UPDATE assento SET numeroAssento = ?, setorAssento = ? WHERE id_assento = ?";
        

        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, assento.getNumeroAssento());
            ps.setString(2, assento.getSetorAssento());
            ps.setInt(3, assento.getId_assento());

            int resp = ps.executeUpdate();

            if (resp > 0) {
                resposta = true;
            }

            ps.close();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resposta;

    }

    @Override
    public boolean delete(Assento assento) {

        boolean resposta = false;

        con = ConnectionFactory.getConnection();

        String sql = "DELETE FROM assento WHERE id_assento = ?";

        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, assento.getId_assento());

            int resp = ps.executeUpdate();

            if (resp > 0) {
                resposta = true;
            }

            ps.close();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resposta;
    }

}
