package org.nskhu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String password;

    private String phoneNumber;

    private Integer birthDay;

    private Integer birthMonth;

    private Integer birthYear;

    private BigDecimal monthlySalary;

    private BigDecimal liabilities;

    private boolean birthdayChanged;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public boolean isBirthdayChanged() {
        return birthdayChanged;
    }

    public void setBirthdayChanged(boolean birthdayChanged) {
        this.birthdayChanged = birthdayChanged;
    }

}
