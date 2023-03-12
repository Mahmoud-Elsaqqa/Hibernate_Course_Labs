package gov.iti.jets.dao;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "buyer", schema = "biddingschema", catalog = "")
public class BuyerEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "value")
    private String value;
    @Basic
    @Column(name = "user_id", insertable = false, updatable = false)
    private Integer userId;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false,insertable=false, updatable=false)
    private UserEntity userByUserId;
    @OneToMany(mappedBy = "buyerByBuyerId")
    private Collection<BuyerBidProductEntity> buyerBidProductsById;
    @OneToMany(mappedBy = "buyerByBuyerId")
    private Collection<BuyerBuyProductEntity> buyerBuyProductsById;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuyerEntity that = (BuyerEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(value, that.value) && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value, userId);
    }

    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
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
}
