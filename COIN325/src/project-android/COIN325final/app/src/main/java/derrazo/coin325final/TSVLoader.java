/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package derrazo.coin325final;

import com.google.common.collect.*;
import java.util.*;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Dominic
 */
public class TSVLoader implements Loader {
    //
    private HashMultimap<String, String> tagToCheese;
    private HashMultimap<String, String> cheeseToTag;
    private HashMap<String, String> cheeseDescs;
    
    public TSVLoader() {
        tagToCheese = HashMultimap.create();
        cheeseToTag = HashMultimap.create();
        cheeseDescs = new HashMap<>();
        
        
        //load from TSV files
        try {            
            Scanner tsvReader = new Scanner(new File("tagToCheese.tsv"));
            
            //load in tags and cheeses listed with those tags
            String currentLine;
            while(tsvReader.hasNext()) {
                currentLine = tsvReader.nextLine();
                String[] parts = currentLine.split("\t");
                String[] cheeses = parts[1].split(",");
                for(String ch : cheeses) {
                    tagToCheese.put(parts[0], ch);
                    cheeseToTag.put(ch, parts[0]);
                }
                    
            }
            tsvReader.close();
            
            //load in cheeses and descriptions
            tsvReader = new Scanner(new File("cheesedesc.tsv"));
            while(tsvReader.hasNext()) {
                currentLine = tsvReader.nextLine();
                String[] parts = currentLine.split("\t");
                cheeseDescs.put(parts[0], parts[1]);
            }
            
        }
        catch(IOException ioe) {
            System.err.println("Error reading file!");
        }
        
    }

    @Override
    public Set<String> getCheeses() {
        return cheeseDescs.keySet();
    }

    @Override
    public Set<String> getCheeses(String tag) {
        return tagToCheese.get(tag);
    }

    @Override
    public Set<String> getTags() {
        TreeSet<String> st = new TreeSet<>(tagToCheese.keySet());
        return st;
    }
    
    public Set<String> getTags(String cheese) {
        return cheeseToTag.get(cheese);
    }

    @Override
    public Cheese getCheese(String cheeseName) {
        return new Cheese(cheeseName, cheeseDescs.get(cheeseName));
    }
    
    
}
