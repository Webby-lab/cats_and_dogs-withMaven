package groomery.groomerywithmaven.repositories;

import groomery.groomerywithmaven.models.Allergy;
import groomery.groomerywithmaven.models.Dog;
import groomery.groomerywithmaven.models.Owner;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DogrepositoryImpl implements DogRepository {

    public List<Dog> dogs = new ArrayList<>
            (Arrays.asList(
                    new Dog("Pityu", 3, "fiú",  new Owner("John", "john@john", "334455"), Arrays.asList(Allergy.GYÓGYSZER)),
                    new Dog("Piroska", 1, "lány", new Owner("Jackie", "jj@jj", "44343"), Arrays.asList(Allergy.BŐR, Allergy.NÖVÉNY)),
                    new Dog("Lajos", 6, "fiú", Arrays.asList(Allergy.ÉLELMISZER, Allergy.NÖVÉNY)),
                    new Dog("Katika", 11, "lány", Arrays.asList(Allergy.GYÓGYSZER, Allergy.NÖVÉNY, Allergy.ÉLELMISZER))));



    @Override
    public List<Dog> getAll() {
        return dogs;
    }

    @Override
    public Dog getById(int id) {
        return dogs.stream()
                .filter(d -> d.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(Dog dog) {
    dogs.add(dog);
    }

    @Override
    public List<Dog> getByName(String name) {
        return dogs.stream()
                .filter(d -> d.getName().equals(name))
                .collect(Collectors.toList());
    }
}
