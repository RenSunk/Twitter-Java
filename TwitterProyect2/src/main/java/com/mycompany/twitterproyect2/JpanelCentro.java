/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.twitterproyect2;

import java.awt.BorderLayout;
import java.net.MalformedURLException;
import javax.swing.*;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import twitter4j.Twitter;
import twitter4j.TwitterException;

/**
 *
 * @author Hogar
 */

public class JpanelCentro extends JPanel{
    
    JTextField texto;
    JscrollPanel panel;
    Twitter twitter;
    public JpanelCentro(Twitter twitter) throws TwitterException, MalformedURLException {
        this.twitter = twitter;
        setLayout(new BorderLayout());
        
        texto = new JTextField();
        panel = new JscrollPanel(twitter);
        JScrollPane scrool = new JScrollPane(panel);
        
        panel.setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0),new TitledBorder("Tweets recientes")));
        
        add(scrool, BorderLayout.CENTER);
        
        add(texto,BorderLayout.SOUTH);
        
    }
    
    public String gettexto(){
        return texto.getText();
    }
    
    public JscrollPanel scrooool(){
        return panel;
    }
    
    public void recargar() throws TwitterException, MalformedURLException{
        removeAll();
        
        setLayout(new BorderLayout());
        
        texto = new JTextField();
        panel = new JscrollPanel(twitter);
        JScrollPane scrool = new JScrollPane(panel);
        
        panel.setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0),new TitledBorder("Tweets recientes")));
        
        add(scrool, BorderLayout.CENTER);
        
        add(texto,BorderLayout.SOUTH);
        repaint();
    }
    
}

