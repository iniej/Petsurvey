package com.Iniebiyo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by Iniebiyo Joshua on 3/22/2017.
 */
    public class PetSurvey extends JFrame {
    private JCheckBox dogCheckBox;
    private JCheckBox catCheckBox;
    private JCheckBox fishCheckBox;
    private JPanel rootPanel;
    private JLabel surveyResultsLabel;
    private JButton quitButton;
    private JLabel serveyResultslabel;

    private boolean dog;
    private boolean cat;
    private boolean fish;

    protected PetSurvey() {
        //Set the contents of the window to be the rootPanel Jpanel.
        setContentPane(rootPanel);
        pack(); //Add the components to the window.
        //Set the size - user wil be able to reset the size.
        setSize(new Dimension(350, 200));
        setTitle("Pet Survey"); //Set the text in the title bar.

        //Close the program when you close this window
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true); //What it sounds like.

        fishCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println("the fish checkbox is checked or unchecked.");
                fish = fishCheckBox.isSelected();
                updateResults();
            }
        });
        dogCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                dog = dogCheckBox.isSelected();
                updateResults();
            }
        });
        catCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                cat = catCheckBox.isSelected();
                updateResults();
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int quit = JOptionPane.showConfirmDialog(PetSurvey.this,
                        "Are you sure you want to quit?",
                        "Confirm Quit", JOptionPane.OK_CANCEL_OPTION);
                if (quit == JOptionPane.OK_OPTION) {
                    System.exit(0);
                }
            }
        });
    }

        private void updateResults() {
        String hasDog = dog ? "One dog" : "no dogs";
        String hasCat = cat ? "one cat" : "no cat";
        String hasFish = fish ? "one fish" : "no fish";



        String results = "You have " + hasDog + " and " + hasCat + " and " + hasFish;
            serveyResultslabel.setText(results);
    }

}

