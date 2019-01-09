
package com.qdu.pojo;

import java.io.Serializable;

public class Question implements Serializable{
     private QuestionId id;
     private String questionDesc;
     private String answerA;
     private String answerB;
     private String answerC;
     private String answerD;
     private String answerKey;
     private int credit;
     
      public Question() {
    }

	
    public Question(QuestionId id, String course) {
        this.id = id;
    }

    public Question(QuestionId id, String questionDesc, String answerA, String answerB, String answerC, String answerD, String answerKey, int credit) {
        this.id = id;
        this.questionDesc = questionDesc;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.answerKey = answerKey;
        this.credit = credit;
    }
    

   


    public String getQuestionDesc() {
        return this.questionDesc;
    }
    
    public void setQuestionDesc(String questionDesc) {
        this.questionDesc = questionDesc;
    }
    public String getAnswerA() {
        return this.answerA;
    }
    
    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }
    public String getAnswerB() {
        return this.answerB;
    }
    
    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }
    public String getAnswerC() {
        return this.answerC;
    }
    
    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }
    public String getAnswerD() {
        return this.answerD;
    }
    
    public void setAnswerD(String answerD) {
        this.answerD = answerD;
    }
    public String getAnswerKey() {
        return this.answerKey;
    }
    
    public void setAnswerKey(String answerKey) {
        this.answerKey = answerKey;
    }

    public QuestionId getId() {
        return id;
    }

    public void setId(QuestionId id) {
        this.id = id;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

     
}
