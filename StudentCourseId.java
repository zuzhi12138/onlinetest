
package com.qdu.pojo;

import java.io.Serializable;

public class StudentCourseId implements Serializable{
    private int studentId;
    private String courseId;

    public StudentCourseId() {
    }

    public StudentCourseId(int studentId, String courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
    
    
}
