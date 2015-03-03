package lab10;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dominic
 */
public class QuizTest {
    
    private Quiz quiz;
    
    public QuizTest() {
        quiz = new Quiz();
    }

    @Test
    public void testQuestions() {
        Question q = new Question("What is the best part of the Oreo?", "the whole thing");
        assertTrue(q.getAnswer().equals("the whole thing"));
        assertTrue(q.getQuestion().equals("What is the best part of the Oreo?"));
    }
    
    @Test
    public void testQuiz() {
        Question q = new Question("What is the best part of the Oreo?", "the whole thing");
        Question q2 = new Question("What is 1+1?", "2");
        
        quiz.add(q);
        quiz.add(q2);
        
        Question qret = quiz.getQuestion(0);
        assertTrue(qret == q);
        assertTrue(quiz.getQuestion(-1) == null);
        assertTrue(quiz.getQuestion(25) == null);
        assertTrue(q2 == quiz.getQuestion(1));
        
        assertTrue(quiz.getQuestion(0).getQuestion().equals("What is the best part of the Oreo?"));
        quiz.getQuestion(0).setResponse("the cookie");
        assertTrue(quiz.getQuestion(0).getResponse().equals("the cookie"));
        
        assertTrue(quiz.getNumberOfQuestions() == 2);
        assertTrue(quiz.getNumberOfCorrectResponses() == 0);
        quiz.getQuestion(1).setResponse("2");
        assertTrue(quiz.getNumberOfCorrectResponses() == 1);
        
    }
    
    @Test
    public void testFromFile() {
        quiz.clear();
        quiz.addFromFile("src/lab10/shortQuiz.txt");
        
        assertTrue(quiz.getNumberOfQuestions() == 4);
    }
    
    @Test
    public void testFullFromFile() {
        quiz.clear();
        quiz.addFromFile("src/lab10/fullQuiz.txt");
        
        assertTrue(quiz.getNumberOfQuestions() == 25);
        
        for(int i = 1; i <= 25; i++) {
            Question current = quiz.getQuestion(i-1);
            current.setResponse(Integer.toString(2 * i));
            assertTrue(quiz.getNumberOfCorrectResponses() == i);
        }
    }
}
