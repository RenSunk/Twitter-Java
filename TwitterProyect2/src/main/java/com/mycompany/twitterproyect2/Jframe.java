/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.twitterproyect2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.swing.*;
import twitter4j.Twitter;
import twitter4j.TwitterException;

/**
 *
 * @author Hogar
 */

public class Jframe extends JFrame implements ActionListener{
    Twitter twitter;
    JButton grafica = new JButton("Graficas");
    ControlImagen control;
    Principal principal;
    public Jframe(Twitter twitter, Principal princiapl) throws MalformedURLException, IOException, TwitterException{
        this.principal = princiapl;
        this.twitter = twitter;
        
        control = new ControlImagen(principal);
        
        recargar();
    }

    
    public void recargar() throws TwitterException, MalformedURLException{
        JpanelCentro centro = new JpanelCentro(twitter);
        JpanelDerecha derecha = new JpanelDerecha(twitter,centro,this,principal);
        

        setSize(1000,500);
        setLocationRelativeTo(null);
        
       
        setLayout(new BorderLayout());
        grafica.addActionListener(this);
        
        add(grafica, BorderLayout.NORTH);
        add(centro, BorderLayout.CENTER);
        add(derecha, BorderLayout.EAST);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == grafica){
            control.inicioGeneGrafico();
        }

    }

}
