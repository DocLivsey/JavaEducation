package topic_2.java_object_oriented_programming;

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
    private String title;
    private int year;
    private String country;
    private String genre;
    private double rentalCost;

    public Movie(String title, int year, String country, String genre, double rentalCost) {
        this.title = title;
        this.year = year;
        this.country = country;
        this.genre = genre;
        this.rentalCost = rentalCost;
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
    public String getGenre() {
        return genre;
    }
    public double getRentalCost() {
        return rentalCost;
    }

    protected void setTitle(String title) {
        this.title = title;
    }
    protected void setYear(int year) {
        this.year = year;
    }
    protected void setCountry(String country) {
        this.country = country;
    }
    protected void setGenre(String genre) {
        this.genre = genre;
    }
    public void setRentalCost(double rentalCost) {
        this.rentalCost = rentalCost;
    }
}
