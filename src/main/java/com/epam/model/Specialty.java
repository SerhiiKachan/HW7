package com.epam.model;

import com.epam.annotation.PrimaryKey;
import com.epam.annotation.SimpleAttribute;
import com.epam.annotation.Table;

@Table
public class Specialty {

    @PrimaryKey(name = "spec_id")
    private int specialtyId;

    @SimpleAttribute(name = "spec_name")
    private String name;

    @SimpleAttribute(name = "spec_description")
    private String description;

    public Specialty() {
    }

    public Specialty(int specialtyId, String name, String description) {
        this.specialtyId = specialtyId;
        this.name = name;
        this.description = description;
    }

    public int getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(int specialtyId) {
        this.specialtyId = specialtyId;
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

        Specialty specialty = (Specialty) o;

        if (specialtyId != specialty.specialtyId) return false;
        if (!name.equals(specialty.name)) return false;
        return description.equals(specialty.description);
    }

    @Override
    public int hashCode() {
        int result = specialtyId;
        result = 31 * result + name.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Specialty{" +
                "specialtyId=" + specialtyId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
