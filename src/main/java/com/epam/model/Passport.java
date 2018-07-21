package com.epam.model;

import com.epam.annotation.PrimaryKey;
import com.epam.annotation.SimpleAttribute;
import com.epam.annotation.Table;

import java.sql.Date;

@Table
public class Passport {

    @PrimaryKey(name = "pass_serial_number")
    private int serialNumber;

    @SimpleAttribute(name = "gender")
    private String gender;

    @SimpleAttribute(name = "date_of_birth")
    private Date dateOfBirth;

    @SimpleAttribute(name = "father_or_mother_full_name")
    private String fatherOrMotherFullName;

    @SimpleAttribute(name = "address")
    private String address;

    public Passport() {
    }

    public Passport(int serialNumber, String gender, Date dateOfBirth, String fatherOrMotherFullName, String address) {
        this.serialNumber = serialNumber;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.fatherOrMotherFullName = fatherOrMotherFullName;
        this.address = address;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFatherOrMotherFullName() {
        return fatherOrMotherFullName;
    }

    public void setFatherOrMotherFullName(String fatherOrMotherFullName) {
        this.fatherOrMotherFullName = fatherOrMotherFullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Passport passport = (Passport) o;

        if (serialNumber != passport.serialNumber) return false;
        if (!gender.equals(passport.gender)) return false;
        if (!dateOfBirth.equals(passport.dateOfBirth)) return false;
        if (!fatherOrMotherFullName.equals(passport.fatherOrMotherFullName)) return false;
        return address.equals(passport.address);
    }

    @Override
    public int hashCode() {
        int result = serialNumber;
        result = 31 * result + gender.hashCode();
        result = 31 * result + dateOfBirth.hashCode();
        result = 31 * result + fatherOrMotherFullName.hashCode();
        result = 31 * result + address.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "serialNumber=" + serialNumber +
                ", gender='" + gender + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", fatherOrMotherFullName='" + fatherOrMotherFullName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
