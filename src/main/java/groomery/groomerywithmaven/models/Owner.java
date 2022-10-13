package groomery.groomerywithmaven.models;

import java.util.concurrent.atomic.AtomicInteger;

public class Owner {
    private static AtomicInteger idGenerator = new AtomicInteger(1);
    private Integer id;
    private String name;
    private String email;
    private String phoneNumber;


    public Owner() {
        this.id = idGenerator.getAndIncrement();
    }

    public Owner(String name) {
        this.id = idGenerator.getAndIncrement();
        this.name = name;
    }

    public Owner(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    @Override
    public String toString() {
        return name;
    }
}
