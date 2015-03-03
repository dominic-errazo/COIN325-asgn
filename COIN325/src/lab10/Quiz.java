/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab10;

import javax.swing.JOptionPane;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author Dominic
 */
public class Quiz {
    
    private Question[] contents;
    private final int MAX_QUESTIONS = 25;
    private int size;
    private Scanner fileReader;
    
    public Quiz() {
        contents = new Question[MAX_QUESTIONS];
        size = 0;
    }
    
    public boolean add(Question question) {
        if(size < MAX_QUESTIONS) {
            
            contents[size++] = question;
            return true;
            
        }
        else return false;
    }
    
    public void addFromFile(String filename) {
        try {
            fileReader = new Scanner(new File(filename));
            String line;
            String[] qAndA;
            while(fileReader.hasNext()) {
                line = fileReader.nextLine();
                qAndA = line.split("\t");
                add(new Question(qAndA[0], qAndA[1]));
            }
        }
        catch(FileNotFoundException e) {
            System.err.println("File not found! Please check path!");
        }
    }
    
    public Question getQuestion(int index) {
        try {
            return contents[index];
        }
        catch(ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }
    
    public int getNumberOfQuestions() {
        return size;
    }
    
    public int getNumberOfCorrectResponses() {
        int correct = 0;
        
        for(int i = 0; i < size; i++)
            if(contents[i].getAnswer().equals(contents[i].getResponse()))
                correct++;
        
        return correct;
    }

        
    public void giveQuiz() {
        for(int i = 0; i < size; i++) {
            contents[i].setResponse(JOptionPane.showInputDialog(contents[i].getQuestion()));
        }
        for(int i = 0; i < size; i++) {
            System.out.println(contents[i].getQuestion() + ", Student response: " +
                               contents[i].getResponse() + ", Instructor's answer: " +
                               contents[i].getAnswer());
        }
        System.out.println("Auto-grader: " + getNumberOfCorrectResponses() +
                            " out of " + size);
    }
    
    

    public static void main(String[] args) {
        Quiz myQuiz = new Quiz();
        myQuiz.add(new Question("What is 2+2?", "4"));
        myQuiz.add(new Question("What is the best part of the Oreo?", 
                                "the whole thing"));
        
        //System.out.println(System.getProperty("user.dir"));
        //myQuiz.addFromFile("src/lab10/shortQuiz.txt");
        myQuiz.giveQuiz();

    }
}
