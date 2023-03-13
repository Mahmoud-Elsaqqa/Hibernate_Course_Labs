package gov.iti.jets.entity;

import jakarta.persistence.*;

@Entity(name = "student")
@Table(name = "student", schema = "lab3.3")
public class Student extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Column(name = "dept")
    private String department;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
