/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.model.dao;

import com.br.lp2.model.Usuario;
import java.sql.Connection;
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
public class UsuarioDAO implements GenericDAO<Usuario> {

    private Connection con;

    //==================================INSERIR NA TABELA================================================
    @Override
    public boolean insert(Usuario usuario) {

        boolean resposta = false;

        con = ConnectionFactory.getConnection();

        String sql = "INSERT INTO usuario(username, senha, plano, time, nascimento, tipo, foto) VALUES (?,?,?,?,?,?,?)";

        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getUsername());
            ps.setString(2, usuario.getSenha());
            ps.setString(3, usuario.getPlano());
            ps.setString(4, usuario.getTime());
            ps.setTimestamp(5, new java.sql.Timestamp(usuario.getNascimento().getTime()));
            ps.setInt(6, usuario.getTipo());
            ps.setString(7, usuario.getFoto());

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
    public List<Usuario> read() {

        List<Usuario> usuarios = new ArrayList<>();

        con = ConnectionFactory.getConnection();

        String sql = "SELECT * FROM usuario";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_usuario");
                String username = rs.getString("username");
                String senha = rs.getString("senha");
                String plano = rs.getString("plano");
                String time = rs.getString("time");
                String foto = rs.getString("foto");
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(rs.getTimestamp("nascimento").getTime());
                java.util.Date data = calendar.getTime();
                int tipo = rs.getInt("tipo");
                Usuario u = new Usuario(id, username, senha, plano, time, foto, data, tipo);
                usuarios.add(u);
            }

            ps.close();
            rs.close();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return usuarios;

    }

    @Override
    public boolean update(Usuario usuario) {

        boolean resposta = false;

        con = ConnectionFactory.getConnection();

        String sql = "UPDATE usuario SET  WHERE id_usuario = ?";

        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getUsername());
            ps.setString(2, usuario.getSenha());
            ps.setString(3, usuario.getPlano());
            ps.setString(4, usuario.getTime());
            ps.setString(5, usuario.getFoto());
            ps.setDate(6, new java.sql.Date(usuario.getNascimento().getTime()));
            ps.setInt(7, usuario.getTipo());

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
    public boolean delete(Usuario usuario) {

        boolean resposta = false;

        con = ConnectionFactory.getConnection();

        String sql = "DELETE FROM usuario WHERE id_usuario = ?";

        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, usuario.getId_usuario());

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

    public Usuario readByUsername(String username) {
        Usuario usuario = new Usuario();
        //2. Criar o preparedStatement
        String sql = "SELECT * FROM usuario WHERE username=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            //3. Executa a query
            ResultSet rs = ps.executeQuery();

            //4. Mostrar os resultados
            while (rs.next()) {
                usuario.setId_usuario(rs.getInt("id_usuario"));
                usuario.setUsername(rs.getString("username"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setPlano(rs.getString("plano"));
                usuario.setTime(rs.getString("time"));
                usuario.setFoto(rs.getString("foto"));
                usuario.setNascimento(rs.getDate("nascimento"));
                usuario.setTipo(rs.getInt("tipo"));
            }

            //5. Fechar tudo
            ps.close();
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }

}
