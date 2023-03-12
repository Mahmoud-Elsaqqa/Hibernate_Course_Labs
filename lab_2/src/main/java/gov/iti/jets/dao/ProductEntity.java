package gov.iti.jets.dao;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "product", schema = "biddingschema", catalog = "")
public class ProductEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "manufacturing_name")
    private String manufacturingName;
    @Basic
    @Column(name = "manufacturing_date")
    private Date manufacturingDate;
    @Basic
    @Column(name = "expiration_date")
    private Date expirationDate;
    @Basic
    @Column(name = "seller_id")
    private Integer sellerId;
    @Basic
    @Column(name = "quantity")
    private Integer quantity;
    @Basic
    @Column(name = "offered_date")
    private Date offeredDate;
    @Basic
    @Column(name = "finish_date")
    private Date finishDate;
    @OneToMany(mappedBy = "productByProductId")
    private Collection<BuyerBidProductEntity> buyerBidProductsById;
    @OneToMany(mappedBy = "productByProductId")
    private Collection<BuyerBuyProductEntity> buyerBuyProductsById;
    @ManyToOne
    @JoinColumn(name = "seller_id", referencedColumnName = "id", insertable = false, updatable = false)
    private SellerEntity sellerBySellerId;
    @OneToMany(mappedBy = "productByProductId")
    private Collection<ProductHasCategoryEntity> productHasCategoriesById;

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

    public Date getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(Date manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getOfferedDate() {
        return offeredDate;
    }

    public void setOfferedDate(Date offeredDate) {
        this.offeredDate = offeredDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(manufacturingName, that.manufacturingName) && Objects.equals(manufacturingDate, that.manufacturingDate) && Objects.equals(expirationDate, that.expirationDate) && Objects.equals(sellerId, that.sellerId) && Objects.equals(quantity, that.quantity) && Objects.equals(offeredDate, that.offeredDate) && Objects.equals(finishDate, that.finishDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, manufacturingName, manufacturingDate, expirationDate, sellerId, quantity, offeredDate, finishDate);
    }

    public Collection<BuyerBidProductEntity> getBuyerBidProductsById() {
        return buyerBidProductsById;
    }

    public void setBuyerBidProductsById(Collection<BuyerBidProductEntity> buyerBidProductsById) {
        this.buyerBidProductsById = buyerBidProductsById;
    }

    public Collection<BuyerBuyProductEntity> getBuyerBuyProductsById() {
        return buyerBuyProductsById;
    }

    public void setBuyerBuyProductsById(Collection<BuyerBuyProductEntity> buyerBuyProductsById) {
        this.buyerBuyProductsById = buyerBuyProductsById;
    }

    public SellerEntity getSellerBySellerId() {
        return sellerBySellerId;
    }

    public void setSellerBySellerId(SellerEntity sellerBySellerId) {
        this.sellerBySellerId = sellerBySellerId;
    }

    public Collection<ProductHasCategoryEntity> getProductHasCategoriesById() {
        return productHasCategoriesById;
    }

    public void setProductHasCategoriesById(Collection<ProductHasCategoryEntity> productHasCategoriesById) {
        this.productHasCategoriesById = productHasCategoriesById;
    }
}
