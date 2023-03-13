package gov.iti.jets.entity;

import jakarta.persistence.*;

@Entity(name = "student")
@Table(name = "student", schema = "lab3.2")
public class Student extends Person {

    @Column(name = "dept")
    private String department;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Student{" +
                "department='" + department + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
