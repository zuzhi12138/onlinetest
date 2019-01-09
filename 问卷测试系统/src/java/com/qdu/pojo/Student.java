
package com.qdu.pojo;

import java.io.Serializable;

public class Student implements Serializable{
    private int studentId;
    private String studentPassword;
    private String studentName;
    private String studentGender;
    private int studentAge;
    private String studentMobile;

    public Student() {
    }

    public Student(int studentId, String studentPassword, String studentName, String studentGender, int studentAge, String studentMobile) {
        this.studentId = studentId;
        this.studentPassword = studentPassword;
        this.studentName = studentName;
        this.studentGender = studentGender;
        this.studentAge = studentAge;
        this.studentMobile = studentMobile;
    }

    
    
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentMobile() {
        return studentMobile;
    }

    public void setStudentMobile(String studentMobile) {
        this.studentMobile = studentMobile;
    }
    
    
    
}
