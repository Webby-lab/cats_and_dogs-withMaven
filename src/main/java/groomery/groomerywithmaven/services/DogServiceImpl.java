package groomery.groomerywithmaven.services;

import groomery.groomerywithmaven.models.Allergy;
import groomery.groomerywithmaven.models.Dog;
import groomery.groomerywithmaven.repositories.DogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DogServiceImpl implements DogService {

    DogRepository dogRepository;

    public DogServiceImpl(DogRepository dogrepository) {
        this.dogRepository = dogrepository;
    }
    @Override
    public List<Dog> getAll() {
        return dogRepository.getAll();
    }

    @Override
    public Dog getById(Integer id) {
        return dogRepository.getById(id);
    }

    @Override
    public List<Dog> getByName(String name) {
        return dogRepository.getByName(name);
    }

    @Override
    public void save(Dog dog) {
    dogRepository.save(dog);
    }
    @Override
    public List<Dog> sortedDogs(String sortedBy, Boolean isAsc) {
        List<Dog> dogs = dogRepository.getAll();
        if ("name".equals(sortedBy)) {
            return dogs.stream()
                    .sorted((d1, d2) -> isAsc ? d1.getName().compareTo(d2.getName()) : d2.getName().compareTo(d1.getName()))
                    .collect(Collectors.toList());
        } else if ("age".equals(sortedBy)) {
            return dogs.stream()
                    .sorted((d1, d2) -> d1.getAge() - d2.getAge())
                    .collect(Collectors.toList());
        } else {
            return dogs;
        }
    }

    @Override
    public List<Dog> filterByAllargies(List<Dog> dogs, Allergy allergy) {
        if (allergy == null) return dogs;
        return dogs.stream()
                .filter(d ->
                        d.getAllergies().contains(allergy))
                .collect(Collectors.toList());
    }



}
