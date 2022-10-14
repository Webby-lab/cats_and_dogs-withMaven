package groomery.groomerywithmaven.models;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Dog extends Pet{
    private static AtomicInteger idGenerator = new AtomicInteger(1);
    private Integer id;
    private String name;
    private int age;
    private String gender;
    private Owner owner;
    private int social;
    private List<Allergy> allergies = new ArrayList<>();

    public Dog() {
        this.id = idGenerator.getAndIncrement();
    }

    public Dog(String name, int age, String gender, List<Allergy> allergies) {
        this.id = idGenerator.getAndIncrement();
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.allergies = allergies;
    }
    public Dog(String name, int age, String gender, Owner owner, List<Allergy> allergies) {
        this.id = idGenerator.getAndIncrement();
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.owner = owner;
        this.allergies = allergies;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public int getSocial() {
        return social;
    }

    public void setSocial(int social) {
        this.social = social;
    }

    public List<Allergy> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<Allergy> allergies) {
        this.allergies = allergies;
    }
}
