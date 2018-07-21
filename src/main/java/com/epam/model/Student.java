package com.epam.model;

import com.epam.annotation.ForeignKey;
import com.epam.annotation.PrimaryKey;
import com.epam.annotation.SimpleAttribute;
import com.epam.annotation.Table;

@Table
public class Student {

    @PrimaryKey(name = "stud_id")
    private int studentId;

    @SimpleAttribute(name = "stud_fname")
    private String firstName;

    @SimpleAttribute(name = "stud_lname")
    private String lastName;

    @SimpleAttribute(name = "stud_middle_name")
    private String middleName;

    @SimpleAttribute(name = "stud_phone_number")
    private String phoneNumber;

    @ForeignKey(name = "pass_serial_number")
    private int passSerialNumber;

    @ForeignKey(name = "gb_number")
    private int gradebookNumber;

    public Student() {
    }

    public Student(int studentId, String firstName, String lastName, String middleName, String phoneNumber, int passSerialNumber, int gradebookNumber) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.phoneNumber = phoneNumber;
        this.passSerialNumber = passSerialNumber;
        this.gradebookNumber = gradebookNumber;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getPassSerialNumber() {
        return passSerialNumber;
    }

    public void setPassSerialNumber(int passSerialNumber) {
        this.passSerialNumber = passSerialNumber;
    }

    public int getGradebookNumber() {
        return gradebookNumber;
    }

    public void setGradebookNumber(int gradebookNumber) {
        this.gradebookNumber = gradebookNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (studentId != student.studentId) return false;
        if (passSerialNumber != student.passSerialNumber) return false;
        if (gradebookNumber != student.gradebookNumber) return false;
        if (!firstName.equals(student.firstName)) return false;
        if (!lastName.equals(student.lastName)) return false;
        if (!middleName.equals(student.middleName)) return false;
        return phoneNumber.equals(student.phoneNumber);
    }

    @Override
    public int hashCode() {
        int result = studentId;
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + middleName.hashCode();
        result = 31 * result + phoneNumber.hashCode();
        result = 31 * result + passSerialNumber;
        result = 31 * result + gradebookNumber;
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", passSerialNumber=" + passSerialNumber +
                ", gradebookNumber=" + gradebookNumber +
                '}';
    }
}
