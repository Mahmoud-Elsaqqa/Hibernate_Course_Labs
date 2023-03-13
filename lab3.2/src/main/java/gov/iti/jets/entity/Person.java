package gov.iti.jets.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Person", schema = "lab3.2")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @TableGenerator(table = "my_sequences", name = "testGenerator")
    private Integer id;

    @Column(name = "f_name")
    protected String firstName;

    @Column(name = "l_name")
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
