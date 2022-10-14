package groomery.groomerywithmaven.repositories;

import groomery.groomerywithmaven.models.Owner;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Repository
public class OwnerRepositoryImpl implements OwnerRepository {
    private DogRepository dogRepository;

    public OwnerRepositoryImpl(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public List<Owner> owners = new ArrayList<>
            (Arrays.asList(
                    new Owner("Géza", "bela@bela.com", "234566"),
                    new Owner("Eszter", "bela@bela.com", "234566"),
                    new Owner("Jani", "bela@bela.com", "234566"),
                    new Owner("Piroska", "bela@bela.com", "234566")));

    @Override
    public List<Owner> getAll() {
        return owners;
    }

    @Override
    public Owner getOwnerByDogId(int id) {
        return dogRepository.getAll().stream()
                .filter(dog -> dog.getId() == id)
                .findFirst()
                .get().getOwner();
    }

    @Override
    public void save(Owner owner) {
        owners.add(owner);
    }

    @Override
    public Owner getOwnerByName(String name) {
        return owners.stream()
                .filter(o -> o.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
