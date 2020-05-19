package crud.model;


import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "color")
    private String color;

    @Column(name = "tipe")
    private String tipe;

    public Car() {}

    public Car(String model, String color, String tipe) {
        this.model = model;
        this.color = color;
        this.tipe = tipe;
    }

    public Car(Long id,String model, String color, String tipe) {
        this.id = id;
        this.model = model;
        this.color = color;
        this.tipe = tipe;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }


}
