package gov.iti.jets;

import gov.iti.jets.entity.Person;
import gov.iti.jets.entity.Student;
import gov.iti.jets.entity.Teacher;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lab3.4");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        Student student1 = new Student();
        //f_name and l_name attributes are inherited from Person Class
        student1.setFirstName("Ahmed");
        student1.setLastName("fathy");
        student1.setDepartment("science");

        Teacher teacher1 = new Teacher();
        //f_name and l_name attributes are inherited from Person Class
        teacher1.setFirstName("Ali");
        teacher1.setLastName("Sobhy");
        teacher1.setHireDate(new Date());


        //Only One Table and Only one Select Query
        String jpql = "SELECT p FROM Person p";

        transaction.begin();
        entityManager.persist(student1);
        entityManager.persist(teacher1);

        //Note That only one select query is performed on only on table "Person Table"
        TypedQuery<Person> query = entityManager.createQuery(jpql, Person.class);
        List<Person> results = query.getResultList();
        //Select Query:
        transaction.commit();
        System.out.println(results);
    }
}

