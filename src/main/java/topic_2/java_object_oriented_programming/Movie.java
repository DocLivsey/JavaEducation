package topic_2.java_object_oriented_programming;

import java.time.Year;
import java.util.Arrays;

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
public class Movie implements Comparable<Movie> {
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

    @Override
    public String toString() {
        return STR."\nmovie: " +
                STR."{title=\{this.title}; " +
                STR."year=\{this.year}; " +
                STR."country=\{this.country}; " +
                STR."genre=\{this.genre.name()}; " +
                STR."rental_cost=\{this.rentalCost}}\n";
    }

    @Override
    public int compareTo(Movie anotherMovie) {
        return Integer.compare(this.getYear(), anotherMovie.getYear());
    }

    public static void main(String[] args) {
        Movie[] movies = {
                new Movie("Побег из Шоушенка", 1994, "USA", Genres.ACTION, 7387000),
                new Movie("Крестный отец", 1972, "Italy", Genres.DETECTIVE, 4561000),
                new Movie("Криминальное чтиво", 1994, "USA", Genres.COMEDY, 13707301),
                new Movie("Тёмный рыцарь", 2008, "USA", Genres.FANTASTIC, 10934890),
        };
        System.out.println(Arrays.toString(Movies.rentalCostsAreAboveAverage(movies)));
        Movies.displayAboutEarliestMovie(movies);
        Movies.sortByTitlesInAlphabeticalOrder(movies);
        System.out.println(STR."sorted by year movies \{Arrays.toString(movies)}");
    }
}

class Movies {
    public static Movie[] rentalCostsAreAboveAverage(Movie[] movies) {
        Movie[] areAboveAverage = new Movie[movies.length];
        double average = 0;
        int length = movies.length;
        for (Movie movie: movies) {
            average += movie.getRentalCost();
        }
        average /= length;
        for (int i = 0; i < movies.length; i++) {
            if (movies[i].getRentalCost() > average) {
                areAboveAverage[i] = movies[i];
            }
        }
        return areAboveAverage;
    }

    public static void displayAboutEarliestMovie(Movie[] movies) {
        Movie earliestMovie = movies[0];
        for (int i = 1; i < movies.length; i++) {
            if (movies[i].getYear() < earliestMovie.getYear()) {
                earliestMovie = movies[i];
            }
        }
        System.out.println(STR."Earliest movie is \{earliestMovie}");
    }

    public static void sortByTitlesInAlphabeticalOrder(Movie[] movies) {
        Arrays.sort(movies);
    }
}
