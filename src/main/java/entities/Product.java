package entities;

public class Product {

    private String product_type;
    private String product_category;
    private String brand;

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public String getProduct_category() {
        return product_category;
    }

    public void setProduct_category(String product_category) {
        this.product_category = product_category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_type='" + product_type + '\'' +
                ", product_category='" + product_category + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}
