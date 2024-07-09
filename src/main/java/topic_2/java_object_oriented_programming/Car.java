package topic_2.java_object_oriented_programming;

import java.time.Year;
import java.util.Arrays;

/* Вариант 1
Разработать класс для хранения информации об автомобилях:
Модель, рег_номер, год_выпуска, пробег, стоимость
и реализовать алгоритм работы с массивом данных объектов, в котором требуется:
–	определить самый дешевый автомобиль;
–	упорядочить массив по убыванию года выпуска;
–	организовать поиск по регистрационному номеру,
    исправление одного из полей и вывод полной информации об автомобиле после редактирования.
* */
public class Car {
    private String model;
    private String regionalNumber;
    private int year;
    private int mileage;
    private double price;

    public Car(String model, String regionalNumber, int year, int mileage, double price) {
        this.model = model;
        if (regionalNumber.length() == 8 || regionalNumber.length() == 9) {
            this.regionalNumber = regionalNumber;
        } else {
            System.out.println(STR."Invalid regional number \{regionalNumber}");
            this.regionalNumber = "undefined";
        } if (year <= 0 || year > Year.now().getValue()) {
            System.out.println(STR."Invalid year \{year}");
            this.year = Year.now().getValue();
        } else {
            this.year = year;
        } if (mileage < 0) {
            System.out.println(STR."Invalid mileage \{mileage}");
        } else {
            this.mileage = mileage;
        } if (price < 0) {
            System.out.println(STR."Invalid price \{price}");
        } else {
            this.price = price;
        }
    }

    public String getModel() {
        return model;
    }
    public String getRegionalNumber() {
        return regionalNumber;
    }
    public int getYear() {
        return year;
    }
    public int getMileage() {
        return mileage;
    }
    public double getPrice() {
        return price;
    }

    protected void setModel(String model) {
        this.model = model;
    }
    public void setRegionalNumber(String regionalNumber) {
        this.regionalNumber = regionalNumber;
    }
    protected void setYear(int year) {
        this.year = year;
    }
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return STR."Car:\n" +
               STR."Model: \{model}\n" +
                STR."Regional Number: \{regionalNumber}\n" +
                STR."Year: \{year}\n" +
                STR."Mileage: \{mileage}\n" +
                STR."Price: \{price}\n";
    }

    public static Car getCheapistCar(Car[] cars) {
        Car cheapistCar = cars[0];
        for (Car car : cars) {
            if (car.getPrice() < cheapistCar.getPrice()) {
                cheapistCar = car;
            }
        }
        return cheapistCar;
    }

    public static void sortArrayByYear(Car[] cars) {
        for (int i = 0; i < cars.length; i++) {
            for (int j = i + 1; j < cars.length; j++) {
                if (cars[i].getYear() < cars[j].getYear()) {
                    Car temp = cars[i];
                    cars[i] = cars[j];
                    cars[j] = temp;
                }
            }
        }
    }

    public static Car findCarByRegisterNumber(Car[] cars, String registerNumber) {
        for (Car car : cars) {
            if (car.regionalNumber.equals(registerNumber)) {
                return car;
            }
        }
        throw new RuntimeException(STR."No such car with registry number \{registerNumber}");
    }

    public static void main(String[] args) {
        Car[] cars = {
                new Car("bmw", "a123bR93", 1999, 10000, 98900.90),
                new Car("mercedes", "F413Ct32", 1997, 9087, 99090.0),
                new Car("lexus", "r895Kw12", 2000, 11390, 87980.79),
        };
        System.out.println(Car.getCheapistCar(cars));
        Car.sortArrayByYear(cars);
        System.out.println(Arrays.toString(cars));
        System.out.println(Car.findCarByRegisterNumber(cars, "F413Ct32"));
    }
}
