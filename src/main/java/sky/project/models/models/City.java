package sky.project.models.models;

import java.util.Objects;

public class City {
    String city_name;
    Integer id;

    public City(String name) {
        this.city_name = name;
    }

    public City(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(city_name, city.city_name);
    }

    public Integer getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(city_name);
    }

    @Override
    public String toString() {
        return " " + city_name;
    }
}
