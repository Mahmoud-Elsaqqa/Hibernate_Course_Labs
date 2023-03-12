package gov.iti.jets;

import gov.iti.jets.dao.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lab2");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        UserEntity userEntity1 = new UserEntity();
        userEntity1.setUserName("Mahmoud");
        userEntity1.setAddress("Cairo");
        userEntity1.setEmail("M@gmail.com");
        userEntity1.setDateOfBirth(new Date());
        userEntity1.setFullName("Mahmoud Mohamed");
        userEntity1.setMobile("01005812889");
        userEntity1.setPassword("P@assw0rd");
        userEntity1.setRegistrationDate(new Date());
        userEntity1.setBuyersById(new HashSet<BuyerEntity>());


        UserEntity userEntity2 = new UserEntity();
        userEntity2.setUserName("Ahmed");
        userEntity2.setAddress("Alex");
        userEntity2.setEmail("M2@gmail.com");
        userEntity2.setDateOfBirth(new Date());
        userEntity2.setFullName("Ahmed Mohamed");
        userEntity2.setMobile("01005812988");
        userEntity2.setPassword("P@assw0rd2");
        userEntity2.setRegistrationDate(new Date());
        userEntity2.setBuyersById(new HashSet<BuyerEntity>());


        SellerEntity sellerEntity1 = new SellerEntity();
        sellerEntity1.setUserById(userEntity1);
        sellerEntity1.setValue(userEntity1.getUserName() + " Electronics Store");
        sellerEntity1.setProductsById(new ArrayList<ProductEntity>());

        BuyerEntity buyerEntity1 = new BuyerEntity();
        buyerEntity1.setValue("geek");
        buyerEntity1.setUserByUserId(userEntity2);
        buyerEntity1.setBuyerBidProductsById(new ArrayList<BuyerBidProductEntity>());
        buyerEntity1.setBuyerBuyProductsById(new ArrayList<BuyerBuyProductEntity>());
        userEntity2.getBuyersById().add(buyerEntity1);


        CategoryEntity categoryEntity1 = new CategoryEntity();
        categoryEntity1.setDescription("smart phones");
        categoryEntity1.setValue("Mobiles");
        categoryEntity1.setProductHasCategoriesById(new HashSet<ProductHasCategoryEntity>());

        CategoryEntity categoryEntity2 = new CategoryEntity();
        categoryEntity2.setDescription("Laptops");
        categoryEntity2.setValue("Computers");
        categoryEntity2.setProductHasCategoriesById(new HashSet<ProductHasCategoryEntity>());

        ProductEntity productEntity1 = new ProductEntity();
        productEntity1.setName("Phone");
        productEntity1.setDescription("Smart Phone");
        productEntity1.setExpirationDate(new Date());
        productEntity1.setManufacturingDate(new Date());
        productEntity1.setFinishDate(new Date());
        productEntity1.setManufacturingName("Apple");
        productEntity1.setQuantity(2);
        productEntity1.setSellerBySellerId(sellerEntity1);
        productEntity1.setProductHasCategoriesById(new HashSet<ProductHasCategoryEntity>());
        productEntity1.setBuyerBuyProductsById(new ArrayList<BuyerBuyProductEntity>());
        productEntity1.setBuyerBidProductsById(new ArrayList<BuyerBidProductEntity>());


        ProductEntity productEntity2 = new ProductEntity();
        productEntity2.setName("Macbook pro");
        productEntity2.setDescription("Computer");
        productEntity2.setExpirationDate(new Date());
        productEntity2.setManufacturingDate(new Date());
        productEntity2.setFinishDate(new Date());
        productEntity2.setManufacturingName("Apple");
        productEntity2.setQuantity(3);
        productEntity2.setSellerBySellerId(sellerEntity1);
        productEntity2.setProductHasCategoriesById(new HashSet<ProductHasCategoryEntity>());
        productEntity2.setBuyerBuyProductsById(new ArrayList<BuyerBuyProductEntity>());
        productEntity2.setBuyerBidProductsById(new ArrayList<BuyerBidProductEntity>());


        ProductHasCategoryEntity productHasCategoryEntity1 = new ProductHasCategoryEntity();
        productHasCategoryEntity1.setProductByProductId(productEntity1);
        productHasCategoryEntity1.setCategoryByCategoryId(categoryEntity1);
        productEntity1.getProductHasCategoriesById().add(productHasCategoryEntity1);
        categoryEntity1.getProductHasCategoriesById().add(productHasCategoryEntity1);
//


        transaction.begin();
        entityManager.persist(userEntity1);
        entityManager.persist(userEntity2);
        entityManager.persist(sellerEntity1);
        entityManager.persist(buyerEntity1);
        entityManager.persist(categoryEntity1);
        entityManager.persist(categoryEntity2);
        entityManager.persist(productEntity1);
        entityManager.persist(productEntity2);
//        entityManager.persist(productHasCategoryEntity1);
//        entityManager.persist(productHasCategoryEntity2);

        transaction.commit();

    }
}
