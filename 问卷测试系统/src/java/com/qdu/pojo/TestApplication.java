
package com.qdu.pojo;

import java.io.Serializable;


public class TestApplication implements Serializable{
    private TestApplicationId id;
    private String studentName;
    private String courseName;
    private String application;

    public TestApplication() {
    }

    public TestApplication(TestApplicationId id) {
        this.id = id;
    }
    

    public TestApplication(TestApplicationId id, String studentName, String courseName, String application) {
        this.id = id;
        this.studentName = studentName;
        this.courseName = courseName;
        this.application = application;
    }

    public TestApplicationId getId() {
        return id;
    }

    public void setId(TestApplicationId id) {
        this.id = id;
    }
    
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }


    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }
    
    
}

