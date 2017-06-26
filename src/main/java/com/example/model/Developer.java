package com.example.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created on 22.06.2017
 *
 * @author Roman Hayda
 */

@Entity
@Table(name = "developers", catalog = "modelslist")
public class Developer extends Person {

    @Column(name = "specialty", nullable = false)
    @NotEmpty
    private String specialty;

    @Column(name = "experience")
    @NotNull
    private int experience;

    @Column(name = "salary")
    @NotNull
    private int salary;

    public Developer(){}

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", specialty='" + specialty + '\'' +
                ", experience=" + experience +
                ", salary=" + salary +
                '}';
    }
}
