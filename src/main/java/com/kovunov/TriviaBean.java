package com.kovunov;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.*;


@Named("trivia")
@SessionScoped
public class TriviaBean implements Serializable {

    private long correctAnswersCount = 0;

    @Inject
    private QuestionService questionService;

    private String question1;

    private String question2;

    private String question3;

    private String question4;

    private String question5;

    private String question6;

    public String validateAnswer(){
        List<String> answers = Arrays.asList(question1,question2,question3,question4,question5,question6);
        Map<Integer,String> answersMap = new HashMap<>();

        for (int i=0;i<6;i++){
            answersMap.put(i+1,answers.get(i));
        }
        correctAnswersCount = countCorrectAnswers(answersMap);
        return "results";
    }

    private long countCorrectAnswers(Map<Integer,String> answers){
        long counter = 0;
        for(int i=1; i<7; i++){
            String encodedAnswer = Base64.getEncoder().encodeToString(answers.get(i).getBytes(StandardCharsets.UTF_8));
            if(encodedAnswer.equals(questionService.getResultsMap().get(i))){
                counter++;
            }
        }
        return counter;
    }

    public long getCorrectAnswersCount() {
        return correctAnswersCount;
    }

    public String getQuestion1() {
        return question1;
    }

    public void setQuestion1(String question1) {
        this.question1 = question1;
    }

    public String getQuestion2() {
        return question2;
    }

    public void setQuestion2(String question2) {
        this.question2 = question2;
    }

    public String getQuestion3() {
        return question3;
    }

    public void setQuestion3(String question3) {
        this.question3 = question3;
    }

    public String getQuestion4() {
        return question4;
    }

    public void setQuestion4(String question4) {
        this.question4 = question4;
    }

    public String getQuestion5() {
        return question5;
    }

    public void setQuestion5(String question5) {
        this.question5 = question5;
    }

    public String getQuestion6() {
        return question6;
    }

    public void setQuestion6(String question6) {
        this.question6 = question6;
    }

    public void tip() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Question 6", "One of them is Ecuador"));
    }
}

