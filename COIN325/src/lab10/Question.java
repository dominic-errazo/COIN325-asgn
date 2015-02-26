/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab10;

/**
 *
 * @author Dominic
 */
public class Question {
    
    private String _question, _answer, _response;
    
    public Question (String question, String answer) {
        _question = question;
        _answer = answer;
    }
    
    public String getQuestion() {
        return _question;
    }
    
    public String getAnswer() {
        return _answer;
    }
    
    public String getResponse() {
        return _response;
    }
    
    public void setQuestion(String question) {
        _question = question;
    }
    
    public void setAnswer(String answer) {
        _answer = answer;
    }
    
    public void setResponse(String response) {
        _response = response;
    }
    
    
    
}
