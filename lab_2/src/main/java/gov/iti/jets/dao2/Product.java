package gov.iti.jets.dao2;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "description", length = 150)
    private String description;

    @Column(name = "manufacturing_name", nullable = false, length = 100)
    private String manufacturingName;

    @Column(name = "manufacturing_date", nullable = false)
    private LocalDate manufacturingDate;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id")
    private Seller seller;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "offered_date", nullable = false)
    private LocalDate offeredDate;

    @Column(name = "finish_date", nullable = false)
    private LocalDate finishDate;

    @OneToMany(mappedBy = "product")
    private Set<BuyerBuyProduct> buyerBuyProducts = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "product_has_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new LinkedHashSet<>();

    @OneToMany(mappedBy = "product")
    private Set<BuyerBidProduct> buyerBidProducts = new LinkedHashSet<>();



    

    public Product(String name, String description, String manufacturingName, LocalDate manufacturingDate,
            LocalDate expirationDate, Seller seller, Integer quantity, LocalDate offeredDate, LocalDate finishDate) {
        this.name = name;
        this.description = description;
        this.manufacturingName = manufacturingName;
        this.manufacturingDate = manufacturingDate;
        this.expirationDate = expirationDate;
        this.seller = seller;
        this.quantity = quantity;
        this.offeredDate = offeredDate;
        this.finishDate = finishDate;
    }

    public Product() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturingName() {
        return manufacturingName;
    }

    public void setManufacturingName(String manufacturingName) {
        this.manufacturingName = manufacturingName;
    }

    public LocalDate getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(LocalDate manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDate getOfferedDate() {
        return offeredDate;
    }

    public void setOfferedDate(LocalDate offeredDate) {
        this.offeredDate = offeredDate;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }

    public Set<BuyerBuyProduct> getBuyerBuyProducts() {
        return buyerBuyProducts;
    }

    public void setBuyerBuyProducts(Set<BuyerBuyProduct> buyerBuyProducts) {
        this.buyerBuyProducts = buyerBuyProducts;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Set<BuyerBidProduct> getBuyerBidProducts() {
        return buyerBidProducts;
    }

    public void setBuyerBidProducts(Set<BuyerBidProduct> buyerBidProducts) {
        this.buyerBidProducts = buyerBidProducts;
    }

}