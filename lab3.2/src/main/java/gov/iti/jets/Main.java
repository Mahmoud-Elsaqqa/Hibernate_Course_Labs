package gov.iti.jets;

import gov.iti.jets.entity.Person;
import gov.iti.jets.entity.Student;
import gov.iti.jets.entity.Teacher;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

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

        Teacher teacher1 = new Teacher();
        //f_name and l_name attributes are inherited from Person Class
        teacher1.setFirstName("Ali");
        teacher1.setLastName("Sobhy");
        teacher1.setHireDate(new Date());


        //Polymorphism
        String jpql = "SELECT p FROM Person p";

        transaction.begin();
        entityManager.persist(student1);
        entityManager.persist(teacher1);

        //Note The Union Select in SQL Query in the output
        TypedQuery<Person> query = entityManager.createQuery(jpql, Person.class);
        List<Person> results = query.getResultList();
        //Select Query:
        /*
        select
        p1_0.id,
                p1_0.clazz_,
                p1_0.f_name,
                p1_0.l_name,
                p1_0.dept,
                p1_0.hire_date
        from
                ( select
                        id,
                        f_name,
                        l_name,
                        null as dept,
                        null as hire_date,
                        0 as clazz_
                        from
                        Person
                        union
                        all select
                        id,
                        f_name,
                        l_name,
                        dept,
                        null as hire_date,
                        1 as clazz_
                        from
                        student
                        union
                        all select
                        id,
                        f_name,
                        l_name,
                        null as dept,
                        hire_date,
                        2 as clazz_
                        from
                        teachers
                )

         */

        transaction.commit();
        System.out.println(results);
    }
}

