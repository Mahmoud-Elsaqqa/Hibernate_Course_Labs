package gov.iti.jets.dao;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "category", schema = "biddingschema", catalog = "")
public class CategoryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "value")
    private String value;
    @Basic
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "categoryByCategoryId")
    private Collection<ProductHasCategoryEntity> productHasCategoriesById;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryEntity that = (CategoryEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(value, that.value) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value, description);
    }

    public Collection<ProductHasCategoryEntity> getProductHasCategoriesById() {
        return productHasCategoriesById;
    }

    public void setProductHasCategoriesById(Collection<ProductHasCategoryEntity> productHasCategoriesById) {
        this.productHasCategoriesById = productHasCategoriesById;
    }
}
