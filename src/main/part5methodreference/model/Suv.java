package main.part5methodreference.model;

public class Suv extends Car {

    public Suv(String name, String brand) {
        super(name, brand);
    }

    public void drive() {
        System.out.println("Driving SUV" + name + " from " + brand);
    }
}
