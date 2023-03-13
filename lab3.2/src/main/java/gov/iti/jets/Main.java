package gov.iti.jets;

import gov.iti.jets.entity.Person;
import gov.iti.jets.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lab3.2");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        Student student1 = new Student();
        //f_name and l_name attributes are inherited from Person Class
        student1.setFirstName("Ahmed");
        student1.setLastName("fathy");
        student1.setDepartment("science");

        //Polymorphism
        Person student2 = new Student();

        transaction.begin();
        entityManager.persist(student1);
        student2 = entityManager.find(Person.class,1);
        transaction.commit();
        System.out.println(student2);
    }
}

