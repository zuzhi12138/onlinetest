
package com.qdu.pojo;

import java.io.Serializable;



public class Grade implements Serializable{
    private GradeId gradeId;
    private int studentGrade;
    private String finishDate;

    public GradeId getGradeId() {
        return gradeId;
    }

    public void setGradeId(GradeId gradeId) {
        this.gradeId = gradeId;
    }

    public int getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(int studentGrade) {
        this.studentGrade = studentGrade;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }


    
    
    
    
    
}
