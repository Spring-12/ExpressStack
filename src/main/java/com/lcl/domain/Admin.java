package com.lcl.domain;

import java.util.Date;

public class Admin {

    private Integer id;
    private String userName;
    private String password;
    private Date loginTime;
    private String loginIp;

    public Admin() {
    }

    public Admin(Integer id, String userName, String password, Date loginTime, String loginIp) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.loginTime = loginTime;
        this.loginIp = loginIp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", loginTime=" + loginTime +
                ", loginIp='" + loginIp + '\'' +
                '}';
    }
}
