package gov.iti.jets.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "teacher")
@Table(name = "teachers", schema = "lab3.2")
public class Teacher extends Person {

    @Column(name = "hire_date")
    private Date hireDate;

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "hireDate=" + hireDate +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
