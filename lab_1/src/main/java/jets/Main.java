package jets;

import jets.dao.AccountEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lab1");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        AccountEntity c = entityManager.find(AccountEntity.class, 2);
        AccountEntity c2 = new AccountEntity();
        c2.setUserName("JPA1");
        c2.setFullName("JPA1");
        c2.setPassword("JPA1");
        entityManager.getTransaction().begin();
        entityManager.persist(c2);
        entityManager.getTransaction().commit();

    }
}
