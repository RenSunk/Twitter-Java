/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.twitterproyect2;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.EventQueue;

/**
 *
 * @author Hogar
 */
public class BarChartEx extends JFrame {

    public void initUI(String sbContCade, String nuContTwee) {

        CategoryDataset dataset = createDataset(sbContCade, nuContTwee);

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

    public CategoryDataset createDataset(String sbContCade, String nuContTwee) {
        
        String strCade = sbContCade;
        String [] prtCade = strCade.split("-");
        
        String strTwee = nuContTwee;
        String [] prtTwee = strTwee.split("-");
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(int i = 1; i < prtCade.length; i++){
            dataset.setValue(Integer.parseInt(prtTwee[i]), "Nuevo de Tweets", prtCade[i]);
        }
        return dataset;
    }

    public JFreeChart createChart(CategoryDataset dataset) {
       
        JFreeChart barChart = ChartFactory.createBarChart(
                "Tweets de tendencia",
                "",
                "Nuevo de Tweets",
                dataset,
                PlotOrientation.HORIZONTAL,
                false, true, false);
        barChart.getPlot().setBackgroundPaint(Color.ORANGE);
        barChart.getPlot().setOutlinePaint(Color.BLACK);
        
        return barChart;
    }
}
