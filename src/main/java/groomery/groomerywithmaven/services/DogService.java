package groomery.groomerywithmaven.services;

import groomery.groomerywithmaven.models.Allergy;
import groomery.groomerywithmaven.models.Dog;

import java.util.List;

public interface DogService {
    List<Dog> sortedDogs(String sortedBy, Boolean isAsc);
    List<Dog> filterByAllargies(List<Dog> dogs, Allergy allergy);
    List<Dog> getAll();
    Dog getById(Integer id);
    void save(Dog dog);
    List<Dog> getByName(String name);
}
