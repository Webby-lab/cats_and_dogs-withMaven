package groomery.groomerywithmaven.repositories;

import groomery.groomerywithmaven.models.Dog;

import java.util.List;

public interface DogRepository {
    List<Dog> getAll();
    Dog getById(Integer id);
    void save(Dog dog);
    List<Dog> getByName(String name);
}
