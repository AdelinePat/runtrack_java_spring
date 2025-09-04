package day3.day3.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Person {

    @Id // primary key (unique identifier for each row)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
    private Long id;

    private String name;
    private Integer age;

    public Person() {}

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}