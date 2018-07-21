package com.epam.model;

import com.epam.annotation.ForeignKey;
import com.epam.annotation.PrimaryKey;
import com.epam.annotation.SimpleAttribute;
import com.epam.annotation.Table;

import java.sql.Date;

@Table
public class Exam {

    @PrimaryKey(name = "exam_id")
    private int examId;

    @ForeignKey(name = "stud_id")
    private int studentId;

    @ForeignKey(name = "sub_id")
    private int subjectId;

    @SimpleAttribute(name = "date_of_exam")
    private Date dateOfExam;

    @SimpleAttribute(name = "stud_mark")
    private int studMark;

    public Exam() {
    }

    public Exam(int examId, int studentId, int subjectId, Date dateOfExam, int studMark) {
        this.examId = examId;
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.dateOfExam = dateOfExam;
        this.studMark = studMark;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public Date getDateOfExam() {
        return dateOfExam;
    }

    public void setDateOfExam(Date dateOfExam) {
        this.dateOfExam = dateOfExam;
    }

    public int getStudMark() {
        return studMark;
    }

    public void setStudMark(int studMark) {
        this.studMark = studMark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Exam exam = (Exam) o;

        if (examId != exam.examId) return false;
        if (studentId != exam.studentId) return false;
        if (subjectId != exam.subjectId) return false;
        if (studMark != exam.studMark) return false;
        return dateOfExam.equals(exam.dateOfExam);
    }

    @Override
    public int hashCode() {
        int result = examId;
        result = 31 * result + studentId;
        result = 31 * result + subjectId;
        result = 31 * result + dateOfExam.hashCode();
        result = 31 * result + studMark;
        return result;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "examId=" + examId +
                ", studentId=" + studentId +
                ", subjectId=" + subjectId +
                ", dateOfExam=" + dateOfExam +
                ", studMark=" + studMark +
                '}';
    }
}
