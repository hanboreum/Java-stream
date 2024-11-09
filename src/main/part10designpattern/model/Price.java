package main.part10designpattern.model;

public class Price {

    private final String price;

    public Price (String price){
        this.price = price;
    }
    public String getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Price{" +
                "price='" + price + '\'' +
                '}';
    }
}
