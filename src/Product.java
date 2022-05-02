public class Product {
    private String productName;
    private int discountPercentages;
    private boolean existProduct;
    private int amountOfProduct;
    private double price;
    private String productDescription;

    public Product(String productName, int discountPercentages, boolean existProduct, int amountOfProduct , int price , String productDescription) {
        this.productName = productName;
        this.discountPercentages = discountPercentages;
        this.existProduct = existProduct;
        this.amountOfProduct = amountOfProduct;
        this.price = price;
        this.productDescription = productDescription;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", discountPercentages=" + discountPercentages +
                ", existProduct=" + existProduct +
                ", amountOfProduct=" + amountOfProduct +
                ", price=" + price +
                ", productDescription='" + productDescription + '\'' +
                '}';
    }

    public int getAmountOfProduct() {
        return amountOfProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setExistProduct() {
    }
}

