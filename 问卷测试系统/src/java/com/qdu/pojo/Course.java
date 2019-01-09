
package com.qdu.pojo;

import java.io.Serializable;


public class Course implements Serializable{
    private String courseId;
    private String courseName;
    private int credit;
    private String cmodule;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getCmodule() {
        return cmodule;
    }

    public void setCmodule(String cmodule) {
        this.cmodule = cmodule;
    }

    
    

    
    
}
