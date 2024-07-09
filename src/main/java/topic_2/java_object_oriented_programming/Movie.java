package topic_2.java_object_oriented_programming;

import java.time.Year;

/* Вариант 2
Разработать класс для хранения информации о фильмах:
Название_фильма, год_выпуска, страна, жанр, стоимость_проката
и реализовать алгоритм работы с массивом данных объектов, в котором требуется:
–	определить фильмы, стоимость проката которых выше средней;
–	вывести информацию о фильме самого раннего года выпуска;
–	упорядочить массив по названиям фильмов в алфавитном порядке;
–	организовать поиск по названию, исправление одного из полей
    и вывод полной информации о фильме после редактирования.
* */
public class Movie {
    public enum Genres {
        COMEDY,
        CARTOON,
        HORROR,
        FANTASTIC,
        THRILLER,
        ACTION,
        MELODRAMA,
        DETECTIVE,
    }

    private String title;
    private int year;
    private String country;
    private Genres genre;
    private double rentalCost;

    public Movie(String title, int year, String country, Genres genre, double rentalCost) {
        this.title = title;
        if (year < 0 || year > Year.now().getValue()) {
            System.out.println(STR."Invalid year \{year}");
            this.year = Year.now().getValue();
        } else {
            this.year = year;
        }
        this.country = country;
        this.genre = genre;
        if (rentalCost < 0.0) {
            System.out.println(STR."Invalid rental cost \{rentalCost}");
            this.rentalCost = 0;
        } else {
            this.rentalCost = rentalCost;
        }
    }

    public String getTitle() {
        return title;
    }
    public int getYear() {
        return year;
    }
    public String getCountry() {
        return country;
    }
    public Genres getGenre() {
        return genre;
    }
    public double getRentalCost() {
        return rentalCost;
    }

    protected void setTitle(String title) {
        this.title = title;
    }
    protected void setYear(int year) {
        if (year < 0 || year > Year.now().getValue()) {
            System.out.println(STR."Invalid year \{year}");
            this.year = Year.now().getValue();
        } else {
            this.year = year;
        }
    }
    protected void setCountry(String country) {
        this.country = country;
    }
    protected void setGenre(Genres genre) {
        this.genre = genre;
    }
    public void setRentalCost(double rentalCost) {
        if (rentalCost < 0.0) {
            System.out.println(STR."Invalid rental cost \{rentalCost}");
            this.rentalCost = 0;
        } else {
            this.rentalCost = rentalCost;
        }
    }

    public static void main(String[] args) {

    }
}

class Movies {

}
