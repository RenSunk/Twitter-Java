/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.twitterproyect2;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import java.awt.Color;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author Hogar
 */
public class GraficoPie extends JFrame{
    
    public void initUI(String sbContCade, String nuContTwee) {
        PieDataset dataset = createDataset(sbContCade, nuContTwee);
        
        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        add(chartPanel);

        pack();
        setTitle("Bar chart");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    public PieDataset createDataset(String sbContCade, String nuContTwee) {
            
        String strCade = sbContCade;
        String [] prtCade = strCade.split("-");
        
        String strTwee = nuContTwee;
        String [] prtTwee = strTwee.split("-");
        
        DefaultPieDataset pieDataset = new DefaultPieDataset();
        for(int i = 1; i < prtCade.length; i++){
            pieDataset.setValue(prtCade[i], Integer.parseInt(prtTwee[i]));
        }
        return pieDataset;
    }
    
    public JFreeChart createChart(PieDataset dataset) { 
        JFreeChart barChart = ChartFactory.createPieChart3D("Tweets de Tendencia", dataset, true, false, false);
        return barChart;
    }
    
}
