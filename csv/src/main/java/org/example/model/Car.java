package org.example.model;

public class Car {

    private int yearOfIssue;
    private String name;
    private String model;
    private String description;
    private int price;

    public Car() {
    }

    public Car(int yearOfIssue, String name, String model, String description, int price) {
        this.yearOfIssue = yearOfIssue;
        this.name = name;
        this.model = model;
        this.description = description;
        this.price = price;
    }

    public int getYearOfIssue() {
        return yearOfIssue;
    }

    public void setYearOfIssue(int yearOfIssue) {
        this.yearOfIssue = yearOfIssue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return yearOfIssue + "," + name + "," + model + "," + description + "," + price;
    }

    public static Car buildCar(String[] carAsArrayStrings) {
        return new Car(
                Integer.parseInt(carAsArrayStrings[0]),
                carAsArrayStrings[1],
                carAsArrayStrings[2],
                carAsArrayStrings[3],
                Integer.parseInt(carAsArrayStrings[4])
        );
    }
}
