/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.twitterproyect2;

import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import twitter4j.TwitterException;

/**
 *
 * @author Hogar
 */
public class ControlImagen extends JPanel implements ActionListener {
    static String birdString = "Gràfico de Barra";
    static String catString = "Gràfico de  Pie";
    
    JButton boton = null;
    JRadioButton birdButton = new JRadioButton(birdString);
    JRadioButton catButton = new JRadioButton(catString);
    JLabel picture;
    Principal principal;
    public ControlImagen(Principal principal) {
        super(new BorderLayout());
        this.principal = principal;
        
        boton =new JButton("Ejecutar");
        boton.setBounds(300,250,100,30);
        
        //Create the radio buttons.
        birdButton.setMnemonic(KeyEvent.VK_B);
        birdButton.setActionCommand(birdString);
        birdButton.setSelected(true);

        catButton.setMnemonic(KeyEvent.VK_C);
        catButton.setActionCommand(catString);
        //Group the radio buttons.
        ButtonGroup group = new ButtonGroup();
        group.add(birdButton);
        group.add(catButton);

        //Register a listener for the radio buttons.
        birdButton.addActionListener(this);
        catButton.addActionListener(this);

        //Set up the picture label.
        picture = new JLabel(createImageIcon("images/" + birdString + ".gif"));

        
        picture.setPreferredSize(new Dimension(177, 122));
        JPanel radioPanel = new JPanel(new GridLayout(0, 1));
        radioPanel.add(birdButton);
        radioPanel.add(catButton);
        radioPanel.add(boton);

        add(radioPanel, BorderLayout.LINE_START);
        add(picture, BorderLayout.CENTER);
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        
        boton.addActionListener(this);
    }

    /** Listens to the radio buttons. */
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == boton){
            if(birdButton.isSelected()){
                try {
                    principal.generaGraficos("B");
                } catch (TwitterException ex) {
                    Logger.getLogger(ControlImagen.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    principal.generaGraficos("P");
                } catch (TwitterException ex) {
                    Logger.getLogger(ControlImagen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        picture.setIcon(createImageIcon("images/" + e.getActionCommand() + ".gif"));
    }

    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = ControlImagen.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }


    private void createAndShowGUI() {
        JFrame frame = new JFrame("ControlImagen");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JComponent newContentPane = new ControlImagen(principal);
        
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
    }

    public void inicioGeneGrafico(){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
