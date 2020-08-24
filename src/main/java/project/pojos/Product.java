package project.pojos;

import java.util.Objects;

public class Product {

    private String description;
    private String price;

    public Product(){
        this.description = "";
        this.price = "";
    }

    public Product(String description, String price){
        this.description = description;
        this.price = price;
    }

    public String getDescription(){
        return description;
    }

    public String getPrice(){
        return price;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setPrice(String price){
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductDetails{" +
                "description='" + description + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product that = (Product) o;
        return Objects.equals(description, that.description) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, price);
    }
}
