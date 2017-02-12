package org.nskhu.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserForm {

    private String name;

    private String password;

    private String phoneNumber;

    private Integer birthDay;

    private Integer birthMonth;

    private Integer birthYear;

    private BigDecimal monthlySalary;

    private BigDecimal liabilities;

    private Boolean isBirthDateEdited;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(int birthDay) {
        this.birthDay = birthDay;
    }

    public Integer getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public BigDecimal getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(BigDecimal monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public BigDecimal getLiabilities() {
        return liabilities;
    }

    public void setLiabilities(BigDecimal liabilities) {
        this.liabilities = liabilities;
    }

    public Boolean getBirthDateEdited() {
        return isBirthDateEdited;
    }

    public void setBirthDateEdited(Boolean birthDateEdited) {
        isBirthDateEdited = birthDateEdited;
    }

    public static UserForm withUser(User user) {
        UserForm uf = new UserForm();
        uf.setName(user.getName());
        uf.setPhoneNumber(user.getPhoneNumber());
        uf.setMonthlySalary(user.getMonthlySalary());
        uf.setLiabilities(user.getLiabilities());
        uf.setBirthDay(user.getBirthDay());
        uf.setBirthMonth(user.getBirthMonth());
        uf.setBirthYear(user.getBirthYear());
        uf.setBirthDateEdited(user.isBirthdayChanged());
        return uf;
    }

}
