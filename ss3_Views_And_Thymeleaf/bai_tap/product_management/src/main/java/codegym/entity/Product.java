package codegym.entity;

public class Product {
    private String id;
    private String product_name;
    private double product_price;
    private String product_describe;
    private String producer;

    public Product() {
    }

    public Product(String id, String product_name, double product_price, String product_describe, String producer) {
        this.id = id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_describe = product_describe;
        this.producer = producer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }

    public String getProduct_describe() {
        return product_describe;
    }

    public void setProduct_describe(String product_describe) {
        this.product_describe = product_describe;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
