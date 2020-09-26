package com.lcl.domain;

import java.util.Date;
import java.util.Objects;

public class Express {
    private Integer id;
    private String exprSno;
    private Integer exprStatus;
    private String statusView;
    private String userName;
    private String userPhone;
    private String company;
    private String code;
    private Date inTime;
    private Date outTime;
    private String sysPhone;

    public Express(Integer id, String exprSno, Integer exprStatus, String statusView, String userName, String userPhone, String company,
                   String code, Date inTime, Date outTime, String sysPhone) {
        this.id = id;
        this.exprSno = exprSno;
        this.exprStatus = exprStatus;
        this.statusView = statusView;
        this.userName = userName;
        this.userPhone = userPhone;
        this.company = company;
        this.code = code;
        this.inTime = inTime;
        this.outTime = outTime;
        this.sysPhone = sysPhone;
    }

    public Express(String exprSno, String userName, String userPhone,
                   String company, String sysPhone) {
        this.exprSno = exprSno;
        this.userName = userName;
        this.userPhone = userPhone;
        this.company = company;
        this.sysPhone = sysPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Express express = (Express) o;
        return Objects.equals(id, express.id) &&
                Objects.equals(exprSno, express.exprSno) &&
                Objects.equals(exprStatus, express.exprStatus) &&
                Objects.equals(userName, express.userName) &&
                Objects.equals(userPhone, express.userPhone) &&
                Objects.equals(company, express.company) &&
                Objects.equals(code, express.code) &&
                Objects.equals(inTime, express.inTime) &&
                Objects.equals(outTime, express.outTime) &&
                Objects.equals(sysPhone, express.sysPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, exprSno, exprStatus, userName, userPhone, company, code, inTime, outTime, sysPhone);
    }

    public Express() {
    }

    @Override
    public String toString() {
        return "Express{" +
                "id=" + id +
                ", exprSno='" + exprSno + '\'' +
                ", exprStatus=" + exprStatus +
                ", userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", company='" + company + '\'' +
                ", code='" + code + '\'' +
                ", inTime=" + inTime +
                ", outTime=" + outTime +
                ", sysPhone='" + sysPhone + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExprSno() {
        return exprSno;
    }

    public void setExprSno(String exprSno) {
        this.exprSno = exprSno;
    }

    public Integer getExprStatus() {
        return exprStatus;
    }

    public void setExprStatus(Integer exprStatus) {
        if (statusView.equals("未签收"))
            exprStatus = 0;
        if (statusView.equals("已签收"))
            exprStatus = 1;
        if (statusView.equals("拒签"))
            exprStatus = 2;
        this.exprStatus = exprStatus;
    }

    public String getStatusView() {
        if (exprStatus==0)
            statusView = "未签收";
        if (exprStatus == 1)
            statusView = "已签收";
        if (exprStatus == 2)
            statusView = "拒签";
        return statusView;
    }

    public void setStatusView(String statusView) {
        this.statusView = statusView;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    public String getSysPhone() {
        return sysPhone;
    }

    public void setSysPhone(String sysPhone) {
        this.sysPhone = sysPhone;
    }
}
