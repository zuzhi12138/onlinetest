
package com.qdu.pojo;

import java.io.Serializable;


public class Manager implements Serializable{
    private int managerNo;
    private String managerPassword;
    private String managerName;
    private String managerGender;
    private String managerMobile;

    public Manager() {
    }

    public Manager(int managerNo, String managerPassword, String managerName, String managerGender, String managerMobile) {
        this.managerNo = managerNo;
        this.managerPassword = managerPassword;
        this.managerName = managerName;
        this.managerGender = managerGender;
        this.managerMobile = managerMobile;
    }

    
    
    public int getManagerNo() {
        return managerNo;
    }

    public void setManagerNo(int managerNo) {
        this.managerNo = managerNo;
    }

    public String getManagerPassword() {
        return managerPassword;
    }

    public void setManagerPassword(String managerPassword) {
        this.managerPassword = managerPassword;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerGender() {
        return managerGender;
    }

    public void setManagerGender(String managerGender) {
        this.managerGender = managerGender;
    }

    public String getManagerMobile() {
        return managerMobile;
    }

    public void setManagerMobile(String managerMobile) {
        this.managerMobile = managerMobile;
    }
    
    
    
    
}
