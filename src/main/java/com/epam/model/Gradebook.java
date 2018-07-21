package com.epam.model;

import com.epam.annotation.ForeignKey;
import com.epam.annotation.PrimaryKey;
import com.epam.annotation.SimpleAttribute;
import com.epam.annotation.Table;

import java.sql.Date;

@Table
public class Gradebook {

    @PrimaryKey(name = "gb_number")
    private int gbNumber;

    @SimpleAttribute(name = "date_of_admission")
    private Date dateOfAdmission;

    @SimpleAttribute(name = "st_group")
    private String studGroup;

    @SimpleAttribute(name = "course")
    private int course;

    @SimpleAttribute(name = "form_of_education")
    private String formOfEducation;

    @ForeignKey(name = "spec_id")
    private int specialtyId;

    public Gradebook() {
    }

    public Gradebook(int gbNumber, Date dateOfAdmission, String studGroup, int course, String formOfEducation, int specialtyId) {
        this.gbNumber = gbNumber;
        this.dateOfAdmission = dateOfAdmission;
        this.studGroup = studGroup;
        this.course = course;
        this.formOfEducation = formOfEducation;
        this.specialtyId = specialtyId;
    }

    public int getGbNumber() {
        return gbNumber;
    }

    public void setGbNumber(int gbNumber) {
        this.gbNumber = gbNumber;
    }

    public Date getDateOfAdmission() {
        return dateOfAdmission;
    }

    public void setDateOfAdmission(Date dateOfAdmission) {
        this.dateOfAdmission = dateOfAdmission;
    }

    public String getStudGroup() {
        return studGroup;
    }

    public void setStudGroup(String studGroup) {
        this.studGroup = studGroup;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getFormOfEducation() {
        return formOfEducation;
    }

    public void setFormOfEducation(String formOfEducation) {
        this.formOfEducation = formOfEducation;
    }

    public int getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(int specialtyId) {
        this.specialtyId = specialtyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gradebook gradebook = (Gradebook) o;

        if (gbNumber != gradebook.gbNumber) return false;
        if (course != gradebook.course) return false;
        if (specialtyId != gradebook.specialtyId) return false;
        if (!dateOfAdmission.equals(gradebook.dateOfAdmission)) return false;
        if (!studGroup.equals(gradebook.studGroup)) return false;
        return formOfEducation.equals(gradebook.formOfEducation);
    }

    @Override
    public int hashCode() {
        int result = gbNumber;
        result = 31 * result + dateOfAdmission.hashCode();
        result = 31 * result + studGroup.hashCode();
        result = 31 * result + course;
        result = 31 * result + formOfEducation.hashCode();
        result = 31 * result + specialtyId;
        return result;
    }

    @Override
    public String toString() {
        return "Gradebook{" +
                "gbNumber=" + gbNumber +
                ", dateOfAdmission=" + dateOfAdmission +
                ", studGroup='" + studGroup + '\'' +
                ", course=" + course +
                ", formOfEducation='" + formOfEducation + '\'' +
                ", specialtyId=" + specialtyId +
                '}';
    }
}
