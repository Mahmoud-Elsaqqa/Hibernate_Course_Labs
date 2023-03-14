package gov.iti.jets;

import gov.iti.jets.entity.Person;
import gov.iti.jets.entity.Student;
import gov.iti.jets.entity.Teacher;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lab3.1");
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


        //Polymorphism
//        cannot resolve Person, Because of Tbale Per Concrete Class Inheritance (No Database Polymorphism)
        String jpql = "SELECT p FROM Person p";

        transaction.begin();
        entityManager.persist(student1);
        entityManager.persist(teacher1);

        //Note The Union Select in SQL Query in the output
        //Select Query:
        TypedQuery<Object> query = entityManager.createQuery(jpql, Object.class);
        List<Object> results = query.getResultList();
        transaction.commit();
        Student st1 = entityManager.find(Student.class,1);
        System.out.println(st1);
   }
}

