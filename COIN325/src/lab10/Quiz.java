/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab10;

import javax.swing.JOptionPane;

/**
 *
 * @author Dominic
 */
public class Quiz {
    
    private Question[] contents;
    private final int MAX_QUESTIONS = 25;
    private int size;
    
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
            if(contents[i].getAnswer() == contents[i].getResponse())
                correct++;
        
        return correct;
    }

        
    public void giveQuiz() {
        for(int i = 0; i < size; i++) {
            contents[i].setResponse(JOptionPane.showInputDialog(contents[i].getQuestion()));
        }
    }

    public static void main(String[] args) {
        Quiz myQuiz = new Quiz();
        myQuiz.add(new Question("What is 2+2?", "4"));
        myQuiz.add(new Question("What is the best part of the Oreo?", 
                                "the whole thing"));
    }
}
