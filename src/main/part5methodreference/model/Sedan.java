package main.part5methodreference.model;

public class Sedan extends Car {

    public Sedan(String name, String brand) {
        super(name, brand);
    }

    public void drive() {
        System.out.println("Driving a Sedan" + name + " from " + brand);
    }
}
