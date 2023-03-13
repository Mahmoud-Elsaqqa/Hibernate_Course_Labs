package gov.iti.jets.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Person", schema = "lab3.3")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "person_type")
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    @Column(name = "f_name", nullable = false)
    protected String firstName;

    @Column(name = "l_name", nullable = false)
    protected String lastName;

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

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
