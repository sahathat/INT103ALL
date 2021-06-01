package model;

public class Product {

    private int product_id;
    private Category category;
    private String product_name;
    private String product_description;
    private double product_price;
    private String product_image;

 
    public Product(int product_id, Category category, String product_name, String product_description, double product_price, String product_image) {
        this.product_id = product_id;
        this.category = category;
        this.product_name = product_name;
        this.product_description = product_description;
        this.product_price = product_price;
        this.product_image = product_image;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }

    public String getProduct_image() {
        return product_image;
    }

    public void setProduct_image(String product_image) {
        this.product_image = product_image;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Product{product_id=").append(product_id);
        sb.append(", category=").append(category);
        sb.append(", product_name=").append(product_name);
        sb.append(", product_description=").append(product_description);
        sb.append(", product_price=").append(product_price);
        sb.append(", product_image=").append(product_image);
        sb.append('}');
        return sb.toString();
    }
    

}
