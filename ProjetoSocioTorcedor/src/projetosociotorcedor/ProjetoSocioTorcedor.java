/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetosociotorcedor;

import com.br.lp2.model.Assento;
import com.br.lp2.model.DateUtil;
import com.br.lp2.model.Usuario;
import com.br.lp2.model.Jogo;
import com.br.lp2.model.Estadio;
import com.br.lp2.model.Ingresso;
import com.br.lp2.model.dao.AssentoDAO;
import com.br.lp2.model.dao.EstadioDAO;
import com.br.lp2.model.dao.IngressoDAO;
import com.br.lp2.model.dao.UsuarioDAO;
import com.br.lp2.model.dao.JogoDAO;
import java.util.List;

/**
 *
 * @author Everson
 */
public class ProjetoSocioTorcedor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        JogoDAO jogoDAO = new JogoDAO();
        IngressoDAO ingressoDAO = new IngressoDAO();
        EstadioDAO estadioDAO = new EstadioDAO();
        AssentoDAO assentoDAO = new AssentoDAO();

        //LEITURA DO ESTADO INICIAL DO BANCO
        List<Usuario> lista = usuarioDAO.read();
        for (Usuario usuario : lista) {
          System.out.println(usuario);
        }

        List<Jogo> lista1 = jogoDAO.read();
        for (Jogo jogo : lista1) {
            System.out.println(jogo);
        }

        List<Ingresso> lista2 = ingressoDAO.read();
        for (Ingresso ingresso : lista2) {
            System.out.println(ingresso);
        }

        List<Estadio> lista3 = estadioDAO.read();
        for (Estadio estadio : lista3) {
            System.out.println(estadio);
        }

        List<Assento> lista4 = assentoDAO.read();
        for (Assento assento : lista4) {
            System.out.println(assento);
        }

        //========================================================================
        
        //USUARIODAO
        
        System.out.println("-----------------");

        Usuario u1 = new Usuario();
        u1.setSenha("123");
        u1.setUsername("everson");
        u1.setPlano("Ouro");
        u1.setTime("Corinthians");
        u1.setFoto("WEB-INF/img/perfil.jpg");
        u1.setNascimento(DateUtil.string2date("19/01/1996 15:51:18"));
        u1.setTipo(1);
        //usuarioDAO.insert(u1);

        //ATUALIZA USUARIO
        //Usuario u2 = lista.get(lista.size() - 1);
        //u2.setUsername("Joel");
        //u2.setSenha("321");
        //usuarioDAO.update(u2);

        //REMOVE USUARIO
        //Usuario u3 = lista.get(lista.size() - 1);
        //usuarioDAO.delete(u3);

        //REMOVE USARIO ESPECIFICO
        Usuario u4 = new Usuario();
        for (Usuario usuario : lista) {
            if (usuario.getUsername().equals("Carlos")) {
                u4 = usuario;
                break;
            }
        }
        //usuarioDAO.delete(u4);

        //========================================================================
        
        //JOGODAO
        
        Jogo j1 = new Jogo();
        j1.setId_Estadio(5);
        j1.setTime1("Palmeiras");
        j1.setTime2("São Paulo");
        //jogoDAO.insert(j1);

        //ATUALIZA JOGO
        //Jogo j2 = lista1.get(lista1.size() - 1);
        //j2.setTime1("COR");
        //j2.setTime2("Santos");
        //jogoDAO.update(j2);

        //REMOVE JOGO
        //Jogo j3 = lista1.get(lista1.size() - 1);
        //jogoDAO.delete(j3);

        //REMOVE JOGO ESPECIFICO
        for (int i = 0; i < lista1.size(); i++) {
            if (lista1.get(i).getTime1().equals("Palmeiras") || lista1.get(i).getTime2().equals("Palmeiras")) {
                //jogoDAO.delete(lista1.get(i));
                break;
            }
        }

        //========================================================================
        
        //INGRESSO
        
        Ingresso i1 = new Ingresso();
        i1.setNumeroIngresso(1);
        i1.setValorIngresso(10.15);
        i1.setData(DateUtil.string2date("19/01/1996 15:55:05"));
        i1.setNomeCampeonato("Cam Brasil");
        //ingressoDAO.insert(i1);

        //ATUALIZA INGRESSO
        //Ingresso i2 = lista2.get(lista2.size() - 1);
        //i2.setData(DateUtil.string2date("19/01/1996 2:04:10"));
        //i2.setNomeCampeonato("Brasileirao");
        //i2.setNumeroIngresso(2);
        //i2.setValorIngresso(10.00);
        //ingressoDAO.update(i2);

        //REMOVE INGRESSO
        //Ingresso i3 = lista2.get(lista2.size() - 1);
        //ingressoDAO.delete(i3);

        //REMOVE INGRESSO ESPECIFICO
        for (int i = 0; i < lista2.size(); i++) {
            if (lista2.get(i).getNumeroIngresso() == 1) {
                //ingressoDAO.delete(lista2.get(i));
                break;
            }
        }

        //========================================================================
        
        //ESTADIODAO

        Estadio es1 = new Estadio();
        es1.setLocalizacao("Itaquera");
        es1.setNomeEstadio("Arena");
        es1.setCapacidadeEstadio(10000);
        //estadioDAO.insert(es1);

        //ATUALIZA ESTADIO
        //Estadio es2 = lista3.get(lista3.size() - 1);
        //es2.setLocalizacao("Rio de Janeiro");
        //es2.setNomeEstadio("Maracanã");
        //es2.setCapacidadeEstadio(9000);
        //estadioDAO.update(es2);

        //REMOVE ESTADIO
        //Estadio es3 = lista3.get(lista3.size() - 1);
        //estadioDAO.delete(es3);

        //REMOVE ESTADIO ESPECIFICO
        for(int i=0; i < lista3.size(); i++){    
            if (lista3.get(i).getNomeEstadio().equals("Arena")) {
                //estadioDAO.delete(lista3.get(i));
                break;
            }
        }

        //========================================================================
        
        //ASSENTODAO
        Assento a1 = new Assento();
        a1.setNumeroAssento(53);
        a1.setSetorAssento("Amarelo");
        //assentoDAO.insert(a1);

        //ATUALIZA ASSENTO
        //Assento a2 = lista4.get(lista4.size() - 1);
        //a2.setNumeroAssento(100);
        //a2.setSetorAssento("Azul");
        //assentoDAO.update(a2);

        //REMOVE ASSENTO
        //Assento a3 = lista4.get(lista4.size() - 1);
        //assentoDAO.delete(a3);

        //REMOVE ASSENTO ESPECIFICO
        for (int i = 0; i < lista4.size(); i++) {
            if (lista4.get(i).getNumeroAssento() == 53 && lista4.get(i).getSetorAssento().equals("Amarelo")) {
                //assentoDAO.delete(lista4.get(i));
                break;
            }
        }

        //========================================================================
        
        lista = usuarioDAO.read();
        for (Usuario usuario : lista) {
            System.out.println(usuario);
        }

        lista1 = jogoDAO.read();
        for (Jogo jogo : lista1) {
            System.out.println(jogo);
        }

        lista2 = ingressoDAO.read();
        for (Ingresso ingresso : lista2) {
            System.out.println(ingresso);
            System.out.println(DateUtil.date2string(ingresso.getData()));
        }

        lista3 = estadioDAO.read();
        for (Estadio estadio : lista3) {
            System.out.println(estadio);
        }

        lista4 = assentoDAO.read();
        for (Assento assento : lista4) {
            System.out.println(assento);
        }

    }
}
