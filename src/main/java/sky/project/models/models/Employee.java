package sky.project.models.models;

import java.util.Objects;

public class Employee {
    private String first_name;
    private String last_name;
    private Integer age;
    private City city;

    public Employee(String firstName, String lastName, Integer age, City city) {
        this.first_name = firstName;
        this.last_name = lastName;
        this.age = age;
        this.city = city;
    }

    public Employee(String first_name, String last_name, Integer age) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
    }

    public Employee() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(first_name, employee.first_name) && Objects.equals(last_name, employee.last_name) && Objects.equals(age, employee.age) && Objects.equals(city, employee.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first_name, last_name, age, city);
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;

    }

    @Override
    public String toString() {
        return first_name + " " + last_name +" "+ age +" "+ city;
    }
}
