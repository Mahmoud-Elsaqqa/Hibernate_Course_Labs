package gov.iti.jets;

import gov.iti.jets.dao2.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Main2 {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lab2");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        User user1 = new User();
        user1.setUserName("Mahmoud");
        user1.setAddress("Cairo");
        user1.setEmail("M@gmail.com");
        user1.setDateOfBirth(LocalDate.now());
        user1.setFullName("Mahmoud Mohamed");
        user1.setMobile("01005812889");
        user1.setPassword("P@assw0rd");
        user1.setRegistrationDate(LocalDate.now());

        User user2 = new User();
        user2.setUserName("Ahmed");
        user2.setAddress("Alex");
        user2.setEmail("M2@gmail.com");
        user2.setDateOfBirth(LocalDate.now());
        user2.setFullName("Ahmed Mohamed");
        user2.setMobile("01005812988");
        user2.setPassword("P@assw0rd2");
        user2.setRegistrationDate(LocalDate.now());


        Seller seller1 = new Seller();
        seller1.setUser(user1);
        seller1.setValue(user1.getUserName() + " Electronics Store");


        Buyer buyer1 = new Buyer();
        buyer1.setValue("geek");
        buyer1.setUser(user2);


        Category category1 = new Category();
        category1.setDescription("smart phones");
        category1.setValue("Mobiles");

        Category category2 = new Category();
        category2.setDescription("Laptops");
        category2.setValue("Computers");

        Set<Category> categories = new HashSet<>();
        categories.add(category1);
        categories.add(category2);

        Product product1 = new Product();
        product1.setName("Phone");
        product1.setDescription("Smart Phone");
        product1.setExpirationDate(LocalDate.now());
        product1.setManufacturingDate(LocalDate.now());
        product1.setFinishDate(LocalDate.now());
        product1.setOfferedDate(LocalDate.now());
        product1.setManufacturingName("Apple");
        product1.setQuantity(2);

        Product product2 = new Product();
        product2.setName("Macbook pro");
        product2.setDescription("Computer");
        product2.setExpirationDate(LocalDate.now());
        product2.setManufacturingDate(LocalDate.now());
        product2.setFinishDate(LocalDate.now());
        product2.setOfferedDate(LocalDate.now());
        product2.setManufacturingName("Apple");
        product2.setQuantity(3);

        Set<Product> products = new HashSet<>();
        products.add(product1);
        products.add(product2);

        //Setting Relationship attributes of seller and product
        seller1.setProducts(products);
        product1.setSeller(seller1);
        product2.setSeller(seller1);

        //Setting Relationship attributes of category and product
        category1.setProducts(products);

        BuyerBidProduct buyerBidProduct1 = new BuyerBidProduct();
        buyerBidProduct1.setBuyer(buyer1);
        buyerBidProduct1.setDate(LocalDate.now());
        buyerBidProduct1.setProduct(product1);
        buyerBidProduct1.setQuantity(1);
        buyerBidProduct1.setAmount(100.0F);

        //Setting Relationship attributes of buyer bid product
        //Setting Relationship attributes of buyer buy product

        transaction.begin();
        entityManager.persist(user1);
        entityManager.persist(user2);
        entityManager.persist(seller1);
        entityManager.persist(buyer1);
        entityManager.persist(category1);
        entityManager.persist(category2);
        entityManager.persist(product1);
        entityManager.persist(product2);
        entityManager.persist(buyerBidProduct1);
        transaction.commit();

    }
}
