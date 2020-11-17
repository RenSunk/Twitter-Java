/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.twitterproyect2;

/**
 *
 * @author Hogar
 */
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;

public class JpanelDerecha extends JPanel implements ActionListener {
    
    JButton boton = new JButton("ENVIAR");
    JTextArea area = new JTextArea();
    Twitter twitter;
    JpanelCentro centro;
    Jframe frame;
    Principal principal;
    public JpanelDerecha(Twitter twitter, JpanelCentro centro, Jframe frame,Principal principal) throws TwitterException, MalformedURLException {
        this.frame = frame;
        this.centro = centro;
        this.twitter = twitter;
        this.principal = principal;
        User usuario = this.twitter.verifyCredentials();
        area.setEditable(false);
    
        ImageIcon imagen = new ImageIcon(new URL(usuario.getOriginalProfileImageURL()));
        
        JLabel label = new JLabel("");
        JPanel panel = new JPanel();
        
        label.setIcon(imagen);
        area.append("\nid: "+usuario.getId()+"\n");
        area.append("Nombre: "+usuario.getName()+"\n");
        area.append("Estado: "+usuario.getStatus().getText()+"\n");
        area.append("seguidores: "+usuario.getFollowersCount()+"\n");
        area.append("Descripcion: "+usuario.getDescription());
        
        setBorder(new CompoundBorder(new EmptyBorder(0, 15, 0, 0),new TitledBorder("Informacion del usuario")));
        boton.addActionListener(this);
        
        panel.setLayout(new BorderLayout());
        
        
        panel.add(label, BorderLayout.NORTH);
        panel.add(area, BorderLayout.CENTER);
        
        setLayout(new BorderLayout());
        
        add(boton, BorderLayout.SOUTH);
        add(panel, BorderLayout.CENTER);
        
    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == boton){
            try {

                if(centro.gettexto() == null || centro.gettexto().equals("")){
                    JOptionPane.showMessageDialog(null, "No puede hacer un twee vacio",
                        "ALERTA",JOptionPane.WARNING_MESSAGE);
                } else {
                    twitter.updateStatus(centro.gettexto());
                    JOptionPane.showMessageDialog(null, "SUCCESSFULLY \n estado actualizado a [ "+centro.gettexto()+" ].",
                        "ALERTA",JOptionPane.WARNING_MESSAGE);
                }

                frame.dispose();                
                Jframe nuevo = new Jframe(twitter,principal);
                
            } catch (TwitterException ex) {
                Logger.getLogger(JpanelDerecha.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MalformedURLException ex) {
                Logger.getLogger(JpanelDerecha.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(JpanelDerecha.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "No es posible duplicar un tweet", "ALERTA",JOptionPane.WARNING_MESSAGE);
            }
            
        }
        
    }

}
