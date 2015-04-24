/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project;

import java.util.Iterator;
import java.util.Set;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Dominic
 */
public class CheeseDBPanel extends JPanel implements ActionListener{
    
    ////=====================================////
    //// Toggle multimaps vs. database usage ////
    ////=====================================////
    private boolean useDB = false;
    
    private JList tagList, cheeseList;
    private Loader data;
    private String[] tagArray, cheeseArray;
    private JLabel name;
    private JTextArea desc;
    private DefaultListModel<String> cheeseModel;
    private JPanel tagPanel, buttonPanel, cheesePanel, cheeseButtons, descrPanel;
    
    public CheeseDBPanel() {
        if(useDB) 
            data = new DBLoader();
        else
            data = new TSVLoader();
        
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        tagPanel = new JPanel();
        buttonPanel = new JPanel();
        cheesePanel = new JPanel();
        cheeseButtons = new JPanel();
        descrPanel = new JPanel();
        //set up tag panel
        tagPanel.setLayout(new BoxLayout(tagPanel, BoxLayout.PAGE_AXIS));
        buttonPanel.setLayout(new GridLayout(0, 2));
        
        tagPanel.add(new JLabel("Select Tag"));
        
            //set up button panel
        
        Set<String> rawTags = data.getTags();
        rawTags.add("ALL CHEESES");
        Iterator<String> tagIt = rawTags.iterator();
        while(tagIt.hasNext()) {
            JButton tagButton = new JButton(tagIt.next());
            tagButton.setName("tag_button");
            tagButton.addActionListener(this);
            buttonPanel.add(tagButton);        
        }
            
        tagPanel.add(buttonPanel);
        
        //set up cheeses panel
        cheesePanel.setLayout(new BoxLayout(cheesePanel, BoxLayout.PAGE_AXIS));
        cheesePanel.add(new JLabel("Select Cheese"));
        cheesePanel.setPreferredSize(new Dimension(200, 350));
        
        cheeseArray = data.getCheeses().toArray(new String[0]);
        Arrays.sort(cheeseArray);
        
            //set up cheese button panel
        cheeseButtons.setLayout(new GridLayout(0, 1));
        for(String chs : cheeseArray) {
            JButton cButton = new JButton(chs);
            cButton.setName("cheese_button");
            cButton.addActionListener(this);
            cheeseButtons.add(cButton);
        }
        cheesePanel.add(cheeseButtons);
        
        //set up descriptions panel
        descrPanel.setLayout(new BoxLayout(descrPanel, BoxLayout.PAGE_AXIS));
        name = new JLabel("Cheese name here!");
        descrPanel.add(name);
        descrPanel.setPreferredSize(new Dimension(200, 350));
        desc = new JTextArea(10,50);
        desc.setText("Cheese description goes here!");
        descrPanel.add(desc);
        desc.setEditable(false);
        desc.setLineWrap(true);
        desc.setWrapStyleWord(true);
        //put it all together
        
        add(tagPanel);
        add(cheesePanel);
        add(descrPanel);
        
        //note: this ended up not working, keeping for archival purposes
        /*Set<String> rawTags = data.getTags();
        rawTags.add("[DISPLAY ALL CHEESES]");
        tagArray = rawTags.toArray(new String[0]);
        tagList = new JList(tagArray);
        tagList.setName("Tags");
        tagList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        cheeseArray = data.getCheeses().toArray(new String[0]);
        Arrays.sort(cheeseArray);
        cheeseList = new JList(cheeseArray);
        cheeseList.setName("Cheeses");
        cheeseList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        cheeseList.setPreferredSize(new Dimension(150, 260));
        cheeseList.setVisibleRowCount(13);
        //vertical height 260px or so
        cheeseModel = new DefaultListModel();
        for(String chs : cheeseArray)
            cheeseModel.addElement(chs);
        cheeseList.setModel(cheeseModel);
        name = new JLabel("PLACEHOLDER");
        
        desc = new JTextArea();
        
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        add(tagList);
        add(cheeseList);
        add(name);
        add(desc);
        
        TagListener tListener = new TagListener();
        ListSelectionModel lsm = new DefaultListSelectionModel();
        System.out.println(lsm.getSelectionMode());
        tagList.setSelectionModel(lsm);
        lsm.addListSelectionListener(tListener);
        
        CheeseListener cListener = new CheeseListener();
        ListSelectionModel clsm = new CheeseSelector();
        System.out.println(clsm.getSelectionMode());
        cheeseList.setSelectionModel(clsm);
        clsm.addListSelectionListener(cListener);*/
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton src = (JButton) e.getSource();
        
        //check whether the button is from the tag or cheeses section
        if(src.getName().equals("tag_button")) {
            //repopulate the cheese button panel with the pertinent cheeses
            cheeseButtons.removeAll();
            Set<String> result;
            if(src.getText().equals("ALL CHEESES")) {
                //special case, display everything
                result = data.getCheeses();
            }
            else {
                //get the pertinent cheese(s)
                result = data.getCheeses(src.getText());
            }
            Iterator<String> cheeseAdd = result.iterator();
            while(cheeseAdd.hasNext()) {
                String buttonText = cheeseAdd.next();
                System.out.println(buttonText);
                JButton cButton = new JButton(buttonText);
                cButton.setName("cheese_button"); //important for the else-if
                cButton.addActionListener(this);
                cheeseButtons.add(cButton);
            }
            cheeseButtons.revalidate();
        }
        else if(src.getName().equals("cheese_button")) {
            //display selected cheese and its description
            name.setText(src.getText());
            Cheese selected = data.getCheese(src.getText());
            desc.setText(selected.getDescription());
            descrPanel.revalidate();
        }
        
    }
    
}
