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

import java.awt.GridLayout;
import java.net.MalformedURLException;
import java.util.List;
import javax.swing.*;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;

public class JscrollPanel extends JPanel{
    
    PanelTweet panel[];
    
    Twitter twitter;
    public JscrollPanel(Twitter twitter) throws TwitterException, MalformedURLException {
        this.twitter = twitter;
        reloadtweets();
    }
    
    public void reloadtweets() throws MalformedURLException, TwitterException{
        
        panel = new PanelTweet[12];
        List<Status> estados = twitter.getHomeTimeline();
        
        setLayout(new GridLayout(panel.length, 1));
        
        for(int i =0; i < panel.length; i++){
            User usuario = estados.get(i).getUser();
            String texto = estados.get(i).getText();
            
            panel[i] = new PanelTweet(usuario.getName(), texto, usuario.getOriginalProfileImageURL());
            add(panel[i]);
        }
        repaint();
    }
    
    public void borrar(){
        removeAll();
    }

}
