
package com.qdu.pojo;

import java.io.Serializable;

public class QuestionId implements Serializable{
    private int questionId;
     private String courseId;
     
     public QuestionId() {
    }

    public QuestionId(int questionId, String courseId) {
       this.questionId = questionId;
       this.courseId = courseId;
    }
   
    public int getQuestionId() {
        return this.questionId;
    }
    
    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }
    public String getCourseId() {
        return this.courseId;
    }
    
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

 
}
