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
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
public class PanelTweet extends JPanel{
    
    
    public PanelTweet(String nombre,String contenido, String foto) throws MalformedURLException {
        
        URL url = new URL(foto);
        
        Image imagen = new ImageIcon(url).getImage();
        Image escalada = imagen.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon icono = new ImageIcon(escalada);
        
        
        JLabel label = new JLabel("");
        JTextField titulo_tweet = new JTextField(), contenmido_tweet = new JTextField();
        JPanel panel = new JPanel();
        
        titulo_tweet.setText(nombre);
        contenmido_tweet.setText(contenido);
        
        titulo_tweet.setEditable(false);
        contenmido_tweet.setEditable(false);
        
        panel.setLayout(new BorderLayout());
        
        label.setIcon(icono);
        setLayout(new BorderLayout());
        
        panel.add(titulo_tweet, BorderLayout.NORTH);
        panel.add(contenmido_tweet, BorderLayout.CENTER);
        setBorder(new CompoundBorder(new EmptyBorder(0, 0, 20, 0),new TitledBorder("")));
        add(label, BorderLayout.WEST);
        add(panel, BorderLayout.CENTER);

    }
    
    
}
