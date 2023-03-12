package gov.iti.jets.dao;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "buyer_buy_product", schema = "biddingschema", catalog = "")
@IdClass(BuyerBuyProductEntityPK.class)
public class BuyerBuyProductEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "buyer_id")
    private Integer buyerId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "product_id")
    private Integer productId;
    @Basic
    @Column(name = "payment_date")
    private Date paymentDate;
    @Basic
    @Column(name = "amount")
    private Double amount;
    @Basic
    @Column(name = "quantity")
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "buyer_id", referencedColumnName = "id", nullable = false,insertable=false, updatable=false)
    private BuyerEntity buyerByBuyerId;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false,insertable=false, updatable=false)
    private ProductEntity productByProductId;

    public Integer getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuyerBuyProductEntity that = (BuyerBuyProductEntity) o;
        return Objects.equals(buyerId, that.buyerId) && Objects.equals(productId, that.productId) && Objects.equals(paymentDate, that.paymentDate) && Objects.equals(amount, that.amount) && Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buyerId, productId, paymentDate, amount, quantity);
    }

    public BuyerEntity getBuyerByBuyerId() {
        return buyerByBuyerId;
    }

    public void setBuyerByBuyerId(BuyerEntity buyerByBuyerId) {
        this.buyerByBuyerId = buyerByBuyerId;
    }

    public ProductEntity getProductByProductId() {
        return productByProductId;
    }

    public void setProductByProductId(ProductEntity productByProductId) {
        this.productByProductId = productByProductId;
    }
}
