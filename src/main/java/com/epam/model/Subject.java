package com.epam.model;

import com.epam.annotation.PrimaryKey;
import com.epam.annotation.SimpleAttribute;
import com.epam.annotation.Table;

@Table
public class Subject {

    @PrimaryKey(name = "sub_id")
    private int subjectId;

    @SimpleAttribute(name = "sub_name")
    private String name;

    @SimpleAttribute(name = "sub_description")
    private String description;

    public Subject() {
    }

    public Subject(int subjectId, String name, String description) {
        this.subjectId = subjectId;
        this.name = name;
        this.description = description;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subject subject = (Subject) o;

        if (subjectId != subject.subjectId) return false;
        if (!name.equals(subject.name)) return false;
        return description.equals(subject.description);
    }

    @Override
    public int hashCode() {
        int result = subjectId;
        result = 31 * result + name.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectId=" + subjectId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
