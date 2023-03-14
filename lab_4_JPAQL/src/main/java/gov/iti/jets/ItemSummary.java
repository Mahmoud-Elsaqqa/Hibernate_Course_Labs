package gov.iti.jets;

public class ItemSummary {
    String name;
    String productDescription;
    String categoryDescription;

    public ItemSummary(String name, String productDescription, String categoryDescription) {
        this.name = name;
        this.productDescription = productDescription;
        this.categoryDescription = categoryDescription;
    }

    @Override
    public String toString() {
        return "ItemSummary{" +
                "name='" + name + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", categoryDescription='" + categoryDescription + '\'' +
                '}';
    }
}
