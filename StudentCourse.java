
package com.qdu.pojo;

import java.io.Serializable;


public class StudentCourse implements Serializable{
    private StudentCourseId id;
    private String studentName;
    private String courseName;

    public StudentCourse() {
    }

    public StudentCourse(StudentCourseId id) {
        this.id = id;
    }
    

    public StudentCourse(StudentCourseId id, String studentName, String courseName) {
        this.id = id;
        this.studentName = studentName;
        this.courseName = courseName;
    }

    public StudentCourseId getId() {
        return id;
    }

    public void setId(StudentCourseId id) {
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
    
    
}
