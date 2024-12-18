package main.part5methodreference.model;

public abstract class Car {
    protected String name;
    protected String brand;

    public Car(String name, String brand) {
        this.name = name;
        this.brand = brand;
    }

    public abstract void drive();
}
