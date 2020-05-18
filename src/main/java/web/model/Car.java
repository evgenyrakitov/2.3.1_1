package web.model;


import org.springframework.beans.factory.annotation.Autowired;


public class Car {

    private String model;

    private String color;

    private String number;

    public Car(String model, String color, String number) {
        this.model = model;
        this.color = color;
        this.number = number;
    }


    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public String getNumber() {
        return number;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return this.getModel();
    }
}
