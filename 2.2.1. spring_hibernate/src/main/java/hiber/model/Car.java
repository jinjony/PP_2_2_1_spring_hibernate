package hiber.model;

import javax.persistence.*;

//2. Создайте сущность Car с полями String model и int series, на которую будет ссылаться User с помощью связи one-to-one

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue
    private int series;

    @Column(name = "model")
    private String model;

    public Car() {
    }

    public Car(String model) {
        setModel(model);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return "Car: \n" +
                "series = " + series + "\n" +
                "model = " + model + '\n';
    }
}