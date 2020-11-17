/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.twitterproyect2;


import java.io.IOException;
import java.net.MalformedURLException;
import twitter4j.*;
/**
 *
 * @author Hogar
 */
public class Principal {
    
    private String sbContCade = "";
    private String nuContTwee = "";
    
    
    Twitter twitter = new TwitterFactory().getInstance();

    public Principal() throws IOException, MalformedURLException, TwitterException{
        Jframe frame = new Jframe(twitter, this); 
    }

    public static void main(String[] args) throws IOException, MalformedURLException, TwitterException  {
        Principal miPrincipal = new Principal();
    } 
    
    public void generaGraficos(String sbDatoCons) throws TwitterException {
        
        Trends tendencias = twitter.getPlaceTrends(23424787);
        
        for (int i = 0; i < tendencias.getTrends().length; i++) {
            if (tendencias.getTrends()[i].getTweetVolume() != -1) {
                System.out.println(i + ". Tendencia: " + tendencias.getTrends()[i].getName() + ", "
                        + "TweetVolume: " + tendencias.getTrends()[i].getTweetVolume());
                sbContCade = sbContCade + "-" + tendencias.getTrends()[i].getName();
                nuContTwee = nuContTwee + "-" + tendencias.getTrends()[i].getTweetVolume();

            }
        }
        System.out.println("sbContCade: "+sbContCade);
        System.out.println("sbContCade: "+nuContTwee);

        if (sbDatoCons.equals("B")) {
            BarChartEx ex = new BarChartEx();
            ex.setVisible(true);
            ex.initUI(sbContCade, nuContTwee);
        } else if (sbDatoCons.equals("P")) {
            GraficoPie ex = new GraficoPie();
            ex.setVisible(true);
            ex.initUI(sbContCade, nuContTwee);
        }
    }
    
    
    
}



