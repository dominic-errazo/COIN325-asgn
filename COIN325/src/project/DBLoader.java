/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project;

import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author Dominic
 */
public class DBLoader implements Loader{
    
    //Didn't quite get to doing this. Too many problems with the main program failing to get lists to play nice.
    
    public DBLoader() {
        JOptionPane.showMessageDialog(null, "NOT IMPLEMENTED YET.\nEXCEPTIONS WILL BE THROWN\nIF YOU USE THIS OBJECT");
    }
    
    @Override
    public Set<String> getCheeses() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<String> getCheeses(String tag) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<String> getTags() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<String> getTags(String cheese) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cheese getCheese(String cheeseName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
