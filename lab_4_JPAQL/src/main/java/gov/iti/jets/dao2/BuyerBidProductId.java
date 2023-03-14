package gov.iti.jets.dao2;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BuyerBidProductId implements Serializable {
    private static final long serialVersionUID = -8511206422195701169L;
    @Column(name = "buyer_id", nullable = false)
    private Integer buyerId;

    @Column(name = "product_id", nullable = false)
    private Integer productId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BuyerBidProductId entity = (BuyerBidProductId) o;
        return Objects.equals(this.productId, entity.productId) &&
                Objects.equals(this.buyerId, entity.buyerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, buyerId);
    }

}